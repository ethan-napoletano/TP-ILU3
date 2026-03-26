package jeu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import cartes.Carte;

public class MainJoueur {
	private List<Carte>main = new ArrayList<>();
	
	public MainJoueur() {
        this.main = new ArrayList<>();
    }
	
	public void prendre(Carte carte) {
        main.add(carte);
    }
	
	
	public void jouer(Carte carte) {
        assert main.contains(carte) : "Carte non présente dans la main";
        main.remove(carte);
    }
	
	@Override
    public String toString() {
        return main.toString();
    }

	public Iterator<Carte> iterator() {
        return main.iterator();
    }
    

}
