package fr.eni.anthill.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Anthill {
	private int nbQueens;
	private int nbMales;
	private int nbWorkers;
	private int nbLarvae;
	private int ageOfAnthill = 0;
	private ArrayList<Ant> anthillList = new ArrayList<>();

	public Anthill(int nbQueens, int nbMales, int nbWorkers, int nbLarvae) {
		this.nbQueens = nbQueens;
		this.nbMales = nbMales;
		this.nbWorkers = nbWorkers;
		this.nbLarvae = nbLarvae;

		for (int i = 0; i < nbQueens; i++) {
			anthillList.add(new Queen());
		}
		for (int i = 0; i < nbMales; i++) {
			anthillList.add(new Male());
		}
		for (int i = 0; i < nbWorkers; i++) {
			anthillList.add(new Worker());
		}
		for (int i = 0; i < nbLarvae; i++) {
			anthillList.add(new Larva());
		}
	}

	public void moreAge() {
		ageOfAnthill++;
		System.out.println("We are at the age " + ageOfAnthill);

		// Iterator<String> it;
		Iterator<Ant> it = anthillList.iterator();

		while (it.hasNext()) {
			Ant ant = (Ant) it.next();
			ant.becomeOlder();
			if (!ant.isAlive()) {
				it.remove();

			}

		}

	}

	public void displayAnthill() {
		
	}

	public int getNbQueens() {
		return nbQueens;
	}

	public void setNbQueens(int nbQueens) {
		this.nbQueens = nbQueens;
	}

	public int getNbMales() {
		return nbMales;
	}

	public void setNbMales(int nbMales) {
		this.nbMales = nbMales;
	}

	public int getNbWorkers() {
		return nbWorkers;
	}

	public void setNbWorkers(int nbWorkers) {
		this.nbWorkers = nbWorkers;
	}

	public int getNbLarvae() {
		return nbLarvae;
	}

	public void setNbLarvae(int nbLarvae) {
		this.nbLarvae = nbLarvae;
	}

	public int getAgeOfAnthill() {
		return ageOfAnthill;
	}

	public void setAgeOfAnthill(int ageOfAnthill) {
		this.ageOfAnthill = ageOfAnthill;
	}

	public ArrayList<Ant> getAnthillList() {
		return anthillList;
	}

	public void setAnthillList(ArrayList<Ant> anthillList) {
		this.anthillList = anthillList;
	}

}
