/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Paulo;

import com.sun.xml.internal.messaging.saaj.util.ParserPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.derby.client.am.UpdateSensitiveBlobLocatorInputStream;

/**
 *
 * @author Paulo
 */
public class JogadorDao extends DBConnection {

    private final Connection conn;

    public JogadorDao() throws ClassNotFoundException, SQLException {
        this.conn = this.getMyDBConnection();
    }

    public void addJogador(Usuario jogador) throws SQLException {
        String SQL = "insert into paulo.usuario(nome, login, email, senha) values(?,?,?,?)";

        PreparedStatement stat = conn.prepareStatement(SQL);

        stat.setString(1, jogador.getNome());
        stat.setString(2, jogador.getLogin());
        stat.setString(3, jogador.getEmail());
        stat.setString(4, jogador.getSenha());

        stat.execute();
        stat.close();
        

    }
    
    public boolean deletarUsuario(int id_jogador) throws SQLException {
        
        PreparedStatement stmt = null;
        
        try {
            String SQL = "DELETE FROM paulo.usuario where id_jogador=?";
            
            stmt = conn.prepareStatement(SQL);
            
            stmt.setInt(1, id_jogador);
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(JogadorDao.class.getName()).log(Level.SEVERE, null, ex);
        return false;
        } finally{
            if(stmt != null){
                stmt.close();
            }
        }
    
}
        
        
    
        
        
    
    
    /**
     * 
     * @param usuario
     * @throws SQLException 
     */
    
    public boolean AlterarUsuario(Usuario usuario) throws SQLException{
        String SQL = "UPDATE PAULO.USUARIO SET nome=?, login=?, email=?"
                +" WHERE id_jogador = ?";
        
        PreparedStatement stmt = conn.prepareStatement(SQL);
        
        stmt.setString(1, usuario.getNome());
        stmt.setString(2, usuario.getLogin());
        stmt.setString(3, usuario.getEmail());
        stmt.setInt(4, usuario.getId()); 
        
        return stmt.executeUpdate() > 0;
    }
        
    

    // para testar o banco retire o bloco de comentarios abaixo
    /*
     public static void main(String arg[]) throws SQLException, ClassNotFoundException{

     JogadorDao jogadordao = new JogadorDao();
     Jogador jogador = new Jogador();
        
     jogador.setNome("Paulo Augusto");
     jogador.setEmail("paulo@gmail.com");
     jogador.setLogin("paulo");
     jogador.setSenha("123");
        
     jogadordao.addJogador(jogador);
        
     }
     */
    public List listaUsuario() throws SQLException {
        PreparedStatement stmt = null;
            ResultSet rs = null;
        try {
            String sql = "SELECT * FROM PAULO.USUARIO";
            
            List usuarios = new LinkedList<>();
            Usuario jogador;

            stmt = conn.prepareStatement(sql);

            rs = stmt.executeQuery();

            while (rs.next()) {
                usuarios.add(getObjeto(rs));
            }

            return usuarios;
        } catch (SQLException ex) {
            Logger.getLogger(JogadorDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        finally{
            if(stmt != null){
                stmt.close();
            }
            if(rs != null){
                rs.close();
            }
        }
        
}
    
    /**
     *
     * @param rs
     * @return
     */
    public Usuario getObjeto(ResultSet rs) throws SQLException {

        Usuario jogador = new Usuario();
        jogador.setId(rs.getInt("id_jogador"));
        jogador.setNome(rs.getString("nome"));
        jogador.setEmail(rs.getString("email"));
        jogador.setLogin(rs.getString("login"));
        return jogador;

    }

    
}
