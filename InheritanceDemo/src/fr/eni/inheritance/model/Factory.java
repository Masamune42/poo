package fr.eni.inheritance.model;

public class Factory extends Building {
	public void makeItems() {
		System.out.println("Factory at address " + address + " is making items"); // super est implicite
	}

	@Override
	public void setSurface(int surface) {
		if (surface < 100) {
			System.out.println("Surface cannot be under 100");
		} else {
			//super.setSurface(surface);
			super.surface = surface;
		}
	}
}
