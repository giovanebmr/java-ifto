/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Emanuelle.aula7.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author aluno
 */
public class DBConnection {
    
    public Connection getMyDBConnection()throws ClassNotFoundException, SQLException{
         return DriverManager.getConnection("jdbc:derby://localhost:1527/Jogo","Emanuelle","123456");
    }

    
}
