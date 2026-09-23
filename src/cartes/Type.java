package cartes;

public enum Type {
    // Définition des constantes avec leurs 3 affichages (Attaque, Parade, Botte)
    FEU("Feu rouge", "Feu vert", "Prioritaire"),
    ESSENCE("Panne d'essence", "Essence", "Citerne"),
    CREVAISON("Crevaison", "Roue de secours", "Increvable"),
    ACCIDENT("Accident", "Réparations", "As du volant");

    private final String nomAttaque;
    private final String nomParade;
    private final String nomBotte;

    // Constructeur à 3 paramètres
    Type(String nomAttaque, String nomParade, String nomBotte) {
        this.nomAttaque = nomAttaque;
        this.nomParade = nomParade;
        this.nomBotte = nomBotte;
    }

    // Getters pour récupérer les affichages
    public String getNomAttaque() { return nomAttaque; }
    public String getNomParade() { return nomParade; }
    public String getNomBotte() { return nomBotte; }
}

