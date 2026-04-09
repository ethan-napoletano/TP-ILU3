package jeu;

import cartes.Carte;

public class Joueur {
	private String nom;
	private ZoneDeJeu zone;
	private MainJoueur main;
	
	public Joueur(String nom) {
		this.nom = nom;
		this.zone = new ZoneDeJeu();
		this.main = new MainJoueur();
	}

	public String getNom() {
		return nom;
	}
	
	public MainJoueur getMain() {
		return main;
	}
	
	public void donner(Carte carte) {
		main.prendre(carte);
	}
	
	@Override
	public boolean equals(Object objet) {
		if(objet instanceof Joueur joueur) {
			return nom.equals(joueur.getNom());
		}
		return false;
	}
	

	@Override
	public String toString() {
		return nom;
	}
	

	public Carte prendreCarte(Sabot sabot) {
		if(sabot.estVide()) {
			return null;
		}
		

		Carte carte = sabot.piocher();
		

		this.donner(carte);
		
		return carte;		
	}
	
	public int donnerKmParcourus() {
	    return zone.donnerKmParcourus();
	}

	public int donnerLimitationVitesse() {
	    return zone.donnerLimitationVitesse();
	}

	public void deposer(Carte carte) {
	    zone.deposer(carte);
	}
	
	public boolean peutAvancer() {
	    return zone.peutAvancer();
	}


	public boolean estDepotAutorise(Carte carte) {
	    return zone.estDepotAutorise(carte);
	}

}