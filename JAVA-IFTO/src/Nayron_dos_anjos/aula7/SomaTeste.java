/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Nayron_dos_anjos.aula7;

import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */

public class SomaTeste {
    //Soma sem teste de exceção
    public static void main(String args[]){
    int x,y;
        String s1 = JOptionPane.showInputDialog("Digite valor para s1");
        String s2 = JOptionPane.showInputDialog("Digite valor para s2");
        
        x = Integer.parseInt(s1);
        y = Integer.parseInt(s2);
        
        JOptionPane.showMessageDialog(null,"Soma = " + (x+y));
}
}