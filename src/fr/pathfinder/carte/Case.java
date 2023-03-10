package fr.pathfinder.carte;

import java.awt.Color;

public class Case {
	
	//Attributs
	int posX, posY, value;
	boolean clicked=false, start=false, finish=false;
	Color color;
	
	//Méthodes
	
	void setPosition(int x, int y) {
		this.posX=x;
		this.posY=y;
	}
	
	void setValue(int val) {
		this.value=val;
	}
	
	void setColor(Color col) {
		this.color=col;
	}
	
	void setStart(boolean bool) {
		this.start=bool;
	}
	
	void setFinish(boolean bool) {
		this.finish=bool;
	}
	
	void setClicked(boolean bool) {
		this.clicked=bool;
	}
	
	Case(int x, int y, int value){
		setPosition(x,y);
		setValue(value);
		setColor(Color.GREEN);
		setStart(false);
		setFinish(false);
		setClicked(false);
	}
	
}
