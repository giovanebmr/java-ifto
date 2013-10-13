/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifto.aula8;

import javax.swing.JOptionPane;

/**
 * @author Giovane
 * @see 22/09/2013
 */
public class TesteUtil2 {

    public static void main(String args[]) {

        float x, y;

        String s, s2;

        Util2 u = new Util2();

        while (!u.isNumeroFloat((s = JOptionPane.showInputDialog("Digite o primeiro número:")))) {
            JOptionPane.showMessageDialog(null, "Digite apenas números!!!!");
        }

        while (!u.isNumeroFloat((s2 = JOptionPane.showInputDialog("Digite o segundo número:")))) {
            JOptionPane.showMessageDialog(null, "Digite apenas números!!!!");
        }

        x = Float.parseFloat(s);
        y = Float.parseFloat(s2);

        JOptionPane.showMessageDialog(null, "Soma = " + (x + y));

    }
}
