package fr.MapSaver;

import java.awt.Component;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;

/**
 * Map Saver is an object that save the map into a .txt file.
 * @author Lasmaw
 */

public class MapSaver extends Component { 
  private File file = null;
  private int [][] map = null;

  public MapSaver(int[][] map) { //This is creating the saver
	  this.map=map;
  }

  public void save() throws Exception { //This is the function to save all data into a .txt file
    try {
      JFileChooser chooser = new JFileChooser();
      chooser.setVisible(true);
      chooser.showSaveDialog(MapSaver.this);
      file = chooser.getSelectedFile();

      PrintWriter printer = new PrintWriter(file);

      printer.println(map.length);
      printer.println(map[0].length);
      for (int k = 0; k < map.length; k++) {
        for (int l = 0; l < map[0].length; l++) {
          printer.println(map[k][l]);
        }
      }
      printer.println("$"); //a $ is set at the end so the load program know when the file is treated
      
      printer.close();
      

    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
}

