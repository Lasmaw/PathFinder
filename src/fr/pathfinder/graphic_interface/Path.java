package fr.pathfinder.graphic_interface;

import java.awt.event.ActionListener;

import javax.swing.JFrame;

import fr.pathfinder.carte.Carte;

public abstract class Path extends JFrame implements ActionListener{

		Path(int size, String name){
			Carte cart = new Carte(size, name);
			int i,j;
			
		}
	
}
