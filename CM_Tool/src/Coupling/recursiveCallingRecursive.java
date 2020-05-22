
package Coupling;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class recursiveCallingRecursive {
    
    static int count12 = 0;
	private static ArrayList<String> recursivenMethodNames = new ArrayList<>();
        public static ArrayList<Integer> countList3 = new ArrayList<>();

	public  static void collectRecursiveMethods() throws IOException {
            
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
                        // Split the word using space
			words = strLine.split(" "); 

			for (int i = 0; i < words.length; i++) {
				for (int j = 0; j < words[i].length(); j++) {
				// Read the word char by char	
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
                                           // incriments if inside a method
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

						recursivenMethodNames.add(methodName);

					}

					// initializing for 0 in end of the method
				}

				insideMethod = 0;

			}

		}

		
	}

	public  static void searchForRecursiveInSameFile() throws IOException {
            
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

		String methodName1 = null;

		while ((strLine = br.readLine()) != null) {
				
			int k = 0;
                        // Split the word using space
			words = strLine.split(" "); 

			for (int i = 0; i < words.length; i++) {
				for (int j = 0; j < words[i].length(); j++) {
				// Read the word char by char	
                                    char ch = words[i].charAt(j); 
					if (ch == '"') {
						isString = isString + 1;
					}
				}
			}
			if (isString % 2 == 0) {

				for (String temp : recursivenMethodNames) {
					// System.out.println(temp);

					if (strLine.contains(input1) && strLine.contains(input3) && (strLine.contains(input2)
							|| strLine.contains(input5) || strLine.contains(input6) || strLine.contains(input7)) && strLine.contains(temp)) // check for methods
					{
						int l = 2;
						String mName[] = null;

						
						methodName1 = temp;
						System.out.println(methodName1);

						insideMethod++; // incriments

						if (strLine.contains(open)) {
							bracket++;
						}

						if (strLine.contains(closed)) {
							bracket--;
						}

					}

				}
                                count1 = 0;

				if (insideMethod == 0) {

					if (bracket > 0 && !strLine.contains(methodName1)) { // if inside method and have recursion call
							// count will increment

						for (String temp1 : recursivenMethodNames) {
							if (strLine.contains(temp1)) {
								count12++;
                                                                count1++;
							}
						}

					}

					// initializing for 0 in end of the method
				}

				insideMethod = 0;
				k = count1;

				System.out.println(strLine + "                                " + k);
                                countList3.add(k);
			}

		}

		

	}

	public int getCr() {
		return count12;
	}
    
}
