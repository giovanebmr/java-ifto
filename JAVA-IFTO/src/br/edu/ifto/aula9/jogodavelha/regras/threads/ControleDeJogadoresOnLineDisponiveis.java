/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifto.aula9.jogodavelha.regras.threads;

import br.edu.ifto.aula9.jogodavelha.beans.Jogador;
import br.edu.ifto.aula9.jogodavelha.dao.JogadorDao;
import br.edu.ifto.aula9.jogodavelha.view.TelaDeDesafios;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 * Faz uma busca, a cada 30 s, de jogadores on-line disponíveis para desafio e coloca no JList de jogadores
 * @author Giovane Bruno Monte Reis
 * @see #jListJogadoresOnLineDisponiveis
 * @since 1.0.0
 * @version 1.0.0
 */
public class ControleDeJogadoresOnLineDisponiveis extends Thread {

    /**Lista de jogadores*/
    private javax.swing.JList jListJogadoresOnLineDisponiveis;
    private boolean stop;
    /**
     * Lista de jogadores on-line
     */
    private List<Jogador> jogadores;

    public ControleDeJogadoresOnLineDisponiveis(JList jListJogadoresOnLine) {
        this.jListJogadoresOnLineDisponiveis = jListJogadoresOnLine;
    }

    //metodo que será executado pela thread
    @Override
    public void run() {
        while (!stop) {
            //preenche a lista de jogadores on-line disponíveis para desafio
            preencheListaDeJogadores();
            try {
                //aguarda 30 segundos para preencher novamente
                ControleDeJogadoresOnLineDisponiveis.sleep(30000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ControleDeJogadoresOnLineDisponiveis.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(jListJogadoresOnLineDisponiveis, "Ocorreu uma falha no programa. |Thread: ControleDeJogadoresOnLine|", "Aviso", 0);
                stop = true;
            }
        }

    }

    /**Preenche a lista de jogadores on-line disponíveis para desafio*/
    private void preencheListaDeJogadores() {
        try {
            JogadorDao dao = new JogadorDao();
            jogadores = dao.loadAllJogadoresLogados();

            //verifica se a lista esta vazia entes de atualizar o JList
            if (!jogadores.isEmpty()) {
                
                final String[] logins = new String[jogadores.size()];

                //inicializa um vetor string para preencher o jlist
                int i = 0;
                for (Iterator<Jogador> it = jogadores.iterator(); it.hasNext();) {
                    logins[i] = (it.next()).getLogin();
                    i++;
                }

                javax.swing.AbstractListModel model = new javax.swing.AbstractListModel() {
                    String[] strings = logins;

                    @Override
                    public int getSize() {
                        return strings.length;
                    }

                    @Override
                    public Object getElementAt(int i) {
                        return strings[i];
                    }
                };

                jListJogadoresOnLineDisponiveis.setModel(model);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(TelaDeDesafios.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(jListJogadoresOnLineDisponiveis, "Ocorreu um erro de conexão com o servidor"
                    + " não foi possível obter a lista de jogadores! "
                    + "\n\nVerifique sua conexão com a internet.", "Aviso", 0);
        }
    }
}