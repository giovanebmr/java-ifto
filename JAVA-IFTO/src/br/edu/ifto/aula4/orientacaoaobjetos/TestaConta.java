/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifto.aula4.orientacaoaobjetos;

/**
 *
 * @author Giovane
 */
class TestaConta {

    public static void main(String[] args) {
        
        Conta conta1 = new Conta();
        conta1.numero = 615777;
        conta1.saldo = 1000;
        conta1.limite = 250;
        
        Conta conta2 = new Conta();
        conta2.numero = 615778;
        conta2.saldo = 1300;
        conta2.limite = 550;

        System.out.println(conta1.numero);
        System.out.println(conta1.limite);
        System.out.println(conta1.saldo);
        
        System.out.println(conta2.numero);
        System.out.println(conta2.limite);
        System.out.println(conta2.saldo);
    }
}