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

  //Public Customer class
    public final class Sales {
        private final SimpleStringProperty car = new SimpleStringProperty("");
        private final SimpleStringProperty model = new SimpleStringProperty("");
        private final SimpleStringProperty price = new SimpleStringProperty("");
        private final SimpleStringProperty customer = new SimpleStringProperty("");
        private final SimpleStringProperty vin = new SimpleStringProperty("");
   
        
    
        public Sales() {
            this("", "", "", "","");
        }
 
        public Sales(String car, String model, String price, String customer, String vin) {
            setCar(car);
            setModel(model);
            setPrice(price);
            setCustomer(customer);
            setVin(vin);
        }
   
     
        public String getCar() {
            return car.get();
        }
 
        public void setCar(String car2Var) {
            this.car.set(car2Var);
        }
        
        public String getModel() {
            return model.get();
        }
    
        public void setModel(String model2Var) {
            this.model.set(model2Var);
        }  
    
        public String getPrice() {
            return price.get();
        }
    
        public void setPrice(String priceVar) {
            this.price.set(priceVar);
        }
    
        public String getCustomer() {
            return customer.get();
        }
    
        public void setCustomer(String customerVar) {
            this.customer.set(customerVar);
        }
        
        public String getVin() {
            return vin.get();
        }
        
        public void setVin(String vinVar) {
            this.vin.set(vinVar);
        }
        
    }//End of Final Customer class
    