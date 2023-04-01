package fr.pathfinder.carte;

import java.awt.Color;

public class Carte {
	
	public Case[][] map;
	public int size;
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
	
	public void fillBorder(int size) {
		int i,j;
		for(i=0;i<size;i++) {
			for(j=0;j<size;j++) {
				if(i<1 || i>(size-2) || j<1 || j>(size-2)) editCaseValue(i,j,-1);
			}
		}
	}
	
	public void showMap(int size) {
		int i,j;
		for(i=0;i<size;i++) {
			for(j=0;j<size;j++) {
				System.out.print(" "+this.map[i][j].value+" ");
			}
			System.out.print("\n");
		}
	}
	
	public Carte(int size) {
		this.size=size;
		size=size+2;
		int i,j;
		this.map=new Case[size][size];
		for(i=0;i<size;i++) {
			for(j=0;j<size;j++) {
				this.map[i][j]=new Case(i,j,0);
			}
		}
		fillBorder(size);
		showMap(size);
	}
}
