package fr.eni.polymorphismdemo.launcher;

import fr.eni.polymorphismdemo.model.Cat;
import fr.eni.polymorphismdemo.model.CatLike;
import fr.eni.polymorphismdemo.model.Tiger;

public class Launcher {

	public static void main(String[] args) {
		System.out.println("Hello Polymorphism !");

		CatLike catlike1 = new CatLike();

		CatLike catlike2 = new Cat();

		CatLike catlike3 = new Tiger();

		CatLike[] catlikeArray = new CatLike[3];

		catlikeArray[0] = catlike1;
		catlikeArray[1] = catlike2;
		catlikeArray[2] = catlike3;

		for (CatLike c : catlikeArray) {
			if(c instanceof Cat) {
				System.out.println("This is a cat !");
				Cat cat = (Cat) c; // cast
				cat.miaou();
			}
			c.eat();
		}

	}

}
