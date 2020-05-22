
package Coupling;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class regularCallingGlobal {
    
    
    static int count14 = 0;
	static final ArrayList<String> globalVaribales = new ArrayList<>();
	static String methodName1 = null;
	
	private static final ArrayList<String> regularmethodnames = new ArrayList<>();
	private static final ArrayList<String> recursivemethods = new ArrayList<>();
	private static final ArrayList<String> duplicateList = new ArrayList<>();
	private static final ArrayList<String> uniqueList = new ArrayList<>();
        public static ArrayList<Integer> countList5 = new ArrayList<>();

	public static void collectGloabalVaribales() throws IOException {
            
            
            File file2;
            file2 = coupling.file1;

		String[] words = null;
		FileInputStream fstream = new FileInputStream(file2);
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine;

		int isString = 0;
		String input1 = "public";
		String input2 = "void";
		String input3 = "(";
		String input4 = "static";
		String input5 = "int";
		String input6 = "String";
		String input7 = "float";
		String[] array1 = {};
		int loopCheck = 0;

		int insideMethod = 1;

		String open = "{";
		String closed = "}";
		int bracket = 0;

		String methodName = null;

		while ((strLine = br.readLine()) != null) {

			int k = 0;

			words = strLine.split(" ");

			for (int i = 0; i < words.length; i++) {
				for (int j = 0; j < words[i].length(); j++) {
					char ch = words[i].charAt(j); 
					if (ch == '"') {
						isString = isString + 1;
					}
				}
			}
			if (isString % 2 == 0) {

				if (strLine.contains(open)) {
					bracket++;
				}

				if (strLine.contains(closed)) {
					bracket--;
				}

				if (bracket == 1
						&& (strLine.contains(input5) || strLine.contains(input6) || strLine.contains(input7))) {
					int l = 1;
					String mName[] = null;

					if (strLine.contains(input4)) {
						l++;
					}

					methodName = words[l];

					System.out.println(methodName);
					
					globalVaribales.add(methodName);

				}

				

			}

		}
		

	}
	
	
	
	public static void collectMethods() throws IOException {
            
            File file2;
            file2 = coupling.file1;

		String[] words = null;
		FileInputStream fstream = new FileInputStream(file2);
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine;

		int isString = 0;
		String input1 = "public";
		String input2 = "void";
		String input3 = "(";
		String input4 = "static";
		String input5 = "int";
		String input6 = "String";
		String input7 = "float";

		int insideMethod = 1;

		String open = "{";
		String closed = "}";
		int bracket = 0;

		String methodName = null;

		while ((strLine = br.readLine()) != null) { 
			int k = 0;

			words = strLine.split(" "); 

			for (int i = 0; i < words.length; i++) {
				for (int j = 0; j < words[i].length(); j++) {
					char ch = words[i].charAt(j); 
					if (ch == '"') {
						isString = isString + 1;
					}
				}
			}
			if (isString % 2 == 0) {

				if (strLine.contains(input1) && strLine.contains(input3) && (strLine.contains(input2)
						|| strLine.contains(input5) || strLine.contains(input6) || strLine.contains(input7))) // check
																												// for
																												// methods
				{
					int l = 2;
					String mName[] = null;

					if (strLine.contains(input4)) {
						l++;
					}

					methodName = words[l];

					insideMethod++; 

					if (strLine.contains(open)) {
						bracket++;
					}

					if (strLine.contains(closed)) {
						bracket--;
					}

				}

				if (insideMethod == 0) {

					if (bracket > 0 && strLine.contains(methodName)) { // if inside method and have recursion call count
																		// will increment

						recursivemethods.add(methodName);
					}

					// initializing for 0 in end of the method
				}

				insideMethod = 0;

			}

		}

		
	}

	public static void storeReRegMethods() throws IOException {
            
            File file2;
            file2 = coupling.file1;

		String[] words = null;
		FileInputStream fstream = new FileInputStream(file2);
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine;

		int isString = 0;
		String input1 = "public";
		String input2 = "void";
		String input3 = "(";
		String input4 = "static";
		String input5 = "int";
		String input6 = "String";
		String input7 = "float";

		int insideMethod = 1;

		String open = "{";
		String closed = "}";
		int bracket = 0;

		String methodName = null;

		while ((strLine = br.readLine()) != null) {
				
			int k = 0;

			words = strLine.split(" "); // Split the word using space

			for (int i = 0; i < words.length; i++) {
				for (int j = 0; j < words[i].length(); j++) {
					char ch = words[i].charAt(j); // Read the word char by char
					if (ch == '"') {
						isString = isString + 1;
					}
				}
			}

			if (isString % 2 == 0) {

				if (strLine.contains(input1) && strLine.contains(input3) && (strLine.contains(input2)
						|| strLine.contains(input5) || strLine.contains(input6) || strLine.contains(input7))) // check
				
				{
					int l = 2;

					String mName[] = null;

					methodName = words[l];

					regularmethodnames.add(methodName);

				}

			}

		}

		
		
				
		
		
		
	}
	
	
	
	
	

	public static void searchForMethods() throws IOException {
		
		
		
		for (String item : regularmethodnames) {
		    if (recursivemethods.contains(item)) {
		        duplicateList.add(item);
		    } else {
		        uniqueList.add(item);
		    }
		}

		for (String naam : uniqueList) {
			System.out.println(naam);
		}
		File file2;
            file2 = coupling.file1;

		String[] words = null;
		FileInputStream fstream = new FileInputStream(file2);
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine;

		int isString = 0;
		String input1 = "public";
		String input2 = "void";
		String input3 = "(";
		String input4 = "static";
		String input5 = "int";
		String input6 = "String";
		String input7 = "float";

		int insideMethod = 1;

		String open = "{";
		String closed = "}";
		int bracket = 0;
                int count1 = 0 ;

		String methodName = null;

		String methods;

		while ((strLine = br.readLine()) != null) {
			int k = 0;

			words = strLine.split(" "); // Split the word using space

			for (int i = 0; i < words.length; i++) {
				for (int j = 0; j < words[i].length(); j++) {
					char ch = words[i].charAt(j); // Read the word char by char
					if (ch == '"') {
						isString = isString + 1;
					}
				}
			}
			if (isString % 2 == 0) {

				for (String temp2 : uniqueList) {

					if (strLine.contains(input1)
							&& strLine.contains(input3) && (strLine.contains(input2) || strLine.contains(input5)
									|| strLine.contains(input6) || strLine.contains(input7))
							&& strLine.contains(temp2)) // check
					
					{
						int l = 2;
						String mName[] = null;

						if (strLine.contains(input4)) {
							l++;
						}

						methodName = words[l];

						insideMethod++; // incriments if inside a method

						if (strLine.contains(open)) {
							bracket++;
						}

						if (strLine.contains(closed)) {
							bracket--;
						}

					}

				}
                                 count1 = 0 ;

				if (insideMethod == 0) {

					if (bracket > 0) { // if inside method and have recursion call count will increment

						for (String temp : globalVaribales) {
							// System.out.println(temp);
							if (strLine.contains(temp)) {
								count14++;
                                                                count1++;
							}
						}

					}

					// initializing for 0 in end of the method
				}

				insideMethod = 0;
				k = count1;

				System.out.println(strLine + "                                " + k);
                                countList5.add(k);
			}

		}

		

	}

	
	
	
	
	
	
	

	public int getCr() {
		return count14;
	}

    
    
}
