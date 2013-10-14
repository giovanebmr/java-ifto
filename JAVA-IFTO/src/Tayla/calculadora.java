/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tayla;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author aluno
 */
public class calculadora {
    
    public static void main (String args []){
	int num;
	int num2;
	int resul;
	
	BufferedReader teclado= new BufferedReader (new InputStreamReader (System.in));

	try{
	
	  System.out.println ("Digite o primeiro número");
	  num = Integer.parseInt (teclado.readLine());
	    
	  System.out.println ("Digite o segundo número");
	  num2 = Integer.parseInt (teclado.readLine());
	  
	  resul=num+num2;
	  
	System.out.println ("O resultado é " +resul);
	
	 }catch (Exception e){
	    System.out.println("Houve um erro de exceção");
	  }
  }
}
