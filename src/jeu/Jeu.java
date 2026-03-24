package jeu;

import cartes.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Jeu {

	private Sabot sabot;

	public Jeu() {

		JeuDeCartes jeuDeCartes = new JeuDeCartes();
		Carte[] tabCartes = jeuDeCartes.donnerCartes();

		List<Carte> listeCartes = new ArrayList<>();
		Collections.addAll(listeCartes, tabCartes);

		Collections.shuffle(listeCartes);

		Carte[] cartesHasard = listeCartes.toArray(new Carte[0]);

		this.sabot = new Sabot(cartesHasard);
	}

	public Sabot getSabot() {
		return sabot;
	}
	
}
