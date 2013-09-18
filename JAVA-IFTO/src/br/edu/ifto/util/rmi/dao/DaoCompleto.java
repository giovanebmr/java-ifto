/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifto.util.rmi.dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import br.edu.ifto.util.rmi.beans.Aluno;
import br.edu.ifto.util.rmi.beans.Emprestimo;
import br.edu.ifto.util.rmi.beans.Livro;
import br.edu.ifto.util.rmi.beans.Reserva;

public class DaoCompleto extends UnicastRemoteObject implements IDaoCompleto{
    
     private final Connection cx;

    public DaoCompleto() throws ClassNotFoundException, SQLException, RemoteException {
        this.cx = getMyDBConnection();
    }
    
  
    @Override
        public Connection getMyDBConnection() throws ClassNotFoundException, SQLException, RemoteException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","base");
    }
    
    
 
    @Override
     public Aluno createValueObjectAluno() throws  RemoteException{
          return new Aluno();
    }


    @Override
    public Aluno getObject(int id) throws NotFoundException, SQLException , RemoteException{

          Aluno valueObject = createValueObjectAluno();
          valueObject.setId(id);
          load(valueObject);
          return valueObject;
    }


    @Override
    public void load( Aluno valueObject) throws NotFoundException, SQLException , RemoteException{

          String sql = "SELECT * FROM aluno WHERE (id = ? ) "; 
          PreparedStatement stmt = null;

          try {
               stmt = cx.prepareStatement(sql);
               stmt.setInt(1, valueObject.getId()); 

               singleQuery(stmt, valueObject);

          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }


  
    @Override
    public List loadAll() throws SQLException , RemoteException{

          String sql = "SELECT * FROM aluno ORDER BY id ASC ";
          List searchResults = listQuery(cx.prepareStatement(sql));

          return searchResults;
    }


   
    @Override
    public synchronized void create( Aluno valueObject) throws SQLException , RemoteException{

          String sql = "";
          PreparedStatement stmt = null;
          ResultSet result = null;

          try {
               sql = "INSERT INTO aluno ( nome, matricula) VALUES ( ?, ?) ";
               stmt = cx.prepareStatement(sql);

               stmt.setString(1, valueObject.getNome()); 
               stmt.setInt(2, valueObject.getMatricula()); 

               int rowcount = databaseUpdate(stmt);
               if (rowcount != 1) {
                    //System.out.println("PrimaryKey Error when updating DB!");
                    throw new SQLException("PrimaryKey Error when updating DB!");
               }

          } finally {
              if (stmt != null)
                  stmt.close();
          }


    }


    @Override
    public void save( Aluno valueObject) 
          throws NotFoundException, SQLException , RemoteException{

          String sql = "UPDATE aluno SET nome = ?, matricula = ? WHERE (id = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = cx.prepareStatement(sql);
              stmt.setString(1, valueObject.getNome()); 
              stmt.setInt(2, valueObject.getMatricula()); 

              stmt.setInt(3, valueObject.getId()); 

              int rowcount = databaseUpdate(stmt);
              if (rowcount == 0) {
                   //System.out.println("Object could not be saved! (PrimaryKey not found)");
                   throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
              }
              if (rowcount > 1) {
                   //System.out.println("PrimaryKey Error when updating DB! (Many objects were affected!)");
                   throw new SQLException("PrimaryKey Error when updating DB! (Many objects were affected!)");
              }
          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }


    
    @Override
    public void delete( Aluno valueObject) 
          throws NotFoundException, SQLException , RemoteException{

          String sql = "DELETE FROM aluno WHERE (id = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = cx.prepareStatement(sql);
              stmt.setInt(1, valueObject.getId()); 

              int rowcount = databaseUpdate(stmt);
              if (rowcount == 0) {
                   //System.out.println("Object could not be deleted (PrimaryKey not found)");
                   throw new NotFoundException("Object could not be deleted! (PrimaryKey not found)");
              }
              if (rowcount > 1) {
                   //System.out.println("PrimaryKey Error when updating DB! (Many objects were deleted!)");
                   throw new SQLException("PrimaryKey Error when updating DB! (Many objects were deleted!)");
              }
          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }


    @Override
    public void deleteAll() throws SQLException , RemoteException{

          String sql = "DELETE FROM aluno";
          PreparedStatement stmt = null;

          try {
              stmt = cx.prepareStatement(sql);
              int rowcount = databaseUpdate( stmt);
          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }


    @Override
    public int countAll() throws SQLException , RemoteException{

          String sql = "SELECT count(*) FROM aluno";
          PreparedStatement stmt = null;
          ResultSet result = null;
          int allRows = 0;

          try {
              stmt = cx.prepareStatement(sql);
              result = stmt.executeQuery();

              if (result.next())
                  allRows = result.getInt(1);
          } finally {
              if (result != null)
                  result.close();
              if (stmt != null)
                  stmt.close();
          }
          return allRows;
    }

    
    @Override
    public List searchMatching( Aluno valueObject) throws SQLException, ClassNotFoundException, RemoteException {

          List searchResults;

          boolean first = true;
          StringBuffer sql = new StringBuffer("SELECT * FROM aluno WHERE 1=1 ");

          if (valueObject.getId() != 0) {
              if (first) { first = false; }
              sql.append("AND id = ").append(valueObject.getId()).append(" ");
          }

          if (valueObject.getNome() != null) {
              if (first) { first = false; }
              sql.append("AND nome LIKE '").append(valueObject.getNome()).append("%' ");
          }

          if (valueObject.getMatricula() != 0) {
              if (first) { first = false; }
              sql.append("AND matricula = ").append(valueObject.getMatricula()).append(" ");
          }


          sql.append("ORDER BY id ASC ");

          // Prevent accidential full table results.
          // Use loadAll if all rows must be returned.
          if (first)
               searchResults = new ArrayList();
          else
               searchResults = listQuery(cx.prepareStatement(sql.toString()));

          return searchResults;
    }


  

    @Override
    public int databaseUpdate( PreparedStatement stmt) throws SQLException, RemoteException {

          int result = stmt.executeUpdate();

          return result;
    }



  
    @Override
    public void singleQuery( PreparedStatement stmt, Aluno valueObject) 
          throws NotFoundException, SQLException, RemoteException {

          ResultSet result = null;

          try {
              result = stmt.executeQuery();

              if (result.next()) {

                   valueObject.setId(result.getInt("id")); 
                   valueObject.setNome(result.getString("nome")); 
                   valueObject.setMatricula(result.getInt("matricula")); 

              } else {
                    //System.out.println("Aluno Object Not Found!");
                    throw new NotFoundException("Aluno Object Not Found!");
              }
          } finally {
              if (result != null)
                  result.close();
              if (stmt != null)
                  stmt.close();
          }
    }


    @Override
    public List listQuery( PreparedStatement stmt) throws SQLException , RemoteException{

          ArrayList searchResults = new ArrayList();
          ResultSet result = null;

          try {
              result = stmt.executeQuery();

              while (result.next()) {
                   Aluno temp = createValueObjectAluno();

                   temp.setId(result.getInt("id")); 
                   temp.setNome(result.getString("nome")); 
                   temp.setMatricula(result.getInt("matricula")); 

                   searchResults.add(temp);
              }

          } finally {
              if (result != null)
                  result.close();
              if (stmt != null)
                  stmt.close();
          }

          return (List)searchResults;
    }

 
    
    
     @Override
    public Livro createValueObjectLivro() throws  RemoteException{
        return new Livro();
    }

    @Override
    public Livro getObjectLivro( int id) throws NotFoundException, SQLException, ClassNotFoundException, RemoteException {

        Livro valueObject = createValueObjectLivro();
        valueObject.setId(id);
        loadLivro( valueObject);
        return valueObject;
    }

   
    @Override
    public void loadLivro( Livro valueObject) throws NotFoundException, SQLException, ClassNotFoundException, RemoteException {

        String sql = "SELECT * FROM livro WHERE (id = ? ) ";
        PreparedStatement stmt = null;

        try {
            stmt = cx.prepareStatement(sql);
            stmt.setInt(1, valueObject.getId());

            singleQueryLivro(stmt, valueObject);

        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    @Override
    public List loadAllLivro() throws SQLException, ClassNotFoundException, RemoteException, NotFoundException {

        String sql = "SELECT * FROM livro ORDER BY id ASC ";
        List searchResults = listQueryLivro( cx.prepareStatement(sql));

        return searchResults;
    }

    @Override
    public synchronized void createLivro( Livro valueObject) throws SQLException ,RemoteException{

        String sql = "";
        PreparedStatement stmt = null;
        ResultSet result = null;

        try {
            sql = "INSERT INTO livro ( titulo, autor, "
                    + "areadeconhecimento) VALUES ( ?, ?, ?) ";
            stmt = cx.prepareStatement(sql);

            stmt.setString(1, valueObject.getTitulo());
            stmt.setString(2, valueObject.getAutor());
            stmt.setString(3, valueObject.getAreaDeConhecimento());


            int rowcount = databaseUpdateLivro(stmt);
            if (rowcount != 1) {
                //System.out.println("PrimaryKey Error when updating DB!");
                throw new SQLException("PrimaryKey Error when updating DB!");
            }

        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }


    }

    @Override
    public void saveLivro(Livro valueObject)
            throws NotFoundException, SQLException ,RemoteException{

        String sql = "UPDATE livro SET titulo = ?, autor = ?, areadeconhecimento = ? WHERE (id = ? ) ";
        PreparedStatement stmt = null;

        try {
            stmt = cx.prepareStatement(sql);
            stmt.setString(1, valueObject.getTitulo());
            stmt.setString(2, valueObject.getAutor());
            stmt.setString(3, valueObject.getAreaDeConhecimento());


            stmt.setInt(6, valueObject.getId());

            int rowcount = databaseUpdateLivro( stmt);
            if (rowcount == 0) {
                //System.out.println("Object could not be saved! (PrimaryKey not found)");
                throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
            }
            if (rowcount > 1) {
                //System.out.println("PrimaryKey Error when updating DB! (Many objects were affected!)");
                throw new SQLException("PrimaryKey Error when updating DB! (Many objects were affected!)");
            }
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }


    @Override
    public void deleteLivro( Livro valueObject)
            throws NotFoundException, SQLException ,RemoteException{

        String sql = "DELETE FROM livro WHERE (id = ? ) ";
        PreparedStatement stmt = null;

        try {
            stmt = cx.prepareStatement(sql);
            stmt.setInt(1, valueObject.getId());

            int rowcount = databaseUpdateLivro( stmt);
            if (rowcount == 0) {
                //System.out.println("Object could not be deleted (PrimaryKey not found)");
                throw new NotFoundException("Object could not be deleted! (PrimaryKey not found)");
            }
            if (rowcount > 1) {
                //System.out.println("PrimaryKey Error when updating DB! (Many objects were deleted!)");
                throw new SQLException("PrimaryKey Error when updating DB! (Many objects were deleted!)");
            }
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    @Override
    public void deleteAllLivro() throws SQLException,RemoteException {

        String sql = "DELETE FROM livro";
        PreparedStatement stmt = null;

        try {
            stmt = cx.prepareStatement(sql);
            int rowcount = databaseUpdateLivro( stmt);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

 
    @Override
    public int countAllLivro() throws SQLException,RemoteException {

        String sql = "SELECT count(*) FROM livro";
        PreparedStatement stmt = null;
        ResultSet result = null;
        int allRows = 0;

        try {
            stmt = cx.prepareStatement(sql);
            result = stmt.executeQuery();

            if (result.next()) {
                allRows = result.getInt(1);
            }
        } finally {
            if (result != null) {
                result.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
        return allRows;
    }

    @Override
    public List searchMatchingLivro( Livro valueObject) throws SQLException, ClassNotFoundException, RemoteException, NotFoundException {

        List searchResults;

        boolean first = true;
        StringBuffer sql = new StringBuffer("SELECT * FROM livro WHERE 1=1 ");

        if (valueObject.getId() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND id = ").append(valueObject.getId()).append(" ");
        }

        if (valueObject.getTitulo() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND titulo LIKE '").append(valueObject.getTitulo()).append("%' ");
        }

        if (valueObject.getAutor() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND autor LIKE '").append(valueObject.getAutor()).append("%' ");
        }

        if (valueObject.getAreaDeConhecimento() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND areadeconhecimento LIKE '").append(valueObject.getAreaDeConhecimento()).append("%' ");
        }



        sql.append("ORDER BY id ASC ");

        // Prevent accidential full table results.
        // Use loadAllLivro if all rows must be returned.
        if (first) {
            searchResults = new ArrayList();
        } else {
            searchResults = listQueryLivro( cx.prepareStatement(sql.toString()));
        }

        return searchResults;
    }

   

    protected int databaseUpdateLivro( PreparedStatement stmt) throws SQLException,RemoteException {

        int result = stmt.executeUpdate();

        return result;
    }

   
    protected void singleQueryLivro( PreparedStatement stmt, Livro valueObject)
            throws NotFoundException, SQLException, ClassNotFoundException, RemoteException {

        ResultSet result = null;

        try {
            result = stmt.executeQuery();

            if (result.next()) {

                valueObject.setId(result.getInt("id"));
                valueObject.setTitulo(result.getString("titulo"));
                valueObject.setAutor(result.getString("autor"));
                valueObject.setAreaDeConhecimento(result.getString("areadeconhecimento"));


            } else {
                //System.out.println("Livro Object Not Found!");
                throw new NotFoundException("Livro Object Not Found!");
            }
        } finally {
            if (result != null) {
                result.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
    }

   
    protected List listQueryLivro(PreparedStatement stmt) throws SQLException, ClassNotFoundException, RemoteException, NotFoundException {

        ArrayList searchResults = new ArrayList();
        ResultSet result = null;

        try {
            result = stmt.executeQuery();

            while (result.next()) {
                Livro temp = createValueObjectLivro();

                temp.setId(result.getInt("id"));
                temp.setTitulo(result.getString("titulo"));
                temp.setAutor(result.getString("autor"));
                temp.setAreaDeConhecimento(result.getString("areadeconhecimento"));


                searchResults.add(temp);
            }

        } finally {
            if (result != null) {
                result.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }

        return (List) searchResults;
    }
    
    @Override
    public Reserva createValueObjectReserva() throws RemoteException{
          return new Reserva();
    }


    @Override
    public Reserva getObjectReserva( int id) throws NotFoundException, SQLException, ClassNotFoundException, RemoteException {

          Reserva valueObject = createValueObjectReserva();
          valueObject.setId(id);
          loadReserva( valueObject);
          return valueObject;
    }


    
    @Override
    public void loadReserva( Reserva valueObject) throws NotFoundException, SQLException, ClassNotFoundException, RemoteException {

          String sql = "SELECT * FROM reserva WHERE (id = ? ) "; 
          PreparedStatement stmt = null;

          try {
               stmt = cx.prepareStatement(sql);
               stmt.setInt(1, valueObject.getId()); 

               singleQueryReserva( stmt, valueObject);

          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }


    @Override
    public List loadAllReserva() throws SQLException, ClassNotFoundException, RemoteException, NotFoundException {

          String sql = "SELECT * FROM reserva ORDER BY id ASC ";
          List searchResults = listQueryReserva(cx.prepareStatement(sql));

          return searchResults;
    }



   
    @Override
    public synchronized void createReserva( Reserva valueObject) throws SQLException, RemoteException {

          String sql = "";
          PreparedStatement stmt = null;
          ResultSet result = null;

          try {
               sql = "INSERT INTO reserva ( livro, datainicio, "
               + "datafinal, aluno) VALUES ( ?, ?, ?, ?) ";
               stmt = cx.prepareStatement(sql);

               stmt.setInt(1, valueObject.getLivro().getId()); 
               stmt.setString(2, valueObject.getDataInicio()); 
               stmt.setString(3, valueObject.getDataFinal()); 
               stmt.setInt(4, valueObject.getAluno().getMatricula()); 

               int rowcount = databaseUpdateReserva( stmt);
               if (rowcount != 1) {
                    //System.out.println("PrimaryKey Error when updating DB!");
                    throw new SQLException("PrimaryKey Error when updating DB!");
               }

          } finally {
              if (stmt != null)
                  stmt.close();
          }


    }


   
    @Override
    public void saveReserva( Reserva valueObject) 
          throws NotFoundException, SQLException , RemoteException{

          String sql = "UPDATE reserva SET livro = ?, datainicio = ?, datafinal = ?, "
               + "aluno = ? WHERE (id = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = cx.prepareStatement(sql);
              stmt.setInt(1, valueObject.getLivro().getId()); 
              stmt.setString(2, valueObject.getDataInicio()); 
              stmt.setString(3, valueObject.getDataFinal()); 
              stmt.setInt(4, valueObject.getAluno().getId()); 

              stmt.setInt(5, valueObject.getId()); 

              int rowcount = databaseUpdateReserva( stmt);
              if (rowcount == 0) {
                   //System.out.println("Object could not be saved! (PrimaryKey not found)");
                   throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
              }
              if (rowcount > 1) {
                   //System.out.println("PrimaryKey Error when updating DB! (Many objects were affected!)");
                   throw new SQLException("PrimaryKey Error when updating DB! (Many objects were affected!)");
              }
          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }


   
    @Override
    public void deleteReserva( Reserva valueObject) 
          throws NotFoundException, SQLException , RemoteException{

          String sql = "DELETE FROM reserva WHERE (id = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = cx.prepareStatement(sql);
              stmt.setInt(1, valueObject.getId()); 

              int rowcount = databaseUpdateReserva( stmt);
              if (rowcount == 0) {
                   //System.out.println("Object could not be deleted (PrimaryKey not found)");
                   throw new NotFoundException("Object could not be deleted! (PrimaryKey not found)");
              }
              if (rowcount > 1) {
                   //System.out.println("PrimaryKey Error when updating DB! (Many objects were deleted!)");
                   throw new SQLException("PrimaryKey Error when updating DB! (Many objects were deleted!)");
              }
          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }


    
    @Override
    public void deleteAllReserva() throws SQLException , RemoteException{

          String sql = "DELETE FROM reserva";
          PreparedStatement stmt = null;

          try {
              stmt = cx.prepareStatement(sql);
              int rowcount = databaseUpdateReserva( stmt);
          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }


   
    @Override
    public int countAllReserva() throws SQLException , RemoteException{

          String sql = "SELECT count(*) FROM reserva";
          PreparedStatement stmt = null;
          ResultSet result = null;
          int allRows = 0;

          try {
              stmt = cx.prepareStatement(sql);
              result = stmt.executeQuery();

              if (result.next())
                  allRows = result.getInt(1);
          } finally {
              if (result != null)
                  result.close();
              if (stmt != null)
                  stmt.close();
          }
          return allRows;
    }


   
    @Override
    public List searchMatchingReserva( Reserva valueObject) throws SQLException, ClassNotFoundException, RemoteException, NotFoundException {

          List searchResults;

          boolean first = true;
          StringBuffer sql = new StringBuffer("SELECT * FROM reserva WHERE 1=1 ");


          if (valueObject.getAluno().getMatricula() != 0) {
              if (first) { first = false; }
              sql.append("AND aluno = ").append(valueObject.getAluno().getMatricula()).append(" ");
          }


          sql.append("ORDER BY id ASC ");

          // Prevent accidential full table results.
          // Use loadAllLivro if all rows must be returned.
          if (first)
               searchResults = new ArrayList();
          else
               searchResults = listQueryReserva( cx.prepareStatement(sql.toString()));

          return searchResults;
    }


   


    @Override
    public int databaseUpdateReserva( PreparedStatement stmt) throws SQLException, RemoteException {

          int result = stmt.executeUpdate();

          return result;
    }



    @Override
    public void singleQueryReserva(PreparedStatement stmt, Reserva valueObject) 
          throws NotFoundException, SQLException, ClassNotFoundException, RemoteException {

          ResultSet result = null;

          try {
              result = stmt.executeQuery();

              if (result.next()) {

                   valueObject.setId(result.getInt("id")); 
                   valueObject.setLivro(getLivroDAOReserva(result.getInt("livro"))); 
                   valueObject.setDataInicio(result.getString("datainicio")); 
                   valueObject.setDataFinal(result.getString("datafinal")); 
                   valueObject.setAluno(getAlunoDAOReserva(result.getInt("aluno"))); 

              } else {
                    //System.out.println("Reserva Object Not Found!");
                    throw new NotFoundException("Reserva Object Not Found!");
              }
          } finally {
              if (result != null)
                  result.close();
              if (stmt != null)
                  stmt.close();
          }
    }


    @Override
    public List listQueryReserva( PreparedStatement stmt) throws SQLException, ClassNotFoundException, RemoteException, NotFoundException {

          ArrayList searchResults = new ArrayList();
          ResultSet result = null;

          System.out.println("\n\n\n\n\n\n--------------------" + stmt.toString());
          
          try {
              result = stmt.executeQuery();

              while (result.next()) {
                   Reserva temp = createValueObjectReserva();

                   temp.setId(result.getInt("id")); 
                   temp.setLivro(getLivroDAOReserva(result.getInt("livro"))); 
                   temp.setDataInicio(result.getString("datainicio")); 
                   temp.setDataFinal(result.getString("datafinal")); 
//                   temp.setAluno(getAlunoDAOReserva(result.getInt("aluno"))); 

                   searchResults.add(temp);
              }

          } finally {
              if (result != null)
                  result.close();
              if (stmt != null)
                  stmt.close();
          }

          return (List)searchResults;
    }

/**
     * Utiliza LivroDAO para retornar Livro     
     */
    @Override
    public Livro getLivroDAOReserva(int id) throws ClassNotFoundException, RemoteException, NotFoundException, SQLException{
        return (new LivroDao()).getObjectLivro(id);
    }
    
    /**
     * Utiliza AlunoDAO para retornar Aluno     
     */
    @Override
    public Aluno getAlunoDAOReserva(int id) throws ClassNotFoundException, RemoteException, NotFoundException, SQLException{
        return (new AlunoDao()).getObject(id);
    } 
    
    
    @Override
      public Emprestimo createValueObjectEmprestimo() {
          return new Emprestimo();
    }


    @Override
    public Emprestimo getObjectEmprestimo( int id) throws NotFoundException, SQLException, ClassNotFoundException, RemoteException {

          Emprestimo valueObject = createValueObjectEmprestimo();
          valueObject.setId(id);
          loadEmprestimo( valueObject);
          return valueObject;
    }


    @Override
    public void loadEmprestimo( Emprestimo valueObject) throws NotFoundException, SQLException, ClassNotFoundException, RemoteException {

          String sql = "SELECT * FROM emprestimo WHERE (id = ? ) "; 
          PreparedStatement stmt = null;

          try {
               stmt = cx.prepareStatement(sql);
               stmt.setInt(1, valueObject.getId()); 

               singleQueryEmprestimo( stmt, valueObject);

          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }


    @Override
    public List loadAllEmprestimo() throws SQLException, ClassNotFoundException, RemoteException, NotFoundException {

          String sql = "SELECT * FROM emprestimo ORDER BY id ASC ";
          List searchResults = listQueryEmprestimo(cx.prepareStatement(sql));

          return searchResults;
    }



    @Override
    public synchronized void createEmprestimo(Emprestimo valueObject) throws SQLException {

          String sql = "";
          PreparedStatement stmt = null;
          ResultSet result = null;

          try {
               sql = "INSERT INTO emprestimo ( livro, aluno, "
               + "datainicio, dtafinal) VALUES (?, ?, ?, ?) ";
               stmt = cx.prepareStatement(sql);
               
               stmt.setInt(1, valueObject.getLivro().getId()); 
               stmt.setInt(2, valueObject.getAluno().getId()); 
               stmt.setString(3, valueObject.getDataInicio()); 
               stmt.setString(4, valueObject.getDataFinal()); 

               int rowcount = databaseUpdateEmprestimo(stmt);
               if (rowcount != 1) {
                    //System.out.println("PrimaryKey Error when updating DB!");
                    throw new SQLException("PrimaryKey Error when updating DB!");
               }

          } finally {
              if (stmt != null)
                  stmt.close();
          }


    }


    @Override
    public void saveEmprestimo( Emprestimo valueObject) 
          throws NotFoundException, SQLException {

          String sql = "UPDATE emprestimo SET livro = ?, aluno = ?, datainicio = ?, "
               + "dtafinal = ? WHERE (id = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = cx.prepareStatement(sql);
              stmt.setInt(1, valueObject.getLivro().getId()); 
              stmt.setInt(2, valueObject.getAluno().getId()); 
              stmt.setString(3, valueObject.getDataInicio()); 
              stmt.setString(4, valueObject.getDataFinal()); 

              stmt.setInt(5, valueObject.getId()); 

              int rowcount = databaseUpdateEmprestimo( stmt);
              if (rowcount == 0) {
                   //System.out.println("Object could not be saved! (PrimaryKey not found)");
                   throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
              }
              if (rowcount > 1) {
                   //System.out.println("PrimaryKey Error when updating DB! (Many objects were affected!)");
                   throw new SQLException("PrimaryKey Error when updating DB! (Many objects were affected!)");
              }
          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }


    
    @Override
    public void deleteEmprestimo( Emprestimo valueObject) 
          throws NotFoundException, SQLException {

          String sql = "DELETE FROM emprestimo WHERE (id = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = cx.prepareStatement(sql);
              stmt.setInt(1, valueObject.getId()); 

              int rowcount = databaseUpdateEmprestimo( stmt);
              if (rowcount == 0) {
                   //System.out.println("Object could not be deleted (PrimaryKey not found)");
                   throw new NotFoundException("Object could not be deleted! (PrimaryKey not found)");
              }
              if (rowcount > 1) {
                   //System.out.println("PrimaryKey Error when updating DB! (Many objects were deleted!)");
                   throw new SQLException("PrimaryKey Error when updating DB! (Many objects were deleted!)");
              }
          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }


    
    @Override
    public void deleteAllEmprestimo() throws SQLException {

          String sql = "DELETE FROM emprestimo";
          PreparedStatement stmt = null;

          try {
              stmt = cx.prepareStatement(sql);
              int rowcount = databaseUpdateEmprestimo( stmt);
          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }


   
    @Override
    public int countAllEmprestimo() throws SQLException {

          String sql = "SELECT count(*) FROM emprestimo";
          PreparedStatement stmt = null;
          ResultSet result = null;
          int allRows = 0;

          try {
              stmt = cx.prepareStatement(sql);
              result = stmt.executeQuery();

              if (result.next())
                  allRows = result.getInt(1);
          } finally {
              if (result != null)
                  result.close();
              if (stmt != null)
                  stmt.close();
          }
          return allRows;
    }


    
    @Override
    public List searchMatchingEmprestimo( Emprestimo valueObject) throws SQLException, ClassNotFoundException, RemoteException, NotFoundException {

          List searchResults;

          boolean first = true;
          StringBuffer sql = new StringBuffer("SELECT * FROM emprestimo WHERE 1=1 ");

          if (valueObject.getId() != 0) {
              if (first) { first = false; }
              sql.append("AND id = ").append(valueObject.getId()).append(" ");
          }

          if (valueObject.getLivro().getId() != 0) {
              if (first) { first = false; }
              sql.append("AND livro = ").append(valueObject.getLivro()).append(" ");
          }

          if (valueObject.getAluno().getId() != 0) {
              if (first) { first = false; }
              sql.append("AND aluno = ").append(valueObject.getAluno().getMatricula()).append(" ");
          }

          if (valueObject.getDataInicio()!= null) {
              if (first) { first = false; }
              sql.append("AND datainicio LIKE '").append(valueObject.getDataInicio()).append("%' ");
          }

          if (valueObject.getDataFinal() != null) {
              if (first) { first = false; }
              sql.append("AND dtafinal LIKE '").append(valueObject.getDataFinal()).append("%' ");
          }


          sql.append("ORDER BY id ASC ");

          // Prevent accidential full table results.
          // Use loadAllLivro if all rows must be returned.
          if (first)
               searchResults = new ArrayList();
          else
               searchResults = listQueryEmprestimo( cx.prepareStatement(sql.toString()));

          return searchResults;
    }



    
    protected int databaseUpdateEmprestimo( PreparedStatement stmt) throws SQLException {

          int result = stmt.executeUpdate();

          return result;
    }



    
    protected void singleQueryEmprestimo(PreparedStatement stmt, Emprestimo valueObject) 
          throws NotFoundException, SQLException, ClassNotFoundException, RemoteException {

          ResultSet result = null;

          try {
              result = stmt.executeQuery();

              if (result.next()) {

                   valueObject.setId(result.getInt("id")); 
                   valueObject.setLivro(getLivroDAO(result.getInt("livro"))); 
                   valueObject.setAluno(getAlunoDAO(result.getInt("aluno"))); 
                   valueObject.setDataInicio(result.getString("datainicio")); 
                   valueObject.setDataFinal(result.getString("dtafinal")); 

              } else {
                    //System.out.println("Emprestimo Object Not Found!");
                    throw new NotFoundException("Não há objeto emprestimo no banco relacionado com o objeto livro!");
              }
          } finally {
              if (result != null)
                  result.close();
              if (stmt != null)
                  stmt.close();
          }
    }


    protected List listQueryEmprestimo( PreparedStatement stmt) throws SQLException, ClassNotFoundException, RemoteException, NotFoundException {

          ArrayList searchResults = new ArrayList();
          ResultSet result = null;

          try {
              result = stmt.executeQuery();
              
              System.out.println("\n\n\n\n\n\n--------------------" + stmt.toString());
              
              while (result.next()) {
                   Emprestimo temp = createValueObjectEmprestimo();

                   temp.setId(result.getInt("id")); 
                   temp.setLivro(getLivroDAO(result.getInt("livro"))); 
//                   temp.setAluno(getAlunoDAO(result.getInt("aluno"))); 
                   temp.setDataInicio(result.getString("datainicio")); 
                   temp.setDataFinal(result.getString("datafinal")); 

                   searchResults.add(temp);
              }

          } finally {
              if (result != null)
                  result.close();
              if (stmt != null)
                  stmt.close();
          }

          return (List)searchResults;
    }
    
    /**
     * Utiliza AlunoDAO      para retornar Aluno
     */
    @Override
    public Aluno getAlunoDAO(int id) throws ClassNotFoundException, RemoteException, NotFoundException, SQLException{
        return (new AlunoDao()).getObject(id);
    }
    
    /**
     * Utiliza LivroDAO     para retornar Livro
     */
    
    @Override
    public Livro getLivroDAO(int id) throws ClassNotFoundException, RemoteException, SQLException, NotFoundException{
        return (new LivroDao()).getObjectLivro(id);
    }

    
}
