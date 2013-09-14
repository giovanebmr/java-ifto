/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifto.aula5;

/**
 *
 * @author Giovane
 */

public class ExemploComGettersAndSetters {

    //É uma boa prática que os atributos das classes sejam privados, evitando o seu acesso direto por outras classes
    private int numero;
    private String nome;
    private double salario;
    private double valor;

    //abaixo segue os métodos Getters and Setters publicos, pelos quais serão acessados os atributos acima.
    //é uma boa prática de programação que os atributos sejam acessados pelos seus respectivos métodos get... e set...
    //se esse acesso for necessário.
    //note o padrão para nomeação do métod
    //get + nome do atributo, com a primeira letra maiúscula  exemplo  getNumero    ou   getNome
    //set + nome do atributo, com a primeira letra maiúscula   exemplo  setNumero    ou   setNome
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
