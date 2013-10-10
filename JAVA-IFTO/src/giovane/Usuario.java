/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package giovane;

/**
 *
 * @author Giovane
 */
public class Usuario implements java.io.Serializable{
    
    private int id;
    private String nome;
    private String login;
    private String email;
    private String senha;

    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    /**
     * @param nome configura o nome do jogador
     * @return void
     */
    public void setNome(String nome){
        this.nome = nome;
    }
    
    /**
     * @return Uma String com o nome do jogador
     */
    public String getNome(){
        return this.nome;
    }
    
    /**
     * @return Uma String com o login do jogador
     */
    public String getLogin(){
        return this.login;
    }
    
    /**
     * @return configura o login do jogador
     */
    public void setLogin(String login){
        this.login = login;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
}
