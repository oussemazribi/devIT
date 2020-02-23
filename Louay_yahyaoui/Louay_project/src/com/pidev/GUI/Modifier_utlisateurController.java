/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.GUI;

import com.pidev.Service.ServiceUser;
import com.pidev.Entite.User;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;


public class Modifier_utlisateurController implements Initializable {
     private Connection con;
    private Statement ste;
 private PreparedStatement ste1;
@FXML
private TextField txtID;
 @FXML
    private TextField txtNom;
    @FXML
    private TextField txtPrenom;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtLogin;
    @FXML
    private PasswordField txtPassword;

    @FXML
    private RadioButton rbHomme;
    @FXML
    private RadioButton rbFemme;
     @FXML
    private Button btnChercher;
     @FXML
    private Button btnReset ;
    @FXML
    private TextField txtTelephone;
    @FXML
    private Label date;
    @FXML
    private Button btnAppliquer;
    @FXML
    private Label l1 ;
     @FXML
             
     ComboBox <String> combo_typeCompte ;
    ObservableList<String> compte = FXCollections.observableArrayList("Administrateur","Chasseur du talent","Utilisateur simple");
@FXML
     ComboBox <String> combo_typeTalent ;
ObservableList<String> talent = FXCollections.observableArrayList("Dance","Chant","StandUP","Dessin");  
ServiceUser service = new ServiceUser();


    @Override
    public void initialize(URL url, ResourceBundle rb) {
           combo_typeCompte.setItems(compte);
     combo_typeTalent.setItems(talent);
    }    
    
    public void btnChercher (ActionEvent event)throws IOException, SQLException{
    FXMLLoader loader = new FXMLLoader(getClass().getResource("Modifier_utlisateur.fxml"));
    
          try {
            Parent root1 = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
          
         User u = new User();
         int num = Integer.parseInt(txtID.getText()); 
         u=service.Recherche_parID(num);
         
                  if(u==null)
            
                  {
                      Alert alert=new Alert(Alert.AlertType.ERROR, "cet utlisateur n'existe pas dans la BD", ButtonType.CLOSE);
                      alert.show();
                  } else {  
                      txtNom.setText(u.getNom());
                      txtPrenom.setText(u.getPrenom());
                      txtEmail.setText(u.getEmail());
                      txtLogin.setText(u.getLogin());
                      txtPassword.setText(u.getMotDePasse());
                      
                   String date1 = u.getDateNaissance();
                      date.setText(date1);   
                    combo_typeCompte.setValue(u.getTypeCompte());
                    combo_typeTalent.setValue(u.getTypeTalent());
                      
                  }


                
       
         }

 public void btnReset (ActionEvent event)throws IOException, SQLException
 {
 
 }
 public void btnSupprimer (ActionEvent event)throws IOException, SQLException{    
 }
  public void btnAppliquer (ActionEvent event)throws IOException, SQLException{
  }

}
        
            
       
            
           
            
      
       
        
        
    
      

