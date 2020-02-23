package fr.eni.model;

import java.io.Serializable;

public class Humain implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8547286404040892833L;
	
	private String nom;
	private String prenom;
	private int age;
	
	public Humain() {
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Humain [nom=" + nom + ", prenom=" + prenom + ", age=" + age + "]";
	}
	
}
