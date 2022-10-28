/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.gg.GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import tn.edu.gg.entities.User;
import tn.edu.gg.services.ServiceUser;
import tn.edu.gg.tools.DataSource;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class DetailController implements Initializable {

    @FXML
    private TableView<User> affichage;
    @FXML
    private TableColumn<User, String> nom;
    @FXML
    private TableColumn<User, String> prénom;
    @FXML
    private TableColumn<User, String> mail;
    @FXML
    private TableColumn<User, String> mdp;
    @FXML
    private TextField prenom;
    @FXML
    private TextField adresse;
    @FXML
    private TextField motdp;
    @FXML
    private Button Modifier;
    @FXML
    private TextField nomm;
    @FXML
    private Button deconnect;





@Override
    public void initialize(URL url, ResourceBundle rb) {
       Connection cnx = DataSource.getInstance().getConnection();
        ServiceUser su = new ServiceUser();
     
                 ObservableList<User> list = su.getAll();
       nom.setCellValueFactory(new PropertyValueFactory<User, String>("firstnameU"));
        prénom.setCellValueFactory(new PropertyValueFactory<User, String>("lastnameU"));
       mail.setCellValueFactory(new PropertyValueFactory<User, String>("loginU"));
        mdp.setCellValueFactory(new PropertyValueFactory<User, String>("passwordU"));

      

        
        
        System.out.println(list);
     
        affichage.setItems(list);
     
    }

    @FXML
    private void Supprimer(ActionEvent event) throws IOException {
         User U = affichage.getSelectionModel().getSelectedItem();
    ServiceUser su = new ServiceUser();
    su.Supprimer(U.getId_User());
    JOptionPane.showMessageDialog(null,"Evenement supprimer");
    
    Parent root = FXMLLoader.load(getClass().getResource("../tn.edi.GUI/detail.fxml")) ;
    Scene rcScene= new Scene(root);
    Stage window= (Stage)((Node)event.getSource()) .getScene().getWindow();
    window.setScene(rcScene);
    window.show();
    }

    @FXML
    private void modifier(ActionEvent event) throws IOException {
    
 
        
    
         User U =  affichage.getSelectionModel().getSelectedItem();
           ServiceUser su = new ServiceUser();
           try{
        U.setFirstnameU(nomm.getText());
        U.setLastnameU(prenom.getText());
        U.setLoginU(adresse.getText());
        U.setPasswordU(motdp.getText());
      
           }
           catch(java.lang.NullPointerException x){
           
           }
        su.modifier(U);
        
    Modifier.getScene().getWindow().hide();
               Parent root = FXMLLoader.load(getClass().getResource("detail.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();

                
    }

    @FXML
    private void Deconnect(ActionEvent event) {
        deconnect.getScene().getWindow().hide();
               try{
              Parent root = FXMLLoader.load(getClass().getResource("connexion.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
               } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
    }

    @FXML
    private void reclamAdmin(ActionEvent event) {
    }
   
    }
    

    
    
    
