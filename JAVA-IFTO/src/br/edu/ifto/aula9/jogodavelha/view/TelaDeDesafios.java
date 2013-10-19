/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifto.aula9.jogodavelha.view;

import br.edu.ifto.aula9.jogodavelha.beans.Jogador;
import br.edu.ifto.aula9.jogodavelha.dao.control.JogadorControl;
import br.edu.ifto.aula9.jogodavelha.regras.threads.ControleDeJogadoresOnLineDisponiveis;
import br.edu.ifto.aula9.jogodavelha.regras.threads.ControleDeMesasSelecionadas;
import br.edu.ifto.aula9.jogodavelha.view.componentes.MesaJPanel;
import java.awt.ComponentOrientation;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Giovane Bruno Monte Reis
 */
public class TelaDeDesafios extends javax.swing.JFrame {

    /**
     * Creates new form TelaDeDesafios
     */
    public TelaDeDesafios(Jogador jogador) {
        this.jogador = jogador;
        initComponents();
        myConfig();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCentral = new JPanelBackground(getClass().getResource("/br/edu/ifto/aula9/jogodavelha/imagens/DSC00512.JPG").getPath());
        jPanelTopo = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jPanelRodape = new javax.swing.JPanel();
        jPanelEsquerdo = new javax.swing.JPanel();
        jPanelListaJogadores = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListJogadoresOnLineDisponiveis = new javax.swing.JList();
        jPanelBotoesJogadores = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanelDireita = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPaneSalaDeDesafios = new javax.swing.JScrollPane();
        jPanelSalaDeDesafios = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                botaoFecharPrograma(evt);
            }
        });

        jPanelCentral.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
                repinturaDoFrame(evt);
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
            }
        });

        jPanelTopo.setBackground(new java.awt.Color(204, 204, 255));

        jButton3.setText("Caixa de Mensagens");

        javax.swing.GroupLayout jPanelTopoLayout = new javax.swing.GroupLayout(jPanelTopo);
        jPanelTopo.setLayout(jPanelTopoLayout);
        jPanelTopoLayout.setHorizontalGroup(
            jPanelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTopoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTopoLayout.setVerticalGroup(
            jPanelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTopoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelRodape.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout jPanelRodapeLayout = new javax.swing.GroupLayout(jPanelRodape);
        jPanelRodape.setLayout(jPanelRodapeLayout);
        jPanelRodapeLayout.setHorizontalGroup(
            jPanelRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelRodapeLayout.setVerticalGroup(
            jPanelRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 105, Short.MAX_VALUE)
        );

        jPanelEsquerdo.setBackground(new java.awt.Color(255, 204, 204));

        jPanelListaJogadores.setBackground(new java.awt.Color(204, 255, 204));

        jListJogadoresOnLineDisponiveis.setBackground(new java.awt.Color(0, 0, 0));
        jListJogadoresOnLineDisponiveis.setForeground(new java.awt.Color(255, 255, 255));
        jListJogadoresOnLineDisponiveis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListJogadoresOnLineDisponiveisMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jListJogadoresOnLineDisponiveis);

        javax.swing.GroupLayout jPanelListaJogadoresLayout = new javax.swing.GroupLayout(jPanelListaJogadores);
        jPanelListaJogadores.setLayout(jPanelListaJogadoresLayout);
        jPanelListaJogadoresLayout.setHorizontalGroup(
            jPanelListaJogadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListaJogadoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))
        );
        jPanelListaJogadoresLayout.setVerticalGroup(
            jPanelListaJogadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListaJogadoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jButton1.setText("Desafiar");

        jButton2.setText("Mensagem");

        javax.swing.GroupLayout jPanelBotoesJogadoresLayout = new javax.swing.GroupLayout(jPanelBotoesJogadores);
        jPanelBotoesJogadores.setLayout(jPanelBotoesJogadoresLayout);
        jPanelBotoesJogadoresLayout.setHorizontalGroup(
            jPanelBotoesJogadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotoesJogadoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );
        jPanelBotoesJogadoresLayout.setVerticalGroup(
            jPanelBotoesJogadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotoesJogadoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBotoesJogadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelDireita.setOpaque(false);

        javax.swing.GroupLayout jPanelDireitaLayout = new javax.swing.GroupLayout(jPanelDireita);
        jPanelDireita.setLayout(jPanelDireitaLayout);
        jPanelDireitaLayout.setHorizontalGroup(
            jPanelDireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelDireitaLayout.setVerticalGroup(
            jPanelDireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanelSalaDeDesafios.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanelSalaDeDesafiosLayout = new javax.swing.GroupLayout(jPanelSalaDeDesafios);
        jPanelSalaDeDesafios.setLayout(jPanelSalaDeDesafiosLayout);
        jPanelSalaDeDesafiosLayout.setHorizontalGroup(
            jPanelSalaDeDesafiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 649, Short.MAX_VALUE)
        );
        jPanelSalaDeDesafiosLayout.setVerticalGroup(
            jPanelSalaDeDesafiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 196, Short.MAX_VALUE)
        );

        jScrollPaneSalaDeDesafios.setViewportView(jPanelSalaDeDesafios);

        jTabbedPane1.addTab("Sala de Desafios", jScrollPaneSalaDeDesafios);

        javax.swing.GroupLayout jPanelEsquerdoLayout = new javax.swing.GroupLayout(jPanelEsquerdo);
        jPanelEsquerdo.setLayout(jPanelEsquerdoLayout);
        jPanelEsquerdoLayout.setHorizontalGroup(
            jPanelEsquerdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEsquerdoLayout.createSequentialGroup()
                .addGroup(jPanelEsquerdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEsquerdoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanelBotoesJogadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelListaJogadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelDireita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelEsquerdoLayout.setVerticalGroup(
            jPanelEsquerdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelDireita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelEsquerdoLayout.createSequentialGroup()
                .addComponent(jPanelListaJogadores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanelBotoesJogadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jTabbedPane1)
        );

        javax.swing.GroupLayout jPanelCentralLayout = new javax.swing.GroupLayout(jPanelCentral);
        jPanelCentral.setLayout(jPanelCentralLayout);
        jPanelCentralLayout.setHorizontalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelRodape, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelTopo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelCentralLayout.createSequentialGroup()
                .addComponent(jPanelEsquerdo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelCentralLayout.setVerticalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCentralLayout.createSequentialGroup()
                .addComponent(jPanelTopo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanelEsquerdo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelRodape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void repinturaDoFrame(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_repinturaDoFrame
        //   Thread t2 = new RestartFrame(this);
        //  t2.start();
    }//GEN-LAST:event_repinturaDoFrame

    private void botaoFecharPrograma(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_botaoFecharPrograma
        try {
            //Seta o jogador para of-line
            if (!(new JogadorControl().sair(jogador))) {
                JOptionPane.showMessageDialog(rootPane, "Ocorreu uma falha no procedimento de logof", "Aviso", 2);
            }
            //varre a tabela de mesas tentando excluir o jogador de possíveis mesas selecionadas...
            (new JogadorControl()).cancelaMesaJogador1(jogador);

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(TelaDeDesafios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botaoFecharPrograma

    private void jListJogadoresOnLineDisponiveisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListJogadoresOnLineDisponiveisMouseClicked
        JOptionPane.showMessageDialog(rootPane, jListJogadoresOnLineDisponiveis.getSelectedValue() + "");
    }//GEN-LAST:event_jListJogadoresOnLineDisponiveisMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JList jListJogadoresOnLineDisponiveis;
    private javax.swing.JPanel jPanelBotoesJogadores;
    private javax.swing.JPanel jPanelCentral;
    private javax.swing.JPanel jPanelDireita;
    private javax.swing.JPanel jPanelEsquerdo;
    private javax.swing.JPanel jPanelListaJogadores;
    private javax.swing.JPanel jPanelRodape;
    private javax.swing.JPanel jPanelSalaDeDesafios;
    private javax.swing.JPanel jPanelTopo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneSalaDeDesafios;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
    /**
     * Contem os dados do usuário que fez o login
     */
    private Jogador jogador;
    private boolean repintouFrame;
    /**
     * Mesas de desafio
     */
    private List<MesaJPanel> mesas = new LinkedList<>();

    private void myConfig() {
        //configura o frame para abrir no tamanho do monitor
        this.setSize(this.getToolkit().getScreenSize().width, this.getToolkit().getScreenSize().height);
        Rectangle r = new Rectangle(this.getToolkit().getScreenSize());

        jPanelTopo.setOpaque(false);
        jPanelRodape.setOpaque(false);
        jPanelEsquerdo.setOpaque(false);
        jPanelListaJogadores.setOpaque(false);
        jPanelBotoesJogadores.setOpaque(false);

        this.setDefaultCloseOperation(3);  //EXIT_ON_CLOSE
        this.setSize(this.getToolkit().getScreenSize().width, this.getToolkit().getScreenSize().height);
        this.setMinimumSize(new Dimension(400, 600));
        this.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        // this.setResizable(false);
        this.setTitle("Jogo da Velha 1.0.0 ALPHA");


        //inicia a Thread de controle de jogadores on-line...
        Thread t = new ControleDeJogadoresOnLineDisponiveis(jListJogadoresOnLineDisponiveis);
        t.start();
        
        //inicia a Thread de controle de mesas selecionadas
        Thread t2 = new ControleDeMesasSelecionadas(mesas);
        t2.start();

        //coloca mesas na sala de desafios
        preencheMesas();


    }

    /**
     * @return the repintouFrame
     */
    public boolean isRepintouFrame() {
        return repintouFrame;
    }

    /**
     * @param repintouFrame the repintouFrame to set
     */
    public void setRepintouFrame(boolean repintouFrame) {
        this.repintouFrame = repintouFrame;
    }

    private void preencheMesas() {

        final int QUANTIDADE_MESAS = 50;

        jPanelSalaDeDesafios.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        jPanelSalaDeDesafios.setLayout(new GridLayout(0, 5, 15, 15));

        //inicialisa a lista de mesas, passando o jogador e o id da mesa pelo construtor do objeto MesaJPanel
        for (int i = 0; i < QUANTIDADE_MESAS; i++) {
            MesaJPanel mesa = new MesaJPanel(this.jogador, i + 1);
            mesa.setPreferredSize(new Dimension(184, 65));
            mesa.setMaximumSize(new Dimension(184, 65));
            mesas.add(mesa);
        }

        //colocal no painel
        for (Iterator<MesaJPanel> it = mesas.iterator(); it.hasNext();) {
            jPanelSalaDeDesafios.add(it.next());
        }
    }
}
