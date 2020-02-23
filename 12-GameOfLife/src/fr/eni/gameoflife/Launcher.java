package fr.eni.gameoflife;

public class Launcher {

	public static void main(String[] args) {

		World world = new World(10, 10);

		int i = 0;

		do {
			i++;
			System.out.println("Generation " + i);
			System.out.println(world.toString());
			world.newGeneration();
			
			try {
				   Thread.sleep(500) ;
				}  catch (InterruptedException e) {
				    // gestion de l'erreur
				}

		} while (true);

	}

}
