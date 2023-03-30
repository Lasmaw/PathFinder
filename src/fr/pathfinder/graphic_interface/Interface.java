package fr.pathfinder.graphic_interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import fr.pathfinder.carte.Carte;

public class Interface extends JFrame implements ActionListener {
    
	private static final long serialVersionUID = 1L;
	
	private JButton startBtn, openBtn, quitBtn;
	private JPanel panelMenu, panelPath;
	Carte map;
	Path path;
	
	JTextArea textArea;
	JButton save;
	
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
        JMenuItem openCart = new JMenuItem("Ouvrir une carte");
        JMenuItem saveCart = new JMenuItem("Enregistrer la carte");
        menuFichier.add(newCart);
        menuFichier.add(openCart);
        menuFichier.add(saveCart);
        
        setJMenuBar(barreDeMenu);

        newCart.addActionListener(new PathButtonListener());
        openCart.addActionListener(new fileChooser());
        saveCart.addActionListener(new fileSaver());
        
//************** Boutons menu **************//
        
        startBtn = new JButton("Nouvelle Carte");
        openBtn = new JButton("Ouvrir une carte");
        quitBtn = new JButton("Quitter");
        
        startBtn.addActionListener(new StartButtonListener());
        openBtn.addActionListener(new OpenButtonListener());
        quitBtn.addActionListener(new QuitButtonListener());
        
//************** Boutons Path **************//
        
        startBtn = new JButton("Nouvelle carte");
        openBtn = new JButton("Ouvrir une carte");
        quitBtn = new JButton("Quitter");
        
        startBtn.addActionListener(new StartButtonListener());
        openBtn.addActionListener(new OpenButtonListener());
        quitBtn.addActionListener(new QuitButtonListener());
        
//************** Panels **************//
        
        panelMenu = new JPanel();
        panelMenu.add(startBtn);
        panelMenu.add(openBtn);
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
        		JButton button = new JButton(String.valueOf(map.map[i+2][j+2].value));
        		button.setPreferredSize(new Dimension(10,10));
        		button.setBackground(Color.white);
        		if (i == 0 || i == size - 1 || j == 0 || j == size - 1) {
        			button.setPreferredSize(new Dimension(buttonSize, buttonSize));
        		}
    			button.addActionListener(new PathButtonListener());
    			
    			
        		map.map[i][j].btn=button;
        		map.map[i][j].autoCol();
        		map.map[i][j].btn.setBackground(map.map[i][j].color);
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
    
	private class PathButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			getContentPane().add(panelPath);
			JFrame btnFrame = new JFrame("Case");
			JPanel btnPanel = new JPanel();
			JButton btnQuit = new JButton("Quitter");
			JLabel valueLabel = new JLabel("Valeur :");
			JLabel startLabel = new JLabel("Départ :");
			JLabel finishLabel = new JLabel("Arrivée :");

			JCheckBox chkStart = new JCheckBox("");
			JCheckBox chkEnd = new JCheckBox("");

			JFormattedTextField value = new JFormattedTextField();
			
			btnQuit.setBackground(Color.red);
			btnQuit.addActionListener((ActionListener) new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnFrame.dispose();
				}
			});
			
			btnPanel.add(valueLabel);
			btnPanel.add(value);
			btnPanel.add(startLabel);
			btnPanel.add(chkStart);
			btnPanel.add(finishLabel);
			btnPanel.add(chkEnd);
			btnFrame.add(btnQuit, BorderLayout.SOUTH);
			btnFrame.add(btnPanel);
			btnFrame.setSize(300,400);
			btnFrame.setVisible(true);
			btnFrame.setResizable(false);
			
			getContentPane().validate();
		}
	}
	
	
	
	
    
    
//************** Fenêtre modif **************//
	
	protected void saveToFile() {
	    JFileChooser fileChooser = new JFileChooser();
	    int retval = fileChooser.showSaveDialog(save);
	    if (retval == JFileChooser.APPROVE_OPTION) {
	      File file = fileChooser.getSelectedFile();
	      if (file == null) {
	        return;
	      }
	      if (!file.getName().toLowerCase().endsWith(".txt")) {
	        file = new File(file.getParentFile(), file.getName() + ".txt");
	      }
	      try {
	        textArea.write(new OutputStreamWriter(new FileOutputStream(file),
	            "utf-8"));
	        Desktop.getDesktop().open(file);
	      } catch (Exception e) {
	        e.printStackTrace();
	      }
	    }
	}
	
	void initUI() {
	    JFrame frame = new JFrame(Interface.class.getSimpleName());
	    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    textArea = new JTextArea(24, 80);
	    save = new JButton("Save to file");
	    save.addActionListener(e -> saveToFile());
	    JPanel buttonPanel = new JPanel();
	    buttonPanel.add(save);
	    frame.add(buttonPanel, BorderLayout.SOUTH);
	    frame.setSize(500, 400);
	    frame.setVisible(true);
	  }

	private class fileCreater implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			initUI();

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

