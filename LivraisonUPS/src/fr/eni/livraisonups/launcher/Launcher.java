package fr.eni.livraisonups.launcher;

import fr.eni.livraisonups.model.Animal;
import fr.eni.livraisonups.model.CamionUPS;
import fr.eni.livraisonups.model.Chat;
import fr.eni.livraisonups.model.Lama;

public class Launcher {

	public static void main(String[] args) {
		
		// Création d'un camion avec un seul type d'animal : lama
		CamionUPS<Lama> camionLama = new CamionUPS<>();
		camionLama.chargerCamion(new Lama("Serge"));
		camionLama.afficherChargement();
		camionLama.faireUnePause();
		
		// Création d'un camion avec un seul type d'animal : chat
		CamionUPS<Chat> camionChat = new CamionUPS<>();
		
		camionChat.chargerCamion(new Chat("Rob"));
		camionChat.afficherChargement();
		camionChat.faireUnePause();

		CamionUPS<Animal> camionAnimaux = new CamionUPS<>();
		camionAnimaux.chargerCamion(new Lama("Serge"));
		camionAnimaux.chargerCamion(new Chat("Rob"));
		camionAnimaux.afficherChargement();
		
	}

}
