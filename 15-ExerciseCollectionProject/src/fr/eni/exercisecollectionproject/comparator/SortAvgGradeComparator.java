package fr.eni.exercisecollectionproject.comparator;

import java.util.Comparator;

import fr.eni.exercisecollectionproject.model.Student;

public class SortAvgGradeComparator implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {
		if(s1.getAverageGrade() > s2.getAverageGrade()) {
			return 1;
		} else if(s1.getAverageGrade() < s2.getAverageGrade()) {
			return -1;
		}else {
			return 0;
			
		}
	}
	
}
