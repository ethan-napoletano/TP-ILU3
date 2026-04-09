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
		return super.equals(obj) && km == ((Borne)obj).km;
	}
	
	@Override
	public int hashCode() {
		return Integer.hashCode(km);
	}
}