/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifto.util.pensandoEmOrdenacoes.max;

/**
 *
 * @author Lars Vogel
 * http://www.vogella.com/articles/JavaAlgorithmsMergesort/article.html
 * 
 * http://www.vogella.com/code/index.html
 */
public class Mergesort {

    private int[] numbers;
    private int[] helper;
    private int number;

    public void sort(int[] values) {
        this.numbers = values;
        number = values.length;
        this.helper = new int[number];
        mergesort(0, number - 1);
    }

    private void mergesort(int low, int high) {
       // Verifique se baixa é menor, então alto, se não, então a matriz é classificada
        if (low < high) {
            // Obter o índice do elemento que está no meio
            int middle = low + (high - low) / 2;
            // Ordena o lado esquerdo da matriz
            mergesort(low, middle);
            // Ordena o lado direito da matriz
            mergesort(middle + 1, high);
            // Combine os dois
            merge(low, middle, high);
        }
    }

    private void merge(int low, int middle, int high) {

        // Copia ambas as partes na matriz helper
        for (int i = low; i <= high; i++) {
            helper[i] = numbers[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;
        // Copie os menores valores de esquerda ou direita para trás
        // Para a matriz original
        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                numbers[k] = helper[i];
                i++;
            } else {
                numbers[k] = helper[j];
                j++;
            }
            k++;
        }
        // Copiar o resto do lado esquerdo da matriz para a matriz de destino
        while (i <= middle) {
            numbers[k] = helper[i];
            k++;
            i++;
        }

    }
}
