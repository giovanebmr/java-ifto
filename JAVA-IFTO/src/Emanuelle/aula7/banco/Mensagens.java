/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Emanuelle.aula7.banco;

import static java.lang.Thread.sleep;
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

    public Mensagens(JTextArea a) {
        jta = a;
    }

    @Override
    public void run() {

        while (true) {
            try {
                JogadorDao dao = new JogadorDao();
                List<Mensagem> mensagens = dao.listaMensagens();
                this.jta.setText("");
                for (Iterator<Mensagem> it = mensagens.iterator(); it.hasNext();) {
                    Mensagem mensagem1 = it.next();
                    this.jta.setText(jta.getText() + "\n" + mensagem1.getHorarioMensagem() + "-" + mensagem1.getApelido() + "fala: " + mensagem1.getMensagem());
                }
                sleep(5000);
            } catch (    ClassNotFoundException | SQLException | InterruptedException ex) {
                Logger.getLogger(Mensagens.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }

    }
}
