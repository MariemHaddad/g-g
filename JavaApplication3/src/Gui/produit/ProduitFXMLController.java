/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.produit;

import Entities.Produit;
import Services.ProduitService;
import com.jfoenix.controls.JFXDialog;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author yermani
 */
public class ProduitFXMLController implements Initializable {

    @FXML
    private Button Ajouter;
    @FXML
    private Label nom;
    @FXML
    private TextField tfNom;
    @FXML
    private Label description;
    @FXML
    private TextField tfDesc;
    @FXML
    private Label prix;
    @FXML
    private TextField tfPrix;
    
    private FlowPane flowPane;
    private JFXDialog dialog;
    private StackPane container;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AddP(ActionEvent event) {
         boolean control = true;
        String nom = tfNom.getText();
        String description = tfDesc.getText();
        
        float prix = Float.parseFloat(tfPrix.getText());
        
        
        
        
        if(control == true)
        {
            Produit p = new Produit(nom,description,prix);
            ProduitService ps = new ProduitService();
            boolean test = ps.AjouterProduit(p);
            
            if(test == true)
            {
                tfNom.clear();
               
                tfPrix.clear();
                tfDesc.clear();
                flowPane.getChildren().clear();
            }
    }
    
    }}
