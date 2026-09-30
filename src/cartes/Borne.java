package cartes;

public class Borne extends Carte {

	private int km;

	public Borne(int km) {
		this.km = km;
	}


	public int getKm() {
		return this.km;
	}


	@Override
	public String toString() {
	    return this.km + " km"; // Exemple : "100 km"
	}
	
	//TP3 Modif.:
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Borne borne){
			return km == borne.km;
		}
		return false;
	}
	


}
