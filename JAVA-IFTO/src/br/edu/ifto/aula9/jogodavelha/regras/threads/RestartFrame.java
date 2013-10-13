/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifto.aula9.jogodavelha.regras.threads;

import br.edu.ifto.aula9.jogodavelha.view.TelaDeDesafios;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Giovane
 */
public class RestartFrame extends Thread {

    private TelaDeDesafios telaDeDesafios;

    public RestartFrame(TelaDeDesafios aThis) {
        this.telaDeDesafios = aThis;
    }

    @Override
    public void run() {
        repintura();
    }

    private void repintura() {
        try {
            if(!telaDeDesafios.isRepintouFrame()){
                this.telaDeDesafios.setVisible(false);
                RestartFrame.sleep(600);
                this.telaDeDesafios.setVisible(true);
                telaDeDesafios.setRepintouFrame(true);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(RestartFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
