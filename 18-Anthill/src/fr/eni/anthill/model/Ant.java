package fr.eni.anthill.model;

public abstract class Ant {
	protected static int cptAnt = 1;
	protected int identifier;
	protected int age;
	protected int maxAge;

	public Ant() {
		identifier = cptAnt++;
	}
	
	public void becomeOlder() {
		age++;
	}
	
	public boolean isAlive() {
		if(age == maxAge) {
			return false;
		} else {
			return true;
		}
		
	}

	public int getIdentifier() {
		return identifier;
	}

	public void setIdentifier(int identifier) {
		this.identifier = identifier;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}

}
