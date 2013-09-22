/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifto.aula8;

/**
 * Contem métodos de validação de conversão de string em números
 * @author Giovane Bruno Monte Reis
 * @see 22/09/2013
 */
public class Util {

    /** Verifica se uma string pode ser convertida em um número inteiro (Integer)
     * @param numero uma string de entrada a ser validada pelo método
     * @return true se for possível a conversão ou false se não for possível
     */
    public boolean isNumeroInteger(String numero) {
        try {
            Integer.parseInt(numero);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    /** Verifica se uma string pode ser convertida em um número com precisão após a virgula (Float)
     * @param numero uma string de entrada a ser validada pelo método
     * @return true se for possível a conversão ou false se não for possível
     */
    public boolean isNumeroFloat(String numero){
        try{
            Float.parseFloat(numero);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }

    /**
     * Faz um teste de conversão de string em um número inteiro
     * @throws NumberFormatException
     * @deprecated
     */
    public void isNumeroIntegerTest(String numero) throws NumberFormatException {
        Integer.parseInt(numero);
    }
    
    // java.lang.System.getProperty("");     informações do sistema operacional
}
