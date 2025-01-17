package com.polonaise;

// Notation Polonaise Inversée

public class Main {

    /*
     * Description: Main method
     * 
     * @param args: The arguments
     */
    public static void main(String[] args) throws EstVideException {
        Pile<Integer> pile = new Pile<>();

        for (String arg : args) {
            try {
                pile.empiler(Integer.valueOf(arg));
            } catch (NumberFormatException e) {
                calcul(arg, pile);
            }
        }

        System.out.println("Result: " + pile.depiler());
    }

    /*
     * Description: Calculate the result of the operation
     * 
     * @param arg: The operation to perform
     * @param pile: The stack
     */
    public static void calcul(String arg, Pile<Integer> pile) throws EstVideException {
        int result = switch (arg) {
            case "+" -> {
                int a = pile.depiler();
                int b = pile.depiler();
                yield a + b;
            }
            case "-" -> {
                int a = pile.depiler();
                int b = pile.depiler();
                yield b - a;
            }
            case "x" -> {
                int a = pile.depiler();
                int b = pile.depiler();
                yield a * b;
            }
            case "/" -> {
                int a = pile.depiler();
                int b = pile.depiler();
                yield b / a;
            }
            default ->
                throw new IllegalArgumentException("Unexpected value: " + arg);
        };
        pile.empiler(result);
    }
}