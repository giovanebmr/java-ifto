package Paulo;

import javax.swing.JOptionPane;

public class Programa{
	public static void main (String args[]) {
		int x = 10;
		int y = 20;
		int maior = 0;

	if( maior < x ){
		maior = x;
	}
	if( maior < y){
		maior = y;
	}
        JOptionPane.showMessageDialog (null, "O número maior é: " + maior);
   }
}
