/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/
package com.pidev.test;

import com.pidev.Entite.Conversation;
import com.pidev.Entite.Message;
import com.pidev.Entite.User;
import com.pidev.Service.ServiceConversation;
import com.pidev.Service.ServiceMessage;
import com.pidev.Service.ServiceUser;
import com.pidev.Utils.DataBase;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author House
*/
public class Test11 {

    public static void main(String[] args) {

        ServiceMessage ser = new ServiceMessage();
        ServiceConversation sc = new ServiceConversation() ;
        ServiceUser su = new ServiceUser();
        Message m1 = new Message(1, 2, "aaslemaaa", 9) ;
        User u1 = new User();
         User userme = new User(1);
        try {
            //  su.findbyimage(1);
            // System.err.println("hello");
          
            List<Message> MapM = ser.messageenvoyees(userme,34); 
            System.out.println(MapM);
        } catch (SQLException ex) {
            Logger.getLogger(Test11.class.getName()).log(Level.SEVERE, null, ex);
        }
   
          //  sc.readorder(2);
           // sc.Nom(2);
            //sc.image(2);
            
            // ser.ajouter(m1);
          
            //sc.ajouter(c);
            
            //  sc.deleteAd(3) ;
            // sc.update("rana", 0, 0, 4);
            //ser.transfer(18,  5);
            //  ser.SeenMessage(44) ;
            // ser.countNbUnreadConversations(2) ;
            // ser.readAllforuser(2);
            //sc.tester(3, 2) ;
   
          //  sc.readorder(2);
           // sc.Nom(2);
            //sc.image(2);
            
            // ser.ajouter(m1);
          
            //sc.ajouter(c);
            
            //  sc.deleteAd(3) ;
            // sc.update("rana", 0, 0, 4);
            //ser.transfer(18,  5);
            //  ser.SeenMessage(44) ;
            // ser.countNbUnreadConversations(2) ;
            // ser.readAllforuser(2);
            //sc.tester(3, 2) ;
      
       
       
    }

        }
 