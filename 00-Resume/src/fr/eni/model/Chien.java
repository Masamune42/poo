package fr.eni.model;

public class Chien extends Animal {
	private int nbBalles;

	public Chien(int nbBalles) {
		super();
		this.nbBalles = nbBalles;
	}
	
	public Chien(String nom, int age, Humain humain, int nbBalles) {
		super(nom, age, humain);
		this.nbBalles = nbBalles;
	}

	public int getNbBalles() {
		return nbBalles;
	}

	public void setNbBalles(int nbBalles) {
		this.nbBalles = nbBalles;
	}

	@Override
	public String toString() {
		return super.toString() + " [nbBalles=" + nbBalles + "]";
	}
	
	
	
	
	
	

}
