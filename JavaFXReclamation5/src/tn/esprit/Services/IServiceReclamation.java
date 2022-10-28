/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.Services;


import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Administrateur
 * @param <R>
 */
public interface IServiceReclamation<R> {
 public List<R> AfficherAllReclamationTriéParDate() ;

   public void ajouterReclamation(R r) ;
     public List<R> AfficherAllReclamations() ;
       public void SupprimerReclamation(R r) ;
         public void modifierReclamation(R r)throws SQLException, NoSuchAlgorithmException ;
}
