package fr.eni.inheritance.model;

public class Student extends Person {
	protected String studentId; // Student Id Number
	protected double gradePointAverage; // grade point average

	public Student(String name, int age, String gender, String studentId, double gradePointAverage) {
		super(name, age, gender);
		this.studentId = studentId;
		this.gradePointAverage = gradePointAverage;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public double getGradePointAverage() {
		return gradePointAverage;
	}

	public void setGradePointAverage(double gradePointAverage) {
		this.gradePointAverage = gradePointAverage;
	}

}
