package jeu;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;
import cartes.Carte;

public class Sabot implements Iterable<Carte> {
    private Carte[] cartes;
    private int nbCartes;
    private int modCount = 0; // Compteur pour détecter les modifications
    
    
    public Sabot(Carte[] cartes) {
        this.cartes = cartes;
        this.nbCartes = cartes.length;
    }

    
    public boolean estVide() {
        return this.nbCartes == 0;
    }


    public void ajouterCarte(Carte carte) {
        if (this.nbCartes >= this.cartes.length) {
            throw new IllegalStateException("Dépassement de capacité : le sabot est plein.");
        }
        this.cartes[this.nbCartes] = carte;
        this.nbCartes++;
        this.modCount++;
    }

    // Pioche en utilisant l'itérateur interne
    public Carte piocher() {
        Iterator<Carte> it = this.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Impossible de piocher, le sabot est vide.");
        }
        Carte cartePiochee = it.next();
        it.remove(); // Supprime la première carte
        return cartePiochee;
    }

    // Rendre la classe itérable en retournant notre itérateur personnalisé
    @Override
    public Iterator<Carte> iterator() {
        return new SabotIterator();
    }

    
    
    // Classe interne privée pour l'itérateur
    private class SabotIterator implements Iterator<Carte> {
        private int curseur = 0;
        private int expectedModCount = modCount;
        private boolean canRemove = false; // Flag pour valider l'appel à remove()

        @Override
        public boolean hasNext() {
            return this.curseur < nbCartes;
        }

        @Override
        public Carte next() {
            verifierModification();
            if (!this.hasNext()) {
                throw new NoSuchElementException("Pas d'élément supplémentaire.");
            }
            Carte carte = cartes[this.curseur];
            this.curseur++;
            this.canRemove = true;
            return carte;
        }

        @Override
        public void remove() {
            verifierModification();
            if (!this.canRemove) {
                throw new IllegalStateException("L'appel à next() doit précéder remove().");
            }

            // Indice de l'élément à supprimer (celui renvoyé par le dernier next())
            int indiceASupprimer = this.curseur - 1;

            // Décalage des cartes vers la gauche pour combler le vide
            for (int i = indiceASupprimer; i < nbCartes - 1; i++) {
                cartes[i] = cartes[i + 1];
            }
            cartes[nbCartes - 1] = null; // Nettoyage de la dernière case devenue obsolète

            nbCartes--;
            modCount++; // Le sabot a été structurellement modifié
            this.expectedModCount = modCount; // L'itérateur valide sa propre modification

            this.curseur--; // Le curseur recule d'un cran suite au décalage
            this.canRemove = false; // Réinitialisation du flag après suppression
        }

        // Vérification de la concurrence (ConcurrentModificationException)
        private void verifierModification() {
            if (modCount != this.expectedModCount) {
                throw new ConcurrentModificationException("Le sabot a subi une modification concurrente externe.");
            }
        }
    }
}

