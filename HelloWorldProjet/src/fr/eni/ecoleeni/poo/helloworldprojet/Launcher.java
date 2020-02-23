package fr.eni.ecoleeni.poo.helloworldprojet;

public class Launcher {

	public static void main(String[] args) {

		ditBonjour();
		ditBonjour("Guillaume");
		

	}

	private static void ditBonjour(String nom) {
		System.out.println("Bonjour " + nom);
		
	}

	private static void ditBonjour() {
		System.out.println("Bonjour");
		
	}

}
