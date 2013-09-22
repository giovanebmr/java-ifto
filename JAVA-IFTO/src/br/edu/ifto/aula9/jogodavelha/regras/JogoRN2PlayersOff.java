/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifto.aula9.jogodavelha.regras;

import java.io.File;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Está classe é responsável for fazer o controle do jogo da velha. Para isto
 * ela deve receber a matriz de botões da view, no construtor da classe, para
 * que eles sejam manipulados pela mesma conforme o decorrer do jogo.
 *
 * @author Giovane Bruno Monte Reis
 * @version 1.0.1
 * @since 22/09/2013
 */
public class JogoRN2PlayersOff {

    private boolean jogadaX;
    private boolean jogadaY;
    /** variável necessária para o controle de opções (botões) disponíveis para o lance */
    private boolean matriz[][];
    /** vetor de JButton onde o usuário fará os lances do jogo */
    private JButton buttonMatriz[][];
    /** vetor de char para indicar qual jogador (X ou O) fez o lance em um indice específico do vetor de lances  */
    private char[][] lances;
    /**Variável necessária para erificar se houve vitória no lance corrente*/
    private boolean houveVitoria;
    /**Objetos para mostrar o placar do jogo*/
    private JTextField placarX, placarO;
    /**Variável necessária para verificar se o número máximo de lances do jogo foi atingido*/
    private int numeroDeLances;

    /**
     * Construtor Recebe uma matriz de botões Recebe dois valores inteiros para
     * delimitar o tamanho da matriz do jogo (que deve ter a mesma dimensão da
     * matriz dos botões)
     *
     * @param buttonMatriz um vetor de JButton, de duas dimensões
     * @param x dimensão x do vetor buttonMatriz e do vetor lances
     * @param x dimensão y do vetor buttonMatriz e do vetor lances
     * @param placar1 onde será colocado a quantidade de vitórias do jogador 1
     * @param placar2 onde será colocado a quantidade de vitórias do jogador 2
     */
    public JogoRN2PlayersOff(JButton buttonMatriz[][], int x, int y, JTextField placar1, JTextField placar2) {
        this.buttonMatriz = buttonMatriz;
        this.matriz = new boolean[x][y];
        this.lances = new char[x][y];
        this.placarO = placar1;
        this.placarX = placar2;
        reinicializaPlacar();
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
     *
     * @param x coordenada x do vetor de lances e do vetor buttonMatriz
     * @param y coordenada y do vetor de lances e do vetor buttonMatriz
     * @see #buttonMatriz
     * @see #lances
     */
    public void setLance(int x, int y) {
        numeroDeLances++;
        if (matriz[x][y] == false) {
            matriz[x][y] = true;
            if (jogadaX) {
                buttonMatriz[x][y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifto/aula9/jogodavelha/imagens/x.png")));
                setVezDeJogar();
                lances[x][y] = 'X';
                if (houveVitoria = verificaVitoria('X')) {
                    incrementaPlacar('X');
                    JOptionPane.showMessageDialog(placarX, "Vitoria de " + "X");
                    reinicializaJogo();
                }
                verificaEmpate();
            } else {
                buttonMatriz[x][y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifto/aula9/jogodavelha/imagens/o.png")));
                setVezDeJogar();
                lances[x][y] = 'O';
                if (houveVitoria = verificaVitoria('O')) {
                    incrementaPlacar('O');
                    JOptionPane.showMessageDialog(placarX, "Vitoria de " + "O");
                    reinicializaJogo();
                }
                verificaEmpate();
            }
        }

    }

    /** Seta null em todos os ícones dos botões e reinicializa a matriz de controle */
    public void reinicializaJogo() {
        for (int i = 0; i < this.buttonMatriz.length; i++) {
            for (int j = 0; j < this.buttonMatriz.length; j++) {
                this.buttonMatriz[i][j].setIcon(null);
                this.matriz[i][j] = false;
                lances[i][j] = ' ';
            }
        }
        reinicializaVetorLances();
        houveVitoria = false;
        numeroDeLances = 0;
    }

    /**
     * <p>Verifica se hove vitória após um lance</p>
     *
     * @param caracter o caracter relativo ao jogador vitorioso a ser verificado
     * (ex: 'X' ou '0')
     * @return true se houve vitória ou false se não
     */
    private boolean verificaVitoria(char caracter) {

        /**
         * verifica vitória na diagonal 1
         */
        if (lances[0][0] == caracter && lances[1][1] == caracter && lances[2][2] == caracter) {
            return true;
        }

        /**
         * verifica vitória na diagonal 2
         */
        if (lances[2][0] == caracter && lances[1][1] == caracter && lances[0][2] == caracter) {
            return true;
        }

        /**
         * verifica vitória na primeira coluna
         */
        if (lances[0][0] == caracter && lances[1][0] == caracter && lances[2][0] == caracter) {
            return true;
        }

        /**
         * verifica vitória na segunda coluna
         */
        if (lances[0][1] == caracter && lances[1][1] == caracter && lances[2][1] == caracter) {
            return true;
        }

        /**
         * verifica vitória na terceira coluna
         */
        if (lances[0][2] == caracter && lances[1][2] == caracter && lances[2][2] == caracter) {
            return true;
        }

        /**
         * verifica vitória na primeira linha
         */
        if (lances[0][0] == caracter && lances[0][1] == caracter && lances[0][2] == caracter) {
            return true;
        }

        /**
         * verifica vitória na segunda linha
         */
        if (lances[1][0] == caracter && lances[1][1] == caracter && lances[1][2] == caracter) {
            return true;
        }

        /**
         * verifica vitória na terceira linha
         */
        if (lances[2][0] == caracter && lances[2][1] == caracter && lances[2][2] == caracter) {
            return true;
        }

        return false;

    }

    /*  00 01 02 
     *  10 11 12
     *  20 21 22
     */
    /**
     * inicializa o vetor lances com um caracter de espaço ' '
     */
    private void reinicializaVetorLances() {
        for (int i = 0; i < this.lances.length; i++) {
            for (int j = 0; j < this.lances.length; j++) {
                lances[i][j] = ' ';
            }
        }
    }

    /**
     * Incrementa a vitória no placar do vitóriozo
     *
     * @param jogador caracter para identificar qual placar será incrementado
     * (ex: 'X' ou 'O')
     */
    private void incrementaPlacar(char jogador) {
        if (jogador == 'X') {
            placarX.setText((Integer.parseInt(placarX.getText()) + 1) + "");
        }
        if (jogador == 'O') {
            placarO.setText((Integer.parseInt(placarO.getText()) + 1) + "");
        }
    }

    /**
     * Reinicializa o placar
     */
    private void reinicializaPlacar() {
        placarX.setText("0");
        placarO.setText("0");
    }

    /**Verifica se houve empate na partida
     * @see #numeroDeLances 
     * @see #houveVitoria
     */
    private void verificaEmpate() {
        if(numeroDeLances == 9 && !houveVitoria){
            JOptionPane.showMessageDialog(null, "Empate!");
            reinicializaJogo();
            reinicializaVetorLances();
        }
    }
}
/*
 void baixarImagem() throws IOException {
        
 //http://www.guj.com.br/java/237085-baixar-imagem-da-internet
        
    
 }
 */
