/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopjdbc;

import java.text.ParseException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tn.edu.gg.entities.User;
import tn.edu.gg.entities.Etudiant;
import tn.edu.gg.entities.Formateur;
import tn.edu.gg.services.ServiceUser;
import tn.edu.gg.tools.DataSource;

/**
 *
 * @author chalg
 */
public class WorkshopJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DataSource.getInstance();
        ServiceUser su = new ServiceUser ();
        User U = new User (10,"Mariem","Haddad","mariem.haddad@esprit.tn","Zumruduanka2022","Etudiant","Tunis");
        User U1 = new User ("Zaineb","gueddiche","abc","zaineb@gmail.com","Formateur","Nabeul");
        User U2 = new User ("Mariem","Haddad","Zumruduanka","mariem.haddad@esprit.tn","Formateur","Tunis");
        //su.ajouter (U1);
        //su.supprimer(12);
        User B = new User (10,"Mariem","Haddad","mariem.haddad@esprit.tn","Zumruduanka","Admin","Tunis");
        Formateur F = new Formateur ("zaineb","gueddiche","abc","zaineb@gmail.com","Formateur","nabeul","3Heures","500dt","coiffure");       
        //su.ajouterF (F);
        User E = new User (14, "hafedh", "haddad", "haddadmariem32@gmail.com", "222", "Etudiant","Sousse");
        //su.modifier(E);
        //su.getAll();
        //su.getone();
    }
    
    
}
