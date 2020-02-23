package fr.eni.maximot2.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Dico {
	public static String motAleatoire() {
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
		return rndWord;
	}

	public static boolean dansLeDico(String motJoueur) {
		try {
			// On spécifie l'adresse locale du dico
			File addr = new File("C:\\Users\\acaignar2019\\Documents\\06-POO\\TP\\dictionnaire.txt");
			// On lit et on stock tous les mots dans le buffer dico
			BufferedReader bfr = new BufferedReader(new InputStreamReader(new FileInputStream(addr), "UTF8"));
			String str;

			// Tant qu'il y a des mots dans le buffer, on les ajoute à la liste
			while ((str = bfr.readLine()) != null) {
				if (str.equals(motJoueur)) {

					return true;
				}
			}

			bfr.close();
			return false;
		} catch (Exception e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return false;

	}

}
