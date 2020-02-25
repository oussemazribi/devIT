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
import com.pidev.Service.ServiceAnnonce;
import java.util.Optional;
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
    User u2 = new User(5, "montasser", "sellami", "aaaa", "montinho", "aaaa", "homme", "1996", 10101010, "Administrateur", "Dance", "null");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        try {
//            // TODO
//
//           // DetailAnnonce();
//        } catch (SQLException ex) {
//            Logger.getLogger(DetailAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }
    ServiceAnnonce ser = new ServiceAnnonce();

    void DetailAnnonce(int id, String Nom, String Description, int Prix, String Image, String Etatt, User u) throws SQLException {
        image = Image;
        idAnn = id;
        nom.setText(Nom);
        etat.setText(Etatt);
        descr.setText(Description);
        prix.setText(Integer.toString(Prix));
        File file = new File("C:/wamp64/www/Images_PI/" + Image);
        img.setImage(new Image(file.toURI().toString()));

        if (u2.getIdUser() == u.getIdUser()) {
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

    @FXML
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
        modif.ModifierAnnonce1(idd, Nom, Description, Prix,Etatt, image);
        Scene scene = new Scene(root2);

        window.setScene(scene);

        // nom.setText(a1.getNom());
        window.show();

    }

    @FXML
    private void main(MouseEvent event) {
    }

    @FXML
    private void chat1(MouseEvent event) {
    }

}
