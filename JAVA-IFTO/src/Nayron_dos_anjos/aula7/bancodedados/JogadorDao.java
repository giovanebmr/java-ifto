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
        String SQL = "insert into NAYRON.jogador(nome,login,email,senha) values (?,?,?,?)";

        PreparedStatement stmt = conn.prepareStatement(SQL);

        stmt.setString(1, jogador.getNome());
        stmt.setString(2, jogador.getLogin());
        stmt.setString(3, jogador.getEmail());
        stmt.setString(4, jogador.getSenha());

        stmt.execute();
        stmt.close();

    }
    public void deleteUsuario(int id) throws SQLException {
        String SQL = "DELETE FROM NAYRON.jogador WHERE id=?";

        PreparedStatement stmt = conn.prepareStatement(SQL);

        stmt.execute();
        stmt.close();
    }

    public void AlterarUsuario(Jogador jogador) throws SQLException {
        String SQL = "UPDATE NAYRON.jogador SET nome=?,login=?,email=?,senha=?,WHERE id=?";

        PreparedStatement stmt = conn.prepareStatement(SQL);

        stmt.setString(1, jogador.getNome());
        stmt.setString(2, jogador.getLogin());
        stmt.setString(3, jogador.getEmail());
        stmt.setString(4, jogador.getSenha());
        stmt.setInt(5, jogador.getId());

        stmt.execute();
        stmt.close();
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
        
        while(rs.next()){
            jogadores.add(getObjeto(rs));
        }

        return jogadores;
    }
    
    public Jogador getObjeto(ResultSet rs) throws SQLException{
        
        Jogador jogador = new Jogador();
        
        jogador.setid(rs.getInt("id"));
        jogador.setNome(rs.getString("nome"));
        jogador.setEmail(rs.getString("email"));
      //  jogador.setSenha(rs.getString("senha"));
        
        return jogador;
    
    }
    
}
