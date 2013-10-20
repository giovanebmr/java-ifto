package Tayla.Jogo;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author aluno
 */
public class Mensagem implements java.io.Serializable{
    
    private int Id;
    private String Remetente;
    private String Destinatario;
    private String Mensagem;
    private String HoraMensagem;
    
    
    public Mensagem(){        
    }

     public void setId(int id){
        this.Id = id;
    }
    
    public void setRemetente(String remetente){
        this.Remetente = remetente;
    }
    
    public void setDestinatario(String destinatario){
        this.Destinatario = destinatario;
    }
    
    public void setMensagem(String mensagem){
        this.Mensagem = mensagem;
    }
    
     public void setHoraMensagem(String horamensagem){
        this.HoraMensagem = horamensagem;
    }
    
        
    
    public int getId(){
        return this.Id;
    }
    
    public String getRemetente(){
        return this.Remetente;
    }
               
    public String getDestinatario(){
        return this.Destinatario;
    }
     
    public String getMensagem(){
        return this.Mensagem;
    }
    
    public String getHoraMensagem(){
        return this.HoraMensagem;
    }
    
}