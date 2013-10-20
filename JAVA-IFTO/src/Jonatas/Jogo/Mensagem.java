/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jonatas.Jogo;

import java.io.Serializable;

/**
 *
 * @author Jonatas Carvalho
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
    
    public int getId(){
        return this.Id;
    }
    
    public void setRemetente(String remetente){
        this.Remetente = remetente;
    }
    
    public String getRemetente(){
        return this.Remetente;
    }
    
    public void setDestinatario(String destinatario){
        this.Destinatario = destinatario;
    }
    
    public String getDestinatario(){
        return this.Destinatario;
    }
    
    
    public void setMensagem(String mensagem){
        this.Mensagem = mensagem;
    }
    
    public String getMensagem(){
        return this.Mensagem;
    }
    
    public String getHoraMensagem(){
        return this.HoraMensagem;
    }
    
    public void setHoraMensagem(String mensagem){
        this.HoraMensagem = mensagem;
    }
  


    
}
