/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifto.aula9.jogodavelha.regras;

import java.io.File;
import javax.swing.JButton;

/**
 *
 * @author Giovane
 */
public class JogoRN {

    private boolean jogadaX;
    private boolean jogadaY;
    private boolean matriz[][];
    private JButton buttonMatriz[][];
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
     */
    public JogoRN(JButton buttonMatriz[][], int x, int y) {
        this.buttonMatriz = buttonMatriz;
        this.matriz = new boolean[x][y];
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
            } else {
                buttonMatriz[x][y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifto/aula9/jogodavelha/imagens/o.png")));
                setVezDeJogar();
            }
        }

    }
    
    public void removerLances() {
        for (int i = 0; i < this.buttonMatriz.length; i++) {
            for (int j = 0; j < this.buttonMatriz.length; j++) {
                this.buttonMatriz[i][j].setIcon(null);
                this.matriz[i][j] = false;
            }
        }
    }
}
















/*
    void baixarImagem() throws IOException {
        
        //http://www.guj.com.br/java/237085-baixar-imagem-da-internet
        
        String s = File.separator;
        String path = s + "br" + s +"edu" + s +"ifto/aula9/jogodavelha/imagems/";
        this.f = new File(path);
        PrintWriter saida;
        try (FileWriter writer = new FileWriter(f)) {
            saida = new PrintWriter(writer);
            saida.print(Toolkit.getDefaultToolkit().getImage("http://br.blackberry.com/content/dam/blackBerry/images/icon/icon-blackBerryTravel.png.original.png"));
        }
        saida.close();
    }
*/
