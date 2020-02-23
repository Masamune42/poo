package fr.eni.polymorphism.launcher;


import fr.eni.polymorphism.model.Rectangle;
import fr.eni.polymorphism.model.Shape;
import fr.eni.polymorphism.model.Triangle;

public class Launcher {

	public static void main(String[] args) {
		Shape s1, s2;
		s1 = new Rectangle("red", 10, 4);
		s2 = new Triangle("blue", 5, 8);

		System.out.println(s1);

		System.out.println("Area is " + s1.getArea());

		System.out.println(s2);

		System.out.println("Area is " + s2.getArea());

	}

}
