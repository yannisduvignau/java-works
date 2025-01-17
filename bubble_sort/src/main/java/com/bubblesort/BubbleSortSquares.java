package com.bubblesort;

public class BubbleSortSquares {
    private final int[] numbers;
    private final int delay = 500;
    private int counter = 0;

    public BubbleSortSquares(int[] numbers) {
        this.numbers = numbers;
    }

    public void swap(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public void bubbleSort(){
        int n = numbers.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    swap(j, j+1);
                }
                this.counter++;
            }
        }
    }

    public static void main(String[] args){
        int[] data = {5, 1, 8, 3, 6, 2, 7, 4, 6, 8,9,10,0,1,44,555,8,96,1};
        BubbleSortSquares visualizer = new BubbleSortSquares(data);

        visualizer.bubbleSort();

        for (int number : visualizer.numbers) {
            System.out.print(number + " ");
        }
        System.out.println("\n" + visualizer.counter);
    }
}
