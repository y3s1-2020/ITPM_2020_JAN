/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package size_Method_variable;

import ctrlStricture.*;
import home.CM_ToolHOME;
import static home.CM_ToolHOME.jDesktopPane1;
import static home.CM_ToolHOME.path_lbl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import static size_Method_variable.AllMethods.getmethodTotal;

/**
 *
 * @author anupama
 */
public class MethodsWeight extends javax.swing.JInternalFrame {

    MethodTable tbl;
    
    /**
     * Creates new form CtrlWeight
     */
    public MethodsWeight() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setClosable(true);

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setText("Program Component");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel2.setText("Weight");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel4.setText("Method with a primitive return type");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel5.setText("Primitive data type parameter");

        jLabel6.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel6.setText("Method with a void return type");

        jLabel7.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel7.setText("Method with a composite return type");

        jButton2.setText("Save");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField1.setText("1");

        jTextField2.setText("2");

        jTextField3.setText("0");

        jTextField4.setText("1");
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jTextField5.setText("2");

        jLabel8.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel8.setText("Composite data type parameter");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(71, 71, 71)
                        .addComponent(jLabel2)
                        .addGap(41, 41, 41))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField1)
                                .addComponent(jTextField2)
                                .addComponent(jTextField3)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Show a success message
        JOptionPane.showMessageDialog(this, "Done");
        
        // Return to the previous intrface
        if (tbl == null) {
            jDesktopPane1.removeAll();
            MethodTable x = new MethodTable();
            jDesktopPane1.add(x).setVisible(true);
            this.dispose();
        } else {
            jDesktopPane1.removeAll();
            jDesktopPane1.add(tbl).setVisible(true);
            this.dispose();
        }
        
        methods();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Go back to the previous interface
        if (tbl == null) {
            jDesktopPane1.removeAll();
            MethodTable x = new MethodTable();
            jDesktopPane1.add(x).setVisible(true);
            this.dispose();
        } else {
            jDesktopPane1.removeAll();
            jDesktopPane1.add(tbl).setVisible(true);
            this.dispose();
        }
        
        methods();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    public void methods() {
        //Default weights for each method component
        int Wmrt = Integer.parseInt(jTextField1.getText());
        int Wpdtp = Integer.parseInt(jTextField2.getText());
        int Wcdtp = Integer.parseInt(jTextField3.getText());
        int Cm = Integer.parseInt(jTextField4.getText());
        
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
    
    CM_ToolHOME h;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
