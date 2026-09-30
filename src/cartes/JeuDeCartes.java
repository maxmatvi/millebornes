package cartes;

public class JeuDeCartes {

	private Configuration[] typesDeCartes;

	public JeuDeCartes() {
		// Initialisation du tableau avec les 19 types de cartes requis
		this.typesDeCartes = new Configuration[19];

		this.typesDeCartes[0] = new Configuration(new Borne(25), 10);
		this.typesDeCartes[1] = new Configuration(new Borne(50), 10);
		this.typesDeCartes[2] = new Configuration(new Borne(75), 10);
		this.typesDeCartes[3] = new Configuration(new Borne(100), 12);
		this.typesDeCartes[4] = new Configuration(new Borne(200), 4);

		this.typesDeCartes[5] = new Configuration(new Parade(Type.FEU), 14); // Feu Vert
		this.typesDeCartes[6] = new Configuration(new FinLimite(), 6);
		this.typesDeCartes[7] = new Configuration(new Parade(Type.ESSENCE), 6); // Bidon d'essence
		this.typesDeCartes[8] = new Configuration(new Parade(Type.CREVAISON), 6); // Roue de secours
		this.typesDeCartes[9] = new Configuration(new Parade(Type.ACCIDENT), 6); // Réparation

		this.typesDeCartes[10] = new Configuration(new Attaque(Type.FEU), 5); // Feu Rouge
		this.typesDeCartes[11] = new Configuration(new DebutLimite(), 4); // Limite 50
		this.typesDeCartes[12] = new Configuration(new Attaque(Type.ESSENCE), 3); // Panne d'essence
		this.typesDeCartes[13] = new Configuration(new Attaque(Type.CREVAISON), 3); // Crevaison
		this.typesDeCartes[14] = new Configuration(new Attaque(Type.ACCIDENT), 3); // Accident

		this.typesDeCartes[15] = new Configuration(new Botte(Type.FEU), 1); // Prioritaire
		this.typesDeCartes[16] = new Configuration(new Botte(Type.ESSENCE), 1); // Citerne
		this.typesDeCartes[17] = new Configuration(new Botte(Type.CREVAISON), 1); // Increvable
		this.typesDeCartes[18] = new Configuration(new Botte(Type.ACCIDENT), 1); // As du volant
	}

	public String affichageJeuDeCartes() {
		StringBuilder sb = new StringBuilder("JEU :\n");
		for (Configuration config : this.typesDeCartes) {
			if (config != null) {
				sb.append(config.getNbExemplaires());
				sb.append(" ");
				sb.append(config.getCarte());
				sb.append("\n");
			}
		}
		return sb.toString();
	}

	public Carte[] donnerCartes() {
		int tailleTotale = 0;
		for (Configuration config : this.typesDeCartes) {
			if (config != null) {
				tailleTotale += config.getNbExemplaires();
			}
		}

		// Remplir le tableau en dupliquant les cartes selon leur nombre d'exemplaires
		Carte[] toutesLesCartes = new Carte[tailleTotale];
		for (int i = 0, index = 0; i < typesDeCartes.length; i++) {
			Configuration configuration = typesDeCartes[i];
			if (configuration != null) {
				for (int j = 0; j < configuration.getNbExemplaires(); j++) {
					toutesLesCartes[index] = configuration.getCarte();
					index++;
				}
			}
		}
		return toutesLesCartes;
	}

	
	private static class Configuration {
		private Carte carte;
		private int nbExemplaires;

		private Configuration(Carte carte, int nbExemplaires) {
			this.carte = carte;
			this.nbExemplaires = nbExemplaires;
		}

		private Carte getCarte() {
			return this.carte;
		}

		private int getNbExemplaires() {
			return this.nbExemplaires;
		}
	}
}
