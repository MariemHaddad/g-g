/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.gg.GUI;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author lenovo
 */
public class NewFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
     try{
            Parent root = FXMLLoader.load(getClass().getResource("UserFXML.fxml"));
         
         Scene scene = new Scene(root);
         
         primaryStage.setScene(scene);
         primaryStage.show();
     }
     catch(IOException ex){
         System.out.println(ex.getMessage());
     }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    



    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
        