/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifto.aula4.orientacaoaobjetos;

/**
 *
 * @author Giovane
 */
public class TesteCliente {
    
    public static void main(String args[]){
        
        Cliente c = new Cliente();
        Cliente c2 = new Cliente();
        
        c.codigo = 1;
        c.nome = "João";
        
        c2.codigo = 2;
        c2.nome = "Ana";
        
        System.out.println(c.nome);
        System.out.println(c.codigo);
        
        System.out.println(c2.nome);
        System.out.println(c2.codigo);
        
        
    }
    
}
