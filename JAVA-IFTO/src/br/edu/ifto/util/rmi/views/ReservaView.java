package br.edu.ifto.util.rmi.views;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import br.edu.ifto.util.rmi.beans.Aluno;
import br.edu.ifto.util.rmi.beans.Livro;
import br.edu.ifto.util.rmi.beans.Reserva;
import br.edu.ifto.util.rmi.dao.DaoCompleto;
import br.edu.ifto.util.rmi.dao.IAluno;
import br.edu.ifto.util.rmi.dao.IDaoCompleto;
import br.edu.ifto.util.rmi.dao.ILivro;
import br.edu.ifto.util.rmi.dao.NotFoundException;

/**
 *
 * @author Giovane
 */
public class ReservaView extends javax.swing.JFrame {

    public ReservaView() throws ClassNotFoundException, SQLException, RemoteException, NotBoundException, MalformedURLException, NotFoundException {
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        minhasConfiguracoes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jComboBox4 = new javax.swing.JComboBox();
        jComboBox5 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reservar Livro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1wwwwwwwwwwwww", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("Reservar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoReservar(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1wwwwwwwwwwwww", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Livro e Autor");

        jLabel2.setText("Matrícula e Aluno");

        jLabel3.setText("Data da Reserva");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 49, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(26, 26, 26))
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
    //private IReserva iReserva;

    private void botaoReservar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoReservar
        try {

            Registry reg;

            IDaoCompleto iDaoCompleto = new DaoCompleto();

            reg = LocateRegistry.getRegistry("localhost", 7000);

            iDaoCompleto = (IDaoCompleto) reg.lookup("DaoCompleto");

            this.listaAluno = iDaoCompleto.loadAll();
            
           
            
            Reserva rv = new Reserva();

            for (Iterator<Livro> it = this.listaLivro.iterator(); it.hasNext();) {
                Livro ib = it.next();
                if (ib.getTitulo().equals(((String) jComboBox1.getSelectedItem()))) {
                    rv.setLivro(ib);
                    break;
                }
            }
            
      

            for (Iterator<Aluno> it = this.listaAluno.iterator(); it.hasNext();) {
                Aluno ib = it.next();
                if (ib.getNome().equals(((String) jComboBox2.getSelectedItem()))) {
                    rv.setAluno(ib);
                    break;
                }
            }



            rv.setDataFinal("");

            rv.setDataInicio(((String) jComboBox3.getSelectedItem()) + "/" + ""
                    + ((String) jComboBox4.getSelectedItem()) + "/" + "" + ((String) jComboBox5.getSelectedItem()));


         
            iDaoCompleto.createReserva(rv);

        } catch (ClassNotFoundException | SQLException | RemoteException | NotBoundException ex) {
            Logger.getLogger(ReservaView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JOptionPane.showMessageDialog(rootPane, "Livro reservado.");
        
        dispose();

    }//GEN-LAST:event_botaoReservar
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private void minhasConfiguracoes() throws ClassNotFoundException, SQLException, RemoteException, NotBoundException, MalformedURLException, NotFoundException {

        setLivros();
        setAlunos();
        setDataReserva();
    }

    private void setLivros() throws NotBoundException, MalformedURLException, RemoteException, SQLException, ClassNotFoundException, NotFoundException {

        Registry reg;

        IDaoCompleto iDaoCompleto = new DaoCompleto();

        reg = LocateRegistry.getRegistry("localhost", 7000);

        iDaoCompleto = (IDaoCompleto) reg.lookup("DaoCompleto");


        //  iLivro = (ILivro) Naming.lookup("rmi://localhost/LivroDao");

        this.listaLivro = iDaoCompleto.loadAllLivro();

//       this.lista = iLivro.loadAllLivro();

        java.lang.String nome[] = new java.lang.String[listaLivro.size()];

        int i = 0;

        for (Iterator<Livro> it = listaLivro.iterator(); it.hasNext();) {
            Livro ib = it.next();
            nome[i] = ib.getTitulo() + "";
            i++;
        }

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(nome));
    }

    private void setAlunos() throws NotBoundException, MalformedURLException, RemoteException, SQLException, ClassNotFoundException, NotFoundException {


        Registry reg;

        IDaoCompleto iDaoCompleto = new DaoCompleto();

        reg = LocateRegistry.getRegistry("localhost", 7000);

        iDaoCompleto = (IDaoCompleto) reg.lookup("DaoCompleto");



        //  iAluno = (IAluno) Naming.lookup("rmi://localhost/AlunoDao");

        //    this.lista = iAluno.loadAll();

        this.listaAluno = iDaoCompleto.loadAll();

        java.lang.String nome[] = new java.lang.String[listaAluno.size()];

        int i = 0;

        for (Iterator<Aluno> it = listaAluno.iterator(); it.hasNext();) {
            Aluno ib = it.next();
            nome[i] = "" + ib.getNome();
            i++;
        }

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(nome));
    }
    private IAluno iAluno;
    private ILivro iLivro;
    private List listaLivro;
    private List listaAluno;

    private void setDataReserva() {

        String dia[] = new String[32];
        String mes[] = new String[13];
        String ano[] = new String[1];

        for (int i = 1; i < 32; i++) {
            dia[i] = i + "";
        };

        for (int i = 1; i < 13; i++) {
            mes[i] = i + "";
        };

        ano[0] = 2013 + "";

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(dia));
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(mes));
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(ano));
    }
}
