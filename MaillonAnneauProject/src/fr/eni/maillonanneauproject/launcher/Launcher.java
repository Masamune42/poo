package fr.eni.maillonanneauproject.launcher;

import fr.eni.maillonanneauproject.model.Anneau;
import fr.eni.maillonanneauproject.model.Maillon;
import fr.eni.maillonanneauproject.model.Sock;

public class Launcher {
	public static void main(String[] args) {
		Sock s1 = new Sock("Yellow");
		Sock s2 = new Sock("Black");
		Sock s3 = new Sock("Rainbow");
		Sock s4 = new Sock("Purple");
		
		Anneau<Sock> anneauSock = new Anneau<>();
		
		anneauSock.ajouter(s1);
		anneauSock.ajouter(s2);
		anneauSock.ajouter(s3);
		anneauSock.ajouter(s4);
		
		Maillon<Sock> maillon = null;
		for (int i = 0; i < anneauSock.getNbElements(); i++) {
			
			if(i== 0 ) {
				maillon = anneauSock.getPtEntree();
			} else {
				maillon = maillon.suivant();
			}
			
			System.out.println(maillon.get().getColor());
		}
		
		
	}

}
