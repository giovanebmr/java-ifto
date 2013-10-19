package br.edu.ifto.aula9.jogodavelha.dao.control;

import br.edu.ifto.aula9.jogodavelha.beans.Jogador;
import br.edu.ifto.aula9.jogodavelha.dao.JogadorDao;
import java.sql.SQLException;

/**
 * Controle do objeto jogador<br/>
 * Separa a camada view da camada DAO<br/>
 * Recebe um objeto Jogador e repassa para o método específico da classe
 * JogadorDao <br/>
 * Realiza login e logof
 * @author Giovane Bruno Monte Reis
 * @since 1.0.0
 * @version 1.0.0
 */

public class JogadorControl {

    public boolean sair(Jogador jogador) throws SQLException, ClassNotFoundException {
        return (new JogadorDao()).setOnlineFalse(jogador);
    }

    public boolean desafiarJogador(Jogador jogadorRemoto, Jogador jogadorLocal) throws ClassNotFoundException, SQLException {
        return (new JogadorDao()).setDesafio(jogadorRemoto, jogadorLocal);
    }
    
    public boolean selecionarMesaJogador1(Jogador jogadorLocal, int idMesa) throws ClassNotFoundException, SQLException{
        return (new JogadorDao()).setMesaJogador1(jogadorLocal, idMesa);
    }
    
    public boolean selecionarMesaJogador2(Jogador jogadorLocal, int idMesa) throws ClassNotFoundException, SQLException{
        return (new JogadorDao()).setMesaJogador2(jogadorLocal, idMesa);
    }
    
    public boolean cancelaMesaJogador1(Jogador jogadorLocal) throws ClassNotFoundException, SQLException{
        return (new JogadorDao()).cancelarMesaJogador1(jogadorLocal);
    }
    
    public boolean cancelaMesaJogador2(Jogador jogadorLocal) throws ClassNotFoundException, SQLException{
        return (new JogadorDao()).cancelarMesaJogador2(jogadorLocal);
    }
    
    public boolean isJogadorInMesa(int idJogador) throws ClassNotFoundException, SQLException{
        return (new JogadorDao()).countJogadorMesa(idJogador) > 0;
    }
    
}
