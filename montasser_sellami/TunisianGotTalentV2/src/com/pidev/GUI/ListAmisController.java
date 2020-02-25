/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.GUI;
import static com.pidev.GUI.HomePage.Userconnected ;
import com.pidev.Entite.User;
import com.pidev.Service.DemandeAmitie;
import com.pidev.Service.ServiceUser;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author HPENVY
 */
public class ListAmisController implements Initializable {
    User u = new User();

    User Userconnected = new User();
      @FXML
    private TableView<User> table1;

    @FXML
    private TableColumn<User, String> nom;

    @FXML
    private TableColumn<User, String> prenom;
    private Button bntProfil;
    ServiceUser srv = new ServiceUser();

    
    
    User userSel = new User();
    @FXML
    private Button btnProfil;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        DemandeAmitie dm = new DemandeAmitie();
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        System.out.println("helloo");
         ObservableList<User> obListActivite = dm.getAll(163);
       // ObservableList<User> obListActivite = dm.getAll(Userconnected.getIdUser());
        table1.setItems(obListActivite);
        
        
        
        System.out.println("bye");
        
        //User userSel = new User();
        
    }  
    
    @FXML
    public void goToProfil()
            
    {
        
        
        
        
        
        try {
            try {
                userSel=srv.findByNom(table1.getSelectionModel().getSelectedItem().getNom(),table1.getSelectionModel().getSelectedItem().getPrenom());
            } catch (SQLException ex) {
                Logger.getLogger(ListAmisController.class.getName()).log(Level.SEVERE, null, ex);
            }
            FXMLLoader LOADER = new FXMLLoader(getClass().getResource("Profile_user.fxml"));
            Parent rootDetails = LOADER.load();
            Profile_userController montaser = LOADER.getController();
            montaser.setDetails(userSel);
            //bntProfil.getScene().setRoot(rootDetails);
            
            
            Scene scene = new Scene(rootDetails, 600, 400);
            
            Stage primaryStage = new Stage();
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListAmisController.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        
        
    }
    
    
    
}
