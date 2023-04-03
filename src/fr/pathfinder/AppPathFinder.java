package fr.pathfinder;

import javax.swing.SwingUtilities;

import fr.pathfinder.carte.CellMap;
import fr.pathfinder.graphic_interface.Menu;

public class AppPathFinder {

	public static void main(String[] args) {
		
		CellMap map = new CellMap(8);
		//Ouvrir l'interface
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Menu();
            }
        });
		
		
		
		
		
	}

}
