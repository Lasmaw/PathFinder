package fr.pathfinder.graphic_interface;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class NewMapWin extends JFrame implements ChangeListener{

	private static final long serialVersionUID = -3675206766922526803L;

	JFrame frame = new JFrame("Nouvelle carte");
	JPanel panel = new JPanel();
	JButton btnValid = new JButton("Valider");
	JLabel valueLabel;
	JSlider slider;
	int size=8;
	
	NewMapWin(JPanel panelMenu){
       
		
		valueLabel = new JLabel();
		slider = new JSlider(4,12,size);
		
		valueLabel.setText("Taille de la carte :");
		
		slider.setPaintTrack(true); 
        slider.setPaintTicks(true); 
        slider.setPaintLabels(true); 
		slider.setMajorTickSpacing(4);
		slider.setMinorTickSpacing(1);
		
		btnValid.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				size=slider.getValue();
				frame.dispose();
				Path path = new Path(size);
				getContentPane().remove(panelMenu);
			}
		});
		
		frame.pack();
		frame.setSize(300,150);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.add(panel);
		frame.add(btnValid,BorderLayout.SOUTH);
		panel.add(valueLabel);
		panel.add(slider);
		getContentPane().validate();
	}
	
	public void stateChanged(ChangeEvent e) {
		this.size=slider.getValue();
		
	}

	
}
