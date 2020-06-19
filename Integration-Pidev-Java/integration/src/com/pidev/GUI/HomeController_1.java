/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.GUI;

import com.pidev.Entite.User;
import static com.pidev.GUI.ConversationsController.idfriend;
import com.pidev.Service.ServicePCVR;
import com.pidev.Service.ServicePublication;
import com.pidev.Entite.Commentaire;
import com.pidev.Entite.Publication;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import static com.pidev.GUI.Integration.Userconnected;
import com.pidev.Service.ServiceUser;
import java.io.File;
import javafx.scene.Node;
import javafx.scene.control.Label;

/**
 *
 * @author asus
 */
public class HomeController_1 implements Initializable {
  
    static String username="amine";
    
    @FXML
    private Button ajout;
    @FXML
    private ListView<Publication> listepublication;
      ServiceUser su = new ServiceUser();
    
   /**********************************/
    ServicePublication serp=new ServicePublication();
    ServicePCVR serPCVR= new ServicePCVR();
     List<Publication> l1;
     List<Commentaire> l2;
    PublicationCellFactory cp;
    @FXML
    private Button actualiser;
    @FXML
    private Button stat;
    @FXML
    private ImageView UserImage;
    @FXML
    private Label UserName;
    public HomeController_1() {
        this.cp = new PublicationCellFactory();
        this.listepublication = new ListView<Publication>();
    }
     
     /*********************************/

    @FXML
 
    ImageView imageuser ;
    
    
    /**
     *
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

          
               
            l1=serp.readAll();
           } catch (SQLException ex) {
            System.out.println(ex.getMessage());
           }
          listepublication.setCellFactory(cp);
          listepublication.getItems().addAll(l1);
           /*ajout.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;-fx-background-radius: 10px;"); 
           actualiser.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;-fx-background-radius: 10px;");*/
          //  InputStream input1 =getClass().getResourceAsStream("/image/ajouter-100-.png");
           // InputStream input2 =getClass().getResourceAsStream("/image/actualiser-90-.png");
            
            
 
       // Image image = new Image(input1);
        //Image image1 = new Image(input2);
        
       // ImageView imageView1 = new ImageView(image);
       // ImageView imageView2 = new ImageView(image1);
       // imageuser.setImage(imageuser1);
       /* ajout.setGraphic(imageView1);
        actualiser.setGraphic(imageView2);*/
    }     
   

    @FXML
    private void ajouter(ActionEvent event) throws IOException
    {
     Parent root = FXMLLoader.load(getClass().getResource("AjoutPub.fxml"));
     Scene scene = new Scene(root);
     Stage stage=new Stage();
     stage.setScene(scene);
     stage.show();
    }

    @FXML
    private void actualiser(ActionEvent event) {
            try {
            l1=serp.readAll();
           } catch (SQLException ex) {
            System.out.println(ex.getMessage());
           }
        listepublication.getItems().clear();
        listepublication.getItems().addAll(l1);
    }

    @FXML
    private void stat(ActionEvent event) throws IOException {
     Parent root = FXMLLoader.load(getClass().getResource("postsStatics.fxml"));
     Scene scene = new Scene(root);
     Stage stage=new Stage();
     stage.setScene(scene);
     stage.show();
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
                stat.getScene().setRoot(root);
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
                                stat.getScene().setRoot(root);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
       if ("Utilisateur simple".equals(Userconnected.getTypeCompte()))
       {
      try {
                Parent root = FXMLLoader.load(getClass().getResource("interfaceUser1.fxml"));
                                stat.getScene().setRoot(root);
 
            } catch (IOException ex) {System.out.println(ex.getMessage());
            }
    }
                if ("Chasseur du talent".equals(Userconnected.getTypeCompte()))
       {
      try {
                Parent root = FXMLLoader.load(getClass().getResource("interfaceUser1.fxml"));
                                stat.getScene().setRoot(root);

            } catch (IOException ex) {System.out.println(ex.getMessage());
            }
    }
    }

    @FXML
    private void amis(MouseEvent event) throws IOException {
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("listAmis.fxml"));
                               stat.getScene().setRoot(root);

    
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
