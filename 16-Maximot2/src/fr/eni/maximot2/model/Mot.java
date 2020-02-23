package fr.eni.maximot2.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Mot {
	private String mot;
	// private String motMelange;
	private ArrayList<Character> motMelange = new ArrayList<>();

	public Mot() {
		mot = Dico.motAleatoire();
	}

	public void melange() {

		for (Character c : this.mot.toCharArray()) {
			motMelange.add(c);
		}

		Collections.shuffle(motMelange);

	}

	public void afficherMotRandom() {
		Iterator<Character> it = motMelange.iterator();

		while (it.hasNext()) {
			Character c = it.next();
			System.out.print(c);
		}
		System.out.println();
	}

	public String getMot() {
		return mot;
	}

	public void setMot(String mot) {
		this.mot = mot;
	}

	public ArrayList<Character> getMotMelange() {
		return motMelange;
	}

	public void setMotMelange(ArrayList<Character> motMelange) {
		this.motMelange = motMelange;
	}

	public boolean memeLettres(String motEntre) {
		ArrayList<Character> motListe = new ArrayList<>();
		for (Character c : motEntre.toCharArray()) {
			motListe.add(c);
		}

		ArrayList<Character> motTrie = new ArrayList<Character>(motMelange);

		for (int i = 0; i < motListe.size(); i++) {
			if (motTrie.contains(motListe.get(i))) {
				motTrie.remove(motListe.get(i));
			} else {
				return false;
			}
		}
		return true;

		// Solution de verif si les 2 mots sont de même tailles :
		// Collections.sort(motListe);
		// Collections.sort(motTrie);
		//
		// if (motListe.equals(motTrie)) {
		// return true;
		// } else {
		// return false;
		// }

	}

}
