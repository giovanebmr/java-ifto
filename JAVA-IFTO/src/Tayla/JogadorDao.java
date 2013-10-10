package Tayla;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


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
public class JogadorDao extends DBConnection{
    private final Connection conn;
    
    public JogadorDao() throws ClassNotFoundException, SQLException{
        this.conn = getMyDBConnection();
    }
    
    
    public void addJogador (Jogador jogador) throws SQLException{
        String SQL = "insert into TAYLA.JOGADOR"
            + "(nome, login, email, senha)"
            + "values (?,?,?,?)";
    
    PreparedStatement stmt = conn.prepareStatement(SQL);
    
    stmt.setString(1, jogador.getNome());
    stmt.setString(2, jogador.getLogin());
    stmt.setString(3, jogador.getEmail());
    stmt.setString(4, jogador.getSenha());
    
    stmt.execute();
    stmt.close();
        
    } 
    
    public List <Jogador> listaUsuarios() throws SQLException{
     
     String sql = "SELECT * FROM JONATAS.JOGADOR";
     PreparedStatement stmt;
     ResultSet rs;
     List jogadores = new LinkedList<>();
     Jogador jogador;
     
     stmt = conn.prepareStatement(sql);
     
     rs = stmt.executeQuery();
     
     while(rs.next()) {
     
         jogadores.add(getObjeto(rs));
         
     }
        return null;
  } 
 
  public Jogador getObjeto(ResultSet rs) throws SQLException{
  
      Jogador jogador = new Jogador();
      jogador.setId(rs.getInt("id"));
      jogador.setNome(rs.getString("nome"));
      jogador.setEmail(rs.getString("email"));
      return jogador;
  }
}
