package fr.pathfinder.graphic_interface;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Interface extends JFrame implements ActionListener {
    
	private static final long serialVersionUID = 1L;
	
	private JButton startBtn, quitBtn;
	private JPanel panelMenu, panelPath;
	
	public Interface() {
		
//************** Données de la fenêtre **************//
		
        super("PathFinder");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280,720);
        setVisible(true);    

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

        newCart.addActionListener(this);
        openCart.addActionListener(this);
        saveCart.addActionListener(this);
        
//************** Boutons menu **************//
        
        startBtn = new JButton("Jouer");
        quitBtn = new JButton("Quitter");
        
        startBtn.addActionListener(new StartButtonListener());
        quitBtn.addActionListener(new QuitButtonListener());
        
//************** Panels **************//
        
        panelMenu = new JPanel();
        panelMenu.add(startBtn);
        panelMenu.add(quitBtn);
        
        panelPath = new JPanel();
        panelPath.setBackground(Color.RED);
        
        getContentPane().add(panelMenu);
    }
	
//************** Listeners **************//
	
	private class StartButtonListener implements ActionListener {
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
    
	
	
	
	
	
    public void actionPerformed(ActionEvent e) {
        String commande = e.getActionCommand();
        if (commande.equals("Nouveau fichier")) {
            System.out.println("Option Nouveau fichier sélectionnée");
        } else if (commande.equals("Charger fichier")) {
            System.out.println("Option Charger fichier sélectionnée");
        } else if (commande.equals("Enregistrer fichier")) {
            System.out.println("Option Enregistrer fichier sélectionnée");
        }
    }
    
}

