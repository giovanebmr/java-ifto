/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tayla;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author aluno
 */
public class Desafio {
    
     public static void main (String args [])throws IOException {
    
      String nome = "João";
      String conta = "9999";
      String senha = "12345";
      String agencia = "1122x";
      Double saldo = 12500.00;
      Double limite = 10000.00;
      
      String vconta;
      String vsenha;
      
      BufferedReader teclado= new BufferedReader (new InputStreamReader (System.in));
      
      System.out.println ("Digite o Número da Conta:");
      vconta = teclado.readLine();
	      
      System.out.println ("Digite a senha:");
      vsenha = teclado.readLine();
    
      if(conta.equals(vconta) && senha.equals(vsenha)){ 
      
	System.out.println("Nome do Cliente: "+nome);
	System.out.println("Agência do Cliente: "+agencia);
	System.out.println("Saldo do Cliente: "+saldo);
	System.out.println("Limite do Cliente: "+limite);
	System.out.println("Limite Total do Cliente: "+(saldo+limite));
	
      }else{
      
	System.out.println("Número da conta ou senha não confere");
      }
	  
	  
	  
   }
}
