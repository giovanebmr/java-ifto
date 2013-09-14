/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifto.aula4.criandoclasses;

/**
 *
 * @author Giovane
 */
public class CriandoMetodos {

    public String retornaNome() {
        return "Giovane";
    }

    public int retornaMaiorNumero(int x, int y) {
        if (x > y) {
            return x;
        } else {
            return y;
        }
    }
}
