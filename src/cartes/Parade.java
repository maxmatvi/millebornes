package cartes;

public class Parade extends Bataille {

	public Parade(Type type) {
		super(type);
	}
	
	public String toString() {
		return this.getType().getNomParade();
	}
	
	//TP3 Modif.:
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Parade parade) {
			return getType().getNomParade().equals(parade.getType().getNomParade());
		}
		return false;
	}


}
