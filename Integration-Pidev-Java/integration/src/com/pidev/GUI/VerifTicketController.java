/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.GUI;

import com.pidev.Entite.Competition;
import com.pidev.Entite.Ticket;
import com.pidev.Entite.User;
import com.pidev.Service.ServiceCompetition;
import com.pidev.Service.ServiceTicket;
import com.pidev.Service.ServiceUser;
import com.sun.javafx.scene.control.skin.ButtonSkin;
import com.twilio.rest.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author loume78
 */
public class VerifTicketController implements Initializable {

    @FXML
    public ComboBox<String> comboTitre;
    
    @FXML
    public PasswordField mdp;
    
    
    
    public void Afficher()
    {
        ServiceCompetition serC = new ServiceCompetition();
        ObservableList<String> list;
        try {
            list = FXCollections.observableArrayList(serC.Select());
            comboTitre.setItems(list);
        } catch (SQLException ex) {
            Logger.getLogger(VerifTicketController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
//    public void SMS()
//     {
//   
//
//           
//    
//        Twilio.init("AC8fc62d0cb544b63cfaa31f5d26e51d04", "5dccfaca0e25cf8c6b1e78bbc7f11a67");
//        Message message = Message.creator(
//                new com.twilio.type.PhoneNumber("+21623422387"),
//                new com.twilio.type.PhoneNumber("+16504377051"),
//                "Participation avec succes ! ").create();
//            
//            
//
//        System.out.println(message.getSid());
//        System.out.println("louay");
//         
//     }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Afficher();
        //Twilio.init("AC8fc62d0cb544b63cfaa31f5d26e51d04", "5dccfaca0e25cf8c6b1e78bbc7f11a67");
    }    
    
    public void VerifTicket()
    {
        try {
            User userTest = new User(102, "oussema", "zribi", "zribi@esprit.tn", "zribi", "oussema", "femme", "28-08-1992", 234223878, "SimpleUtilisateur", "Comedie", "hahaha", 5000);
            //sString log=num.getText();
            String mdpass=mdp.getText();
            String titre=comboTitre.getSelectionModel().getSelectedItem();
            ServiceCompetition serC = new ServiceCompetition();
            
            Competition comp=serC.SelectTitre(titre);
            
            ServiceUser s1 = new ServiceUser();
            ServiceTicket s2 = new ServiceTicket();
            boolean test = false;
            
            test = s2.findByMDP2(mdpass);
            
            Ticket tik = new Ticket();
            tik = s2.findByMDP(mdpass);
            
            if (test == false) {
                Alert alert=new Alert(Alert.AlertType.ERROR, "Mot de passe incorrecte", ButtonType.CLOSE);
                alert.show();
                
            } else {
                System.err.println("chargement...");
                if (tik.getUser().getIdUser() == userTest.getIdUser()) {
                    
                    if (tik.getCompetition().getIdCompetition() == comp.getIdCompetition()) {
                        Alert alert=new Alert(Alert.AlertType.CONFIRMATION, "je vous souhaite la bienvenue !", ButtonType.OK);
                        alert.show();
                        
                        
                        
                        
                        System.out.println("je vous souhaite la bienvenue ! ");
                        
                    } else {
                        Alert alert=new Alert(Alert.AlertType.ERROR, "cette ticket appartient a un autre evenement", ButtonType.CLOSE);
                        alert.show();
                        System.err.println("cette ticket appartient a un autre evenement");
                    }
                } else {
                    Alert alert=new Alert(Alert.AlertType.ERROR, "verifier votre ticket", ButtonType.CLOSE);
                    alert.show();
                    System.err.println("verifier votre ticket");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(VerifTicketController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
        
        
        
    }
    
    
    
}
