/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 *
 * @author rolandoruche
 */
public class FinalProject extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Parent root = loader.load();
        FXMLDocumentController FXMLDocumentController = loader.getController();
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
        MySQLConnect sql = new MySQLConnect();
        sql.showTable(1);

        
        FXMLDocumentController.start(stage); 
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}//Testing comment
