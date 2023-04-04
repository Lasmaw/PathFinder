package fr.MapParser;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MapParser extends Component {
  private File file = null;
  private int [][] map = null;

  public MapParser() {
  }

  public int [][] parse() throws Exception {
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
