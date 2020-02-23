package fr.eni.calculatrice.launcher;

import java.util.Scanner;

import fr.eni.calculatrice.exception.DepassementCapaciteException;
import fr.eni.calculatrice.exception.DivisionParZeroException;
import fr.eni.calculatrice.model.Operation;

public class Launcher {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		char choix;
		int n1 = 0;
		int n2 = 0;

		do {

			n1 = enterANumber();

			n2 = enterANumber();

			choix = calculate(n1, n2);
		} while (choix != 'q');

	}

	/**
	 * 
	 * @param n1 nombre 1
	 * @param n2 nombre 2
	 * @return le résultat du calcul choisi entre les 2 nombres
	 */
	private static char calculate(int n1, int n2) {
		char choix;
		System.out.println("opérateur ? (+ - * / % ou q pour quitter)");
		choix = sc.nextLine().charAt(0);
		try {
			switch (choix) {
			case '+':
				System.out.println(Operation.ajouter(n1, n2));

				break;
			case '-':
				System.out.println(Operation.soustraire(n1, n2));

				break;
			case '*':
				System.out.println(Operation.multiplier(n1, n2));

				break;
			case '/':
				if (n2 == 0) {
					throw new DivisionParZeroException();
				} else {
					System.out.println(n1 / n2);
				}

				break;
			default:
				break;
			}
		} catch (DepassementCapaciteException e) {
			System.err.println(e.getMessage());
		} catch (DivisionParZeroException e) {
			System.err.println(e.getMessage());
		}
		return choix;
	}

	/**
	 * Demande d'entrer un nombre
	 * @return le nombre rentré
	 */
	private static int enterANumber() {
		boolean isNumber = false;
		int number=0;
		do {
			System.out.println("Saisir un nombre entier : ");
			try {
				String strNumber = sc.nextLine();
				long longNumber = Long.parseLong(strNumber);
				if (longNumber > Integer.MAX_VALUE || longNumber < Integer.MIN_VALUE) {
					throw new DepassementCapaciteException();
				}

				number = Integer.parseInt(strNumber);
				isNumber = true;
			} catch (DepassementCapaciteException e) {
				System.err.println(e.getMessage());
				isNumber = false;
			} catch (NumberFormatException e) {
				System.err.println("Saisie incorrecte. Réessayez...");
				isNumber = false;
			}
		} while (!isNumber);

		return number;
	}

}
