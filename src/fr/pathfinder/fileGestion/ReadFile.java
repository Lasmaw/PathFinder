package fr.pathfinder.fileGestion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class ReadFile {
	
	
	String [] Ver=null;


	void read(Reader file) throws IOException{
		int i;
		String S=new String();
		BufferedReader myFile = new BufferedReader(file);
		
		
		i=0;
		S = myFile.readLine();
		int y= S.charAt(0);
		S = myFile.readLine();
		
		Ver = new String [S.charAt(0)*y];
		while (S.charAt(0)!='$'){
			Ver[i]=S;
			System.out.print("Lecture "+Ver[i]+"\n");
			i++;
			S = myFile.readLine();		
		}
		
		Ver[i]=S;				
		myFile.close();
		
	} // lire()
	
	
}
