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
import java.util.Optional;
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
import javafx.scene.input.MouseEvent;
import javax.mail.Service;


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
    private Button btnSupprimer;
     @FXML
             
     ComboBox <String> combo_typeCompte ;
    ObservableList<String> compte = FXCollections.observableArrayList("Administrateur","Chasseur du talent","Utilisateur simple");
@FXML
     ComboBox <String> combo_typeTalent ;
ObservableList<String> talent = FXCollections.observableArrayList("Dance","Chant","StandUP","Dessin");  
ServiceUser service = new ServiceUser();
User u = new User();


    @Override
    public void initialize(URL url, ResourceBundle rb) {
           combo_typeCompte.setItems(compte);
     combo_typeTalent.setItems(talent);
    }    
    
    @FXML
    public void btnChercher (ActionEvent event)throws IOException, SQLException{
    FXMLLoader loader = new FXMLLoader(getClass().getResource("Modifier_utlisateur.fxml"));
    
          try {
            Parent root1 = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
          
//         User u = new User();
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
                      String num1 = String.valueOf(u.getNumTelephone());
                      
                      txtTelephone.setText(num1);
                      
                      
                   String date1 = u.getDateNaissance();
                      date.setText(date1);   
                    combo_typeCompte.setValue(u.getTypeCompte());
                    combo_typeTalent.setValue(u.getTypeTalent());
                 if (u.getSexe().equals("Homme")){
                  rbHomme.isSelected() ;    
                  }else { 
                   rbFemme.isSelected();   
                  }    
                  }
                


                
       
         }

    @FXML
 public void btnReset (ActionEvent event)throws IOException, SQLException
 {
 
 FXMLLoader loader = new FXMLLoader(getClass().getResource("Modifier_utlisateur.fxml"));
    
          try {
            Parent root1 = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtID.setText("");
        txtNom.setText("");
        txtPrenom.setText("");
        txtLogin.setText(""); 
        txtEmail.setText("");
        txtPassword.setText("");
        txtTelephone.setText("");
        date.setText("");
        combo_typeCompte.setItems(null);
        combo_typeTalent.setItems(null);
 }
    @FXML
 public void btnSupprimer (ActionEvent event)throws IOException, SQLException{  
    // User u = new User();
       int num = Integer.parseInt(txtID.getText());
     u= service.Recherche_parID(num);
    // ServiceUser service = new ServiceUser();
     Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
     alert.setTitle("Suppression");
     alert.setContentText("voulez-vous vraiment supprimer cet utilisateur");
     Optional<ButtonType> result = alert.showAndWait();
     if (result.get()== ButtonType.OK){
      
    service.delete(u);
     txtID.setText("");
        txtNom.setText("");
        txtPrenom.setText("");
        txtLogin.setText(""); 
        txtEmail.setText("");
        txtPassword.setText("");
        txtTelephone.setText("");
        date.setText("");
        combo_typeCompte.setItems(null);
        combo_typeTalent.setItems(null);
    
    
    
 }}
    @FXML
  public void btnAppliquer (ActionEvent event)throws IOException, SQLException{
   //  User u = new User();
     int num = Integer.parseInt(txtID.getText());
    
     
     Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
     alert.setTitle("MODIFICATION");
     alert.setContentText("voulez-vous vraiment modifier les données de cet utilisateur");
    Optional<ButtonType> result = alert.showAndWait();
     if (result.get()== ButtonType.OK){  
         String type=combo_typeTalent.getValue();
         String sexe="";
        
       service.update(txtNom.getText(),txtPrenom.getText(),txtEmail.getText() ,txtLogin.getText(),txtPassword.getText(),sexe ,date.getText() ,Integer.valueOf(txtTelephone.getText()),combo_typeCompte.getValue() ,type,"",5,num);
      
    }

}

    @FXML
    private void main(MouseEvent event) {
    }

    @FXML
    private void chat1(MouseEvent event) {
    }
}
        
            
       
            
           
            
      
       
        
        
    
      

