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
public class calculodaidade {
    public static void main (String [] args) throws IOException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        
        int idade;
        int ano;
        
        System.out.println("Digite seu ano de nascimento: ");
        ano = Integer.parseInt(teclado.readLine());
                
        idade = 2013 - ano;
        
        System.out.println("Voce tem " + idade +" de idade!");
    }
    
}
