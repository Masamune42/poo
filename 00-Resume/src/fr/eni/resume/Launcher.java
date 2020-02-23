package fr.eni.resume;

import fr.eni.exception.NegativeValueException;
import fr.eni.model.Animal;
import fr.eni.model.Chat;
import fr.eni.model.Chien;
import fr.eni.model.Humain;

public class Launcher {

	public static void main(String[] args) {
		// Bases
		System.out.println("2-Bases :");
		bases();
		System.out.println("---------------------------------------");
		
		// POO
		System.out.println("3-POO");
		poo();
		System.out.println("---------------------------------------");
		
		// Exceptions
		System.out.println("3-Exceptions");
		exceptions();
		System.out.println("---------------------------------------");
	}

	private static void exceptions() {
		// 4 types d'exceptions
		System.out.println("start");
		try {
			//int i = 5 / 0;
			// String myStr = null;
			int i = -2;
			// myStr.length();
			if (i < 0) {
				throw new NegativeValueException();
			}
			System.out.println("After code in try");
		} catch (ArithmeticException e) {
			// 1. l'exception existe
			System.out.println("Error Arith");
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("Error Null Pointer");
			e.printStackTrace();
		} catch (NegativeValueException e) {
			// 3. Création de l'exception puis utlisation
			e.printStackTrace();
		}

		System.out.println("end");
		
	}

	private static void poo() {
		Humain humain = new Humain();
		humain.setPrenom("Alex");
		humain.setNom("C");
		humain.setAge(42);
		
		// Polymorphisme
		// Aggrégation dans Animal
		// super dans chat et chien
		Animal chat = new Chat("kiki", 20, humain, 0);
		Animal chien = new Chien("Hatchi", 8, humain, 2);
		
		System.out.println(chat);
		System.out.println(chien);
		
	}

	static void bases() {
		// Tableaux
		int[] tab1 = new int[4];
		int[] tab2 = {5,4,3};
		
		int[][] tab3 = {{5,4,3},{5,4,3}};
		
		// Conditions ternaires
		int i = 1;
		int j = (i > 2 ? i : 0);
		System.out.println("Condition ternaire : "+j);
		System.out.println();
		
		// foreach
		System.out.println("foreach");
		for (int k : tab2) {
			System.out.println(k);
		}
		System.out.println();
		
		
	}

}
