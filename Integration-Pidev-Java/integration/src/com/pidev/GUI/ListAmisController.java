/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.GUI;

import com.pidev.Entite.User;

import static com.pidev.GUI.Integration.Userconnected;

import com.pidev.Service.DemandeAmitie;
import com.pidev.Service.ServiceUser;
import java.io.File;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author HPENVY
 */
public class ListAmisController implements Initializable {


  
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
    @FXML
    private ImageView UserImage;
    @FXML
    private Label UserName;
      ServiceUser su = new ServiceUser();
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
               
          try {
              String im = su.findbyImage(Userconnected.getIdUser());
              File file = new File("C:/xampp/htdocs/Image_Pi/" + im);
              UserImage.setImage(new Image(file.toURI().toString()));
              String alo = su.findByIdname(Userconnected.getIdUser());
              String friendlastname = su.findByIlastname(Userconnected.getIdUser());
              UserName.setText(alo+" "+friendlastname);
              
              
              DemandeAmitie dm = new DemandeAmitie();
              
              nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
              prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
              System.out.println("helloo");
              
              //    ObservableList<User> obListActivite = dm.getAll(Userc);
              System.out.println(Userconnected.getIdUser());
              ObservableList<User> obListActivite = dm.getAll(Userconnected.getIdUser());
              table1.setItems(obListActivite);
              
              
              
              
              //User userSel = new User();
          } catch (SQLException ex) {
              Logger.getLogger(ListAmisController.class.getName()).log(Level.SEVERE, null, ex);
          }
        
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
            Parent root = LOADER.load();
            Profile_userController montaser = LOADER.getController();
            montaser.setDetails(userSel);
//            bntProfil.getScene().setRoot(root);
            
            
            Scene scene = new Scene(root, 1000, 600);
            
            Stage primaryStage = new Stage();
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListAmisController.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        
        
    }

    @FXML
    private void acceuil(MouseEvent event) {
                                  FXMLLoader LOADER = new FXMLLoader(getClass().getResource("Home_1.fxml"));
        try {
            Parent root = LOADER.load();
            Scene rana = new Scene(root);
            HomeController_1 hamza = LOADER.getController();
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(rana);
            window.show();
        } catch (IOException ex) {

        }
    
    }

    @FXML
    private void chat1(MouseEvent event) {
            FXMLLoader LOADER = new FXMLLoader(getClass().getResource("Conversations.fxml"));
                try {
                    Parent root = LOADER.load();
                    Scene rana = new Scene(root);
                      ConversationsController hamza = LOADER.getController();
                    Stage window =(Stage)((Node) event.getSource()).getScene().getWindow() ;
              
                    window.setScene(rana);
                    window.show();
                } catch (IOException ex) {
                  
                }
    }

    @FXML
    private void competition(MouseEvent event) {
                if ("Chasseur du talent".equals(Userconnected.getTypeCompte()))
       {
           FXMLLoader LOADER = new FXMLLoader(getClass().getResource("IntChasseur.fxml"));
                try {
                    Parent root = LOADER.load();
                    Scene rana = new Scene(root);
                      IntChasseurController hamza = LOADER.getController();
                    Stage window =(Stage)((Node) event.getSource()).getScene().getWindow() ;
              
                    window.setScene(rana);
                    window.show();
                } catch (IOException ex) {
                  
    }}
       if ("Utilisateur simple".equals(Userconnected.getTypeCompte()))
       {
      try {
                Parent root = FXMLLoader.load(getClass().getResource("UserInterface.fxml"));
                            bntProfil.getScene().setRoot(root);

            } catch (IOException ex) {System.out.println(ex.getMessage());
            }
    }}

    @FXML
    private void annonce(MouseEvent event) {
                 FXMLLoader LOADER = new FXMLLoader(getClass().getResource("AffichageAnnonce.fxml"));
                try {
                    Parent root = LOADER.load();
                    Scene rana = new Scene(root);
                      AffichageAnnonceController hamza = LOADER.getController();
                    Stage window =(Stage)((Node) event.getSource()).getScene().getWindow() ;
              
                    window.setScene(rana);
                    window.show();
                } catch (IOException ex) {
                  
                }
    }

    @FXML
    private void reclamation(MouseEvent event) {
               if ("Administrateur".equals(Userconnected.getTypeCompte()))
        { 
            try {
                Parent root = FXMLLoader.load(getClass().getResource("interfaceadmin.fxml"));
                                            bntProfil.getScene().setRoot(root);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
       if ("Utilisateur simple".equals(Userconnected.getTypeCompte()))
       {
      try {
                Parent root = FXMLLoader.load(getClass().getResource("interfaceUser1.fxml"));
                                            bntProfil.getScene().setRoot(root);
 
            } catch (IOException ex) {System.out.println(ex.getMessage());
            }
    }
                if ("Chasseur du talent".equals(Userconnected.getTypeCompte()))
       {
      try {
                Parent root = FXMLLoader.load(getClass().getResource("interfaceUser1.fxml"));
                                            bntProfil.getScene().setRoot(root);

            } catch (IOException ex) {System.out.println(ex.getMessage());
            }
    }
    }

    @FXML
    private void amis(MouseEvent event) throws IOException {
            Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("listAmis.fxml"));
                                            bntProfil.getScene().setRoot(root);

    }

    @FXML
    private void logout(MouseEvent event) {
                                     FXMLLoader LOADER = new FXMLLoader(getClass().getResource("Authentification.fxml"));
        try {
            Parent root = LOADER.load();
            Scene rana = new Scene(root);
            AuthentificationController hamza = LOADER.getController();
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(rana);
            window.show();
        } catch (IOException ex) {

        }
    }
    
    
    
}
