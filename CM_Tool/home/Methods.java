/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home;

/**
 *
 * @author anupama
 */
public class Methods {
    public static String totalComplexityDueToSize(String line) {
        return "0";
    }
    
    public static String totalComplexityDueToVariables(String line) {
        return "0";
    }
    
    public static String totalComplexityDueToMethods(String line) {
        return "0";
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
    
}
