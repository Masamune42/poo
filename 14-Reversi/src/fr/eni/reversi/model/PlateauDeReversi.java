package fr.eni.reversi.model;

public class PlateauDeReversi {
	// TODO : Revoir les conditions de boucles : le bouclage prend trop de temps en
	// fin de partie lors des vérifs (tester)
	// TODO : Revoir la manière dont on retourne les pions : ne pas mettre en
	// mémoire les coordonnées des pions mais retenir la direction, retourner les
	// pions ensuite dans poser
	Pion[][] tabPion;
	int[] coordLigne = new int[20];
	int[] coordColonne = new int[20];
	int nbRetourne = 0;

	/**
	 * Constructeur qui initialise le plateau
	 */
	public PlateauDeReversi() {
		tabPion = new Pion[8][8];
		for (int i = 0; i < tabPion.length; i++) {
			for (int j = 0; j < tabPion[0].length; j++) {
				if (i == 3 && j == 3 || i == 4 && j == 4) {
					tabPion[i][j] = Pion.BLANC;
				} else if (i == 3 && j == 4 || i == 4 && j == 3) {
					tabPion[i][j] = Pion.NOIR;
				} else {
					tabPion[i][j] = Pion.LIBRE;
				}
			}
		}
	}

	/**
	 * Affiche le tableau ainsi que le nombre de pions de chaque couleur sur
	 * celui-ci
	 */
	public void afficher() {
		System.out.println(Pion.NOIR.getNombre() + " ●");
		System.out.println(Pion.BLANC.getNombre() + " o");

		System.out.print(" ");
		for (int i = 0; i < tabPion.length; i++) {
			System.out.print(" " + (i + 1));
		}

		System.out.println();

		int ligne = 1;
		for (Pion[] pions : tabPion) {
			System.out.print(ligne++ + " ");
			for (Pion pion : pions) {
				System.out.print(pion.getSymbole() + " ");
			}
			System.out.println();
		}
	}

	/**
	 * Test si le joueur peut poser un pion qui va retourner au moins un pion
	 * adverse
	 * 
	 * @param pion
	 *            couleur du pion
	 * @param ligne
	 *            numéro de ligne
	 * @param colonne
	 *            numéro de colonne
	 * @return le nombre de pion que l'on peut retourner
	 */
	public int tester(Pion pion, int ligne, int colonne) {
		nbRetourne = 0;

		// test si on a choisi une case libre
		if (tabPion[ligne][colonne] == Pion.LIBRE) {
			// On observe tout autour du pion posé s'il y a un pion adverse
			// On ne vérifie pas les cases en dehors du tableau
			for (int i = -1; i <= 1; i++) {
				for (int j = -1; j <= 1; j++) {
					if ((ligne + i) >= 0 && (ligne + i) < tabPion.length && (colonne + j) >= 0
							&& (colonne + j) < tabPion[0].length) {
						if (tabPion[ligne + i][colonne + j] == pion.autrePion()) {
							// nbRetourne = 0;
							// System.out.println((ligne + i + 1) + " " + (colonne + j + 1));

							// Création de tableaux temporaires qui vont recuillir les valeurs
							// des bons choix
							int[] coordLigneTemp = new int[20];
							int[] coordColonneTemp = new int[20];
							int index = 0;

							// Création d'une variable pour ligne et colonne
							int i2 = i;
							int j2 = j;
							boolean test = false;

							// Ajout au tableau des coordonnées du pion opposé trouvé
							coordLigneTemp[index] = ligne + i;
							coordColonneTemp[index] = colonne + j;
							// Incrémentation du compteur index indiquant où on en est dans la tableau
							index++;

							do {
								// A chaque tour de boucle, on continue dans la direction dont
								// on a trouvé un pion opposé
								i2 += i;
								j2 += j;

								if (ligne + i2 >= 0 && (ligne + i2) < tabPion.length && (colonne + j2) >= 0
										&& (colonne + j2) < tabPion[0].length) {
									// Si on trouve un autre pion on ajoute ses coordonnées au tableau temp
									if (tabPion[ligne + i2][colonne + j2] == pion.autrePion()) {

										// System.out.println(" i = " + (ligne + i2) + " j = " + (ligne + j2));
										coordLigneTemp[index] = ligne + i2;
										coordColonneTemp[index] = colonne + j2;
										// nbRetourne++;
										index++;

									}
									// Si on trouve un pion de notre couleur, on peut ajouter au tableau de
									// coordonnées
									// les coordonnées temp et on renvoie true pour sortir de la boucle
									if (tabPion[ligne + i2][colonne + j2] == pion) {
										test = true;
										for (int k = nbRetourne; k < nbRetourne + index; k++) {
											coordColonne[k] = coordColonneTemp[k - nbRetourne];
											coordLigne[k] = coordLigneTemp[k - nbRetourne];
										}
										nbRetourne += index;
									}
									// Si on rencontre une case vide, on renvoie true pour sortir de la boucle
									if (tabPion[ligne + i2][colonne + j2] == Pion.LIBRE) {
										test = true;
									}
								}
							} while (!test);

						}

					}

				}
			}
		}

		return nbRetourne;
	}

	/**
	 * Test si on peut jouer au moins un pion
	 * 
	 * @param pion
	 *            couleur du pion
	 * @return true si on peut jouer, sinon false
	 */
	public boolean peutJouer(Pion pion) {
		for (int i = 0; i < tabPion.length; i++) {
			for (int j = 0; j < tabPion.length; j++) {
				if (tester(pion, i, j) > 0) {
					return true;
				}
			}
		}

		return false;

	}

	/**
	 * Pose un pion et retourne les pions mémorisés dans le tableau de pions
	 * 
	 * @param pion
	 *            couleur du pion
	 * @param ligne
	 *            ligne
	 * @param colonne
	 *            colonne
	 */
	public void poser(Pion pion, int ligne, int colonne) {
		// On appelle tester pour vérifier que l'on va retourner au moins un pion
		// Sert aussi à mémoriser les coordonnées dans le tableau
		if (tester(pion, ligne, colonne) > 0) {
			// on pose notre pion sur l'emplacement voulu
			tabPion[ligne][colonne] = pion;
			// Incrémentation du compteur du pion de notre couleur
			pion.setNombre(pion.getNombre() + 1);
			// On va boucler dans le tableau pour obtenir les coordonnées des pions à
			// retourner
			// A chaque fois on actualise le nombre de pièces présentes
			for (int i = 0; i < nbRetourne; i++) {
				// System.out.println(coordLigne[i] + " " +coordColonne[i]);
				tabPion[coordLigne[i]][coordColonne[i]] = pion;
				pion.setNombre(pion.getNombre() + 1);
				pion.autrePion().setNombre(pion.autrePion().getNombre() - 1);
				;
			}

		} else {
			// Si on ne peut pas retourner de pion (inclus si on a pas posé sur une case
			// libre)
			System.out.println("Choisir une autre case");
		}
	}

	/**
	 * Change automatiquement de joueur à chaque fois que l'un à retourner au moins
	 * un pion
	 * 
	 * @param pion
	 *            couleur du pion joué
	 * @return la couleur opposé du pion si le joueur a joué, sinon refait jouer le
	 *         même
	 */
	public Pion jouer(Pion pion) {
		if (nbRetourne > 0) {
			return pion.autrePion();
		} else {
			return pion;
		}

	}

}
