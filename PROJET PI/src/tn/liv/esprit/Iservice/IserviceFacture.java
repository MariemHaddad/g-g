/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.liv.esprit.Iservice;

import java.util.List;
import tn.liv.esprit.entities.Facture;


/**
 *
 * @author Mouthana
 */
public interface IserviceFacture<F> {
    boolean AjouterFacture(Facture facture);

    boolean Modifierfacture(Facture facture);

    boolean SupprimerFacture(int idF);
    
    public List<F> getAll();
    
}
