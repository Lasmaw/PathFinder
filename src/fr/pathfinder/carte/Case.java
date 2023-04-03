package fr.pathfinder.carte;

import java.awt.Color;

import javax.swing.JButton;

import fr.pathfinder.graphic_interface.ColorBoard;

public class Case {
	
	//Attributs
	public int posX;
	public int posY;
	public int state;
	public int value;
	boolean clicked=false;
	public Color color=Color.white;
	public JButton btn=new JButton();
	
	//Méthodes
	
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
	
	
	void setClicked(boolean bool) {
		this.clicked=bool;
	}
	
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
	
	
	public Case(int x, int y, int val){
		setPosition(x,y);
		this.value=val;
		setValue(val);
		setState(0);
		setClicked(false);
		autoCol();
	}
	
}
