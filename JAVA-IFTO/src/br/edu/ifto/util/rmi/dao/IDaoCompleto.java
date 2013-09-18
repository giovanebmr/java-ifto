/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifto.util.rmi.dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import br.edu.ifto.util.rmi.beans.Aluno;
import br.edu.ifto.util.rmi.beans.Emprestimo;
import br.edu.ifto.util.rmi.beans.Livro;
import br.edu.ifto.util.rmi.beans.Reserva;

/**
 *
 * @author Giovane
 */
public interface IDaoCompleto extends Remote{

    int countAll() throws SQLException, RemoteException;

    int countAllEmprestimo() throws SQLException, RemoteException;

    int countAllLivro() throws SQLException, RemoteException;

    int countAllReserva() throws SQLException, RemoteException;

    void create(Aluno valueObject) throws SQLException, RemoteException;

    void createEmprestimo(Emprestimo valueObject) throws SQLException, RemoteException;

    void createLivro(Livro valueObject) throws SQLException, RemoteException;

    void createReserva(Reserva valueObject) throws SQLException, RemoteException;

    Aluno createValueObjectAluno() throws RemoteException;

    Emprestimo createValueObjectEmprestimo() throws RemoteException;

    Livro createValueObjectLivro() throws RemoteException;

    Reserva createValueObjectReserva() throws RemoteException;

    int databaseUpdate(PreparedStatement stmt) throws SQLException, RemoteException;

    int databaseUpdateReserva(PreparedStatement stmt) throws SQLException, RemoteException;

    void delete(Aluno valueObject) throws NotFoundException, SQLException, RemoteException;

    void deleteAll() throws SQLException, RemoteException;

    void deleteAllEmprestimo() throws SQLException, RemoteException;

    void deleteAllLivro() throws SQLException, RemoteException;

    void deleteAllReserva() throws SQLException, RemoteException;

    void deleteEmprestimo(Emprestimo valueObject) throws NotFoundException, SQLException, RemoteException;

    void deleteLivro(Livro valueObject) throws NotFoundException, SQLException, RemoteException;

    void deleteReserva(Reserva valueObject) throws NotFoundException, SQLException, RemoteException;

    /**
     * Utiliza AlunoDAO      para retornar Aluno
     */
    Aluno getAlunoDAO(int id) throws ClassNotFoundException, RemoteException, NotFoundException, SQLException;

    /**
     * Utiliza AlunoDAO para retornar Aluno
     */
    Aluno getAlunoDAOReserva(int id) throws ClassNotFoundException, RemoteException, NotFoundException, SQLException;

    /**
     * Utiliza LivroDAO     para retornar Livro
     */
    Livro getLivroDAO(int id) throws ClassNotFoundException, RemoteException, SQLException, NotFoundException;

    /**
     * Utiliza LivroDAO para retornar Livro
     */
    Livro getLivroDAOReserva(int id) throws ClassNotFoundException, RemoteException, NotFoundException, SQLException;

    Connection getMyDBConnection() throws ClassNotFoundException, SQLException, RemoteException;

    Aluno getObject(int id) throws NotFoundException, SQLException, RemoteException;

    Emprestimo getObjectEmprestimo(int id) throws NotFoundException, SQLException, ClassNotFoundException, RemoteException;

    Livro getObjectLivro(int id) throws NotFoundException, SQLException, ClassNotFoundException, RemoteException;

    Reserva getObjectReserva(int id) throws NotFoundException, SQLException, ClassNotFoundException, RemoteException;

    List listQuery(PreparedStatement stmt) throws SQLException, RemoteException;

    List listQueryReserva(PreparedStatement stmt) throws SQLException, ClassNotFoundException, RemoteException, NotFoundException;

    void load(Aluno valueObject) throws NotFoundException, SQLException, RemoteException;

    List loadAll() throws SQLException, RemoteException;

    List loadAllEmprestimo() throws SQLException, ClassNotFoundException, RemoteException, NotFoundException;

    List loadAllLivro() throws SQLException, ClassNotFoundException, RemoteException, NotFoundException;

    List loadAllReserva() throws SQLException, ClassNotFoundException, RemoteException, NotFoundException;

    void loadEmprestimo(Emprestimo valueObject) throws NotFoundException, SQLException, ClassNotFoundException, RemoteException;

    void loadLivro(Livro valueObject) throws NotFoundException, SQLException, ClassNotFoundException, RemoteException;

    void loadReserva(Reserva valueObject) throws NotFoundException, SQLException, ClassNotFoundException, RemoteException;

    void save(Aluno valueObject) throws NotFoundException, SQLException, RemoteException;

    void saveEmprestimo(Emprestimo valueObject) throws NotFoundException, SQLException, RemoteException;

    void saveLivro(Livro valueObject) throws NotFoundException, SQLException, RemoteException;

    void saveReserva(Reserva valueObject) throws NotFoundException, SQLException, RemoteException;

    List searchMatching(Aluno valueObject) throws SQLException, ClassNotFoundException, RemoteException;

    List searchMatchingEmprestimo(Emprestimo valueObject) throws SQLException, ClassNotFoundException, RemoteException, NotFoundException;

    List searchMatchingLivro(Livro valueObject) throws SQLException, ClassNotFoundException, RemoteException, NotFoundException;

    List searchMatchingReserva(Reserva valueObject) throws SQLException, ClassNotFoundException, RemoteException, NotFoundException;

    void singleQuery(PreparedStatement stmt, Aluno valueObject) throws NotFoundException, SQLException, RemoteException;

    void singleQueryReserva(PreparedStatement stmt, Reserva valueObject) throws NotFoundException, SQLException, ClassNotFoundException, RemoteException;
    
}
