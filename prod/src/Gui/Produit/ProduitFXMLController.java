/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Produit;

import Entities.Produit;
import Services.ProduitService;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import java.util.ResourceBundle;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.ContextMenuEvent;


/**
 * FXML Controller class
 *
 * @author yermani
 */


public class ProduitFXMLController implements Initializable {
    
   
    
    
    List<Produit> list = new ArrayList();
    ProduitService ps=new ProduitService();
    @FXML
    private Button btnAjouter;

    @FXML
    private Button btnModifier;

    @FXML
    private Button btnSupprimer;

    @FXML
    private TableColumn<Produit, String> descriptioncolomn;

    @FXML
    private TableColumn<Produit, Integer> idcolomn;

    @FXML
    private TableColumn<Produit, String> nomcolomn;

    @FXML
    private TableColumn<Produit, String> photocolomn;

    private ImageView photoview;

    @FXML
    private TableColumn<Produit, Float> prixcolomn;

    @FXML
    private TableView<Produit> table;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtNom;

    @FXML
    private TextField txtPrix;
    
    @FXML
    private TextField txtPhoto;
    
     
    
    ProduitService SP=new ProduitService();
    
     Connection con;
    PreparedStatement pst;
    int MyIndex;
    int id;
    
    public void Connect() throws SQLException {
        try{
            Class.forName("com.mysql.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/yermeni1","root","");
        }catch (ClassNotFoundException ex) {
    }catch (SQLException ex){
        ex.printStackTrace();
   
        }}

    @FXML
    void Ajouter (ActionEvent event)  {
       
       System.out.println(txtNom.getText());
        Produit c=new Produit( txtNom.getText(), txtDescription.getText(), Float.parseFloat(txtPrix.getText()),txtPhoto.getText());
        SP.AjouterProduit(c);
        System.out.println("Ajoutée avec SUCCEESS");
        LoadTable();
    }
    
    

    
    @FXML
    void Modifier(ActionEvent event) {
        
  Produit a = table.getSelectionModel().getSelectedItem();
      
      
       a.setNom(txtNom.getText());
        a.setDescription(txtDescription.getText());
       a.setPrix (Float.parseFloat(txtPrix.getText()));
       a.setPhoto(txtPhoto.getText());
       
      
        SP.ModifierProduit(a);

      LoadTable();

    
        System.out.println("modifiee avec SUCCEESS");
         LoadTable();
        
    }

    @FXML
    void Supprimer(ActionEvent event) {
     
        Produit  p = table.getSelectionModel().getSelectedItem();
        
         SP.SupprimerProduit(p.getId());
        
       
   
    LoadTable();

            }
     void handleMouseAction(MouseEvent event) {
  Produit p = table.getSelectionModel().getSelectedItem();
         idcolomn.setText(""+p.getId());
        nomcolomn.setText(p.getNom());
        descriptioncolomn.setText(p.getDescription());
        prixcolomn.setText(""+p.getPrix());
        photocolomn.setText(p.getPhoto());
       
         
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LoadTable(); 
 try {
            // TODO
            Connect();
        } catch (SQLException ex) {
            Logger.getLogger(ProduitFXMLController.class.getName()).log(Level.SEVERE, null, ex);
       }
 
    }
        
    
  
    /**
     * Initializes the controller class.
     */
      

    void LoadTable()
    {
        
        
                list = SP.getall();
      ObservableList<Produit> list =  FXCollections.observableArrayList(this.list);
   
        nomcolomn.setCellValueFactory(new PropertyValueFactory<Produit , String>("nom"));
        descriptioncolomn.setCellValueFactory(new PropertyValueFactory<Produit , String>("description")); 
        prixcolomn.setCellValueFactory(new PropertyValueFactory<Produit , Float>("prix"));
          photocolomn.setCellValueFactory(new PropertyValueFactory<Produit , String>("photo"));
             
            
        table.setItems(list);
    }

 
   @FXML
    private void handleMouseAction(ContextMenuEvent event) {
         Produit p = table.getSelectionModel().getSelectedItem();
         
        txtNom.setText(p.getNom());
        txtDescription.setText(p.getDescription());
        txtPrix.setText(""+p.getPrix());
       txtPhoto.setText(p.getPhoto());
    }

    @FXML
    private void handleMouseAction(javafx.scene.input.MouseEvent event) {
          Produit p = table.getSelectionModel().getSelectedItem();
         
        txtNom.setText(p.getNom());
        txtDescription.setText(p.getDescription());
        txtPrix.setText(""+p.getPrix());
       txtPhoto.setText(p.getPhoto());
    }
  
    }
       
      
       

    
    
    
    

    
   
    
    

