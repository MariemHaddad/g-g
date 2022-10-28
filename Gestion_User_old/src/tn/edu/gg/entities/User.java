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
public class User {
    protected int id_User ;
    protected String firstnameU ;
    protected String lastnameU ;
     protected String loginU;
    protected String passwordU;
    
    protected String Role;
    protected String adresse;

    public User (){
    }

    public User(String firstnameU, String lastnameU,  String LoginU,String passwordU, String Role, String adresse) {
        this.firstnameU = firstnameU;
        this.lastnameU = lastnameU;
        this.loginU = LoginU;
        this.passwordU = passwordU;
        this.Role = Role;
        this.adresse = adresse;
    }
     public User(int id_User, String firstnameU, String lastnameU, String LoginU, String passwordU, String Role, String adresse) {
        this.id_User = id_User;
        this.firstnameU = firstnameU;
        this.lastnameU = lastnameU;
    
        this.loginU = LoginU;
        this.passwordU = passwordU;
        this.Role = Role;
        this.adresse = adresse;
    }

    
    public User(int id_User) {
       this.id_User = id_User;
    }


    public int getId_User() {
        return id_User;
    }

    public void setId_User(int id_User) {
        this.id_User = id_User;
    }

    public String getFirstnameU() {
        return firstnameU;
    }

    public void setFirstnameU(String firstnameU) {
        this.firstnameU = firstnameU;
    }

    public String getLastnameU() {
        return lastnameU;
    }

    public void setLastnameU(String lastnameU) {
        this.lastnameU = lastnameU;
    }

    public String getPasswordU() {
        return passwordU;
    }

    public void setPasswordU(String passwordU) {
        this.passwordU = passwordU;
    }
     public String getLoginU() {
        return loginU;
    }

    public void setLoginU(String loginU) {
        this.loginU = loginU;
    }
     public String getrole() {
        return Role;
    }

    public void setrole(String Role) {
        this.Role = Role;
    }
     public String getadresse() {
        return adresse;
    }

    public void setadresse(String adresse) {
        this.adresse = adresse;
    }
    @Override
    public String toString() {
        return  super.toString() +"User{" + "firstnameU=" + firstnameU + ", lastnameU=" + lastnameU + ",, loginU=" + loginU + ", passwordU=" + passwordU + ",Role=" + Role+ ", adresse=" + adresse+"}";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.id_User;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        return this.id_User == other.id_User;
    }

    

  

       
    
}
