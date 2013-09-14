/*
 * Escreva um programa em Java que solicita 5 números ao usuário, através de um laço while,
 * e ao final mostre os dois maiores números digitados pelo usuário.
 */
package br.edu.ifto.aula2;

import java.util.Scanner;

/**
 *
 * @author Giovane
 */
public class While1 {

    public static void main(String args[]) {

        Scanner s = new Scanner(System.in);
        
        int vetor[] = new int[5];
        int i = 0;
        int maior = 0;
        int maior2 = 0;

        while (i < 5) {
            System.out.println("Digite o número " + (i + 1) + ": ");
            vetor[i] = s.nextInt();
            i++;
        }

        i = 0;

        while (i < 5) {
            if (maior < vetor[i]) {
                maior2 = maior;
                maior = vetor[i];
            }else{
                if(vetor[i] < maior && vetor[i] > maior2){
                    maior2 = vetor[i];
                }
            }
            i++;
        }

        System.out.println("O maior número é: " + maior);
        
        System.out.println("\nO segundo maior número é: " + maior2);

    }
}
