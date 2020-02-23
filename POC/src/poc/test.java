package poc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		JourPlus unJour = JourPlus.DIMANCHE;

		System.out.println("numero de " + unJour + " : " + unJour.ordinal());
		System.out.println(unJour + " : " + unJour.action());

		for (JourPlus jour : JourPlus.values())
			System.out.println("nombre d'heures de " + jour + " : " + jour.getNbHeures());
	}
}
