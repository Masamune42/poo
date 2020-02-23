package fr.eni.reversi.exception;

public class NombreNegatifException extends Exception {
	public NombreNegatifException() {
		super("Erreur : le chiffre ne peut être négatif. Réessayez.");
	}
}
