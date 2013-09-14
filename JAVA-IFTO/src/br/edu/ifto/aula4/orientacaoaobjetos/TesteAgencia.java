/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifto.aula4.orientacaoaobjetos;

/**
 *
 * @author Giovane
 */
public class TesteAgencia {

    public static void main(String args[]) {
        Agencia a = new Agencia();
        Agencia b = new Agencia();

        a.numero = 2397;
        b.numero = 4880;
        
        System.out.println(a.numero);
        System.out.println(b.numero);
        
    }
}
