/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home;

import static home.CM_ToolHOME.path_lbl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author anupama
 */
public class AnalyseMethods {
    public static String totalComplexityDueToSize(String line) {
        return "0";
    }
    
    public static String totalComplexityDueToVariables(String line) {
        return "0";
    }
    
    public static String totalComplexityDueToMethods(String line) {
        int Npdtp = 0;
        int Ncdtp = 0;
        int Wmrt = 0;
        
        String [] crrline = line.split(" ");
        StringTokenizer token = new StringTokenizer(line);
                
        //Reading word by word
        while(token.hasMoreTokens()) {
                    
            String word = token.nextToken();

            //Finding class identifiers
            if((word.equals("public") || word.equals("private")) && word.equals("void")) {
                Wmrt = 0;
            }
                    
            if((word.equals("public") || word.equals("private")) && (word.equals("boolean") || word.equals("char") || word.equals("byte") || word.equals("short") || word.equals("int") || word.equals("long") || word.equals("float") || word.equals("double"))) {
                Npdtp = Npdtp + 1;
            }
                    
            if((word.equals("public") || word.equals("private")) && (word.equals("char[]") || word.equals("byte[]") || word.equals("short[]") || word.equals("int[]") || word.equals("long[]") || word.equals("float[]") || word.equals("double[]") || word.equals("ArrayList") || word.equals("LinkedList") || word.equals("Stack") || word.equals("HashTable") || word.equals("HashSet") || word.equals("HashTree"))) {
                Ncdtp = Ncdtp + 1;
            }
        }
        
        int Cm = Wmrt + Npdtp + (Ncdtp * 2);
        
        return String.valueOf(Cm);
//return "0";
    }
    
    public static String totalComplexityDueToInheritance(String line) {
        return "0";
    }
    
    public static String totalComplexityDueToCoupling(String line) {
        return "0";
    }
        
    public static String totalComplexityDueToCtrlStructures(String line) {
        // A conditional control structure such as an 'if' or 'else-if' condition
        if (line.contains(" if") || line.contains(" else if")) 
            return "2";
        
        // An iterative control structure such as a 'for', 'while', or 'do-while' loop
        if (line.contains(" for") || line.contains(" while") || line.contains(" do"))
            return "3";
        
        // The 'switch' statement in a 'switch-case' control structure 
        if (line.contains(" switch"))
            return "2";
        
        // Each 'case' statement in a 'switch-case' control structure
        if (line.contains(" case")) 
            return "1";
        
        else
            return "0";
    }
    
    public static void totalComplexity() {
        // get file path to the uploaded file
        String filepath = path_lbl.getText();

        File file = new File(filepath);

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String[] colNames = {"#", "Line", "Cs", "Cv", "Cm", "Ci", "Ccp", "Ccs", "TCps"};
        
            DefaultTableModel model = (DefaultTableModel) Analyse.jTable1.getModel();
            model.setColumnIdentifiers(colNames);

            Object[] lines = br.lines().toArray();
            
            // read the file line by line and check for the control structures
            for (int i = 1; i <= lines.length; i++) {
                String line = lines[i].toString();

                String col = String.valueOf(i);
                
                int size = Integer.parseInt(totalComplexityDueToSize(line)); // total complexity due to size
                int variables = Integer.parseInt(totalComplexityDueToVariables(line)); // total complexity due to variables
                int methods = Integer.parseInt(totalComplexityDueToMethods(line)); // total complexity due to methods
                int inheritance = Integer.parseInt(totalComplexityDueToInheritance(line)); // total complexity due to inheritance
                int coupling = Integer.parseInt(totalComplexityDueToCoupling(line)); // total complexity due to coupling
                int ctrl = Integer.parseInt(totalComplexityDueToCtrlStructures(line)); // total complexity due to control structures 
                
                String total = String.valueOf(size + variables + methods + inheritance + coupling + ctrl);
                
                String[] data = {col, line,
                    totalComplexityDueToSize(line),
                    totalComplexityDueToVariables(line),
                    totalComplexityDueToMethods(line),
                    totalComplexityDueToInheritance(line),
                    totalComplexityDueToCoupling(line),
                    totalComplexityDueToCtrlStructures(line),
                    total// total complexity
                };
                
                total();
                
                model.addRow(data);
                
                // Set column sizes
                Analyse.jTable1.setAutoResizeMode(Analyse.jTable1.AUTO_RESIZE_NEXT_COLUMN);
                TableColumnModel colModel = Analyse.jTable1.getColumnModel();
                colModel.getColumn(0).setPreferredWidth(35);
                colModel.getColumn(1).setPreferredWidth(300);
                colModel.getColumn(2).setPreferredWidth(35);
                colModel.getColumn(3).setPreferredWidth(35);
                colModel.getColumn(4).setPreferredWidth(35);
                colModel.getColumn(5).setPreferredWidth(35);
                colModel.getColumn(6).setPreferredWidth(35);
                colModel.getColumn(7).setPreferredWidth(35);
                colModel.getColumn(8).setPreferredWidth(35);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void total() {
        int total = 0;
        for (int i = 0; i < Analyse.jTable1.getRowCount(); i++) {
            total = total + Integer.parseInt(Analyse.jTable1.getValueAt(i, 8).toString());
        }

        Analyse.lbl_total.setText(Integer.toString(total));
    }
}
