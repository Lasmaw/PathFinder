package fr.pathfinder.carte;

import java.awt.Color;
import java.util.Random;


import fr.pathfinder.backtrack.Position;
import fr.pathfinder.backtrack.Map;

public class CellMap {
	
	public Case[][] map;
	public Case start, finish;
	public int size,strtCount=0,fnshCount=0;
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
	
	
	public CellMap(int size) {
		this.size=size;
		int i,j;
		this.map=new Case[size][size];
		for(i=0;i<size;i++) {
			for(j=0;j<size;j++) {
				this.map[i][j]=new Case(i,j,0);
			}
		}
		showMap(size);
	}
	
	public Map toBackTrackMap() {
		Map bMap = new Map(map.length, map.length);
		for (int i = 0; i < this.map.length; i++) {
            for (int j = 0; j < this.map[0].length; j++) {
                bMap.set(i,j,map[i][j].value);
            }
        }
		return bMap;
	}
	
	
	public CellMap randomize(int max_height) {
        Random random = new Random();
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                map[i][j].value = random.nextInt(max_height);
                map[i][j].btn.setText(String.valueOf(map[i][j].value)); 
                map[i][j].autoCol();
            }
        }
        return this;
    }
	
	public void set(Position position, int value) {
        editCaseValue(position.x, position.y, value);
    }
	
	public int getHeightDelta(Position origin, Position destination) {
        return map[destination.x][destination.y].value- map[origin.x][origin.y].value;
    }
}
