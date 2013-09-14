/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifto.aula3;

import javax.swing.JOptionPane;

/**
 *
 * @author Giovane
 */
public class IfThenElse {
    
    
    public static void main(String args[]){
        
        String teste = (2 > 1) ? "2 é maior que 1" : "1 é maior que dois";
        
        JOptionPane.showMessageDialog(null, teste);
    }
}
