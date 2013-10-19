package Paulo;

public class Programa3 {
	
	public static void main (String args[]){

	if(args[0].equals("SOMAR")){

	double x = Integer.parseInt(args[1]);
	double y = Integer.parseInt(args[2]);
	double resultadosoma = x + y;
	double resultadosubtrair = x - y;
    double resultadomultiplicar = x * y;
    double resultadodividir = x / y;
	System.out.println("Resultado da soma é: "+ resultadosoma);
        System.out.println("Resultado da subtração: "+ resultadosubtrair);
        System.out.println("Resultado da multiplicação é: "+ resultadomultiplicar);
        System.out.println("Resultado da divisão é: "+ resultadodividir);

	}
	else{
		System.out.println ("Erro");
	}
		
	}
}
