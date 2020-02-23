package fr.eni.polymorphism.model;

public class Triangle extends Shape {

	protected float base;
	protected float height;

	public Triangle(String color, float length, float width) {
		super(color);
		this.base = length;
		this.height = width;
	}

	@Override
	public float getArea() {

		return (base * height * 0.5f);

	}
	
	@Override
	public String toString() {
		return " length : "+ base + " width : "+ height + " " + super.toString();
	}

}
