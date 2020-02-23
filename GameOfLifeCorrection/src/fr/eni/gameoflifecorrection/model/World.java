package fr.eni.gameoflifecorrection.model;

import java.util.Random;

public class World {

	private Cell[][] cells;

	public World(int nbColumns, int nbRows) {

		cells = new Cell[nbColumns][nbRows];

		Random random = new Random();

		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[i].length; j++) {
				if (random.nextBoolean()) {
					cells[i][j] = new AliveCell();
				} else {
					cells[i][j] = new DeadCell();
				}

			}
		}

	}

	public void newGeneration() {
		Cell[][] tempCells = new Cell[cells.length][cells[0].length];

		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[i].length; j++) {
				// cell[i][j]

				int neighboursCount = 0;

				for (int u = -1; u <= 1; u++) {
					for (int v = -1; v <= 1; v++) {

						int xIndexOfNeightbours = i + u;
						int yIndexOfNeightbours = j + v;

						if (!(u == 0 && v == 0)) {
							if (xIndexOfNeightbours >= 0 && yIndexOfNeightbours >= 0
									&& xIndexOfNeightbours < cells.length && yIndexOfNeightbours < cells[0].length) {

								if (cells[xIndexOfNeightbours][yIndexOfNeightbours].isAlive()) {
									neighboursCount++;
								}

							}

						}

					}
				}

				// cell[i][j]
				tempCells[i][j] = cells[i][j].newGeneration(neighboursCount);
			}
		}

		this.cells = tempCells;
	}

	@Override
	public String toString() {
		String worldStr = "";
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[i].length; j++) {
				worldStr = worldStr + cells[i][j].getAsString();
			}
			worldStr = worldStr + "\n";
		}
		return worldStr;
	}

}
