package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class GestionCartes {

	private static Random random = new Random();

	// VERSION CLASSIQUE

	public static <E> E extraire(List<E> liste) {
		if (liste == null || liste.isEmpty()) {
			throw new IllegalArgumentException("La liste peut pas être vide");
		}
		int indice = random.nextInt(liste.size());
		return liste.remove(indice);
	}

	// VERSION ITÉRATEUR

	public static <E> E extraireIterator(List<E> liste) {

		if (liste == null || liste.isEmpty()) {
			throw new IllegalArgumentException("La liste peut pas être vide");
		}

		int indice = random.nextInt(liste.size());
		ListIterator<E> iter = liste.listIterator();

		for (int i = 0; i < indice; i++) {
			iter.next();
		}

		iter.previous();
		E elt = iter.next();
		return elt;
	}

	public static <E> List<E> melanger(List<E> liste) {
		List<E> listeHasard = new ArrayList<>();

		while (!liste.isEmpty()) {
			listeHasard.add(extraire(liste));
		}

		return listeHasard;

	}

	public static <E> boolean verifierMelange(List<E> liste1, List<E> liste2) {

		if (liste1.size() != liste2.size()) {
			return false;
		}

		List<E> copie = new ArrayList<>(liste1);

		for (E elt : copie) {
			if (Collections.frequency(liste1, elt) != Collections.frequency(liste2, elt)) {
				return false;
			}
		}

		return true;
	}

	public static <E> List<E> rassembler(List<E> liste) {

		List<E> listeFinit = new ArrayList<>();
		List<E> copie = new ArrayList<>(liste);

		while (!copie.isEmpty()) {
			E elt = copie.get(0);
			listeFinit.add(elt);
			copie.remove(0);

			ListIterator<E> iter = copie.listIterator();

			while (iter.hasNext()) {
				E courant = iter.next();

				if (elt.equals(courant)) {
					listeFinit.add(courant);
					iter.remove();
				}
			}
		}
		return listeFinit;
	}

	public static <E> boolean verifierRassemblement(List<E> liste) {

		if (liste == null || liste.size() <= 1) {
			return true;
		}

		ListIterator<E> iter1 = liste.listIterator();
		E eltPrec = null;

		while (iter1.hasNext()) {

			E eltCour = iter1.next();

			if (eltPrec != null && !eltCour.equals(eltPrec)) {

				ListIterator<E> iter2 = liste.listIterator(iter1.nextIndex());

				while (iter2.hasNext()) {

					E eltNext = iter2.next();

					if (eltPrec.equals(eltNext)) {
						return false;
					}
				}
			}
			eltPrec = eltCour;
		}
		return true;
	}

}
