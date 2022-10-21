package Entities;

import javafx.scene.control.Label;

/**
 *
 * @author Khairi
 */
public class Produit {

    private int id;
    private String nom;
    private String description;
    private float prix;
    private String photo;

    public Produit() {
    }

    public Produit(int id, String nom , String description, float prix, String photo) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.photo = photo;
    }
    public Produit(int id, String nom) {
        this.id = id;
        this.nom = nom;
       
        
    }
    public Produit( String nom) {
        this.nom = nom;
      
        
    }

    public Produit(String nom, String description, float prix, String photo) {
        this.nom = nom;
        this.description=description;
        this.prix = prix;
        this.photo = photo;
    }
      public Produit(String nom, String description, float prix) {
        this.nom = nom;
        this.description=description;
        this.prix = prix;
        
    }
     public Produit(String nom, float prix, String photo) {
        this.nom = nom;
    
        this.prix = prix;
        this.photo = photo;
    }

   
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", nom=" + nom +  ", description=" + description + ", prix=" + prix + ", photo=" + photo + '}';
    }


}
