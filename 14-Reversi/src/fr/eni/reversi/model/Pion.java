package fr.eni.reversi.model;

public enum Pion {
	// 3 types de cases
	LIBRE, BLANC, NOIR;

	// Nombre de base de pion sur le plateau
	private int nombre = 2;

	/**
	 * Permet de savoir à l'affichage le pion du tableau
	 * @return le symbole du pion concerné
	 */
	public char getSymbole() {
		if (this == Pion.BLANC) {
			return 'o';
		} else if (this == Pion.NOIR) {
			return '●';
		} else {
			return '·';
		}
	}

	/**
	 * Détecte la couleur du pion actuel
	 * @return la couleur opposé du pion
	 */
	public Pion autrePion() {
		if (this == Pion.BLANC) {
			return Pion.NOIR;
		} else if (this == Pion.NOIR) {
			return Pion.BLANC;
		} else {
			return Pion.LIBRE;
		}

	}

	public void gagne(int nbPionChange) {
		nombre += nbPionChange;

	}

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

}
