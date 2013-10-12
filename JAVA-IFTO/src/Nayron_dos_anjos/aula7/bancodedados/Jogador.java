
package Nayron_dos_anjos.aula7.bancodedados;

/**
 *
 * @author Náyron dos Anjos
 */
public class Jogador implements java.io.Serializable{
    private String nome;
    private String login;
    private String email;
    private String senha;
    private int id;
    
    public Jogador(){
        
    }
    /**
    *@param nome nomes do jogar
    * return void 
    */
    public void setNome(String nome){
        this.nome = nome;
    }
    /**
     * 
     * @return uma String com o nome do jogador
     */
    public String getNome(){
        return this.nome;
    }
     /**
     * 
     * @return uma String com o login do jogador
     */
    public String getLogin(){
        return this.login;
    }
    /**
     * 
     * Configura o login do Jogador
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

    /**
     * @return the ip
     */
    public int getId() {
        return this.id;
    }

      public void setid(int id) {
        this.id = id;
    }
    
}
