/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifto.util.rmi.beans;

import java.util.Objects;


public class Reserva implements java.io.Serializable{
    
    private int id;
    private String dataInicio;
    private String dataFinal;
    
    private Livro livro;
    private Aluno aluno;

    public Reserva() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    @Override
    public String toString() {
        return "Reserva{" + "id=" + id + ", dataInicio=" + dataInicio + ", dataFinal=" + dataFinal + ", livro=" + livro + ", aluno=" + aluno + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id;
        hash = 67 * hash + Objects.hashCode(this.dataInicio);
        hash = 67 * hash + Objects.hashCode(this.dataFinal);
        hash = 67 * hash + Objects.hashCode(this.livro);
        hash = 67 * hash + Objects.hashCode(this.aluno);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reserva other = (Reserva) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.dataInicio, other.dataInicio)) {
            return false;
        }
        if (!Objects.equals(this.dataFinal, other.dataFinal)) {
            return false;
        }
        if (!Objects.equals(this.livro, other.livro)) {
            return false;
        }
        if (!Objects.equals(this.aluno, other.aluno)) {
            return false;
        }
        return true;
    }

    public Reserva(int id, String dataInicio, String dataFinal, Livro livro, Aluno aluno) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.livro = livro;
        this.aluno = aluno;
    }

    public Reserva(String dataInicio, String dataFinal, Livro livro, Aluno aluno) {
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.livro = livro;
        this.aluno = aluno;
    }
    
    
    
}
