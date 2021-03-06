package fr.eni.ecoleeni.oop.model;

public class Boat {
	// instance variable
	// ==attribute
	// ==property
	// ==field
	private String name;
	private int size;
	private Captain captain;

	public Boat() {

	}

	public Boat(String name, int size) {
		// this instance courante
		this.name = name;
		this.size = size;
	}

	// m�thodes d'instance
	public void goForward() {
		System.out.println("Go forward !");
	}

	public void sink() {
		System.out.println("Glouglou!");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Captain getCaptain() {
		return captain;
	}

	public void setCaptain(Captain captain) {
		this.captain = captain;
	}
	
	

}
