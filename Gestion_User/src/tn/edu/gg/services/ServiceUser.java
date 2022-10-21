/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.gg.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.management.relation.Role;
import tn.edu.gg.entities.User;
import tn.edu.gg.entities.Formateur;
import tn.edu.gg.entities.Etudiant;
import tn.edu.gg.entities.Livreur;
import tn.edu.gg.tools.DataSource;
import tn.edu.gg.services.IService;


/**
 *
 * @author chalg
 */
public class ServiceUser implements IService<User,Etudiant,Formateur,Livreur> {

    Connection cnx;

    public ServiceUser() {
        this.cnx = DataSource.getInstance().getConnection();
    }

   
    @Override
    public void ajouter(User U) {
        try {
            String req = "INSERT INTO `user`(`firstnameU`, `lastnameU`,`passwordU`,`loginU`,`Role`, `adresse`) VALUES ('" + U.getFirstnameU() + "','" + U.getLastnameU() + "','" + U.getPasswordU() + "','" + U.getLoginU() + "','" + U.getrole() + "','"+ U.getadresse() +"')";

            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(User U) {
        
              try {
            String req="UPDATE user SET firstnameu=?,lastnameu=?,loginu=?,passwordu=?,role=?,adresse=? where id_user=?" ;
          
            PreparedStatement stm = cnx.prepareStatement(req);
            //Mouch mohem tartib les instruction numero ya3ty indication 3al blasetha fel requete
            stm.setInt(7, U.getId_User());
            stm.setString(1, U.getFirstnameU());
            stm.setString(2, U.getLastnameU());
            stm.setString(4, U.getPasswordU());
            stm.setString(3, U.getLoginU());
            stm.setString(5, U.getrole());
            stm.setString(6, U.getadresse());
           
            stm.executeUpdate();
            System.out.println("User Modifié avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
              
    }
     java.util.Scanner entree =   new java.util.Scanner(System.in);
    @Override
    public void modifierRole(User u) {
        try {
            String req = "UPDATE `user` SET `Role`=? WHERE id_User=" +u.getId_User();
            PreparedStatement stm = cnx.prepareStatement(req);
            Scanner sc = new Scanner(System.in);
            String r = entree.next();
            stm.setString(1, r);
            stm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Override
       public void ajouterE(Etudiant E) {
           
        try {
           String rep = "SELECT Role FROM `user` WHERE Role='Etudiant'";
           Statement stm = this.cnx.createStatement();
           ResultSet rs = stm.executeQuery(rep);
            
            while (rs.next()) {
                String role = rs.getString("Role");
                if (role.equals("Etudiant"))
                {   
            String req = "UPDATE user SET niveaux='"+ E.getniveaux() +"' WHERE Role = 'Etudiant'" ;
            PreparedStatement st = cnx.prepareStatement(req);  
             st.executeUpdate(req);
             System.out.println("Etudiant ajouté avec succées");
                }  
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
       }
       @Override
       public void modifierE(Etudiant E){
           try {
           String rep = "SELECT Role FROM `user` WHERE Role='Etudiant'";
           Statement stm = this.cnx.createStatement();
           ResultSet rs = stm.executeQuery(rep);
            
            while (rs.next()) {
                String role = rs.getString("Role");
                if (role.equals("Etudiant"))
                {   
            String req ="UPDATE user SET niveaux=?, WHERE id_User=" + E.getId_User() ;
            PreparedStatement st = cnx.prepareStatement(req);
            //Mouch mohem tartib les instruction numero ya3ty indication 3al blasetha fel requete

            st.setString(1, E.getniveaux());

            st.executeUpdate();
            System.out.println("Etudiant modifié avec succés");
                }  
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
           
       }
 
       

    @Override
    public void supprimer(int id_User) {
         try {
            String req = "DELETE FROM user WHERE id_User="+id_User;
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
            System.out.println("user supprimé avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
    }

    @Override
    public User getOne(int id_User) {
        String rep = "SELECT * FROM `user` WHERE id_User=" + id_User;
                     User util= new User();
        Statement stm;
        try {

            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(rep);

            while (rs.next()) {
                    util.setId_User(rs.getInt("id_User"));
                    util.setFirstnameU(rs.getString("firstnameu"));
                    util.setLastnameU(rs.getString("lastnameu"));
                    util.setPasswordU(rs.getString("passwordu"));
                    util.setLoginU(rs.getString("loginu"));
                    util.setrole(rs.getString("Role"));
                    util.setadresse(rs.getString("adresse"));                
                }
           
                System.out.println(util);
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    return util;
}
     

    @Override
    public ObservableList<User> getAll() {
        
        String rep = "SELECT * FROM `user`";
        ObservableList<User> list = FXCollections.observableArrayList();
        Statement stm;
        try {
            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(rep);

            while (rs.next()) {
                User B = new User();
                B.setId_User(rs.getInt(1));
                B.setFirstnameU(rs.getString(2));
                B.setLastnameU(rs.getString(3));
                B.setLoginU(rs.getString(4));
                B.setPasswordU(rs.getString(5));
                B.setrole(rs.getString(6));
                B.setadresse(rs.getString(7));
                list.add(B);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(list+"\n");

        return list;
    }
    
 @Override
    public ObservableList<Etudiant> getAllE(){
         String rep = "SELECT * FROM `user`";
         ObservableList<Etudiant> Etudiant = FXCollections.observableArrayList();
     
        Statement stm;
        try {

            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(rep);
                
            while (rs.next()) {
               
               String role = rs.getString("role");
               if(role.equals("Etudiant")){
                    Etudiant E = new Etudiant();
                    E.setId_User(rs.getInt("id_User"));
                    E.setFirstnameU(rs.getString("firstnameU"));
                    E.setLastnameU(rs.getString("lastnameU"));
                    E.setPasswordU(rs.getString("passwordU"));
                    E.setLoginU(rs.getString("loginU"));
                    E.setadresse(rs.getString("adresse"));
                   
                    E.setniveaux(rs.getString("niveaux"));
                    
                    System.out.println(E);

               }
  
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    return Etudiant;
     
} 
@Override
     public Etudiant getOneE (int id_User){
         
        String rep = "SELECT * FROM `user` WHERE id_User=" + id_User;
        Etudiant E= new Etudiant();
                           User a = new User();

        Statement stm;
        try {

            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(rep);
                
            while (rs.next()) {
                
               String role = rs.getString("role");
               if(role.equals("Etudiant")){
                
                    a.setId_User(rs.getInt("id_User"));
                    a.setFirstnameU(rs.getString("firstnameU"));
                    a.setLastnameU(rs.getString("lastnameU"));
                    a.setPasswordU(rs.getString("paswwordU"));
                    a.setLoginU(rs.getString("loginU"));
                    a.setrole(rs.getString("role"));
                    a.setadresse(rs.getString("adresse"));
                    E.setUser(a);
                    E.setniveaux(rs.getString("niveaux")); 
                    
                }
                
                System.out.println(E);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    return E;
     }
     
    @Override
       public void ajouterF(Formateur F) {
           
        try {
           String rep = "SELECT Role FROM `user` WHERE Role='Formateur'";
           Statement stm = this.cnx.createStatement();
           ResultSet rs = stm.executeQuery(rep);
            
            while (rs.next()) {
                String role = rs.getString("Role");
                if (role.equals("Formateur"))
                {   
            String req = "UPDATE user SET charge_horaire='"+ F.getcharge_horaire() +"', salaire='"+ F.getsalaire()+"', département='"+F.getdépartement()+"' WHERE Role = 'Formateur'" ;
            PreparedStatement st = cnx.prepareStatement(req);  
             st.executeUpdate(req);
             System.out.println("Formateur ajouté avec succées");
                }  
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
       }
       @Override
       public void modifierF(Formateur F){
           try {
           String rep = "SELECT Role FROM `user` WHERE Role='Formateur'";
           Statement stm = this.cnx.createStatement();
           ResultSet rs = stm.executeQuery(rep);
            
            while (rs.next()) {
                String role = rs.getString("Role");
                if (role.equals("Formateur"))
                {   
            String req ="UPDATE user SET charge_horaire=?, salaire=?, département=?, WHERE id_User=" + F.getId_User() ;
            PreparedStatement st = cnx.prepareStatement(req);
            //Mouch mohem tartib les instruction numero ya3ty indication 3al blasetha fel requete

            st.setString(1, F.getcharge_horaire());
            st.setString(2, F.getsalaire());
            st.setString(3, F.getdépartement());
            st.executeUpdate();
            System.out.println("Formateur modifié avec succés");
                }  
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
           
       }
       @Override
    public ObservableList<Formateur> getAllF(){
         String rep = "SELECT * FROM `user`";
         ObservableList<Formateur> Formateur = FXCollections.observableArrayList();
        User a = new User();

        Statement stm;
        try {

            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(rep);
                
            while (rs.next()) {
               
               String role = rs.getString("role");
               if(role.equals("Formateur")){
                    Formateur F = new Formateur();
                    F.setId_User(rs.getInt("id_User"));
                    F.setFirstnameU(rs.getString("firstnameU"));
                    F.setLastnameU(rs.getString("lastnameU"));
                    F.setPasswordU(rs.getString("passwordU"));
                    F.setLoginU(rs.getString("loginU"));
                    F.setadresse(rs.getString("adresse"));
                    F.setUser(a);
                    F.setcharge_horaire(rs.getString("charge_horaire"));
                    F.setsalaire(rs.getString("salaire"));
                    F.setdépartement(rs.getString("département"));
                    Formateur.add(F);
                    System.out.println("Formateur:"+F);

               }
  
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    return Formateur;
     
} 
@Override
     public Formateur getOneF (int id_User){
         
        String rep = "SELECT * FROM `user` WHERE id_User=" + id_User;
        Formateur F= new Formateur();
                           User a = new User();

        Statement stm;
        try {

            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(rep);
                
            while (rs.next()) {
                
               String role = rs.getString("role");
               if(role.equals("Formateur")){
                
                    a.setId_User(rs.getInt("id_User"));
                    a.setFirstnameU(rs.getString("firstnameU"));
                    a.setLastnameU(rs.getString("lastnameU"));
                    a.setPasswordU(rs.getString("paswwordU"));
                    a.setLoginU(rs.getString("loginU"));
                    a.setrole(rs.getString("role"));
                    a.setadresse(rs.getString("adresse"));
                    F.setUser(a);
                    F.setcharge_horaire(rs.getString("charge_horaire"));
                    F.setsalaire(rs.getString("salaire"));
                    F.setdépartement(rs.getString("département"));
                }
                
                System.out.println(F);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    return F;
     }

@Override
       public void ajouterL(Livreur L) {
           
        try {
           String rep = "SELECT Role FROM `user` WHERE Role='Livreur'";
           Statement stm = this.cnx.createStatement();
           ResultSet rs = stm.executeQuery(rep);
            
            while (rs.next()) {
                String role = rs.getString("Role");
                if (role.equals("Livreur"))
                {   
            String req = "UPDATE user SET diponibilités='"+ L.getdisponibilités() +"', point_de_départ='"+ L.getpoint_de_départ()+"' WHERE Role = 'Etudiant'" ;
            PreparedStatement st = cnx.prepareStatement(req);  
             st.executeUpdate(req);
             System.out.println("Livreur ajouté avec succées");
                }  
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
       }
       @Override
       public void modifierL(Livreur L){
           try {
           String rep = "SELECT Role FROM `user` WHERE Role='Livreur'";
           Statement stm = this.cnx.createStatement();
           ResultSet rs = stm.executeQuery(rep);
            
            while (rs.next()) {
                String role = rs.getString("Role");
                if (role.equals("Livreur"))
                {   
            String req ="UPDATE user SET disponibilités=?, point_de_départ=?, WHERE id_User=" + L.getId_User() ;
            PreparedStatement st = cnx.prepareStatement(req);
            //Mouch mohem tartib les instruction numero ya3ty indication 3al blasetha fel requete

            st.setString(1, L.getdisponibilités());
            st.setString(2, L.getpoint_de_départ());
            st.executeUpdate();
            System.out.println("Livreur modifié avec succés");
                }  
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
           
       }
       @Override
    public List<Livreur> getAllL(){
         String rep = "SELECT * FROM `user`";
        Livreur L= new Livreur();
        User a = new User();

        Statement stm;
        try {

            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(rep);
                
            while (rs.next()) {
               
               String role = rs.getString("role");
               if(role.equals("Livreur")){
                    
                    a.setId_User(rs.getInt("id_User"));
                    a.setFirstnameU(rs.getString("firstnameU"));
                    a.setLastnameU(rs.getString("lastnameU"));
                    a.setPasswordU(rs.getString("passwordU"));
                    a.setLoginU(rs.getString("loginU"));
                    a.setadresse(rs.getString("adresse"));
                    L.setUser(a);
                    L.setdisponibilités(rs.getString("disponibilités"));
                  
                    L.setpoint_de_départ(rs.getString("point_de_départ"));
                    System.out.println(L);

               }
  
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    return null;
     
} 
@Override
     public Livreur getOneL (int id_User){
         
        String rep = "SELECT * FROM `user` WHERE id_User=" + id_User;
        Livreur L= new Livreur();
                           User a = new User();

        Statement stm;
        try {

            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(rep);
                
            while (rs.next()) {
                
               String role = rs.getString("role");
               if(role.equals("Livreur")){
                
                    a.setId_User(rs.getInt("id_User"));
                    a.setFirstnameU(rs.getString("firstnameU"));
                    a.setLastnameU(rs.getString("lastnameU"));
                    a.setPasswordU(rs.getString("paswwordU"));
                    a.setLoginU(rs.getString("loginU"));
                    a.setrole(rs.getString("role"));
                    a.setadresse(rs.getString("adresse"));
                     L.setUser(a);
                    L.setdisponibilités(rs.getString("disponibilités"));
                    L.setpoint_de_départ(rs.getString("point_de_départ"));
                }
                
                System.out.println(L);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    return L;
     }
     
     public User connexion(String loginU, String passwordU){
        User u = null;
        
        try {
            PreparedStatement statement = this.cnx.prepareStatement(
    "SELECT * FROM user WHERE loginU=?");
           
            statement.setString(1,loginU);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
              
                if(rs.getString("passwordu").equals(passwordU)){
                    u = new User();
                    
                    u.setId_User(rs.getInt("id_User"));
                    u.setFirstnameU(rs.getString("firstnameU"));
                    u.setLastnameU(rs.getString("lastnameU"));
                    u.setPasswordU(rs.getString("passwordU"));
                    u.setLoginU(rs.getString("loginU"));
                    u.setrole(rs.getString("role"));
                    u.setadresse(rs.getString("adresse"));
                    
                    
                }
                
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return u;
    }

    public void Supprimer(int id_User) {
         try {
            String req = "DELETE FROM user WHERE id_User="+id_User;
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
            System.out.println("user supprimé avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }}
    
    }

   


        
    
  

   