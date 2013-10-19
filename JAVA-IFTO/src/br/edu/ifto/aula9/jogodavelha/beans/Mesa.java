/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifto.aula9.jogodavelha.beans;

/**
 *
 * @author Giovane
 */
public class Mesa {

    //para verificar quais jogadores estão jogando
    private int idJogador1;
    private int idJogador2;
    //para verificar o lance dos jogadores
    private char jogadaJogador1X;
    private char jogadaJogador1Y;
    private char jogadaJogador2X;
    private char jogadaJogador2Y;
    //para verificar se o jogador ja fez a jogada
    private boolean jogador1jogou;
    private boolean jogador2jogou;
    //para verificar se ambos os jogadores concordaram em jogar
    private boolean aceiteJogoJogador1;
    private boolean aceiteJogoJogador2;
    //Mensagens do jogo
    private String mensagemDoJogo;
    private String mensagemDoJogador;
    private String mensagemDeDesafio;
    //para verificar quem inicia jogando
    private boolean iniciaJogandoJogador1;
    private boolean iniciaJogandoJogador2;
    //para verificar se ja esta com processo de desafio ou jogo em andamento...
    private boolean bloqueadoParaDesafio;
    //placar jogador 1 na primeira posição do vetor, jogador 2 na segunda...
    private int pontosJogador1;
    private int pontosJogador2;

    public int getIdJogador1() {
        return idJogador1;
    }

    public void setIdJogador1(int idJogador1) {
        this.idJogador1 = idJogador1;
    }

    public int getIdJogador2() {
        return idJogador2;
    }

    public void setIdJogador2(int idJogador2) {
        this.idJogador2 = idJogador2;
    }

    public char getJogadaJogador1X() {
        return jogadaJogador1X;
    }

    public void setJogadaJogador1X(char jogadaJogador1X) {
        this.jogadaJogador1X = jogadaJogador1X;
    }

    public char getJogadaJogador1Y() {
        return jogadaJogador1Y;
    }

    public void setJogadaJogador1Y(char jogadaJogador1Y) {
        this.jogadaJogador1Y = jogadaJogador1Y;
    }

    public char getJogadaJogador2X() {
        return jogadaJogador2X;
    }

    public void setJogadaJogador2X(char jogadaJogador2X) {
        this.jogadaJogador2X = jogadaJogador2X;
    }

    public char getJogadaJogador2Y() {
        return jogadaJogador2Y;
    }

    public void setJogadaJogador2Y(char jogadaJogador2Y) {
        this.jogadaJogador2Y = jogadaJogador2Y;
    }

    public boolean isJogador1jogou() {
        return jogador1jogou;
    }

    public void setJogador1jogou(boolean jogador1jogou) {
        this.jogador1jogou = jogador1jogou;
    }

    public boolean isJogador2jogou() {
        return jogador2jogou;
    }

    public void setJogador2jogou(boolean jogador2jogou) {
        this.jogador2jogou = jogador2jogou;
    }

    public boolean isAceiteJogoJogador1() {
        return aceiteJogoJogador1;
    }

    public void setAceiteJogoJogador1(boolean aceiteJogoJogador1) {
        this.aceiteJogoJogador1 = aceiteJogoJogador1;
    }

    public boolean isAceiteJogoJogador2() {
        return aceiteJogoJogador2;
    }

    public void setAceiteJogoJogador2(boolean aceiteJogoJogador2) {
        this.aceiteJogoJogador2 = aceiteJogoJogador2;
    }

    public String getMensagemDoJogo() {
        return mensagemDoJogo;
    }

    public void setMensagemDoJogo(String mensagemDoJogo) {
        this.mensagemDoJogo = mensagemDoJogo;
    }

    public String getMensagemDoJogador() {
        return mensagemDoJogador;
    }

    public void setMensagemDoJogador(String mensagemDoJogador) {
        this.mensagemDoJogador = mensagemDoJogador;
    }

    public String getMensagemDeDesafio() {
        return mensagemDeDesafio;
    }

    public void setMensagemDeDesafio(String mensagemDeDesafio) {
        this.mensagemDeDesafio = mensagemDeDesafio;
    }

    public boolean isIniciaJogandoJogador1() {
        return iniciaJogandoJogador1;
    }

    public void setIniciaJogandoJogador1(boolean iniciaJogandoJogador1) {
        this.iniciaJogandoJogador1 = iniciaJogandoJogador1;
    }

    public boolean isIniciaJogandoJogador2() {
        return iniciaJogandoJogador2;
    }

    public void setIniciaJogandoJogador2(boolean iniciaJogandoJogador2) {
        this.iniciaJogandoJogador2 = iniciaJogandoJogador2;
    }

    public boolean isBloqueadoParaDesafio() {
        return bloqueadoParaDesafio;
    }

    public void setBloqueadoParaDesafio(boolean bloqueadoParaDesafio) {
        this.bloqueadoParaDesafio = bloqueadoParaDesafio;
    }

    public int getPontosJogador1() {
        return pontosJogador1;
    }

    public void setPontosJogador1(int pontosJogador1) {
        this.pontosJogador1 = pontosJogador1;
    }

    public int getPontosJogador2() {
        return pontosJogador2;
    }

    public void setPontosJogador2(int pontosJogador2) {
        this.pontosJogador2 = pontosJogador2;
    }
    
    
}
