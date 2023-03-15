package fr.pathfinder.carte;

import java.awt.Color;

import javax.swing.JButton;

public class Case {
	
	//Attributs
	int posX, posY;
	public int value;
	boolean clicked=false, start=false, finish=false;
	Color color;
	public JButton btn;
	
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
	
	public Case(int x, int y, int val){
		setPosition(x,y);
		setValue(val);
		setColor(Color.GREEN);
		setStart(false);
		setFinish(false);
		setClicked(false);
	}
	
}
