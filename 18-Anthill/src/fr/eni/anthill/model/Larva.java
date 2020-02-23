package fr.eni.anthill.model;

import java.util.Random;

public class Larva extends Ant {
	String larvaType;
	protected int type;
	
	public Larva() {
		super();
		Random rgen = new Random(); // Random number generator
		age = 0;
		maxAge = 10;
		int randomPosition = rgen.nextInt(20);
		if(randomPosition == 0) {
			System.out.println("It's a Queen !");
		} else if(randomPosition == 1 || randomPosition == 2) {
			System.out.println("It's a Male !");
		} else {
			System.out.println("It's a Worker !");
		}
		
		
	}
}
