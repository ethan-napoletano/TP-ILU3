package cartes;

public class JeuDeCartes {
	private Configuration[] configurations = new Configuration[] {

			new Configuration(new Borne(25), 10), new Configuration(new Borne(50), 10),
			new Configuration(new Borne(75), 10), new Configuration(new Borne(100), 12),
			new Configuration(new Borne(200), 4),

			new Configuration(new Parade(Type.FEU), 14), new Configuration(new Parade(Type.ESSENCE), 6),
			new Configuration(new Parade(Type.CREVAISON), 6), new Configuration(new Parade(Type.ACCIDENT), 6),
			new Configuration(new FinLimite(), 6),

			new Configuration(new Attaque(Type.FEU), 5), new Configuration(new Attaque(Type.ESSENCE), 3),
			new Configuration(new Attaque(Type.CREVAISON), 3), new Configuration(new Attaque(Type.ACCIDENT), 3),
			new Configuration(new DebutLimite(), 4),

			new Configuration(new Botte(Type.FEU), 1), new Configuration(new Botte(Type.ESSENCE), 1),
			new Configuration(new Botte(Type.CREVAISON), 1), new Configuration(new Botte(Type.ACCIDENT), 1) };

	

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
			affichage.append(config.getNbExemplaires());
			affichage.append(" ");
			affichage.append(config.getCarte());
			affichage.append("\n");
		}

		return affichage.toString();
	}

	public Carte[] donnerCartes() {
		int TotalCarte= 0;
		
		for(Configuration config : configurations) {
			TotalCarte += config.getNbExemplaires() ; 		
		}
		
		Carte[] TouteLesCartes = new Carte[TotalCarte];
		
		int index = 0;
		
		for(Configuration config : configurations) {
			for(int i=0; i < config.getNbExemplaires();i++) {
				TouteLesCartes[index] = config.getCarte();
				index++;
			}		
		}
		return TouteLesCartes;
		
	}
	
	private static class Configuration {
		private Carte carte;
		private int nombreExemplaires;

		public Configuration(Carte carte, int nombreExemplaires) {
			this.carte = carte;
			this.nombreExemplaires = nombreExemplaires;
		}

		public Carte getCarte() {
			return carte;
		}

		public int getNbExemplaires() {
			return nombreExemplaires;
		}
	}

}
