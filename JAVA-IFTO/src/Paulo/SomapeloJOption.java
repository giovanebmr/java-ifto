/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Paulo;

import javax.swing.JOptionPane;

/**
 *
 * @author Jr
 */
public class SomapeloJOption {
    public static void main(String args[]) {
        int x, y;

        String s, s2;

        s = JOptionPane.showInputDialog("Digite o primeiro número:");
        s2 = JOptionPane.showInputDialog("Digite o segundo número:");

        x = Integer.parseInt(s);
        y = Integer.parseInt(s2);

        JOptionPane.showMessageDialog(null, "Soma = " + (x + y));
    }
}
