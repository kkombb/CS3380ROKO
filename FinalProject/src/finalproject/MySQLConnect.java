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
 * @author coast
 */
public class MySQLConnect {
    
    public MySQLConnect(){
        
    }
    
    public void showTable(int table) throws Exception{
        System.out.println("Connecting to AWS...");
        
        

        //MySQL
        System.out.println("Connecting to MySQL Server...");
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        
        Connection conn = null;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://52.14.177.55:3306/CS2830", "user", "pass");
            
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        
        Statement stmt = null;
        String statement = "SELECT * FROM users;";
        
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
    
}
