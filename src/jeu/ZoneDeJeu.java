package jeu;

import java.util.ArrayList;
import java.util.List;
import cartes.Bataille;
import cartes.Borne;
import cartes.FinLimite;
import cartes.Limite;
import cartes.Carte;

public class ZoneDeJeu {
	private List<Limite>limites = new ArrayList<>();
	private List<Bataille>batailles = new ArrayList<>();
	private List<Borne>bornes = new ArrayList<>();
	
	
	
	public int donnerLimitationVitesse() {
	    if (limites.isEmpty()) {
	        return 200;
	    }

	    Carte sommet = limites.get(limites.size() - 1);

	    if (sommet instanceof FinLimite) {
	        return 200;
	    }

	    return 50;
	}
	
	public int donnerKmParcourus() {
	    int total = 0;

	    for (Borne b : bornes) {
	        total += b.getkm();
	    }

	    return total;
	}
	
	
}
