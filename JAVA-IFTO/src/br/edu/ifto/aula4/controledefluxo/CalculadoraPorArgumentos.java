/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifto.aula4.controledefluxo;

/**
 *
 * @author Giovane
 */
public class CalculadoraPorArgumentos {

    public static void main(String args[]) {

        double resultado = 0d;

        System.out.println("teste");
        
        switch ((args[0]).toUpperCase()) {
            case "SOMAR":
                for (int i = 1; i < args.length; i++) {
                    resultado = resultado + Double.parseDouble(args[i]);
                }
                break;
            case "DIVIDIR":
                resultado = Double.parseDouble(args[1]);
                for (int i = 2; i < args.length; i++) {
                    resultado = resultado / Double.parseDouble(args[i]);
                }
                break;
            case "MULTIPLICAR":
                resultado = Double.parseDouble(args[1]);
                for (int i = 2; i < args.length; i++) {
                    resultado = resultado * Double.parseDouble(args[i]);
                }
                break;
            case "SUBTRAIR":
                resultado = Double.parseDouble(args[1]);
                for (int i = 2; i < args.length; i++) {
                    resultado = resultado - Double.parseDouble(args[i]);
                }
                break;
            default:
                System.out.println("\nAs opções são: SOMAR, DIVIDIR, MULTIPLICAR e SUBTRAIR.\n");
                break;

        }
         System.out.println("\nO resultado é: " + resultado);
    }
}
