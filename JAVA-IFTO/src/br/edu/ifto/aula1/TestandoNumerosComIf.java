/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifto.aula1;

import javax.swing.JOptionPane;

/**
 *
 * @author Giovane
 */
public class TestandoNumerosComIf {

    public static void main(String args[]) {
        
        int x = 10;
        
        int y = 20;
        
        int maior = 0;
                
        if( maior < x ){
            
            maior = x;
        }
         
        if(maior < y){
            
            maior = y;
        }
        
      //  System.out.println("Valor maior: " + maior);
        
        JOptionPane.showMessageDialog(null, "O maior número é: " + maior);
        
        
        
        
        
    }
}
