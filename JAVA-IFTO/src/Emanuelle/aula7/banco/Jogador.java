/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Emanuelle.aula7.banco;

/**
 *
 * @author aluno
 */
public class Jogador {
    private String nome;
    private String login;
    private String email;
    private String senha;
    private int id;
    
    public Jogador () {
}
    public void setNome (String nome){
        this.nome=nome;
    }
    public String getNome (){
    return this.nome;
    }
    public void setLogin (String login){
    this.login=login;
    }
    public String getLogin (){
    return this.login;
    }
    public void setEmail (String email){
        this.email=email;
    }
    public String getEmail() {
        return email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
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
    
}

