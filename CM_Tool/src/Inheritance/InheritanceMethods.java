/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inheritance;

import static home.CM_ToolHOME.jComboBox1;
import static home.CM_ToolHOME.jTextArea1;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author anupama
 */
public class InheritanceMethods {
    public static void inheritance() {
        String fullcode = jTextArea1.getText();
        String combo = jComboBox1.getSelectedItem().toString(); //get Combobox selected item value to the variable
        int total = 0;

        if (combo.equals("C++")) {
                
            Pattern p1 = Pattern.compile(" : public");
            Matcher m1 = p1.matcher(fullcode);

            Pattern p8 = Pattern.compile(" : protected");
            Matcher m8 = p8.matcher(fullcode);

            Pattern p9 = Pattern.compile(" : private");
            Matcher m9 = p9.matcher(fullcode);

            Pattern p10 = Pattern.compile(" : abstract");
            Matcher m10 = p10.matcher(fullcode);

            Pattern p11 = Pattern.compile(" : static");
            Matcher m11 = p11.matcher(fullcode);

            Pattern p12 = Pattern.compile(" : final");
            Matcher m12 = p12.matcher(fullcode);

            Pattern p13 = Pattern.compile(" : synchronized");
            Matcher m13 = p13.matcher(fullcode);

            Pattern p14 = Pattern.compile(" : volatile");
            Matcher m14 = p14.matcher(fullcode);

            while (m1.find() | m8.find() | m9.find() | m10.find() | m11.find() | m12.find() | m13.find() | m14.find()) {  //C++ child found
                total = total + 1;
                System.out.println(" c++ complexity due to inheritance : " + total);
            }

        } else {
            //Complexity due to Inheritance of a Java code
            Pattern p2 = Pattern.compile(" extends ");
            Matcher m2 = p2.matcher(fullcode);

            while (m2.find()) {   //Java child found
                total = total + 1;
                System.out.println("java complexity due to inheritance : " + total);
            }

        }
    }
}
