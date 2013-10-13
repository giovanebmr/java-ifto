/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package giovane2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Giovane
 */
public class DBConnection {
    public Connection getMyDBConnection() throws ClassNotFoundException, SQLException {
       // Class.forName("org.apache.derby.jdbc.ClientDriver");  //necessário com java anterior à versão 6
        return DriverManager.getConnection("jdbc:derby://localhost:1527/jogo_da_velha","javadb","javadb");
    }
}
