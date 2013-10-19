/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifto.aula9.jogodavelha.regras.threads;

import br.edu.ifto.aula9.jogodavelha.beans.Jogador;

/**
 * @author Giovane Bruno Monte Reis
 * Thread responsável por controlar as intenções de desafios entre jogadores
 * Após o desafio estar preparado e pronto para iniciar uma partida, a thread é encerrada.
 * @since 1.0.0
 * @version 1.0.0
 */
public class ControleDeDesafios extends Thread {
    
    private Jogador jogadorLocal;
    private Jogador jogadorRemoto;
    
    /**
     * @param jogadorLocal Objeto com os dados do jogador local
     * @param jogadorRemoto Objeto com os dados do jogador desafiado
     */
    public ControleDeDesafios(Jogador jogadorLocal, Jogador jogadorRemoto){
        this.jogadorLocal = jogadorLocal;
        this.jogadorRemoto = jogadorRemoto;
    }
    
    @Override
    public void run() {
    }
}
