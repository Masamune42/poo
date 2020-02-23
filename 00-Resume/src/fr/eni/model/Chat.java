package fr.eni.model;

public class Chat extends Animal {
	private int nbSouris;

	public Chat(int nbSouris) {
		super();
		this.nbSouris = nbSouris;
	}
	
	public Chat(String nom, int age, Humain humain, int nbSouris) {
		super(nom, age, humain);
		this.nbSouris = nbSouris;
	}

	public int getNbBalles() {
		return nbSouris;
	}

	public void setNbBalles(int nbBalles) {
		this.nbSouris = nbBalles;
	}

	@Override
	public String toString() {
		return super.toString() + " [nbSouris=" + nbSouris + "]";
	}
}
