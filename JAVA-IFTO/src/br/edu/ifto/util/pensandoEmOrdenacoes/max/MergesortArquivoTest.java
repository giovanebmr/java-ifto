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
 * 
 * Acrescentado outros métodos de teste por: Giovane Bruno Monte Reis
 * 
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MergesortArquivoTest {

    private int[] numbers;
    final int MAX = 100000;

    @Before
    public void setUp() throws Exception {

        FileInputStream inputStream = new FileInputStream(new File("C:\\GITRepository\\javaifto\\JAVA-IFTO\\src\\br\\edu\\ifto\\util\\pensandoEmOrdenacoes\\max\\IntegerArray.txt"));
        InputStreamReader isr = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(isr);
        numbers = new int[MAX];
        String s;
        for (int i = 0; ((s = reader.readLine()) != null) && (i < numbers.length); i++) {
            numbers[i] = Integer.parseInt(s);
        }
    }

    //Ordena com Mergesort
    @Test
    public void testMergeSort() throws FileNotFoundException, IOException {
        long startTime = System.currentTimeMillis();

        Mergesort sorter = new Mergesort();
        sorter.sort(numbers);

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Mergesort " + elapsedTime);

        //Verifica a ordenação do vetor
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                fail("\n-------> Falha na ordenação por Mergesort\n");
            }
        }

        //Grava o vetor ordenado em arquivo
        File f = new File("C:\\GITRepository\\javaifto\\JAVA-IFTO\\src\\br\\edu\\ifto\\util\\pensandoEmOrdenacoes\\max\\ArrayOrdenadoPorMergesort.txt");
        FileWriter writer = new FileWriter(f);  //para modo append, colocar true no segundo parâmetro.
        PrintWriter saida = new PrintWriter(writer);

        //Grava os dados do vetor no arquivo
        for (int i = 0; i < numbers.length; i++) {
            saida.println(numbers[i]);
        }

        saida.close();
        writer.close();


        assertTrue(true);

    }

    //Realiza o teste 200 vezes
    @Test
    public void itWorksRepeatably() throws Exception {
        for (int i = 0; i < 200; i++) {
            //reinicializa o vetor para ordenação
            setUp();
            Mergesort sorter = new Mergesort();
            sorter.sort(numbers);
            for (int j = 0; j < numbers.length - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    fail("\n-------> Falha na ordenação do teste de repetição de 200 vezes\n");
                }
            }
            assertTrue(true);
        }
    }

    //Usando o método de ordenação da API padrão Arrays.sort()
    @Test
    public void testStandardSort() throws Exception {
        //reinicializa o vetor para ordenação
        setUp();
        long startTime = System.currentTimeMillis();
        Arrays.sort(numbers);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Standard Java sort " + elapsedTime);

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                fail("\n-------> Falha na ordenação por Arrays.sort()\n");
            }
        }
        assertTrue(true);
    }

    //Usando a classe PensandoEmOrdenacoes
    @Test
    public void testPensandoEmOrdenacoes() throws Exception {
        //reinicializa o vetor para ordenação
        setUp();
        PensandoEmOrdenacoes ordenacao = new PensandoEmOrdenacoes();
        long startTime = System.currentTimeMillis();
        ordenacao.ordenar(numbers);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("PensandoEmOrdenacoes " + elapsedTime);

        //Grava o vetor ordenado em arquivo
        File f = new File("C:\\GITRepository\\javaifto\\JAVA-IFTO\\src\\br\\edu\\ifto\\util\\pensandoEmOrdenacoes\\max\\ArrayOrdenadoPorPensandoEmOrdenacoes.txt");

        try (FileWriter writer = new FileWriter(f); PrintWriter saida = new PrintWriter(writer)) {
            //Grava os dados do vetor no arquivo
            for (int i = 0; i < numbers.length; i++) {
                saida.println(numbers[i]);
            }
        }

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                fail("\n-------> Falha na ordenação por PensandoEmOrdenacoes\n");
            }
        }
        assertTrue(true);
    }
    
    //Usando a classe PensandoEmOrdenacoes
    @Test
    public void testPensandoEmOrdenacoes2() throws Exception {
        //reinicializa o vetor para ordenação
        setUp();
        PensandoEmOrdenacoes ordenacao = new PensandoEmOrdenacoes();
        long startTime = System.currentTimeMillis();
        ordenacao.ordenar2(numbers);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("PensandoEmOrdenacoes-2 " + elapsedTime);

        //Grava o vetor ordenado em arquivo
        File f = new File("C:\\GITRepository\\javaifto\\JAVA-IFTO\\src\\br\\edu\\ifto\\util\\pensandoEmOrdenacoes\\max\\ArrayOrdenadoPorPensandoEmOrdenacoes-2.txt");

        try (FileWriter writer = new FileWriter(f); PrintWriter saida = new PrintWriter(writer)) {
            //Grava os dados do vetor no arquivo
            for (int i = 0; i < numbers.length; i++) {
                saida.println(numbers[i]);
            }
        }

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                fail("\n-------> Falha na ordenação por PensandoEmOrdenacoes-2\n");
            }
        }
        assertTrue(true);
    }
    
    @Test
    public void testPensandoEmOrdenacoes3() throws Exception {
        //reinicializa o vetor para ordenação
        setUp();
        PensandoEmOrdenacoes ordenacao = new PensandoEmOrdenacoes();
        long startTime = System.currentTimeMillis();
        ordenacao.ordenar3(numbers);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("PensandoEmOrdenacoes-3 " + elapsedTime);

        //Grava o vetor ordenado em arquivo
        File f = new File("C:\\GITRepository\\javaifto\\JAVA-IFTO\\src\\br\\edu\\ifto\\util\\pensandoEmOrdenacoes\\max\\ArrayOrdenadoPorPensandoEmOrdenacoes-3.txt");

        try (FileWriter writer = new FileWriter(f); PrintWriter saida = new PrintWriter(writer)) {
            //Grava os dados do vetor no arquivo
            for (int i = 0; i < numbers.length; i++) {
                saida.println(numbers[i]);
            }
        }

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                System.out.println("\n\n\n------------------------------ posição - " + i);
                fail("\n-------> Falha na ordenação por PensandoEmOrdenacoes-3\n");
            }
        }
        assertTrue(true);
    }
    
    
    @Test
    public void testPensandoEmOrdenacoes4() throws Exception {
        //reinicializa o vetor para ordenação
        setUp();
        PensandoEmOrdenacoes ordenacao = new PensandoEmOrdenacoes();
        long startTime = System.currentTimeMillis();
        ordenacao.ordenar3(numbers);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("PensandoEmOrdenacoes-4 " + elapsedTime);

        //Grava o vetor ordenado em arquivo
        File f = new File("C:\\GITRepository\\javaifto\\JAVA-IFTO\\src\\br\\edu\\ifto\\util\\pensandoEmOrdenacoes\\max\\ArrayOrdenadoPorPensandoEmOrdenacoes-4.txt");

        try (FileWriter writer = new FileWriter(f); PrintWriter saida = new PrintWriter(writer)) {
            //Grava os dados do vetor no arquivo
            for (int i = 0; i < numbers.length; i++) {
                saida.println(numbers[i]);
            }
        }

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                System.out.println("\n\n\n------------------------------ posição - " + i);
                fail("\n-------> Falha na ordenação por PensandoEmOrdenacoes-4\n");
            }
        }
        assertTrue(true);
    }
}
