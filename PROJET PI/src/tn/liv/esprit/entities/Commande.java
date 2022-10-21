package tn.liv.esprit.entities;

import java.sql.Date;

/**
 *
 * @author Khairi
 */
public class Commande {

    private int idCommande;
    private int id_user;
    private int idP;
    private String dateCommande;
    private int montant;

    public Commande() {
    }

    public Commande(int idCommande, int id_user, int idP, String dateCommande, int montant) {
        this.idCommande = idCommande;
        this.id_user = id_user;
        this.idP = idP;
        this.dateCommande = dateCommande;
        this.montant = montant;
    }

    public Commande(int id_user, int idP, int montant,String dateCommande) {
        this.id_user = id_user;
        this.idP = idP;
        this.dateCommande = dateCommande;
        this.montant = montant;
    }
    

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public String getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(String dateCommande) {
        this.dateCommande = dateCommande;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    @Override
    public String toString() {
        return "Commande{" + "idCommande=" + idCommande + ", id_user=" + id_user + ", idP=" + idP + ", dateCommande=" + dateCommande + ", montant=" + montant + '}';
    }
    
}
