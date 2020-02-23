package fr.eni.ecoleeni.guessnumber;

import java.util.Random;
import java.util.Scanner;

public class Launcher {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int rnd = (int)(Math.random() * 100)+1;
		int nb;
		
		System.out.println(rnd);
		
		System.out.println("Hello, please guess a number");
		
		
		
		do {
			nb=sc.nextInt();
			sc.nextLine();
			if (nb > rnd) {
				System.out.println("Trop grand");
			} else if (nb < rnd) {
				System.out.println("Trop petit");
			}
		}while(nb != rnd);
		
		System.out.println("GG");
		

	}

}
