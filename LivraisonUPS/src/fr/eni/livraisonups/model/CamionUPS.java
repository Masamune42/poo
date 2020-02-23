package fr.eni.livraisonups.model;

public class CamionUPS<T extends Animal> {
	private T chargement;

	public void chargerCamion(T chargement) {
		this.chargement = chargement;
	}

	public void afficherChargement() {
		System.out.println("Tut tut, voici mon chargement !");
		System.out.println(chargement);
	}

	public T recuperer() {
		return chargement;
	}
	
	public void faireUnePause() {
		System.out.println("Boire un café");
		System.out.println("Je nourri les animaux");
		chargement.feed();
	}
	
	

}
