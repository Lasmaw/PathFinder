/*package fr.pathfinder.graphic_interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Fenetre extends JFrame {
    
    private JButton testBtn, quitBtn;
    private JPanel panel1, panel2;
    
    public Fenetre() {
        super("Ma fenêtre");
        setSize(1280, 720);
        
        testBtn = new JButton("Test");
        quitBtn = new JButton("Quitter");
        
        // Ajout des listeners aux boutons
        testBtn.addActionListener(new TestButtonListener());
        quitBtn.addActionListener(new QuitButtonListener());
        
        // Création du premier panel avec le bouton "test"
        panel1 = new JPanel();
        panel1.add(testBtn);
        
        // Création du deuxième panel avec fond rouge
        panel2 = new JPanel();
        panel2.setBackground(Color.RED);
        
        // Ajout du premier panel à la fenêtre
        getContentPane().add(panel1);
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    // Listener pour le bouton "test"
    private class TestButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Changement de panel
            getContentPane().remove(panel1);
            getContentPane().add(panel2);
            getContentPane().validate();
        }
    }
    
    // Listener pour le bouton "quitter"
    private class QuitButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Fermeture de la fenêtre
            dispose();
        }
    }
    
    public static void main(String[] args) {
        new Fenetre();
    }
}
*/