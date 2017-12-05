/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author kirtisorendorff 
 */
public class MySQLConnect {
    
    public MySQLConnect(){
        
    }
    
    public void showTable(int table) throws Exception{
        
        System.out.println("Connecting to MySQL Server...");
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        
        Connection conn = null;
        try{
            //updated to call database for this project
            conn = DriverManager.getConnection("jdbc:mysql://52.14.177.55:3306/final_project", "user", "pass");
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        
        Statement stmt = null;
        String statement = "SELECT * FROM users;";      //!!!!change from "users" to the table being used, either inventory or sales
        
        //transfer result set to an instance of either SoldCar or InventoryCar
        //I need the list instance from Roland's stuff
            try {
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(statement);
                while (rs.next()) {
                    System.out.println(rs.getString("username"));
                }
            } catch (SQLException e ) {
                System.out.println(e);
            } finally {
                if (stmt != null) { stmt.close(); }
            }
        conn.close();
    }
    
    public void updateTable(int table) throws Exception{
        
        System.out.println("Connecting to MySQL Server...");
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        
        Connection conn = null;
        try{
            //updated to call database for this project
            conn = DriverManager.getConnection("jdbc:mysql://52.14.177.55:3306/final_project", "user", "pass");
        }
        catch(SQLException ex){
            System.out.println(ex);
        } 
        
        Statement stmt = null;

        try {
           stmt = conn.createStatement();
           ResultSet rs = stmt.executeQuery("UPDATE" + ""); //create the update statement based on whats being updated
           while (rs.next()) {
               System.out.println(rs.getString("username"));
           }
       } catch (SQLException e ) {
           System.out.println(e);
       } finally {
           if (stmt != null) { stmt.close(); }
       }
             
        conn.close();
        
    }
    
    public void deleteFromTable(int table) throws Exception{
        
        System.out.println("Connecting to MySQL Server...");
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        
        Connection conn = null;
        try{
            //updated to call database for this project
            conn = DriverManager.getConnection("jdbc:mysql://52.14.177.55:3306/final_project", "user", "pass");
        }
        catch(SQLException ex){
            System.out.println(ex);
        } 
        
        Statement stmt = null;

        try {
           stmt = conn.createStatement();
           ResultSet rs = stmt.executeQuery("DELETE"); //create the delete statement based on whats being deleted
           while (rs.next()) {
               System.out.println(rs.getString("username"));
           }
       } catch (SQLException e ) {
           System.out.println(e);
       } finally {
           if (stmt != null) { stmt.close(); }
       }
             
        conn.close();  
    }
    
    public void newRow(int table) throws Exception{
                
        System.out.println("Connecting to MySQL Server...");
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        
        Connection conn = null;
        try{
            //updated to call database for this project
            conn = DriverManager.getConnection("jdbc:mysql://52.14.177.55:3306/final_project", "user", "pass");
        }
        catch(SQLException ex){
            System.out.println(ex);
        } 
        
        Statement stmt = null;

        try {
           stmt = conn.createStatement();
           ResultSet rs = stmt.executeQuery("NEW ROW"); //create a new row statement based on new data
           while (rs.next()) {
               System.out.println(rs.getString("username"));
           }
       } catch (SQLException e ) {
           System.out.println(e);
       } finally {
           if (stmt != null) { stmt.close(); }
       }
             
        conn.close();
    }
    
}
