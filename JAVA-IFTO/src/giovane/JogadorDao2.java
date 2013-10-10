/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package giovane;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Giovane
 */
public class JogadorDao2 extends DBConnection {

    private final Connection conn;

    public JogadorDao2() throws ClassNotFoundException, SQLException {
        this.conn = this.getMyDBConnection();
    }

    public void addJogador(Usuario jogador) throws SQLException {
        String SQL = "insert into jogodavelha.jogador (nome, login, email, senha) values( ?,  ?,  ?,  ?)";

        try (PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setString(1, jogador.getNome());
            stmt.setString(2, jogador.getLogin());
            stmt.setString(3, jogador.getEmail());
            stmt.setString(4, jogador.getSenha());
            stmt.execute();
        }
    }

    public List<Usuario> listaUsuarios() throws SQLException {
        String sql = "SELECT * FROM JOGODAVELHA.JOGADOR";
        PreparedStatement stmt;
        ResultSet rs;
        List jogadores = new LinkedList<Usuario>();
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();
        while (rs.next()) {
            jogadores.add(getUsuario(rs));
        }
        return jogadores;
    }

    public Usuario getUsuario(ResultSet rs) throws SQLException {
        Usuario jogador = new Usuario();
        jogador.setId(rs.getInt("id_jogador"));
        jogador.setNome(rs.getString("nome"));
        jogador.setEmail(rs.getString("email"));
        jogador.setSenha(rs.getString("senha"));
        return jogador;
    }
}