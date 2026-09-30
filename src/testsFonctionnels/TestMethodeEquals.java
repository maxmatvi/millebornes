package testsFonctionnels;

import cartes.Attaque;
import cartes.Borne;
import cartes.Parade;
import cartes.Type;

public class TestMethodeEquals {
	
	public static void main(String[] args) {
		
		//Test de la méthode equals sur 2 obj. bornes
        Borne borne1 = new Borne(25);
        Borne borne2 = new Borne(25);
        System.out.println("borne1 : " + borne1);
        System.out.println("borne2 : " + borne2);
        boolean egaux = borne1.equals(borne2);
        System.out.println(egaux);
        
		//Test de la méthode equals sur 2 obj. attaque (feu rouge)
        Attaque feuRouge1 = new Attaque(Type.FEU);
        Attaque feuRouge2 = new Attaque(Type.FEU);
        System.out.println("feuRouge1 : " + feuRouge1);
        System.out.println("feuRouge2 : " + feuRouge2);
        boolean egaux2 = feuRouge1.equals(feuRouge2);
        System.out.println(egaux2);
        
      //Test de la méthode equals sur 1 obj. attaque (feu rouge) et 1 obj. parade (feu_vert)
        Attaque feuRouge3 = new Attaque(Type.FEU);
        Parade feuVert = new Parade(Type.FEU);
        System.out.println("feuRouge3 : " + feuRouge3);
        System.out.println("feuVert : " + feuVert);
		boolean egaux3 = feuRouge3.equals(feuVert);
        System.out.println(egaux3);

    }
	
	
}
