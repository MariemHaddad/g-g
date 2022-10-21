/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.liv.esprit.entities;

/**
 *
 * @author Mouthana
 */
public class Facture {
    private int idF;
    private int montantF;
    private int commande;
    private String adresse;

    public Facture() {
    }

    public Facture(int idF, int montantF, int commande, String adresse) {
        this.idF = idF;
        this.montantF = montantF;
        this.commande = commande;
        this.adresse = adresse;
    }

    public Facture(int montantF, int commande, String adresse) {
        this.montantF = montantF;
        this.commande = commande;
        this.adresse = adresse;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

   

    public int getIdF() {
        return idF;
    }

    public void setIdF(int idF) {
        this.idF = idF;
    }

    public int getMontantF() {
        return montantF;
    }

    public void setMontantF(int montantF) {
        this.montantF = montantF;
    }

    public int getCommande() {
        return commande;
    }

    public void setCommande(int commande) {
        this.commande = commande;
    }
    @Override
    public String toString() {
       return "id="+idF+"commande="+commande+"montantF="+montantF; 
    }

}
