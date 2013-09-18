/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifto.util.rmi.dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import br.edu.ifto.util.rmi.beans.Livro;

/**
 *
 * @author Giovane
 */
public interface ILivro extends Remote {

    int countAllLivro() throws SQLException, RemoteException;

    void createLivro(Livro valueObject) throws SQLException, RemoteException;

    Livro createValueObjectLivro() throws RemoteException;

    void deleteAllLivro() throws SQLException, RemoteException;

    void deleteLivro(Livro valueObject) throws NotFoundException, SQLException, RemoteException;

    Connection getMyDBConnection() throws ClassNotFoundException, SQLException, RemoteException;

    Livro getObjectLivro(int id) throws NotFoundException, SQLException, ClassNotFoundException, RemoteException;

    List loadAllLivro() throws SQLException, ClassNotFoundException, RemoteException, NotFoundException;

    void loadLivro(Livro valueObject) throws NotFoundException, SQLException, ClassNotFoundException, RemoteException;

    void saveLivro(Livro valueObject) throws NotFoundException, SQLException, RemoteException;

    List searchMatchingLivro(Livro valueObject) throws SQLException, ClassNotFoundException, RemoteException, NotFoundException;
    
}
