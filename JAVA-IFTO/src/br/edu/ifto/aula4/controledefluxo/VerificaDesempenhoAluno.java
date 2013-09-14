/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifto.aula4.controledefluxo;

/**
 *
 * @author Giovane
 */
public class VerificaDesempenhoAluno {

    public static void main(String args[]) {
        System.out.println(verificaDesempenho(6.5));
    }

    private static String verificaDesempenho(Double media) {
        if (media <= 4.0) {
            return "PESSIMO";
        }
        if (media > 4.0 && media <= 6.0) {
            return "RUIM";
        }
        if (media > 6.0 && media <= 7.0) {
            return "REGULAR";
        }
        if (media > 7.0 && media <= 8.5) {
            return "BOM";
        }
        if (media > 8.5) {
            return "OTIMO";
        }
        return null;
    }
}