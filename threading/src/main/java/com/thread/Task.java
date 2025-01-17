package com.thread;

public class Task implements Runnable {
    private String taskName;

    // Constructeur pour définir le nom de la tâche
    public Task(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(taskName + " is running step " + i);
            try {
                // Simule un temps d'attente
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(taskName + " was interrupted.");
            }
        }
        System.out.println(taskName + " has finished.");
    }
}

