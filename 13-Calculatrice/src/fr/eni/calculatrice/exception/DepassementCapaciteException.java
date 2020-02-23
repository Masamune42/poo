package fr.eni.calculatrice.exception;

@SuppressWarnings("serial")
public class DepassementCapaciteException extends Exception {
	public DepassementCapaciteException() {
		super("Le résultat dépasse la capacité de la calculatrice");
	}
}
