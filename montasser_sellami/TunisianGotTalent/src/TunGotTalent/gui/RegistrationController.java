/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TunGotTalent.gui;

import TunGotTalent.Service.ServiceUser;
import TunGotTalent.entities.User;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class RegistrationController implements Initializable {

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
    private RadioButton combo_Dance;
    @FXML
    private RadioButton combo_Chant;
    @FXML
    private RadioButton combo_Dessin;
    @FXML
    private RadioButton combo_StandUp;
    @FXML
    private Button btnvalider;
    @FXML
    private Label lblResultat;
    @FXML
    private Button btnParcourir;

// parcourir bouttonn (image)
//    public void parcourir() {
//        JFileChooser fc = new JFileChooser();
//        FileNameExtensionFilter filter = new FileNameExtensionFilter("IMAGE", "jpg", "png");
//        fc.addChoosableFileFilter(filter);
//        int result = fc.showSaveDialog(null);
//    }
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
    }
    
    @FXML
    private void ajouter(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Registration.fxml"));

        try {
            Parent root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }

        ServiceUser service = new ServiceUser();
        User user = new User();
        /*if (service.Recherche_parLogin(txtLogin.getText()) == true) {
            lblResultat.setText("Login existe deja !!!");
        } else if (!txtEmail.getText().contains("@")) {
            lblResultat.setText("Email non valide!!");

        } else if (txtPassword.getText().length() < 8) {
            lblResultat.setText("Le mot de passe doit contenir au moins 8 caractéres");
        } else if (txtTelephone.getText().length() < 8 || txtTelephone.getText().length() > 8) {
            lblResultat.setText("Numero Telephone different à 8 chiffres!!!");
        } else if (txtNom.getText().isEmpty()) {
            lblResultat.setText("Saisir nom");
        } else if (txtPrenom.getText().isEmpty()) {
            lblResultat.setText("Saisir prenom");
        } else if (txtEmail.getText().isEmpty()) {
            lblResultat.setText("Saisir Email");
        } else if (txtTelephone.toString().length() < 8) {
            lblResultat.setText("le num doit avoir 8 chiffre");
        } else {
*/
            user.setNom(txtNom.getText());
            user.setPrenom(txtPrenom.getText());
            user.setEmail(txtEmail.getText());
            user.setLogin(txtLogin.getText());
            user.setMotDePasse("zdz");

            user.setDateNaissance("1996");
            /*if (rbHomme.isSelected()) {
                user.setSexe(rbHomme.getText());
            } else {
                user.setSexe(rbFemme.getText());
            }*/
            user.setSexe("homme");
            user.setNumTelephone(20202020);
            user.setTypeTalent("Danse");
            user.setTypeCompte("Utilisateur");
            user.setImguser("null");
            
            try {
                service.ajouter(user);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            lblResultat.setText("Inscription valide !!");
        //}

    }
}
