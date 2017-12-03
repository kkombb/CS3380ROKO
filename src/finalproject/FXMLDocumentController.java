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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


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
    private TextField car; //label for car box
    
    @FXML
    private TextField model; //label for model box
    
    @FXML
    private TextField year; //label for year box
    
    @FXML
    private TextField miles; //label for miles box
    
    @FXML
    private TableView<Person> table; 
    
    @FXML
    private TableColumn carClmn;
    
    @FXML
    private TableColumn modelClmn;
    
    @FXML
    private TableColumn yearClmn;
    
    @FXML
    private TableColumn milesClmn;
    
    @FXML
    private Button delete;
    
    @FXML
    private Button update;
    
    @FXML
    private Button cancel;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        //Creating an Obsevable list
        final ObservableList<Person> data = FXCollections.observableArrayList(
            new Person("Porsche", "991 Turbo", "1996", "15000")
        );
        
        
        //Associating Data with columns
        carClmn.setCellValueFactory(new PropertyValueFactory<Person, String>("car"));
        modelClmn.setCellValueFactory(new PropertyValueFactory<Person, String>("model"));
        yearClmn.setCellValueFactory(new PropertyValueFactory<Person, String>("year"));
        milesClmn.setCellValueFactory(new PropertyValueFactory<Person, String>("miles"));
        
        //Add data items inside table
        table.setItems(data);
        
        //setting the delete and the update button to false so it is not visible
        delete.setVisible(false);
        update.setVisible(false);
        cancel.setVisible(false);
        
    }//End of initialize    
  
    
    @FXML
    private void updateBtn(ActionEvent event) {
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
                
                Person data = table.getSelectionModel().getSelectedItem();
                
                data.setCar(car.getText());
                data.setModel(model.getText());
                data.setYear(year.getText());
                data.setMiles(miles.getText());
               
                table.refresh(); //refrehes the full table
                
                valid.setText("Queue updated!");//lets user know that row has been updated
                invalid.setText(null);
                
                //Clear all the contents in TextField after deleting 
                car.clear();
                model.clear();
                year.clear();
                miles.clear();
                
                //disappear buttons after updating
                delete.setVisible(false);
                update.setVisible(false);
                cancel.setVisible(false);
        
                //Set table row selection mode to null
                table.getSelectionModel().select(null);  
            }//End of else       
        }//End of else
    }//End of updateBtn
    
    @FXML
    private void insertBtn(ActionEvent event) {   
        ObservableList<Person> data = table.getItems();
        
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
        } else {
            data.add(new Person(
                    car.getText(),
                    model.getText(),
                    year.getText(),
                    miles.getText()));
            car.clear();
            model.clear();
            year.clear();
            miles.clear();
            
            //diplaying items on the table
            table.setItems(data);
           
            valid.setText("Queue inserted!");
            invalid.setText(null);
        }
        
    }//End of insertBtn
   
    @FXML
    private void deleteBtn(ActionEvent event) throws InterruptedException {
        if(table.getSelectionModel().getSelectedItem() == null) { //setting buttons invisible once no content is in the table
            delete.setVisible(false);
            update.setVisible(false);
            cancel.setVisible(false);
        }
        table.setEditable(true);
        int selectedIndex = table.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
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
        
            //Set table roll selection mode to null
            table.getSelectionModel().select(null);
        } else {
            invalid.setText(null);
            valid.setText(null);
        }//End of else
    }//End of deleteBtn
    
    
    @FXML
    private void handleClicked(MouseEvent event) {
        delete.setVisible(true); //displaying the delete button
        update.setVisible(true); //displaying the update button
        cancel.setVisible(true); //displaying the cancel button
        
        table.setEditable(true);
        if(table.getSelectionModel().getSelectedItem() != null) {
            Person data = table.getSelectionModel().getSelectedItem();
            String displayCar = data.getCar();
            String displayModel = data.getModel();
            String displayYear = data.getYear();
            String displayMiles = data.getMiles();
           
            car.setText(displayCar);
            model.setText(displayModel);
            year.setText(displayYear);
            miles.setText(displayMiles);
            
        } else {
            //disappear buttons after deleting
            delete.setVisible(false);
            update.setVisible(false);
            cancel.setVisible(false);
        }
    }
    
    @FXML
    private void cancelBtn(ActionEvent event) {
        delete.setVisible(false);
        update.setVisible(false);
        cancel.setVisible(false);
        table.getSelectionModel().select(null);
        valid.setText(null);
        invalid.setText(null); 
        //Clear all the contents in TextField after deleting 
        car.clear();
        model.clear();
        year.clear();
        miles.clear();
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
        
        TextArea textArea = new TextArea("This is for our final project. ");
        textArea.appendText("And yes we kick ass!");
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
private void handleEnterKey(KeyEvent event) {
    ActionEvent insertEvent = null;
    if(event.getCode() == KeyCode.ENTER){
        insertBtn(insertEvent);
    }
}
/*
@FXML
private void handleArrowKey(KeyEvent event) {
    if(event.getCode() == KeyCode.UP){
        
        Person data = table.getSelectionModel().getSelectedItem();
        
        String displayCar = data.getCar();
        String displayModel = data.getModel();
        String displayYear = data.getYear();
        String displayMiles = data.getMiles();
       
        car.setText(displayCar);
        model.setText(displayModel);
        year.setText(displayYear);
        miles.setText(displayMiles);
       
    } else if (event.getCode() == KeyCode.DOWN) {
        Person data = table.getSelectionModel().getSelectedItem();
        
        String displayCar = data.getCar();
        String displayModel = data.getModel();
        String displayYear = data.getYear();
        String displayMiles = data.getMiles();
           
        car.setText(displayCar);
        model.setText(displayModel);
        year.setText(displayYear);
        miles.setText(displayMiles);
       
    }
     
}
*/
    
}//End of FXMLDocController class
