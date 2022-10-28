/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author yermani
 */
public class Stock {
     private int idS,produit_id ;
    private String emplacement;
     private String Reference ;
     private int nbreProdEnstock ;

    public Stock(int idS, int produit_id, String emplacement, String Reference , int nbreProdEnstock) {
        this.idS = idS;
        this.produit_id = produit_id;
        this.emplacement = emplacement;
        this.Reference = Reference;
        this.nbreProdEnstock = nbreProdEnstock;
    }

    public Stock(int produit_id, String emplacement, String Reference , int nbreProdEnstock) {
        this.produit_id = produit_id;
        this.emplacement = emplacement;
        this.Reference = Reference;
        this.nbreProdEnstock = nbreProdEnstock;
    }

    public Stock() {
         this.produit_id = produit_id;
        this.emplacement = emplacement;
        this.Reference = Reference;
        this.nbreProdEnstock = nbreProdEnstock;
    }

    

  

    public int getIdS() {
        return idS;
    }

    public void setIdS(int idS) {
        this.idS = idS;
    }

    public int getProduit_id() {
        return produit_id;
    }

    public void setProduit_id(int produit_id) {
        this.produit_id = produit_id;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement =emplacement;
    }

    public String getReference() {
        return Reference;
    }

    public void setReference(String Reference) {
        this.Reference = Reference;
    }

    public int getNbreProdEnstock() {
        return nbreProdEnstock;
    }

    public void setNbreProdEnstock(int nbreProdEnstock) {
        this.nbreProdEnstock = nbreProdEnstock;
    }

   
   

}