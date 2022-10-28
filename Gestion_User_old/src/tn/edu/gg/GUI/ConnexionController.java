/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.gg.GUI;
import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.edu.gg.entities.User;
import tn.edu.gg.services.ServiceUser;
import tn.edu.gg.tools.DataSource;
import java.sql.Connection;
import javafx.scene.input.MouseEvent;

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
    @FXML
    private Button Inscrire;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Actioon(ActionEvent event) throws IOException {
         
  String role = null;
        if (adressemail.getText().equals("") || mdp.getText().equals("")) {
            Alert alert = new Alert(AlertType.INFORMATION);

            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("completer vos coordonnées ");
            alert.showAndWait();

        } else {

            ServiceUser su = new ServiceUser();
            User ss = su.connexion(adressemail.getText(),mdp.getText());

            if (ss == null) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Verifier vos coordonnées ");
                alert.show();

            } else if (adressemail.getText().equals("mariem.haddad@esprit.tn") || mdp.getText().equals("Zumruduanka")) {
              
        connect.getScene().getWindow().hide();
                            Parent root = FXMLLoader.load(getClass().getResource("detail.fxml"));
                            Stage mainStage = new Stage();
                            Scene scene = new Scene(root);
                            mainStage.setScene(scene);
                            mainStage.show();
            } else if ((adressemail.getText().equals("aziz.hadda@gmail.com") || mdp.getText().equals("123"))) {
               connect.getScene().getWindow().hide();
                            Parent root = FXMLLoader.load(getClass().getResource("Formateur.fxml"));
                            Stage mainStage = new Stage();
                            Scene scene = new Scene(root);
                            mainStage.setScene(scene);
                            mainStage.show();
            }else if ((adressemail.getText().equals("sarra@gmail.com") || mdp.getText().equals("111"))) {
               connect.getScene().getWindow().hide();
                            Parent root = FXMLLoader.load(getClass().getResource("Livreur.fxml"));
                            Stage mainStage = new Stage();
                            Scene scene = new Scene(root);
                            mainStage.setScene(scene);
                            mainStage.show();
        }else if ((adressemail.getText().equals("haddadmariem32@gmail.com") || mdp.getText().equals("222"))) {
               connect.getScene().getWindow().hide();
                            Parent root = FXMLLoader.load(getClass().getResource("Etudiant.fxml"));
                            Stage mainStage = new Stage();
                            Scene scene = new Scene(root);
                            mainStage.setScene(scene);
                            mainStage.show();
        }}
    }
    @FXML
    private void Inscrire(ActionEvent event) {
               Inscrire.getScene().getWindow().hide();
               try{
              Parent root = FXMLLoader.load(getClass().getResource("UserFXML.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
               } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
    }

    @FXML
    private void reset(MouseEvent event) {
        Inscrire.getScene().getWindow().hide();
               try{
              Parent root = FXMLLoader.load(getClass().getResource("Reset.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
               } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
    }
        
    }

    
    

   
    

