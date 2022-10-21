/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import tn.liv.esprit.entities.Commande;
import tn.liv.esprit.service.ServiceCommande;

/**
 * FXML Controller class
 *
 * @author Mouthana
 */
public class HomeCommandeController implements Initializable {

    @FXML
    private VBox scroll;
    @FXML
    private Button addbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceCommande sc= new ServiceCommande();
        List<Commande> lc = sc.AfficherCommandes(1);
        Node[] nodes = new Node[lc.size()];
          for (int i = 0; i < nodes.length; i++) {
             FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(NewFXMain.class.getResource("itemListCommande.fxml"));
           try {
               Pane pane = fxmlLoader.load();
               
               
                  ItemListCommandeController ItemController= fxmlLoader.getController();
           
               ItemController.setData(lc.get(i));
               
                scroll.getChildren().add(pane);
               
           } catch (IOException ex) {
             //  Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
           }  
            
        }

        // TODO
    }  
       
    
}
