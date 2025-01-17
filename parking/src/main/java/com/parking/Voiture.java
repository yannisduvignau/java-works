package com.parking;

public class Voiture extends VehiculeRoulant {
    @Override
    public void avancer() {
        this.rouler();
    }
    
    public Voiture(String marque, String modele, String couleur, String immatriculation) {
        super(marque, modele, couleur, immatriculation);
    }

    @Override
    public void rouler() {
        System.out.println("La voiture " + getMarque() + " roule");
    }
    
    public String toString() {
        return "Voiture " + super.toString();
    }
    
}
