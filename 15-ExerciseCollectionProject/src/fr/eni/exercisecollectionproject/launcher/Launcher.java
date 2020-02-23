package fr.eni.exercisecollectionproject.launcher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import fr.eni.exercisecollectionproject.model.Student;

public class Launcher {

	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();
		students.add(new Student(250, "Bob", 'M', 12.5));
		students.add(new Student(123, "Rob", 'F', 18));
		students.add(new Student(141, "Tob", 'M', 9.75));
		students.add(new Student(90, "Job", 'F', 11.5));
		students.add(new Student(122, "Mob", 'M', 15.9));

		// Solution 1 :
		// Collections.sort(students, new SortAvgGradeComparator());
		// Solution 2 :
		Collections.sort(students);

		ListIterator<Student> it = students.listIterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}

}
