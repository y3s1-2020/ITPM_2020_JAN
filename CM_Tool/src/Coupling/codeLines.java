
package Coupling;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class codeLines {
    
    
        public static ArrayList<String> linesList = new ArrayList<>();
    
    
    
    public static void readLines() throws IOException {
		
        
        File file2;
            file2 = coupling.file1;
        
		String[] words=null;
		FileInputStream fstream = new FileInputStream(file2);
		  DataInputStream in = new DataInputStream(fstream);
		  BufferedReader br = new BufferedReader(new InputStreamReader(in));
		  String strLine;
                  
                  while((strLine=br.readLine()) != null)
			{
                            linesList.add(strLine);
                        }
                  
                  
    
    }
    
    
}
