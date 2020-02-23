package fr.eni.polymorphism.model;

public class Rectangle extends Shape {

	protected float length;
	protected float width;

	public Rectangle(String color, float length, float width) {
		super(color);
		this.length = length;
		this.width = width;
	}

	@Override
	public float getArea() {

		return length * width;

	}
	
	@Override
	public String toString() {
		return " length : "+ length + " width : "+ width + " " + super.toString();
	}

}
