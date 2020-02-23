package fr.eni.reversi.launcher;

import java.util.Scanner;

import fr.eni.reversi.exception.NombreNegatifException;
import fr.eni.reversi.model.Pion;
import fr.eni.reversi.model.PlateauDeReversi;

public class Launcher {

	public static void main(String[] args) {

		PlateauDeReversi plateau = new PlateauDeReversi();
		Scanner sc = new Scanner(System.in);
		// Définition du 1er joueur
		Pion pion = Pion.NOIR;
		
		int ligne=0;
		int colonne=0;
		do {
			plateau.afficher();
			// Change de joueur si l'autre a effectué un tour en retournant des pions
			pion = plateau.jouer(pion);
			// test si le joueur courant peut jouer
			if (plateau.peutJouer(pion)) {
				System.out.println(pion.getSymbole() + " à toi");

				System.out.println("Ligne :");
				ligne = entreeValeur(sc);

				System.out.println("Colonne :");
				colonne = entreeValeur(sc);
				
				// Pose un pion
				plateau.poser(pion, ligne - 1, colonne - 1);
			} else {
				// Sinon change de joueur
				pion = pion.autrePion();
			}

		} while (Pion.NOIR.getNombre() + Pion.BLANC.getNombre() < 64);
		
		if(Pion.NOIR.getNombre() > Pion.BLANC.getNombre()) {
			System.out.println(Pion.NOIR.getSymbole() +" a gagné");
		} else if (Pion.NOIR.getNombre() < Pion.BLANC.getNombre()) {
			System.out.println(Pion.BLANC.getSymbole() +" a gagné");
		} else {
			System.out.println("Égalité !");
		}

	}

	private static int entreeValeur(Scanner sc) {
		boolean error = false;
		int valeur=0;
		do {
			
			try {
				valeur = Integer.parseInt(sc.nextLine());
				if(valeur > 0) {
					
					error = false;
				} else {
					throw new NombreNegatifException();
				}
				
			} catch (NumberFormatException e) {
				error = true;
				System.err.println("Entrez une valeur correcte");
			} catch(NombreNegatifException e) {
				error = true;
				System.err.println(e.getMessage());
			}
		} while (error);
		return valeur;
	}

}
