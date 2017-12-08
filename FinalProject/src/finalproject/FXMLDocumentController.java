/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import java.sql.*;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


/**
 *
 * @author rolandoruche
 */
public class FXMLDocumentController implements Initializable {

    
    
    
    
    @FXML
    private Label invalid; //label for wrong or insufficent inputs
    
    @FXML
    private Label valid; //label for correct inputs
    
    @FXML
    private Label carLbl; //label for model
    
    @FXML
    private Label modelLbl; //label for model
    
    @FXML
    private Label yearLbl; //label for year 
    
    @FXML
    private Label milesLbl; //label for miles
    
    @FXML
    private Label vinLbl; //label for VIN
    
    
   
    @FXML
    private TextField car; //textfield for car box
    
    @FXML
    private TextField model; //textfield for model box
    
    @FXML
    private TextField year; //textfield for year box 
    
    @FXML
    private TextField miles; //textfield for miles box 
    
    @FXML
    private TextField vin; //textfield for vin
    
    
    @FXML
    private TableView<Inventory> table; 
    
    @FXML
    private TableColumn carClmn;
    
    @FXML
    private TableColumn modelClmn;
    
    @FXML
    private TableColumn yearClmn;
    
    @FXML
    private TableColumn milesClmn;
    
    @FXML
    private TableColumn vinClmn;
    
    @FXML
    private Button insert;
    
    @FXML
    private Button delete;
    
    @FXML
    private Button update;
    
    @FXML
    private Button cancel;
    
    @FXML
    private Button sell; //Button to sell car to customer
    
    
   
    
    
    //FOR SWITCHING SCENES
    private Stage stage;
    private Scene scene1; //car dealership scene
    private Scene scene2; //car inventory scene
    private FXMLDocument2Controller FXMLDocument2Controller; //doc2 controller
    
    MySQLConnect sql = new MySQLConnect();
    
    static ObservableList<Inventory> data;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        //Creating an Obsevable list
        data = FXCollections.observableArrayList();
       
       
        //Associating Data with columns
        carClmn.setCellValueFactory(new PropertyValueFactory<Inventory, String>("car"));
        modelClmn.setCellValueFactory(new PropertyValueFactory<Inventory, String>("model"));
        yearClmn.setCellValueFactory(new PropertyValueFactory<Inventory, String>("year"));
        milesClmn.setCellValueFactory(new PropertyValueFactory<Inventory, String>("miles"));
        vinClmn.setCellValueFactory(new PropertyValueFactory<Inventory, String>("vin"));
        
        
        car.setPromptText("Porsche");
        model.setPromptText("991 Turbo");
        year.setPromptText("1996");
        miles.setPromptText("15000");
        vin.setPromptText("1G1789FL523L6122F");
        
        //Add data items inside table
        table.setItems(data);
        
        //setting the delete and the update button to false so it is not visible
        delete.setVisible(false);
        update.setVisible(false);
        cancel.setVisible(false);
        
        //Test
        Singleton.getInstance().setCar(car);
        Singleton.getInstance().setModel(model);
        Singleton.getInstance().setYear(year);
        Singleton.getInstance().setMiles(miles);
        Singleton.getInstance().setVin(vin);
        
        Singleton.getInstance().setInsert(insert);
        Singleton.getInstance().setDelete(delete);
        Singleton.getInstance().setUpdate(update);
        Singleton.getInstance().setCancel(cancel);
        
        Singleton.getInstance().setTable(table);
        
        Singleton.getInstance().setValid(valid);
        Singleton.getInstance().setInvalid(invalid);
        

    }//End of initialize    
    
    public void start(Stage stage) {
        this.stage = stage;
        scene1 = stage.getScene();
        valid.setText(null);
        invalid.setText(null);
        
      
    }
  
    
    @FXML
    private void updateBtn(ActionEvent event) throws Exception {
        if(table.getSelectionModel().getSelectedItem() == null) { //setting buttons invisible once no content is in the table
            delete.setVisible(false);
            update.setVisible(false);
            cancel.setVisible(false);
            invalid.setText("No content to update.");
            valid.setText(null);
        } else {
            //UPDATING DONE HERE
            if ((car.getText() == null || car.getText().length() == 0)) {
                invalid.setText("Invalid requirements.");
                valid.setText(null);
            }  else if ((model.getText() == null || model.getText().length() == 0)) {
                invalid.setText("Invalid requirements.");
                valid.setText(null);
            }  else if ((year.getText() == null || year.getText().length() == 0)) {
                invalid.setText("Invalid requirements.");
                valid.setText(null);
            }  else if ((miles.getText() == null || miles.getText().length() == 0)) {
                invalid.setText("Invalid requirements.");
                valid.setText(null);
            } else {
                
                if(isInt(miles.getText()) && isInt(year.getText())){

                    Inventory data = table.getSelectionModel().getSelectedItem();
                    int selectedIndex = table.getSelectionModel().getSelectedIndex();

                    data.setCar(car.getText());
                    data.setModel(model.getText());
                    data.setYear(year.getText());
                    data.setMiles(miles.getText());
                    data.setVin(vin.getText());

                    sql.updateRow(1, selectedIndex);

                    table.refresh(); //refrehes the full table

                    valid.setText("Queue updated!");//lets user know that row has been updated
                    invalid.setText(null);

                    //Clear all the contents in TextField after deleting 
                    car.clear();
                    model.clear();
                    year.clear();
                    miles.clear();
                    vin.clear(); 
                } else {
                    valid.setText(null);
                    invalid.setText("Queue not inserted, Update anomoly detected");
                }
                //disappear buttons after updating
                delete.setVisible(false);
                update.setVisible(false);
                cancel.setVisible(false);
                vin.setDisable(false);
        
                //Set table row selection mode to null
                table.getSelectionModel().select(null);
                insert.setText("Insert"); //setting button back to Insert
            }//End of else       
        }//End of else
    }//End of updateBtn
    
    @FXML
    private void insertBtn(ActionEvent event) throws Exception{  
         data = table.getItems();
        
        invalid.setText(null);
        if ((car.getText() == null || car.getText().length() == 0)) {
                invalid.setText("Invalid requirements.");
                valid.setText(null);
        }  else if ((model.getText() == null || model.getText().length() == 0)) {
                invalid.setText("Invalid requirements.");
                valid.setText(null);
        }  else if ((year.getText() == null || year.getText().length() == 0)) {
                invalid.setText("Invalid requirements.");
                valid.setText(null);
        }  else if ((miles.getText() == null || miles.getText().length() == 0)) {
                invalid.setText("Invalid requirements.");
                valid.setText(null);
        } else if ((vin.getText() == null || vin.getText().length() == 0)) {
                invalid.setText("Invalid requirements.");
                valid.setText(null);
        } else if("Want to sell?".equals(insert.getText())) { //For selling purposes
                goToCarInventory(event);
                setVisible();
                
        }
        else {
            //add to sql list
            
            //add the new row to sql IFF year and miles are integers
            if(isInt(miles.getText()) && isInt(year.getText())){
                
                data.add(new Inventory(
                car.getText(),
                model.getText(),
                year.getText(),
                miles.getText(),
                vin.getText()));
                
                System.out.println(isInt(data.get(data.size()-1).getYear()));
                
                if(sql.newRow(1) == false){
                    data.remove(data.size() - 1);
                    valid.setText(null);
                    invalid.setText("Insert anomoly detected: Two cars with same VIN...");
                } else {
                   valid.setText("Queue inserted!");
                   invalid.setText(null); 
                }
                

                car.clear();
                model.clear();
                year.clear();
                miles.clear();
                vin.clear();

                //diplaying items on the table
                table.setItems(data);
                
            }else{
                valid.setText(null);
                invalid.setText("Queue not inserted, Insert anomoly detected");
            }

        }
        
    }//End of insertBtn
    
    private boolean isInt(String string){
        boolean isInteger = false;
        
        try{
            int x = Integer.parseInt(string);
            isInteger = true;
        } catch(Exception e){
            System.err.println("String is not an int...");
        }
        
        return isInteger;
    }
   
    @FXML
    private void deleteBtn(ActionEvent event) throws InterruptedException, Exception {
        if(table.getSelectionModel().getSelectedItem() == null) { //setting buttons invisible once no content is in the table
            delete.setVisible(false);
            update.setVisible(false);
            cancel.setVisible(false);
        }
        table.setEditable(true);
        int selectedIndex = table.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            sql.deleteFromTable(1, selectedIndex);
            table.getItems().remove(selectedIndex);
            valid.setText("Queue deleted!");
            
            invalid.setText(null);
        
            //disappear buttons after deleting
            delete.setVisible(false);
            update.setVisible(false);
            cancel.setVisible(false);
        
            //Clear all the contents in TextField after deleting 
            car.clear();
            model.clear();
            year.clear();
            miles.clear();
            vin.clear();
        
            //Set table roll selection mode to null
            table.getSelectionModel().select(null);
            insert.setText("Insert"); //setting button back to Insert
            vin.setDisable(false);
        } else {
            invalid.setText(null);
            valid.setText(null);
        }//End of else
    }//End of deleteBtn
    
    private void setVisible() {
        TextField price = Singleton.getInstance().getPrice();
        TextField customer = Singleton.getInstance().getCustomer();
        Label priceLbl = Singleton.getInstance().getPriceLbl();
        Label customerLbl = Singleton.getInstance().getCustomerLbl();
        Label validText = Singleton.getInstance().getValid();
        Label invalidText = Singleton.getInstance().getInvalid();
        Button sellBtn = Singleton.getInstance().getSellBtn();
        
        //Setting all buttons labels tFields to visibe in Doc2controller
        price.setVisible(true);
        customer.setVisible(true);
        priceLbl.setVisible(true);
        customerLbl.setVisible(true);
        sellBtn.setVisible(true);
        validText.setText(null);
        invalidText.setText(null);
    }
  
    private void sellBtnAppear(ActionEvent event) throws Exception{
        insert.setText("Sell");
        //Setting all button, labels and textfields to invisible
        delete.setVisible(false);
        update.setVisible(false);
        cancel.setVisible(true); //giving the person the option to opt out of selling
        car.setVisible(false);
        model.setVisible(false);
        carLbl.setVisible(false);
        modelLbl.setVisible(false);
        
        yearLbl.setText("Price");
        milesLbl.setText("Customer");
        
        year.clear(); //clearing the textField of year(=>price)
        miles.clear(); //clearing the textField or miles(=>customer)
     
        
    }
    
    @FXML
    private void handleClicked(MouseEvent event) {
        
        delete.setVisible(true); //displaying the delete button
        update.setVisible(true); //displaying the update button
        cancel.setVisible(true); //displaying the cancel button
        
        table.setEditable(true);
        if(table.getSelectionModel().getSelectedItem() != null) {
            Inventory data = table.getSelectionModel().getSelectedItem();
            String displayCar = data.getCar();
            String displayModel = data.getModel();
            String displayYear = data.getYear();
            String displayMiles = data.getMiles();
            String displayVin = data.getVin();
           
            car.setText(displayCar);
            model.setText(displayModel);
            year.setText(displayYear);
            miles.setText(displayMiles);
            vin.setText(displayVin);
            
            insert.setText("Want to sell?"); //Giving the user the option to sell the car
            vin.setDisable(true);
            
        } else {
            //disappear buttons after deleting
            delete.setVisible(false);
            update.setVisible(false);
            cancel.setVisible(false);
        }
    }
    
    @FXML
    private void cancelBtn(ActionEvent event) {
        car.setVisible(true);
        model.setVisible(true);
        carLbl.setVisible(true);
        modelLbl.setVisible(true);
        yearLbl.setText("Year");
        milesLbl.setText("Miles");
        delete.setVisible(false);
        update.setVisible(false);
        cancel.setVisible(false);
        table.getSelectionModel().select(null);
        valid.setText(null);
        invalid.setText(null); 
        vin.setDisable(false);
        //Clear all the contents in TextField after deleting 
        car.clear();
        model.clear();
        year.clear();
        miles.clear();
        vin.clear();
        insert.setText("Insert"); //setting button back to Insert
    }//End of ccancelBtn
    
    @FXML
    private void handleAbout(ActionEvent event) {
        displayAboutAlert();
    }//End of handleAbout
    
    private void displayAboutAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Car Storage File");
        alert.setContentText("This application was developed by Roland Oruche and Kirtis Orendorff and for CS3380 at the University of Missouri.");
        
        TextArea textArea = new TextArea("This is for our final project. This application keeps track of the inventory in a mock car dealership.");
        textArea.appendText("Project by Kirtis O. and Roland O.");
        textArea.setEditable(false);
        textArea.setWrapText(true);
        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
            
        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(textArea, 0, 0);

        alert.getDialogPane().setExpandableContent(expContent);
        
        alert.showAndWait();
    }//End of alert
          
    
@FXML
private void handleEnterKey(KeyEvent event) throws Exception{
    ActionEvent insertEvent = null;
    if(event.getCode() == KeyCode.ENTER){
        insertBtn(insertEvent);
    }
}//End of handleEnterKey

@FXML
private void goToCarInventory(ActionEvent event) throws Exception{
   if (scene2 == null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument2.fxml"));
                Parent scene2Root = loader.load();
                FXMLDocument2Controller = loader.getController();
                FXMLDocument2Controller.scene1 = scene1;
                FXMLDocument2Controller.FXMLDocumentController = this;
                scene2 = new Scene(scene2Root);
                
                sql.showTable(2);
            } catch (Exception ex) {
                
            }
        }
        
        stage.setScene(scene2);
        FXMLDocument2Controller.start(stage); 
}//End of carInventory

    
}//End of FXMLDocController class

