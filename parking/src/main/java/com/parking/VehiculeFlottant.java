package com.parking;

public abstract class VehiculeFlottant extends Vehicule implements Flottant {
    protected String marque;
    protected String modele;
    protected String couleur;
    protected String immatriculation;

    public VehiculeFlottant(String marque, String modele, String couleur, String immatriculation) {
        this.marque = marque;
        this.modele = modele;
        this.couleur = couleur;
        this.immatriculation = immatriculation;
    }

    protected String getMarque() {return marque;}
    protected String getModele() {return modele;}
    protected String getCouleur() {return couleur;}
    protected String getImmatriculation() {return immatriculation;}

    @Override
    public abstract void flotter();

    public String toString() {
        return "[marque=" + this.getMarque() + ", modele=" + this.getModele() + ", couleur=" + this.getCouleur() + ", immatriculation=" + this.getImmatriculation() + "]";
    }
}
