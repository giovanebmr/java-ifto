/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Paulo;

/**
 *
 * @author Paulo
 */
public class Usuario implements java.io.Serializable{
    
    private String nome;
    private String login;
    private String email;
    private String senha;
    private int id;
    
   // public Jogador(){
   // }
    
    public void setId(int id) {
        this.id = id;
    }
   
    public int getId(){
        return id;
    }
    /**
     * @param nome nome do jogador
     * @return void
     */
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
     * @return Uma String com o nome do jogador
     */
    
    public String getNome(){
        return nome;
    }
    
       
    /**
     *  @return configura o login do jogador
     */
    
    public void setLogin(String login){
        this.login = login;
    }
    
    /**
     * @return Uma String com o login do jogador
     */
    
    public String getLogin(){
        return login;
    }
    
    /**
     * @ param email configura o email
     */
    
    public void setEmail(String email){
        this.email = email;
    }
    
    /**
     * @ return o Email
     */
    
    public String getEmail(){
        return email;
    }
    
    /**
     * @param senha configura senha
     */
    
    public void setSenha(String senha){
        this.senha = senha;
    }    
    
    /** 
     * @return a senha 
     */
        
    public String getSenha(){
        return senha;
    }
    
}
