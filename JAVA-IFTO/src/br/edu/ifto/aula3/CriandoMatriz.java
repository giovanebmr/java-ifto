/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifto.aula3;

/**
 *
 * @author Giovane
 */
public class CriandoMatriz {
    
    public static void main(String args[]){
        
        
        String matriz [][] = new String[3][3];
        
        for(int i = 0; i<2; i++){
            for(int j = 0; j<2; j++){
                matriz[i][j] = "Posição do vetor: " + i + " " + j;
                System.out.println(matriz[i][j]);
            }
        }
    }
}
