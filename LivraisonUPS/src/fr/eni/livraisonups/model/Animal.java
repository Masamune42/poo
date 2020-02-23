package fr.eni.livraisonups.model;

public abstract class Animal {
	
	private String nom;
	
	public Animal() {
	}

	public Animal(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@Override
	public String toString() {
		return nom;
	}
	
	public abstract void feed();
}
