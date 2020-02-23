package fr.eni.anthill.launcher;

import java.util.Scanner;

import fr.eni.anthill.model.Anthill;


public class Launcher {

	// TODO : PAS FINI !
	public static void main(String[] args) {
		Anthill anthill = new Anthill(0, 1, 0, 0);
		
		 Scanner scanner = new Scanner(System.in);
		    String readString = scanner.nextLine();
		    while(readString!=null) {
		        System.out.println(readString);

		        if (readString.isEmpty()) {
		            anthill.moreAge();
		            
		        }

		        if (scanner.hasNextLine()) {
		            readString = scanner.nextLine();
		        } else {
		            readString = null;
		        }
		    }
		
		
	}

}
