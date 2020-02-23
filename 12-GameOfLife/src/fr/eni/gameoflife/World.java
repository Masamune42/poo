package fr.eni.gameoflife;

import java.util.Random;

public class World {

	Cell[][] tabCell;

	public World(int nbColumns, int nbRows) {
		tabCell = new Cell[nbColumns][nbRows];
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

	void newGeneration() {
		// Compteur de cellules voisines
		int cptCell;
		Cell[][] tabCellTemp = new Cell[tabCell.length][tabCell[0].length];
		// Création d'un tableau temporaire de même taille que tabCell
		for (int i3 = 0; i3 < tabCellTemp.length; i3++) {
			for (int j3 = 0; j3 < tabCellTemp[0].length; j3++) {
				tabCellTemp[i3][j3] = tabCell[i3][j3];
			}
		}

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
		
//		for (int i = 0; i < tabCellTemp.length; i++) {
//			for (int j = 0; j < tabCellTemp[0].length; j++) {
//				tabCell[i][j] = tabCellTemp[i][j];
//			}
//		}

//		for (int[] cells : tabCellTempCpt) {
//			for (int cell : cells) {
//				System.out.print(cell + " ");
//			}
//			System.out.println();
//		}
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
