package fr.eni.gameoflife;

public interface Cell {
	// Return the next generation cell depending on the number of neighbours.
	Cell newGeneration(int nbNeighbours);

	// Return a String representation of the cell state.
	String getAsString();

	// Return if the cell is currently alive or not.
	boolean isAlive();

}
