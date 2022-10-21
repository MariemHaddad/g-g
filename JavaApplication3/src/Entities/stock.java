/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author ASUS
 */
public class stock {
    private int id,produit_id ;
    private String emplacemanet;

    public stock(){}
   public stock(int id, int produit_idP, String emplacemanet) {
        this.id = id;
        this.produit_id = produit_id;
        this.emplacemanet = emplacemanet;
        
       
    }
   
    public stock(int produit_id, String emplacemanet) {
        this.produit_id = produit_id;
        this.emplacemanet = emplacemanet;
        
        
    }
    

   
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
   public int getProduit_id() {
        return produit_id;
    }

    public void setProduit_id(int produit_id) {
        this.produit_id = produit_id;
    }

    @Override
    public String toString() {
        return "stock{" + "id=" + id + ", produit_id=" + produit_id + ", emplacement=" + emplacemanet + '}';
    }
    
    public String getEmplacement() {
        return emplacemanet;
    }

    public void setEmplacement(String emplacemanet) {
        this.emplacemanet = emplacemanet;
    } 

   
    
    
}
