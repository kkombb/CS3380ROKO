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
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author rolandoruche
 */
public class FXMLDocument2Controller implements Initializable {

    @FXML
    private TableView<Customer> table2; //Table for viewing cars sold to customers
    
    
    @FXML
    private TableColumn carClmn;
    
    @FXML
    private TableColumn modelClmn;
    
    @FXML
    private TableColumn priceClmn;
    
    @FXML
    private TableColumn customerClmn;
    
    @FXML
    private TableColumn dateClmn;
    
    
    //FOR SWITCHING SCENES
    private Stage stage;
    public Scene scene1; //for car dealership scene
    public FXMLDocumentController FXMLDocumentController;
   
    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        final ObservableList<Customer> data = FXCollections.observableArrayList(
            new Customer("Porsche", "991 Turbo", "56000", "Bob Evans", "12/08/2017")
        );
        
         //Associating Data with columns
        carClmn.setCellValueFactory(new PropertyValueFactory<Customer, String>("car"));
        modelClmn.setCellValueFactory(new PropertyValueFactory<Customer, String>("model"));
        priceClmn.setCellValueFactory(new PropertyValueFactory<Customer, String>("price"));
        customerClmn.setCellValueFactory(new PropertyValueFactory<Customer, String>("customer"));
        dateClmn.setCellValueFactory(new PropertyValueFactory<Customer, String>("date"));
        
        
        
        //Add data items inside table
        table2.setItems(data);
        
        
        
        
    }    
    
    
    @FXML
    private void handleTestButton(ActionEvent event) {
        String str1 = Singleton.getInstance().getCar().getText();
        String str2 = Singleton.getInstance().getModel().getText();

        System.out.println(str1);
        System.out.println(str2);
    }
    
    @FXML
    private void goBackToCarDealership(ActionEvent event) {
        stage.setScene(scene1); //Goes back to the previous scene
    }
    
    public void start(Stage stage) {
        this.stage = stage;
    }
    
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
}//End of FXMLDocument2Controller
