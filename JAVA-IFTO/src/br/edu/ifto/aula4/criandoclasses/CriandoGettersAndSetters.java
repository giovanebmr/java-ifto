/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifto.aula4.criandoclasses;

/**
 *
 * @author Giovane
 */
// E uma boa pratica de programação criar atributos com acesso private, pois assim a classe estara protegida de acessos esternos indiscriminados a seus atributos
//No entanto, se alguns destes atributos necessitam de acesso externo, deverá ser criando o seu repectivo método get ou set, conforme o caso.
public class CriandoGettersAndSetters {

    private int valor = 10;
    private String nome = "Testando Geters and Seters";

    //this se refere à propria classe. É utilizado para indicar um atributo da propria classe
    public int getValor() {
        return this.valor;
    }

    //Por que usar this? 
    //É uma boa prática usar this, ele evita conflitos entre variaveis ou atributos
    //alem de indicar de forma fácil e visual, uma referência a um atributo da propria classe.
    public void setValor(int valor) {
        this.valor = valor;
    }
}
