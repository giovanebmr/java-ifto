/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifto.util.rmi.beans;

import java.util.Objects;

/**
 *
 * @author Giovane
 */
public class Emprestimo implements java.io.Serializable{

    public Emprestimo() {
    }
    
    private int id;
    private String dataInicio;
    private String dataFinal;
    
    private Livro livro;
    private Aluno aluno;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicial) {
        this.dataInicio = dataInicial;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
        hash = 59 * hash + Objects.hashCode(this.dataInicio);
        hash = 59 * hash + Objects.hashCode(this.dataFinal);
        hash = 59 * hash + Objects.hashCode(this.livro);
        hash = 59 * hash + Objects.hashCode(this.aluno);
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
        final Emprestimo other = (Emprestimo) obj;
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

    @Override
    public String toString() {
        return "Emprestimo{" + "id=" + id + ", dataInicial=" + dataInicio + ", dataFinal=" + dataFinal + ", livro=" + livro + ", aluno=" + aluno + '}';
    }

    public Emprestimo(int id, String dataInicial, String dataFinal, Livro livro, Aluno aluno) {
        this.id = id;
        this.dataInicio = dataInicial;
        this.dataFinal = dataFinal;
        this.livro = livro;
        this.aluno = aluno;
    }

    public Emprestimo(String dataInicial, String dataFinal, Livro livro, Aluno aluno) {
        this.dataInicio = dataInicial;
        this.dataFinal = dataFinal;
        this.livro = livro;
        this.aluno = aluno;
    }
    
    
  
}
