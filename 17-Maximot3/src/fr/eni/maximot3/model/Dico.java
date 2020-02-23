package fr.eni.maximot3.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class Dico {
	static ArrayList<String> dico;

	public static String motAleatoire() {
		dico = new ArrayList<String>();
		// On crée une liste pour stocker tous les mots du dico

		try {
			// On spécifie l'adresse locale du dico
			File addr = new File("C:\\Users\\acaignar2019\\Documents\\06-POO\\TP\\dictionnaire.txt");
			// On lit et on stock tous les mots dans le buffer dico
			BufferedReader bfr = new BufferedReader(new InputStreamReader(new FileInputStream(addr), "UTF8"));
			String str;

			// Tant qu'il y a des mots dans le buffer, on les ajoute à la liste
			while ((str = bfr.readLine()) != null) {
				dico.add(str.toUpperCase());
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
				if (str.toUpperCase().equals(motJoueur)) {

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

	public static ArrayList<String> verifMots(String motTire) {

		Iterator<String> it;
		ArrayList<String> listeMotsPG = new ArrayList<>();

		for (int i = 2; i <= motTire.length(); i++) {
			it = dico.iterator();
			while (it.hasNext()) {
				
				String motDico = it.next();
				
				if (motDico.length() == i) {
					listeMotsPG.add(motDico);
				}

			}
		}
		return listeMotsPG;
	}

}
