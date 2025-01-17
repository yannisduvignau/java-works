package com.parking;

public class Bateau extends VehiculeFlottant {
    @Override
    public void avancer() {
        this.flotter();
    }
    
    public Bateau(String marque, String modele, String couleur, String immatriculation) {
        super(marque, modele, couleur, immatriculation);
    }

    public void flotter() {
        System.out.println("Le bateau " + getMarque() + " avance");
    }
    
    @Override
    public String toString() {
        return "Bateau " + super.toString();
    }
    
}
