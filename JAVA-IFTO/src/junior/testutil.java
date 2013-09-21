import javax.swing.JOptionPane;


public abstract class testutil {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		int x,y;
		
		String s,s2;
		
		util1 u = new util1();
		
		while (!u.isNumero(s=JOptionPane.showInputDialog(" Digite o primeiro numero"))){
			JOptionPane.showMessageDialog(null,"Digite apenas numeros!!!");
		}
		
		while (!u.isNumero(s2=JOptionPane.showInputDialog(" Digite o segundo numero"))){
			JOptionPane.showMessageDialog(null,"Digite apenas numeros!!!");
		
		}
		
		
		  x = Integer.parseInt(s);
		  y = Integer.parseInt(s2);
		  
		  JOptionPane.showMessageDialog(null,"Soma = " + (x+y));
		  
		  
		  
		
		
		

	}

}
