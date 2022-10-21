/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.gg.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import esprit.gg.entities.EntityReclamation;
import esprit.gg.connection.DataConnexion;

/**
 *
 * @author yassine
 */
public class ReclamService implements IserviceReclam<EntityReclamation> {

    Connection cnx;

    public ReclamService() {
        this.cnx = (Connection) DataConnexion.getInstance().getConnection();
    }

    @Override
    public void ajouter(EntityReclamation r) {
        try {
            String req = "INSERT INTO `reclamation`(`descriptionR`, `auteurR`, `dateR`, `etatR`) VALUES ('" + r.getDescriptionR() + "','" + r.getAuteurR() + "','" + r.getDateR() + "','" + r.getEtatR() + "')";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
            System.out.println("Element **Ajouter** Avec Succes!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void modifier(EntityReclamation r) {

        try {

            String req = "UPDATE reclamation SET " + " idR='" + r.getIdR() + "'"
                    + ",descriptionR='" + r.getDescriptionR() + "'"
                    + ",auteurR='" + r.getAuteurR() + "'" + ",dateR='" + r.getDateR() + "'"
                    + ",etatR='" + r.getEtatR() + "' WHERE idR = " + r.getIdR() + "";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
            System.out.println("Element **Modifier** Avec Succes!!");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void supprimer(int idR) {
        try {
            String req = "DELETE FROM `reclamation` WHERE idR = " + idR;

            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
            System.out.println("Element **Supprimer** Avec Succes!!");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    /*   @Override
    public Reclamation getOne(int idR) {
        try {
             String req ="SELECT * FROM `reclamation` WHERE idR = "+idR;
     
         Statement stm = cnx.createStatement();
         stm.executeUpdate(req);
         stm.last();
         int nbr z
          System.out.println("Element **Supprimer** Avec Succes!!");
         
    } catch (SQLException ex) {
       System.out.println(ex.getMessage());
    }
     */
    @Override
    public List<EntityReclamation> getAll() {
        String req = "SELECT * FROM `reclamation`";
        ArrayList<EntityReclamation> reclamations = new ArrayList();
        Statement stm;
        try {

            stm = this.cnx.createStatement();

            ResultSet rs = stm.executeQuery(req);
            while (rs.next()) {
                EntityReclamation r = new EntityReclamation();

                r.setIdR(rs.getInt(1));
                r.setDescriptionR(rs.getString(2));
                r.setAuteurR(rs.getString(3));
                r.setDateR(rs.getDate(4));
                r.setEtatR(rs.getString(5));

                reclamations.add(r);
            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());

        }
        return reclamations;
    }

    @Override
    public EntityReclamation getOne(EntityReclamation r) {
        
        
        return null;
    }

}
