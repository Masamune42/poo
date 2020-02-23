package fr.eni.ecole.quelMedecin.bo;

public class MedecinGeneraliste {
	protected String nom;
	protected String prenom;
	protected String numeroDeTelephone;
	static protected int tarif = 25;
	Adresse adresse;
	Creneau[] tabCreneau = new Creneau[15];
	// compteur du nb de cr�neaux, va garder sa valeur apr�s chaque changement.
	private int nbCreaneau = 0;
	
	public MedecinGeneraliste(String nom, String prenom, String numeroDeTelephone) {
		this.nom = nom;
		this.prenom = prenom;
		this.numeroDeTelephone = numeroDeTelephone;
	}

	public MedecinGeneraliste(String nom, String prenom, String numeroDeTelephone, Adresse adresse) {
		this.nom = nom;
		this.prenom = prenom;
		this.numeroDeTelephone = numeroDeTelephone;
		this.adresse = adresse;
	}

	public void ajouterCreneau(Creneau c) {
		// On va v�rifier que le m�decin (this)
		// est bien celui associ� au cr�neau (c.getMedecin())
		// Cela �vite que si l'on utilise un autre constructeur
		// un autre m�decin (ou aucun) ne soit associ� au cr�neau
		if (this.equals(c.getMedecin())) {
			this.tabCreneau[this.nbCreaneau] = c;
			this.nbCreaneau++;
		}
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
		System.out.println("T�l�phone : " + numeroDeTelephone);
		System.out.println("Tarif : " + tarif + "�");
		if(adresse != null) {
			System.out.println("Adresse :");
			adresse.afficher();
		}
		if(tabCreneau.length == 0) {
			System.out.println("Cr�neaux :");
			for (Creneau creneau : tabCreneau) {
				creneau.afficher();
			}
		}
		
	}

}
