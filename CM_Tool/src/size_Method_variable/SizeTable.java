/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package size_Method_variable;

import ctrlStricture.CtrlWeight;
import static home.CM_ToolHOME.jDesktopPane1;

/**
 *
 * @author yelan
 */
public class SizeTable extends javax.swing.JInternalFrame {

    /**
     * Creates new form SizeTable
     */
    public SizeTable() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setMaximumSize(new java.awt.Dimension(699, 547));
        setMinimumSize(new java.awt.Dimension(699, 547));
        setPreferredSize(new java.awt.Dimension(699, 547));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "import java.util.Scanner;", "0", "0", "0", "0", "0", "0"},
                {"2", "class Years{", "1", "1", "0", "0", "0", "2"},
                {"3", "public int getYear(){", "1", "1", "0", "0", "0", "2"},
                {"4", "int year;", "0", "0", "0", "0", "0", "0"},
                {"5", "String enteredYear;", "0", "0", "0", "0", "0", "0"},
                {"6", "Scanner sc = new Scanner(System.in);", "1", "0", "0", "0", "0", "1"},
                {"7", "System.out.println(\"Enter the year as a number :\");", "0", "3", "2", "0", "1", "6"},
                {"8", "enteredYear = sc.next();", "0", "1", "1", "0", "0", "2"},
                {"9", "year = Integer.parseInt(enteredYear);", "0", "2", "1", "0", "0", "3"},
                {"10", "return year;", "1", "0", "0", "0", "0", "1"},
                {"11", "}", "0", "0", "0", "0", "0", "0"},
                {"12", "}", "0", "0", "0", "0", "0", "0"},
                {"13", "//------------------------------------------------------------------------------------------------------------------------------------", "0", "0", "0", "0", "0", "0"},
                {"14", "class Months extends Years{", "2", "2", "0", "0", "0", "4"},
                {"15", "public int getMonth(){", "1", "1", "0", "0", "0", "2"},
                {"16", "int month;", "0", "0", "0", "0", "0", "0"},
                {"17", "String enteredMonthNumber;", "0", "0", "0", "0", "0", "0"},
                {"18", "Scanner sc = new Scanner(System.in);", "1", "0", "0", "0", "0", "0"},
                {"19", "System.out.println(\"Enter the month number :\");", "0", "3", "0", "0", "1", "4"},
                {"20", "enteredMonthNumber = sc.next();", "0", "1", "1", "0", "0", "0"},
                {"21", "month = Integer.parseInt(enteredMonthNumber);", "0", "2", "1", "0", "0", "2"},
                {"22", "return month;", "1", "1", "0", "0", "0", "2"},
                {"23", "}", "0", "0", "0", "0", "0", "0"},
                {"24", "}", "0", "0", "0", "0", "0", "0"},
                {"25", "//------------------------------------------------------------------------------------------------------------------------------------", "0", "0", "0", "0", "0", "0"},
                {"26", "class DaysPerMonth extends Months{ ", "2", "2", "0", "0", "0", "4"},
                {"27", "static int numDays = 0;", "1", "0", "1", "1", "0", "3"},
                {"28", "public static void main(String[] args) {", "3", "1", "0", "0", "0", "4"},
                {"29", "int year;", "0", "0", "0", "0", "0", "0"},
                {"30", " Months m = new Months();", "0", "1", "1", "0", "0", "2"},
                {"31", "int month = m.getMonth();", "0", "1", "2", "0", "0", "3"},
                {"32", " ", "0", "0", "0", "0", "0", "0"},
                {"33", "if((month < 1) || (month > 12)){ ", "0", "0", "3", "2", "0", "6"},
                {"34", " System.out.println(\"Kindly enter a number between 0 to 13.\");", "0", "3", "0", "0", "1", "4"},
                {"35", "}", "0", "0", "0", "0", "0", "0"},
                {"36", "else {", "1", "0", "0", "0", "0", "1"},
                {"37", "switch (month) {", "0", "0", "0", "0", "0", "0"},
                {"38", "case 1:", "0", "0", "0", "1", "0", "1"},
                {"39", "case 3:", "0", "0", "0", "1", "0", "1"},
                {"40", "case 5:", "0", "0", "0", "1", "0", "1"},
                {"41", "case 7:", "0", "0", "0", "1", "0", "1"},
                {"42", "case 8:", "0", "0", "0", "1", "0", "1"},
                {"43", "case 10:", "0", "0", "0", "1", "0", "1"},
                {"44", "case 12:", "0", "0", "0", "1", "0", "1"},
                {"45", "numDays = 31;", "0", "1", "1", "1", "0", "3"},
                {"46", "System.out.println(\"Month \" + month + \" consists of \" + numDays + \" days.\");", "0", "5", "6", "0", "3", "14"},
                {"47", "break;", "1", "0", "0", "0", "0", "1"},
                {"48", " case 4:", "0", "0", "0", "1", "0", "1"},
                {"49", "case 6:", "0", "0", "0", "1", "0", "1"},
                {"50", " case 9:", "0", "0", "0", "1", "0", "1"},
                {"51", "case 11:", "0", "0", "0", "1", "0", "1"},
                {"52", "numDays = 30;", "0", "1", "1", "1", "0", "3"},
                {"53", "System.out.println(\"Month \" + month + \" consists of \" + numDays + \" days.\");", "0", "5", "6", "0", "3", "14"},
                {"54", " break;", "1", "0", "0", "0", "0", "1"},
                {"55", "case 2:", "0", "0", "0", "1", "0", "1"},
                {"56", " year = m.getYear();", "0", "3", "1", "0", "0", "4"},
                {"57", "if(year < 1) {", "0", "1", "1", "1", "0", "3"},
                {"58", "System.out.println(\"Kindly enter a valid year.\");", "0", "3", "2", "0", "1", "6"},
                {"59", "}", "0", "0", "0", "0", "0", "0"},
                {"60", "else{", "1", "0", "0", "0", "0", "1"},
                {"61", "if(((year % 4 == 0) &&  !(year % 100 == 0)) || (year % 400 == 0)){", "0", "3", "9", "6", "0", "18"},
                {"62", "numDays = 29;", "0", "1", "1", "1", "0", "3"},
                {"63", "if(year > 2020){", "0", "1", "1", "1", "0", "3"},
                {"64", "System.out.println(\"In year \" + year + \" month \" + month + \" will consist of \" + numDays + \" days.\");", "0", "6", "8", "0", "4", "18"},
                {"65", "}", "0", "0", "0", "0", "0", "0"},
                {"66", "else{", "1", "0", "0", "0", "0", "0"},
                {"67", "  System.out.println(\"In year \" + year + \" month \" + month + \" has consisted of \" + numDays + \" days.\");", "0", "6", "8", "0", "4", "18"},
                {"68", " }", "0", "0", "0", "0", "0", "0"},
                {"69", "}//if at line 61", "0", "0", "0", "0", "0", "0"},
                {"70", "else{", "1", "0", "0", "0", "0", "1"},
                {"71", "numDays = 28;", "0", "1", "1", "1", "0", "3"},
                {"72", "if (year > 2020){", "0", "1", "1", "1", "0", "3"},
                {"73", "System.out.println(\"In year \" + year + \" month \" + month + \" will consist of \" + numDays + \" days.\");", "0", "6", "8", "0", "4", "18"},
                {"74", "}", "0", "0", "0", "0", "0", "0"},
                {"75", "else{", "1", "0", "0", "0", "0", "0"},
                {"76", "System.out.println(\"In year \" + year + \" month \" + month + \" has consisted of \" + numDays + \" days.\");", "0", "6", "8", "0", "4", "18"},
                {"77", " }", "0", "0", "0", "0", "0", "0"},
                {"78", "break;  ", "1", "0", "0", "0", "0", "1"},
                {"79", " }//else at line 70", "0", "0", "0", "0", "0", "0"},
                {"80", " }//else at line 60", "0", "0", "0", "0", "0", "0"},
                {"81", " }//switch at line 37", "0", "0", "0", "0", "0", "0"},
                {"82", "}//else at line 36", "0", "0", "0", "0", "0", "0"},
                {"83", "//method", "0", "0", "0", "0", "0", "0"},
                {"84", "//class", "0", "0", "0", "0", "0", "0"}
            },
            new String [] {
                "Line No", "Program Statement", "Nkw", "Nid", "Nop", "Nnv", "Nsl", "Cs"
            }
        ));
        jTable1.setMaximumSize(new java.awt.Dimension(0, 0));
        jTable1.setMinimumSize(new java.awt.Dimension(0, 0));
        jTable1.setPreferredSize(new java.awt.Dimension(699, 547));
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("Change weights");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (weight == null) {
            jDesktopPane1.removeAll();
            SizeWeight tbl = new SizeWeight();
            jDesktopPane1.add(tbl).setVisible(true);
            this.setVisible(false);
        } else {
            jDesktopPane1.removeAll();
            jDesktopPane1.add(weight).setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    SizeWeight weight;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
