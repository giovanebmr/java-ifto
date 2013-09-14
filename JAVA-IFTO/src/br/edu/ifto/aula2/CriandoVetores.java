/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifto.aula2;

import javax.swing.JOptionPane;

/**
 *
 * @author Giovane
 */
public class CriandoVetores {

    public static void main(String args[]) {


        
         //
        //   | 0,0 | 0,1 |
        //   | 1,0 | 1,1 | 
        
        int[] vetorInteiros = new int[100000];
        
        int numero = 0;
        
        //repetição while
        while(numero < 100000){
           vetorInteiros[numero] = numero;
           System.out.println("posição = " + vetorInteiros[numero]);
           numero = numero + 1;
        }
        
       
        
        
        
        

        

    }
}
