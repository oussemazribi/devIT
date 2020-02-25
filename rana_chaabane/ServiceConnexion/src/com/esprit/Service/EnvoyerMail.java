package com.esprit.Service;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EnvoyerMail {

    private String username = "rana.chaabane1997@gmail.com";
    private String password = "ranach123456789";

    public void envoyer() {
        
// Etape 1 : Création de la session
        Properties props = new Properties();
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
       
        
        Session session = Session.getInstance(props,new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        
        try {
            
// Etape 2 : Création de l'objet Message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("rana.chaabane1997@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("rana.chaabane1997@gmail.com"));
            message.setSubject("you have a new Conversation");
            String html="<h1> TUNISIAN GOT TALENT </h1> <br/> <h2><b>Welcome to our application</b></h2>";
            message.setContent(html,"text/html");
            //message.setText("Bonjour, ce message est un test ...");
            
// Etape 3 : Envoyer le message
            Transport.send(message);
            System.out.println("Message_envoye");
        } catch (MessagingException e) {
            System.err.println(e.getMessage());
        }
    }
//Etape 4 : Tester la méthode

  
}
