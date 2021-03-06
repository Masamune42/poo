package fr.eni.ecoleeni.calendrier;

import java.util.GregorianCalendar;
import java.util.Locale;

public class Launcher {
	public static void main(String[] args) {
		int annee = 2019, mois = 8;

		afficherMois(annee, mois);
	}

	/**
	 * Affiche un calendrier
	 * @param annee Ann�e renseign�e
	 * @param mois Mois renseign�
	 */
	private static void afficherMois(int annee, int mois) {
		// Cr�ation d'un calendrier avec le mois et l'ann�e renseign�s
		GregorianCalendar cal = new GregorianCalendar(annee, mois, 1);

		// R�cup�ration du nom du mois + affichage
		String monthStr = cal.getDisplayName(GregorianCalendar.MONTH, GregorianCalendar.LONG_FORMAT, Locale.FRANCE);
		System.out.println(" * " + monthStr + "  " + cal.get(GregorianCalendar.YEAR) + " *");

		System.out.println("L  Ma Me J  V  S  D");

		// Placement de base pour commencer l'affichage
		// Suivant le jour de la semaine
		for (int i = 2; i <= cal.get(GregorianCalendar.DAY_OF_WEEK) - 1; i++) {

			System.out.print("   ");

		}
		// Comme les mois commen�ant par dimanche (= 1) et qu'il n'est pas compris dans
		// la boucle pr�c�dente
		// On g�re son cas � part : 6 fois des espaces.
		if (cal.get(GregorianCalendar.DAY_OF_WEEK) == 1) {
			for (int i = 1; i <= 6; i++) {
				System.out.print("   ");

			}
		}

		// nb de jour max dans le mois en cours
		int maxDay = cal.getActualMaximum(GregorianCalendar.DATE);

		// Affichage
		for (int i = 0; i < maxDay; i++) {
			if (i < 9) {
				System.out.print("0");
			}
			// On passe une ligne apr�s avoir �crit pour un dimanche
			if ((cal.get(GregorianCalendar.DAY_OF_WEEK)) - 1 % 7 == 0) {
				System.out.println(cal.get(GregorianCalendar.DAY_OF_MONTH) + " ");
			} else {
				System.out.print(cal.get(GregorianCalendar.DAY_OF_MONTH) + " ");
			}

			cal.add(GregorianCalendar.DATE, 1);
		}

	}

}
