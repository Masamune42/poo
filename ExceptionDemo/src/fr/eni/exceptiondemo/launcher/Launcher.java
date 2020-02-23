package fr.eni.exceptiondemo.launcher;

public class Launcher {

	public static void main(String[] args) {

		System.out.println("start");
		try {
			//int i = 5 / 0;
			String myStr = null;
			myStr.length();
			System.out.println("After code in try");
		} catch (ArithmeticException e) {
			System.out.println("Error Arith");
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("Error Null Pointer");
			e.printStackTrace();
		}

		System.out.println("end");

	}

}
