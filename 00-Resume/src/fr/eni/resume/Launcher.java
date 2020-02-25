package fr.eni.resume;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import fr.eni.comparator.SortAgeComparator;
import fr.eni.exception.NegativeValueException;
import fr.eni.model.Animal;
import fr.eni.model.Chat;
import fr.eni.model.Chien;
import fr.eni.model.Humain;

public class Launcher {

	public static void main(String[] args) {
		// Bases
		System.out.println("2-Bases :");
		bases();
		System.out.println("---------------------------------------");

		// POO
		System.out.println("3-POO");
		poo();
		System.out.println("---------------------------------------");

		// Exceptions
		System.out.println("3-Exceptions");
		exceptions();
		System.out.println("---------------------------------------");

		// Collections
		System.out.println("4-Collections");
		collections();
		System.out.println("---------------------------------------");
	}

	private static void collections() {
		// Listes :
		System.out.println("Listes : ");
		// ArrayList
		// Bonnes performances pour avoir et affecter les données
		List<Integer> arrayList = new ArrayList<>();

		// LinkedList
		// Meilleurs performances pour ajouter et retirer
		// Pauvre perfs pour avoir et affecter une valeur
		List<Integer> linkedList = new LinkedList<>();

		arrayList.add(5); // ajout
		int val = arrayList.get(0); // retour valeur à un index de liste
		System.out.println("valeur à l'indice 0 : " + val);
		arrayList.remove(0); // retire l'élement à l'index
		int tailleArrayList = arrayList.size(); // Taille de la liste
		System.out.println("Taille arrayList : " + tailleArrayList);

		// Map
		// clé(unique)/valeur
		// ~ tableau associatif
		System.out.println();
		System.out.println("Maps : ");

		// HashMap
		// Manipule la hash value des clés pour être efficace
		// peut avoir une clé null et plusieurs valeurs null
		Map<String, int[]> hashMap = new HashMap<>();
		int[] tab = { 5, 3, 2 };

		// Méthodes
		hashMap.put("Bob", tab);
		hashMap.put("James", tab);
		hashMap.get("Bob");
		hashMap.remove("James");
		boolean keyExist = hashMap.containsKey("Bob");
		System.out.println("Bob existe : " + keyExist);
		boolean valueExist = hashMap.containsValue(tab);
		System.out.println("tab existe : " + keyExist);

		// Set
		// éléments uniques
		System.out.println();
		System.out.println("Sets : ");

		// HashSet
		// Manipule la hash value des clés pour être efficace
		// Un seul élément null
		Set<Integer> hashSet = new HashSet<>();

		// LinkedHashSet
		// idem HashSet mais garde l'ordre d'insertion des éléments
		Set<Integer> linkedHashSet = new LinkedHashSet<>();

		// TreeSet
		// Tri auto des éléments dans l'ordre ascendant
		Set<Integer> treeSet = new TreeSet<>();

		hashSet.add(2); // ajout
		hashSet.add(2); // ajout doublon -> échec
		hashSet.add(5);
		int tailleHashSet = hashSet.size();
		System.out.println("Taille Set : " + tailleHashSet);

		// Itérateurs
		// Objet générique
		// Lecture seulement dans l'ordre ascendant
		// Peut supprimer un élément avec remove();
		System.out.println("Itération sur arrayList : ");
		for (int i = 0; i < 5; i++) {
			arrayList.add(i);
		}

		for (int i = 15; i > 11; i--) {
			arrayList.add(i);
		}

		System.out.println("Taille arrayList avant iterator :" + arrayList.size());
		Iterator<Integer> it = arrayList.iterator();
		while (it.hasNext()) {
			int valArrayList = it.next();
			if (valArrayList == 2) {
				it.remove();
				System.out.print("Suppression de " + valArrayList + " dans l'iterator ");
			} else {
				System.out.print(valArrayList + " ");
			}

		}
		System.out.println("\nTaille arrayList après iterator :" + arrayList.size());

		// Tri de collections
		// Comparator
		Humain humain = new Humain();
		humain.setPrenom("Alex");
		humain.setNom("C");
		humain.setAge(42);
		
		Animal chat = new Chat("kiki", 20, humain, 0);
		Animal chat1 = new Chat("snowki", 8, humain, 15);
		Animal chat2 = new Chat("molly", 12, humain, 10);
		Animal chat3 = new Chat("fripouille", 14, humain, 5);
		
		List<Animal> animaux = new ArrayList<>();
		animaux.add(chat);
		animaux.add(chat1);
		animaux.add(chat2);
		animaux.add(chat3);
		
		Collections.sort(animaux, new SortAgeComparator());
		System.out.println("tri de la liste d'animaux par age");
		Iterator<Animal> itAnimal = animaux.iterator();
		
		while (itAnimal.hasNext()) {
			Animal animal = itAnimal.next();
			System.out.println(animal.getNom() +" : "+animal.getAge());
		}

		// méthodes de Collections
		Collections.sort(arrayList);
		System.out.println("arrayList après sort :");
		System.out.print(arrayList);
		System.out.println();
		
		Collections.reverse(arrayList);
		System.out.println("arrayList après reverse :");
		System.out.print(arrayList);
		System.out.println();

		// méthodes de Arrays
		Integer[] tabInteger = { 5, 8, 3, 2, 9 };
		List<Integer> tabToList = Arrays.asList(tabInteger);
		System.out.println("Conversion d'un tableau de Integer en liste : " + tabToList);

	}

	private static void exceptions() {
		// 4 types d'exceptions
		System.out.println("start");
		try {
			// int i = 5 / 0;
			// String myStr = null;
			int i = 0;
			// myStr.length();
			if (i < 0) {
				throw new NegativeValueException();
			}
			System.out.println("After code in try");
		} catch (ArithmeticException e) {
			// 1. l'exception existe
			System.out.println("Error Arith");
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("Error Null Pointer");
			e.printStackTrace();
		} catch (NegativeValueException e) {
			// 3. Création de l'exception puis utlisation
			e.printStackTrace();
		}

		System.out.println("end");

	}

	private static void poo() {
		Humain humain = new Humain();
		humain.setPrenom("Alex");
		humain.setNom("C");
		humain.setAge(42);

		// Polymorphisme
		// Aggrégation dans Animal
		// super dans chat et chien
		Animal chat = new Chat("kiki", 20, humain, 0);
		Animal chien = new Chien("Hatchi", 8, humain, 2);

		System.out.println(chat);
		System.out.println(chien);

	}

	static void bases() {
		// Tableaux
		int[] tab1 = new int[4];
		int[] tab2 = { 5, 4, 3 };

		int[][] tab3 = { { 5, 4, 3 }, { 5, 4, 3 } };

		// Conditions ternaires
		int i = 1;
		int j = (i > 2 ? i : 0);
		System.out.println("Condition ternaire : " + j);
		System.out.println();

		// foreach
		System.out.println("foreach");
		for (int k : tab2) {
			System.out.println(k);
		}
		System.out.println();

	}

}
