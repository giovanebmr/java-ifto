/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fabio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class UsuarioDAO extends DBConnetctio {

    private final Connection con;

    public UsuarioDAO() throws SQLException {
        this.con = this.getMyConnection();
    }

    /**
     *
     * @return @throws SQLException
     */
    public ArrayList<Usuario> listaUsuarios() throws SQLException {

        String sql = "SELECT * FROM JOGODAVELHA.JOGADOR";
        PreparedStatement stmt;
        ResultSet rs;
        ArrayList usuarios = new ArrayList<Usuario>();

        stmt = con.prepareStatement(sql);

        rs = stmt.executeQuery();

        while (rs.next()) {
            usuarios.add(getObjeto(rs));
        }
        return usuarios;
    }
    

    private Usuario getObjeto(ResultSet rs) throws SQLException {
        Usuario u = new Usuario();
        u.setEmail(rs.getString("email"));
        u.setLogin(rs.getString("login"));
        u.setNome(rs.getString("nome"));
        u.setId(rs.getString("id"));
        return u;
    }
}
