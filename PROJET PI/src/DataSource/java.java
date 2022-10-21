/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataSource;

import java.sql.Connection;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import tn.liv.esprit.entities.Commande;
import tn.liv.esprit.entities.Facture;
import tn.liv.esprit.service.ServiceCommande;
import tn.liv.esprit.service.ServiceFacture;
import tn.liv.esprit.tools.MaConnexion;

/**
 *
 * @author Mouthana
 */
public class java {
    public static void main(String[] args) throws ParseException {
        System.out.println("ok");
        MaConnexion instance = MaConnexion.getInstance();
        Connection cnx = instance.getCnx();
        System.out.println("connextion..."+cnx);
        ServiceFacture sf = new ServiceFacture();
        System.out.println(sf.getAll());
        ServiceCommande sc = new ServiceCommande();
        System.out.println("list by user "+sc.AfficherCommandes(1));
       Commande c1 = new Commande(1,1,450,"10/10/2022");
      sc.AjouterCommande(c1);
     //   System.out.println(sc.AjouterCommande(c1));
      //  Commande cmd = new Commande(1, 1, 15, "tunis"); 
//        sc.AfficherCommandes(1);
sc.SupprimerCommande(1);
    }
    
}
