package Paulo;

public class Calculadora2 {

	public static void main(String args[]) {
	
		if(args[0].equals("0")){
		
		float a = Integer.parseInt(args[1]);
		float b = Integer.parseInt(args[2]);
		float c = Integer.parseInt(args[3]);
		float d = Integer.parseInt(args[4]);
		float e = Integer.parseInt(args[5]);
		float resultado = a + b - c * d / e;
		float resultado2 = a - b + c / d * e;
		float resultado3 = a * b / c + d - e;
		float resultado4 = a / b * c - d + e;
		System.out.println("O primeiro resultado:"+ resultado);
        System.out.println("O segundo resultado:"+ resultado2);
        System.out.println("O terceiro resultado:"+ resultado3);
        System.out.println("O quarto resultado:"+ resultado4);

		}
		
		else{
			System.out.println("Erro");		
		}	
	}
}
