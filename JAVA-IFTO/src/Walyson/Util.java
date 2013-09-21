package Walyson;


public class Util {

    /**
     * Retorna true se for possível a conversão
     * @param numero
     * @return boolean
     * @autor wanderson
     */
    public boolean isNumero(String numero) {
        try {
            Integer.parseInt(numero);
            return true;

        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isNumero2(String numero) throws NumberFormatException {
        Integer.parseInt(numero);
        return true;

    }
}