package fr.eni.ecoleeni.enumeration;

import java.util.Scanner;

public class Launcher {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		

		boolean hasError = false;
		do {
			System.out.println("Age?");

			String myAge = sc.nextLine();
			try {
				int ageInt = Integer.parseInt(myAge);
				hasError = false;
			} catch (Exception e) {
				System.out.println("Oups, not a number");
				hasError = true;
			}
		} while (hasError);

	}

}
