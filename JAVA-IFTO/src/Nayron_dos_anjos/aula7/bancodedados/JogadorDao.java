/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Nayron_dos_anjos.aula7.bancodedados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

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
        String SQL = "insert into NAYRON.JOGADOR(nome,login,email,senha) values (?,?,?,?)";

        PreparedStatement stmt = conn.prepareStatement(SQL);

        stmt.setString(1, jogador.getNome());
        stmt.setString(2, jogador.getLogin());
        stmt.setString(3, jogador.getEmail());
        stmt.setString(4, jogador.getSenha());

        stmt.execute();
        stmt.close();

    }

    public boolean deleteUsuario(int id) throws SQLException {
        String SQL = "DELETE FROM NAYRON.JOGADOR where id_jogador=?";

        PreparedStatement stmt = conn.prepareStatement(SQL);

        stmt.setInt(1, id);

        return stmt.executeUpdate()> 0;

    }

    public boolean AlterarUsuario(Jogador jogador) throws SQLException {
        String SQL = "UPDATE NAYRON.JOGADOR SET nome=?,login=?,email=?,senha=?"
                + "where id_jogador=?";

        PreparedStatement stmt = conn.prepareStatement(SQL);

        stmt.setString(1, jogador.getNome());
        stmt.setString(2, jogador.getLogin());
        stmt.setString(3, jogador.getEmail());
        stmt.setString(4, jogador.getSenha());
        stmt.setInt(5, jogador.getId());

        return stmt.executeUpdate() > 0;
    }

    /**
     *
     * @return @throws SQLException
     */
    public List<Jogador> listaUsuarios() throws SQLException {

        String sql = "select * from NAYRON.JOGADOR";
        PreparedStatement stmt;
        ResultSet rs;

        List jogadores = new LinkedList<>();

        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();

        while (rs.next()) {
            jogadores.add(getObjeto(rs));
        }

        return jogadores;
    }

    public Jogador getObjeto(ResultSet rs) throws SQLException {

        Jogador jogador = new Jogador();

        jogador.setid(rs.getInt("id_jogador"));
        jogador.setNome(rs.getString("nome"));
        jogador.setEmail(rs.getString("email"));
        jogador.setLogin(rs.getString("login"));

        return jogador;

    }
    public void addUsuario(Mensagem mensagem) throws SQLException  {
        String SQL = "insert into NAYRON.MENSAGEM3(apelido,mensagem,horarioMensagem) values (?,?,CURRENT_TIMESTAMP)";
        PreparedStatement stmt = conn.prepareStatement(SQL);

        stmt.setString(1, mensagem.getApelido());
        stmt.setString(2, mensagem.getMensagem());
        

        stmt.execute();
    }
}
