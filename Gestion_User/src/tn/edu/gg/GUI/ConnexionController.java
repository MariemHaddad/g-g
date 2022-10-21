/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.gg.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.edu.gg.entities.User;
import tn.edu.gg.services.ServiceUser;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class ConnexionController implements Initializable {

    @FXML
    private TextField adressemail;
    @FXML
    private TextField mdp;
    @FXML
    private Button connect;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Actioon(ActionEvent event) {
          String loginU = adressemail.getText();
          String passwordU = mdp.getText();
          
          ServiceUser service = new ServiceUser();
          
          User connected = service.connexion(loginU, passwordU);
          
          if(connected == null){
              System.out.println("error");
          }else{
              System.out.println(connected);              
          }
    
    }

   
    
}
