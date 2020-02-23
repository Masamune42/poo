package fr.eni.ecole.quelMedecin.test;

import fr.eni.ecole.quelMedecin.bo.MedecinGeneraliste;

public class TestMedecin {

	public static void main(String[] args) {
		System.out.println("__________________________ M�decins ______________________________");
		MedecinGeneraliste melanie = new MedecinGeneraliste("Malalaniche", "M�lanie", "02.28.03.17.28");
		MedecinGeneraliste edmond = new MedecinGeneraliste("Bosapin", "Edmond", "+33 2 17 18 19 20");
		MedecinGeneraliste djemila = new MedecinGeneraliste("Table", "Dj�mila", "03-04-05-06-07");

		melanie.afficher();
		System.out.println("------------------------------------------------------------------");
		edmond.afficher();
		System.out.println("------------------------------------------------------------------");
		djemila.afficher();

		System.out.println("--------------- Changement du num�ro de ce m�decin ---------------");
		djemila.setNumeroDeTelephone("07-06-05-04-03");
		System.out.printf("Nouveau num�ro du Dr %s : %s%n", djemila.getNom(), djemila.getNumeroDeTelephone());
		
		System.out.println("-------------- Changement du prix de la consultation -------------");
		MedecinGeneraliste.setTarif(23);
		melanie.afficher();
		System.out.println("------------------------------------------------------------------");
		edmond.afficher();
		System.out.println("------------------------------------------------------------------");
		djemila.afficher();
	}
}
