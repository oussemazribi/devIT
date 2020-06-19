/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.GUI;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import com.pidev.Entite.Annonce;
import com.pidev.Entite.User;
import static com.pidev.GUI.Integration.Userconnected;
import com.pidev.Service.ServiceAnnonce;
import com.pidev.Service.ServiceUser;
import java.util.Optional;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ousse
 */
public class DetailAnnonceController implements Initializable {

    @FXML
    private Button annuler;
    @FXML
    private Button edit;
    @FXML
    private Button supp;
    @FXML
    private Label prix;
    @FXML
    private Label nom;
    @FXML
    private Label etat;
    @FXML
    private Label descr;
    @FXML
    private ImageView img;

    private String image;

    int idAnn;
    ServiceUser su = new ServiceUser();

    // User u2 = new User(6, "montasser", "sellami", "aaaa", "montinho", "aaaa", "homme", "1996", 10101010, "Administrateur", "Dance", "null");
    @FXML
    private ImageView UserImage;
    @FXML
    private Label UserName;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            String im = su.findbyImage(Userconnected.getIdUser());
            File file = new File("C:/xampp/htdocs/Image_Pi/" + im);
            UserImage.setImage(new Image(file.toURI().toString()));
            String alo = su.findByIdname(Userconnected.getIdUser());
            String friendlastname = su.findByIlastname(Userconnected.getIdUser());
            UserName.setText(alo + " " + friendlastname);
//        try {
//            // TODO
//
//           // DetailAnnonce();
//        } catch (SQLException ex) {
//            Logger.getLogger(DetailAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
//        }
        } catch (SQLException ex) {
            Logger.getLogger(DetailAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    ServiceAnnonce ser = new ServiceAnnonce();

    void DetailAnnonce(int id, String Nom, String Description, int Prix, String Image, String Etatt, User u) throws SQLException {
        image = Image;
        idAnn = id;
        nom.setText(Nom);
        etat.setText(Etatt);
        descr.setText(Description);
        prix.setText(Integer.toString(Prix));
        File file = new File("C:/xampp/htdocs/Image_Pi/" + Image);
        img.setImage(new Image(file.toURI().toString()));

        if (Userconnected.getIdUser() == u.getIdUser()) {
            edit.setVisible(true);
            supp.setVisible(true);

        } else {
            edit.setVisible(false);
            supp.setVisible(false);
        }

    }

    @FXML
    private void Annuler(ActionEvent event) throws IOException {
        FXMLLoader LOADER = new FXMLLoader(getClass().getResource("AffichageAnnonce.fxml"));
        Parent root1 = LOADER.load();
        annuler.getScene().setRoot(root1);
    }

    public void btnSupprimerAction(ActionEvent event) throws IOException, SQLException {
        ServiceAnnonce ser = new ServiceAnnonce();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

//        quitter = new ImageView(new Image(getClass().getResourceAsStream("/add.png")));
//        btnQuitter.setGraphic(quitter);
        alert.setTitle("Suppression ");
        alert.setContentText("Voulez-vous vraiment supprimer cette Competition ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            ser.delete(ser.findById(idAnn));
            FXMLLoader LOADER = new FXMLLoader(getClass().getResource("AffichageAnnonce.fxml"));
            Parent root1 = LOADER.load();
            supp.getScene().setRoot(root1);
        } else {
            FXMLLoader LOADER = new FXMLLoader(getClass().getResource("AffichageAnnonce.fxml"));
            Parent root1 = LOADER.load();
            supp.getScene().setRoot(root1);

        }
    }

    @FXML
    public void btnModifierAction(ActionEvent event) throws IOException {

        int idd = idAnn;
        String Nom = nom.getText();
        String Description = descr.getText();
        String Etatt = etat.getText();
        int Prix = Integer.parseInt(prix.getText());

//        FXMLLoader LOADER = new FXMLLoader(getClass().getResource("modifierAnnonce.fxml"));
//        Parent root2 = LOADER.load();
//        edit.getScene().setRoot(root2);
//        ModifierAnnonceController modif = LOADER.getController();
//                modif.ModifierAnnonce1(idd, Nom, Description, Prix, image);
        Stage window = new Stage();

        // Parent root2;
        FXMLLoader LOADER = new FXMLLoader(getClass().getResource("modifierAnnonce.fxml"));

        Parent root2 = LOADER.load();
        ModifierAnnonceController modif = LOADER.getController();
        //System.out.println("=== Nom: "+Nom);
        modif.ModifierAnnonce1(idd, Nom, Description, Prix, Etatt, image);
        Scene scene = new Scene(root2);

        window.setScene(scene);

        // nom.setText(a1.getNom());
        window.show();

    }

    @FXML
    private void chat1(MouseEvent event) {
        FXMLLoader LOADER = new FXMLLoader(getClass().getResource("Conversations.fxml"));
        try {
            Parent root = LOADER.load();
            Scene rana = new Scene(root);
            ConversationsController hamza = LOADER.getController();
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(rana);
            window.show();
        } catch (IOException ex) {

        }
    }

    @FXML
    private void competition(MouseEvent event) {
        if ("Chasseur du talent".equals(Userconnected.getTypeCompte())) {
            FXMLLoader LOADER = new FXMLLoader(getClass().getResource("IntChasseur.fxml"));
            try {
                Parent root = LOADER.load();
                Scene rana = new Scene(root);
                IntChasseurController hamza = LOADER.getController();
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

                window.setScene(rana);
                window.show();
            } catch (IOException ex) {

            }
        }
        if ("Utilisateur simple".equals(Userconnected.getTypeCompte())) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("UserInterface.fxml"));
                annuler.getScene().setRoot(root);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    @FXML
    private void annonce(MouseEvent event) {
        FXMLLoader LOADER = new FXMLLoader(getClass().getResource("AffichageAnnonce.fxml"));
        try {
            Parent root = LOADER.load();
            Scene rana = new Scene(root);
            AffichageAnnonceController hamza = LOADER.getController();
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(rana);
            window.show();
        } catch (IOException ex) {

        }
    }

    @FXML
    private void reclamation(MouseEvent event) {
        if ("Administrateur".equals(Userconnected.getTypeCompte())) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("interfaceadmin.fxml"));
                annuler.getScene().setRoot(root);
//                Stage stage = new Stage();
//                Scene scene = new Scene(root);
//                stage.setScene(scene);
//                stage.show();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        if ("Utilisateur simple".equals(Userconnected.getTypeCompte())) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("interfaceUser1.fxml"));
                annuler.getScene().setRoot(root);

//                Stage stage = new Stage();
//                Scene scene = new Scene(root);
//                stage.setScene(scene);
//                stage.show();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        if ("Chasseur du talent".equals(Userconnected.getTypeCompte())) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("interfaceUser1.fxml"));
                annuler.getScene().setRoot(root);

//                Stage stage = new Stage();
//                Scene scene = new Scene(root);
//                stage.setScene(scene);
//                stage.show();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    @FXML
    private void amis(MouseEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("listAmis.fxml"));
        annuler.getScene().setRoot(root);

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
