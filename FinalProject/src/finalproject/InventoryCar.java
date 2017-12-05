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
public class InventoryCar {
    
    private String make;
    private String model;
    private float miles;
    private int year;
    
    public InventoryCar(String make, String model, float miles, int year){
        this.make = make;
        this.model = model;
        this.miles = miles;
        this.year = year;
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
    
    public void setMiles(float miles){
        this.miles = miles;
    }
    
    public float getMiles(){
        return this.miles;
    }
    
    public void setYear(int year){
        this.year = year;
    }
    
    public int getYear(){
        return this.year;
    }

}
