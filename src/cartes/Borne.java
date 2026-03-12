package cartes;

public class Borne extends Carte {
	
	private int Km;
	
	public Borne(int Km) {
		this.Km = Km;
	}
	
	public int getKm() {
		return Km;
	}
	
	@Override
	public String toString() {
		return Km + " km";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		Borne bor = (Borne) obj;
		return Km == bor.Km;
	}

}
