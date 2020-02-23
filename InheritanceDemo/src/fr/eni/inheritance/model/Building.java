package fr.eni.inheritance.model;

public class Building {
	protected int surface;
	protected String address;

	public Building() {
		surface = 100;
		address = "Unknown address";
	}

	public Building(String address) {
		surface = 100;
		this.address = address;
	}

	public Building(int surface, String address) {
		this.surface = surface;
		this.address = address;
	}

	public void doBuild() {
		System.out.println("My building at " + address + " is being built");
	}

	public void doRenovate() {
		System.out.println("Renovating " + surface + " m²");
	}

	public int getSurface() {
		return surface;
	}

	public void setSurface(int surface) {
		this.surface = surface;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Building " + address + " " + surface + " m²";
	}
	
	

}
