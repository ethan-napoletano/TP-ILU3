package cartes;

public class JeuDeCartes {
	private Configuration[] configurations = new Configuration[] {

			new Configuration(new Borne(25), 10), new Configuration(new Borne(50), 10),
			new Configuration(new Borne(75), 10), new Configuration(new Borne(100), 12),
			new Configuration(new Borne(200), 4),

			new Configuration(new Parade(Type.FEU), 14), 
			new Configuration(new Parade(Type.ESSENCE), 6),
			new Configuration(new Parade(Type.CREVAISON), 6), 
			new Configuration(new Parade(Type.ACCIDENT), 6),
			new Configuration(new FinLimite(), 6),

			new Configuration(new Attaque(Type.FEU), 5), 
			new Configuration(new Attaque(Type.ESSENCE), 3),
			new Configuration(new Attaque(Type.CREVAISON), 3), 
			new Configuration(new Attaque(Type.ACCIDENT), 3),
			new Configuration(new DebutLimite(), 4),

			new Configuration(new Botte(Type.FEU), 1), 
			new Configuration(new Botte(Type.ESSENCE), 1),
			new Configuration(new Botte(Type.CREVAISON), 1), 
			new Configuration(new Botte(Type.ACCIDENT), 1) };
	
	
	private static class Configuration {
		private Carte carte;
		private int nombreExemplaires;
		

		Configuration(Carte carte, int nombreExemplaires) {
			this.carte = carte;
			this.nombreExemplaires = nombreExemplaires;
		}

		Carte getCarte() {
			return carte;
		}

		int getNbExemplaires() {
			return nombreExemplaires;
		}
	}
	
	public boolean checkCount() {
		for (Configuration config : configurations) {

			Carte[] tabCarte = donnerCartes();
			int cpt = 0;
			Carte recherche = config.getCarte();

			for (Carte car : tabCarte) {
				if (car != null && car.equals(recherche)) {
					cpt++;
				}
			}

			if (cpt != config.getNbExemplaires()) {
				System.out.println("Il n'y a pas le nombre de cartes attendus");
				return false;
			}
		}
		return true;
	}


	
	public String afficherJeuDeCartes() {

	    StringBuilder affichage = new StringBuilder("JeuDeCartes :\n");

	    for (Configuration config : configurations) {
	        affichage.append(config.getNbExemplaires())
	                 .append(" ")
	                 .append(config.getCarte())
	                 .append("\n");
	    }

	    return affichage.toString();
	}
	
	
	public Carte[] donnerCartes() {

		int nombreTotalCartes = 0;

		for (Configuration config : configurations) {
			nombreTotalCartes += config.getNombreExemplaires();
		}

		Carte[] cartes = new Carte[nombreTotalCartes];
		int index = 0;

		for (int i = 0; i < 10; i++)
			cartes[index++] = new Borne(25);
		for (int i = 0; i < 10; i++)
			cartes[index++] = new Borne(50);
		for (int i = 0; i < 10; i++)
			cartes[index++] = new Borne(75);
		for (int i = 0; i < 12; i++)
			cartes[index++] = new Borne(100);
		for (int i = 0; i < 4; i++)
			cartes[index++] = new Borne(200);

		for (int i = 0; i < 14; i++)
			cartes[index++] = new Parade(Type.FEU);
		for (int i = 0; i < 6; i++)
			cartes[index++] = new FinLimite();
		for (int i = 0; i < 6; i++)
			cartes[index++] = new Parade(Type.ESSENCE);
		for (int i = 0; i < 6; i++)
			cartes[index++] = new Parade(Type.CREVAISON);
		for (int i = 0; i < 6; i++)
			cartes[index++] = new Parade(Type.ACCIDENT);

		for (int i = 0; i < 5; i++)
			cartes[index++] = new Attaque(Type.FEU);
		for (int i = 0; i < 4; i++)
			cartes[index++] = new DebutLimite();
		for (int i = 0; i < 3; i++)
			cartes[index++] = new Attaque(Type.ESSENCE);
		for (int i = 0; i < 3; i++)
			cartes[index++] = new Attaque(Type.CREVAISON);
		for (int i = 0; i < 3; i++)
			cartes[index++] = new Attaque(Type.ACCIDENT);

		cartes[index++] = new Botte(Type.FEU);
		cartes[index++] = new Botte(Type.ESSENCE);
		cartes[index++] = new Botte(Type.CREVAISON);
		cartes[index++] = new Botte(Type.ACCIDENT);

		return cartes;
	}

}
