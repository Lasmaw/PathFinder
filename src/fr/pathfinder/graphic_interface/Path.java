package fr.pathfinder.graphic_interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.pathfinder.carte.Carte;

public class Path extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

		Path(Carte cart,JPanel panel){
			JButton pathBtn;
			//int i,j;
			//for(i=0;i<cart.size;i++) {
				//for(j=0;j<cart.size;j++) {
					pathBtn=new JButton("Btn");
					panel.add(pathBtn);
				}
			//}
		//}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	
}
