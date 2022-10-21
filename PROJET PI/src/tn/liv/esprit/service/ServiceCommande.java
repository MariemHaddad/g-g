package tn.liv.esprit.service;

import tn.liv.esprit.entities.Commande;
import tn.liv.esprit.entities.Facture;
import tn.liv.esprit.Iservice.IserviceCommande;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tn.liv.esprit.tools.MaConnexion;

public class ServiceCommande implements IserviceCommande {

    MaConnexion instance = MaConnexion.getInstance();
   Connection cnx = instance.getCnx();
    public ServiceCommande() {
        MaConnexion instance = MaConnexion.getInstance();
        Connection con = instance.getCnx();
    }

    @Override
    public boolean AjouterCommande(Commande c) {
        try {
            String req = "INSERT INTO commande (`id_user`, `idP`, `montant`, `dateCommande`) VALUES (?, ?, ?, ?)";
            PreparedStatement pstm = cnx.prepareStatement(req);
            pstm.setInt(1, c.getId_user());
            pstm.setInt(2, c.getIdP());
            pstm.setInt(3, c.getMontant());
            pstm.setString(4,c.getDateCommande());
            
         //   pstm.setString(4, c.getAdresse());
            pstm.executeUpdate();

            System.out.println("Commande Ajouté");
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ServiceFacture.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur d'ajout du commande");
            return false;
        }

    }

    @Override
    public boolean ModifierCommande(Commande c) {

        try {
            String req = "UPDATE commande SET  user_id=? , idP=? , montant=? ,dateCommande=? , WHERE idCommande=?";
            PreparedStatement pstm = cnx.prepareStatement(req);
            pstm.setInt(1, c.getId_user());
            pstm.setInt(2, c.getIdP());
            pstm.setInt(3, c.getMontant());
            pstm.setString(4, c.getDateCommande());
            pstm.setInt(5, c.getIdCommande());
            pstm.executeUpdate();

            System.out.println("Commande Modifié");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCommande.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur de modification du commande");
            return false;
        }


    }

    @Override
    public boolean SupprimerCommande(int idCommande ) {
        try {
            String req = "DELETE FROM `commande` WHERE idCommande  = " + idCommande  + "";
            PreparedStatement pstm = cnx.prepareStatement(req);
            pstm.executeUpdate();
            System.out.println("Commande Supprimé");
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur de supression du commande"+ex);
        }
        return false;

    }

    @Override
    public List<Commande> AfficherCommandes() {
        List<Commande> commandes = new ArrayList();
        try {
            String req = "SELECT * FROM commande";
            PreparedStatement pstm = cnx.prepareStatement(req);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Commande c = new Commande();
                c.setIdCommande (rs.getInt("idCommande"));
                c.setId_user(rs.getInt("id_user"));
                c.setIdP(rs.getInt("idP"));
                c.setMontant(rs.getInt("montant"));
                c.setDateCommande(rs.getString("dateCommande"));
               

                commandes.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCommande.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur d'affichage des commandes");
        }
        return commandes;

    }

    @Override
    public Commande RecupererCommande(int idCommande) {
        
        Commande c = new Commande();
        try {
            String req = "SELECT * FROM commande WHERE idCommande=\""+idCommande+"\";";
            PreparedStatement pstm = cnx.prepareStatement(req);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                c.setIdCommande (rs.getInt("idCommande"));
                c.setId_user(rs.getInt("id_user"));
                c.setIdP(rs.getInt("idP"));
                c.setMontant(rs.getInt("montant"));
                c.setDateCommande(rs.getString("dateCommande"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCommande.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur de récuperation");
        }
        return c;

    }

    @Override
    public List<Commande> AfficherCommandes(int idUser) {
        List<Commande> commandes = new ArrayList();
        
        try {
            String req = "SELECT * FROM commande WHERE id_user = " + idUser + "";
            PreparedStatement pstm = cnx.prepareStatement(req);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Commande c = new Commande();
               c.setIdCommande (rs.getInt("idCommande"));
                c.setId_user(rs.getInt("id_user"));
                c.setIdP(rs.getInt("idP"));
                c.setMontant(rs.getInt("montant"));
                c.setDateCommande(rs.getString("dateCommande"));

                commandes.add(c);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCommande.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur d'affichage des commandes");
        }
                return commandes;
    }
    
}
