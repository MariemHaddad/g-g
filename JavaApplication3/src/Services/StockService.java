package Services;



import Entities.stock;

import Utils.MyDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import IServices.IServiceStock;

public class StockService implements IServiceStock {

    Connection con;
    Statement stm;

    public StockService() {
        con = MyDB.getInstance().getCon();
    }


    @Override
    public boolean AjouterStock(stock stock) {
         try {
            String req = "INSERT INTO `stock` (`produit_id`, `emplacemanet`) VALUES (?, ?)";
            PreparedStatement pstm = con.prepareStatement(req);
            pstm.setInt(1, stock.getProduit_id());
            pstm.setString(2, stock.getEmplacement());
           
            pstm.executeUpdate();

            System.out.println("stock Ajouté");
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur d'ajout du stock");
            return false;
        }

    }

    @Override
    public boolean ModifierStock(stock stock) {
      try {
            String req = "UPDATE stock SET  emplacemanet=? , Produit_idP=?  WHERE id=?";
            PreparedStatement pstm = con.prepareStatement(req);
            
            pstm.setInt(1 , stock.getProduit_id());
            pstm.setString(2, stock.getEmplacement());
           
            pstm.setInt(3, stock.getId());
            pstm.executeUpdate();

            System.out.println("stock Modifié");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur de modification du stock");
            return false;
        }

    }

    @Override
    public boolean SupprimerStock(int id) {
         try {
            String req = "DELETE FROM `stock` WHERE id = " + id + "";
            PreparedStatement pstm = con.prepareStatement(req);
            pstm.executeUpdate();
            System.out.println("stock Supprimé");
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur de supression du stock");
        }
        return false;
    }

    @Override
    public List<stock> AfficherStock() {
       List<stock> stock = new ArrayList();
        try {
            String req = "SELECT * FROM stock";
            PreparedStatement pstm = con.prepareStatement(req);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                stock k= new stock();
                k.setId(rs.getInt("id"));
                
                k.setProduit_id(rs.getInt("produit_id"));
                k.setEmplacement(rs.getString("emplacemanet"));
                
                

                stock.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur d'affichage des Stocks");
        }
        return stock;  
    }

   
  

 
    
}
