/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Walyson;

import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class TesteUtil{

    /**
     * Retorna tue se for possível e retorna false caso não seja possível
     *
     * @param args
     */
    public static void main(String args[]) {
        int x, y;
        String s, s2;
        
        Util u = new Util();
        
        
while (!u.isNumero((s = JOptionPane.showInputDialog("Insira um número")))){
    JOptionPane.showMessageDialog(null, "Insira apenas números!");
    
}
while (!u.isNumero((s2 = JOptionPane.showInputDialog("Insira outro número")))){
       JOptionPane.showMessageDialog(null, "Insira apenas números!");
       
   }
        x = Integer.parseInt(s);
        y = Integer.parseInt(s2);
        
        
        
        JOptionPane.showMessageDialog(null, "Soma = " + (x+y));
    }

    
}
