package fr.eni.ecoleeni.shootingstar;

public class Launcher {

	public static void main(String[] args) {
		// line(5);
		System.out.println();
		// square(8);
		System.out.println();
		//emptySquare(5);
		System.out.println();
		triangle(5);

	}

	private static void triangle(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j <= i) {
					System.out.print('*');
				} else {
					System.out.print(' ');
				}

			}
			System.out.println();
		}
		
	}

	public static void line(int n) {
		for (int i = 0; i < n; i++) {
			System.out.print('*');
		}

		System.out.println();

	}

	public static void square(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print('*');
			}
			System.out.println();
		}

	}

	public static void emptySquare(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j == 0 || j == n - 1 || i == 0 || i == n - 1) {
					System.out.print('*');
				} else {
					System.out.print(' ');
				}

			}
			System.out.println();
		}

	}

}
