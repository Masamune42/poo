package fr.eni.gameoflife;

public class AliveCell implements Cell {

	@Override
	public Cell newGeneration(int nbNeighbours) {
		if (nbNeighbours < 2) {
			return new DeadCell();
		}
		if (nbNeighbours == 2 || nbNeighbours == 3) {
			return this;
		} else {
			return new DeadCell();
		}

	}

	@Override
	public String getAsString() {
		return "0";
	}

	@Override
	public boolean isAlive() {
		return true;
	}

}
