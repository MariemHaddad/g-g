/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.gg.GUI;

import Email.Sendmail;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.edu.gg.entities.User;
import tn.edu.gg.services.ServiceUser;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class FXMLController implements Initializable {

    @FXML
    private TextField txt_mail;
    @FXML
    private Button validmail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void confirmer(ActionEvent event) throws IOException {

               ServiceUser us = new ServiceUser();
        User u = new User();
        String mail = txt_mail.getText();
        String passwordu = us.getPasswordU(txt_mail.getText());
                u = us.getByMail(mail);
        
       /* if (u == null) {
            JOptionPane.showMessageDialog(null, "Email does not exist");
            txt_mail.setText("");*/
        {

            Sendmail x = new Sendmail();
            String subject = "Reset Password";
            String body = "Votre mot de passe est: " + passwordu;
            x.sendEmail(subject, body, txt_mail.getText());
            Stage stage;
            Parent root = FXMLLoader.load(getClass().getResource("connexion.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);

            stage.setScene(scene);

            stage.show();

        }
    }
}
    
