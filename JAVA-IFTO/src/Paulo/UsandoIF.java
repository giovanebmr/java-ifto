/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Paulo;

/**
 *
 * @author Paulo
 */
public class UsandoIF {
    
    public static void main(String args[]){
        
        String nome = "Paulo";
        
        String nome2 = "Augusto";
        
        //equals retorna true (verdadeiro)  para o if se o valor contido em teste for igual ao contido em nome, se for diferente ele retorna false (falso)
        if(nome.equals(nome2)){ //teste
            System.out.println("Não vou ser exibido, pois os nomes são diferentes");
        }//fim do if
        
        //OBS: Os métodos dentro do if somente serão executados se o teste for verdadeiro

    }
    
}
