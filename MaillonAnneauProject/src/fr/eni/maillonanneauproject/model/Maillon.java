package fr.eni.maillonanneauproject.model;

public class Maillon<T> {

	private T valeur;
	private Maillon<T> suivant;

	public Maillon(T valeur, Maillon<T> suivant) {
		this.valeur = valeur;
		this.suivant = suivant;
	}

	public Maillon<T> suivant() {
		return this.suivant;
	}

	public void setSuivant(Maillon<T> suivant) {
		this.suivant = suivant;
	}

	public T get() {
		return this.valeur;
	}

}
