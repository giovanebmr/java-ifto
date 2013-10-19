/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifto.aula9.jogodavelha.beans;

import java.io.Serializable;

/**
 * @author Giovane
 */
public class Jogador implements Serializable{  
    
    private int id;
    private String nome;
    private String login;
    private String email;
    private String senha;
    private boolean administrador;
    private boolean jogando;
    private boolean desafiado;
    /**aguardando desafio*/
    private boolean mesaSelecionada;  
    /**id da mesa*/
    private int idMesaSelecionada;  
    

    public Jogador(String nome, String login, String email, String senha) {
        this.nome = nome;
        this.login = login;
        this.email = email;
        this.senha = senha;
    }
    

    public Jogador() {
    }

    public boolean isMesaSelecionada() {
        return mesaSelecionada;
    }

    public void setMesaSelecionada(boolean mesaSelecionada) {
        this.mesaSelecionada = mesaSelecionada;
    }

    public int getIdMesaSelecionada() {
        return idMesaSelecionada;
    }

    public void setIdMesaSelecionada(int idMesaSelecionada) {
        this.idMesaSelecionada = idMesaSelecionada;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isIsAdministrador() {
        return administrador;
    }

    public void setIsAdministrador(boolean isAdministrador) {
        this.administrador = isAdministrador;
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    public boolean isJogando() {
        return jogando;
    }

    public void setJogando(boolean jogando) {
        this.jogando = jogando;
    }

    public boolean isDesafiado() {
        return desafiado;
    }

    public void setDesafiado(boolean desafiado) {
        this.desafiado = desafiado;
    }

   
    
}
