package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class GestionCartes {

	private static Random random = new Random();

	// a. Version 1 : directement sur la liste
	public static <T> T extraire(List<T> liste) {
		int index = random.nextInt(liste.size());
		return liste.remove(index);
	}

	// a. Version 2 : en exploitant un ListIterator
	public static <T> T extraireIterateur(List<T> liste) {
		int index = random.nextInt(liste.size());
		ListIterator<T> iterateur = liste.listIterator(index);
		T element = iterateur.next();
		iterateur.remove();
		return element;
	}

	// b. Mélanger une liste
	public static <T> List<T> melanger(List<T> liste) {
		List<T> listeMelangee = new ArrayList<>();
		while (!liste.isEmpty()) {
			listeMelangee.add(extraire(liste));
		}
		return listeMelangee;
	}

	// c. Vérifier le mélange avec Collections.frequency
	public static <T> boolean verifierMelange(List<T> liste1, List<T> liste2) {
		if (liste1.size() != liste2.size()) {
			return false;
		}
		for (T element : liste1) {
			if (Collections.frequency(liste1, element) != Collections.frequency(liste2, element)) {
				return false;
			}
		}
		return true;
	}

	// d. Rassembler
	public static <T> List<T> rassembler(List<T> liste) {
		List<T> listeRassemblee = new ArrayList<>();
		for (T element : liste) {
			int dernierIndex = listeRassemblee.lastIndexOf(element);
			if (dernierIndex == -1) {
				listeRassemblee.add(element);
			} else {
				listeRassemblee.add(dernierIndex + 1, element);
			}
		}
		return listeRassemblee;
	}

	// Alias exigé par l'énoncé du TP
	public static <T> List<T> rassemblerV2(List<T> liste) {
		return rassembler(liste);
	} 

	// e. 
	public static <T> boolean verifierRassemblement(List<T> liste) {
		if (liste.isEmpty()) {
			return true;
		}
		ListIterator<T> iter1 = liste.listIterator();
		T precedent = iter1.next();

		while (iter1.hasNext()) {
			T courant = iter1.next();
			if (!courant.equals(precedent)) {
				for (ListIterator<T> iter2 = liste.listIterator(iter1.nextIndex()); iter2.hasNext();) {
					if (iter2.next().equals(precedent)) {
						return false;
					}
				}
				precedent = courant;
			}
		}
		return true;
	}

} 
