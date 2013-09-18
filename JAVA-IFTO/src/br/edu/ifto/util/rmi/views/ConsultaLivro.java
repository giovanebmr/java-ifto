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

import br.edu.ifto.util.rmi.beans.Livro;
import br.edu.ifto.util.rmi.dao.DaoCompleto;
import br.edu.ifto.util.rmi.dao.IDaoCompleto;
import br.edu.ifto.util.rmi.dao.ILivro;
import br.edu.ifto.util.rmi.dao.NotFoundException;

/**
 *
 * @author Giovane
 */
public class ConsultaLivro extends javax.swing.JFrame {

    public ConsultaLivro() throws ClassNotFoundException, SQLException, RemoteException, NotBoundException, MalformedURLException, NotFoundException {
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        minhasConfiguracoes();
    }
    private ILivro iLivro;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        titulo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jRadioButton2 = new javax.swing.JRadioButton();
        autor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        conhecimento = new javax.swing.JTextField();
        jRadioButton3 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consultar Livro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP));

        jButton1.setText("Consultar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConsultar(evt);
            }
        });

        jLabel1.setText("Por título");

        jLabel2.setText("Por autor");

        jLabel3.setText("Por área de conhecimento");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(conhecimento, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(autor, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
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
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton1)
                            .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(jLabel2)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton2)
                            .addComponent(autor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton3)
                            .addComponent(conhecimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
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
            Livro livro = new Livro();

            List<Livro> livros = new LinkedList<Livro>();


            if (this.jRadioButton1.isSelected()) {
                if (titulo.getText().equals("")) {
                    this.jRadioButton1.setSelected(false);
                } else {
                    livro.setTitulo(titulo.getText());
                }
            }
            if (this.jRadioButton2.isSelected()) {
                if (autor.getText().equals("")) {
                    this.jRadioButton2.setSelected(false);
                } else {
                    livro.setAutor(autor.getText());
                }
            }
            if (this.jRadioButton3.isSelected()) {
                if (conhecimento.getText().equals("")) {
                    this.jRadioButton3.setSelected(false);
                } else {
                    livro.setAreaDeConhecimento(conhecimento.getText());
                }
            }

      

                Registry reg;
                
                IDaoCompleto iDaoCompleto = new DaoCompleto();

                reg = LocateRegistry.getRegistry("localhost", 7000);

                iDaoCompleto = (IDaoCompleto) reg.lookup("DaoCompleto");


                //iLivro = (ILivro) Naming.lookup("rmi://localhost/LivroDao");

                //livros = (List<Livro>) iLivro.searchMatchingLivro(livro);
                
                   livros = (List<Livro>) iDaoCompleto.searchMatchingLivro(livro);

                //   JOptionPane.showMessageDialog(rootPane, livros.toString());

                preencheTabela(livros);
        } catch (ClassNotFoundException | SQLException | RemoteException | NotBoundException | NotFoundException ex) {
            Logger.getLogger(ConsultaLivro.class.getName()).log(Level.SEVERE, null, ex);
        }




    }//GEN-LAST:event_botaoConsultar
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField autor;
    private javax.swing.JTextField conhecimento;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField titulo;
    // End of variables declaration//GEN-END:variables

    private void minhasConfiguracoes() throws ClassNotFoundException, SQLException, RemoteException, NotBoundException, MalformedURLException, NotFoundException {

        jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object[25][4], new String[]{"Código", "Título", "Autor", "Área de Conhecimento"}));
    }

    private void preencheTabela(List<Livro> livros) {

        jTable1.removeAll();

        String array[][] = new String[livros.size()][4];

        int i = 0;

        for (Iterator<Livro> it = livros.iterator(); it.hasNext();) {
            Livro livro = it.next();
            array[i][0] = livro.getId() + "";
            array[i][1] = livro.getTitulo() + "";
            array[i][2] = livro.getAutor() + "";
            array[i][3] = livro.getAreaDeConhecimento() + "";
            i++;
        }

        jTable1.setModel(new javax.swing.table.DefaultTableModel(array, new String[]{"Código", "Título", "Autor", "Área de Conhecimento"}));

        jTable1.updateUI();
    }
}
