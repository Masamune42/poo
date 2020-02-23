package fr.eni.ecole.quelMedecin.bo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Patient {
	protected String nom;
	protected String prenom;
	protected String numeroDeTelephone;
	protected char sexe;
	protected long numSecurite;
	protected LocalDate dateNaissance;
	protected String commentaires;
	Adresse adresse;

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM YYYY");

	public Patient(String nom, String prenom, String numeroDeTelephone, char sexe, long numSecurite,
			LocalDate dateNaissance, String commentaires, Adresse adresse) {
		this.nom = nom.toUpperCase();
		this.prenom = prenom;
		this.numeroDeTelephone = numeroDeTelephone;
		this.sexe = sexe;
		this.numSecurite = numSecurite;
		this.dateNaissance = dateNaissance;
		this.commentaires = commentaires;
		this.adresse = adresse;
	}

	public Patient(String nom, String prenom, String numeroDeTelephone, char sexe, long numSecurite,
			LocalDate dateNaissance, String commentaires) {
		this.nom = nom.toUpperCase();
		this.prenom = prenom;
		this.numeroDeTelephone = numeroDeTelephone;
		this.sexe = sexe;
		this.numSecurite = numSecurite;
		this.dateNaissance = dateNaissance;
		this.commentaires = commentaires;
	}

	public void afficher() {
		System.out.println(nom + " " + prenom);
		System.out.println("Téléphone : " + numeroDeTelephone);
		System.out.println("Sexe : " + ((sexe == 'm') ? "Masculin" : "Féminin"));
		System.out.println("Numéro de Sécurité sociale : " + numSecurite);
		System.out.println("Date de naissance : " + formatter.format(dateNaissance));
		System.out.println("Commentaires : " + (commentaires != null ? commentaires : "[aucun commentaire]"));

		if (adresse != null) {
			System.out.println("Adresse :");
			adresse.afficher();
		}

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

	public String getNumeroDeTelephone() {
		return numeroDeTelephone;
	}

	public void setNumeroDeTelephone(String numeroDeTelephone) {
		this.numeroDeTelephone = numeroDeTelephone;
	}

	public char getSexe() {
		return sexe;
	}

	public void setSexe(char sexe) {
		this.sexe = sexe;
	}

	public long getNumSecurite() {
		return numSecurite;
	}

	public void setNumSecurite(long numSecurite) {
		this.numSecurite = numSecurite;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public DateTimeFormatter getFormatter() {
		return formatter;
	}

	public void setFormatter(DateTimeFormatter formatter) {
		this.formatter = formatter;
	}

}
