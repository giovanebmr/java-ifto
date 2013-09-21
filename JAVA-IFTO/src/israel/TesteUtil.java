/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifto.aula8;

import javax.swing.JOptionPane;

/**
 *
 * @author Giovane
 */
public class TesteUtil {

    public static void main(String args[]) {

        int x, y;

        String s, s2;

        Util u = new Util();

        while (!u.isNumero((s = JOptionPane.showInputDialog("Digite o primeiro número:")))) {
            JOptionPane.showMessageDialog(null, "Digite apenas números!!!!");
        }

        while (!u.isNumero((s2 = JOptionPane.showInputDialog("Digite o segundo número:")))) {
            JOptionPane.showMessageDialog(null, "Digite apenas números!!!!");
        }

        x = Integer.parseInt(s);
        y = Integer.parseInt(s2);

        JOptionPane.showMessageDialog(null, "Soma = " + (x + y));


    }
}
