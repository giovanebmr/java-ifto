/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifto.aula9.jogodavelha.beans;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Giovane
 */
public class Mensagem {
    private int idRemetente;
    private int idDestinatario;
    private String mensagem;
    private java.sql.Date dataMensagem;
    private java.sql.Time horarioMensagem;

    public int getIdRemetente() {
        return idRemetente;
    }

    public void setIdRemetente(int idRemetente) {
        this.idRemetente = idRemetente;
    }

    public int getIdDestinatario() {
        return idDestinatario;
    }

    public void setIdDestinatario(int idDestinatario) {
        this.idDestinatario = idDestinatario;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Date getDataMensagem() {
        return dataMensagem;
    }

    public void setDataMensagem(Date dataMensagem) {
        this.dataMensagem = dataMensagem;
    }

    public Time getHorarioMensagem() {
        return horarioMensagem;
    }

    public void setHorarioMensagem(Time horarioMensagem) {
        this.horarioMensagem = horarioMensagem;
    }

 
    
}
