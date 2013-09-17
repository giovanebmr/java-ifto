/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifto.util.pensandoEmOrdenacoes.max;

/**
 *
 * @author Giovane Bruno Monte Reis
 */
public class PensandoEmOrdenacoes {

    int numbers[];
    int x;
    boolean stop;

    public void ordenar(int[] vetor) {
        this.numbers = vetor;
        int i = 0;
        while (!this.stop) {
            ordenarSimples1(numbers);
            i++;
        }
        System.out.println("|PensandoEmOrdenacoes.ordenar| O laço de repetição for, foi reinicializado " + i + " vezes.");
    }

    public void ordenar2(int[] vetor) {
        this.numbers = vetor;
        int i = 0;
        while (!this.stop) {
            ordenarSimples2(numbers, i);
            i++;
        }
        stop = false;
        while (!this.stop) {
            ordenarSimples1(numbers);
            i++;
        }
        System.out.println("|PensandoEmOrdenacoes.ordenar2| O laço de repetição for, foi reinicializado " + i + " vezes.");
    }

    public void ordenar3(int[] vetor) {
        this.numbers = vetor;
        int i = 0;
        while (!this.stop) {
            ordenarSimples2(numbers, i);
            i++;
        }
        stop = false;
        int j = numbers.length - (numbers.length / 3);
        while (!this.stop) {
            ordenarSimples3(numbers, j);
            i++;
        }

        System.out.println("|PensandoEmOrdenacoes.ordenar3| O laço de repetição for, foi reinicializado " + i + " vezes.");
    }

    //ordenar sempre a metade recursivamente
    public void ordenar4(int[] vetor) {
        this.numbers = vetor;
        int i = 0;
        //ordena a primeira metade
        int j = numbers.length / 2;
        while (!this.stop) {
            ordenarSimples4(numbers, j, 0);
            ordenarSimples4(numbers, j * 2, j);
            i++;
        }
        System.out.println("|PensandoEmOrdenacoes.ordenar4| O laço de repetição for, foi reinicializado " + i + " vezes.");
    }

    private void ordenarSimples1(int[] vetor) {
        this.stop = true;  //pare
        this.numbers = vetor;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                x = numbers[i];
                numbers[i] = numbers[i + 1];
                numbers[i + 1] = x;
                this.stop = false;   //se encontrou valor para ordenar... recebe false (não pare!)
            }
        }
    }

    private void ordenarSimples2(int[] vetor, int i) {
        this.stop = true;  //pare
        this.numbers = vetor;
        for (int k = i; k < numbers.length - 1; k = k + 2) {
            if (numbers[k] > numbers[k + 1]) {
                x = numbers[k];
                numbers[k] = numbers[k + 1];
                numbers[k + 1] = x;
                this.stop = false;   //se encontrou valor para ordenar... recebe false (não pare!)
            }
        }
    }

    //ordena ate uma posição específica do vetor
    private void ordenarSimples3(int[] vetor, int k) {
        this.stop = true;  //pare
        this.numbers = vetor;
        for (int i = 0; i < k; i++) {
            if (numbers[i] > numbers[i + 1]) {
                x = numbers[i];
                numbers[i] = numbers[i + 1];
                numbers[i + 1] = x;
                this.stop = false;   //se encontrou valor para ordenar... recebe false (não pare!)
            }
        }
    }

    //ordena ate uma posição específica do vetor
    private void ordenarSimples4(int[] vetor, int k, int j) {
        if (((k / 2) < 2) && j < 0) {
            this.stop = true;  //pare
            return;
        }
        this.stop = true;  //pare
        this.numbers = vetor;
        for (int i = j; i < k; i++) {
            if (numbers[i] > numbers[i + 1]) {
                x = numbers[i];
                numbers[i] = numbers[i + 1];
                numbers[i + 1] = x;
                this.stop = false;   //se encontrou valor para ordenar... recebe false (não pare!)
            }
        }
        ordenarSimples4(vetor, k , (k / 2));
        ordenarSimples4(vetor, (k / 2) , j);
    }
}
