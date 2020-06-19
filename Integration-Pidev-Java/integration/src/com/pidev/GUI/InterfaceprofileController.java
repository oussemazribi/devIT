/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.GUI;

import static com.pidev.GUI.Integration.Userconnected;
import com.pidev.Service.ServicePCVR;
import com.pidev.Service.ServicePublication;
import com.pidev.Entite.Commentaire;
import com.pidev.Entite.Publication;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class InterfaceprofileController implements Initializable {

    @FXML
    private ListView<Publication> listepublication;
    @FXML
    private Button ajouter;
    @FXML
    private Button bloquer;
    @FXML
    private Button retirer;
    ServicePublication serp=new ServicePublication();
    ServicePCVR serPCVR= new ServicePCVR();
     List<Publication> l1;
     List<Commentaire> l2;
    PublicationCellFactory cp;
    /**
     * Initializes the controller class.
     */
        public InterfaceprofileController() {
        this.cp = new PublicationCellFactory();
        this.listepublication = new ListView<Publication>();
    }
     
     /*********************************/
    InputStream im =getClass().getResourceAsStream("/image/download.png");
    Image imageuser1 = new Image(im);
    @FXML
 
    ImageView imageuser ;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                  try {
     l1=serp.showpublicationbyuser(Userconnected.getId());
           } catch (SQLException ex) {
            System.out.println(ex.getMessage());
           }
          listepublication.setCellFactory(cp);
          listepublication.getItems().addAll(l1);
           /*ajout.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;-fx-background-radius: 10px;"); 
           actualiser.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;-fx-background-radius: 10px;");*/
            InputStream input1 =getClass().getResourceAsStream("/image/ajouter-100-.png");
            InputStream input2 =getClass().getResourceAsStream("/image/actualiser-90-.png");
            
            
 
        Image image = new Image(input1);
        Image image1 = new Image(input2);
        
        ImageView imageView1 = new ImageView(image);
        ImageView imageView2 = new ImageView(image1);
        imageuser.setImage(imageuser1);
       /* ajout.setGraphic(imageView1);
        actualiser.setGraphic(imageView2);*/
    }  
       

    
}
