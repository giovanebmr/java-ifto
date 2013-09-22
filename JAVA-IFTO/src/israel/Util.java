/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package israel;


/**
 *
 * @author Giovane
 */
public class Util {

    /**
     * Retorna true se for possível a conversão do número
     * Retorna false se não for possível a conversão
     */
    public boolean isNumero(String numero) {
        try {
            Integer.parseInt(numero);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Simples lançamento de Exceptions
     */
    public boolean isNumero2(String numero) throws NumberFormatException {
        Integer.parseInt(numero);
        return true;
    }
}
