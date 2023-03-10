package fr.pathfinder.carte;

import java.awt.Color;
import java.util.Scanner;

public class Carte {
	
	Case cart[][];
	int size;
	String name;
	
	//Méthodes
	void editCaseValue(int x, int y, int value) { //Permet de changer la valeur d'une case
		cart[x][y].setValue(value);
	}
	
	void editCaseColor(int x, int y, Color col) { //Permet de changer la couleur d'une case
		cart[x][y].setColor(col);
	}
	
	void editCartValueAndColor(int x, int y, int value, Color col) { //Permet de changer la couleur et la valeur d'une case
		cart[x][y].setValue(value);
		cart[x][y].setColor(col);
	}
	
	void borderCases() { //Permet d'établir les bordures à -1
		int i,j;
		for(i=0;2<=i && i<this.size+2;i++) {
			for(j=0;2<=j && j<this.size+2;j++) {
				
				if(i<2 || j<2 || i>=this.size || j>=this.size) {
					editCaseValue(i, j, -1);
				}
			}
		}
	}
	
	Carte(int size, String name){
		int i,j,value;
		Scanner scan = new Scanner(System.in);
		for(i=2;2<=i && i<size+2;i++) {
			for(j=0;2<=j && j<size+2;j++) {
				value=scan.nextInt();
				borderCases();
				editCartValueAndColor(i,j,value,Color.GREEN);
			}
		}
	}
}
