package fr.eni.abstractdemo.launcher;

import java.util.Random;

import fr.eni.abstractdemo.model.Cat;
import fr.eni.abstractdemo.model.Catlike;
import fr.eni.abstractdemo.model.Tiger;

public class Launcher {
	public static void main(String[] args) {
		System.out.println("Abstract demo");
		
		Catlike[] randomCatlike = randomCatlike();
		
		for (Catlike c : randomCatlike) {
			c.hunt();
		}
	}
	
	static Catlike[] randomCatlike() {
		Catlike[] catlikes = new Catlike[10];
		
		for (int i = 0; i < catlikes.length; i++) {
			Random random = new Random();
			if (random.nextBoolean()) {
				catlikes[i]= new Cat();
			} else {
				catlikes[i]= new Tiger();
			}
			
			
		}
		return catlikes;
	}
}
