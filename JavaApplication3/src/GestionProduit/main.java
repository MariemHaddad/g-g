/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionProduit;

import Entities.Produit;
import Entities.stock;
import Utils.MyDB;
import Services.ProduitService;
import IServices.IServiceProduit;
import Services.StockService;
import javax.activation.DataSource;

/**
 *
 * @author yermani
 */

public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Produit p1 = new Produit("sechecheveux", "Bonne etat", 100,"photo");
       Produit p2 = new Produit("sechoire","bonne etat",50,"photo");
       Produit p3 = new Produit("brosse","bonne etat",10,"photo");
       stock stock = new stock(11,"yer");
       
       ProduitService ps = new ProduitService();
       StockService pss = new StockService();
       ps.AjouterProduit(p1);
       ps.AjouterProduit(p2);
       ps.AfficherProduits();
       
       ps.AjouterProduit(p3);
       pss.AjouterStock(stock);
       ps.ModifierProduit(p2);
     
      ps.SupprimerProduit(11);
        System.out.println(ps.AfficherProduits().toString());
        System.out.println(pss.AfficherStock().toString());
      
       
       MyDB.getInstance();
    }
    
}
