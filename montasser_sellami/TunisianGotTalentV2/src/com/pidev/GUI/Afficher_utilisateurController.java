/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.GUI;

import com.pidev.Service.ServiceUser;
import com.pidev.Entite.User;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javax.swing.table.TableColumn;

/**
 * FXML Controller class
 *
 * @author HPENVY
 */
public class Afficher_utilisateurController implements Initializable {

    @FXML
private TableColumn id;
 @FXML
    private TableColumn <User, u> nom;
    @FXML
    private TableColumn prenom;
    @FXML
    private TableColumn email;
    @FXML
    private TableColumn login;
    @FXML
    private TableColumn Mdp;

    @FXML
    private TableColumn sexe ;
     @FXML
    private TableColumn date;
     @FXML
    private TableColumn num ;
    @FXML
    private TableColumn compte;
    @FXML
    private TableColumn talent;
    @FXML
    private TableColumn nbd;
    @FXML
    private Button btnGenerer_list ;
    ServiceUser ser = new ServiceUser();
    User u = new User();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }  
  public void btnGenerer_list (ActionEvent event) throws SQLException{
  ;
  nom.setIdentifier();
  u.ser.readAll();
  }
    
    
}
