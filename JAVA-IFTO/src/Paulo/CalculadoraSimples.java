
package Paulo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 *
 * @author Paulo Augusto Barros de Sousa Júnior
 */
public class CalculadoraSimples {
    
    public static void main(String args[]) throws IOException{
        
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        
        int numero1;
        
        int numero2;
        
        int resultado;
        
        System.out.println("Somando numeros: \n");
        
        System.out.println("Digite o primeiro numero: ");
        numero1 = Integer.parseInt(teclado.readLine());

        System.out.println("Digite o segundo numero: ");
        numero2 = Integer.parseInt(teclado.readLine());
        
        resultado = numero1 + numero2;
        
        System.out.println("O resultado da soma e: " + resultado);
    }
    
}
