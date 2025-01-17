package com.parking;

public class Port extends Emplacement {

    public Port(int capacite) {
        super(capacite); // Call the constructor of the superclass Emplacement
    }

    public boolean entrer(VehiculeFlottant vehicule) throws FullEmplacementException {
        if (vehicule == null) {
            System.out.println("Erreur : Le véhicule est null.");
            return false;
        }
        vehicule.flotter();
        return this.garer(vehicule);
    }

    public boolean garer(VehiculeFlottant vehicule) throws FullEmplacementException {
        for (int i = 0; i < vehicules.length; i++) {
            if (vehicules[i] == null) {
                vehicules[i] = vehicule;
                return true;
            }
        }
        throw new FullEmplacementException();
    }

    public boolean sortir(VehiculeFlottant vehicule) throws FullEmplacementException {
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
        return "Port " + super.toString();
    }
}
