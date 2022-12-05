/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.gg.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chalg
 */
public class DataConnexion {
    private Connection cnx;
    private static DataConnexion instance;
    
    private String url = "jdbc:mysql://localhost:3306/reclamation_forme";
    private String user = "root";
    private String password = "";
    
    private DataConnexion(){
        try {
            cnx = DriverManager.getConnection(url, user, password);
            System.out.println("connected to DB !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static DataConnexion getInstance(){
        if(instance == null){
            instance = new DataConnexion();
        }
        return instance;
    }
    
    public Connection getConnection(){
        return this.cnx;
    }
}
