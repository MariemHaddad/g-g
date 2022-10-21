package tn.liv.esprit.Iservice;

import tn.liv.esprit.entities.Commande;

import java.util.List;

public interface IserviceCommande {

    boolean AjouterCommande(Commande commande);

    boolean ModifierCommande(Commande commande);

    boolean SupprimerCommande(int idCommande);

    List<Commande> AfficherCommandes();
    
    List<Commande> AfficherCommandes(int id_user);
    
    Commande RecupererCommande(int idCommande);
}