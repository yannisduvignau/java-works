package com.parking;

public class Parking extends Emplacement {

    public Parking(final int capacite) {
        super(capacite);
    }

    public boolean entrer(VehiculeRoulant vehicule) throws FullEmplacementException {
        if (vehicule == null) {
            System.out.println("Erreur : Le véhicule est null.");
            return false;
        }
        vehicule.rouler();
        return this.garer(vehicule);
    }

    public boolean garer(VehiculeRoulant vehicule) throws FullEmplacementException {
        for (int i = 0; i < vehicules.length; i++) {
            if (vehicules[i] == null) {
                vehicules[i] = vehicule;
                return true;
            }
        }
        throw new FullEmplacementException();
    }

    public boolean sortir(VehiculeRoulant vehicule) throws FullEmplacementException {
        for (int i = 0; i < vehicules.length; i++) {
            if (vehicules[i] == vehicule) {
                vehicules[i] = null;
                return true;
            }
        }
        throw new FullEmplacementException();
    }

    @Override
    public String toString() {
        StringBuilder vehiculeStr = new StringBuilder("[");
        for (int i = 0; i < vehicules.length; i++) {
            if (vehicules[i] != null) {
                vehiculeStr.append(vehicules[i].toString());
                if (i < vehicules.length - 1) {
                    vehiculeStr.append(", ");
                }
            }
        }
        vehiculeStr.append("]");
        return "Parking [capacite=" + capacite + ", vehicule=" + vehiculeStr + "]";
    }
}
