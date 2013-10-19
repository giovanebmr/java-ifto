/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifto.aula9.jogodavelha.regras.threads;

import br.edu.ifto.aula9.jogodavelha.view.componentes.MesaJPanel;
import java.util.List;

/**
 * @author Giovane Bruno Monte Reis
 */

public class ControleDeMesasSelecionadas extends Thread {

    private List<MesaJPanel> mesas;

    public ControleDeMesasSelecionadas(List<MesaJPanel> mesas) {
        this.mesas = mesas;
    }

    public void rum() throws InterruptedException {

        while (true) {
            //busca a lista de mesas

            //preenche as mesas locais


            //dorme por 5 segundos
            sleep(5000);
        }
    }
}
