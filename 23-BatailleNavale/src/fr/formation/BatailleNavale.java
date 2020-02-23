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
	// associée sur le tableau
	static String[][] listeBateaux = { { "destroyer", "2", "d" }, { "light cruiser", "3", "l" },{ "heavy cruiser", "4", "h" } , { "battleship", "5", "b" }};
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		// On initialise les grilles
		InitGrilles();
		// On place nos bateaux sur la grille
		placerBateaux();
		do {
			// Affiche la grille des tirs réalisés
			afficherGrilleTirs();
			joue();

		} while (!gagne());

		// Fin du game
		afficherGrilleTirs();
		System.out.println("Partie terminée ! ");

	}

	/**
	 * Initialisation des grilles
	 */
	private static void InitGrilles() {
		for (int i = 0; i < grilleBateaux.length; i++) {
			for (int j = 0; j < grilleBateaux.length; j++) {
				// i -> numéro de ligne, j -> numéro de colonne
				grilleTirs[i][j] = INCONNU;
				// La grille des bateaux est inialisée avec de l'eau partout
				grilleBateaux[i][j] = EAU;
			}
		}

	}

	/**
	 * Vérifie les conditions de victoire
	 * 
	 * @return un booléen true si victoire, sinon false
	 */
	private static boolean gagne() {
		Boolean gagne = true;
		// On vérifie chaque case du tableau et si il reste la lettre d'un seul bateau
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

		// On entre les coordonnées du tir
		Integer coordTir[] = tirer();
		// On vérifie si le tir touche et on l'affiche sur les 2 grilles
		verifTir(coordTir);

	}

	/**
	 * Vérifie que le tir a touché
	 * 
	 * @param coordTir Coordonnées du tir
	 */
	private static void verifTir(Integer[] coordTir) {
		System.out.println("Tir de coordonnées : [" + coordTir[0] + "," + coordTir[1] + "]");

		// Si on a bien tiré sur une case n'étant pas de l'eau
		if (grilleBateaux[coordTir[0]][coordTir[1]] != EAU) {
			// On indique la case touchée par un 'x'
			grilleTirs[coordTir[0]][coordTir[1]] = TOUCHE;
			verifToucheCoule(coordTir);
			grilleBateaux[coordTir[0]][coordTir[1]] = TOUCHE;

		} else {
			// Si le tir est raté, on l'indique sur la grille des tirs
			grilleTirs[coordTir[0]][coordTir[1]] = EAU;
			System.out.println("Plouf !");
		}

	}

	/**
	 * Vérifie si un bateau de la grille est coulé
	 * 
	 * @param coordTir coordonnées du tir
	 */
	public static void verifToucheCoule(Integer[] coordTir) {
		for (int i = 0; i < listeBateaux.length; i++) {
			if (grilleBateaux[coordTir[0]][coordTir[1]].equals(listeBateaux[i][2].charAt(0))) {
				Integer dmgBateau = Integer.parseInt(listeBateaux[i][1]) - 1;
				listeBateaux[i][1] = dmgBateau.toString();
				if (dmgBateau == 0) {
					System.out.println("Touché coulé !");
				} else {
					System.out.println("Touché !");
				}

			}
		}
	}

	/**
	 * Demande de tirer sur une case de la grille des bateaux
	 * 
	 * @return les coordonnées du tir
	 * 
	 */
	private static Integer[] tirer() {
		// On demande la saisie de coordonnées et on renvoie le tout dans un tableau
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

		// Pour chaque bateau présent
		for (int k = 0; k < listeBateaux.length; k++) {
			// On déclare la taille d'un bateau dans une variable
			Integer tailleBateau = Integer.parseInt(listeBateaux[k][1]);
			Boolean bateauPlace;
			do {
				do {
					bateauPlace = true;
					System.out.println("Placer votre " + listeBateaux[k][0] + " de taille " + tailleBateau);

					// Coordonnées du bateau
					ligne = saisieCoordAlpha("Ligne :");
					colonne = saisieCoord("Colonne : ");

				} while ((ligne < 0 || ligne >= HAUTEUR) || (colonne < 0 || colonne >= LARGEUR));
				// Tant que l'utilisateur n'a pas entré de coordonnées cohérantes

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

					// Si on a estimé que le bateau pouvait être placé, on le fait
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
					System.out.println("Réessayez!");
					bateauPlace = false;
					break;
				}
			} while (!bateauPlace);

			// Affiche les bateaux placés
			afficheGrilleBateaux();
		}

	}

	/**
	 * Demande de saisir un entier
	 * 
	 * @param string Phrase indiquant la valeur attendue
	 * @return La valeur entière entrée
	 */
	private static Integer saisieCoord(String string) {
		System.out.println(string);
		Integer valeur = sc.nextInt();
		sc.nextLine();
		return valeur;
	}

	/**
	 * Affiche la grille des tirs effectués
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
