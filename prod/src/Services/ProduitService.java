/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Produit;
import Iservices.IServiceProduit;
import Utils.MyDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yermani
 */
public class ProduitService implements IServiceProduit {
    Connection con;
    Statement stm;

    public ProduitService() {
        con = MyDB.getInstance().getCon();}

    @Override
    public void AjouterProduit(Produit produit) {
      try {
            String req = "INSERT INTO `produit` (`nom`, `description`, `prix`,`photo`) VALUES (?,?,?,?)";
            PreparedStatement pstm = con.prepareStatement(req);
            pstm.setString(1, produit.getNom());
            pstm.setString(2, produit.getDescription());
            pstm.setFloat(3, produit.getPrix());
            pstm.setString(4, produit.getPhoto());
           
            pstm.executeUpdate();

            System.out.println("Produit Ajouté");
           

        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur d'ajout du produit");
            
        }

    }

    

    @Override
    public void ModifierProduit(Produit produit) {
          try {
     
 String req ="UPDATE produit SET nom='"+produit.getNom()+"'"
         
         +",description='"+produit.getDescription()+"'"+",prix='"+produit.getPrix()+"'"
         +",photo='"+produit.getPhoto()+"' WHERE id = "+produit.getId()+"";
         Statement stm = con.createStatement();
         stm.executeUpdate(req);
         
         System.out.println("Element **Modifier** Avec Succes!!");
         
    } catch (SQLException ex) {
       System.out.println(ex.getMessage());
    }
          }
    
    

    @Override
    public void SupprimerProduit(int id) {
        try {
            String req = "DELETE FROM `produit` WHERE id = " + id + "";
            PreparedStatement pstm = con.prepareStatement(req);
            pstm.executeUpdate();
            System.out.println("Produit Supprimé");
            
        } catch (SQLException ex) {
            System.out.println("Erreur de supression");
        }
    }
    
    @Override
    public List<Produit> AfficherProduit() {
        ArrayList<Produit> produits = new ArrayList();
        try {
            String req = "SELECT * FROM produit";
            PreparedStatement pstm = con.prepareStatement(req);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Produit produit = new Produit();
                produit.setId(rs.getInt("id"));
                produit.setNom(rs.getString("nom"));
                produit.setDescription(rs.getString("description"));
                produit.setPrix(rs.getFloat("prix"));
                produit.setPhoto(rs.getString("photo"));

               produits.add(produit);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur d'affichage des produits");
        }
        return produits;
    
}

   

    @Override
    public List<Produit> getall() {
        String rep = "SELECT * FROM `produit`";
        ArrayList<Produit> produit = new ArrayList();
        Statement stm;
        try {
            stm = this.con.createStatement();
            ResultSet rs = stm.executeQuery(rep);

            while (rs.next()) {
                Produit p = new Produit();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setDescription(rs.getString(3));
                p.setPrix(rs.getFloat(4));
               p.setPhoto(rs.getString(5));
                
                produit.add(p);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return produit;
    }

    }

