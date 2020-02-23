package fr.eni.ecoleeni.maximot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public final class Launcher {

	static boolean win = false;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] rndWord = tirerMotAleatoirement();

		afficher(rndWord);

		char[] rndWordMix = melange(rndWord);

		do {
			afficher(rndWordMix);
			System.out.println("Saisir un mot :");
			// Prends le mot du joueur
			String motJoueur = sc.nextLine().toLowerCase();
			char[] tabMotJoueur = new char[motJoueur.length()];
			// On place chaque lettre du mot dans le tableau
			for (int i = 0; i < tabMotJoueur.length; i++) {
				tabMotJoueur[i] = motJoueur.charAt(i);
			}

			boolean memeLettres = bonnesLettres(tabMotJoueur, rndWord);

			// Si on utilise les bonnes lettres, on peut vérifier que le mot existe
			// Sinon, renvoie un message pour indiquer que les lettres ne sont pas les bonnes
			if (memeLettres) {
				dansLeDico(motJoueur);
			} else {
				System.out.println("Vous n'utilisez pas les bonnes lettres");
			}
		} while (!win);

	}

	/**
	 * Vérifie que le mot du joueur est dans le dictionnaire
	 * @param motJoueur mot proposé par le joueur
	 */
	private static void dansLeDico(String motJoueur) {
		try {
			// On spécifie l'adresse locale du dico
			File addr = new File("C:\\Users\\acaignar2019\\Documents\\06-POO\\TP\\dictionnaire.txt");
			// On lit et on stock tous les mots dans le buffer dico
			BufferedReader bfr = new BufferedReader(new InputStreamReader(new FileInputStream(addr), "UTF8"));
			String str;

			// Tant qu'il y a des mots dans le buffer, on les ajoute à la liste
			while ((str = bfr.readLine()) != null) {
				if (str.equals(motJoueur)) {
					
					win = true;
				}
			}
			
			if(win) {
				System.out.println("GG !");
			} else {
				System.out.println("Réessayez !\n");
			}
			

			bfr.close();
		} catch (Exception e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}

	private static boolean bonnesLettres(char[] tabMotJoueur, char[] rndWord) {

		char[] motJoueurTrie = Arrays.copyOf(tabMotJoueur, tabMotJoueur.length);
		char[] rndWordTrie = Arrays.copyOf(rndWord, tabMotJoueur.length);

		Arrays.sort(motJoueurTrie);
		Arrays.sort(rndWordTrie);

		if (Arrays.equals(motJoueurTrie, rndWordTrie)) {
			return true;
		} else {
			return false;
		}

	}

	private static void afficher(char[] rndWordMix) {
		for (char c : rndWordMix) {
			System.out.print(c);
		}
		System.out.println();

	}

	/**
	 * Va mélanger les lettres d'un mot
	 * 
	 * @param mot
	 *            : mot à mélanger
	 * @return le mot mélangé
	 */
	public static char[] melange(char[] mot) {
		Random rgen = new Random(); // Random number generator
		int size = mot.length;

		char[] motMelange = Arrays.copyOf(mot, size);

		for (int i = 0; i < size; i++) {
			int randomPosition = rgen.nextInt(size);
			char temp = motMelange[i];

			motMelange[i] = motMelange[randomPosition];
			motMelange[randomPosition] = temp;
		}
		return motMelange;
	}

	/**
	 * Retourne un mot aléatoire du dictionnaire
	 * 
	 * @return Un tableau de caractère contenant les lettres du mot
	 */
	public static char[] tirerMotAleatoirement() {
		// On crée une liste pour stocker tous les mots du dico
		ArrayList<String> dico = new ArrayList<String>();
		try {
			// On spécifie l'adresse locale du dico
			File addr = new File("C:\\Users\\acaignar2019\\Documents\\06-POO\\TP\\dictionnaire.txt");
			// On lit et on stock tous les mots dans le buffer dico
			BufferedReader bfr = new BufferedReader(new InputStreamReader(new FileInputStream(addr), "UTF8"));
			String str;

			// Tant qu'il y a des mots dans le buffer, on les ajoute à la liste
			while ((str = bfr.readLine()) != null) {
				dico.add(str);
			}

			bfr.close();
		} catch (Exception e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		// Crée un nombre aléatoirement
		int rndNb = (int) (Math.random() * dico.size());
		// On choisit un mot aléatoire avec le nombre tiré avant
		String rndWord = dico.get(rndNb);

		// Création d'un tableau de char de la taille du mot
		char[] tabRndWord = new char[rndWord.length()];

		// On place chaque lettre du mot dans le tableau
		for (int i = 0; i < tabRndWord.length; i++) {
			tabRndWord[i] = rndWord.charAt(i);
		}

		return tabRndWord;

	}

}
