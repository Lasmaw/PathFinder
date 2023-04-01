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

	JFrame frame = new JFrame("Editer la case");
	JPanel panel = new JPanel();
	JButton btnValid = new JButton("Valider");
	JSlider slider;
	JLabel valueLabel;
	
	JLabel startLabel = new JLabel("Départ :");
	JLabel finishLabel = new JLabel("Arrivée :");

	JCheckBox chkStart = new JCheckBox("");
	JCheckBox chkEnd = new JCheckBox("");

	JFormattedTextField value = new JFormattedTextField();
	
	Case slot;
	
	public StateModificaterWin(Case slot){
		
		this.slot=slot;
		slider = new JSlider(0,20,slot.value);
		valueLabel = new JLabel("Valeur : " + slider.getValue());

		
		
		slider.setPaintTrack(true); 
        slider.setPaintTicks(true); 
        slider.setPaintLabels(true); 
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		
		btnValid.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				slot.value=slider.getValue();
				slot.autoCol();
				slot.btn.setBackground(slot.color);
				slot.btn.setText(String.valueOf(slot.value));
				frame.dispose();
			}
		});
		
		panel.add(slider);
		panel.add(valueLabel);
		panel.add(startLabel);
		panel.add(chkStart);
		panel.add(finishLabel);
		panel.add(chkEnd);
		frame.add(btnValid, BorderLayout.SOUTH);
		frame.add(panel);
		frame.setSize(300,150);
		frame.setVisible(true);
		frame.setResizable(false);
		
		getContentPane().validate();
	}

	public void stateChanged(ChangeEvent e) {
		slot.value=slider.getValue();
	}
	
	

}
