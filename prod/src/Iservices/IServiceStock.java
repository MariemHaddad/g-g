/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iservices;

import Entities.Produit;
import Entities.Stock;
import java.util.List;

/**
 *
 * @author yermani
 */
public interface IServiceStock {
     public void AjouterStock(Stock stock);

   public void ModifierStock(Stock stock);

    public void SupprimerStock(int idS);
    
    public List<Stock>getall();
    
    
}
