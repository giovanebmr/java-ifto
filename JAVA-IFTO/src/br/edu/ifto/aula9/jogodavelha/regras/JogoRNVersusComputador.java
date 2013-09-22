/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifto.aula9.jogodavelha.regras;

import java.io.File;
import javax.swing.JButton;

/**
 * Está classe é responsável for fazer o controle do jogo da velha.
 * Para isto ela deve receber a matriz de botões da view, no construtor da classe,
 * para que eles sejam manipulados pela mesma conforme o decorrer do jogo.
 * @author Giovane Bruno Monte Reis
 * @version 1.0.1
 * @since 22/09/2013
 */
public class JogoRNVersusComputador {

    private boolean jogadaX;
    private boolean jogadaY;
    /**variável necessária para o controle de opções (botões) disponíveis para o lance*/
    private boolean matriz[][];
    /**vetor de JButton onde o usuário fará os lances do jogo*/
    private JButton buttonMatriz[][];
    /**vetor de char para indicar qual jogador (X ou O)fez o lance em um indice específico do vetor de lances*/
    private char[][] lances;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private File f;

    /**
     * Construtor Recebe uma matriz de botões Recebe dois valores inteiros para
     * delimitar o tamanho da matriz do jogo (que deve ter a mesma dimensão da
     * matriz dos botões)
     * @param buttonMatriz um vetor de JButton, de duas dimensões
     * @param x dimensão x do vetor buttonMatriz e do vetor lances
     * @param x dimensão y do vetor buttonMatriz e do vetor lances
     */
    public JogoRNVersusComputador(JButton buttonMatriz[][], int x, int y) {
        this.buttonMatriz = buttonMatriz;
        this.matriz = new boolean[x][y];
        this.lances = new char[x][y];
    }

    /**
     * Alterna a vez do lance para o próximo jogador...
     */
    private void setVezDeJogar() {
        if (jogadaX) {
            jogadaY = true;
            jogadaX = false;
        } else {
            jogadaY = false;
            jogadaX = true;
        }
    }

    /**
     * seta o lance na matriz e coloca a imagem correspondente
     */
    public void setLance(int x, int y) {
        if (matriz[x][y] == false) {
            matriz[x][y] = true;
            if (jogadaX) {
                buttonMatriz[x][y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifto/aula9/jogodavelha/imagens/x.png")));
                setVezDeJogar();
                lances[x][y] = 'x';
            } else {
                buttonMatriz[x][y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifto/aula9/jogodavelha/imagens/o.png")));
                setVezDeJogar();
                lances[x][y] = 'O';
            }
        }

    }
    
    /**
     Seta null em todos os ícones dos botões e reinicializa a matriz de controle
     */
    public void removerLances() {
        for (int i = 0; i < this.buttonMatriz.length; i++) {
            for (int j = 0; j < this.buttonMatriz.length; j++) {
                this.buttonMatriz[i][j].setIcon(null);
                this.matriz[i][j] = false;
                lances[i][j] = ' ';
            }
        }
    }
    
    
    private void verificaVitoriaOuEmpate(){
        for (int i = 0; i < this.buttonMatriz.length; i++) {
            for (int j = 0; j < this.buttonMatriz.length; j++) {
                if(true){
                    
                }
                this.buttonMatriz[i][j].setIcon(null);
                this.matriz[i][j] = false;
            }
        }
    }
}





































/*
    void baixarImagem() throws IOException {
        
        //http://www.guj.com.br/java/237085-baixar-imagem-da-internet
        
    
    }
*/
