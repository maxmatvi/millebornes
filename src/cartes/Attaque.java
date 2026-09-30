package cartes;

public class Attaque extends Bataille {

	public Attaque(Type type) {
		super(type);
	}

	@Override
	public String toString() {
		return this.getType().getNomAttaque();
	}
	
	//TP3 Modif.:
		@Override
		public boolean equals(Object obj) {
			if(obj instanceof Attaque attaque) {
				return getType().getNomAttaque().equals(attaque.getType().getNomAttaque());
			}
			return false;
		}

}
