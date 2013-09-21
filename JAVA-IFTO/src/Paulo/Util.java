/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Paulo;

import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class Util {
    

    
   
    /*
     * retorna true se for possível converter
     * retorna false se,não for possível
     **/
    public boolean isNumero(String numero) {

        try {
            Integer.parseInt(numero);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /*
     * não há controle nesse método
     * retorna sempre true
     **/
    public boolean isNumero2(String numero) throws NumberFormatException {
        Integer.parseInt(numero);
        return true;
    }
      
        
      
}
