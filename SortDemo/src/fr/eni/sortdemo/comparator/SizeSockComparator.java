package fr.eni.sortdemo.comparator;

import java.util.Comparator;

import fr.eni.sortdemo.model.Sock;

public class SizeSockComparator implements Comparator<Sock> {

	@Override
	public int compare(Sock o1, Sock o2) {
		System.out.println("Comparing...");
		System.out.println(o1);
		System.out.println(o2);
		System.out.println();

		if (o1.getSize() > o2.getSize()) {
			return 1;
		} else if (o1.getSize() < o2.getSize()) {
			return -1;
		} else {
			return 0;
		}

	}

}
