package fr.eni.ecole.quelMedecin.bo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RendezVous {
	Creneau creneau;
	Patient patient;
	LocalDate date;
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM YYYY");
	
	public RendezVous(Creneau creneau, Patient patient, LocalDate date) {
		this.creneau = creneau;
		this.patient = patient;
		this.date = date;
	}
	
	
	public void afficher() {
		System.out.print("Rendez-vous du " + formatter.format(date) + " ");
		creneau.afficher();
		System.out.println("avec le Dr " + creneau.medecin.getNom());
		System.out.print("pour ");
		patient.afficher();
	}

}
