package fr.eni.referenceproject.launcher;

public class Launcher {

	public static void main(String[] args) {
		
		int myVariable = 10;
		changeMyInt(myVariable);
		System.out.println(myVariable);
		
		Cat myCat = new Cat();
		myCat.name="Bob";
		
		changeCatName(myCat);
		
		System.out.println(myCat.name);
		System.out.println(myCat);
	}
	
	static void changeMyInt(int myInt) {
		myInt = 0;
	}
	
	static void changeCatName(Cat cat) {
		cat.name="Sombrero";
		
	}

}

class Cat{
	String name;
	
	@Override
	public String toString() {
		return "Miaou !" + this.name;
	}
}