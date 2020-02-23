package fr.eni.livraisonups.model;

public class Lama extends Animal {

	public Lama(String name) {
		super(name);
	}

	@Override
	public void feed() {
		System.out.println("Pshiiite je mange");
		
	}

}
