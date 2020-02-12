/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.Utils;

import com.pidev.Entite.Competition;
import com.pidev.Entite.Participation;
import com.pidev.Entite.Talents;
import com.pidev.Entite.Ticket;
import com.pidev.Entite.User;
import com.pidev.Service.ServiceCompetition;
import com.pidev.Service.ServiceParticipation;
import com.pidev.Service.ServiceTicket;
import com.pidev.Service.ServiceUser;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author loume78
 */
public class Test {

    public static void main(String[] args) {

        ServiceCompetition ser = new ServiceCompetition();
        Talents t1 = new Talents(1, "dance");
        Talents t20 = new Talents(1, "BeatBox");

        Competition t = new Competition(10, "ghany", "lalalalala", t1.getNom(), "22/06/2020", "13/06/2020", 100);
        Competition t2 = new Competition(11, "louay", "lalalalala", t1.getNom(), "22/06/2020", "13/06/2020", 100);
        Competition t3 = new Competition(12, "maysa", "lalalalala", t20.getNom(), "22/06/2020", "13/06/2020", 100);
        Competition t4 = new Competition(12, "hellooooo", "lalalalala", t20.getNom(), "22/06/2020", "13/06/2020", 100);
        Competition t5 = new Competition(7, "ghada", "lalalalala", t1.getNom(), "22/06/2020", "13/06/2020", 100);

//        try {
//            ser.ajouter(t);
//             ser.ajouter(t2);
//      ser.ajouter(t3);
//      ser.ajouter(t4);
//        } catch (SQLException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        }
     
//        try {
//            //        try {
////
////            Map<User, Competition> map = ser.readAll();
////            for (Map.Entry<User, Competition> ha : map.entrySet()) {
////                System.out.println(ha.getKey() + "" + ha.getValue());
//////                System.out.println("\n");
////            }
////
////        } catch (SQLException ex) {
////            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
////        }
//
////        try {
////            //        List<Competition> arr = new ArrayList<>();
//////        try {
////ser.ajouter(t);
////ser.ajouter(t2);
////        } catch (SQLException ex) {
////            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
////        }
//ser.ajouter(t3);
//ser.ajouter(t4);
//            ser.ajouter(t5);
//        } catch (SQLException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        }
//            
//            arr = ser.findByTalent("Dance");
//            System.out.println(arr);
//        } catch (SQLException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
         ServiceTicket ser1 = new ServiceTicket();
         
         Ticket tik = new Ticket(16, 5, "louay", "motdepass");
         Ticket tik2 = new Ticket(17, 6, "maysa", "kkkk");
         Ticket tik3 = new Ticket(19, 5, "oussema", "hello");
//         
//Ticket louay=new Ticket();
//            louay =ser1.findByMDP("0hello");
//            System.out.println(louay);
//            
//          Ticket tick = ser1.findById(12);
//          System.out.println(tick);
////         
//        try {
//            ser1.ajouter(tik);
////            ser1.ajouter(tik3);
////            ser1.ajouter(tik2);
//             List<Ticket> list = ser1.readAll();
//            System.out.println(list);
//            
//              
//        } catch (SQLException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
        ServiceUser serv = new ServiceUser();
        User u1 = new User("louay", "yahyaoui", "hahaha", "hahaha", "haahha", "haha", "589", 2345, "Administrateur", "Dance", "jajaja", 500);
        User u2 = new User("maysa", "habbachi", "hahaha", "hahaha", "haahha", "haha", "589", 2345, "Administrateur", "Dance", "jajaja", 500);
        User u3 = new User("ghada", "said", "hahaha", "hahaha", "haahha", "haha", "589", 2345, "Administrateur", "Dance", "jajaja", 500);
       ServiceParticipation ppp=new ServiceParticipation();
       
        
        
  
        try {
            ppp.ParticiperCompetition(38,24);
            //ppp.VerifierTicket(200,38,"U24C38");
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
            
        
    }
    }

