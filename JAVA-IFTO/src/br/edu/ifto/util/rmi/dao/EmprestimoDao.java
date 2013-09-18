/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifto.util.rmi.dao;



import br.edu.ifto.util.rmi.beans.Emprestimo;

 


import java.sql.*;
import java.util.*;
import java.math.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import br.edu.ifto.util.rmi.beans.Aluno;
import br.edu.ifto.util.rmi.beans.Livro;


 


public class EmprestimoDao extends UnicastRemoteObject{

private final Connection cx;

    public EmprestimoDao() throws ClassNotFoundException, SQLException, RemoteException {
        this.cx = getMyDBConnection();
    }
    
    
        public Connection getMyDBConnection() throws ClassNotFoundException, SQLException, RemoteException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","base");
    }

   
   
    public Emprestimo createValueObjectEmprestimo() {
          return new Emprestimo();
    }


    public Emprestimo getObjectEmprestimo( int id) throws NotFoundException, SQLException, ClassNotFoundException, RemoteException {

          Emprestimo valueObject = createValueObjectEmprestimo();
          valueObject.setId(id);
          loadEmprestimo( valueObject);
          return valueObject;
    }


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


    public List loadAllEmprestimo() throws SQLException, ClassNotFoundException, RemoteException, NotFoundException {

          String sql = "SELECT * FROM emprestimo ORDER BY id ASC ";
          List searchResults = listQueryEmprestimo(cx.prepareStatement(sql));

          return searchResults;
    }



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
              sql.append("AND aluno = ").append(valueObject.getAluno()).append(" ");
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

              while (result.next()) {
                   Emprestimo temp = createValueObjectEmprestimo();

                   temp.setId(result.getInt("id")); 
                   temp.setLivro(getLivroDAO(result.getInt("livro"))); 
                   temp.setAluno(getAlunoDAO(result.getInt("aluno"))); 
                   temp.setDataInicio(result.getString("datainicio")); 
                   temp.setDataFinal(result.getString("dtafinal")); 

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
    public Aluno getAlunoDAO(int id) throws ClassNotFoundException, RemoteException, NotFoundException, SQLException{
        return (new AlunoDao()).getObject(id);
    }
    
    /**
     * Utiliza LivroDAO     para retornar Livro
     */
    
    public Livro getLivroDAO(int id) throws ClassNotFoundException, RemoteException, SQLException, NotFoundException{
        return (new LivroDao()).getObjectLivro(id);
    }


}