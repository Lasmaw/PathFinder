package fr.pathfinder.graphic_interface;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import fr.pathfinder.carte.Case;
import fr.pathfinder.carte.CellMap;


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
	CellMap carte;
	int slotCase;
	int currentState;
	
	
	public StateModificaterWin(CellMap usedMap, Case slotCarte){
		this.carte=usedMap;
		this.slot=slotCarte;
		this.currentState=slotCarte.state;
		
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
				
				switch(switcher.getValue()) {
				case -1:
					usedMap.strtCount++;
					if(usedMap.strtCount>0) {
						usedMap.strtCount=0;
						for(int i=0;i<usedMap.size;i++) {
							for(int j=0;j<usedMap.size;j++) {
								if(usedMap.map[i][j].state==-1) {
									usedMap.map[i][j].state=0;
									usedMap.map[i][j].autoCol();
									usedMap.map[i][j].btn.setBackground(usedMap.map[i][j].color);
								}
								
							}
						}
					}
					usedMap.start=slotCarte;
					break;
				case 0:
					break;
				case 1:
					usedMap.fnshCount++;
					if(usedMap.fnshCount>0) {
						usedMap.fnshCount=0;
						for(int i=0;i<usedMap.size;i++) {
							for(int j=0;j<usedMap.size;j++) {
								if(usedMap.map[i][j].state==1) {
									usedMap.map[i][j].state=0;
									usedMap.map[i][j].autoCol();
									usedMap.map[i][j].btn.setBackground(usedMap.map[i][j].color);
								}
								
							}
						}
					}
					usedMap.finish=slotCarte;
					break;
				default:
					break;
				}
				
				slotCarte.value=slider.getValue();
				slotCarte.state=switcher.getValue();

				slotCarte.autoCol();
				slotCarte.btn.setBackground(slotCarte.color);
				
				
				
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
		frame.setLocationRelativeTo(null);
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
