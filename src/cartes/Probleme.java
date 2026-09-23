package cartes;

public abstract class Probleme extends Carte {
	
	protected Probleme(Type type) {
		this.type = type;
	}

	private Type type;

	public Type getType() {
		return type;
	}

}
