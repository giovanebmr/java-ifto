/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifto.aula3;

/**
 *
 * @author Giovane
 */
public class Matriz {
    
        public static void main(String teste[]) {

        int vetor[][] = new int[10][10];

        for (int i = 0; i < 10; i = i + 1) {
            for (int j = 0; i < 10; i = i + 1) {
                vetor[i][j] = i + j;
                 System.out.print("Valor do vetor na posição " + i + "." + j + " é: " + vetor[i][j] + "\n");
            }
        }
        

        

    }
}
