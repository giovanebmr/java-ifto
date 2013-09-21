package Nayron_dos_anjos.aula7;

/**
 *
 * @author aluno
 */
public class Util {
     /**
     * Retorna true se for possivel a conversão
     * retorna false se não for possivel
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
     * Não tem controle retorna sempre true
     */
    public boolean isNumero2(String numero) throws NumberFormatException {
        Integer.parseInt(numero);
        return true;
    }
}