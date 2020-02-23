package fr.eni.ecoleeni.oop.model;

public class Captain {
	private String name;
	private int age;
	private Boat boat;
	
	public Captain() {
		
	}

	public Captain(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void getDrunk() {
		System.out.println("Getting drunk AF!");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if(age < 18) {
			System.out.println("Oops, underage");
			return;
		}
		this.age = age;
	}

	public Boat getBoat() {
		return boat;
	}

	public void setBoat(Boat boat) {
		this.boat = boat;
	}
	
	

}
