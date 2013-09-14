/* Calculadora simples coma operação de adição
 * com captura de exceções IOException
 * IOException captura exceções de Input/Output (entrada ou saida) de dados. Um exemplo deria os erros no processo de leitura
 * dos dados armazenados no buffer do teclado 
 * o buffer do teclado é a memória padrão para armazenar os caracteres digitados no teclado 
 * Se houver algum erro nesse processo, ele será tratado por meio da classe IOException
 * IOException se localiza no package java.io
 */
package br.edu.ifto.aula1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 *
 * @author Giovane Bruno Monte Reis
 */
public class CalculadoraSimples {
    
    public static void main(String args[]) throws IOException{
        
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        
        int numero1;
        
        int numero2;
        
        int resultado;
        
        System.out.println("Somando números: \n");
        
        System.out.println("Digite o primeiro número: ");
        numero1 = Integer.parseInt(teclado.readLine());

        System.out.println("Digite o segundo número: ");
        numero2 = Integer.parseInt(teclado.readLine());
        
        resultado = numero1 + numero2;
        
        System.out.println("O resultado da soma é: " + resultado);
    }
    
}
