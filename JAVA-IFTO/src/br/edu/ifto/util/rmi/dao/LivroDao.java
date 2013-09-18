/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifto.util.rmi.dao;


import java.sql.*;
import java.util.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import br.edu.ifto.util.rmi.beans.Livro;

public class LivroDao extends UnicastRemoteObject implements ILivro  {

    private final Connection cx;

    public LivroDao() throws ClassNotFoundException, SQLException, RemoteException {
        this.cx = getMyDBConnection();
    }

    @Override
    public Connection getMyDBConnection() throws ClassNotFoundException, SQLException, RemoteException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "base");
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
    
   

}