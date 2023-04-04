package fr.pathfinder.graphic_interface;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import fr.MapParser.MapParser;
import fr.MapSaver.MapSaver;
import fr.pathfinder.carte.CellMap;


public class Menu extends JFrame implements ActionListener {
    
	private static final long serialVersionUID = 1L;
	
	private JButton startBtn, openBtn, quitBtn;
	private JPanel panelMenu, panelPath;
	CellMap map;
	Path path;
	
	JTextArea textArea;
	JButton save;

	public Menu()  {
		
		
		
//************** Données de la fenêtre **************//
		
        super("PathFinder");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(1280,720);
        setLocationRelativeTo(null);
        setVisible(true); 
        setResizable(false);
        
        this.map=map;
//************** Barre d'outils **************//
        
        JMenuBar barreDeMenu = new JMenuBar();
        
        JMenu menuFichier = new JMenu("Fichier");
        barreDeMenu.add(menuFichier);

        JMenuItem newCart = new JMenuItem("Nouvelle carte");
        JMenuItem openCart = new JMenuItem("Ouvrir une carte");
        menuFichier.add(newCart);
        menuFichier.add(openCart);
        
        setJMenuBar(barreDeMenu);

        newCart.addActionListener(new StartButtonListener());
        openCart.addActionListener(new fileChooser());
        
//************** Boutons menu **************//
        
        startBtn = new JButton("Nouvelle Carte");
        openBtn = new JButton("Ouvrir une carte");
        quitBtn = new JButton("Quitter");
        
        startBtn.addActionListener(new StartButtonListener());
        openBtn.addActionListener(new fileChooser());
        quitBtn.addActionListener(new QuitButtonListener());
        
//************** Panels **************//

        panelMenu = new JPanel();
        panelMenu.add(startBtn);
        panelMenu.add(openBtn);
        panelMenu.add(quitBtn);
        
        panelPath = new JPanel();

        
        getContentPane().add(panelMenu);

    }
	
	
	
//************** Listeners **************//
	
	private class StartButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			NewMapWin newMap = new NewMapWin(panelMenu);
			dispose();
		}
	}
	
	private class OpenButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			getContentPane().remove(panelMenu);
			getContentPane().add(panelPath);
			getContentPane().validate();

		}
	}
	
	private class QuitButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}
       
    
//************** Fenêtre modif **************//
	
	
	private class fileChooser implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try {
					MapParser mapParser = new MapParser();
					int [][] mapToParse=mapParser.parse();
					map=new CellMap(mapToParse);
					dispose();
					new Path(mapToParse.length, map);
	
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

	
    
}

