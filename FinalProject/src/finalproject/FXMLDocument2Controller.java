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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author rolandoruche
 */
public class FXMLDocument2Controller implements Initializable {

    @FXML
    private TableView<Sales> table2; //Table for viewing cars sold to customers
    
    //COLUMNS
    @FXML
    private TableColumn carClmn;
    
    @FXML
    private TableColumn modelClmn;
    
    @FXML
    private TableColumn priceClmn;
    
    @FXML
    private TableColumn customerClmn;
    
    @FXML
    private TableColumn vinClmn;
    
    //TEXTFIELDS
    @FXML
    private TextField price;
    
    @FXML
    private TextField customer;
    
    
    //LABELS
    @FXML
    private Label invalid;
    
    @FXML
    private Label valid;
    
    @FXML
    private Label priceLbl;
    
    @FXML
    private Label customerLbl;
    
    @FXML
    private Button sellBtn;
    
    @FXML
    private Label sellStatement; //label for displaying what is being sold
    
    
    MySQLConnect sql = new MySQLConnect();
    
    //FOR SWITCHING SCENES
    private Stage stage;
    public Scene scene1; //for car dealership scene
    public FXMLDocumentController FXMLDocumentController;
   
    static ObservableList<Sales> data;
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         data = FXCollections.observableArrayList();
        
         //Associating Data with columns
        carClmn.setCellValueFactory(new PropertyValueFactory<Sales, String>("car"));
        modelClmn.setCellValueFactory(new PropertyValueFactory<Sales, String>("model"));
        priceClmn.setCellValueFactory(new PropertyValueFactory<Sales, String>("price"));
        customerClmn.setCellValueFactory(new PropertyValueFactory<Sales, String>("customer"));
        vinClmn.setCellValueFactory(new PropertyValueFactory<Sales, String>("vin"));
      
        //Add data items inside table
        table2.setItems(data);
        
        //Test
        Singleton.getInstance().setPrice(price);
        Singleton.getInstance().setCustomer(customer);
        Singleton.getInstance().setPriceLbl(priceLbl);
        Singleton.getInstance().setCustomerLbl(customerLbl);
        Singleton.getInstance().setSellBtn(sellBtn);
        Singleton.getInstance().setValid(valid);
        Singleton.getInstance().setInvalid(invalid);
        
        String getCar = Singleton.getInstance().getCar().getText();
        String getModel = Singleton.getInstance().getModel().getText();
        
        sellStatement.setText("Selling: " + getCar + " " + getModel);
        
      
    }//End of initialize
   
    
    @FXML
    private void sellBtnAction(ActionEvent event) throws Exception {
        data = table2.getItems();
        String getCar = Singleton.getInstance().getCar().getText();
        String getModel = Singleton.getInstance().getModel().getText();
        String getVin = Singleton.getInstance().getVin().getText();
       
        
        if ((price.getText() == null || price.getText().length() == 0)) {
                invalid.setText("Invalid requirements.");
                valid.setText(null);
        }  else if ((customer.getText() == null || customer.getText().length() == 0)) {
                invalid.setText("Invalid requirements.");
                valid.setText(null);
        } else {
            
            
            if(isInt(price.getText())){
                data.add(new Sales(
                   getCar,
                   getModel,
                   price.getText(),
                   customer.getText(),
                   getVin));

                sql.newRow(2);

                price.clear(); //clearing the TextField of price
                customer.clear(); //clearing the TextField of customer

                sellStatement.setText(null);


                TableView table = Singleton.getInstance().getTable();
                int selectedIndex = table.getSelectionModel().getSelectedIndex();
                if (selectedIndex >= 0) {
                    System.out.println("deleting from inventory table");
                    sql.deleteFromTable(1, selectedIndex);
                    table.getItems().remove(selectedIndex);
                }

                //diplaying items on the table
                table2.setItems(data);
                valid.setText("Car Sold!");
            
                priceLbl.setVisible(false);
                price.setVisible(false);
                customerLbl.setVisible(false);
                customer.setVisible(false);
                sellBtn.setVisible(false);
                invalid.setText(null);
            }else{
                valid.setText(null);
                invalid.setText("Car not sold, insert anomoly detected...");
            }
        }
        
    }
    
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
    private void goBackToCarDealership(ActionEvent event) {
        stage.setScene(scene1); //Goes back to the previous scene
        hideObjects();
    }
    
    private void hideObjects() {
        //Resetting all of the TextFields
        TextField carField = Singleton.getInstance().getCar();
        TextField modelField = Singleton.getInstance().getModel();
        TextField yearField = Singleton.getInstance().getYear();
        TextField milesField = Singleton.getInstance().getMiles();
        TextField vinField = Singleton.getInstance().getVin();
        carField.setText(null);
        modelField.setText(null);
        yearField.setText(null);
        milesField.setText(null);
        vinField.setText(null);
        sellStatement.setText(null);
        vinField.setDisable(false);
        
        //Resetting all of the Buttons
        Button insertBtn = Singleton.getInstance().getInsert();
        Button deleteBtn = Singleton.getInstance().getDelete();
        Button updateBtn = Singleton.getInstance().getUpdate();
        Button cancelBtn = Singleton.getInstance().getCancel();
       
        insertBtn.setText("Insert");
        deleteBtn.setVisible(false);
        updateBtn.setVisible(false);
        cancelBtn.setVisible(false);
        
        
        
       
        
        
        
    }
    
    public void start(Stage stage) {
        this.stage = stage;
        
            priceLbl.setVisible(false);
            price.setVisible(false);
            customerLbl.setVisible(false);
            customer.setVisible(false);
            sellBtn.setVisible(false);
            valid.setText(null);
            invalid.setText(null);
            
            
    }
   
    @FXML
    private void handleEnterKey(KeyEvent event) throws Exception {
        ActionEvent insertEvent = null;
        if(event.getCode() == KeyCode.ENTER){
           sellBtnAction(insertEvent);
        }
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
}//End of FXMLDocument2Controller
