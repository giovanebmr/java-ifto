/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package giovane.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Giovane
 * 
 */
public class UsuarioDao extends DBConnection {

    private final Connection conn;

    public UsuarioDao() throws ClassNotFoundException, SQLException {
        this.conn = this.getMyDBConnection();
    }

    /**
     * @param usuario
     */
    public boolean AlterarUsuario(Usuario usuario) throws SQLException {
        String SQL = "UPDATE jogodavelha.jogador SET nome=?, login=?, email=?"
                + " WHERE id_jogador = ?";

        try (PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getLogin());
            stmt.setString(3, usuario.getEmail());
            stmt.setInt(4, usuario.getId());

            return stmt.executeUpdate() > 0;
        }

    }

    public boolean deletarUsuario(int id) throws SQLException {
        PreparedStatement stmt = null;
        try {
            String SQL = "DELETE FROM jogodavelha.jogador where id_jogador = ?";
            stmt = conn.prepareStatement(SQL);
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public void addUsuario(Usuario usuario) throws SQLException {
        String SQL = "insert into jogodavelha.jogador (nome, login, email, senha) values( ?,  ?,  ?,  ?)";

        try (PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getLogin());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getSenha());
            stmt.execute();
        }
    }

    public List<Usuario> listaUsuarios() throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM JOGODAVELHA.JOGADOR";
            List usuarios = new LinkedList<Usuario>();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                usuarios.add(getUsuario(rs));
            }
            return usuarios;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(stmt != null){
                stmt.close();
            }
            if(rs != null){
                rs.close();
            }
        }
    }

    public Usuario getUsuario(ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setId(rs.getInt("id_jogador"));
        usuario.setNome(rs.getString("nome"));
        usuario.setEmail(rs.getString("email"));
        usuario.setLogin(rs.getString("login"));
        return usuario;
    }
}