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
public class Livreur extends User {
    private String disponibilités;
    private String point_de_départ;
    private User user;  
    public Livreur() {
        
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Livreur(String disponibilités, String point_de_départ) {
        this.disponibilités = disponibilités;
        this.point_de_départ = point_de_départ;
    }
   
    public Livreur(String disponibilités, String point_de_départ,String firstnameU,String lastnameU, String passwordU, String loginU, String Role, String adresse) {
        super(firstnameU, lastnameU, passwordU, loginU, Role, adresse);
        this.disponibilités = disponibilités;
        this.point_de_départ = point_de_départ;
    }

    public Livreur(String disponibilités, String point_de_départ, int id_User, String firstnameU, String lastnameU, String passwordU, String loginU, String Role, String adresse) {
        super(id_User, firstnameU, lastnameU, passwordU, loginU, Role, adresse );
        this.disponibilités = disponibilités;
        this.point_de_départ = point_de_départ;
    }

    public String getdisponibilités() {
        return  disponibilités;
    }

    public String getpoint_de_départ() {
        return point_de_départ;
    }

    public void setdisponibilités(String disponibilités) {
        this.disponibilités = disponibilités;
    }

    public void setpoint_de_départ(String point_de_départ) {
        this.point_de_départ = point_de_départ;
    }

    @Override
    public String toString() {
        return "Livreur : " + user + "\n disponibilités : " + disponibilités + "\n point_de_départ : " + point_de_départ;
    }  

}

