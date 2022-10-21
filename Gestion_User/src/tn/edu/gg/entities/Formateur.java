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
public class Formateur extends User {
    private String charge_horaire;
    private String salaire;
    private String département;
    private User user;  
    public Formateur() {
        
    }

 

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

  

    public Formateur(String firstnameU, String lastnameU, String passwordU, String LoginU, String Role, String adresse,String charge_horaire, String salaire, String département) {
        super(firstnameU, lastnameU, passwordU, LoginU, Role, adresse);
        this.charge_horaire = charge_horaire;
        this.salaire = salaire;
        this.département = département;
    }

    public Formateur( int id_User, String firstnameU, String lastnameU, String passwordU, String loginU, String Role, String adresse,String charge_horaire, String salaire,String département) {
        super(id_User, firstnameU, lastnameU, passwordU, loginU, Role,adresse);
        this.charge_horaire = charge_horaire;
        this.salaire = salaire;
        this.département = département;
    }

    public String getcharge_horaire() {
        return  charge_horaire;
    }

    public String getsalaire() {
        return salaire;
    }
    public String getdépartement() {
        return département;
    }
    public void setcharge_horaire(String charge_horaire) {
        this.charge_horaire = charge_horaire;
    }

    public void setsalaire(String salaire) {
        this.salaire = salaire;
    }
    public void setdépartement(String département) {
        this.département = département;
    }
    @Override
    public String toString() {
        return "Formateur : " + user + "\n charge_horaire : " + charge_horaire + "\n salaire : " + salaire +"\n département : " + département;
    }  

}
    
