/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movie.database;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author II
 */
public class Model {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/film";
    static final String USER = "root"; 
    static final String PASS = "";    
    
    Conn conn;
    Statement statement;
    
    public Model() {
      try{
          Class.forName(JDBC_DRIVER);
          conn = (Conn) (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
          System.out.println("Koneksi Berhasil");
      }catch(ClassNotFoundException | SQLException ex){
          JOptionPane.showMessageDialog(null, ex.getMessage());
          System.out.println("Koneksi gagal");
      }
  }
    
    public void insertFilm(String judul, String tipe, String ep, String genre, String status, String rating){
        try{
           String query = "INSERT INTO `movie` (`judul`, `tipe`, `ep`,`genre`,`status`,`rating`) "
                   + "VALUES ('"+judul+"','"+tipe+"','"+ep+"','"+genre+"','"+status+"','"+rating+"')";
          statement = (Statement) Conn.createStatement();
          statement.executeUpdate(query);
          System.out.println("Berhasil Ditambahkan");
          JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
        }
        catch(SQLException | HeadlessException sql){
          System.out.println(sql.getMessage());
          JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public String[][] readFilm(){
        try{
          int jmlData = 0;
          String data[][] = new String[getBanyakData()][8];
          String query = "SELECT * from `movie`";
          ResultSet resultSet = statement.executeQuery(query);
          while(resultSet.next()){
              data[jmlData][0] = resultSet.getString("#");
              data[jmlData][1] = resultSet.getString("id");
              data[jmlData][2] = resultSet.getString("judul");
              data[jmlData][3] = resultSet.getString("tipe");
              data[jmlData][4] = resultSet.getString("ep");
              data[jmlData][5] = resultSet.getString("genre");
              data[jmlData][6] = resultSet.getString("status");
              data[jmlData][7] = resultSet.getString("rating");
              jmlData++;
          }
          return data;
          
      }catch(SQLException e){
          System.out.println(e.getMessage());
          System.out.println("SQL ERROR");
          return null;
      }
    }
    
    public int getBanyakData(){
      int jmlData = 0;
      try{
          statement = Conn.createStatement();
          String query = "Select * from `movie`";
          ResultSet resultSet = statement.executeQuery(query);
          while(resultSet.next()){  
              jmlData++;
          }
          return jmlData;
        }
      catch(SQLException e){
          System.out.println(e.getMessage());
          System.out.println("SQL ERROR");
          return 0;
       }
    } 
      
    public void deleteFilm (String judul){
      try{
          String query = "DELETE FROM `movie` WHERE `judul` = '"+judul+"'";
          statement = Conn.createStatement();
          statement.executeUpdate(query);
          JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
      }catch(SQLException sql){
          System.out.println(sql.getMessage());
      }
    }
    
     void searchFilm(String search) {
         try{
          String sql = "SELECT * FROM `movie` WHERE `judul` LIKE '"+search+"%'";
          statement = Conn.createStatement();
          statement.executeQuery(sql);
          JOptionPane.showMessageDialog(null, "Berhasil DiCari");
      }catch(SQLException sql){
          System.out.println(sql.getMessage());
      }
    }
     
    void updateFilm(String judul, String tipe, String ep, String genre, String status, String rating){
        try{
            String sql = "UPDATE `movie` SET judul = '"+judul+"',tipe = '"+tipe+"', ep = '"+ep+"', "
                    + "genre = '"+genre+"', status = '"+status+"', rating = '"+rating+"'";
            java.sql.PreparedStatement pst;
            pst = Conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "berhasil disimpan");
        }catch(SQLException | HeadlessException e){
             JOptionPane.showMessageDialog(null, e);
        }    
    }
}
