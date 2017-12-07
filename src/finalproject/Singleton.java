/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 *
 * @author rolandoruche
 */
public class Singleton {
    private static Singleton instance = new Singleton();
    public static Singleton getInstance(){
        return instance;
    }
   
    private TextField car; //textfield for car box
    private TextField model; //textfield for model box
    private TextField year;
    private TextField miles;
    private TextField price;
    private TextField customer;
    private TextField vin;
    
    private TableView table;
    
    
    private Label priceLbl;
    private Label customerLbl;
    private Label valid;
    private Label invalid;
    
    
    private Button sellBtn;
    private Button insert;
    private Button delete;
    private Button update;
    private Button cancel;
  
    
     public TableView getTable() {
        return table;
    }
    
    public void setTable(TableView table) {
        this.table = table;
    }
    
    public Button getSellBtn() {
        return sellBtn;
    }
    
    public void setSellBtn(Button sellBtn) {
        this.sellBtn = sellBtn;
    }
    
    public Button getInsert() {
        return insert;
    }
    
    public void setInsert(Button insert) {
        this.insert = insert;
    }
    
    public Button getDelete() {
        return delete;
    }
    
    public void setDelete (Button delete) {
        this.delete = delete;
    }
    
    public Button getUpdate() {
        return update;
    }
    
    public void setUpdate(Button update) {
        this.update = update;
    }
    
    public Button getCancel() {
        return cancel;
    }
    
    public void setCancel(Button cancel) {
        this.cancel = cancel;
    }
    
    public TextField getCar() {
        return car;
    }
    
    public void setCar(TextField car) {
        this.car = car;
    }
        
    public TextField getModel() {
        return model;
    }
 
    public void setModel(TextField model) {
        this.model = model;
    }
    
    public TextField getYear() {
        return year;
    }
 
    public void setYear(TextField year) {
        this.year = year;
    }
    
    public TextField getMiles() {
        return miles;
    }
 
    public void setMiles(TextField miles) {
        this.miles = miles;
    }
    
    public TextField getPrice() {
        return price;
    }
    
    public void setPrice(TextField price) {
        this.price = price;
    }
    
    public TextField getCustomer() {
        return customer;
    }
    
    public void setCustomer(TextField customer) {
        this.customer = customer;
    }
    
    public TextField getVin() {
        return vin;
    }
    
    public void setVin(TextField vin) {
        this.vin = vin;
    }   
    
    public Label getPriceLbl() {
        return priceLbl;
    }
    
    public void setPriceLbl(Label priceLbl) {
        this.priceLbl = priceLbl;
    }
    
    public Label getCustomerLbl() {
        return customerLbl;
    }
    
    public void setCustomerLbl(Label customerLbl) {
        this.customerLbl = customerLbl;
    }
    
    public Label getValid() {
        return valid;
    }
    
    public void setValid(Label valid) {
        this.valid = valid;
    }
   
    public Label getInvalid() {
        return invalid;
    }
    
    public void setInvalid(Label invalid) {
        this.invalid = invalid;
    }
        
}//End of Singleton Class
