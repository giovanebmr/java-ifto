import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Calculadora{
  public static void main(String args[]) {
    
   int erro =0;
    
   while (erro == 0){
      try{
	calcular();
      
      }catch (NumberFormatException e) {
	System.out.println("Entre apenas com numeros");
	erro = 0;
      }catch (Exception e) {
	System.out.println("Houve um erro de exceção" + e);
	erro = 0;
      }
     
   }
     
  }
  
  public static void calcular() throws Exception {
    
    int numero;
    int numero2;
    int resultado;
    
    BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
    try{
      System.out.println("Entre com o primeiro numero ");
      numero = Integer.parseInt(teclado.readLine());
    
      System.out.println("Entre com o segundo numero ");
      numero2 = Integer.parseInt(teclado.readLine());
	
      resultado = numero + numero2;
      
      System.out.println("O Resultado é " + resultado);
      
      }catch(Exception e){
	throw e;
      }
       
   }
  
}