/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @author loume78
 */
public class HomeController implements Initializable {

    
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    
    public void startChasseur(ActionEvent event) throws IOException {
        FXMLLoader LOADER = new FXMLLoader(getClass().getResource("AfficherCompetition.fxml"));
        Parent rootChasseur = LOADER.load();
        button1.getScene().setRoot(rootChasseur);
//        Scene scene = new Scene(rootChasseur);
//        
//        Stage primaryStage = new Stage();
//        primaryStage.setScene(scene);
//        primaryStage.show();
            
        
        
        
       
    }
    public void startUser(ActionEvent event) throws IOException {
        
        
       FXMLLoader LOADER = new FXMLLoader(getClass().getResource("AffichageUser.fxml"));
        Parent rootUser = LOADER.load();
         button2.getScene().setRoot(rootUser);
        
        
        
       
    }
    
   public void start(ActionEvent event) throws IOException {
        
        
       FXMLLoader LOADER = new FXMLLoader(getClass().getResource("VerifTicket.fxml"));
        Parent root = LOADER.load();
         button3.getScene().setRoot(root);
        
        
        
       
    }
    
}
