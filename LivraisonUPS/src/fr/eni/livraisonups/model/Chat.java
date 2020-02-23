package fr.eni.livraisonups.model;

public class Chat extends Animal {

	public Chat(String nom) {
		super(nom);
	}

	@Override
	public void feed() {
		System.out.println("Miaou miaou je mange");
		
	}

}
