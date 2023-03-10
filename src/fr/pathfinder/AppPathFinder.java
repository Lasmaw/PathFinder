package fr.pathfinder;

import javax.swing.SwingUtilities;

import fr.pathfinder.graphic_interface.Interface;

public class AppPathFinder {

	public static void main(String[] args) {
		
		
		//Ouvrir l'interface
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Interface();
            }
        });
		
		
	}

}
