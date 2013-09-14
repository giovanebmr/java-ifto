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
public class CalculadoraComSwitch {

    public static void main(String[] args) {

        int n1;
        int n2;
        String Operacao;

        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite a operação que deseja efetuar");
        Operacao = entrada.next();

        System.out.println("Digite o Primeiro Numero");
        n1 = entrada.nextInt();

        System.out.println("Digite o Segundo Numero");
        n2 = entrada.nextInt();

        switch (Operacao) {

            case "+":
                System.out.println("O Resultado da Soma é:" + (n1 + n2));
                break;

            case "-":
                System.out.println("O Resultado da subtração é:" + (n1 - n2));
                break;

            case "*":
            System.out.println("O Resultado da Multiplicação é:" + (n1 * n2));
                break;

            case "/":
                System.out.println("O Resultado da Divisão é:" + (n1 / n2));
                break;

            default:
                System.out.println("Operação inválida, tente Novamente!");
                break;

        } 

    }
}