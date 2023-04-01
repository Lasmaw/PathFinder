package fr.pathfinder;

import javax.swing.SwingUtilities;

import fr.pathfinder.carte.Carte;
import fr.pathfinder.graphic_interface.Menu;

public class AppPathFinder {

	public static void main(String[] args) {
		
		Carte cart = new Carte(8);
		//Ouvrir l'interface
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Menu();
            }
        });
		
		
		
		
		
	}

}
