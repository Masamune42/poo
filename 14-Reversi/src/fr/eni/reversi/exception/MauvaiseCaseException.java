package fr.eni.reversi.exception;

public class MauvaiseCaseException extends Exception {
	public MauvaiseCaseException() {
		super("Erreur : Vous avez choisi une case déjà utilisée ou en dehors du tableau. Réessayez...");
	}
}
