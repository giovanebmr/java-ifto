package Tayla.Jogo;

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
    Jogador jogador;
    
    public JogadorDao() throws ClassNotFoundException, SQLException{
        this.conn = getMyDBConnection();
    }
    
    public JogadorDao(Jogador jogador) throws ClassNotFoundException, SQLException{
        this.conn = getMyDBConnection();
        this.jogador = jogador;
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
    
   public void addJogador () throws SQLException{
        String SQL = "insert into TAYLA.JOGADOR"
            + "(nome, login, email, senha)"
            + "values (?,?,?,?)";
    
    PreparedStatement stmt = conn.prepareStatement(SQL);
    
    stmt.setString(1, this.jogador.getNome());
    stmt.setString(2, this.jogador.getLogin());
    stmt.setString(3, this.jogador.getEmail());
    stmt.setString(4, this.jogador.getSenha());
    
    stmt.execute();
    stmt.close();
        
    } 
    
    public List <Jogador> listaUsuarios() throws SQLException{
     
     String sql = "SELECT * FROM TAYLA.JOGADOR";
     PreparedStatement stmt;
     ResultSet rs;
     List jogadores = new LinkedList<>();
     Jogador jogador;
     
     stmt = conn.prepareStatement(sql);
     
     rs = stmt.executeQuery();
     
     while(rs.next()) {
     
         jogadores.add(getObjeto(rs));
         
     }
        return jogadores;
        
  } 
 
  public Jogador getObjeto(ResultSet rs) throws SQLException{
  
      Jogador jogador = new Jogador();
      jogador.setId(rs.getInt("id_jogador"));
      jogador.setNome(rs.getString("nome"));
      jogador.setEmail(rs.getString("email"));
      jogador.setLogin(rs.getString("login"));
      return jogador;
  }
  
  public boolean AlterarJogador (Jogador jogador) throws SQLException{
      String SQL = "UPDATE tayla.JOGADOR "
              + "SET nome = ?, login=?, email=? "
              + "where id_jogador =?";
      
      PreparedStatement stmt = conn.prepareStatement(SQL);
      
      stmt.setString(1, jogador.getNome());
      stmt.setString(2, jogador.getLogin());
      stmt.setString(3, jogador.getEmail());
      stmt.setInt(4, jogador.getId());
      
      return stmt.executeUpdate() > 0;
  }
  
    public boolean DeletarJogador () throws SQLException{
      String SQL = "delete from tayla.JOGADOR "
              + "where id_jogador =?";
      
      PreparedStatement stmt = conn.prepareStatement(SQL);
      

      stmt.setInt(1, this.jogador.getId());
      
      return stmt.executeUpdate() > 0;
  }
   
   public void addMensagem (Mensagem mensagem) throws SQLException{
        String SQL = "insert into TAYLA.MENSAGEM"
            + "(Remetente, Destinatario, Mensagem, horarioMensagem)"
            + "values (?, ?, ?, CURRENT_TIMESTAMP)";
    
    PreparedStatement stmt = conn.prepareStatement(SQL);
    
    stmt.setString(1, mensagem.getRemetente());
    stmt.setString(2, mensagem.getDestinatario());
    stmt.setString(3, mensagem.getMensagem());
        
    stmt.execute();
    stmt.close();
        
    } 
    
   public List <Mensagem> listaMensagem() throws SQLException{
     
     String sql = "SELECT * FROM TAYLA.MENSAGEM";
     PreparedStatement stmt;
     ResultSet rs;
     List mensagens = new LinkedList<>();
     Mensagem mensagem;
     
     stmt = conn.prepareStatement(sql);
     
     rs = stmt.executeQuery();
     
     while(rs.next()) {
     
         mensagens.add(getMensagem(rs));
         
     }
        return mensagens;
        
  }
   
  public void sendMensagem(Mensagem mensagem) throws SQLException{
  
      String SQL = "INSERT INTO TAYLA.MENSAGEM"
              + "(REMETENTE, DESTINATARIO, MENSAGEM, HORARIOMENSAGEM)"
              + "VALUES(?, ?, ?, CURRENT_TIMESTAMP)";
      
      try (PreparedStatement stmt = conn.prepareStatement(SQL)){
      
          stmt.setString(1, mensagem.getRemetente());
          stmt.setString(2, mensagem.getDestinatario());
          stmt.setString(3, mensagem.getMensagem());               
      }     
  
  }
  
  public Mensagem getMensagem(ResultSet rs) throws SQLException{
  
      Mensagem mensagem = new Mensagem();
      mensagem.setId(rs.getInt("id"));
      mensagem.setRemetente(rs.getString("remetente"));
      mensagem.setDestinatario(rs.getString("destinatario"));
      mensagem.setMensagem(rs.getString("mensagem"));
      mensagem.setHoraMensagem(rs.getString("horariomensagem"));
      
      return mensagem;
  }
}
