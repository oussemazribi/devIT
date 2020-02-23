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
    private Label descr;
    @FXML
    private ImageView img;

    User u2 = new User(6, "montasser", "sellami", "aaaa", "montinho", "aaaa", "homme", "1996", 10101010, "Administrateur", "Dance", "null");



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

    void DetailAnnonce(String Nom,String Description, int Prix, String Image, User u) throws SQLException {

        nom.setText(Nom);
        descr.setText(Description);
        prix.setText(Integer.toString(Prix));
        File file = new File("C:/wamp64/www/Images_PI/" +Image);
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

}
