/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifto.aula4.controledefluxo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 *
 * @author Giovane
 */
public class CalculaIdade {
    
    public static void main(String args[]) throws IOException{
        
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(streamReader);
        int anoDeNascimento;
        int idade;
        
        System.out.println("Digite o ano que você nasceu: ");
        anoDeNascimento = Integer.parseInt(buffer.readLine());
        
        idade = 2013 - anoDeNascimento;
        
        System.out.println("Você tem " + idade + " anos de idade.");
        
        
    }
    
}
