package fr.pathfinder.graphic_interface;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import fr.pathfinder.carte.Case;


public class StateModificaterWin extends JFrame implements ChangeListener{

	private static final long serialVersionUID = 7964617219132017366L;

	
	JSlider slider;
	JLabel valueLabel;
	
	public StateModificaterWin(Case slot){
		super("PathFinder");
		modificater(slot);
		
		
	}
	
	public void modificater(Case slot) {
		JFrame btnFrame = new JFrame("Case");
		JPanel btnPanel = new JPanel();
		slider = new JSlider(0,20,slot.value);
		valueLabel = new JLabel("Valeur : " + slider.getValue());
		JButton btnQuit = new JButton("Quitter");
		JLabel startLabel = new JLabel("Départ :");
		JLabel finishLabel = new JLabel("Arrivée :");

		JCheckBox chkStart = new JCheckBox("");
		JCheckBox chkEnd = new JCheckBox("");

		JFormattedTextField value = new JFormattedTextField();
		
		
		slider.setPaintTrack(true); 
        slider.setPaintTicks(true); 
        slider.setPaintLabels(true); 
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		
		btnQuit.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnFrame.dispose();
			}
		});
		
		btnPanel.add(slider);
		btnPanel.add(valueLabel);
		btnPanel.add(startLabel);
		btnPanel.add(chkStart);
		btnPanel.add(finishLabel);
		btnPanel.add(chkEnd);
		btnFrame.add(btnQuit, BorderLayout.SOUTH);
		btnFrame.add(btnPanel);
		btnFrame.setSize(300,150);
		btnFrame.setVisible(true);
		btnFrame.setResizable(false);
	}

	public void stateChanged(ChangeEvent e) {
		valueLabel.setText("Valeur : " + slider.getValue());
	}
	
	

}
