package fr.eni.maillonanneauproject.model;

public class Anneau<T> {
	private Maillon<T> ptEntree;
	private int nbElements = 0;

	public Maillon<T> ajouter(T element) {
		this.nbElements++;
		if (ptEntree == null) {
			// Si on a pas encore entré de valeurs
			this.ptEntree = new Maillon<T>(element, null);
			this.ptEntree.setSuivant(this.ptEntree);
		} else {
			Maillon<T> nouveau = new Maillon<T>(element, this.ptEntree);
			this.ptEntree.setSuivant(nouveau);
			this.ptEntree = nouveau;
		}
		return ptEntree;

	}

	public int getNbElements() {
		return nbElements;
	}

	public Maillon<T> getPtEntree() {
		return ptEntree;
	}
	
	
}
