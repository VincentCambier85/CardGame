// Pour la Partie 1 -> affichage des 52 cartes par valeur et par couleur dans la console

package com.cartes.demo;

public class Cartes {
    private String[] valeurs = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Valet", "Reine", "Roi", "As"};
    private String[] couleurs = {"Carreau", "Coeur", "Pique", "Trèfle"};

    public void afficherCartes() {
        for (String couleur : couleurs) {
            for (String valeur : valeurs) {
                System.out.println(valeur + " de " + couleur);
            }
            
            // Ajout d'une ligne vide entre chaque série de cartes d'une même couleur
            System.out.println();
        }
    }
}