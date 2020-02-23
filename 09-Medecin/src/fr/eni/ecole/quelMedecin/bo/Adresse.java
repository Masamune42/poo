package fr.eni.ecole.quelMedecin.bo;

public class Adresse {
	protected String mentions;
	protected int numeroVoie;
	protected String typeVoie;
	protected String nomVoie;
	protected int codePostal;
	protected String nomCommune;

	public Adresse(int numeroVoie, String typeVoie, String nomVoie, int codePostal, String nomCommune) {
		this.mentions = null;
		this.numeroVoie = numeroVoie;
		this.typeVoie = typeVoie;
		this.nomVoie = nomVoie;
		this.codePostal = codePostal;
		this.nomCommune = nomCommune;
	}

	public Adresse(String mentions, int numeroVoie, String typeVoie, String nomVoie, int codePostal,
			String nomCommune) {
		this.mentions = mentions;
		this.numeroVoie = numeroVoie;
		this.typeVoie = typeVoie;
		this.nomVoie = nomVoie;
		this.codePostal = codePostal;
		this.nomCommune = nomCommune;
	}

	public void afficher() {
		if (mentions != null) {
			System.out.println(mentions);
		}
		
		System.out.println(numeroVoie + (typeVoie != null ? typeVoie : "") + " " + nomVoie);
		System.out.println(String.format("%05d", codePostal) + " " + nomCommune.toUpperCase());

	}

}
