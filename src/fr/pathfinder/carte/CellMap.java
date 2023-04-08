package fr.pathfinder.carte;

import java.awt.Color;
import java.util.Random;


import fr.backtrack.Position;
import fr.backtrack.Map;

/**
 * CellMap is an object that create the map made of Case.
 * @author Lasmaw
 */

public class CellMap {
	
	public Case[][] map; //Case spreadsheet that is used for the map printing on the window
	public Case start, finish; //tells what are the start and stop cells
	public int size,strtCount=0,fnshCount=0;
	String name;
	
	//Methods
	void editCaseValue(int x, int y, int value) { //change the value of a cell
		this.map[x][y].setValue(value);
	}
	
	void editCaseColor(int x, int y, Color col) { //change the color of a cell
		this.map[x][y].setColor(col);
	}
	
	void editCartValueAndColor(int x, int y, int value, Color col) { //change the color and the value of a cell
		this.map[x][y].setValue(value);
		this.map[x][y].setColor(col);
	}
	
	
	public void showMap(int size) { //print the map in the terminal
		int i,j;
		for(i=0;i<size;i++) {
			for(j=0;j<size;j++) {
				System.out.print(" "+this.map[i][j].value+" ");
			}
			System.out.print("\n");
		}
	}
	
	public CellMap(int [][] map) {
		this.size=map.length;
		int i,j;
		this.map=new Case[size][size];
		for(i=0;i<size;i++) {
			for(j=0;j<size;j++) {
				this.map[i][j]=new Case(i,j,map[i][j]);

			}
			
		}
		
	}
	
	
	public CellMap(int size) { //this create a flat map
		this.size=size;
		int i,j;
		this.map=new Case[size][size];
		for(i=0;i<size;i++) {
			for(j=0;j<size;j++) {
				this.map[i][j]=new Case(i,j,0);
			}
		}
		//showMap(size);
	}
	
	public Map toBackTrackMap() { //convert the case map into an int map (for the backtrack)
		Map bMap = new Map(map.length, map.length);
		for (int i = 0; i < this.map.length; i++) {
            for (int j = 0; j < this.map[0].length; j++) {
                bMap.set(i,j,map[i][j].value);
            }
        }
		return bMap;
	}
	
	
	public CellMap randomize(int max_height) { //fill every cell randomly
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
	
	public void set(Position position, int value) { //change the value of a cell (for the backtrack)
        editCaseValue(position.x, position.y, value);
    }
	
	public int getHeightDelta(Position origin, Position destination) { //function that calculate the difference of height between 2 cells
        return map[destination.x][destination.y].value- map[origin.x][origin.y].value;
    }
}
