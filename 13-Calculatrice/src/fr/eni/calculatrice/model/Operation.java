package fr.eni.calculatrice.model;

import fr.eni.calculatrice.exception.DepassementCapaciteException;

public class Operation {
	public static int ajouter(int n1, int n2) throws DepassementCapaciteException {
		if ((long)(n1)+(long)(n2) != n1 + n2) {
			throw new DepassementCapaciteException();
		} else {
			return n1+n2;
		}
		
	}
	
	public static int soustraire(int n1, int n2) throws DepassementCapaciteException {
		if ((long)(n1)-(long)(n2) != n1 - n2) {
			throw new DepassementCapaciteException();
		} else {
			return n1-n2;
		}
		
	}
	
	public static int multiplier(int n1, int n2) throws DepassementCapaciteException {
		if ((long)(n1)*(long)(n2) != n1 * n2) {
			throw new DepassementCapaciteException();
		} else {
			return n1*n2;
		}
		
	}
}
