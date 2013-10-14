/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fabio;

/**
 *
 * @author aluno
 */
public class Usuario implements java.io.Serializable {

    private int id;
    private String nome;
    private String login;
    private String email;
    private String senha;

    public Usuario() {
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setlogin(String login) {
        this.setLogin(login);
    }

    public String getLogin() {
        return this.login;
    }

    public void setemail(String email) {
        this.setEmail(email);
            
           
    }

    public String getEmail() {
        return this.email;

    }
    
    public void setSenha(String senha){
        this.senha = senha;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
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
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    void setId(String string) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    
    
    
}
    
        
        
         
           
                
        
    

