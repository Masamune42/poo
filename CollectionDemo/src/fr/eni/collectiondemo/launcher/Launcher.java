package fr.eni.collectiondemo.launcher;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Launcher {

	public static void main(String[] args) {
		List<String> myList1 = new ArrayList<>();
		ArrayList<String> mylist = new ArrayList<>();

		mylist.add("My first String");
		String mySecondString = "My second String";
		mylist.add(mySecondString);

		System.out.println(mylist.get(0));
		// System.out.println(mylist.get(-1));
		// System.out.println(mylist.get(999));

		int i = 9;

		try {
			System.out.println(mylist.get(i));
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Index not Found");
		}

		if (i >= 0 && i < mylist.size()) {
			System.out.println(mylist.get(i));
		} else {
			System.out.println("Index out of bounds");
		}

		// foreach
		for (String str : mylist) {
			System.out.println(str);
		}

		// for with index
		for (int j = 0; j < mylist.size(); j++) {
			System.out.println(mylist.get(j));
		}

		// Associative Array
		HashMap<String, Integer> nameAgeMap = new HashMap<>();
		nameAgeMap.put("Bob", 25);
		nameAgeMap.put("Rob", 35);
		nameAgeMap.put("Job", 42);
		nameAgeMap.put("Tob", 18);
		
		int ageOfBob = nameAgeMap.get("Bob");
		System.out.println(ageOfBob);
		
		for (int age : nameAgeMap.values()) {
			System.out.println(age);
		}
		
		// How to find the keys of a specific value
		int ageToFind = 25;
		for (Map.Entry<String, Integer> myEntry : nameAgeMap.entrySet()) {
			System.out.println(myEntry);
			
			if (myEntry.getValue() == ageToFind) {
				System.out.println("Comon key for age 25 : " + myEntry.getKey());
			}
		}
		
		HashSet<String> planets = new HashSet<>();
		
		planets.add("Mercure");
		planets.add("Jupiter");
		planets.add("Venus");
		
		planets.add("Venus");
		
		System.out.println(planets.size());
		
//		for (String str : mylist) {
//			if(str.equals(mySecondString)) {
//				mylist.remove(mySecondString);
//			}
//		}
		
//		for (int j = 0; j < mylist.size(); j++) {
//			mylist.remove(j);
//		}
		
		System.out.println(mylist);
		
		Integer[] intArray = {4,6,3,7};
		
		System.out.println(Arrays.toString(intArray));
		
		List<Integer> listInt = new ArrayList<Integer>(Arrays.asList(intArray));
				
		System.out.println(listInt);
		
		//System.out.println(intArray);
		
		System.out.println(Arrays.asList(intArray));
		
		
	}

}
