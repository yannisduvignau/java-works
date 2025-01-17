package com.parking;

public class Main {

    public static void main(String[] args) {

        /// ---------------------------------------- ///
        ///             Création des objets          ///
        /// ---------------------------------------- ///
        
        System.out.println("\n/// ---------------------------------------- ///\n" + "///             Création des objets          ///\n" + "/// ---------------------------------------- ///\n");

        Parking parking = new Parking(3);
        Port port = new Port(3);
        Voiture voiture = new Voiture("Renault", "Clio", "Rouge", "AB-123-CD");
        Voiture voiture2 = new Voiture("Peugeot", "208", "Blanc", "EF-456-GH");
        Voiture voiture3 = new Voiture("Citroën", "C3", "Bleu", "IJ-789-KL");
        Voiture voiture4 = new Voiture("Volkswagen", "Golf", "Gris", "MN-012-OP");
        Moto moto = new Moto("Yamaha", "MT-07", "Noir", "EF-456-GH");
        Bateau bateau = new Bateau("Yamaha", "MT-07", "Noir", "EF-456-GH");

        System.out.println("Véhicule roulant n°1 : " + voiture);
        System.out.println("Véhicule roulant n°2 : " + voiture2);
        System.out.println("Véhicule roulant n°3 : " + voiture3);
        System.out.println("Véhicule roulant n°4 : " + voiture4);
        System.out.println("Véhicule roulant n°5 : " + moto);
        System.out.println("Véhicule flottant n°1 : " + bateau);
        System.out.println("Parking : " + parking);
        System.out.println("Port : " + port);

        /// ---------------------------------------- ///
        ///          Remplissage du parking          ///
        /// ---------------------------------------- ///
        
        System.out.println("\n/// ---------------------------------------- ///\n" + "///          Remplissage du parking          ///\n" + "/// ---------------------------------------- ///\n");

        try {
            parking.entrer(voiture);
            parking.entrer(voiture2);
            parking.entrer(voiture3);
            parking.entrer(voiture4);
            parking.entrer(moto);
        } catch (FullEmplacementException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        System.out.println("\nParking : " + parking + "\n");

        /// ---------------------------------------- ///
        ///          Remplissage du port             ///
        /// ---------------------------------------- ///
        
        System.out.println("\n/// ---------------------------------------- ///\n" + "///          Remplissage du port             ///\n" + "/// ---------------------------------------- ///\n");

        try {
            port.entrer(bateau);
        } catch (FullEmplacementException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        System.out.println("\nPort : " + port + "\n");
    }
}
