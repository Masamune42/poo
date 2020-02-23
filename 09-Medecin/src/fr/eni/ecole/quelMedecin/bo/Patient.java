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
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM YYYY");
	
	
	
	public Patient(String nom, String prenom, String numeroDeTelephone, char sexe, long numSecurite,
			LocalDate dateNaissance, String commentaires) {
		this.nom = nom;
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
		System.out.println("Sexe : " + ((sexe=='m') ? "Masculin" : "Féminin"));
		System.out.println("Numéro de Sécurité sociale : " + numSecurite);
		System.out.println("Date de naissance : " + formatter.format(dateNaissance));
		System.out.println("Commentaires : " + (commentaires != null ? commentaires : "[aucun commentaire]"));
	}
}
