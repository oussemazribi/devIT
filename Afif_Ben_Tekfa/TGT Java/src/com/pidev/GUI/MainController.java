/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author BENTEKFA
 */
public class MainController implements Initializable {

    @FXML
    private Button admin;
    @FXML
    private Button user;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void adminvisit(ActionEvent event) throws IOException {
                Parent root = FXMLLoader.load(getClass().getResource("interfaceadmin.fxml"));
                Stage stage=new Stage();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show(); 
   
    }

    @FXML
    private void uservisit(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("interfaceUser1.fxml"));
        Stage stage=new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show(); 
   
    }
    
}
