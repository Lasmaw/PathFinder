package fr.pathfinder.graphic_interface;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import fr.pathfinder.carte.Carte;

public class Path extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	int size;
	
	Carte map;
	
	JPanel pathPanel;
	private JButton testbtn;
	
		
		Path(int size){

			//************** Données de la fenêtre **************//
			
	        super("PathFinder");
	        
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        pack();
	        setSize(1280,720);
	        setVisible(true); 
	        setResizable(false);

	        
	//************** Barre d'outils **************//
	        
	        JMenuBar barreDeMenu = new JMenuBar();
	        
	        JMenu menuFichier = new JMenu("Fichier");
	        barreDeMenu.add(menuFichier);

	        JMenuItem newCart = new JMenuItem("Nouvelle carte");
	        JMenuItem openCart = new JMenuItem("Ouvrir une carte");
	        JMenuItem saveCart = new JMenuItem("Enregistrer la carte");
	        menuFichier.add(newCart);
	        menuFichier.add(openCart);
	        menuFichier.add(saveCart);
	        
	        setJMenuBar(barreDeMenu);

//	        newCart.addActionListener(new PathButtonListener());
//	        openCart.addActionListener(new fileChooser());
//	        saveCart.addActionListener(new fileSaver());
			
	        
	        pathPanel = new JPanel();

	        getContentPane().add(pathPanel);
	      //************** Panels **************//
	        
	        pathPanel = new JPanel();
	        
			
			this.size=size;
			this.map = new Carte(this.size);
			
			
			int buttonSize=(1280 - 2 * 20) / size;
			pathPanel.setLayout(new GridLayout(size, size));
			pathPanel.setBorder(BorderFactory.createEmptyBorder(100, 350, 50, 350)); // north, west , south, east
		    
		    for (int i = 0; i < map.size+1; i++) {
	        	for (int j = 0; j < map.size+1; j++) {
	        		if(this.map.map[i][j].value == -1) {} else {
	        		JButton button = new JButton(String.valueOf(this.map.map[i][j].value));
	        		button.setPreferredSize(new Dimension(10,10));
	        		button.setBackground(this.map.map[i][j].color);
	        		if (i == 0 || i == map.size + 1 || j == 0 || j == map.size + 1) {
	        			button.setPreferredSize(new Dimension(buttonSize, buttonSize));
	        		}
	        		final int x = i;
	        		final int y = j;
	        		button.addActionListener((ActionListener) new ActionListener() {
	    				public void actionPerformed(ActionEvent e) {
	    					StateModificaterWin modifier =  new StateModificaterWin((map.map[x][y]));
	    				}
	    			});
	        		map.map[i][j].btn=button;
	        		pathPanel.add(map.map[i][j].btn);
	        		}
	        	}
		    }
		    
		    
		    add(pathPanel);
	        getContentPane().add(pathPanel);
			pathPanel.setVisible(true);
		}


		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
}
