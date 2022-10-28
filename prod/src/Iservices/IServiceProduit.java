/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iservices;

import Entities.Produit;
import java.util.List;

/**
 *
 * @author yermani
 */
public interface IServiceProduit {
  public void AjouterProduit(Produit produit);

   public void ModifierProduit(Produit produit);

    public void SupprimerProduit(int id);
    List<Produit> AfficherProduit();
    public List<Produit>getall();
}
