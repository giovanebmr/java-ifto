/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifto.aula4.criandoclasses;

/**
 *
 * @author Giovane
 */
public class CriandoConstrutores {
    
    private String nome;
    private double altura;
    
    //Construtor 1
    public CriandoConstrutores(){
        this.nome = "Giovane";
        this.altura = 1.74;
    }
    
    //Construtor 2
    public CriandoConstrutores(String nome, double altura){
        this.nome = nome;
        this.altura = altura;
    }
    
}
