package com.parking;

public abstract class VehiculeRoulant extends Vehicule implements Roulant {
    protected String marque;
    protected String modele;
    protected String couleur;
    protected String immatriculation;

    public VehiculeRoulant(String marque, String modele, String couleur, String immatriculation) {
        this.marque = marque;
        this.modele = modele;
        this.couleur = couleur;
        this.immatriculation = immatriculation;
    }

    protected String getMarque() {return marque;}
    protected String getModele() {return modele;}
    protected String getCouleur() {return couleur;}
    protected String getImmatriculation() {return immatriculation;}

    public abstract void rouler();

    public String toString() {
        return "[marque=" + this.getMarque() + ", modele=" + this.getModele() + ", couleur=" + this.getCouleur() + ", immatriculation=" + this.getImmatriculation() + "]";
    }
}
