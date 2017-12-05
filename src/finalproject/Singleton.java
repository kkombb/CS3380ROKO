/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;


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
        
        
}//End of Singleton Class
