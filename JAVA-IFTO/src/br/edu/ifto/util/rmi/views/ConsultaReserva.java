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
import javax.swing.JOptionPane;
import br.edu.ifto.util.rmi.beans.Aluno;
import br.edu.ifto.util.rmi.beans.Livro;
import br.edu.ifto.util.rmi.beans.Reserva;
import br.edu.ifto.util.rmi.dao.DaoCompleto;
import br.edu.ifto.util.rmi.dao.IDaoCompleto;
import br.edu.ifto.util.rmi.dao.ILivro;
import br.edu.ifto.util.rmi.dao.NotFoundException;

/**
 *
 * @author Giovane
 */
public class ConsultaReserva extends javax.swing.JFrame {

    public ConsultaReserva() throws ClassNotFoundException, SQLException, RemoteException, NotBoundException, MalformedURLException, NotFoundException {
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consultar Reserva", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP));

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
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
            
            Reserva reserva = new Reserva();
            List<Reserva> reservas = new LinkedList<Reserva>();

            Registry reg;
            IDaoCompleto iDaoCompleto = new DaoCompleto();
            reg = LocateRegistry.getRegistry("localhost", 7000);
            
            for (Iterator<Aluno> it = this.listaAluno.iterator(); it.hasNext();) {
                Aluno ib = it.next();
                if (ib.getNome().equals(((String) jComboBox1.getSelectedItem()))) {
                    reserva.setAluno(ib);
                   // JOptionPane.showMessageDialog(rootPane, ib.getMatricula());
                    break;
                }
            }
            
            reserva.setLivro(new Livro());
            
           
            iDaoCompleto = (IDaoCompleto) reg.lookup("DaoCompleto");
            
            
            reservas = (List<Reserva>) iDaoCompleto.searchMatchingReserva(reserva);

           // JOptionPane.showMessageDialog(rootPane, reservas);

            preencheTabela(reservas);
            
        } catch (ClassNotFoundException | SQLException | RemoteException | NotBoundException | NotFoundException ex) {
            Logger.getLogger(ConsultaReserva.class.getName()).log(Level.SEVERE, null, ex);
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
        jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object[25][3], new String[]{"Código da Reserva", "Data Reservada", "Nome do Livro"}));
    }

    private void preencheTabela(List<Reserva> reservas) {

        jTable1.removeAll();

        String array[][] = new String[reservas.size()][3];

        int i = 0;

        for (Iterator<Reserva> it = reservas.iterator(); it.hasNext();) {
            Reserva reserva = it.next();
            array[i][0] = reserva.getId() + "";
            array[i][1] = reserva.getDataInicio() + "";
            array[i][2] = reserva.getLivro().getTitulo() + "";
            i++;
        }

        jTable1.setModel(new javax.swing.table.DefaultTableModel(array, new String[]{"Código da Reserva", "Data Reservada", "Nome do Livro"}));

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
