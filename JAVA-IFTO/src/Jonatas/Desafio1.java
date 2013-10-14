package Jonatas;

/*Desafio:

Crie um aplicativo que guarde dados bancários: nome, conta, agência, saldo
e limite. Quando o usuário iniciar o aplicativo, o sistema pedira o número
da conta e uma senha de autenticação, se o conjunto conta e senha estiver 
correto, mostre os dados bancários, se a conta e senha não forem digitadas
corretamente, exiba uma mensagem de erro e feche o programa.
Usem os programas que foram feitos em sala como exemplo.

Para fazer a comparação use o comando  if  
E o método equals da String que armazena a senha.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Desafio1 {
    
    public static void main(String args[]) throws IOException{
    
      String nome = "João";
      String conta = "1234";
      String agencia = "0102";
      String senha = "00000";
      Double saldo = 1500.50;
      Double limite = 25000.00;
      
      String vconta;
      String vsenha;
      
      BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
      
      System.out.println("Entre com o numero da conta ");
      vconta = teclado.readLine();
      
      System.out.println("Entre com a senha ");
      vsenha = teclado.readLine();
      
       if(vsenha.equals(senha) &&  vconta.equals(conta)){ //teste
            
            System.out.println("Nome do Cliente: " + nome );
            System.out.println("Conta: " + conta );
            System.out.println("Agencia: " + agencia );
            System.out.println("Saldo: " + saldo );
            System.out.println("Limite: " + limite );
            
            
        }else{
	  System.out.println("Erro");
        }//fim do if
    
    }
    
}