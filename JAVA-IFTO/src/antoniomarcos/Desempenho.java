
package antoniomarcos;

/**
 *
 * @author Antonio Marcos
 */
public class Desempenho {
    double nota;
    String mensagem;
    
    public String getDesempenho(double nota){
        
        if(nota<=4){
         mensagem = "PESSIMO!!!";
        }
        
        if(nota>4 && nota <6){
           mensagem = "RUIM!!!";
        }
        if(nota>6 && nota<8){
           mensagem = "BOM!!!";
        }
        if(nota>8 && nota<=10){
           mensagem = "ÓTIMO!!!";
    }
        return mensagem;
        
                
    }
    
}
