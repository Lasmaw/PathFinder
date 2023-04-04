package fr.pathfinder.fileGestion;

import java.io.IOException;
import java.io.Reader;

public class FileTraitor {
	
	
	public FileTraitor(Reader file) throws IOException{
		ReadFile reader=new ReadFile();
		int[] map;
		int i;
		
		reader.read(file);
		
		map = new int [12];
		i=0;
		while (reader.Ver[i].charAt(0)!='$'){
			try {
				map[i]= Integer.parseInt (reader.Ver[i]);
			}
			catch (Exception e) {map[i]=0;}
		
			System.out.print("T : "+map[i]+"\n");
			i=i+1;
		}
	}
	
	
	

}
