package com.parking;

public abstract class Emplacement {
    protected final int capacite;
    protected Vehicule[] vehicules;
    
    public Emplacement(int capacite) {
        this.capacite = capacite;
        this.vehicules = new Vehicule[capacite];
    }

    // public abstract boolean entrer(Vehicule vehicule);
    // public abstract boolean garer(Vehicule vehicule);
    // public abstract boolean sortir(Vehicule vehicule);
    
    public int getCapacite() {
        return capacite;
    }
    
    public Vehicule[] getVehicules() {
        return vehicules;
    }
    
    public void setVehicules(Vehicule[] vehicules) {
        if (vehicules.length == this.capacite) {
            this.vehicules = vehicules;
        } else {
            System.out.println("Erreur : la taille du tableau ne correspond pas à la capacité.");
        }
    }
    
    @Override
    public String toString() {
        StringBuilder vehiculesStr = new StringBuilder("[");
        for (int i = 0; i < vehicules.length; i++) {
            if (vehicules[i] != null) {
                vehiculesStr.append(vehicules[i].toString());
                if (i < vehicules.length - 1) {
                    vehiculesStr.append(", ");
                }
            }
        }
        vehiculesStr.append("]");
        return "[capacite=" + capacite + ", vehicules=" + vehiculesStr + "]";
    }
}
