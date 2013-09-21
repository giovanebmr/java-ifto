/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Paulo;

import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class TesteUtil2 {

    public static void main(String[] args) {

        int x, y;
        String s, s2;
        Util u = new Util();

        while (!u.isNumero((s = JOptionPane.showInputDialog("digite o primeiro numero: "))))  {
            JOptionPane.showMessageDialog(null, "Digite apenas números !!!!");
        }

        while (!u.isNumero((s2 = JOptionPane.showInputDialog("digite o primeiro segundo: "))))  {
            JOptionPane.showMessageDialog(null, "Digite apenas números !!!!");
        }
        
         x = Integer.parseInt(s);
        y = Integer.parseInt(s2);
        
        JOptionPane.showMessageDialog(null, (x+y));

    }
}
