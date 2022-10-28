/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxreclamation5;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Duration;
import tn.esprit.Services.ReclamationService;
import tn.esprit.entities.Reclamation;
import tn.esprit.tools.MyDB;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author yassine
 */
public class ListReclamationController implements Initializable {

    @FXML
    private TableView<Reclamation> tableview;
    @FXML
    private TableColumn<Reclamation,Date> dateReclam;
    @FXML
    private TableColumn<Reclamation,String> typeReclam;
    @FXML
    private TableColumn<Reclamation,String> auteurReclam;
    @FXML
    private TableColumn<Reclamation,String> descriptionReclam;
    @FXML
    private Button supp1;
    @FXML
    private Button supp;
    @FXML
    private Button Ajouter;
    public static Reclamation connectedRec;
 public ObservableList<Reclamation> obs2;
//public static Reclamation connectedRec;
   ReclamationService cs = new ReclamationService();
//   List<Reclamation> obs2 = new ArrayList();
public ObservableList<Reclamation> list;
    @FXML
    private TextField searchR;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//          ReclamationService cs = new ReclamationService();
//                   
//            ArrayList<Reclamation> c = new ArrayList<>();
//             c = (ArrayList<Reclamation>) cs.AfficherAllReclamations();
//         ObservableList<Reclamation> obs2 = FXCollections.observableArrayList(c);
//     
// tableview.setItems(obs2);
////         List<Reclamation> obs2 = cs.AfficherAllReclamations();
//          descriptionReclam.setCellValueFactory(new PropertyValueFactory<>("descriptionR"));
//        auteurReclam.setCellValueFactory(new PropertyValueFactory<>("auteurR"));   
//        dateReclam.setCellValueFactory(new PropertyValueFactory<>("dateR"));
//       typeReclam.setCellValueFactory(new PropertyValueFactory<>("typeR"));
//    list = FXCollections.observableArrayList(
//                    cs.AfficherAllReclamations());
//    tableview.setItems(obs2);
//    
//
////     
////        tableview.setItems((ObservableList<Reclamation>) obs2);
////    
    

  ReclamationService cs = new ReclamationService();
                   
          
         ArrayList<Reclamation> c = new ArrayList<>();
         c = (ArrayList<Reclamation>) cs.AfficherAllReclamations();
     ObservableList<Reclamation> obs2 = FXCollections.observableArrayList(c);
 tableview.setItems(obs2);
//         List<Reclamation> obs2 = cs.AfficherAllReclamations();
          descriptionReclam.setCellValueFactory(new PropertyValueFactory<>("descriptionR"));
        auteurReclam.setCellValueFactory(new PropertyValueFactory<>("auteurR"));   
        dateReclam.setCellValueFactory(new PropertyValueFactory<>("dateR"));
       typeReclam.setCellValueFactory(new PropertyValueFactory<>("typeR"));
   
        
        
        try {
            list = FXCollections.observableArrayList(
                    cs.AfficherAllReclamations()
            );      
            FilteredList<Reclamation> filteredData = new FilteredList<>(list, e -> true);
            searchR.setOnKeyReleased(e -> {
                searchR.textProperty().addListener((ObservableValue, oldValue, newValue) -> {
                    filteredData.setPredicate((Predicate<? super Reclamation>) Reclamations -> {
                        if (newValue == null || newValue.isEmpty()) {
                            return true;
                        }
                        String lower = newValue.toLowerCase();
                        if (Reclamations.getDescriptionR().toLowerCase().contains(lower)) {
                            return true;
                        }else if(Reclamations.getAuteurR().toLowerCase().contains(lower)){
                        return true;}
                        else if(Reclamations.getTypeR().toLowerCase().contains(lower)){
                        return true;}
                         else if(Reclamations.getDateR().toString().toLowerCase().contains(lower)){
                        return true;}
                        else
                        return false;
                    });
                });
                SortedList<Reclamation> sortedData = new SortedList<>(filteredData);
                sortedData.comparatorProperty().bind(tableview.comparatorProperty());
                tableview.setItems(sortedData);
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
       
       
    }
     

    @FXML
    private void Modif(ActionEvent event)throws IOException {
          ReclamationService ps = new ReclamationService();
        Reclamation c = new Reclamation(
                tableview.getSelectionModel().getSelectedItem().getIdR(),
             
                 tableview.getSelectionModel().getSelectedItem().getDescriptionR(),
                tableview.getSelectionModel().getSelectedItem().getAuteurR(),
               tableview.getSelectionModel().getSelectedItem().getDateR(),
                tableview.getSelectionModel().getSelectedItem().getTypeR(),
                 tableview.getSelectionModel().getSelectedItem().getImgR()
                );
       ListReclamationController.connectedRec = c;
        
             Parent page1;
       
            page1 = FXMLLoader.load(getClass().getResource("ModifierReclamation.fxml"));
       
        Scene scene = new Scene(page1, 1144, 741);
    
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
          
    }
        
    

    @FXML
    private void supp(ActionEvent event) throws SQLException {
          if (event.getSource() == supp) {
            Reclamation rec = new Reclamation();
            rec.setIdR(tableview.getSelectionModel().getSelectedItem().getIdR());  
            ReclamationService cs = new ReclamationService();
                Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setContentText("Are you sure you want to delete this reclamation ");
            a.setHeaderText(null);
            a.showAndWait();
            cs.SupprimerReclamation(rec);
            resetTableData();
            
              TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
            tray.setTitle("Reclamation Deleted Successfully !!!");
            tray.setMessage("");
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.showAndDismiss(Duration.millis(5000));
    }
    }
     public void resetTableData() throws SQLDataException, SQLException{

         List<Reclamation> listrec = new ArrayList<>();
         listrec = cs.AfficherAllReclamations();
         ObservableList<Reclamation> data = FXCollections.observableArrayList(listrec);
         tableview.setItems(data);
       
    }

          
         
          
    @FXML
    private void Ajouter(ActionEvent event) {
       Parent page1;
        try {
            page1 = FXMLLoader.load(getClass().getResource("AjouterReclamation.fxml"));
       
        Scene scene = new Scene(page1);
      
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Ajouter une Reclamations");
        stage.setScene(scene);
        stage.show();
        }  catch (IOException ex) {
           System.out.println(ex.getMessage());
        }
        
    }
    
}
