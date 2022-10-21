package IServices;


import Entities.stock;

import java.util.List;

public interface IServiceStock {

    boolean AjouterStock(stock stock);

    boolean ModifierStock(stock stock);

    boolean SupprimerStock(int id);

    List<stock> AfficherStock();
    
   
}
