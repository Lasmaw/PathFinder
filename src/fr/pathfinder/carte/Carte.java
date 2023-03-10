package fr.pathfinder.carte;

import java.awt.Color;

public class Carte {
	
	Case[][] map;
	int size;
	String name;
	
	//Méthodes
	void editCaseValue(int x, int y, int value) { //Permet de changer la valeur d'une case
		this.map[x][y].setValue(value);
	}
	
	void editCaseColor(int x, int y, Color col) { //Permet de changer la couleur d'une case
		this.map[x][y].setColor(col);
	}
	
	void editCartValueAndColor(int x, int y, int value, Color col) { //Permet de changer la couleur et la valeur d'une case
		this.map[x][y].setValue(value);
		this.map[x][y].setColor(col);
	}
	
	public void createCart(int size) {
		
		int i,j;
		for(i=0;i<size;i++) {
			for(j=0;j<size;j++) {
				if(i<2 || j<2 || i>=size || j>=size) {
					this.map[i][j]=new Case(i,j,-1);
					editCaseValue(i,j,-1);
				}
				else {
					this.map[i][j]=new Case(i,j,5);
				}
			}	
		}
	}
	
	
	public void printCart(int size) { //Permet d'établir les bordures à -1
		int i,j;
		for(i=0;i<size+2;i++) {
			for(j=0;j<size+2;j++) {
				System.out.print(" " + this.map[i][j].value + " ");
			}
		}
	}
	
	
	
	public Carte(int size, String name){
		map = new Case[size][size];
		this.size=size;
		this.name=name;
		createCart(size);
		printCart(size);
		
	}
}
