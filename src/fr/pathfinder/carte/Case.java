package fr.pathfinder.carte;

import java.awt.Color;

import javax.swing.JButton;

public class Case {
	
	//Attributs
	int posX, posY;
	public int value;
	boolean clicked=false, start=false, finish=false;
	public Color color=Color.white;
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
	
	void autoCol() {
		if(0<=this.value && this.value <5) this.color=Color.white;
		else if(5<=this.value && this.value <10) this.color=Color.lightGray;
		else if(10<=this.value && this.value <15) this.color=Color.GRAY;
		else if(15<=this.value && this.value <20) this.color=Color.darkGray;
		else if(20 <=this.value ) this.color=Color.black;
		else if(0 > this.value ) this.color=Color.blue;
		
		if(this.start=true) this.color=Color.green;
		else if(this.finish=true) this.color=Color.red;
	}
	
	
	public Case(int x, int y, int val){
		setPosition(x,y);
		this.value=val;
		setValue(val);
		setStart(false);
		setFinish(false);
		setClicked(false);
		autoCol();
	}
	
}
