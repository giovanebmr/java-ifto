/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifto.aula9.jogodavelha.regras.threads;

import br.edu.ifto.aula9.jogodavelha.dao.control.JogadorControl;

/**
 *
 * @author Giovane Bruno Monte Reis
 */
public class ConfiguraMesa extends Thread{
    
    private JogadorControl control;
    
    public void rum(){
        control = new JogadorControl();
    }
    
    
    
}
