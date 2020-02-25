/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.Test;
import com.pidev.Service.DemandeAmitie;
import com.pidev.Service.GeneratePDF;
import com.pidev.Service.Mailing;
import com.pidev.Service.ServiceUser;
import com.pidev.Entite.Amitie;
import com.pidev.Entite.User;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.mail.MessagingException;

/**
 *
 * @author HPENVY
 */
public class test  {
static User Userconnected = new User ();
    private Stage stage;
    private Parent parent;

//    @Override
//    public void start(Stage primaryStage) throws Exception {
//
//        this.stage = primaryStage;
//        parent = FXMLLoader.load(getClass().getResource("/TunGotTalent/gui/Registration.fxml"));
//        Scene scene = new Scene(parent);
//        stage.setScene(scene);
//        stage.show();
//    }

    /**
//     * @param args the command line arguments
//
     * @param args */
//    public static void main(String[] args) {
//        launch(args);
//    }

     public static void main(String[] args) throws MessagingException, Exception{
         
     ServiceUser ser = new  ServiceUser ();
     DemandeAmitie dm = new DemandeAmitie();
     User u1 = new User("montasser", "sellami", "montinho1996@gmail.com", "montinho", "lion","homme", "1996", 10101010 ,"Administrateur" ,"Dance", "null");
     User u2 = new User("mehdi", "sellami", "montinho1996@gmail.com", "mehdi", "aaaa","homme", "1996", 22336665 ,"Administrateur" ,"Dance", "null");
     Amitie a1 = new Amitie(163, 164, "0", 163, 0);
     Amitie a2 = new Amitie(164, 166, "0", 163, 0);
     
     try {
       
      
      
   
      
     // ser.delete(u1);
    // ser.update("amin", "null", "null", "null", "null", "null", "null",22488637, "Administrateur", "Dance", "null", 26);
     List<User> list = ser.readAll();
     System.out.println(list);
            
     //ser.Recherche_parID(99);
            
     //  ser.Authentification ("montinho","aaaa");
     //System.out.println(ser.Recherche_parLogin("montinho")); 
         
       
       //      Mailing.mailing(u1.getEmail());
           
        // System.out.println(ser.Recherche_parID(122));
     } catch (SQLException ex) {
     Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
     }
    // dm.ajouterD(a1);
       // dm.ajouterD(a2);
      //  dm.acceptDemande(a1);
        
         System.out.println(dm.getAll(Userconnected.getIdUser()));
     }
     
}
