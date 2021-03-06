/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jonatas.Jogo;

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
    
    public JogadorDao() throws ClassNotFoundException, SQLException  {
        this.conn = this.getMyDBConnection();
 
    }
    
    public void addJogador(Jogador jogador) throws SQLException{
        
        String SQL = "insert into JONATAS.JOGADOR "
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
    public void addMensagem(Mensagem mensagem) throws SQLException{
        
        String SQL = "INSERT INTO JONATAS.MENSAGEM "
               + "(IDREMETENTE, IDDESTINATARIO, MENSAGEM, HORARIOMENSAGEM) "
               + "VALUES ( ?, ?, ?, CURRENT_TIMESTAMP)";
	
                
        PreparedStatement stmt = conn.prepareStatement(SQL);
        
        stmt.setString(1, mensagem.getRemetente());
        stmt.setString(2, mensagem.getDestinatario());
        stmt.setString(3, mensagem.getMensagem());
               
        stmt.execute();
        stmt.close();
    }
    
     public List <Mensagem> listaMensagem() throws SQLException{
     
     String sql = "SELECT * FROM JONATAS.MENSAGEM";
     PreparedStatement stmt;
     ResultSet rs;
     List mensagens = new LinkedList<>();
     Mensagem mensagem;
     
     stmt = conn.prepareStatement(sql);
     
     rs = stmt.executeQuery();
     
     while(rs.next()) {
     
         mensagens.add(getObjetoMensagem(rs));
         
     }
        return mensagens;
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
        return jogadores;
  }
     
     public boolean AlterarJogador(Jogador jogador) throws SQLException{
         String SQL = "update jonatas.jogador "
                 + "set nome=?, login=?, email=? "
                 + "where id_jogador=?";
         
         PreparedStatement stmt = conn.prepareStatement(SQL);
         
         stmt.setString(1, jogador.getNome());
         stmt.setString(2, jogador.getLogin());
         stmt.setString(3, jogador.getEmail());
         stmt.setInt(4, jogador.getId());
         
         return stmt.executeUpdate() > 0; 
         
         
     }
     
    public boolean DeletarJogador(Jogador jogador) throws SQLException{
         String SQL = "delete from jonatas.jogador "
                    + "where id_jogador=?";
         
         PreparedStatement stmt = conn.prepareStatement(SQL);
         
         stmt.setInt(1, jogador.getId());
         
         return stmt.executeUpdate() > 0; 
         
         
     }
 
  public Jogador getObjeto(ResultSet rs) throws SQLException{
  
      Jogador jogador = new Jogador();
      jogador.setId(rs.getInt("id_jogador"));
      jogador.setNome(rs.getString("nome"));
      jogador.setEmail(rs.getString("email"));
      jogador.setLogin(rs.getString("login"));
      return jogador;
  }
  
  public Mensagem getObjetoMensagem(ResultSet rs) throws SQLException{
  
      Mensagem mensagem = new Mensagem();
      mensagem.setId(rs.getInt("id"));
      mensagem.setMensagem(rs.getString("mensagem")); 
      mensagem.setRemetente(rs.getString("idRemetente"));
      mensagem.setDestinatario(rs.getString("idDestinatario"));
      mensagem.setHoraMensagem(rs.getString("horariomensagem"));
      return mensagem;
  }
}



