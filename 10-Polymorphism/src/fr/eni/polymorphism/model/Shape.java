package fr.eni.polymorphism.model;

public abstract class Shape {

	protected String color;

	public Shape(String color) {
		this.color = color;
	}

	abstract public float getArea();

	@Override
	public String toString() {
		return "color : " + color;
	}

}
