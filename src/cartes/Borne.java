package cartes;

public class Borne extends Carte {
	
	private int km;
	
	public Borne(int km) {
		this.km = km;
	}
	
	public int getkm(){
		return km;
	}
	
	@Override
	public String toString() {
		return km + "KM";
	}	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || this.getClass() != obj.getClass()){
			return false;
		}
		Borne bor = (Borne) obj;
		return km == bor.km;
	}
	
	@Override
	public int hashCode() {
		return Integer.hashCode(km);
	}
}