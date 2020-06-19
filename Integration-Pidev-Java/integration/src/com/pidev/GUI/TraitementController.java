/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.GUI;

import com.pidev.Service.ServiceReclamation;
import com.pidev.Entite.Reclamation;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static com.pidev.GUI.InterfaceadminController.rr;

/**
 * FXML Controller class
 *
 * @author BENTEKFA
 */
public class TraitementController implements Initializable {

    @FXML
    private Label iduser;
    @FXML
    private Button completer;
    @FXML
    private Label objet;
 
    @FXML
    private ImageView image;

    /**
     * Initializes the controller class.
     */
    /*********************************************/
    ServiceReclamation ser=new ServiceReclamation();
    Reclamation rrr=rr;
    @FXML
    private Label texte23;
    
    /********************************************/
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        iduser.setText(Integer.toString(rrr.getIdUser()));
        objet.setText(rrr.getObjet());
        texte23.setText(rrr.getDescription());
        
        /*Image capt=new Image(rr.getPhoto());
        image.setImage(capt);*/
        // TODO
    }    

    @FXML
    private void modifier(ActionEvent event) throws SQLException {
        int iduser=rrr.getIdUser();
        String objet=rrr.getObjet();
        String desc=rrr.getDescription();
        String photo=rrr.getPhoto();
        String etatp=rrr.getEtat();
        String netat="traité";
        Reclamation r=new Reclamation(iduser,objet,desc,photo,etatp);
        ser.update(objet, desc, photo, netat, r);
        
                
        
        
    }
    
}
