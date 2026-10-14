package cartes;

public abstract class Carte {
	
	protected Carte() {
        super();
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj != null && getClass().equals(obj.getClass());
	}

}
