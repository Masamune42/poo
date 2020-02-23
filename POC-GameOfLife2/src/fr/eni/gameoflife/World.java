package fr.eni.gameoflife;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class World {

	Cell[][] tabCell;

	public World(int nbColumns, int nbRows) {
		tabCell = new Cell[nbRows][nbColumns];
		for (int i = 0; i < tabCell.length; i++) {
			for (int j = 0; j < tabCell[0].length; j++) {
				Random random = new Random();
				if (random.nextBoolean()) {
					tabCell[i][j] = new AliveCell();
				} else {
					tabCell[i][j] = new DeadCell();
				}
			}
		}
	}

	public World(String f) {
		File file = new File(f);

		try {
			Scanner scanner = new Scanner(file);
			String str = "";

			// Compteur de ligne
			int lineNum = 1;
			// Lecture du fichier ligne par ligne
			// tant qu'on a une prochaine ligne
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				lineNum++;
				// On définit size qui va contenir les 2 dimensions de tabCell
				int[] size = new int[2];
				int cptSize = 0;
				// On cherche la ligne avec la taille du tableau 2D voulu
				if (line.startsWith("x")) {
					int cpt = 0;
					// On va regarder chaque caractère jusqu'à ce qu'on rencontre la lettre 'r'
					// du mot "rule"
					for (int i = 0; line.charAt(i) != 'r'; i++) {
						// Si le caractère est un chiffre, on l'ajoute à str
						if (Character.isDigit(line.charAt(i))) {
							str += line.charAt(i);
						} else if (str != "") {
							// Si on rencontre un caractère différent d'un chiffre
							// on va convertir str en int et l'ajouter à size[]
							cpt = Integer.parseInt(str);
							size[cptSize++] = cpt;
							str = "";
						}

					}

					// System.out.println(size[0]);
					// System.out.println(size[1]);

					tabCell = new Cell[size[1]][size[0]];
					line = "";
					while (scanner.hasNextLine()) {
						line += scanner.nextLine();
					}

					String[] splitted = line.split("[$]");

					// System.out.println(line);
					for (int i = 0; i < splitted.length; i++) {
						splitted[i] += "$";
					}

					// Affichage
					for (String s : splitted)
						System.out.println(s);

					for (int ligne = 0; ligne < splitted.length; ligne++) {

						// System.out.println(lineNum + " " + line);

						cpt = 0;
						int cptRemplissage = 0;

						// On va regarder chaque caractère jusqu'à ce que la ligne soit finie
						for (int i = 0; i < splitted[ligne].length(); i++) {
							// Si le caractère est un chiffre, on l'ajoute à str
							if (Character.isDigit(splitted[ligne].charAt(i))) {
								str += splitted[ligne].charAt(i);
							} else if (str != "") {
								// Si on rencontre un caractère différent d'un chiffre
								// on va convertir str en int et l'ajouter à size[]
								//System.out.println(str);
								cpt = Integer.parseInt(str);
								str = "";
							} else if (str.equals("")) {
								cpt = 1;
							}

							// if(cpt > 1 && i == tabCell[ligne].length-1) {
							// for (int j = 0; j < tabCell[ligne].length; j++) {
							// tabCell[ligne][j] = new DeadCell();
							// ++ligne;
							// }
							// cptRemplissage = 0;
							// cpt = 0;
							// }
							
							for (int j = 0; j < tabCell[ligne].length; j++) {
								if(tabCell[ligne][j] != null) {
									cptRemplissage = j;
									
								}
							}
							
							//System.out.println(cptRemplissage);

							if (splitted[ligne].charAt(i) == 'o') {
								for (int j = 0; j < cpt; j++) {
									tabCell[ligne][j+cptRemplissage] = new AliveCell();
//									cptRemplissage++;
								}
								//cptRemplissage += cpt;
								cpt = 0;
							}

							if (splitted[ligne].charAt(i) == 'b') {
								for (int j = 0; j < cpt; j++) {
									tabCell[ligne][j+cptRemplissage] = new DeadCell();
//									cptRemplissage++;
								}
								//cptRemplissage += cpt;
								cpt = 0;
							}

							if (splitted[ligne].charAt(i) == '$') {

								for (int k = ligne; k < cpt+ligne; k++) {
									if (cptRemplissage < tabCell[ligne].length) {
										for (int j = 1; j+cptRemplissage < tabCell[ligne].length; j++) {
											tabCell[ligne][j+cptRemplissage] = new DeadCell();
										}
										// cptRemplissage = 0;
									}
								}
								
							}

						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			// handle this
		}
	}

	void newGeneration() {
		// Compteur de cellules voisines
		int cptCell;
		// Création d'un tableau temporaire de même taille que tabCell
		Cell[][] tabCellTemp = new Cell[tabCell.length][tabCell[0].length];

		// for (int i3 = 0; i3 < tabCellTemp.length; i3++) {
		// for (int j3 = 0; j3 < tabCellTemp[0].length; j3++) {
		// tabCellTemp[i3][j3] = tabCell[i3][j3];
		// }
		// }

		// int[][] tabCellTempCpt = new int[5][5];
		for (int i = 0; i < tabCell.length; i++) {
			for (int j = 0; j < tabCell[0].length; j++) {
				cptCell = 0;
				for (int i2 = -1; i2 <= 1; i2++) {
					for (int j2 = -1; j2 <= 1; j2++) {
						if (j + j2 >= 0 && j + j2 < tabCell[0].length && i + i2 >= 0 && i + i2 < tabCell.length) {

							if (tabCell[i + i2][j + j2].isAlive() && ((j + j2 != j) || (i + i2 != i))) {
								cptCell++;
							}
						}
					}
				}
				// tabCellTempCpt[i][j] = cptCell;

				tabCellTemp[i][j] = tabCell[i][j].newGeneration(cptCell);

			}

		}

		tabCell = tabCellTemp;

		// for (int i = 0; i < tabCellTemp.length; i++) {
		// for (int j = 0; j < tabCellTemp[0].length; j++) {
		// tabCell[i][j] = tabCellTemp[i][j];
		// }
		// }

		// for (int[] cells : tabCellTempCpt) {
		// for (int cell : cells) {
		// System.out.print(cell + " ");
		// }
		// System.out.println();
		// }
	}

	@Override
	public String toString() {
		String theWorld = "";
		for (Cell[] cells : tabCell) {
			for (Cell cell : cells) {
				System.out.print(cell.getAsString() + " ");
			}
			System.out.println();
		}
		return theWorld;
	}

}
