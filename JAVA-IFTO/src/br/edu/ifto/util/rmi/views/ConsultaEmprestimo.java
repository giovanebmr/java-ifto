package br.edu.ifto.util.rmi.views;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.edu.ifto.util.rmi.beans.Aluno;
import br.edu.ifto.util.rmi.beans.Emprestimo;
import br.edu.ifto.util.rmi.beans.Livro;
import br.edu.ifto.util.rmi.dao.DaoCompleto;
import br.edu.ifto.util.rmi.dao.IDaoCompleto;
import br.edu.ifto.util.rmi.dao.NotFoundException;

/**
 *
 * @author Giovane
 */
public class ConsultaEmprestimo extends javax.swing.JFrame {

    public ConsultaEmprestimo() throws ClassNotFoundException, SQLException, RemoteException, NotBoundException, MalformedURLException, NotFoundException {
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        minhasConfiguracoes();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consultar Emprestimo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP));

        jButton1.setText("Consultar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConsultar(evt);
            }
        });

        jLabel1.setText("Por Aluno");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 192, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(26, 26, 26))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoConsultar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConsultar
        try {
            
            Emprestimo emprestimo = new Emprestimo();
            List<Emprestimo> emprestimos = new LinkedList<Emprestimo>();

            Registry reg;
            IDaoCompleto iDaoCompleto = new DaoCompleto();
            reg = LocateRegistry.getRegistry("localhost", 7000);
            
            for (Iterator<Aluno> it = this.listaAluno.iterator(); it.hasNext();) {
                Aluno ib = it.next();
                if (ib.getNome().equals(((String) jComboBox1.getSelectedItem()))) {
                    emprestimo.setAluno(ib);
                   // JOptionPane.showMessageDialog(rootPane, ib.getMatricula());
                    break;
                }
            }
            
            emprestimo.setLivro(new Livro());
            
           
            iDaoCompleto = (IDaoCompleto) reg.lookup("DaoCompleto");
            
            
            emprestimos = (List<Emprestimo>) iDaoCompleto.searchMatchingEmprestimo(emprestimo);

           // JOptionPane.showMessageDialog(rootPane, reservas);

            preencheTabela(emprestimos);
            
        } catch (ClassNotFoundException | SQLException | RemoteException | NotBoundException | NotFoundException ex) {
            Logger.getLogger(ConsultaEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
        }




    }//GEN-LAST:event_botaoConsultar
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private void minhasConfiguracoes() throws ClassNotFoundException, SQLException, RemoteException, NotBoundException, MalformedURLException, NotFoundException {
        setAlunos();
        jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object[25][4], new String[]{"Código do Emprestimo", "Livro", "Data do Emprestimo", "Data da Devolução"}));
    }

    private void preencheTabela(List<Emprestimo> emprestimos) {

        jTable1.removeAll();

        String array[][] = new String[emprestimos.size()][4];

        int i = 0;

        for (Iterator<Emprestimo> it = emprestimos.iterator(); it.hasNext();) {
            Emprestimo emprestimo = it.next();
            array[i][0] = emprestimo.getId() + "";
            array[i][1] = emprestimo.getLivro().getTitulo() + "";
            array[i][2] = emprestimo.getDataInicio() + "";
            array[i][3] = emprestimo.getDataFinal() + "";
            i++;
        }

        jTable1.setModel(new javax.swing.table.DefaultTableModel(array, new String[]{"Código do Emprestimo", "Livro", "Data do Emprestimo", "Data da Devolução"}));

        jTable1.updateUI();
    }

    private void setAlunos() throws NotBoundException, MalformedURLException, RemoteException, SQLException, ClassNotFoundException, NotFoundException {


        Registry reg;

        IDaoCompleto iDaoCompleto = new DaoCompleto();

        reg = LocateRegistry.getRegistry("localhost", 7000);

        iDaoCompleto = (IDaoCompleto) reg.lookup("DaoCompleto");

        this.listaAluno = iDaoCompleto.loadAll();

        java.lang.String nome[] = new java.lang.String[listaAluno.size()];

        int i = 0;

        for (Iterator<Aluno> it = listaAluno.iterator(); it.hasNext();) {
            Aluno ib = it.next();
            nome[i] = ib.getNome();
            i++;
        }

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(nome));
    }

    private List listaAluno;
}
