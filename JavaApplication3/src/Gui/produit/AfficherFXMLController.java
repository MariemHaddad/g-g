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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author yermani
 */
public class AfficherFXMLController implements Initializable {

    @FXML
    private TableView<Produit> tfView;
    @FXML
    private TableColumn<Produit, String> tfNom;
    @FXML
    private TableColumn<Produit, String> tfDesc;
    @FXML
    private TableColumn<Produit, Float> tfPrix;
    @FXML
    private Button A;
    
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void A(ActionEvent event) {
         ProduitService sc= new ProduitService();
        List<Produit> lc = sc.AfficherProduits();
        tfNom.setCellValueFactory(new PropertyValueFactory<Produit,String>("nom"));
         tfDesc.setCellValueFactory(new PropertyValueFactory<Produit,String>("description"));
          tfPrix.setCellValueFactory(new PropertyValueFactory<Produit,Float>("prix"));
         
               
        }
    
}


