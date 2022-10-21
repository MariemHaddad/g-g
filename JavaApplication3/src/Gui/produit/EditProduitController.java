/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.produit;

import Entities.Produit;
import Services.ProduitService;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author yermani
 */
public class EditProduitController implements Initializable { 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     public class EditProduitController implements Initializable { 
    @FXML
    private Button closeButton;
    @FXML
    private JFXTextField tfNom;
    @FXML
    private JFXTextField tfDescription;
    @FXML
    private JFXTextField tfPrix;
    
    
    private int ProduitId;
    private FlowPane flowPane;
    private JFXDialog dialog;
    private StackPane container;  // TODO
     
