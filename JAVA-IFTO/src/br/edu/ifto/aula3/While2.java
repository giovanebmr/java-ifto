/*
 * Escreva um programa em Java que solicita 5 números ao usuário, através de um laço while,
 * e ao final mostre os dois maiores números digitados pelo usuário.
 */
package br.edu.ifto.aula3;

import java.util.Scanner;

/**
 *
 * @author Giovane
 */
public class While2 {

    public static void main(String args[]) {

        Scanner s = new Scanner(System.in);
        int i = 0;
        int numero = 0;
        int maior = 0;
        int maior2 = 0;

        while (i < 5) {
            System.out.println("Digite o número " + (i + 1) + ": ");
            numero = s.nextInt();
            if(numero > maior){
                maior2 = maior;
                maior = numero;
            }else if(numero > maior2 && numero < maior){
                maior2 = numero;
            }
            i++;
        }


        System.out.println("O maior número é: " + maior);
        
        System.out.println("\nO segundo maior número é: " + maior2);

    }
}
