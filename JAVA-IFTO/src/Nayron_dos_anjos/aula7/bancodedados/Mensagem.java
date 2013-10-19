/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Nayron_dos_anjos.aula7.bancodedados;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author aluno
 */
public class Mensagem {
    private int id;
    private String apelido;
    private String mensagem;
    private String horarioMensagem;

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

    /**
     * @return the apelido
     */
    public String getApelido() {
        return apelido;
    }

    /**
     * @param apelido the apelido to set
     */
    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    /**
     * @return the horarioMensagem
     */
    public String getHorarioMensagem() {
        return horarioMensagem;
    }

    /**
     * @param horarioMensagem the horarioMensagem to set
     */
    public void setHorarioMensagem(String horarioMensagem) {
        this.horarioMensagem = horarioMensagem;
    }

    /**
     * @return the mensagem
     */
    public String getMensagem() {
        return mensagem;
    }

    /**
     * @param mensagem the mensagem to set
     */
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

   
}
