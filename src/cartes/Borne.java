package cartes;

public class Borne extends Carte {

	private int km;
	
	public Borne(int km) {
		super();
		this.km = km;
	}
	
	
	public int getKm() {
		return this.km;
	}


	@Override
	public String toString() {
	    return this.km + " km"; // Exemple : "100 km"
	}


}
