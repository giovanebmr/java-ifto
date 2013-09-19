/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Nayron_dos_anjos.aula7;

import br.edu.ifto.aula7.InterfaceCalculadora;

/**
 *
 * @author aluno
 */
public class Calculadora implements InterfaceCalculadora {

    @Override
    public double somar(double x, double y) {
        return x+y;
    }

   @Override
    public double subtrair(double x, double y) {
     return x-y;
    }

   @Override
    public double dividir(double x, double y) {
         return x/y;
    }

     @Override
    public double multiplicar(double x, double y) {
         return x*y;
    }
    
}
