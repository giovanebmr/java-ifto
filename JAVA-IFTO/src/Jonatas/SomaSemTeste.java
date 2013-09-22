package Jonatas;



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class SomaSemTeste {
    
    public  static void main(String args[]){
        
        int x = 0;
	int y = 0;
	String s;
        String s2;
        
        s = JOptionPane.showInputDialog("Digite o primeiro número.");
        s2 = JOptionPane.showInputDialog("Digite o segundo número.");
        
        x = Integer.parseInt(s);
        y = Integer.parseInt(s2);
        
        JOptionPane.showMessageDialog(null, "Soma = " + (x + y));
        
        
    }
    
}
