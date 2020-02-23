package fr.eni.exercisecollectionproject.model;

public class Student implements Comparable<Student> {
	private long id;
	private String name;
	private char gender;
	private double averageGrade;

	public Student() {
		
	}

	public Student(long id, String name, char gender, double averageGrade) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.averageGrade = averageGrade;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public double getAverageGrade() {
		return averageGrade;
	}

	public void setAverageGrade(double averageGrade) {
		this.averageGrade = averageGrade;
	}

	@Override
	public String toString() {
		return "Étudiant : " + getName() + " number : " + getId() + " gender : " + getGender() + " average grade : " + getAverageGrade();
	}

	@Override
	public int compareTo(Student s) {
		if(this.averageGrade > s.averageGrade) {
			return 1;
		} else if(this.averageGrade < s.averageGrade) {
			return -1;
		} else {
			return 0;
		}
		
	}
	
	

}
