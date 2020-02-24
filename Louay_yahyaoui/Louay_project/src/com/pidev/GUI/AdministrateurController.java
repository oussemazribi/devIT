package com.pidev.GUI;

import com.pidev.Service.ServiceUser;
import com.pidev.Entite.User;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import static java.util.Locale.filter;
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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
public class AdministrateurController implements Initializable {
  @FXML
    private Label label;
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
    private TextField txtTelephone;
    @FXML
    private DatePicker date;
    @FXML
    private Button btnvalider;
    @FXML
    private Label lblResultat;
    @FXML
    private Button btnParcourir;
     @FXML
     ComboBox <String> combo_typeCompte ;
    ObservableList<String> compte = FXCollections.observableArrayList("Administrateur","Chasseur du talent","Utilisateur simple");
@FXML
     ComboBox <String> combo_typeTalent ;
ObservableList<String> talent = FXCollections.observableArrayList("Dance","Chant","StandUP","Dessin");    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        combo_typeCompte.setItems(compte);
     combo_typeTalent.setItems(talent);
    } 
    @FXML
 private void ajouter(ActionEvent event) throws IOException{
        
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Administrateur(ajout).fxml"));

        try {
            Parent root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }

        ServiceUser service = new ServiceUser();
        User user = new User();
        if (service.Recherche_parLogin(txtLogin.getText()) == true) {
            lblResultat.setText("ce Login existe deja !!!");
          Alert alert=new Alert(Alert.AlertType.ERROR, "ce Login existe deja", ButtonType.CLOSE);
                alert.show();
        }
      
       else if (!txtEmail.getText().contains("@")) {
          lblResultat.setText("Email non valide!!");
            Alert alert=new Alert(Alert.AlertType.ERROR, "Adresse mail non valide", ButtonType.CLOSE);
                alert.show();
        }
     else if (txtPassword.getText().length() < 8) {
      lblResultat.setText("Le mot de passe doit contenir au moins 8 caractéres");
  Alert alert=new Alert(Alert.AlertType.ERROR, "Le mot de passe doit contenir au moins 8 caracteres", ButtonType.CLOSE);
                alert.show();
     } 
      else if (txtTelephone.getText().length() < 8 || txtTelephone.getText().length() > 8) {
          lblResultat.setText("Numero Telephone different à 8 chiffres!!!");
            Alert alert=new Alert(Alert.AlertType.ERROR, "Numero de telephone  different a 8 chiffres !!!!", ButtonType.CLOSE);
                alert.show();
        }
       else if (txtNom.getText().isEmpty()) {
            lblResultat.setText("Saisir nom");
  Alert alert=new Alert(Alert.AlertType.ERROR, "Le champs NOm ne doit pas  etre vide !!!", ButtonType.CLOSE);
                alert.show();
       } 
       else if (txtPrenom.getText().isEmpty()) {
          lblResultat.setText("Saisir prenom");
            Alert alert=new Alert(Alert.AlertType.ERROR, "Le champs PRENOM ne doit pas etre vide", ButtonType.CLOSE);
                alert.show();
      }
        else if (txtEmail.getText().isEmpty()) {
            lblResultat.setText("Saisir Email");
  Alert alert=new Alert(Alert.AlertType.ERROR, "MERCI DE REMPLIR LE CHAMPS EMAIL", ButtonType.CLOSE);
                alert.show();
        } 
        else if (txtTelephone.toString().length() < 8  ) {
            lblResultat.setText("le num doit avoir 8 chiffre");
          Alert alert=new Alert(Alert.AlertType.ERROR, "LE CHAMPS NUMERO DOIT AVOIR 8 CHIFFRES !!!!", ButtonType.CLOSE);
                alert.show();
        }
          else if (combo_typeTalent.getItems() == null) {
            lblResultat.setText("le num doit avoir 8 chiffre");
          Alert alert=new Alert(Alert.AlertType.ERROR, "vous devez choisir au moin un type de talent", ButtonType.CLOSE);
                alert.show();}
 else {

            user.setNom(txtNom.getText());
            user.setPrenom(txtPrenom.getText());
            user.setEmail(txtEmail.getText());
            user.setLogin(txtLogin.getText());
            user.setMotDePasse(txtPassword.getText());
            LocalDate ld = date.getValue();
            String datenais = ld.toString() ;
            

            user.setDateNaissance(datenais);
            if (rbHomme.isSelected()) {
                user.setSexe(rbHomme.getText());
            } else {
                user.setSexe(rbFemme.getText());
            }
           int num = Integer.parseInt(txtTelephone.getText());
            user.setNumTelephone(num);
            
           user.setTypeTalent(combo_typeTalent.getValue());
           user.setTypeCompte(combo_typeCompte.getValue());
           user.setImguser(btnParcourir.getText());
           
           

            
            
            user.setTypeCompte("Utilisateur");
            user.setImguser("null");
            
            try {
                service.ajouter(user);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            lblResultat.setText("utilisateur "+txtLogin.getText()+"ajouté avec succes");}
        //}

    } 
 public void btnParcourir(ActionEvent event) throws IOException{

		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

		int returnValue = jfc.showOpenDialog(null);
		// int returnValue = jfc.showSaveDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jfc.getSelectedFile();
			System.out.println(selectedFile.getAbsolutePath());
		}

	}
    
}
