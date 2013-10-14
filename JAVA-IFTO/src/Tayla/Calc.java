/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tayla;

/**
 *
 * @author aluno
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Calc {
    
    public static void main (String args []){

    if (args.length == 3){
    
      if (args[0].toUpperCase().equals ("SOMAR")){
	System.out.println ("Operação de Soma");
	System.out.println ("Resultado: " + (Integer.parseInt(args[1]) + Integer.parseInt(args[2])));
      }
      
      if (args[0].toUpperCase().equals ("SUBTRAIR")){
	System.out.println ("Operação de Substração");
	System.out.println ("Resultado: " + (Integer.parseInt(args[1]) - Integer.parseInt(args[2])));
      }
      
      if (args[0].toUpperCase().equals ("MULTIPLICAR")){
	System.out.println ("Operação de Multiplicação");
	System.out.println ("Resultado: " + (Integer.parseInt(args[1]) * Integer.parseInt(args[2])));
      }
      
      if (args[0].toUpperCase().equals ("DIVIDIR")){
	System.out.println ("Operação de Divisão");
	System.out.println ("Resultado: " + (Double.parseDouble(args[1]) / Integer.parseInt(args[2])));
      }
      
    }else{
	System.out.println ("Informe 3 parâmetros.");
     }
  }
}
