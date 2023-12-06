// Pour la Partie 2 -> Base de Données

package com.cartes.demo;
import java.sql.*;

public class Database {
    public void main(String[] args) {
        Connection connection = null;
        try {
            // Driver pour se connecter à la Base de données (BDD)
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306?useSSL=false", "root", "admin");

            Statement stmt = connection.createStatement();

            System.out.println("Création de la base de données...");

            // Création de la BDD si elle n'existe pas
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS CARD_GAME");
            System.out.println("Base de données créée avec succès.");

            System.out.println("Utilisation de la base de données CARD_GAME...");
            stmt.executeUpdate("USE CARD_GAME");

            System.out.println("Création de la table Cartes...");

            // Création de la Table "Cartes" si elle n'existe pas, dans laquelle le programme transférera les cartes
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Cartes (id INT AUTO_INCREMENT PRIMARY KEY, valeur_carte VARCHAR(50), couleur_carte VARCHAR(50))");
            System.out.println("Table Cartes créée avec succès.");

            // Nettoyer le contenu de la table Cartes avant d'insérer de nouvelles données
            System.out.println("Nettoyage du contenu de la table Cartes...");
            stmt.executeUpdate("TRUNCATE TABLE Cartes");
            System.out.println("Contenu de la table Cartes nettoyé.");

            System.out.println("Insertion des cartes dans la table Cartes...");

            String[] valeurs = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Valet", "Reine", "Roi", "As"};
            String[] couleurs = {"Carreau", "Coeur", "Pique", "Trèfle"};

            PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO Cartes (valeur_carte, couleur_carte) VALUES (?, ?)");

            // Insertion des 52 cartes dans la Table "Cartes" par valeur et couleur
            for (String couleur : couleurs) {
                for (String valeur : valeurs) {
                    insertStatement.setString(1, valeur);
                    insertStatement.setString(2, couleur);
                    insertStatement.executeUpdate();
                }

                // Ajout d'une ligne vide entre chaque groupe de cartes
                System.out.println();
            }

            System.out.println("Les cartes ont été insérées dans la table Cartes.");

            System.out.println("Affichage du contenu de la table Cartes :");

            //Affiche dans la console le contenu de la table "Cartes" pour vérifier que l'insertion des 52 cartes à été effectué correctement
            ResultSet rs = stmt.executeQuery("SELECT * FROM Cartes");
            String currentColor = "";
            while (rs.next()) {
                int id = rs.getInt("id");
                String valeur = rs.getString("valeur_carte");
                String couleur = rs.getString("couleur_carte");

                if (!couleur.equals(currentColor)) {

                    // Ajout d'une ligne vide entre chaque groupe de cartes
                    System.out.println();
                    currentColor = couleur;
                }

                System.out.println("ID : " + id + ", Valeur : " + valeur + ", Couleur : " + couleur);
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}