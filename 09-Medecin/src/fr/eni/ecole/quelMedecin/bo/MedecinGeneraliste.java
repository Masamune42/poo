package fr.eni.ecole.quelMedecin.bo;

public class MedecinGeneraliste {
	protected String nom;
	protected String prenom;
	protected String numeroDeTelephone;
	static protected int tarif=25;
	
	

	public MedecinGeneraliste(String nom, String prenom, String numeroDeTelephone) {
		this.nom = nom;
		this.prenom = prenom;
		this.numeroDeTelephone = numeroDeTelephone;
	}

	public String getNom() {
		return nom;
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

	public static int getTarif() {
		return tarif;
	}

	public static void setTarif(int tarif) {
		MedecinGeneraliste.tarif = tarif;
	}

	public void afficher() {
		System.out.println(nom + " " + prenom);
		System.out.println("Téléphone : " + numeroDeTelephone);
		System.out.println("Tarif : " + tarif + "€");

	}

}
