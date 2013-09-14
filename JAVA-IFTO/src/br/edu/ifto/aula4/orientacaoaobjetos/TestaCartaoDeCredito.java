/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifto.aula4.orientacaoaobjetos;

/**
 *
 * @author Giovane
 */
public class TestaCartaoDeCredito {
    
    public static void main(String [] args){
        CartaoDeCredito cdc1 = new CartaoDeCredito();
        CartaoDeCredito cdc2 = new CartaoDeCredito();
        
        cdc1.numero = 111111;
        cdc1.dataDeValidade = "12/12/2014";
        
        cdc2.numero = 222222;
        cdc2.dataDeValidade = "25/04/2015";
        
        System.out.println(cdc1.numero);
        System.out.println(cdc1.dataDeValidade);
        
        System.out.println(cdc2.numero);
        System.out.println(cdc2.dataDeValidade);
        
        
    }
    
}
