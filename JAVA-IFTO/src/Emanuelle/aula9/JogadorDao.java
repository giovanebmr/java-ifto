/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Emanuelle.aula9;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author aluno
 */
public class JogadorDao extends DBConnection {

    private final Connection conn;

    public JogadorDao() throws ClassNotFoundException, SQLException {
        this.conn = this.getMyDBConnection();
    }

    public void addJogador(Jogador jogador) throws SQLException {
        String SQL = "insert into Emanuelle.jogador (nome,login,email,senha) values (?,?,?,?)";


        PreparedStatement stat = conn.prepareStatement(SQL);

        stat.setString(1, jogador.getNome());
        stat.setString(2, jogador.getLogin());
        stat.setString(3, jogador.getEmail());
        stat.setString(4, jogador.getSenha());

        stat.execute();
        stat.close();

    }
}
