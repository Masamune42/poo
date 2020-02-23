package fr.formation;

import java.util.Scanner;

import javax.swing.text.StyledEditorKit.BoldAction;

/**
 * Jeu de bataille navale
 * 
 * @author Alexandre Caignard
 *
 */
public class BatailleNavale {

	// constantes de taille de grille
	static final Integer HAUTEUR = 10;
	static final Integer LARGEUR = 10;
	// constantes des symboles
	static final Character INCONNU = '?';
	static final Character EAU = '~';
	static final Character TOUCHE = 'x';
	// grilles
	static Character[][] grilleTirs = new Character[HAUTEUR][LARGEUR];
	static Character[][] grilleBateaux = new Character[HAUTEUR][LARGEUR];
	// liste de bateaux avec : (0) -> nom du bateau, (1) -> taille, (2) -> lettre
	// associ�e sur le tableau
	static String[][] listeBateaux = { { "destroyer", "2", "d" }, { "light cruiser", "3", "l" },{ "heavy cruiser", "4", "h" } , { "battleship", "5", "b" }};
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		// On initialise les grilles
		InitGrilles();
		// On place nos bateaux sur la grille
		placerBateaux();
		do {
			// Affiche la grille des tirs r�alis�s
			afficherGrilleTirs();
			joue();

		} while (!gagne());

		// Fin du game
		afficherGrilleTirs();
		System.out.println("Partie termin�e ! ");

	}

	/**
	 * Initialisation des grilles
	 */
	private static void InitGrilles() {
		for (int i = 0; i < grilleBateaux.length; i++) {
			for (int j = 0; j < grilleBateaux.length; j++) {
				// i -> num�ro de ligne, j -> num�ro de colonne
				grilleTirs[i][j] = INCONNU;
				// La grille des bateaux est inialis�e avec de l'eau partout
				grilleBateaux[i][j] = EAU;
			}
		}

	}

	/**
	 * V�rifie les conditions de victoire
	 * 
	 * @return un bool�en true si victoire, sinon false
	 */
	private static boolean gagne() {
		Boolean gagne = true;
		// On v�rifie chaque case du tableau et si il reste la lettre d'un seul bateau
		// dans la grille, on continue la partie
		for (int i = 0; i < HAUTEUR; i++) {
			for (int j = 0; j < LARGEUR; j++) {
				if (grilleBateaux[i][j] != EAU && grilleBateaux[i][j] != TOUCHE) {
					gagne = false;
				}
			}
		}
		return gagne;
	}

	/**
	 * Effectue un tour de jeu classique
	 */
	private static void joue() {

		// On entre les coordonn�es du tir
		Integer coordTir[] = tirer();
		// On v�rifie si le tir touche et on l'affiche sur les 2 grilles
		verifTir(coordTir);

	}

	/**
	 * V�rifie que le tir a touch�
	 * 
	 * @param coordTir Coordonn�es du tir
	 */
	private static void verifTir(Integer[] coordTir) {
		System.out.println("Tir de coordonn�es : [" + coordTir[0] + "," + coordTir[1] + "]");

		// Si on a bien tir� sur une case n'�tant pas de l'eau
		if (grilleBateaux[coordTir[0]][coordTir[1]] != EAU) {
			// On indique la case touch�e par un 'x'
			grilleTirs[coordTir[0]][coordTir[1]] = TOUCHE;
			verifToucheCoule(coordTir);
			grilleBateaux[coordTir[0]][coordTir[1]] = TOUCHE;

		} else {
			// Si le tir est rat�, on l'indique sur la grille des tirs
			grilleTirs[coordTir[0]][coordTir[1]] = EAU;
			System.out.println("Plouf !");
		}

	}

	/**
	 * V�rifie si un bateau de la grille est coul�
	 * 
	 * @param coordTir coordonn�es du tir
	 */
	public static void verifToucheCoule(Integer[] coordTir) {
		for (int i = 0; i < listeBateaux.length; i++) {
			if (grilleBateaux[coordTir[0]][coordTir[1]].equals(listeBateaux[i][2].charAt(0))) {
				Integer dmgBateau = Integer.parseInt(listeBateaux[i][1]) - 1;
				listeBateaux[i][1] = dmgBateau.toString();
				if (dmgBateau == 0) {
					System.out.println("Touch� coul� !");
				} else {
					System.out.println("Touch� !");
				}

			}
		}
	}

	/**
	 * Demande de tirer sur une case de la grille des bateaux
	 * 
	 * @return les coordonn�es du tir
	 * 
	 */
	private static Integer[] tirer() {
		// On demande la saisie de coordonn�es et on renvoie le tout dans un tableau
		return new Integer[] { saisieCoordAlpha("Ligne ? : "), saisieCoord("Colonne ? : ") };
	}

	private static Integer saisieCoordAlpha(String string) {
		System.out.println(string);
		Character lettre = sc.nextLine().toUpperCase().charAt(0);
		Integer valeur = (int) (lettre) - 65;
		return valeur;
	}

	/**
	 * Placement de tous les bateaux sur leur grille
	 */
	private static void placerBateaux() {

		Integer ligne = 0;
		Integer colonne = 0;
		
		afficheGrilleBateaux();

		// Pour chaque bateau pr�sent
		for (int k = 0; k < listeBateaux.length; k++) {
			// On d�clare la taille d'un bateau dans une variable
			Integer tailleBateau = Integer.parseInt(listeBateaux[k][1]);
			Boolean bateauPlace;
			do {
				do {
					bateauPlace = true;
					System.out.println("Placer votre " + listeBateaux[k][0] + " de taille " + tailleBateau);

					// Coordonn�es du bateau
					ligne = saisieCoordAlpha("Ligne :");
					colonne = saisieCoord("Colonne : ");

				} while ((ligne < 0 || ligne >= HAUTEUR) || (colonne < 0 || colonne >= LARGEUR));
				// Tant que l'utilisateur n'a pas entr� de coordonn�es coh�rantes

				System.out.println("vers quelle direction voulez-vous le placer?");
				System.out.println("Gauche (g)? Droite (d)? Haut(h)? Bas(b)?");

				// On choisit la direction du bateau

				switch (sc.nextLine().toLowerCase()) {
				case "g":

					// Si on rencontre une case autre que de l'eau pour placer le bateau
					for (int i = 0; i < tailleBateau; i++) {
						if (colonne - i < 0) {
							bateauPlace = false;
						} else {
							if (grilleBateaux[ligne][colonne - i] != EAU) {
								bateauPlace = false;
							}

						}
					}

					// Si on a estim� que le bateau pouvait �tre plac�, on le fait
					if (bateauPlace) {
						for (int i = 0; i < tailleBateau; i++) {
							grilleBateaux[ligne][colonne - i] = listeBateaux[k][2].charAt(0);
						}
					}

					break;
				case "d":

					// Si on rencontre une case autre que de l'eau pour placer le bateau
					for (int i = 0; i < tailleBateau; i++) {
						if (colonne + i >= LARGEUR) {
							bateauPlace = false;
						} else {
							if (grilleBateaux[ligne][colonne + i] != EAU) {
								bateauPlace = false;
							}

						}
					}

					if (bateauPlace) {
						for (int i = 0; i < tailleBateau; i++) {
							grilleBateaux[ligne][colonne + i] = listeBateaux[k][2].charAt(0);
						}
					}

					break;
				case "h":
					// Si on rencontre une case autre que de l'eau pour placer le bateau
					for (int i = 0; i < tailleBateau; i++) {
						if (ligne - i < 0) {
							bateauPlace = false;
						} else {
							if (grilleBateaux[ligne - i][colonne] != EAU) {
								bateauPlace = false;
							}

						}
					}

					if (bateauPlace) {
						for (int i = 0; i < tailleBateau; i++) {
							grilleBateaux[ligne - i][colonne] = listeBateaux[k][2].charAt(0);
						}
					}

					break;
				case "b":
					// Si on rencontre une case autre que de l'eau pour placer le bateau
					for (int i = 0; i < tailleBateau; i++) {
						if (ligne + i >= HAUTEUR) {
							bateauPlace = false;
						} else {
							if (grilleBateaux[ligne + i][colonne] != EAU) {
								bateauPlace = false;
							}

						}
					}
					if (bateauPlace) {
						for (int i = 0; i < tailleBateau; i++) {
							grilleBateaux[ligne + i][colonne] = listeBateaux[k][2].charAt(0);
						}
					}

					break;
				default:
					System.out.println("R�essayez!");
					bateauPlace = false;
					break;
				}
			} while (!bateauPlace);

			// Affiche les bateaux plac�s
			afficheGrilleBateaux();
		}

	}

	/**
	 * Demande de saisir un entier
	 * 
	 * @param string Phrase indiquant la valeur attendue
	 * @return La valeur enti�re entr�e
	 */
	private static Integer saisieCoord(String string) {
		System.out.println(string);
		Integer valeur = sc.nextInt();
		sc.nextLine();
		return valeur;
	}

	/**
	 * Affiche la grille des tirs effectu�s
	 */
	private static void afficherGrilleTirs() {
		Integer i = 0;

		System.out.print("  ");
		for (int j = 0; j < grilleBateaux.length; j++) {
			System.out.print(j + " ");
		}

		System.out.println();

		for (Character[] grilleTirs1d : grilleTirs) {
			System.out.print((char) ('A' + i++) + " ");
			for (Character caseTab : grilleTirs1d) {
				System.out.print(caseTab + " ");
			}
			System.out.println("");
		}

	}

	public static void afficheGrilleBateaux() {
		
		Integer i = 0;

		System.out.print("  ");
		for (int j = 0; j < grilleBateaux.length; j++) {
			System.out.print(j + " ");
		}

		System.out.println();
		
		for (Character[] grilleTirs1d : grilleBateaux) {
			System.out.print((char) ('A' + i++) + " ");
			for (Character caseTab : grilleTirs1d) {
				System.out.print(caseTab + " ");
			}
			System.out.println("");
		}
	}

}
