/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.Services;

import java.sql.Date;
import java.time.LocalDate;


import tn.esprit.entities.Reclamation;
import tn.esprit.tools.MyDB;

/**
 *
 * @author yassine
 */
public class EtudeReclamation {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
    MyDB.getInstance();
   ReclamationService rs= new ReclamationService();
    
  
    // teste Ajout
//   Reclamation r  = new Reclamation( "reclamation2222 ","an other222",new Date(21,01,2020),  "traite");
//      rs.ajouter(r);
//   
   
   //test Modfier
 // Reclamation r  = new Reclamation( 5,"reclamation service","yass",new Date(11,11,2050),  "EN COURS");
  // rs.modifierReclamation(r);
   
   
   //test Supprimer
  //Reclamation r = (1,"reclamationproduit3","yassine3",(11,11,2020),"EN COURS");
  //  rs.supprimerReclamation(5) ;
   
  
   
   // Test getAllRecl()
   System.out.println(rs.AfficherAllReclamations());
    /* ps.ModifierP(2,"yaaas","ghhhh" );*/
    
    
    
    //Ajouter categorieReclmation
   // CategorieReclam cr = new CategorieReclam("technique","ceci la reclam 12");
   // rs.ajouterCatR(cr);
   
   
   //Modifier   categorieReclmation
 //  CategorieReclam cr = new CategorieReclam(1,"service 1.1","ceci la reclam 1.0");
  // rs.modifierCatR(cr);
    
   
   //test getAllCatR()
 //  System.out.println(rs.getAllCatR());
   }
    }                                                 
    


