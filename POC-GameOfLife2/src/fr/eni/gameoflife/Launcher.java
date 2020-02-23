package fr.eni.gameoflife;

public class Launcher {

	public static void main(String[] args) {

		String adr = "C:\\Users\\acaignar2019\\Documents\\06-POO\\TP\\GameOfLife_Patterns\\jslife\\fuses\\1803278.lif";
//		 World world = new World(10, 10);

		World world = new World(adr);

		int i = 0;

		do {
			i++;
			System.out.println("Generation " + i);
			System.out.println(world.toString());
			world.newGeneration();

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// gestion de l'erreur
			}

		} while (true);

	}

}
