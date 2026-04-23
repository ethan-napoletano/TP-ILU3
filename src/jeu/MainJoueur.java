package jeu;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import cartes.Carte;

public class MainJoueur implements Iterable<Carte>{
	private List <Carte> CartesDansMain;
	
	public MainJoueur() {
		this.CartesDansMain = new LinkedList<>();
	}
	
	public void prendre(Carte carte) {
		CartesDansMain.add(carte);
	}
	
	public void jouer(Carte carte) {
		assert CartesDansMain.contains(carte) : "il n'y a pas cette carte";
		CartesDansMain.remove(carte);
	}
	

	@Override
	public String toString() {
		return CartesDansMain.toString();
	}

	@Override
	public Iterator<Carte> iterator() {
		return CartesDansMain.iterator();
	}
	

}