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
	JSlider slider,switcher;
	JLabel valueLabel;
	
	JLabel startLabel = new JLabel("Départ             Neutre           Arrivée");


	JFormattedTextField value = new JFormattedTextField();
	
	Case slot;
	int slotCase;
	
	
	public StateModificaterWin(Case slot){
		
		this.slot=slot;

		slider = new JSlider(0,25,slot.value);
		switcher = new JSlider(-1,1,slot.state);
		valueLabel = new JLabel("Valeur     :     " + slider.getValue());

		
		
		slider.setPaintTrack(true); 
        slider.setPaintTicks(true); 
        slider.setPaintLabels(true); 
		slider.setMajorTickSpacing(5);
		slider.setMinorTickSpacing(1);
		
		switcher.setPaintTrack(true); 
		switcher.setPaintTicks(true); 
		switcher.setPaintLabels(true); 
		switcher.setMajorTickSpacing(1);

		
		btnValid.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				slot.value=slider.getValue();
				slot.state=switcher.getValue();
				slot.autoCol();
				slot.btn.setBackground(slot.color);

				
				frame.dispose();
			}
		});
		panel.add(valueLabel);
		panel.add(slider);
		
		panel.add(switcher);
		panel.add(startLabel);


		frame.add(btnValid, BorderLayout.SOUTH);
		frame.add(panel);
		frame.setSize(300,210);
		frame.setVisible(true);
		frame.setResizable(false);
		
		getContentPane().validate();
	}

	public void stateChanged(ChangeEvent e) {
		slot.value=slider.getValue();
		slot.state=switcher.getValue();
		valueLabel = new JLabel("Valeur : " + slider.getValue()); 

	}
	
	
	
	

}
