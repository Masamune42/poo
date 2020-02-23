package fr.eni.sortdemo.launcher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.eni.sortdemo.comparator.SizeSockComparator;
import fr.eni.sortdemo.model.Sock;

public class Launcher {

	public static void main(String[] args) {

		List<Sock> socks = new ArrayList<>();
		socks.add(new Sock(36, 10));
		socks.add(new Sock(34, 5));
		socks.add(new Sock(39, 6));
		socks.add(new Sock(46, 15));

		// System.out.println(socks);

		for (Sock s : socks) {
			System.out.println(s);
		}

		Collections.sort(socks, new SizeSockComparator());

		for (Sock s : socks) {
			System.out.println(s);
		}
	}

}
