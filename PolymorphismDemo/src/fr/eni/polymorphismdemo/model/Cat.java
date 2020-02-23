package fr.eni.polymorphismdemo.model;

public class Cat extends CatLike {
	
	public void miaou() {
		System.out.println("MIAOU!");
	}
	
	@Override
	public void eat() {
		System.out.println("eating like a Cat");
	}

}
