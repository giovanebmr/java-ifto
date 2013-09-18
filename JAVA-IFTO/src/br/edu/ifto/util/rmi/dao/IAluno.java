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


public interface IAluno extends Remote{

   
    int countAll() throws SQLException, RemoteException;

  
    void create(Aluno valueObject) throws SQLException, RemoteException;

    Aluno createValueObject() throws RemoteException;

    
    int databaseUpdate(PreparedStatement stmt) throws SQLException, RemoteException;

   
    void delete(Aluno valueObject) throws NotFoundException, SQLException, RemoteException;

    Connection getMyDBConnection() throws ClassNotFoundException, SQLException, RemoteException;

   
    Aluno getObject(int id) throws NotFoundException, SQLException, RemoteException;

    
    List listQuery(PreparedStatement stmt) throws SQLException, RemoteException;

  
    void load(Aluno valueObject) throws NotFoundException, SQLException, RemoteException;

    List loadAll() throws SQLException, RemoteException;

   
    void save(Aluno valueObject) throws NotFoundException, SQLException, RemoteException;

    
    List searchMatching(Aluno valueObject) throws SQLException, ClassNotFoundException, RemoteException;

    void singleQuery(PreparedStatement stmt, Aluno valueObject) throws NotFoundException, SQLException, RemoteException;
    
}
