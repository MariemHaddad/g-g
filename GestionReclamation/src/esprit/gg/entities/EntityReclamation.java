/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.gg.entities;

import java.util.Date;

/**
 *
 * @author yassine
 */
public class EntityReclamation {
   private int idR;
    private String descriptionR;
    private String auteurR;
    private Date dateR;
    private String etatR;

    public EntityReclamation() {
    }

    public EntityReclamation(int idR, String descriptionR, String auteurR, Date dateR, String etatR) {
        this.idR = idR;
        this.descriptionR = descriptionR;
        this.auteurR = auteurR;
        this.dateR = dateR;
        this.etatR = etatR;
    }

    public EntityReclamation(String descriptionR, String auteurR, Date dateR, String etatR) {
        this.descriptionR = descriptionR;
        this.auteurR = auteurR;
        this.dateR = dateR;
        this.etatR = etatR;
    }

  
   
   
    
    @Override
    public String toString() {
        return "EntityReclamation{" + "idR=" + idR + ", descriptionR=" + descriptionR + ", auteurR=" + auteurR + ", dateR=" + dateR + ", etatR=" + etatR + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.idR;
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
        final EntityReclamation other = (EntityReclamation) obj;
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

    public String getEtatR() {
        return etatR;
    }

    public void setEtatR(String etatR) {
        this.etatR = etatR;
    }
}
    

  
   
    
    
    

   