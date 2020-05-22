/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package size_Method_variable;

import ctrlStricture.CtrlTbl;
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
                    
                    //Calculate weight for each component
                    int valWkw = Wkw * Nkw;
                    int valWid = Wid * Nid;
                    int valWop = Wop * Nop;
                    int valWnv = Wnv * Nnv;
                    int valWsl = Wsl * Nsl;                    

                    Cs = valWkw + valWid + valWop + valWnv + valWsl;

                    //Finding string literals
                    Pattern p3 = Pattern.compile("\"([^\"]*)\"");
                    Matcher m3 = p3.matcher(word);

                    while (m3.find()) {//String between double quotes found
                        Nsl = Nsl + 1;
                    }

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
    }
}
