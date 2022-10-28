/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author yermani
 */
public class Produit {

  
    
    private Integer id;
    private String nom;
    private String description;
    private Float prix;
    private String photo;

    public Produit(Integer id, String nom, String description, Float prix,String photo) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.photo = photo;
    }

    
  

    public Produit(String nom, String description, Float prix, String photo) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.photo = photo;
    }

    public Produit() {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.photo = photo;
    }

    
   

   

    

    

   

   

    

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public Float getPrix() {
        return prix;
    }

    public String getPhoto() {
        return photo;
    }

    public void setId(int id) {
        this.id = id;
      
    }

  
    
   
}
