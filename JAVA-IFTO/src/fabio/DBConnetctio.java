/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fabio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author aluno
 */
public class DBConnetctio {

    public Connection getMyConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:derby://localhost:1527/pamers", "pamers","pamers");
    }
}