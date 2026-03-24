package testsFonctionnels;

import cartes.*;

public class TestJeuDeCartes {

	public static void main(String[] args) {
		JeuDeCartes jeuDeCartes = new JeuDeCartes();

		jeuDeCartes.affichageJeuDeCartes();

		System.out.println();
		Carte[] cartes = jeuDeCartes.donnerCartes();
		System.out.println("Nombre total de cartes : " + cartes.length);

		System.out.println();
		System.out.println("Verification du nombre de carte : " + jeuDeCartes.checkCount());
	}
}