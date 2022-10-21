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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import tn.edu.gg.entities.Etudiant;
import tn.edu.gg.entities.Formateur;
import tn.edu.gg.entities.Livreur;
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
    private TableColumn<User, String> role;
    @FXML
    private TableColumn<Formateur, String> chrgeho;
    @FXML
    private TableColumn<User, String> adresse;

    @FXML
    private TableColumn<User, String> niveaux;
    @FXML
    private TableColumn<User, String> salaire;
    @FXML
    private TableColumn<User, String> départe;
    @FXML
    private TableColumn<User, String> disponi;
    @FXML
    private TableColumn<User, String> ptdep;
    @FXML
    private TableColumn<User, String> badge;
@Override
    public void initialize(URL url, ResourceBundle rb) {
       Connection cnx = DataSource.getInstance().getConnection();
        ServiceUser su = new ServiceUser();
     
                 ObservableList<User> list = su.getAll();
ObservableList<Etudiant> Etudiant = su.getAllE();
ObservableList<Formateur> Formateur = su.getAllF();
       nom.setCellValueFactory(new PropertyValueFactory<User, String>("firstnameU"));
        prénom.setCellValueFactory(new PropertyValueFactory<User, String>("lastnameU"));
       mail.setCellValueFactory(new PropertyValueFactory<User, String>("loginU"));
        mdp.setCellValueFactory(new PropertyValueFactory<User, String>("passwordU"));
        role.setCellValueFactory(new PropertyValueFactory<User, String>("Role"));
        chrgeho.setCellValueFactory(new PropertyValueFactory<Formateur, String>("charge_horaire"));
        adresse.setCellValueFactory(new PropertyValueFactory<User, String>("adresse"));
        niveaux.setCellValueFactory(new PropertyValueFactory<User, String>("niveaux"));
        salaire.setCellValueFactory(new PropertyValueFactory<User, String>("salaire"));
        départe.setCellValueFactory(new PropertyValueFactory<User, String>("département"));
        disponi.setCellValueFactory(new PropertyValueFactory<User, String>("disponibilités"));
        ptdep.setCellValueFactory(new PropertyValueFactory<User, String>("point_de_départ"));
        badge.setCellValueFactory(new PropertyValueFactory<User, String>("badge"));
        
        
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
    }
