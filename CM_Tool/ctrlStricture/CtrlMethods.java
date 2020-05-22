/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctrlStricture;

import static home.CM_ToolHOME.path_lbl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author anupama
 */
public class CtrlMethods {
    public static void ctrlStructures() {
        // number of conditions in single line
        int count = 1;
        
        // Weights for each control structure
        int forIfElse = 2;
        int forForWhile = 3;
        int forSwitch = 2;
        int forCase = 1;
        int noCtrl = 0;
        
        // complexity of previous program
        int previous = 0;
        
        // calculate ccs
        int valIfElse = forIfElse * count;
        int valForWhile = forForWhile * count;
        int valSwitch = forSwitch * count;
        int valCase = forCase * count;
        int valNothing = noCtrl * count;
        
        // convert that values into string
        String nc = String.valueOf(count);
        String wtcsIfElse = String.valueOf(forIfElse);
        String wtcsForWhile = String.valueOf(forForWhile);
        String wtcsSwitch = String.valueOf(forSwitch);
        String wtcsCase = String.valueOf(forCase);
        String nothing = String.valueOf(noCtrl);
        String ccspps = String.valueOf(previous);
        
        // convert calculated values into string
        String ccsIfElse = String.valueOf(valIfElse);
        String ccsForWhile = String.valueOf(valForWhile);
        String ccsSwitch = String.valueOf(valSwitch);
        String ccsCase = String.valueOf(valCase);
        String ccsNothing = String.valueOf(valNothing);
        
        // get file path to the uploaded file
        String filepath = path_lbl.getText();

        File file = new File(filepath);

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            // give the table header
            String[] colNames = {"#", "Line", "Wtcs", "NC", "Ccspps", "Ccs"};

            DefaultTableModel model = (DefaultTableModel) CtrlTbl.jTable1.getModel();

            model.setColumnIdentifiers(colNames);

            Object[] lines = br.lines().toArray();

            // read the file line by line and check for the control structures
            for (int i = 1; i <= lines.length; i++) {
                String line = lines[i].toString();

                String col = String.valueOf(i);

                if (line.contains("//")) {
                    String[] data = {col, line, nothing, "0", ccspps, ccsNothing};
                    model.addRow(data);
                }
                else {
                    // A conditional control structure such as an 'if' or 'else-if' condition
                    if (line.contains("if") || line.contains("else if")) {
                        String[] data = {col, line, wtcsIfElse, nc, ccspps, ccsIfElse};
                        model.addRow(data);
                    }

                    // An iterative control structure such as a 'for', 'while', or 'do-while' loop
                    if (line.contains("for") || line.contains("while") || line.contains("do")) {
                        String[] data = {col, line, wtcsForWhile, nc, ccspps, ccsForWhile};
                        model.addRow(data);
                    }

                    // The 'switch' statement in a 'switch-case' control structure 
                    if (line.contains("switch")) {
                        String[] data = {col, line, wtcsSwitch, nc, ccspps, ccsSwitch};
                        model.addRow(data);
                    }

                    // Each 'case' statement in a 'switch-case' control structure
                    if (line.contains("case")) {
                        String[] data = {col, line, wtcsCase, nc, ccspps, ccsCase};
                        model.addRow(data);
                    } // Lines without any control structure
                    else {
                        String[] data = {col, line, nothing, "0", ccspps, ccsNothing};
                        model.addRow(data);
                    }
                }
                
                getCtrlTotal();

                // Set column sizes
                CtrlTbl.jTable1.setAutoResizeMode(CtrlTbl.jTable1.AUTO_RESIZE_NEXT_COLUMN);
                TableColumnModel colModel = CtrlTbl.jTable1.getColumnModel();
                colModel.getColumn(0).setPreferredWidth(25);
                colModel.getColumn(1).setPreferredWidth(400);
                colModel.getColumn(2).setPreferredWidth(35);
                colModel.getColumn(3).setPreferredWidth(25);
                colModel.getColumn(4).setPreferredWidth(50);
                colModel.getColumn(5).setPreferredWidth(25);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
    
    public static void getCtrlTotal() {
        int total = 0;
        for (int i = 0; i < CtrlTbl.jTable1.getRowCount(); i++) {
            total = total + Integer.parseInt(CtrlTbl.jTable1.getValueAt(i, 5).toString());
        }
        
        CtrlTbl.ctrl_lbl_total.setText(Integer.toString(total));
    }
}
