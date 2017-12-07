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


//FOR INT TABLE:
//      1 = inventory
//      2 = sales
public class MySQLConnect {
    
    public MySQLConnect(){
        
    }
    
    public void showTable(int table) throws Exception{
        
        System.out.println(FXMLDocumentController.data);
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
        String statement1 = "";
        String tablename = "";
        
        switch(table){
            case 1:
                tablename = "inventory";
                break;
            case 2:
                tablename = "sales";
                break;
        }
        
        statement1 = "SELECT * FROM "+tablename+";";
        //transfer result set to an instance of either SoldCar or InventoryCar
        //I need the list instance from Roland's stuff
            try {
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(statement1);
                
                System.out.println(tablename+":");
                while (rs.next()) {
                    if(table == 1){
                        int year = rs.getInt("year");
                        int miles = rs.getInt("miles");
                        Inventory inventory = new Inventory(rs.getString("car"), rs.getString("model"), Integer.toString(year), Integer.toString(miles), rs.getString("vin"));
                        System.out.println(rs.getString("vin"));
                        System.out.println(rs.getString("car"));
                        System.out.println(rs.getString("model"));
                        System.out.println(rs.getInt("year"));
                        System.out.println(rs.getInt("miles"));
                        FXMLDocumentController.data.add(inventory);
                    }
                    if(table == 2){
                        int price = rs.getInt("price");
                        Sales sales = new Sales(rs.getString("car"), rs.getString("model"), Integer.toString(price), rs.getString("name"), rs.getString("vin"));
                        System.out.println(rs.getString("vin"));
                        System.out.println(rs.getString("car"));
                        System.out.println(rs.getString("model"));
                        System.out.println(rs.getInt("price"));
                        System.out.println(rs.getString("name"));
                        FXMLDocument2Controller.data.add(sales);
                    }
                }
            } catch (SQLException e ) {
                System.out.println(e);
            } finally {
                if (stmt != null) { stmt.close(); }
            }
        conn.close();
    }
    
    public void updateRow(int table, int index) throws Exception{
        
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
        
        //establish criteria to update
        String vin = ""; //get vin from inventory class
        String year = "";
        String car = "";
        String model = "";
        String miles = "";
        String name = "";
        String price = "";
        String tablename = "";
        String columns = "";
        
        Inventory inventory;
        Sales sales;
        
        
        switch(table){
            case 1:
                tablename = "inventory";
                inventory = FXMLDocumentController.data.get(index);
                
                vin = inventory.getVin();
                car = inventory.getCar();
                model = inventory.getModel();
                year = inventory.getYear();
                miles = inventory.getMiles();
                
                columns = "car = '"+car+"', model = '"+model+"', year = "+year+", miles = "+miles;
                
                break;
            case 2:
                tablename = "sales";
                sales = FXMLDocument2Controller.data.get(index);
                
                vin = sales.getVin();
                car = sales.getCar();
                model = sales.getModel();
                price = sales.getPrice();
                name = sales.getCustomer();
                
                columns = "car = '"+car+"', model = '"+model+"', price = "+price+", name = '"+name+"'";
                break;
        }
        
        String condition = "vin = '" + vin + "';";
        
        
        Statement stmt = null;
        String statement1 = "UPDATE " + tablename + " SET " + columns + " WHERE " + condition; //query to update
        System.out.println(statement1);
        String statement2 = "SELECT * FROM " + tablename + ";";
        try {
           stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
           stmt.executeUpdate(statement1); //create the update statement based on whats being updated
           ResultSet rs = stmt.executeQuery(statement2);
           while (rs.next()) {
                    if(table == 1){
                        System.out.println(rs.getString("vin"));
                        System.out.println(rs.getString("car"));
                        System.out.println(rs.getString("model"));
                        System.out.println(rs.getInt("year"));
                        System.out.println(rs.getInt("miles"));
                    }
                    //sales table output
                    if(table == 2){
                        System.out.println(rs.getString("vin"));
                        System.out.println(rs.getString("car"));
                        System.out.println(rs.getString("model"));
                        System.out.println(rs.getInt("price"));
                        System.out.println(rs.getString("name"));
                    }
           }
       } catch (SQLException e ) {
           System.out.println(e);
       } finally {
           if (stmt != null) { stmt.close(); }
       }
             
        conn.close();
        
    }
    
    public void deleteFromTable(int table, int index) throws Exception{
        
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
        //vin is example data
        String vin = "";
        
        String tablename = "";
        
        //select table
        switch(table){
            case 1:
                tablename = "inventory";
                vin = FXMLDocumentController.data.get(index).getVin();
                break;
            case 2:
                tablename = "sales";
                vin = FXMLDocument2Controller.data.get(index).getVin();
                break;
        }
        
        String statement1 = "DELETE FROM "+tablename+" WHERE vin = '"+vin+"';";
        String statement2 = "SELECT * from "+tablename+";";
        
        try {
           stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
           stmt.executeUpdate(statement1); //create the delete statement based on whats being deleted
           ResultSet rs = stmt.executeQuery(statement2);
           while (rs.next()) {
               //this line will be replaced by actually copying data into the TableView
//               System.out.println(rs.getInt("vin") + rs.getString("make") + rs.getString("model") + rs.getInt("year") + rs.getFloat("miles"));
                    if(table == 1){
                        System.out.println(rs.getString("vin"));
                        System.out.println(rs.getString("car"));
                        System.out.println(rs.getString("model"));
                        System.out.println(rs.getInt("year"));
                        System.out.println(rs.getInt("miles"));
                    }
                    //sales table output
                    if(table == 2){
                        System.out.println(rs.getString("vin"));
                        System.out.println(rs.getString("car"));
                        System.out.println(rs.getString("model"));
                        System.out.println(rs.getInt("price"));
                        System.out.println(rs.getString("name"));
                    }
           }
       } catch (SQLException e ) {
           System.out.println(e);
       } finally {
           if (stmt != null) { stmt.close(); }
       }
             
        conn.close();  
    }
    
    
    //this function now works, only needs to replace example values with values given by the View
    public boolean newRow(int table) throws Exception{
                
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
        
        //example data
        String tablename = "";
        String vin = "";
        String car = "";
        String model = "";
        String year = "";
        String miles = "";
        String price = "";
        String name = "";
        String statement1 = "";
        String statement2 = "";
        int index = 0;
        
        boolean vinExist = true;
        
        Inventory inventory;
        Sales sales;

        
        switch(table){
            case 1:
                tablename = "inventory";
                //FXMLDocumentController.data.get(FXMLDocumentController.data.size());
                index = FXMLDocumentController.data.size();
                inventory = FXMLDocumentController.data.get(index - 1);
                
                vin = inventory.getVin();
                year = inventory.getYear();
                car = inventory.getCar();
                model = inventory.getModel();
                miles = inventory.getMiles();
                
                
                statement1 = "INSERT INTO "+tablename+" (vin, car, model, year, miles) VALUES ('"+vin+"', '"+car+"', '"+model+"', "+year+", "+miles+");";
                break;
            case 2:
                tablename = "sales";
                index = FXMLDocument2Controller.data.size();
                sales = FXMLDocument2Controller.data.get(index - 1);
                
                vin = sales.getVin();
                model = sales.getModel();
                car = sales.getCar();
                price = sales.getPrice();
                name = sales.getCustomer();
                
                statement1 = "INSERT INTO "+tablename+" (vin, car, model, price, name) VALUES ('"+vin+"', '"+car+"', '"+model+"', "+price+", '"+name+"');";
        }
        statement2 = "SELECT * FROM "+tablename+";";
        System.out.println(statement1);
        
        try {
           stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

           stmt.executeUpdate(statement1); //create a new row statement based on new data
           ResultSet rs = stmt.executeQuery(statement2);

           while (rs.next()) {
                    //inventory table output
                    if(table == 1){
                        System.out.println(rs.getString("vin"));
                        System.out.println(rs.getString("car"));
                        System.out.println(rs.getString("model"));
                        System.out.println(rs.getInt("year"));
                        System.out.println(rs.getInt("miles"));
                    }
                    //sales table output
                    if(table == 2){
                        System.out.println(rs.getString("vin"));
                        System.out.println(rs.getString("car"));
                        System.out.println(rs.getString("model"));
                        System.out.println(rs.getInt("price"));
                        System.out.println(rs.getString("name"));
                    }
           }
       } catch (SQLException e ) {
           System.out.println(e);
           System.out.println("Cannot output to MySQL...");
           vinExist = false;
       } finally {
           if (stmt != null) { stmt.close(); }
       }
             
        conn.close();
        return vinExist;
    }
    
}
