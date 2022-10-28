/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxreclamation5;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.time.ZoneId;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.imageio.ImageIO;
import tn.esprit.Services.ReclamationService;
import tn.esprit.entities.Reclamation;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author yassine
 */
public class AjouterReclamationController implements Initializable {

    @FXML
    private Label welcome;
    @FXML
    private TextField Contenu;
    @FXML
    private Hyperlink prec;
    @FXML
    private ComboBox<String> Type;
    @FXML
    private Button A;
    @FXML
    private TextField AuteurR;
    @FXML
    private DatePicker myDatePicker;
    Connection cnx;
    @FXML
    private Button ImageR;
    @FXML
    private ImageView imageCadre;
    
    @FXML
    private Label Pathimage;

   String ImagePath ="";
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    ObservableList<String> list1 =FXCollections.observableArrayList("reclamation technique","reclamation service","reclamation produit");
    Type.setItems(list1);
    }    

    @FXML
    private void prec(ActionEvent event) {
            Parent page1;
        try {
            page1 = FXMLLoader.load(getClass().getResource("ListReclamation.fxml"));
              Scene scene = new Scene(page1, 1144, 741);
            
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
     } catch (IOException ex) {
            Logger.getLogger(AjouterReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        }

    @FXML
    private void addReclam(ActionEvent event) {
            ReclamationService productService = new ReclamationService();
  
        if (Contenu.getText().equals("")
              ) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("You cant send a reclamation without content ");
            a.setHeaderText(null);
            a.showAndWait();
        } else if (Contenu.getText().matches("[\\\\!\"#$%&()*+,./:;<=>?@\\[\\]^_{|}~]+")
              ) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("Une erreur s’est produite. Veuillez réessayer. ");
            a.setHeaderText(null);
            a.showAndWait();
        }
        else{
            java.util.Date date2= java.util.Date.from(this.myDatePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
                 java.sql.Date sqlDate2 = new java.sql.Date(date2.getTime());

            Reclamation c = new Reclamation(Contenu.getText(),AuteurR.getText(),sqlDate2, (String) Type.getValue(),ImagePath);
            productService.ajouterReclamation(c);
            
             TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
            tray.setTitle("Reclamation Added Successfully !!!");
            tray.setMessage("");
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.showAndDismiss(Duration.millis(5000));
            
        
                   Parent page1;
                try {
                    page1 = FXMLLoader.load(getClass().getResource("ListReclamation.fxml"));
             
        Scene scene = new Scene(page1);
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       stage.setScene(scene);
        stage.show();
        
        }    catch (IOException ex) {
                    Logger.getLogger(AjouterReclamationController.class.getName()).log(Level.SEVERE, null, ex);
                }
        
    }
       
    }

    @FXML
    private void addImage(ActionEvent event) {
         FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilterJPG
                = new FileChooser.ExtensionFilter("JPG files (*.JPG)", "*.JPG");
        FileChooser.ExtensionFilter extFilterjpg
                = new FileChooser.ExtensionFilter("jpg files (*.jpg)", "*.jpg");
        FileChooser.ExtensionFilter extFilterPNG
                = new FileChooser.ExtensionFilter("PNG files (*.PNG)", "*.PNG");
        FileChooser.ExtensionFilter extFilterpng
                = new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
        fileChooser.getExtensionFilters()
                .addAll(extFilterJPG, extFilterjpg, extFilterPNG, extFilterpng);
        File file = fileChooser.showOpenDialog(null);
        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            WritableImage image = SwingFXUtils.toFXImage(bufferedImage, null);
            imageCadre.setImage(image);
           imageCadre.setFitWidth(200);
           imageCadre.setFitHeight(200);
            imageCadre.scaleXProperty();
            imageCadre.scaleYProperty();
            imageCadre.setSmooth(true);
            imageCadre.setCache(true);
            FileInputStream fin = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for (int readNum; (readNum = fin.read(buf)) != -1;) {
                bos.write(buf, 0, readNum);
            }
            byte[] person_image = bos.toByteArray();
        } catch (IOException ex) {
            Logger.getLogger("ss");
        }
      //  Pathimage.setText(file.getAbsolutePath());
     ImagePath=file.getAbsolutePath();
    }
    
    }
  
    


