package fr.eni.resume;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
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

		// Fonctions utiles
		System.out.println("5-Fonctions utiles");
		fonctionsUtiles();
		System.out.println("---------------------------------------");

		// Lecture/Ecriture de fichiers
		System.out.println("6-Files");
		files();
		System.out.println("---------------------------------------");
	}


	private static void files() {
		List<String> listeMots = new ArrayList<>();
		try {
			// On sp�cifie l'adresse locale du dico
			File addr = new File("C:\\Users\\acaignar2019\\Documents\\06-POO\\TP\\dictionnaire.txt");
			// On lit et on stock tous les mots dans le buffer dico
			BufferedReader bfr = new BufferedReader(new InputStreamReader(new FileInputStream(addr), "UTF8"));
			String str;
			

			// Tant qu'il y a des mots dans le buffer, on les ajoute � la liste
			while ((str = bfr.readLine()) != null) {
				// System.out.println(str);
				listeMots.add(str);
			}
			

			bfr.close();
		} catch (Exception e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		// System.out.println(listeMots);
		
	}

	private static void fonctionsUtiles() {
		List<String> liste = new ArrayList<>();
		liste.add("bob");
		liste.add("john");
		liste.add("ted");
		liste.add("garry");
		String string = "Test sur une chaine de caract�res";
		String[] tab = { "chat", "chien", "corbeau", "renard", "loup" };
		Animal chat1 = new Chat("kiki", 19, new Humain(), 0);

		// String
		System.out.println("String ->");

		System.out.println("toUpperCase : " + string.toUpperCase());
		System.out.println("toLowerCase : " + string.toLowerCase());
		System.out.println("length : " + string.length());

		// String -> tableaux de char
		System.out.println("toCharArray : ");
		for (char c : string.toCharArray()) {
			System.out.print(c + " ");
		}
		System.out.println();

		// tableau -> String
		String tabToString = String.join(", ", tab);
		System.out.println("Tableau en String : " + tabToString);

		// Tableaux
		System.out.println("Tableaux ->");
		// sort
		Arrays.sort(tab);
		System.out.print("sort tableau : ");
		for (String string2 : tab) {
			System.out.print(string2 + " ");
		}
		System.out.println();

		// Collections
		System.out.println("Collectons ->");
		System.out.println("Liste : " + liste);

		// shuffle
		Collections.shuffle(liste);
		System.out.println("Liste m�lang�e : " + liste);

		// Objet
		System.out.println("Objet ->");
		boolean b1 = chat1 instanceof Chat;
		boolean b2 = chat1 instanceof Animal;
		boolean b3 = chat1 instanceof Chien;
		System.out.println("chat instanceof Chat: " + b1);
		System.out.println("chat instanceof Animal : " + b2);
		System.out.println("chat instanceof  Chien: " + b3);

	}

	private static void collections() {
		// Listes :
		System.out.println("Listes : ");
		// ArrayList
		// Bonnes performances pour avoir et affecter les donn�es
		List<Integer> arrayList = new ArrayList<>();

		// LinkedList
		// Meilleurs performances pour ajouter et retirer
		// Pauvre perfs pour avoir et affecter une valeur
		List<Integer> linkedList = new LinkedList<>();

		arrayList.add(5); // ajout
		int val = arrayList.get(0); // retour valeur � un index de liste
		System.out.println("valeur � l'indice 0 : " + val);
		arrayList.remove(0); // retire l'�lement � l'index
		int tailleArrayList = arrayList.size(); // Taille de la liste
		System.out.println("Taille arrayList : " + tailleArrayList);

		// Map
		// cl�(unique)/valeur
		// ~ tableau associatif
		System.out.println();
		System.out.println("Maps : ");

		// HashMap
		// Manipule la hash value des cl�s pour �tre efficace
		// peut avoir une cl� null et plusieurs valeurs null
		Map<String, int[]> hashMap = new HashMap<>();
		int[] tab = { 5, 3, 2 };

		// M�thodes
		hashMap.put("Bob", tab);
		hashMap.put("James", tab);
		hashMap.get("Bob");
		hashMap.remove("James");
		boolean keyExist = hashMap.containsKey("Bob");
		System.out.println("Bob existe : " + keyExist);
		boolean valueExist = hashMap.containsValue(tab);
		System.out.println("tab existe : " + keyExist);

		// Set
		// �l�ments uniques
		System.out.println();
		System.out.println("Sets : ");

		// HashSet
		// Manipule la hash value des cl�s pour �tre efficace
		// Un seul �l�ment null
		Set<Integer> hashSet = new HashSet<>();

		// LinkedHashSet
		// idem HashSet mais garde l'ordre d'insertion des �l�ments
		Set<Integer> linkedHashSet = new LinkedHashSet<>();

		// TreeSet
		// Tri auto des �l�ments dans l'ordre ascendant
		Set<Integer> treeSet = new TreeSet<>();

		hashSet.add(2); // ajout
		hashSet.add(2); // ajout doublon -> �chec
		hashSet.add(5);
		int tailleHashSet = hashSet.size();
		System.out.println("Taille Set : " + tailleHashSet);

		// It�rateurs
		// Objet g�n�rique
		// Lecture seulement dans l'ordre ascendant
		// Peut supprimer un �l�ment avec remove();
		System.out.println("It�ration sur arrayList : ");
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
		System.out.println("\nTaille arrayList apr�s iterator :" + arrayList.size());

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
			System.out.println(animal.getNom() + " : " + animal.getAge());
		}

		// m�thodes de Collections
		Collections.sort(arrayList);
		System.out.println("arrayList apr�s sort :");
		System.out.print(arrayList);
		System.out.println();

		Collections.reverse(arrayList);
		System.out.println("arrayList apr�s reverse :");
		System.out.print(arrayList);
		System.out.println();

		// m�thodes de Arrays
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
			// 3. Cr�ation de l'exception puis utlisation
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
		// Aggr�gation dans Animal
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
