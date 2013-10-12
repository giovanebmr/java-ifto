/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Emanuelle.aula7.banco;

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
        String SQL = "insert into Emanuelle.jogador (nome,login,email,senha) values (?,?,?,?)";


        PreparedStatement stat = conn.prepareStatement(SQL);

        stat.setString(1, jogador.getNome());
        stat.setString(2, jogador.getLogin());
        stat.setString(3, jogador.getEmail());
        stat.setString(4, jogador.getSenha());

        stat.execute();
        stat.close();

    }

    public List<Jogador> listarUsuario() throws SQLException {

        String sql = "select * from EMANUELLE.JOGADOR";
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

        jogador.setId(rs.getInt("id"));
        jogador.setNome(rs.getString("nome"));
        jogador.setEmail(rs.getString("email"));

        return jogador;

    }
    
    public void deleteUsuario (int id){
        String SQL = "DELETE from Emanuelle.jogador WHERE id = ?";
        
    }
    
    public void atulizarUsuario (Jogador jogador) throws SQLException{
        String SQL = "UPDATE into Emanuelle.jogador WHERE id = ?";


        PreparedStatement stat = conn.prepareStatement(SQL);

        stat.setString(1, jogador.getNome());
        stat.setString(2, jogador.getLogin());
        stat.setString(3, jogador.getEmail());
        stat.setString(4, jogador.getSenha());
        stat.setInt(5, jogador.getId());
        

        stat.execute();
        stat.close();

    }
    
}
