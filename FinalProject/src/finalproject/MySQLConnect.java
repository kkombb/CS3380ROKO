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
        String statement1 = "SELECT * FROM inventory;";      //!!!!change from "users" to the table being used, either inventory or sales
        String statement2 = "SELECT * FROM sales;";
        
        //transfer result set to an instance of either SoldCar or InventoryCar
        //I need the list instance from Roland's stuff
            try {
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(statement1);
                while (rs.next()) {
                    System.out.println(rs.getString(""));
                }
                ResultSet rs2 = stmt.executeQuery(statement2);
                while (rs2.next()) {
                    System.out.println(rs2.getString(""));
                }
            } catch (SQLException e ) {
                System.out.println(e);
            } finally {
                if (stmt != null) { stmt.close(); }
            }
        conn.close();
    }
    
    public void updateRow(int table) throws Exception{
        
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
    
    //this function should be in same place as newRow as far as functionality is concerned
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
        int vin = 1;
        String statement1 = "DELETE FROM inventory WHERE vin = ";
        String statement2 = "SELECT * from inventory";
        try {
           stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
           stmt.executeUpdate(statement1 + vin + ";"); //create the delete statement based on whats being deleted
           ResultSet rs = stmt.executeQuery(statement2);
           while (rs.next()) {
               //this line will be replaced by actually copying data into the TableView
               System.out.println(rs.getInt("vin") + rs.getString("make") + rs.getString("model") + rs.getInt("year") + rs.getFloat("miles"));
           }
       } catch (SQLException e ) {
           System.out.println(e);
       } finally {
           if (stmt != null) { stmt.close(); }
       }
             
        conn.close();  
    }
    
    //this function now works, only needs to replace example values with values given by the View
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
        
        //test post please ignore
        String statement1 = "INSERT INTO inventory(vin, make, model, year, miles) VALUES ('1', 'Ford', 'Bronco', '1984', '10000');";
        String statement2 = "SELECT * FROM inventory;";
        try {
           stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

           stmt.executeUpdate(statement1); //create a new row statement based on new data
           ResultSet rs = stmt.executeQuery(statement2);

           while (rs.next()) {
               System.out.println(rs.getInt("vin") + rs.getString("make") + rs.getString("model") + rs.getInt("year") + rs.getFloat("miles"));   
           }
       } catch (SQLException e ) {
           System.out.println(e);
       } finally {
           if (stmt != null) { stmt.close(); }
       }
             
        conn.close();
    }
    
}
