package testsFonctionnels;

import java.util.Iterator;
import java.util.ConcurrentModificationException;
import cartes.Borne; // Exemple pour instancier des cartes de test
import cartes.Carte;
import jeu.Sabot;

public class TestSabot {
    public static void main(String[] args) {
        // Préparation d'un tableau de cartes pour le test
        Carte[] cartesInitiales = new Carte[4];
        cartesInitiales[0] = new Borne(25);
        cartesInitiales[1] = new Borne(25);
        cartesInitiales[2] = new Borne(50);
        cartesInitiales[3] = new Borne(75);

   
        System.out.println("=== Test avec piocher ===");
        Sabot sabot1 = new Sabot(cartesInitiales.clone());
        while (!sabot1.estVide()) {
            Carte c = sabot1.piocher();
            System.out.println("je pioche " + c);
        }

       
        System.out.println("\n=== Test avec iterateur et remove ===");
        Sabot sabot2 = new Sabot(cartesInitiales.clone());
        Iterator<Carte> it2 = sabot2.iterator();
        while (it2.hasNext()) {
            Carte c = it2.next();
            System.out.println("je pioche " + c);
            it2.remove();
        }

       
        System.out.println("\n=== Test exception : modification pendant parcours ===");
        Sabot sabot3 = new Sabot(cartesInitiales.clone());
        Iterator<Carte> it3 = sabot3.iterator();
        try {
            if (it3.hasNext()) {
                it3.next();
                sabot3.piocher(); // Déclenche ConcurrentModificationException
                it3.next(); 
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("Exception reçue avec succès : " + e.getMessage());
        }

        
        Sabot sabot4 = new Sabot(new Carte[5]); // Capacité de 5
        sabot4.ajouterCarte(new Borne(25));
        sabot4.ajouterCarte(new Borne(50));
        
        Iterator<Carte> it4 = sabot4.iterator();
        try {
            if (it4.hasNext()) {
                it4.next();
                sabot4.ajouterCarte(new Borne(100)); // Déclenche ConcurrentModificationException
                it4.next();
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("Exception d'ajout reçue avec succès : " + e.getMessage());
        }
    }
}

