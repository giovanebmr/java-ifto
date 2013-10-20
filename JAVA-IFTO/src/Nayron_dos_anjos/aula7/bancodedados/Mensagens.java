/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Nayron_dos_anjos.aula7.bancodedados;

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
public class Mensagens extends Thread {
    
    private JTextArea jta;
            
   public Mensagens(JTextArea jta){
       this.jta = jta;
       
   }
    /**
     *
     */
    @Override
   public void run(){
        while(true){
              try {
            JogadorDao dao = new JogadorDao();
        

            List<Mensagem> msgs = dao.listaMensagens();
            jta.setText("");

            for (Iterator<Mensagem> it = msgs.iterator(); it.hasNext();) {
                Mensagem mensagem = it.next();
                jta.setText(jta.getText() + "\n" + mensagem.getHorarioMensagem() + " - " + mensagem.getApelido() + " fala: " + mensagem.getMensagem());
            }
            
            sleep(5000);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Batepapo.class.getName()).log(Level.SEVERE, null, ex);
        }   catch (InterruptedException ex) {
                Logger.getLogger(Mensagens.class.getName()).log(Level.SEVERE, null, ex);
            }

       
    
}
    }
}

