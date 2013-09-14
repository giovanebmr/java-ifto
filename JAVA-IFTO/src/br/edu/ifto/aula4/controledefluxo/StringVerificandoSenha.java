/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifto.aula4.controledefluxo;

/**
 *
 * @author Giovane
 */

public class StringVerificandoSenha {
    
    public static void main(String args []){
        
        String senha = "123456";
        
        boolean isSenhaCorreta = false;
        
        
        isSenhaCorreta = senha.contains("123456");
        
        System.out.println("A senha esta: " + isSenhaCorreta);
        
    }
    
}
