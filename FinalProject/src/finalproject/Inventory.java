/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author rolandoruche
 */

  //Public Person class
    public final class Inventory {
        private final SimpleStringProperty car = new SimpleStringProperty("");
        private final SimpleStringProperty model = new SimpleStringProperty("");
        private final SimpleStringProperty year = new SimpleStringProperty("");
        private final SimpleStringProperty miles = new SimpleStringProperty("");
        private final SimpleStringProperty vin = new SimpleStringProperty("");
   
        
    
        public Inventory() {
            this("", "", "", "", "");
        }
 
        public Inventory(String car, String model, String year, String miles, String vin) {
            setCar(car);
            setModel(model);
            setYear(year);
            setMiles(miles);
            setVin(vin);
        }
   
     
        public String getCar() {
            return car.get();
        }
 
        public void setCar(String carVar) {
            this.car.set(carVar);
        }
        
        public String getModel() {
            return model.get();
        }
    
        public void setModel(String modelVar) {
            this.model.set(modelVar);
        }  
    
        public String getYear() {
            return year.get();
        }
    
        public void setYear(String yearVar) {
            this.year.set(yearVar);
        }
    
        public String getMiles() {
            return miles.get();
        }
    
        public void setMiles(String milesVar) {
            this.miles.set(milesVar);
        }
        
        public String getVin() {
            return vin.get();
        }
        
        public void setVin(String vinVar) {
            this.vin.set(vinVar);
        }
        
        
    }//End of Final Person class
    