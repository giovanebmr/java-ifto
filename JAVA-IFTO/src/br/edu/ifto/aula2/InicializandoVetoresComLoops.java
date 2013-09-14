/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifto.aula2;

/**
 *
 * @author Giovane
 */
public class InicializandoVetoresComLoops {

    public static void main(String teste[]) {

        int vetor[] = new int[10];

        for (int i = 0; i < 10; i = i + 1) {
            vetor[i] = i;
        }
        
        for (int i = 0; i < 10; i = i + 1) {
            System.out.print("Valor do vetor na posição " + i + " é: " + vetor[i] + "\n");
        }
        
        

    }
}
