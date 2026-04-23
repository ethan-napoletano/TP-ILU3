package jeu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;


public class Jeu {
	private Sabot sabot;
	private List<Joueur> joueurs = new ArrayList<>();
	private Iterator<Joueur> iterateurJoueurs;

	public Jeu(Sabot sabot) {
	    this.sabot = sabot;

	}
	
	
	public void inscrire(Joueur... nouveauxJoueurs) {
		joueurs.addAll(Arrays.asList(nouveauxJoueurs));
	}
	
	public void distribuerCartes() {
		for (int i = 0; i < 6; i++) {
			for (Joueur j : joueurs) {
				j.donner(sabot.piocher());
			}
		}
	}
	
	public Joueur donnerJoueurSuivant() {
		if (iterateurJoueurs == null || !iterateurJoueurs.hasNext()) {
			iterateurJoueurs = joueurs.iterator();
		}
		return iterateurJoueurs.next();
	}
	
	public String jouerTour(Joueur joueur) {
		joueur.prendreCarte(sabot);
		Coup coup = joueur.choisirCoup(new HashSet<>(joueurs));
		joueur.retirerDeLaMain(coup.getCarteJouee());
		
		if (coup.getCible() == null) {
			sabot.ajouterCarte(coup.getCarteJouee());
		} else {
			coup.getCible().deposer(coup.getCarteJouee());
		}
		
		return coup.toString();
	}
	public String lancer() {
	    StringBuilder resultat = new StringBuilder();

	    while (!sabot.estVide()) {
	        Joueur joueur = donnerJoueurSuivant();
	        
	        String tour = jouerTour(joueur);
	        resultat.append(tour).append("\n");

	        if (joueur.donnerKmParcourus() >= 1000) {
	            resultat.append(joueur.getNom())
	                    .append(" a gagné avec ")
	                    .append(joueur.donnerKmParcourus())
	                    .append(" km !");
	            return resultat.toString();
	        }
	    }

	    resultat.append("Le sabot est vide. Fin de la partie.");
	    return resultat.toString();
	}


}