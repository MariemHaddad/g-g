/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.gg.entities;

/**
 *
 * @author lenovo
 */
public class Etudiant extends User {
    private String niveaux;
    private String badge;
    private User user;  
    public Etudiant() {
        
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public Etudiant(String niveaux, String badge) {
        this.niveaux = niveaux;
        this.badge = badge;
    }

    public Etudiant(String firstnameU, String lastnameU, String passwordU, String LoginU, String Role, String adresse,String niveaux, String badge) {
        super(firstnameU, lastnameU, passwordU, LoginU, Role, adresse);
        this.niveaux = niveaux;
        this.badge = badge;
            }

    public Etudiant(int id_User, String firstnameU, String lastnameU, String passwordU, String loginU, String Role, String adresse,String niveaux,String badge) {
        super(id_User, firstnameU, lastnameU, passwordU, loginU, Role, adresse);
        this.niveaux = niveaux;
        this.badge = badge;
    }

    public String getniveaux() {
        return  niveaux;
    }

    

    public void setniveaux(String niveaux) {
        this.niveaux = niveaux;
    }

   public String getbadge() {
        return  badge;
    }

    

    public void setbadge(String badge) {
        this.badge = badge;
    }

    @Override
    public String toString() {
        return "Etudiant : " + user + "\n niveaux : " + niveaux +"\n badge:" +badge ;
    }  

}


