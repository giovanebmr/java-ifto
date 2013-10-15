/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fabio;

/**
 *
 * @author aluno
 */
public class Desempenho_1 {

    String mensagem;

    public String getDesempenho(double nota) {

        if (nota <= 0 && nota >= 4) {
            mensagem = "pessimo";
        }

        if (nota > 4 && nota < 6) {
            mensagem = "ruim";
        }
        if (nota >= 6 && nota < 8) {
            mensagem = "bom";
        }
        if (nota >= 8 && nota < 10) {
            mensagem = "ótimo";
        }

        return mensagem;


    }
}