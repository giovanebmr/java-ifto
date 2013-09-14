/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifto.aula4.controledefluxo;


import java.util.Scanner;

/**
 *
 * @author Giovane
 */
public class EntradaDeDadosComScanner {
    
    public static void main(String args[]){
        
        Scanner scanner = new Scanner(System.in);
        
        String nome;
        
        System.out.println("Diite seu nome: ");
        
        nome = scanner.next();
        
        System.out.println("Prazer em conhece-lo " + nome);
        
    }
    
}
