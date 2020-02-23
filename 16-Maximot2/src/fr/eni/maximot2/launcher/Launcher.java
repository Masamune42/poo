package fr.eni.maximot2.launcher;

import java.util.Scanner;

import fr.eni.maximot2.model.Dico;
import fr.eni.maximot2.model.Mot;

public class Launcher {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Mot mot = new Mot();
		String motEntre = "";
		boolean estTrouve = false;

		System.out.println(mot.getMot());
		mot.melange();

		do {
			mot.afficherMotRandom();

			System.out.println("Proposez un mot :");
			motEntre = sc.nextLine();

			if (mot.memeLettres(motEntre)) {
				if (Dico.dansLeDico(motEntre)) {
					System.out.println("GG !");
					estTrouve = true;
				} else {
					System.out.println("Bonnes lettres mais le mot n'existe pas. Réessayez !\n");
					estTrouve = false;
				}
			} else {
				System.out.println("Pas les bonnes lettres ! Try again...\n");
			}
		} while (!estTrouve);

		sc.close();
	}

}
