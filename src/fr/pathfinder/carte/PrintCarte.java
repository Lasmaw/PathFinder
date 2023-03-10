package fr.pathfinder.carte;

import java.awt.Color;
import java.io.FileWriter;
import java.io.IOException;

public class PrintCarte {
	
	PrintCarte(String name, Case cart[][]) throws IOException {
		int i,j;
		FileWriter file = new FileWriter(name + ".txt");
		
		for(i=0;i<12;i++) {
			for(j=0;j<12;j++) {
				file.write(" " + cart[i][j].value + " ");
			}
			file.write("\n");
		}
		
		System.out.println(Color.RED + "Carte imprimée !");
		file.close();
	}
}
