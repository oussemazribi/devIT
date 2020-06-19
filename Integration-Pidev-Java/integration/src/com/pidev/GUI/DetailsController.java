/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.GUI;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.TextFlow;

public class DetailsController implements Initializable {

    @FXML
    private Label titre;
    @FXML
    private Label description;
    @FXML
    private Label dated;
    @FXML
    private Label datef;
    @FXML
    private Label type;
    @FXML
    private Label cout;
    @FXML
    private ImageView image;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setDetails(String Titre, String Description, String Image, String DateD, String DateF,String Type,int Cout) {

        titre.setText(Titre);
        description.setText(Description);
        File file = new File("C:/xampp/htdocs/Image_Pi/" + Image);
       

        image.setImage(new Image(file.toURI().toString()));
        dated.setText(DateD);
        datef.setText(DateF);
        type.setText(Type);
        cout.setText(Integer.toString(Cout));
       

    }

}
