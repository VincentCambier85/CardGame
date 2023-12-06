// Programme Principal exécutant la Partie 1 Et la Partie 2 de l’évaluation avec en sortie l'affichage des 52 cartes dans le terminal puis du contenu de la base de données

package com.cartes.demo;

public class Main {
    public static void main(String[] args) {

        // Appel à la classe "Cartes" pour afficher les 52 cartes
        Cartes cartes = new Cartes();
        cartes.afficherCartes();

        // Exécution de la classe "Database" pour insérer les 52 cartes dans une base de données MySQL
        Database createDB = new Database();        
        createDB.main(args);
    }
}