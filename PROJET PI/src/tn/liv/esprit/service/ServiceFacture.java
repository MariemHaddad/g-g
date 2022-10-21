/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.liv.esprit.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.input.KeyCode.F;
import javax.activation.DataSource;
import tn.liv.esprit.entities.Facture;
import tn.liv.esprit.tools.MaConnexion;
import tn.liv.esprit.Iservice.IserviceFacture;

public class ServiceFacture implements IserviceFacture<Facture> 
{
MaConnexion instance = MaConnexion.getInstance();
   Connection cnx = instance.getCnx();

    @Override
    public boolean AjouterFacture(Facture f) {
        try {
            String req = "INSERT INTO facture ( `montantF`, `idCommande`,Adresse`) VALUES (?, ?, ?)";
            PreparedStatement pstm = cnx.prepareStatement(req);
            pstm.setInt(1, f.getMontantF());
            pstm.setInt(2, f.getCommande());
            pstm.setString(3, f.getAdresse());
            
         //   pstm.setString(4, c.getAdresse());
            pstm.executeUpdate();

            System.out.println("Facture Ajouté");
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ServiceFacture.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur d'ajout facture");
            return false;
        }
    }

    @Override
    public boolean Modifierfacture(Facture f) {
        

        try {
            String req = "UPDATE commande SET  idF=? , montantF=?,idCommande=? WHERE idf=?";
            PreparedStatement pstm = cnx.prepareStatement(req);
            
            pstm.setInt(1, f.getIdF());
            pstm.setInt(2, f.getMontantF());
            pstm.setInt(3, f.getCommande());
            pstm.executeUpdate();

            System.out.println("Facture Modifié");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCommande.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur de modification Facture");
            return false;
        }   
    }

    @Override
    public boolean SupprimerFacture(int idF) {
        try {
            String req = "DELETE FROM `commande` WHERE idF  = " + idF  + "";
            PreparedStatement pstm = cnx.prepareStatement(req);
            pstm.executeUpdate();
            System.out.println("Facture Supprimé");
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur de supression du facture"+ex);
        }
        return false;    }
      @Override
    public List<Facture> getAll() {
        
        ArrayList<Facture> factures = new ArrayList();
       
        try {
            Statement st = cnx.createStatement();
            String req = "SELECT * FROM facture";
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
             factures.add(new Facture(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString("Adresse")));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return factures;
    }
    }


