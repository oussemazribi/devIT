/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.GUI;

import com.pidev.Entite.User;
import com.sun.imageio.plugins.common.ImageUtil;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;


public class Profile_userController implements Initializable {

     @FXML
     public ImageView ImageU;
     @FXML
     public Label Nom;
     @FXML
     public Label Prenom;
     @FXML
     public Label Num;
     @FXML
     public Label Email;
     @FXML
     public Label Talent;
     @FXML
     public Label idRecup;
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    public void setDetails(User userSel)
    {
        File file = new File("C:/wamp64/www/Image_PI/" + userSel.getImguser());

        ImageU.setImage(new Image(file.toURI().toString()));
        System.out.println(userSel.getImguser());
        Nom.setText(userSel.getNom());
        System.out.println(userSel.getNom());
        Prenom.setText(userSel.getPrenom());
        System.out.println(userSel.getPrenom());
        Num.setText(Integer.toString(userSel.getNumTelephone()));
        System.out.println(userSel.getNumTelephone());
        Email.setText(userSel.getEmail());
        System.out.println(userSel.getEmail());
        Talent.setText(userSel.getTypeTalent());
        System.out.println(userSel.getTypeTalent());
        idRecup.setText(Integer.toString(userSel.getIdUser()));
        System.out.println(userSel.getIdUser());
        
        
    }
    
    
    
}
