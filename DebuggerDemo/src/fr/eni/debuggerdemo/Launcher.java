package fr.eni.debuggerdemo;

public class Launcher {

	public static void main(String[] args) {

//		Integer myInt1 = 12;
//		Integer myInt2 = 12;
//
//		if (myInt1 == myInt2) {
//			System.out.println("Both are same");
//		} else {
//			System.out.println("Not the same");
//		}
//		

//		// ==?
//		
//		String str1 = "Hello";
//		String str2 = "Hello";
//		
//		if (str1.equals(str2)) {
//			//is String str1 contains same thing as str2
//		}

		// String myStr=null;
		// String myStr2="";
		// String myStr3="0";
		// String myStr4="null";
		//
		// int myStrSize = myStr.length();
		//
		// for (int i = 0; i < 100; i++) {
		// System.out.println(i);
		// }
		
		Cat cat1 = new Cat("Bob");
		Cat cat2 = new Cat("Bob2");
		Cat cat3 = new Cat("Bob3");
		Cat cat4 = new Cat("Bob4");
		
//		Cat[] myTab2 = {cat3,cat4};
//		Cat[] myTab1 = myTab2.clone();
//		
//		myTab2[0].name = "NEW NAME";
//		System.out.println(myTab1[0].name);
		
		Cat[][] myTab5 = {{cat1,cat2}, {cat3,cat4}};
		
		Cat[][] myTab6 = myTab5.clone();
		
		myTab5[0][0].name = "NAWE2";
		
		System.out.println(myTab6[0][0].name);
		
//		Cat cat5 = new Cat("Bob5");
//		
//		myTab1[0] = cat5;
//		
//		System.out.println(myTab1[0].name);
//		System.out.println(myTab2[0].name);
//		
//		// Tableaux 2D
//		Cat[][] myTab3 =  {{cat1,cat2},{cat1,cat2}};
//		Cat[][] myTab4 = {{cat3,cat4},{cat3,cat4}};
//		
//		myTab3 = myTab4.clone();
//		
//		myTab3[0][0] = cat5;
//		
//		System.out.println(myTab3[0][0].name);
//		System.out.println(myTab4[0][0].name);
	}

}

class Cat {
	String name;

	public Cat(String name) {
		this.name = name;
	}

}
