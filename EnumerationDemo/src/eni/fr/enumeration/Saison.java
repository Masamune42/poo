package eni.fr.enumeration;

public enum Saison {

	PRINTEMPS(0, 10, 24), ETE(1, 15, 38), AUTOMNE(2, 5, 15), HIVER(3, -5, 12);

	private int index;
	private int minTemp;
	private int maxTemp;

	private Saison(int index, int minTemp, int maxTemp) {
		this.index = index;
		this.maxTemp = maxTemp;
		this.minTemp = minTemp;
	}

	public String getName() {
		switch (this) {
		case ETE:
			return "Été";

		case HIVER:
			return "Hiver";

		case AUTOMNE:
			return "Automne";

		case PRINTEMPS:
			return "Printemps";

		default:
			return "Unknown";
		}
	}

	public int getIndex() {
		return index;
	}

	public int getMinTemp() {
		return minTemp;
	}

	public int getMaxTemp() {
		return maxTemp;
	}
	
	@Override
	public String toString() {
		return "Saison " + (index + 1) + " " + getName() + " min : " + getMinTemp() + "°C - max : " + getMaxTemp() + "°C";
	}

}
