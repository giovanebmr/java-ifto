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
public class TesteUtil {
    private static int a;
    private static int b;
    private static int c;
    private static int d;

    public static void main(String[] args) {
        int x, y;
        String s, s2;
        s = JOptionPane.showInputDialog("Digite o número 1");
        s2 = JOptionPane.showInputDialog("Digite o número 2");
        
        x = Integer.parseInt(s);
        y = Integer.parseInt(s2);
        a = x+y;
        b = x-y;
        c = x*y;
        d = x/y;
        
        JOptionPane.showMessageDialog(null,"a soma é : " +a);
        JOptionPane.showMessageDialog(null,"a subtração é : " +b);
        JOptionPane.showMessageDialog(null,"a multiplicação é : " +c);
        JOptionPane.showMessageDialog(null,"a divisão é : " +d);
        
    }
}
