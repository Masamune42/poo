package fr.eni.ecole.quelMedecin.bo;

import java.time.LocalTime;

public class Creneau {

	protected LocalTime heureDebut;
	protected int duree;
	MedecinGeneraliste medecin;
	
	public Creneau() {
		// TODO Auto-generated constructor stub
	}

	public Creneau(LocalTime heureDebut, int duree, MedecinGeneraliste medecin) {
		this.heureDebut = heureDebut;
		this.duree = duree;
		this.medecin = medecin;
		medecin.ajouterCreneau(this);
	}

	public MedecinGeneraliste getMedecin() {
		return medecin;
	}

	public void setMedecin(MedecinGeneraliste medecin) {
		this.medecin = medecin;
	}

	public void afficher() {
		System.out.println(this.heureDebut + " - " + heureDebut.plusMinutes(duree) + " ("+duree+" minutes)");

	}

}
