package fr.pathfinder.graphic_interface;

import java.awt.Color;

public class ColorBoard {
	
	public Color[]colorBoard=new Color[120];
	public Color[]colorFont=new Color[120];
	
	public ColorBoard(){
		
		for(int i=0;i<9;i++) {
			this.colorBoard[9+(12*i)]=new Color(51,102,0);
			this.colorFont[9+(12*i)]=Color.black;
			this.colorBoard[10+(12*i)]=new Color(25,51,0);
			this.colorFont[10+(12*i)]=Color.black;
			this.colorBoard[11+(12*i)]=new Color(0,51,0);
			this.colorFont[11+(12*i)]=Color.white;
			this.colorBoard[0+(12*i)]=new Color(51,255,51);
			this.colorFont[0+(12*i)]=Color.black;
			this.colorBoard[1+(12*i)]=new Color(153,255,51);
			this.colorFont[1+(12*i)]=Color.black;
			this.colorBoard[2+(12*i)]=new Color(128,255,0);
			this.colorFont[2+(12*i)]=Color.black;
			this.colorBoard[3+(12*i)]=new Color(0,255,0);
			this.colorFont[3+(12*i)]=Color.black;
			this.colorBoard[4+(12*i)]=new Color(0,204,0);
			this.colorFont[4+(12*i)]=Color.black;
			this.colorBoard[5+(12*i)]=new Color(102,204,0);
			this.colorFont[5+(12*i)]=Color.black;
			this.colorBoard[6+(12*i)]=new Color(76,153,0);
			this.colorFont[6+(12*i)]=Color.black;
			this.colorBoard[7+(12*i)]=new Color(0,153,0);
			this.colorFont[7+(12*i)]=Color.black;
			this.colorBoard[8+(12*i)]=new Color(0,102,0);
			this.colorFont[8+(12*i)]=Color.black;

		}
		
	}
}
