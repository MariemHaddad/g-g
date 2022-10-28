/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Produit;
import Entities.Stock;
import Iservices.IServiceStock;
import Utils.MyDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yermani
 */
public class StockService implements IServiceStock {
    Connection con;
    Statement stm;

    public StockService() {
        con = MyDB.getInstance().getCon();
    }

    @Override
    public void AjouterStock(Stock stock) {
      try {
            String req = "INSERT INTO `stock` (`produit_id`, `emplacement`, `reference`,`nbreProdEnstock`) VALUES (?,?,?,?)";
            PreparedStatement pstm = con.prepareStatement(req);
            pstm.setInt(1, stock.getProduit_id());
            pstm.setString(2, stock.getEmplacement());
            pstm.setString(3, stock.getReference());
            pstm.setInt(4, stock.getNbreProdEnstock());
           
            pstm.executeUpdate();

            System.out.println("Stock Ajouté");
           

        } catch (SQLException ex) {
            Logger.getLogger(StockService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur d'ajout du stock");
            
        }
    }

    @Override
    public void ModifierStock(Stock stock) {
     try {
     
 String req ="UPDATE stock SET "+" idS='"+stock.getIdS()+"'"
         +",produit_id='"+stock.getProduit_id()+"'"
         +",emplacement='"+stock.getEmplacement()+"'"+",reference='"+stock.getReference()+"'"
         +",nbreProdEnstock='"+stock.getNbreProdEnstock()+"' WHERE idS = "+stock.getIdS()+"";
         Statement stm = con.createStatement();
         stm.executeUpdate(req);
         
         System.out.println("Element **Modifier** Avec Succes!!");
         
    } catch (SQLException ex) {
       System.out.println(ex.getMessage());
    }

    }

    @Override
    public void SupprimerStock(int idS) {
        try {
            String req = "DELETE FROM `stock` WHERE idS = " + idS ;
            PreparedStatement pstm = con.prepareStatement(req);
            pstm.executeUpdate();
            System.out.println("Stock Supprimé");
            
        } catch (SQLException ex) {
            System.out.println("Erreur de supression");
        }
    }

   /* @Override
    public List<Stock> AfficherStock() {
       ArrayList<Stock> stocks = new ArrayList();
        try {
            String req = "SELECT * FROM stock";
            PreparedStatement pstm = con.prepareStatement(req);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Stock stock = new Stock();
               stock.setIdS(rs.getInt("idS"));
                stock.setProduit_id(rs.getInt("produit_id"));
                stock.setEmplacemanet(rs.getString("emplacement"));
                stock.setReference(rs.getString("reference"));
                stock.setNbreProdEnstock(rs.getInt("nbreProdEnstock"));

               stocks.add(stock);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur d'affichage des stocks");
        }
        return stocks;
    }*/

    @Override
    public List<Stock> getall() {
        
       String rep = "SELECT * FROM `stock`";
        ArrayList<Stock> stock = new ArrayList();
        Statement stm;
        try {
            stm = this.con.createStatement();
            ResultSet rs = stm.executeQuery(rep);

            while (rs.next()) {
                Stock s = new Stock();
                s.setIdS(rs.getInt(1));
                s.setProduit_id(rs.getInt(2));
                s.setEmplacement(rs.getString(3));
                s.setReference(rs.getString(4));
               s.setNbreProdEnstock(rs.getInt(5));
                
                stock.add(s);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return stock;
    }
    }
    
     
   

    
    
    
    
    
    
    
    
    
    
    
    
    
   

    

    
        

    

    