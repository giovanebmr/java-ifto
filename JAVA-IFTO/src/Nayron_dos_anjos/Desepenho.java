/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Nayron_dos_anjos;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class Desepenho {
    double nota;
    
    public String getDesempenho(double nota){
        String mensagem = null;
        if(nota >=0 && nota <4){
            mensagem = "Desempenho Péssimo";
        }else if(nota >=4 && nota <=6){
            mensagem = "Desempenho ruim";
        }else if(nota >6 && nota <=8){
            mensagem = "/desempenho Bom";
            
        }else if(nota> 8 && nota<=10){
            mensagem = "Desempenho Otimo";
        }
        return mensagem;
    }
      
    
    
}
