package testsFonctionnels;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import cartes.Carte;
import cartes.JeuDeCartes;
import utils.GestionCartes;

public class TestGestionCartes {

	@SafeVarargs
	public static <T> void testerRassemblement(T... elements) {
		List<T> liste = new ArrayList<>();
		Collections.addAll(liste, elements);
		System.out.println("Liste initiale : " + liste);
		List<T> listeRassemblee = GestionCartes.rassembler(liste);
		System.out.println("Liste rassemblée : " + listeRassemblee);
		System.out.println("liste rassemblée sans erreur ? "
				+ GestionCartes.verifierRassemblement(listeRassemblee));
	}

	public static void main(String[] args) {
		testerRassemblement();
		testerRassemblement(1, 1, 2, 1, 3);
		testerRassemblement(1, 4, 3, 2);
		testerRassemblement(1, 1, 2, 3, 1);

		JeuDeCartes jeu = new JeuDeCartes();
		List<Carte> listeCarteNonMelangee = new LinkedList<>();
		for (Carte carte : jeu.donnerCartes()) {
			listeCarteNonMelangee.add(carte);
		}
		List<Carte> listeCartes = new ArrayList<>(listeCarteNonMelangee);
		System.out.println(listeCartes);
		listeCartes = GestionCartes.melanger(listeCartes);
		System.out.println(listeCartes);
		System.out.println("liste mélangée sans erreur ? "
				+ GestionCartes.verifierMelange(listeCarteNonMelangee, listeCartes));
		listeCartes = GestionCartes.rassemblerV2(listeCartes);
		System.out.println(listeCartes);
		System.out.println("liste rassemblée sans erreur ? "
				+ GestionCartes.verifierRassemblement(listeCartes));
	}

}
