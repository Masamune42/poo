package eni.fr.enumeration;

public class Launcher {

	public static void main(String[] args) {
		System.out.println("Énumération Démo");

		Saison maSaison = Saison.HIVER;
		System.out.println(maSaison);

		// for each
		for (Saison s : Saison.values()) {
			System.out.println(s);
		}
		if (maSaison == Saison.HIVER) {
			System.out.println("Il fait froid");
		} else {
			System.out.println("Il fait chaud");
		}
		switch (maSaison) {
		case HIVER:
			System.out.println("Il fait froid");
			break;
		case ETE:
		case AUTOMNE:
		case PRINTEMPS:
			System.out.println("Il fait chaud");
		}

		for (int i = 0; i < 10; i++) {
			if (i == 5) {
				//break;
				continue;
			}
			System.out.println(i);
			
		}
	}
}
