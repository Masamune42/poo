package fr.eni.ecoleeni.multi;

public class Launcher {

	public static void main(String[] args) {
		
		System.out.print("* | ");
		for (int i = 1; i <= 5; i++) {
			System.out.print(i +" ");
		}
		
		System.out.println("\n---------------");
		
		for (int i = 1; i <= 10; i++) {
			System.out.print(i+ " | ");
			for (int j = 1; j <= 5; j++) {
				System.out.print((i * j) +" ");
			}
			System.out.println();
		}

	}

}
