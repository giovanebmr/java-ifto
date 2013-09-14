package KassioLuis;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aluno
 */
public class Desempenho {
    
    double nota;
    
    String mensagem;
    
    public String getDesempenho(double nota){
    
        if (nota >= 0 && nota <= 4) {
        mensagem = "Desempenho Péssimo";
        }
        if (nota > 4 && nota <= 6) {
        mensagem = "Desempenho Ruim";
        }
        if (nota > 6 && nota <= 8) {
        mensagem = "Desempenho Bom";
        }
        if (nota > 8 && nota <= 10) {
        mensagem = "Desempenho Ótimo";
        }
        
        return mensagem;
    }
}