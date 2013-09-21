package Tayla;



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.JOptionPane;

/**
 *
 * @author Tayla
 */

public class Util {
/**
 * Retorna verdadeiro se for possíve a conversão e falso se não.
 */
    public boolean isNumero(String numero) {
        try {
            Integer.parseInt(numero);
            return true;
        } catch (NumberFormatException e) {
            return false;
          }
    }
/** Não a controle nesse método, retorna sempre true
 */
    public boolean isNumero2(String numero) throws NumberFormatException {
        Integer.parseInt(numero);
        return true;
    }
       
}
