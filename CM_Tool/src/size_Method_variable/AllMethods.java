/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package size_Method_variable;

import home.CM_ToolHOME;
import static home.CM_ToolHOME.path_lbl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author anupama
 */
public class AllMethods {

    public static void variables() {
        //Default weights for each weight component
        int Wvs = 0;
        int Wpdtv = 1;
        int Wcdtv = 2;
        
        //Number of variable components
        int Npdtv = 0;
        int Ncdtv = 0;
        
        int Cv = 0;
        
        //Calculate weights for each variable component
       
        //Getting the filepath
        String filepath = path_lbl.getText();
        
        File file = new File(filepath);
        
        try {
            
            BufferedReader br = new BufferedReader(new FileReader(file));
            
             // give the table header
            String[] colNames = {"#", "Line", "Wvs", "Npdtv", "Ncdtv", "Cv"};
            
            DefaultTableModel model = (DefaultTableModel) Variables.jTable1.getModel();
            
            model.setColumnIdentifiers(colNames);
             
            Object[] lines = br.lines().toArray();
            
            //Reading the file line by line
            for (int i = 0; i <= lines.length; i++)
            {
                String line = lines[i].toString();
                
                String col = String.valueOf(i);
                
                String [] crrline = line.split(" ");
                StringTokenizer token = new StringTokenizer(line);
                
                while(token.hasMoreTokens())
                {
                    String word = token.nextToken();
                    
                    //Checking if variable is local
                    if(word.equals("private"))
                    {
                        Wvs = 1;
                        
                        //Checking if varibale is primitive
                        if(word.equals("boolean") || word.equals("char") || word.equals("byte") || word.equals("short") || word.equals("int") || word.equals("long") || word.equals("float") || word.equals("double"))
                        {
                            Npdtv = Npdtv +1;
                        }
                        //Checking if variable is composite
                        else if(word.equals("char[]") || word.equals("byte[]") || word.equals("short[]") || word.equals("int[]") || word.equals("long[]") || word.equals("float[]") || word.equals("double[]") || word.equals("ArrayList") || word.equals("LinkedList") || word.equals("Stack") || word.equals("HashTable") || word.equals("HashSet") || word.equals("HashTree"))
                        {
                            Ncdtv = Ncdtv + 1;
                        }
                    }
                    
                    else if (word.equals("public")) //Checking if variable is global
                    {
                        Wvs = 2;
                         
                         //Checking if varibale is primitive
                        if(word.equals("boolean") || word.equals("char") || word.equals("byte") || word.equals("short") || word.equals("int") || word.equals("long") || word.equals("float") || word.equals("double"))
                        {
                            Npdtv = Npdtv +1;
                        }
                        //Checking if variable is composite
                        else if(word.equals("char[]") || word.equals("byte[]") || word.equals("short[]") || word.equals("int[]") || word.equals("long[]") || word.equals("float[]") || word.equals("double[]") || word.equals("ArrayList") || word.equals("LinkedList") || word.equals("Stack") || word.equals("HashTable") || word.equals("HashSet") || word.equals("HashTree"))
                        {
                            Ncdtv = Ncdtv + 1;
                        }
                    }
                
                    Cv = Wvs * ((Wpdtv * Npdtv) + (Wcdtv * Ncdtv));
                }
        
                //Converts number of variable components to string
                String sNpdtv = String.valueOf(Npdtv);
                String sNcdtv = String.valueOf(Ncdtv);
                String sWvs = String.valueOf(Wvs);
                String sCv = String.valueOf(Cv);
   
                String[] data = {col, line, sWvs, sNpdtv, sNcdtv, sCv};
                model.addRow(data);
                
                Npdtv = 0; Ncdtv = 0; Wvs = 0;
                
                getVariableTotal();
                
                // Set column sizes
                Variables.jTable1.setAutoResizeMode(Variables.jTable1.AUTO_RESIZE_NEXT_COLUMN);
                TableColumnModel colModel = Variables.jTable1.getColumnModel();
                colModel.getColumn(0).setPreferredWidth(25);
                colModel.getColumn(1).setPreferredWidth(400);
                colModel.getColumn(2).setPreferredWidth(35);
                colModel.getColumn(3).setPreferredWidth(35);
                colModel.getColumn(4).setPreferredWidth(35);
                colModel.getColumn(5).setPreferredWidth(35);
            }     
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CM_ToolHOME.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void getVariableTotal() {
        int total = 0;
        for (int i = 0; i < Variables.jTable1.getRowCount(); i++) {
            total = total + Integer.parseInt(Variables.jTable1.getValueAt(i, 5).toString());
        }
        
        Variables.lbl_total_var.setText(Integer.toString(total));
    }

    public static void sizeMethod() {

        //FOR SIZE CALCULATION
        //Default weights for each size component
        int Wkw = 1;
        int Wid = 1;
        int Wop = 1;
        int Wnv = 1;
        int Wsl = 1;

        //Number or size components
        int Nkw = 0;
        int Nid = 0;
        int Nop = 0;
        int Nnv = 0;
        int Nsl = 0;
        int Cs = 0;

        //Getting the filepath
        String filepath = path_lbl.getText();

        File file = new File(filepath);

        try {

            BufferedReader br = new BufferedReader(new FileReader(file));

            // give the table header
            String[] colNames = {"#", "Line", "Nkw", "Nid", "Nop", "Nnv", "Nsl", "Cs"};

            DefaultTableModel model = (DefaultTableModel) SizeTable.jTable1.getModel();

            model.setColumnIdentifiers(colNames);

            Object[] lines = br.lines().toArray();

            //Reading the file line by line
            for (int i = 0; i <= lines.length; i++) {
                String line = lines[i].toString();

                String col = String.valueOf(i);

                String[] crrline = line.split(" ");
                StringTokenizer token = new StringTokenizer(line);

                while (token.hasMoreTokens()) {
                    String word = token.nextToken();

                    //Finding keywords
                    if (word.equals("void") || word.equals("assert") || word.equals("break") || word.equals("catch") || word.equals("class") || word.equals("const") || word.equals("continue") || word.equals("default") || word.equals("else") || word.equals("enum") || word.equals("extends") || word.equals("final") || word.equals("finally") || word.equals("goto") || word.equals("implements") || word.equals("") || word.equals("import") || word.equals("instanceof") || word.equals("interface") || word.equals("native") || word.equals("new") || word.equals("private") || word.equals("protected") || word.equals("public") || word.equals("return") || word.equals("static") || word.equals("strictfp") || word.equals("super") || word.equals("synchronized") || word.equals("this") || word.equals("throw") || word.equals("throws") || word.equals("transient") || word.equals("try") || word.equals("volatile") || word.equals("false") || word.equals("true") || word.equals("null")) {
                        Nkw = Nkw + 1;
                    }

                    //Finding class identifiers
                    if (word.equals("class") && word.equals("public")) {
                        Nid = Nid + 1;
                    }

                    //Finding method identifiers
                    if (word.equals("public") || word.equals("private")) {
                        Nid = Nid + 1;
                    }

                    //Finding variable identifiers
                    if (word.equals("for") || word.equals("while") || word.equals("do") || word.equals("if") || word.equals("switch") || word.equals("case")) {
                        if (word.equals("boolean") || word.equals("char") || word.equals("byte") || word.equals("short") || word.equals("int") || word.equals("long") || word.equals("float") || word.equals("couble") || word.equals("String")) {
                            Nid = Nid + 1;
                        }
                    }

                    //Finding object identifiers
                    if (word.equals("new")) {
                        Nid = Nid + 1;
                    }

                    //Finding data structure identifiers
                    if (word.equals("collection") || word.equals("linkedlist") || word.equals("stack") || word.equals("hashset") || word.equals("hashtable") || word.equals("ArrayList") || word.equals("hashtree")) {
                        Nid = Nid + 1;
                    }

                    //Finding operators
                    if (word.equals("+") || word.equals("-") || word.equals("*") || word.equals("/") || word.equals("%") || word.equals("++") || word.equals("--") || word.equals("==") || word.equals("!=") || word.equals(">") || word.equals("<") || word.equals(">=") || word.equals("<=") || word.equals("&&") || word.equals("||") || word.equals("!") || word.equals("|") || word.equals("^") || word.equals("~") || word.equals("<<") || word.equals(">>") || word.equals(">>>") || word.equals("<<<") || word.equals(",") || word.equals("->") || word.equals(".") || word.equals("::") || word.equals("+=") || word.equals("-=") || word.equals("*=") || word.equals("/=") || word.equals("=") || word.equals(">>>=") || word.equals("|=") || word.equals("&=") || word.equals("%=") || word.equals("<<=") || word.equals(">>=") || word.equals("^=")) {
                        Nop = Nop + 1;
                    }

                    //Finding numerical values
                    if (word.equals("[0-9]")) {
                        Nnv = Nnv + 1;
                    }

                    //Finding string literals
                    Pattern p3 = Pattern.compile("\"([^\"]*)\"");
                    Matcher m3 = p3.matcher(word);

                    while (m3.find()) {//String between double quotes found
                        Nsl = Nsl + 1;
                    }
                    
                    //Calculate weight for each component
                    int valWkw = Wkw * Nkw;
                    int valWid = Wid * Nid;
                    int valWop = Wop * Nop;
                    int valWnv = Wnv * Nnv;
                    int valWsl = Wsl * Nsl;                    

                    Cs = valWkw + valWid + valWop + valWnv + valWsl;

                }

                //Convert number of size compoenets to string
                String sNkw = String.valueOf(Nkw);
                String sNid = String.valueOf(Nid);
                String sNop = String.valueOf(Nop);
                String sNnv = String.valueOf(Nnv);
                String sNsl = String.valueOf(Nsl);
                String sCs = String.valueOf(Cs);

                String[] data = {col, line, sNkw, sNid, sNop, sNnv, sNsl, sCs};
                model.addRow(data);

                Nkw = 0; Nid = 0; Nop = 0; Nnv = 0; Nsl = 0;
                
                getSizeTotal();
        
                // Set column sizes
                SizeTable.jTable1.setAutoResizeMode(SizeTable.jTable1.AUTO_RESIZE_NEXT_COLUMN);
                TableColumnModel colModel = SizeTable.jTable1.getColumnModel();
                colModel.getColumn(0).setPreferredWidth(25);
                colModel.getColumn(1).setPreferredWidth(400);
                colModel.getColumn(2).setPreferredWidth(35);
                colModel.getColumn(3).setPreferredWidth(35);
                colModel.getColumn(4).setPreferredWidth(35);
                colModel.getColumn(5).setPreferredWidth(35);
                colModel.getColumn(6).setPreferredWidth(35);
                colModel.getColumn(7).setPreferredWidth(35);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CM_ToolHOME.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void getSizeTotal() {
        int total = 0;
        for (int i = 0; i < SizeTable.jTable1.getRowCount(); i++) {
            total = total + Integer.parseInt(SizeTable.jTable1.getValueAt(i, 7).toString());
        }
        
        SizeTable.lbl_total_size.setText(Integer.toString(total));
    }

    public static void methods() {
        //Default weights for each method component
        int Wmrt = 0;
        int Wpdtp = 1;
        int Wcdtp = 2;
        int Cm = 0;
        
        //No of method compoenents
        int Npdtp = 0;
        int Ncdtp = 0;
        
        //Getting the filepath
        String filepath = path_lbl.getText();
        
        File file = new File(filepath);
        
        try {
            
            BufferedReader br = new BufferedReader(new FileReader(file));
            
             // give the table header
            String[] colNames = {"#", "Line", "Wmrt", "Npdtp", "Ncdtp", "Cm"};
            
            DefaultTableModel model = (DefaultTableModel) MethodTable.jTable1.getModel();
            
            model.setColumnIdentifiers(colNames);
             
            Object[] lines = br.lines().toArray();
            
            //Reading the file line by line
            for (int i = 0; i <= lines.length; i++)
            {
                String line = lines[i].toString();
                
                String col = String.valueOf(i);
                
                String [] crrline = line.split(" ");
                StringTokenizer token = new StringTokenizer(line);
                
                //Reading word by word
                while(token.hasMoreTokens())
                {
                    
                    String word = token.nextToken();

                    //Finding class identifiers
                    if(word.equals("public") || word.equals("private")&& word.equals("void"))
                    {
                        Wmrt = 0;
                    }
                    
                    if(word.equals("public") || word.equals("private")&& word.equals("boolean") || word.equals("char") || word.equals("byte") || word.equals("short") || word.equals("int") || word.equals("long") || word.equals("float") || word.equals("double"))
                    {
                        Npdtp = Npdtp + 1;
                    }
                    
                    if(word.equals("public") || word.equals("private") && word.equals("char[]") || word.equals("byte[]") || word.equals("short[]") || word.equals("int[]") || word.equals("long[]") || word.equals("float[]") || word.equals("double[]") || word.equals("ArrayList") || word.equals("LinkedList") || word.equals("Stack") || word.equals("HashTable") || word.equals("HashSet") || word.equals("HashTree"))
                    {
                        Ncdtp = Ncdtp + 1;
                    }
                
                    Cm = Wmrt + (Wpdtp * Npdtp) + (Wcdtp * Ncdtp);
                }
        
                //Convert number of method components to string
                String sWmrt = String.valueOf(Wmrt);
                String sNpdtp = String.valueOf(Npdtp);
                String sNcdtp = String.valueOf(Ncdtp);
                String sCm = String.valueOf(Cm);
                
                String[] data = {col, line, sWmrt, sNpdtp, sNcdtp, sCm};
                model.addRow(data);
                
                Wmrt = 0; Npdtp = 0; Ncdtp = 0;
                
                getmethodTotal();
                
                // Set column sizes
                MethodTable.jTable1.setAutoResizeMode(MethodTable.jTable1.AUTO_RESIZE_NEXT_COLUMN);
                TableColumnModel colModel = MethodTable.jTable1.getColumnModel();
                colModel.getColumn(0).setPreferredWidth(25);
                colModel.getColumn(1).setPreferredWidth(400);
                colModel.getColumn(2).setPreferredWidth(35);
                colModel.getColumn(3).setPreferredWidth(35);
                colModel.getColumn(4).setPreferredWidth(35);
                colModel.getColumn(5).setPreferredWidth(35);
            }     
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CM_ToolHOME.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void getmethodTotal() {
        int total = 0;
        for (int i = 0; i < MethodTable.jTable1.getRowCount(); i++) {
            total = total + Integer.parseInt(MethodTable.jTable1.getValueAt(i, 5).toString());
        }
        
        MethodTable.lbl_total_methods.setText(Integer.toString(total));
    }
}
