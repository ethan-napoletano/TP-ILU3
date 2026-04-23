package jeu;

import cartes.Attaque;
import cartes.Carte;
import cartes.DebutLimite;
import java.util.Objects;

public class Coup {
    private Joueur joueurCourant;
    private Carte carteJouee;
    private Joueur joueurCible; 
    
    public Coup(Joueur joueurCourant, Carte carteJouee, Joueur joueurCible) {
        this.joueurCourant = joueurCourant;
        this.carteJouee = carteJouee;
        this.joueurCible = joueurCible;
    }

    public Joueur getJoueurCourant() { 
    	return joueurCourant; 
    }
    
    public Carte getCarteJouee() { 
    	return carteJouee; 
    }
    
    public Joueur getCible() { 
    	return joueurCible; 
    }

    public boolean estValide() {
        if (joueurCible == null) { 
        	return true; 
        }

        if (!joueurCible.estDepotAutorise(carteJouee)) {
        	return false;
        }

        boolean cibleEstMoi = joueurCourant.equals(joueurCible);
        boolean estAttaqueOuLimite = (carteJouee instanceof Attaque) || (carteJouee instanceof DebutLimite);

        if (estAttaqueOuLimite) {
            return !cibleEstMoi; 
            
        } else {
            return cibleEstMoi;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
        	return true;
        }
        if (!(obj instanceof Coup)) {
        	return false;
        }
        Coup other = (Coup) obj;
        return joueurCourant.equals(other.joueurCourant) &&
               carteJouee.equals(other.carteJouee) &&
               Objects.equals(joueurCible, other.joueurCible);
    }

    @Override
    public int hashCode() {
        return Objects.hash(joueurCourant, carteJouee, joueurCible);
    }

    @Override
    public String toString() {
        if (joueurCible == null) {
            return joueurCourant.getNom() + " defausse la carte " + carteJouee;
        } else {
            String cibleStr = joueurCourant.equals(joueurCible) ? "sa zone de jeu" : "la zone de jeu de " + joueurCible.getNom();
            return joueurCourant.getNom() + " depose la carte " + carteJouee + " dans " + cibleStr;
        }
    }
}