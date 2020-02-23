package fr.eni.exceptiondemo.launcher;

public class ThrowsThrows {

	public static void main(String[] args) {
		System.out.println("Hello");
		try {

			method1();

		} catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
		}

	}

	static void method1() throws Exception {
		System.out.println("Here method1");
		method2();
	}

	static void method2() throws Exception {
		System.out.println("Here method2");
		method3();
	}

	static void method3() throws Exception {
		System.out.println("Here method3");
		//int i = 2 / 0;
		
		throw new NegativeValueException();
	}

}
