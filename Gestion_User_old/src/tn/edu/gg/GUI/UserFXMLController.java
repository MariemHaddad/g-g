/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.gg.GUI;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import tn.edu.gg.services.ServiceUser;
import tn.edu.gg.entities.User;
import tn.edu.gg.tools.DataSource;
import workshopjdbc.WorkshopJDBC;
/**
 * 
 * FXML Controller class
 *
 * @author lenovo
 */
public class UserFXMLController implements Initializable {

    @FXML
    private TextField NomUser;
    @FXML
    private TextField PrénomUser;
    @FXML
    private TextField AdressemailUser;
    @FXML
    private TextField passUser;
    @FXML
    private TextField AdresseUser;
    @FXML
    private Button enregistrer;
    @FXML
    private TextField Roleu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void Enregistrer(ActionEvent event){
        //String id = inputId.getText();
        String firstnameU = NomUser.getText();
        String lastnameU = PrénomUser.getText();
        String passwordU = passUser.getText();
        String loginU = AdressemailUser.getText();
        String Role = Roleu.getText();
        String adresse = AdresseUser.getText();
        
        
        Connection cnx =DataSource.getInstance().getConnection();
      
       User u=new User (firstnameU,lastnameU,passwordU,loginU, Role,adresse);
         ServiceUser su = new ServiceUser ();
         su.ajouter(u);
    }

   

   
    
}
    
    
    

