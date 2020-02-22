/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import TunGotTalent.Service.GeneratePDF;
import TunGotTalent.Service.Mailing;
import TunGotTalent.Service.ServiceUser;
import TunGotTalent.entities.User;
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
     User u1 = new User("montasser", "sellami", "montinho1996@gmail.com", "montinho", "aaaa","homme", "1996", 10101010 ,"Administrateur" ,"Dance", "null");
     User u2 = new User("mehdi", "sellami", "montinho1996@gmail.com", "mehdi", "aaaa","homme", "1996", 22336665 ,"Administrateur" ,"Dance", "null");
     
     try {
    // ser.ajouter(u1);
       
      
   
      
     // ser.delete(u1);
     ser.update("amin", "null", "null", "null", "null", "null", "null",22488637, "Administrateur", "Dance", "null", 26);
     List<User> list = ser.readAll();
     System.out.println(list);
            
     //ser.Recherche_parID(99);
            
     //  ser.Authentification ("montinho","aaaa");
     System.out.println(ser.Recherche_parLogin("montinho")); 
         
       
             Mailing.mailing(u1.getEmail());
           
       
     } catch (SQLException ex) {
     Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
     }
     }
     
}
