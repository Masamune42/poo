package fr.eni.gameoflifecorrection.launcher;

import java.util.Scanner;

import fr.eni.gameoflifecorrection.exception.NegativeValueException;
import fr.eni.gameoflifecorrection.model.World;

public class Launcher {

	public static void main(String[] args) {
		int row = 0;
		int column=0;
		Scanner sc = new Scanner(System.in);
		boolean hasError = false;

		do {
			System.out.println("Enter the number of columns :");
			String colonneStr = sc.nextLine();
			try {
				column = Integer.parseInt(colonneStr);
				if (column < 0) {
					throw new NegativeValueException();
				}
				hasError = false;
			} catch (NumberFormatException e) {
				System.out.println("This is not a number");
				hasError = true;
			} catch (NegativeValueException e) {
				System.out.println(e.getMessage());
				hasError = true;
			}
		} while (hasError);
		
		do {
			System.out.println("Enter the number of rows :");
			String rowStr = sc.nextLine();
			try {
				row = Integer.parseInt(rowStr);
				if (row < 0) {
					throw new NegativeValueException();
				}
				hasError = false;
			} catch (NumberFormatException e) {
				System.out.println("This is not a number");
				hasError = true;
			} catch (NegativeValueException e) {
				System.out.println(e.getMessage());
				hasError = true;
			}
		} while (hasError);

		World world = new World(column, row);
		System.out.println(world);

		for (int i = 0; i < 1000; i++) {
			world.newGeneration();
			System.out.println(world);

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		sc.close();
	}

}
