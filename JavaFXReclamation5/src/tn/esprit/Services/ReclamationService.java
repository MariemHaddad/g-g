/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.Services;

import java.security.NoSuchAlgorithmException;
import tn.esprit.tools.MyDB;
import tn.esprit.entities.Reclamation;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrateur
 */
public class ReclamationService implements IServiceReclamation<Reclamation> {
    Connection connexion;   
  public ReclamationService() {
       this.connexion =(Connection) MyDB.getInstance().getConnection();
    }


 
     
 @Override
  public void ajouterReclamation(Reclamation u)  {
       
        try {
            String req = "INSERT INTO Reclamation(`descriptionR`, `auteurR`, `dateR`, `typeR`, `imgR`) VALUES ('" + u.getDescriptionR() + "','" + u.getAuteurR() + "','" + u.getDateR() + "','" + u.getTypeR()+ "','" + u.getImgR()+ "')";
    
          
       Statement stm =connexion.createStatement();
            stm.executeUpdate(req);
        
         System.out.println("Element **Ajouter** Avec Succes!!");
         } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
  ////////
    
  //////////
  
@Override
     public List<Reclamation> AfficherAllReclamations()  {

        List<Reclamation> rec = new ArrayList<>();
        String req = "SELECT * FROM `reclamation`";
      
        try {
           Statement stm = connexion.createStatement();
       
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            Reclamation u = new Reclamation(rst.getInt("idR")
                  
                   
                    , rst.getString("descriptionR")
                    , rst.getString("auteurR")
                     , rst.getDate("dateR")
                    , rst.getString("typeR")
                     ,rst.getString("imgR"));
            rec.add(u);
        }} catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
 

return rec ;

        }
//      String req = "SELECT * FROM `reclamation`";
//        ArrayList<Reclamation> Reclamations = new ArrayList();
//        Statement stm;
//        try {
//            stm = this.connexion.createStatement();
//            ResultSet rs = stm.executeQuery(req);
//
//            while (rs.next()) {
//                Reclamation c = new Reclamation();
//               c.setIdR(rs.getInt(1));
//                c.setDescriptionR(rs.getString(2));
//                c.setAuteurR(rs.getString(3));
//                c.setDateR(rs.getDate(4));
//                c.setTypeR(rs.getString(5));
//               
//                Reclamations.add(c);
//            }
//
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//
//        return Reclamations;
//     
//     
//     
//     }
//     
  @Override
     public void SupprimerReclamation(Reclamation u) {

       
        try { 
            String req = "DELETE FROM reclamation WHERE idR =?";
            
            PreparedStatement ps = connexion.prepareStatement(req);
            ps.setInt(1, u.getIdR());
            ps.executeUpdate();
             System.out.println("Element **Supprimer** Avec Succes!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
       
      @Override
      public void modifierReclamation(Reclamation u) throws SQLException, NoSuchAlgorithmException {
     
      
               String req = "UPDATE reclamation SET "
              + " descriptionR='"+u.getDescriptionR()+"'"
                 + ", auteurR='"+u.getAuteurR()+"'"
                 + ", dateR='"+u.getDateR()+"'"
                 + ", typeR='"+u.getTypeR()+"' "
                       + ", imgR='"+u.getImgR()+"'where idR= "+u.getIdR()+"";
        Statement stm = connexion.createStatement();
       
        stm.executeUpdate(req);
        System.out.println("Element **Modifier** Avec Succes!!");
         
    } 
      
   
     
     
            
             
      @Override  
   public List<Reclamation> AfficherAllReclamationTriéParDate()  {

        List<Reclamation> rec = new ArrayList<>();
        String req = "select * from reclamation order by date ";
        Statement stm;
        try {
            stm = connexion.createStatement();
       
        ResultSet rst = stm.executeQuery(req);

         while (rst.next()) {
            Reclamation u = new Reclamation(rst.getInt("id")
                
                    , rst.getString("descriptionR")
                    , rst.getString("auteurR")
                    , rst.getDate("dateR")
                    , rst.getString("typeR")
                     ,rst.getString("imgR"));
            rec.add(u);
         }
             } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return rec;
    }
   
   /*
   @Override
   public List<Utilisateur> RechercherUsersParNom(String Nom) throws SQLException {
   List<Utilisateur> users = new ArrayList<>();
            String req = "select  * from  utilisateur u  where u.nom LIKE'" + Nom + "'";
            Statement stm = connexion.createStatement();
            ResultSet rst = stm.executeQuery(req);
            while (rst.next()) {
                  Utilisateur u = new Utilisateur(rst.getInt("id")
                    , rst.getString("nom")
                    , rst.getInt("telephone")
                    , rst.getString("email")
                    , rst.getString("password")
                    , rst.getString("usertype"));
               users.add(u);
            }
     return users;
   
    }*/
   
 

   /*   @Override
   public int nbUsersParRole(String Genre) throws SQLException{
       List<Utilisateur> users = new ArrayList<>();
            String req = "select  * from  utilisateur u  where u.usertype LIKE'" + Genre + "'";
            Statement stm = connexion.createStatement();
            ResultSet rst = stm.executeQuery(req);
            while (rst.next()) {
                  Utilisateur u = new Utilisateur(rst.getInt("id")
                    , rst.getString("nom")
                    , rst.getInt("telephone")
                    , rst.getString("email")
                    , rst.getString("password")
                    , rst.getString("usertype"));
               users.add(u);
            }
     return users.size();
   }
*/  
}
