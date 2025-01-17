package com.element_search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nComparaison de performances :\n");

        // Création et Peuplement de la liste
        int taille_list = 1_000_000;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < taille_list; i++) {
            list.add(i);
        }

        // Mélanger la liste
        Collections.shuffle(list);  // Mélange de la liste

        // Élément à rechercher
        int element = 500_000;
        int nb_threads = Runtime.getRuntime().availableProcessors(); // Utilisation du nombre de cœurs
        System.out.println("Nombre de cœurs : " + nb_threads + "\n");

        if (element >= taille_list) {
            System.out.println("L'élément " + element + " est hors de portée de la liste.");
            return;
        }

        // Mesure du temps pour la recherche sans threads
        long startWithoutThreads = System.nanoTime();
        int indexWithoutThreads = searchElementWithoutThreads(list, element);
        long endWithoutThreads = System.nanoTime();
        long durationWithoutThreads = endWithoutThreads - startWithoutThreads;

        System.out.println("Recherche sans threads : " + (indexWithoutThreads != -1 ? 
            "Élément " + element + " trouvé à l'index " + indexWithoutThreads : "Élément " + element + " non trouvé."));
        System.out.println("Durée sans threads : " + durationWithoutThreads / 1_000_000.0 + " ms\n");

        // Mesure du temps pour la recherche avec threads
        long startWithThreads = System.nanoTime();
        int indexWithThreads = searchElementWithThreads(list, element, nb_threads);
        long endWithThreads = System.nanoTime();
        long durationWithThreads = endWithThreads - startWithThreads;

        System.out.println("Recherche avec threads : " + (indexWithThreads != -1 ? 
            "Élément " + element + " trouvé à l'index " + indexWithThreads : "Élément " + element + " non trouvé."));
        System.out.println("Durée avec threads : " + durationWithThreads / 1_000_000.0 + " ms\n");
    }

    public static int searchElementWithoutThreads(List<Integer> list, int element) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == element) {
                return i;
            }
        }
        return -1;
    }

    public static int searchElementWithThreads(List<Integer> list, int element, int nb_threads) {
        int taille_par_thread = list.size() / nb_threads;
        AtomicInteger resultIndex = new AtomicInteger(-1);

        Thread[] threads = new Thread[nb_threads];

        for (int i = 0; i < nb_threads; i++) {
            int debut = i * taille_par_thread;
            int fin = (i == nb_threads - 1) ? list.size() : (i + 1) * taille_par_thread;

            threads[i] = new Thread(new SearchElement(list, element, debut, fin, resultIndex));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.err.println("Thread interrupted: " + e.getMessage());
            }
        }

        return resultIndex.get();
    }

    public static class SearchElement implements Runnable {
        private final List<Integer> list;
        private final int element;
        private final int debut;
        private final int fin;
        private final AtomicInteger resultIndex;

        public SearchElement(List<Integer> list, int element, int debut, int fin, AtomicInteger resultIndex) {
            this.list = list;
            this.element = element;
            this.debut = debut;
            this.fin = fin;
            this.resultIndex = resultIndex;
        }

        @Override
        public void run() {
            for (int i = debut; i < fin && resultIndex.get() == -1; i++) {
                if (list.get(i) == element) {
                    resultIndex.set(i);
                    break;
                }
            }
        }
    }
}
