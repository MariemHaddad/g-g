/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Produit;

import Entities.Produit;
import Entities.Stock;
import Services.StockService;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author yermani
 */
public class StockFXMLController implements Initializable {
List<Stock> lists = new ArrayList();
    StockService SS=new StockService();
    @FXML
    private Button modifierS;
    @FXML
    private Button supprimerS;
    @FXML
    private TextField txtpid;
    @FXML
    private TextField txtemp;
    @FXML
    private TextField txtref;
    @FXML
    private TextField txtnbreps;
    @FXML
    private Button btnajouterS;
    @FXML
    private TableView<Stock> tableS;
    @FXML
    private TableColumn<Stock, Integer> pid;
    @FXML
    private TableColumn<Stock, String> emp;
    @FXML
    private TableColumn<Stock, String> ref;
    @FXML
    private TableColumn<Stock, Integer> nbrps;
    
    public  ObservableList<Stock> list = FXCollections.observableArrayList();
  
    
     Connection con;
    PreparedStatement pst;
    int MyIndex;
    int idS;
    
    
    public void Connect() throws SQLException {
        try{
            Class.forName("com.mysql.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/yermeni1","root","");
        }catch (ClassNotFoundException ex) {
    }catch (SQLException ex){
        ex.printStackTrace();}}

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            // TODO
            Connect();
        } catch (SQLException ex) {
            Logger.getLogger(StockFXMLController.class.getName()).log(Level.SEVERE, null, ex);
     
 }LoadTable() ;  
        // TODO
    }    
    
     @FXML
    private void Ajouter(ActionEvent event) {
          
        Stock s=new Stock(Integer.parseInt(txtpid.getText()), txtemp.getText(),txtref.getText(),Integer.parseInt(txtnbreps.getText()));
       SS.AjouterStock(s);
        System.out.println("Ajoutée avec SUCCEESS");
        LoadTable();
    }
    
   /*private void modifier(ActionEvent event) throws IOException {
    
 
        
    
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
        su.modifier(U);*/
    

    @FXML
    private void Modifier(ActionEvent event)   { 
       
  Stock a = tableS.getSelectionModel().getSelectedItem();
      
      
       a.setProduit_id(Integer.parseInt(txtpid.getText()));
        a.setEmplacement(txtemp.getText());
      
       a.setReference(txtref.getText());
       a.setNbreProdEnstock(Integer.parseInt(txtnbreps.getText()));
      
        SS.ModifierStock(a);

     

    
        System.out.println("modifiee avec SUCCEESS");
         LoadTable();
    
    }
     @FXML
    private void handleMouseAction(ContextMenuEvent event) {
        Stock s = tableS.getSelectionModel().getSelectedItem();
        
         txtpid.setText(""+s.getProduit_id());
        txtemp.setText(s.getEmplacement());
        txtref.setText(s.getReference());
        txtnbreps.setText(""+s.getNbreProdEnstock());}
    

   

    @FXML
    private void supprimer(ActionEvent event) {
        Stock  s = tableS.getSelectionModel().getSelectedItem();
        
         SS.SupprimerStock(s.getIdS());
        
       
   
    LoadTable();
    }
    
   
    void LoadTable()
    {
        
        
                lists =   SS.getall();
      ObservableList<Stock> lists = FXCollections.observableArrayList(this.lists);
   
         pid.setCellValueFactory(new PropertyValueFactory ("produit_id"));
        emp.setCellValueFactory(new PropertyValueFactory("emplacement")); 
         ref.setCellValueFactory(new PropertyValueFactory("reference"));
           nbrps.setCellValueFactory(new PropertyValueFactory("nbreProdEnstock"));
             
            
        tableS.setItems(lists);
    }

    @FXML
    private void handleMouseAction(MouseEvent event) {
        Stock s = tableS.getSelectionModel().getSelectedItem();
         
         txtpid.setText(""+s.getProduit_id());
        txtemp.setText(""+s.getEmplacement());
        txtref.setText(""+s.getReference());
        txtnbreps.setText(""+s.getNbreProdEnstock());
    }
    
    
    
   
}

