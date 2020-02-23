package fr.eni.exception;

public class NegativeValueException extends Exception {
	public NegativeValueException() {
		super("Pas de chiffre négatif !");
	}
}
