package fr.pathfinder.graphic_interface;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.tools.JavaFileManager;

import fr.pathfinder.carte.Carte;
import fr.pathfinder.carte.Case;

public class Interface extends JFrame implements ActionListener {
    
	private static final long serialVersionUID = 1L;
	
	private JButton startBtn, quitBtn;
	private JPanel panelMenu, panelPath;
	Carte map;
	Path path;
	
	public Interface(Carte map) {
		
		
		
//************** Données de la fenêtre **************//
		
        super("PathFinder");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(1280,720);
        setVisible(true); 
        setResizable(false);
        
        this.map=map;
//************** Barre d'outils **************//
        
        JMenuBar barreDeMenu = new JMenuBar();
        
        JMenu menuFichier = new JMenu("Fichier");
        barreDeMenu.add(menuFichier);

        JMenuItem newCart = new JMenuItem("Nouvelle carte");
        JMenuItem openCart = new JMenuItem("Ouvrir carte");
        JMenuItem saveCart = new JMenuItem("Enregistrer carte");
        menuFichier.add(newCart);
        menuFichier.add(openCart);
        menuFichier.add(saveCart);
        
        setJMenuBar(barreDeMenu);

        newCart.addActionListener(new fileCreater());
        openCart.addActionListener(new fileChooser());
        saveCart.addActionListener(new fileSaver());
        
//************** Boutons menu **************//
        
        startBtn = new JButton("Jouer");
        quitBtn = new JButton("Quitter");
        
        startBtn.addActionListener(new StartButtonListener());
        quitBtn.addActionListener(new QuitButtonListener());
        
//************** Boutons Path **************//
        
        startBtn = new JButton("Jouer");
        quitBtn = new JButton("Quitter");
        
        startBtn.addActionListener(new StartButtonListener());
        quitBtn.addActionListener(new QuitButtonListener());
        
//************** Panels **************//
        
        panelMenu = new JPanel();
        panelMenu.add(startBtn);
        panelMenu.add(quitBtn);
        
        panelPath = new JPanel();
        pathWin(map, panelPath);

        
        getContentPane().add(panelMenu);
    }
	
	
	public void pathWin(Carte map, JPanel win) { //Tableau de boutons
		
        int size = map.size;
        int buttonSize = (1280 - 2 * 20) / size;
        
        win.setLayout(new GridLayout(size, size));
        win.setBorder(BorderFactory.createEmptyBorder(100, 350, 50, 350)); // north, west , south, east

        for (int i = 0; i < size; i++) {
        	for (int j = 0; j < size; j++) {
        		JButton button = new JButton(String.valueOf(i+j));
        		button.setPreferredSize(new Dimension(10,10));
        		if (i == 0 || i == size - 1 || j == 0 || j == size - 1) {
        			button.addActionListener(new PathButtonListener());
        			button.setPreferredSize(new Dimension(buttonSize, buttonSize));
        		}
        		map.map[i][j].btn=button;
        		win.add(map.map[i][j].btn);
        	}
        }        
        win.setVisible(true);
    }
	
	
	
//************** Listeners **************//
	
	private class StartButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			getContentPane().remove(panelMenu);
			getContentPane().add(panelPath);
			getContentPane().validate();
            System.out.println("Test");

		}
	}
	
	private class QuitButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}
    
	private class PathButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			getContentPane().add(panelPath);
			getContentPane().validate();
		}
	}
	
	
	
	
    
    
//************** Fenêtre modif **************//
	
	private class fileCreater implements ActionListener {
		public void actionPerformed(ActionEvent event) {
	        JFileChooser chooser = new JFileChooser();
	        chooser.setVisible(true);
	        int retval = chooser.showDialog(Interface.this, "Test");
	        File file = chooser.getSelectedFile();
	    }
	}
	
	
	
	private class fileChooser implements ActionListener {
		public void actionPerformed(ActionEvent event) {
	        JFileChooser chooser = new JFileChooser();
	        chooser.setVisible(true);
	        int userSelec = chooser.showOpenDialog(Interface.this);
	        File file = chooser.getSelectedFile();
	    }
	}
	
	private class fileSaver implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JFileChooser saver = new JFileChooser();
			saver.setDialogTitle("Enregistrer le fichier");
			saver.setVisible(true);
			int usrSelec = saver.showSaveDialog(Interface.this);
			
			
			if (usrSelec == JFileChooser.APPROVE_OPTION) {
			    File fileToSave = saver.getSelectedFile();
			    System.out.println("Enregistrer en tant que " + fileToSave.getAbsolutePath());
			}
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	


	
    
}

