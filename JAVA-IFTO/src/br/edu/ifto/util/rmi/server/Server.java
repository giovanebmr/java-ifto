/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifto.util.rmi.server;

import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.*;
import java.sql.SQLException;
import javax.naming.NamingException;
import br.edu.ifto.util.rmi.dao.DaoCompleto;

/**
 *
 * @author giovane
 */
public class Server {


    public static void main(String[] args) throws RemoteException, MalformedURLException, AccessException, AlreadyBoundException, SQLException, NamingException, Exception {
        try {
           

            DaoCompleto dc = new DaoCompleto();

            Registry registry = LocateRegistry.createRegistry(7000);
            
            registry.bind("DaoCompleto", dc);

           

            Thread.sleep(10000);
        } catch (RemoteException | ClassNotFoundException | SQLException | AlreadyBoundException |  InterruptedException e) {
            System.err.println("Error: " + e);
        }
    }
}
