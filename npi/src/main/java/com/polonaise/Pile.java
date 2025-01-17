package com.polonaise;

public class Pile<T> {
    private Node<T> tete;
    private int taille;

    private static class Node<T> {
        T info;
        Node<T> suivant;

        Node(T info, Node<T> suivant) {
            this.info = info;
            this.suivant = suivant;
        }
    }

    public Pile() {
        tete = null;
        taille = 0;
    }
    
    public void empiler(T item) {
        tete = new Node<>(item, tete);
        taille++;
    }

    public boolean estVide() {
        return tete == null;
    }

    public T depiler() throws EstVideException {
        if (estVide()) {
            throw new EstVideException();
        }
        T item = tete.info;
        tete = tete.suivant;
        taille--;
        return item;
    }

    public T valeur() throws EstVideException {
        if (estVide()) {
            throw new EstVideException();
        }
        return tete.info;
    }

    public int taille() {
        return taille;
    }

    public void vider() {
        tete = null;
        taille = 0;
    }
}
