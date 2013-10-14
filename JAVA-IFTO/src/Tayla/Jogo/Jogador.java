package Tayla.Jogo;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author aluno
 */
public class Jogador implements java.io.Serializable{
    
    private String nome;
    private String login;
    private String email;
    private String senha;
    private int id;
    
    public Jogador(){        
    }
/*
 *@ parâmetros do jogador
 * @return void
 **/
     public void setId(int id){
        this.id = id;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setLogin(String login){
        this.login = login;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setSenha(String senha){
        this.senha = senha;
    }
    
 /*
 *@ Retorna uma string dos atributos do jogador
 **/  
    public int getId(){
        return this.id;
    }
    
    public String getNome(){
        return this.nome;
    }
               
    public String getLogin(){
        return this.login;
    }
     
    public String getEmail(){
        return this.email;
    }
    
    public String getSenha(){
        return this.senha;
    }
    
   
}