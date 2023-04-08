package fr.pathfinder.carte;

import java.awt.Color;

import javax.swing.JButton;

import fr.pathfinder.graphic_interface.ColorBoard;

public class Case {
	
	//Attributs
	public int posX;
	public int posY;
	public int state; //Start=-1, Finish=1, Neutral=0
	public int value;
	public Color color=Color.white;
	public JButton btn=new JButton();
	
	//Methods
	
	void setPosition(int x, int y) {
		this.posX=x;
		this.posY=y;
	}
	
	void setValue(int val) {
		this.value=val;
	}
	
	void setState(int state) {
		this.state=state;
	}
	
	void setColor(Color col) {
		this.color=col;
	}
	
	
	//this colorate the cell automatically
	
	public void autoCol() {
				
		switch(this.state) {
		case -1: 
			this.color=Color.white;
			this.btn.setBackground(this.color);
			this.btn.setText("D");
			this.btn.setForeground(Color.black);
			break;
		case 1: 
			this.color=Color.black;
			this.btn.setBackground(this.color);
			this.btn.setText("A");
			this.btn.setForeground(Color.white);
			break;
		case 0:
			ColorBoard colorBoard = new ColorBoard();
			for(int i=0;i<=this.value;i++) {
				this.color=colorBoard.colorBoard[i];
				this.btn.setForeground(colorBoard.colorFont[i]);
			}
			this.btn.setBackground(this.color);
			this.btn.setText(String.valueOf(this.value));
			break;
		default:
			break;
		}
	}
	
	
	public Case(int x, int y, int val){ //this create a new cell with a specific position and value
		setPosition(x,y);
		this.value=val;
		setValue(val);
		setState(0);
		autoCol();
	}
	
}
