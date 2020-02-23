package fr.eni.inheritance.launcher;

import fr.eni.inheritance.model.Building;
import fr.eni.inheritance.model.Factory;
import fr.eni.inheritance.model.House;

public class Launcher {

	public static void main(String[] args) {
		
		Building myBuilding1 = new Building();
		Building myBuilding2 = new Building("Address of building 2");
		Building myBuilding3 = new Building(42, "Address of building 3");
		
		House myHouse = new House();
		myHouse.setAddress("My house address");
		myHouse.setSurface(35);
		
		System.out.println(myBuilding1);
		System.out.println(myBuilding2);
		System.out.println(myBuilding3);
		
		System.out.println(myHouse);
		
		myBuilding3.doBuild();
		myHouse.doBuild();
		
		Factory myFactory = new Factory();
		myFactory.setAddress("Factory address");
		myFactory.setSurface(2000);
		myFactory.makeItems();
	}

}
