/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Paulo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 *
 * @author Jr
 */
public class Calculadora {
    public static void main(String [] args) throws IOException{
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        int x;
        int y;
        int resultadosoma;
        int resultadosubrtração;
        int resultadomultiplicação;
        int resultadodivisão;
        
        System.out.println("Digite o primeiro número: ");
        x = Integer.parseInt(teclado.readLine());
        
        System.out.println("Digite o segundo número: ");
        y = Integer.parseInt(teclado.readLine());
        
        calculos cal = new calculos();
        /*
        resultadosoma = x + y;
        resultadosubrtração = x - y;
        resultadomultiplicação = x * y;
        resultadodivisão = x / y;
        */
        System.out.println("a Soma é: " +cal.soma(x, y));
        System.out.println("a Subtração é: " +cal.subtracao(x, y));
        System.out.println("a Multiplicação é: " +cal.multiplicacao(x, y));
        System.out.println("a Divisão é: " +cal.divisao(x, y));
        
                
    }
    
}
