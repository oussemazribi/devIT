/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.GUI;

import com.pidev.Service.ServiceUser;
import com.pidev.Entite.User;
import static com.pidev.GUI.Integration.Userconnected;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HPENVY
 */
public class AuthentificationController implements Initializable {
   
    
    
    @FXML
     private Hyperlink btnIns;
    @FXML
     private ImageView login;
    @FXML
     private ImageView text;
    @FXML
     private ImageView mdp;
    @FXML
    private TextField txtLogin;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Button btn1;
    

    User user =new User();
    
    @FXML
    public void btnValider(ActionEvent event) throws IOException {

        ServiceUser service = new ServiceUser();
        
        user = service.Authentification(txtLogin.getText(), txtPassword.getText());
        if (user.getIdUser() == 0) {
           Alert alert=new Alert(Alert.AlertType.ERROR, "cet utlisateur n'existe pas dans la BD", ButtonType.CLOSE);
                     alert.show();  
          
        } 
        else  
        { //Alert alert=new Alert(Alert.AlertType.CONFIRMATION, "Bienvenue Mr(s)"+user.getNom()+"", ButtonType.OK);
                    //  alert.show();
            if ("Administrateur".equals(user.getTypeCompte())) 
            {  transfertdonnées();
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("Modifier_utlisateur.fxml"));
                btn1.getScene().setRoot(root);
//                Scene scene = new Scene(root);
//                stage.setScene(scene);
//                stage.show();

            } else if ("Chasseur du talent".equals(user.getTypeCompte()))  {
                transfertdonnées();
                  Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("Home_1.fxml"));
                btn1.getScene().setRoot(root);
//                Scene scene = new Scene(root);
//                stage.setScene(scene);
//                stage.show();
            }else if ("Utilisateur simple".equals(user.getTypeCompte()))  {
                transfertdonnées();
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("Home_1.fxml"));
                        btn1.getScene().setRoot(root);
//                Scene scene = new Scene(root);
//                stage.setScene(scene);
//                stage.show();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    /**
     *
     * @param event
     * @throws java.io.IOException
     */
    @FXML
    public void btnIns(ActionEvent event) throws IOException{
 Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("Registration2.fxml"));
                btn1.getScene().setRoot(root);
//                Scene scene = new Scene(root);
//                stage.setScene(scene);
//                stage.show();
}
   public void transfertdonnées()
    {
        ServiceUser service = new ServiceUser();
        User user1 = service.Authentification(txtLogin.getText(), txtPassword.getText());
        Userconnected.setIdUser(user1.getIdUser());
        Userconnected.setNom(user1.getNom());
        Userconnected.setPrenom(user1.getPrenom());
        Userconnected.setLogin(user1.getLogin());
        Userconnected.setMotDePasse(user1.getMotDePasse());
        Userconnected.setDateNaissance(user1.getDateNaissance());
        Userconnected.setEmail(user1.getEmail());
        Userconnected.setNumTelephone(user1.getNumTelephone());
        Userconnected.setImguser(user1.getImguser());
        Userconnected.setNbDiament(user1.getNbDiament());
        Userconnected.setTypeCompte(user1.getTypeCompte());
        Userconnected.setTypeTalent(user1.getTypeTalent());
        Userconnected.setSexe(user1.getSexe());
       Userconnected=user1;
        System.out.println(Userconnected.toString());
        
    }

 
}
