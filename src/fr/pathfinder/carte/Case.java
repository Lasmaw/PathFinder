package fr.pathfinder.carte;

import java.awt.Color;

import javax.swing.JButton;

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
			this.color=Color.GREEN;
			this.btn.setText("D");
			this.btn.setForeground(Color.black);
			break;
		case 1: 
			this.color=Color.RED;
			this.btn.setText("A");
			this.btn.setForeground(Color.black);
			break;
		case 0:
			if(0<=this.value && this.value <5) {
				this.color=Color.white;
				this.btn.setForeground(Color.black);
			}
			else if(5<=this.value && this.value <10) {
				this.color=Color.lightGray;
				this.btn.setForeground(Color.black);
			}
			else if(10<=this.value && this.value <15) {
				this.color=Color.GRAY;
				this.btn.setForeground(Color.black);
			}
			else if(15<=this.value && this.value <20) {
				this.color=Color.darkGray;
				this.btn.setForeground(Color.white);
			}
			else if(20 <=this.value ) {
				this.color=Color.black;
				this.btn.setForeground(Color.white);
			}
			else if(0 > this.value ) this.color=Color.blue;
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
