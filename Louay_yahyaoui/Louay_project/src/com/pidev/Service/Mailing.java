package com.pidev.Service;
import com.pidev.Test.DataBase;
//import static com.sun.org.glassfish.external.amx.AMXUtil.prop;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.pidev.Entite.User;

public class Mailing {
     private Connection con;
    private Statement ste;

        
    public Mailing() {
        con = DataBase.getInstance().getConnection();

    }
    
    
      
             
    public static void mailing(String recipient) throws Exception{
     
    Properties prop = new Properties();
     final String  moncompteEmail = "montasser.sellami.ms@gmail.com";
    final String psw = "lion96montinho";
    prop.put ("mail.smtp.host","smtp.gmail.com");
     prop.put ("mail.smtp.port","587");
    prop.put ("mail.smtp.auth","true");
    prop.put ("mail.smtp.starttls.enable","true");
   
   
    
    Session ses = Session.getInstance(prop,new javax.mail.Authenticator(){
     
    protected PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication(moncompteEmail, psw);
    } 
    } ); 
    
    try {
        
        Message msg = new MimeMessage(ses);
        msg.setFrom(new InternetAddress(moncompteEmail));
        msg.setRecipient(Message.RecipientType.TO,new InternetAddress(recipient));
        msg.setSubject("information");
        msg.setContent("salut","text/html");
        
        Transport.send(msg);
        
    } catch(MessagingException ex) {
        Logger.getLogger(Mailing.class.getName()).log(Level.SEVERE, null, ex);   
    }
   
}
}