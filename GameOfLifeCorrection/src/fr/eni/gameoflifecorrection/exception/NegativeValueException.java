package fr.eni.gameoflifecorrection.exception;

@SuppressWarnings("serial")
public class NegativeValueException extends Exception {
	public NegativeValueException() {
		super("Please enter a positive value");
	}
}
