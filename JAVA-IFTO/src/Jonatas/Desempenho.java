/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jonatas;

/**
 *
 * @author aluno
 */
public class Desempenho{
  
  private double nota;
  private String Mensagem;
  
  public String getDesempenho (double nota){ 
  
    if (nota >=0 && nota <4){
    Mensagem = "Aluno com Desempenho Péssimo.";
    }
        
    if (nota >= 4 && nota <6){
    Mensagem = "Aluno com Desempenho Ruim.";
    }
    
    if (nota >= 6 && nota <8){
    Mensagem = "Aluno com Desempenho Bom.";
    }
    
    if (nota >= 8 && nota <=10){
    Mensagem = "Aluno com Desempenho Ótimo.";
    }
    
     if (nota <0 || nota >10){
    Mensagem = "Informe uma nota entre 0 e 10.";
    }
    
    
    return Mensagem;
  }
 
}

