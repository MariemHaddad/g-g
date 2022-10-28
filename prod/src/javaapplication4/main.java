/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import Entities.Produit;
import Entities.Stock;
import Services.ProduitService;
import Services.StockService;
import Utils.MyDB;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;

/**
 *
 * @author yermani
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
      Produit p=new Produit("bb","bonne",251f,"photo");
         Stock se = new Stock(4,"gg","hh",15);
         StockService ss=new StockService();
         ProduitService ps = new ProduitService();
      ps.AjouterProduit(p);
           
          ps.AfficherProduit();
         System.out.println(ps.AfficherProduit().toString());
         
            StockService pss = new StockService();
            pss.AjouterStock(se);
            ps.SupprimerProduit(9);
          
            ps.ModifierProduit(p);
           
       
           
       ps.AfficherProduit();
        
     
        MyDB.getInstance();
    }
    
}
