package com.pidev.GUI;

import com.pidev.Service.Mailing;
import com.pidev.Service.ServiceUser;
import com.pidev.Entite.User;
import java.io.File;
import java.io.FileInputStream;
//import java.io.FileInputStreimport java.io.InputStream;
import java.io.OutputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import static java.util.Locale.filter;
import java.util.Random;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class RegistrationController implements Initializable {

    String path;
     @FXML
    private String Imguser;
     @FXML
    private ImageView imageU;
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
    ComboBox<String> combo_typeCompte;
    ObservableList<String> compte = FXCollections.observableArrayList("Administrateur", "Chasseur du talent", "Utilisateur simple");
    @FXML
    ComboBox<String> combo_typeTalent;
    ObservableList<String> talent = FXCollections.observableArrayList("Dance", "Chant", "StandUP", "Dessin");
    User u = new User();

    Random r = new Random();
    static int nb_valider;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        combo_typeCompte.setItems(compte);
        combo_typeTalent.setItems(talent);
    }

    @FXML

    private void ajouter(ActionEvent event) throws IOException, Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Registration2.fxml"));

        try {
            Parent root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }

        ServiceUser service = new ServiceUser();
        User user = new User();
        if (service.Recherche_parLogin(txtLogin.getText()) == true) {
            lblResultat.setText("ce Login existe deja !!!");
            Alert alert = new Alert(Alert.AlertType.ERROR, "ce Login existe deja", ButtonType.CLOSE);
            alert.show();
        } else if (!txtEmail.getText().contains("@")) {
            lblResultat.setText("Email non valide!!");
            Alert alert = new Alert(Alert.AlertType.ERROR, "Adresse mail non valide", ButtonType.CLOSE);
            alert.show();
        } else if (txtPassword.getText().length() < 8) {
            lblResultat.setText("Le mot de passe doit contenir au moins 8 caractéres");
            Alert alert = new Alert(Alert.AlertType.ERROR, "Le mot de passe doit contenir au moins 8 caracteres", ButtonType.CLOSE);
            alert.show();
        } else if (txtTelephone.getText().length() < 8 || txtTelephone.getText().length() > 8) {
            lblResultat.setText("Numero Telephone different à 8 chiffres!!!");
            Alert alert = new Alert(Alert.AlertType.ERROR, "Numero de telephone  different a 8 chiffres !!!!", ButtonType.CLOSE);
            alert.show();
        } else if (txtNom.getText().isEmpty()) {
            lblResultat.setText("Saisir nom");
            Alert alert = new Alert(Alert.AlertType.ERROR, "Le champs NOm ne doit pas  etre vide !!!", ButtonType.CLOSE);
            alert.show();
        } else if (txtPrenom.getText().isEmpty()) {
            lblResultat.setText("Saisir prenom");
            Alert alert = new Alert(Alert.AlertType.ERROR, "Le champs PRENOM ne doit pas etre vide", ButtonType.CLOSE);
            alert.show();
        } else if (txtEmail.getText().isEmpty()) {
            lblResultat.setText("Saisir Email");
            Alert alert = new Alert(Alert.AlertType.ERROR, "MERCI DE REMPLIR LE CHAMPS EMAIL", ButtonType.CLOSE);
            alert.show();
        } else if (txtTelephone.toString().length() < 8) {
            lblResultat.setText("le num doit avoir 8 chiffre");
            Alert alert = new Alert(Alert.AlertType.ERROR, "LE CHAMPS NUMERO DOIT AVOIR 8 CHIFFRES !!!!", ButtonType.CLOSE);
            alert.show();
        } else if (combo_typeTalent.getItems() == null) {
            lblResultat.setText("le type de talent ne doit pas etre vide");
            Alert alert = new Alert(Alert.AlertType.ERROR, "vous devez choisir au moin un type de talent", ButtonType.CLOSE);
            alert.show();
        } else {
            nb_valider = r.nextInt(10000);
            Mailing.mailingValider(txtEmail.getText(), nb_valider);

              user.setNom(txtNom.getText());
                user.setPrenom(txtPrenom.getText());
                user.setEmail(txtEmail.getText());
                user.setLogin(txtLogin.getText());
                user.setMotDePasse(txtPassword.getText());
                LocalDate ld = date.getValue();
                String datenais = ld.toString();

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
                user.setImguser(Imguser);
            
            JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
            String txt_CodeConfirmation = jop.showInputDialog(null, "Merci de saisir le code de verification !", "Verification Adresse Mail", JOptionPane.QUESTION_MESSAGE);
            
            if (Integer.parseInt(txt_CodeConfirmation) == nb_valider) {
  
                try {
                    service.ajouter(user);
                      Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Bienvenue Mr(s) "+ txtNom.getText() , ButtonType.CLOSE);
            alert.show();
                    // redirection vers la page d'accueil
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
//                lblResultat.setText("Inscription valide !!");
            }else {
              Alert alert = new Alert(Alert.AlertType.ERROR, "Code incorrect", ButtonType.CLOSE);
                alert.show();
            }
        }
        //}

    }

//    @FXML
//    public void btnParcourir(ActionEvent event) throws IOException {
//
//        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
//
//        int returnValue = jfc.showOpenDialog(null);
//        // int returnValue = jfc.showSaveDialog(null);
//
//        if (returnValue == JFileChooser.APPROVE_OPTION) {
//            File selectedFile = jfc.getSelectedFile();
//            System.out.println(selectedFile.getAbsolutePath());
//            path = selectedFile.getAbsolutePath();
//            u.setImguser(path);
//
//        }
//
//    }
    
    @FXML
    public void ChoiceImage() throws FileNotFoundException, IOException {
        FileChooser fc = new FileChooser();
        //fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Images", listFichier));
        File f = fc.showOpenDialog(null);
        if (f != null) {

            //Commentaire.setText("Image selectionnée" + f.getAbsolutePath());
            InputStream is = null;
            OutputStream os = null;
            try {
                is = new FileInputStream(new File(f.getAbsolutePath()));
//             
                os = new FileOutputStream(new File("C:/wamp64/www/Image_PI/" + f.getName()));
                byte[] buffer = new byte[1024];
                int length;
                while ((length = is.read(buffer)) > 0) {
                    os.write(buffer, 0, length);
                }
                System.out.println("louay");

            } finally {
                is.close();
                os.close();

            }

            File file = new File("C:/wamp64/www/Image_PI/" + f.getName());
//            System.out.println(file.toURI().toString());
            imageU.setImage(new Image(file.toURI().toString()));
            Imguser = f.getName();
            System.out.println(Imguser);
        } else if (f == null) {
            //Commentaire.setText("Erreur chargement de l'image");
            System.out.println("Erreur !");
        }

    }
}
