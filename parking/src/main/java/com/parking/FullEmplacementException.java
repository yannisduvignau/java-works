package com.parking;

public class FullEmplacementException extends Exception {
    public FullEmplacementException() {
        super("L'emplacement est plein.");
    }

    public FullEmplacementException(String message) {
        super(message);
    }
    
}
