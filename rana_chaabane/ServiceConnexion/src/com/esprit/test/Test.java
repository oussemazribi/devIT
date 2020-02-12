/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.test;

import com.esprit.Entite.Conversation;
import com.esprit.Entite.Message;
import com.esprit.Service.ServiceConversation;
import com.esprit.Service.ServiceMessage;
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
        try {
            ServiceMessage ser = new ServiceMessage();
            ServiceConversation sc = new ServiceConversation() ;
            Message m1 = new Message(1, 2, "aaslemaaa", "", 4) ;
            ser.ajouter(m1);
            Conversation c1 = new Conversation("rana", 22, 2);
            Map<Conversation,Message> MapM = sc.readMessage();
             for (Map.Entry<Conversation,Message>  Ha : MapM.entrySet())
            System.err.println(Ha.getKey()+""+Ha.getValue());
         //  sc.deleteAd(3) ;
        // sc.update("rana", 0, 0, 4);
        //ser.transfer(18,  5);
        ser.SeenMessage(25, "ejrili") ;
            
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null,ex);
        }
       
       
    }

        }
