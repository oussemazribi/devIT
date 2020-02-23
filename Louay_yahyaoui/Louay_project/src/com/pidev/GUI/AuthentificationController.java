/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.GUI;

import com.pidev.Service.ServiceUser;
import com.pidev.Entite.User;
import static com.pidev.GUI.tnGotTalent.Userconnected;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author HPENVY
 */
public class AuthentificationController implements Initializable {

    @FXML
    private TextField txtLogin;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Label lblerror;
    @FXML
    private Button btn1;
    @FXML
    private Button btnAccount;
    @FXML
    private Hyperlink mdpOublier;
     User user = new User();

    public void btnValider(ActionEvent event) throws IOException {

        ServiceUser service = new ServiceUser();
        user = service.Authentification(txtLogin.getText(), txtPassword.getText());
        transfertdonnées();
        System.out.println(Userconnected.toString());
        
        if (user.getIdUser()!=0 && user.getTypeCompte().equals("Chasseur du talent")) {
            
            FXMLLoader LOADER = new FXMLLoader(getClass().getResource("IntChasseur.fxml"));
            Parent Chasseur = LOADER.load();
            btn1.getScene().setRoot(Chasseur);
           // System.out.println(Userconnected.toString()); 
          

        } else if(user.getIdUser()!=0 && user.getTypeCompte().equals("Utilisateur simple"))
        {
            FXMLLoader LOADER = new FXMLLoader(getClass().getResource("UserInterface.fxml"));
            Parent user = LOADER.load();
            btn1.getScene().setRoot(user);
            
            
        }
//        else {
//            if (user.getTypeCompte() == "Administrateur") {
//                Stage stage = new Stage();
//                Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
//                Scene scene = new Scene(root);
//                stage.setScene(scene);
//                stage.show();
//
//            } else {
//                Stage stage = new Stage();
//                Parent root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
//                Scene scene = new Scene(root);
//                stage.setScene(scene);
//                stage.show();
                 
//            }
//        }
    }

    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void afficher(ActionEvent event) {

    }

//    public void Registre() {
//
//        try {
//            FXMLLoader LOADER = new FXMLLoader(getClass().getResource("Home.fxml"));
//            Parent Chasseur = LOADER.load();
//            btnAccount.getScene().setRoot(Chasseur);
//        } catch (IOException ex) {
//            Logger.getLogger(AuthentificationController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
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
