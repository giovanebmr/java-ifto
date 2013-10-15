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
public class Jogador implements java.io.Serializable{
    private int Id;
    private String Nome;
    private String Login;
    private String Email;
    private String Senha;
    
    public Jogador(){
    
    }

    public Jogador(String Nome, String Login, String Email, String Senha) {
        this.Nome = Nome;
        this.Login = Login;
        this.Email = Email;
        this.Senha = Senha;
    }

   
    
    public void setId(int id){
        this.Id = id;
    }
    
    public void setId(int id){
        this.Id = id;
    }
    
    public int getId(){
        return this.Id;
    }
    
    public void setNome(String nome){
        this.Nome = nome;
    }
    
    public void setLogin(String login){
        this.Login = login;
    }
     
    public void setEmail(String email){
        this.Email = email;
    }
    
    public void setSenha(String senha){
        this.Senha = senha;
    }
    
    public String getNome(){
        return this.Nome;        
    }
    
    public String getLogin(){
        return this.Login;        
    }
    
    public String getEmail(){
        return this.Email;        
    }
        
    public String getSenha(){
        return this.Senha;        
    }

    
}
