package fr.MapParser;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Map Parser is an object that load the map from a .txt file.
 * @author Lasmaw
 */

public class MapParser extends Component { 
  private File file = null;
  private int [][] map = null;

  public MapParser() { //this is creating a parser
  }

  public int [][] parse() throws Exception { //this function treat the .txt file and load every data from it
    try {
      JFileChooser chooser = new JFileChooser();
      chooser.setVisible(true);
      chooser.showOpenDialog(MapParser.this);
      file = chooser.getSelectedFile();

      Scanner lines = new Scanner(file);

      if (!lines.hasNextInt())
        throw new Exception("Error opening the file.");

      int i = lines.nextInt();

      if (!lines.hasNextInt())
        throw new Exception("Incorrect format.");
      int j = lines.nextInt();

      map = new int[i][j];
      for (int k = 0; k < i; k++) {
        for (int l = 0; l < j; l++) {
          if (!lines.hasNextInt()) throw new Exception("Incorrect format.");
          map[k][l] = lines.nextInt();
        }
        
      }
      
      lines.close();
      
      return map;

    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
}
