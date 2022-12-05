/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.entities;

import java.util.Date;

/**
 *
 * @author Administrateur
 */
public class Reclamation {
    private int idR;
    private String descriptionR;
    private String auteurR;
    private Date dateR ;
    private String typeR;
    private String imgR;

    public Reclamation() {
    }

    public Reclamation(int idR, String descriptionR, String auteurR, Date dateR, String typeR, String imgR) {
        this.idR = idR;
        this.descriptionR = descriptionR;
        this.auteurR = auteurR;
        this.dateR = dateR;
        this.typeR = typeR;
        this.imgR = imgR;
    }

    public Reclamation(String descriptionR, String auteurR, Date dateR, String typeR, String imgR) {
        this.descriptionR = descriptionR;
        this.auteurR = auteurR;
        this.dateR = dateR;
        this.typeR = typeR;
        this.imgR = imgR;
    }

    public Reclamation(String descriptionR, String auteurR, Date dateR, String typeR) {
        this.descriptionR = descriptionR;
        this.auteurR = auteurR;
        this.dateR = dateR;
        this.typeR = typeR;
    }

    public Reclamation(int idR, String descriptionR, String auteurR, Date dateR, String typeR) {
        this.idR = idR;
        this.descriptionR = descriptionR;
        this.auteurR = auteurR;
        this.dateR = dateR;
        this.typeR = typeR;
    }
    

    @Override
    public String toString() {
        return "Reclamation{" + "idR=" + idR + ", descriptionR=" + descriptionR + ", auteurR=" + auteurR + ", dateR=" + dateR + ", typeR=" + typeR + ", imgR=" + imgR + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.idR;
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
        final Reclamation other = (Reclamation) obj;
        if (this.idR != other.idR) {
            return false;
        }
        return true;
    }

    public int getIdR() {
        return idR;
    }

    public void setIdR(int idR) {
        this.idR = idR;
    }

    public String getDescriptionR() {
        return descriptionR;
    }

    public void setDescriptionR(String descriptionR) {
        this.descriptionR = descriptionR;
    }

    public String getAuteurR() {
        return auteurR;
    }

    public void setAuteurR(String auteurR) {
        this.auteurR = auteurR;
    }

    public Date getDateR() {
        return dateR;
    }

    public void setDateR(Date dateR) {
        this.dateR = dateR;
    }

    public String getTypeR() {
        return typeR;
    }

    public void setTypeR(String typeR) {
        this.typeR = typeR;
    }

    public String getImgR() {
        return imgR;
    }

    public void setImgR(String imgR) {
        this.imgR = imgR;
    }

  
   
    

   

   

   
   
    
    
    
}
