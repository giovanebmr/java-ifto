/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Paulo;

/**
 *
 * @author Paulo
 */
public class Desempenho {
    
    double nota;
    private String mensagem;
    
    
    
    public String getDesempenho(double nota){
        
        if(nota <= 4){
            mensagem = "Péssimo";
        }
        
        if(nota > 4   &&  nota < 6){
            mensagem = "Ruim";
        }
        
        if(nota >= 6   &&  nota < 8){
            mensagem = "Bom";
        }
        
        if(nota >= 8   &&  nota <= 10){
            mensagem = "Ótimo";
        }
        
        if(nota >= 11){
            mensagem = "Não existe essa nota";
        }
        
        return mensagem;
   }
    
}
