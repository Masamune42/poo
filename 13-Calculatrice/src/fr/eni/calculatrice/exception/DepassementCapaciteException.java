package fr.eni.calculatrice.exception;

@SuppressWarnings("serial")
public class DepassementCapaciteException extends Exception {
	public DepassementCapaciteException() {
		super("Le r�sultat d�passe la capacit� de la calculatrice");
	}
}
