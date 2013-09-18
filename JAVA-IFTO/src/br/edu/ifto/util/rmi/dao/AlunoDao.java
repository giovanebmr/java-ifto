/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifto.util.rmi.dao;

import java.sql.*;
import java.util.*;
import java.math.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import br.edu.ifto.util.rmi.beans.Aluno;


public class AlunoDao extends UnicastRemoteObject implements IAluno{
    
    
    private final Connection cx;

    public AlunoDao() throws ClassNotFoundException, SQLException, RemoteException {
        this.cx = getMyDBConnection();
    }
    
  
    @Override
        public Connection getMyDBConnection() throws ClassNotFoundException, SQLException, RemoteException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","base");
    }
    
    
 
    @Override
     public Aluno createValueObject() {
          return new Aluno();
    }


    @Override
    public Aluno getObject(int id) throws NotFoundException, SQLException , RemoteException{

          Aluno valueObject = createValueObject();
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
                   Aluno temp = createValueObject();

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

   
   

}
