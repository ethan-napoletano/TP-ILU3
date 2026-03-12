package cartes;

public enum Type {
	FEU("Feu rouge", "Feu vert","Prioritaire"),
	ESSENCE("Panne d'essence", "Essence", "Camion citerne"),
	CREVAISON("Crevaison", "Roue de secours", "Increvable"),
	ACCIDENT("Accident", "Réparation", "As du volant");

	private String nomAttaque;
	private String nomParade;
	private String nomBotte;

	private Type(String attaque, String Parade, String Botte) {
		this.nomAttaque = attaque;
		this.nomParade = Parade;
		this.nomBotte = Botte;
	}
	
	
	
	public String getNomAttaque() {
		return nomAttaque;
	}
	
	public String getnomParade() {
		return nomParade;
	}
	
	public String getnomBotte() {
		return nomBotte;
	}

}
