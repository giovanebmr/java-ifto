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
import br.edu.ifto.util.pensandoEmOrdenacoes.max.Mergesort;
import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MergesortTest {

    
    private int[] numbers;
    private final static int SIZE = 100000;
    private final static int MAX = 100000;

    @Before
    public void setUp() throws Exception {
        numbers = new int[SIZE];
        Random generator = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = generator.nextInt(MAX);
        }
    }

    @Test
    public void testMergeSort() {
        long startTime = System.currentTimeMillis();

        Mergesort sorter = new Mergesort();
        sorter.sort(numbers);

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Mergesort " + elapsedTime);

        //Verifica a ordenação do vetor
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                fail("Falha na ordenação");
            }
        }
        assertTrue(true);

    }

    //Realiza o teste 200 vezes
    @Test
    public void itWorksRepeatably() {
        for (int i = 0; i < 200; i++) {
            numbers = new int[SIZE];
            Random generator = new Random();
            for (int a = 0; a < numbers.length; a++) {
                numbers[a] = generator.nextInt(MAX);
            }
            Mergesort sorter = new Mergesort();
            sorter.sort(numbers);
            for (int j = 0; j < numbers.length - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    fail("Falha na ordenação");
                }
            }
            assertTrue(true);
        }
    }

    //Usando o método de ordenação da API padrão Arrays.sort()
    @Test
    public void testStandardSort() {
        long startTime = System.currentTimeMillis();
        Arrays.sort(numbers);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Standard Java sort " + elapsedTime);

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                fail("Falha na ordenação");
            }
        }
        assertTrue(true);
    }
}
