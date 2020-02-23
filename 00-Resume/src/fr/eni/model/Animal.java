package fr.eni.model;

public abstract class Animal {
	private String nom;
	private int age;
	// Aggrégation
	private Humain humain;
	
	public Animal() {
	}
	
	public Animal(String nom, int age, Humain humain) {
		this.nom = nom;
		this.age = age;
		this.humain = humain;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Humain getHumain() {
		return humain;
	}

	public void setHumain(Humain humain) {
		this.humain = humain;
	}

	@Override
	public String toString() {
		return "Animal [nom=" + nom + ", age=" + age + ", humain=" + humain + "]";
	}
}
