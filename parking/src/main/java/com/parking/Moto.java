package com.parking;

public class Moto extends VehiculeRoulant {
    @Override
    public void avancer() {
        this.rouler();
    }
    
    public Moto(String marque, String modele, String couleur, String immatriculation) {
        super(marque, modele, couleur, immatriculation);
    }

    @Override
    public void rouler() {
        System.out.println("La moto " + getMarque() + " roule");
    }
    
    public String toString() {
        return "Moto " + super.toString();
    }
    
}
