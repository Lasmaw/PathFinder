package fr.pathfinder.graphic_interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import fr.pathfinder.carte.CellMap;
import fr.pathfinder.backtrack.*;

public class Path extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	int size;
	
	private BackTracker backTracker = null;
	
	CellMap map;
	
	JPanel pathPanel;
	
	
		
		Path(int size){

			//************** Données de la fenêtre **************//
			
	        super("PathFinder");
	        
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        pack();
	        setSize(1280,720);
	        setLocationRelativeTo(null);
	        setVisible(true); 
	        setResizable(false);

	        
	//************** Barre d'outils **************//
	        
	        JMenuBar barreDeMenu = new JMenuBar();
	        
	        JMenu menuFichier = new JMenu("Fichier");
	        JMenu menuCalculs = new JMenu("Calculs");
	        barreDeMenu.add(menuFichier);
	        barreDeMenu.add(menuCalculs);

	        JMenuItem newCart = new JMenuItem("Nouvelle carte");
	        JMenuItem openCart = new JMenuItem("Ouvrir une carte");
	        JMenuItem saveCart = new JMenuItem("Enregistrer la carte");
	        
	        JMenuItem startCalculator = new JMenuItem("Lancer le calcul");
	        JMenuItem randomizer = new JMenuItem("Remplir les cases aléatoirement");
	        menuFichier.add(newCart);
	        menuFichier.add(openCart);
	        menuFichier.add(saveCart);
	        
	        menuCalculs.add(startCalculator);
	        menuCalculs.add(randomizer);
	        
	        setJMenuBar(barreDeMenu);

	        startCalculator.addActionListener(new BackTrackerStarter());
	        randomizer.addActionListener(new Randomize());
//	        newCart.addActionListener(new NewMapWin(pathPanel));
//	        openCart.addActionListener(new fileChooser());
//	        saveCart.addActionListener(new fileSaver());
			
	        
	        pathPanel = new JPanel();

	        getContentPane().add(pathPanel);
	      //************** Panels **************//
	        
	        
	        
			
			this.size=size;
			this.map = new CellMap(this.size);
			this.backTracker = new BackTracker(this.map.toBackTrackMap());
			
			
			int buttonSize=(1280 - 2 * 20) / size;
			pathPanel.setLayout(new GridLayout(size, size));
			pathPanel.setBorder(BorderFactory.createEmptyBorder(100, 350, 50, 350)); // north, west , south, east
		    
		    for (int i = 0; i < map.size; i++) {
	        	for (int j = 0; j < map.size; j++) {

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
	        					StateModificaterWin modifier =  new StateModificaterWin(map, map.map[x][y]);
	        					
	        				}
	        			});
	        		
	        			map.map[i][j].btn=button;
	        			pathPanel.add(map.map[i][j].btn);
	        			
	        		
	        	}
		    }
		    

		    add(pathPanel);
	        getContentPane().add(pathPanel);
			pathPanel.setVisible(true);
		}

		
		private class BackTrackerStarter implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				try {
					backTracker = new BackTracker(map.toBackTrackMap());
					backTracker.resolve(new Position(map.start.posX,map.start.posY) , new Position(map.finish.posX,map.finish.posY));
					for (Pair pair : backTracker.getStack().dataStack) {
						map.map[pair.position.x][pair.position.y].btn.setBackground(Color.pink);
						map.map[pair.position.x][pair.position.y].btn.setText("P");
						
					}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		    }
		}
		
		private class Randomize implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				map.randomize(5);
				backTracker=new BackTracker(map.toBackTrackMap());
				
			}
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
}
