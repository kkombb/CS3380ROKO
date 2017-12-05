/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

/**
 *
 * @author kirtisorendorff 
 */
public class SoldCar {
    
    private String make;
    private String model;
    private float price;
    private String name;
    
    public SoldCar(String make, String model, float price, String name){
        this.make = make;
        this.model = model;
        this.price = price;
        this.name = name;
    }
    
    public void setMake(String make){
        this.make = make;
    }
    
    public String getMake(){
        return this.make;
    }
    
    public void setModel(String model){
        this.model = model;
    }
    
    public String getModel(){
        return this.model;
    }
    
    public void setPrice(float price){
        this.price = price;
    }
    
    public float getPrice(){
        return this.price;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
}
