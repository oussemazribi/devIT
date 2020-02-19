/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/
package com.esprit.test;

import com.esprit.Entite.Conversation;
import com.esprit.Entite.Message;
import com.esprit.Entite.User;
import com.esprit.Service.ServiceConversation;
import com.esprit.Service.ServiceMessage;
import com.esprit.Service.ServiceUser;
import com.esprit.Utils.DataBase;
import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author House
*/
public class Test {

    public static void main(String[] args) {

        ServiceMessage ser = new ServiceMessage();
        ServiceConversation sc = new ServiceConversation() ;
        ServiceUser su = new ServiceUser();
        Message m1 = new Message(1, 2, "aaslemaaa", 9) ;
        User u1 = new User();
        //  su.findbyimage(1);
        System.err.println("hello");
        try {
            sc.readorder(2);
            sc.Nom(2);
            sc.image(2);
            
            // ser.ajouter(m1);
            //sc.messageenvoyees(2);
            //sc.ajouter(c);
            
            //  sc.deleteAd(3) ;
            // sc.update("rana", 0, 0, 4);
            //ser.transfer(18,  5);
            //  ser.SeenMessage(44) ;
            // ser.countNbUnreadConversations(2) ;
            // ser.readAllforuser(2);
            //sc.tester(3, 2) ;
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
    }

        }
 