/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Emanuelle;

import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class Util2 {

    public static void main(String args[]) {
        int x, y;
        String s, s2;


        Util u = new Util();

        while (!u.isNumero((s = JOptionPane.showInputDialog("Digite valor para s")))) {
            JOptionPane.showMessageDialog(null, "Digite apenas numeros!!");
        }
        while (!u.isNumero((s2 = JOptionPane.showInputDialog("Digite valor para s2")))) {
            JOptionPane.showMessageDialog(null, "Digite apenas numeros!!");
        }
        x = Integer.parseInt(s);
        y = Integer.parseInt(s2);

        JOptionPane.showMessageDialog(null, "Soma = " + (x + y));
    }
}
