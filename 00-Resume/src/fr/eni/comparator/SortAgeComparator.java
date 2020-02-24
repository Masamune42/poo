package fr.eni.comparator;

import java.util.Comparator;

import fr.eni.model.Animal;

public class SortAgeComparator implements Comparator<Animal> {

	@Override
	public int compare(Animal s1, Animal s2) {
		if (s1.getAge() > s2.getAge()) {
			return 1;
		} else if (s1.getAge() < s2.getAge()) {
			return -1;
		} else {
			return 0;

		}
	}

}
