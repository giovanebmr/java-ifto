/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jonatas.Jogo;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author aluno
 */
public class Mensagens extends Thread{
    private JTextArea jta;
    
    public Mensagens(JTextArea jta){
        this.jta = jta;
    
    }
    
    @Override
    public void run(){
        while(true){
            
            try {
                listarMensagens();
                sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Mensagens.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
    private void listarMensagens(){
        
        JogadorDao jogadorDao;
        try {
            jogadorDao = new JogadorDao();
             List<Mensagem> mensagens = jogadorDao.listaMensagem();
            this.jta.setText("");
        for (Iterator<Mensagem>  it = mensagens.iterator(); it.hasNext();){
            Mensagem mensagem1 = it.next();
            this.jta.append("\n" + mensagem1.getHoraMensagem() +
                      " - " + mensagem1.getRemetente() + 
                        " fala: " + mensagem1.getMensagem()); 
            }
        
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Mensagens.class.getName()).log(Level.SEVERE, null, ex);
        }
              
    }
}
