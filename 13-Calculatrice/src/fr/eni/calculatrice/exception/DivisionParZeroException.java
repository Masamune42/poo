package fr.eni.calculatrice.exception;

@SuppressWarnings("serial")
public class DivisionParZeroException extends Exception {
	public DivisionParZeroException() {
		super("La division par 0 n'est pas d�finie !");
	}
}
