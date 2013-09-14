/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifto.aula2;

/**
 *
 * @author Giovane
 */
public class InicializandoVetoresComString {
    
    public static void main(String args[]) {
        
        String [] vetor = new String[3];
        
        //inicializando vetor com valores inteiros
        vetor[0] = "banana";
        vetor[1] = "manga";
        vetor[2] = "laranja";
        
        //mostrando dados do vetor
        System.out.println("Vetor na posição 0, contem o valor: " + vetor[0]);
        System.out.println("Vetor na posição 1, contem o valor: " + vetor[1]);
        System.out.println("Vetor na posição 2, contem o valor: " + vetor[2]);

    }
}
