package fr.pathfinder.graphic_interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Interface extends JFrame implements ActionListener {
    
    public Interface() {
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280,720);
        setVisible(true);    
                
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

