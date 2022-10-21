/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import tn.liv.esprit.entities.Commande;

/**
 * FXML Controller class
 *
 * @author Mouthana
 */
public class ItemListCommandeController implements Initializable {

    @FXML
    private Label date;
    @FXML
    private Label montant;
    @FXML
    private Label user_id;
    @FXML
    private Label idp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setData(Commande c ){
        date.setText(String.valueOf(c.getDateCommande()));
        montant.setText(String.valueOf(c.getMontant()));
        user_id.setText(String.valueOf(c.getId_user()));
        idp.setText(String.valueOf(c.getIdP()));
        
    }
}
