package com.thread;

public class Main {
    public static void main(String[] args) {
        // Crée deux objets Runnable
        Runnable task1 = new Task("Task 1");
        Runnable task2 = new Task("Task 2");
        
        // Crée deux threads avec ces tâches
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        
        // Démarre les threads
        thread1.start();
        thread2.start();
        
        // Affiche un message pour montrer que le thread principal continue
        System.out.println("Main thread is running...");
    }
}