/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifto.util;

/**
 *
 * @author Giovane
 */
public class Util {
    
    public boolean isNumero(String numero) {
        try {
            Integer.parseInt(numero);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    
}
