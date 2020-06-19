/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.GUI;

import com.pidev.Entite.Conversation;
import com.pidev.Entite.User;
import static com.pidev.GUI.Integration.Userconnected;
import com.pidev.Service.EnvoyerMail;
import com.pidev.Service.ServiceConversation;
import com.pidev.Service.ServiceUser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class Profile_userController implements Initializable {

     @FXML
     public ImageView ImageU;
     @FXML
     public Label Nom;
     @FXML
     public Label Prenom;
     @FXML
     public Label Num;
     @FXML
     public Label Email;
     @FXML
     public Label Talent;
     @FXML
     public Label idRecup;
      @FXML
    private Label idloula;
        ServiceConversation conv = new ServiceConversation();
   // mailServices off = new mailServices();
      EnvoyerMail m = new EnvoyerMail();
    @FXML
    private ImageView UserImage;
    @FXML
    private Label UserName;
       ServiceUser su = new ServiceUser();
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         try {
             String im = su.findbyImage(Userconnected.getIdUser());
             File file = new File("C:/xampp/htdocs/Image_Pi/" + im);
             UserImage.setImage(new Image(file.toURI().toString()));
             String alo = su.findByIdname(Userconnected.getIdUser());
             String friendlastname = su.findByIlastname(Userconnected.getIdUser());
             UserName.setText(alo+" "+friendlastname);
             // TODO
         } catch (SQLException ex) {
             Logger.getLogger(Profile_userController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }    
    
    
    public void setDetails(User userSel)
    {
        File file = new File("C:/xampp/htdocs/Image_Pi/" + userSel.getImguser());
        ImageU.setFitHeight(70);
        ImageU.setFitWidth(70);
        ImageU.setImage(new Image(file.toURI().toString()));
        System.out.println(userSel.getImguser());
        Nom.setText(userSel.getNom());
        System.out.println(userSel.getNom());
        Prenom.setText(userSel.getPrenom());
        System.out.println(userSel.getPrenom());
        Num.setText(Integer.toString(userSel.getNumTelephone()));
        System.out.println(userSel.getNumTelephone());
        Email.setText(userSel.getEmail());
        System.out.println(userSel.getEmail());
        Talent.setText(userSel.getTypeTalent());
        System.out.println(userSel.getTypeTalent());
        idRecup.setText(Integer.toString(userSel.getIdUser()));
        System.out.println(userSel.getIdUser());
      
        
        
    }

    @FXML
    private void communiquer(MouseEvent event) {
         try {
             idloula.setText("Our New Converstion");
            FXMLLoader LOADER = new FXMLLoader(getClass().getResource("Conversations.fxml"));
            Parent root = LOADER.load();
            ConversationsController hamza = LOADER.getController();
            hamza.setDetails("" + idloula.getText(), idRecup.getText());
            Conversation NewConv = new Conversation(idloula.getText(), Userconnected.getIdUser(), Integer.parseInt(idRecup.getText()));

            try {
                if (conv.tester(Integer.parseInt(idRecup.getText())) == "yes") {
                    System.out.println("Conversation créé deja");
                    idloula.getScene().setRoot(root);

                } else {
                  
                    m.envoyer();
                    conv.ajouter(NewConv);
                    idloula.getScene().setRoot(root);
                }

            } catch (SQLException ex) {
                  Logger.getLogger(TestController.class.getName()).log(Level.SEVERE, null, ex);
            }

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
                Num.getScene().setRoot(root);
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
                                Num.getScene().setRoot(root);
 
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
       if ("Utilisateur simple".equals(Userconnected.getTypeCompte()))
       {
      try {
                Parent root = FXMLLoader.load(getClass().getResource("interfaceUser1.fxml"));
                                Num.getScene().setRoot(root);

            } catch (IOException ex) {System.out.println(ex.getMessage());
            }
    }
                if ("Chasseur du talent".equals(Userconnected.getTypeCompte()))
       {
      try {
                Parent root = FXMLLoader.load(getClass().getResource("interfaceUser1.fxml"));
                                Num.getScene().setRoot(root);
 
            } catch (IOException ex) {System.out.println(ex.getMessage());
            }
    }
    }

    @FXML
    private void amis(MouseEvent event) throws IOException {
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("listAmis.fxml"));
                                Num.getScene().setRoot(root);

    
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

        }}
    
    
    
}
