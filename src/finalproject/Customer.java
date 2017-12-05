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
    public final class Customer {
        private final SimpleStringProperty car = new SimpleStringProperty("");
        private final SimpleStringProperty model = new SimpleStringProperty("");
        private final SimpleStringProperty price = new SimpleStringProperty("");
        private final SimpleStringProperty customer = new SimpleStringProperty("");
        private final SimpleStringProperty date = new SimpleStringProperty("");
   
        
    
        public Customer() {
            this("", "", "", "", "");
        }
 
        public Customer(String car, String model, String price, String customer, String date) {
            setCar(car);
            setModel(model);
            setPrice(price);
            setCustomer(customer);
            setDate(date);
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
        
        public String getDate() {
            return date.get();
        }
        
        public void setDate(String dateVar) {
            this.date.set(dateVar);
        }
        
    }//End of Final Customer class
    