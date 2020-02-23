package fr.eni.ecoleeni.launcher;

import fr.eni.ecoleeni.oop.model.Boat;
import fr.eni.ecoleeni.oop.model.Captain;
import fr.eni.ecoleeni.oop.model.Harbor;

public class Launcher {
	public static void main(String[] args) {
		Harbor myHarbor = new Harbor();
		Captain captainBob = new Captain();
		Boat myBoat = new Boat();
		
		myBoat.setName("Richelieu");
		myBoat.setSize(100);
		myBoat.setCaptain(captainBob);
		
		captainBob.setBoat(myBoat);
		myHarbor.setBoat(myBoat);
		
		
		myHarbor.getBoat().getCaptain().getDrunk();
		
		
	}
}
