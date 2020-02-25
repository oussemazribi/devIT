package com.pidev.GUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import static com.pidev.GUI.ConversationsController.idconversation;
import static com.pidev.GUI.ConversationsController.idfriend;
import com.pidev.Entite.Conversation;
import com.pidev.Entite.Message;
import com.pidev.Entite.User;
import com.pidev.IService.IService;
import com.pidev.Service.ServiceConversation;
import com.pidev.Service.ServiceMessage;
import com.pidev.Service.ServiceUser;
import com.pidev.Service.filetourl;
import com.github.sarxos.webcam.Webcam;


import java.awt.Dialog;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URI;
import java.net.URL;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.imageio.ImageIO;
import javax.management.Notification;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class MessagerieController implements Initializable {

    @FXML
    private VBox InboxVB;
    private TextField rana;
    private Pane pn;
    ServiceMessage sc = new ServiceMessage();
    ServiceUser su = new ServiceUser();
    ServiceConversation conv = new ServiceConversation();
 
    Message m = new Message();
    
   
    @FXML
    private Label loulares;
    @FXML
    private Label theniares;
    @FXML
    private Label mnumber;
    Label messageBody = new Label();
    private TextField recherche;
       User userme = new User(1);
    int idme = userme.getIdUser();
    String myname = userme.getNom();
   // int a = Integer.valueOf(loulares.getText());

    public void setDetails(int id , int friend) {
        loulares.setText(Integer.toString(id));
    

    }
      
    User userfriend = new User(idfriend); 
     int idfriendee = userfriend.getIdUser(); 

    public String getDetails() {
        return loulares.getText();
    }

          
    /**
     * Initializes the controller class.
     *
     * @param url
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {

          //  System.out.println(a);
        // int b = parseInt(loulares.getText()) ;
         // System.out.println(Integer.valueOf(loulares.getText()));
            List<Message> MapM = sc.messageenvoyees(userme, idconversation); // id user seesion
            Iterator iterator = MapM.iterator();

            VBox vbm, vbm2, vbmA, donia;
            vbm = new VBox(10);
// calcul total unread messages !!! ( think about refresh after reply )
     
            Label UnreadConversations = new Label("Your private Conversation");
            UnreadConversations.setFont(Font.font("Amble CN", FontWeight.BOLD, 20));
            UnreadConversations.setTextFill(Color.web("#336e83"));
            UnreadConversations.setMaxWidth(Double.MAX_VALUE);
            UnreadConversations.setAlignment(Pos.CENTER);

            InboxVB.getChildren().add(UnreadConversations);

            for (int i = 0; i < MapM.size(); i++) {
                vbm = new VBox(10);
                vbm.setPadding(new Insets(10, 10, 10, 10));
                // vbm.setSpacing(10);
                vbm.setSpacing(20); // espace horizontal entre deux images
                for (int j = 0; j < 1; j++) {
                    if (iterator.hasNext()) {
                        vbm.getChildren().add(readmessages((Message) iterator.next()));
                    }
                }

                InboxVB.getChildren().add(vbm);
            }

            Button send_but;

            send_but = new Button("send a file");
            send_but.setStyle("-fx-background-color:#4F97B2; -fx-text-fill: #000000; -fx-font-size: 15; styleClass=\"txt-fld\"");

            InboxVB.setStyle("-fx-background-color: #E0E5E7;");
            TextArea rana = new TextArea();
            rana.setPromptText("Type your reply here.");
            rana.setPrefRowCount(2);
            rana.setCursor(Cursor.WAIT);
            Button reply = new Button("Reply");

            reply.setTranslateX(320);
            send_but.setTranslateX(320);

            reply.setStyle("-fx-background-color: #4F97B2; -fx-text-fill: #000000; -fx-font-size: 15; styleClass=\"txt-fld\"");

            reply.setOnAction((event) -> {

                ServiceMessage ser = new ServiceMessage();
                Message mbs = new Message(idme, idfriend, rana.getText(),idconversation);
                if (rana.getText().length() == 0) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setContentText("le message est vide!");
                    alert.showAndWait();
                } else {
                    try {
                        ser.ajouter(mbs);
                        Image sendtick = new Image("file:///C:/xampp/htdocs/projetZink/devIT/rana_chaabane/ServiceConnexion/src/Fxml/images/sendtick.png");

                        Notifications notificationBuilder = Notifications.create()
                                .title("message envoyee")
                                .graphic(new ImageView(sendtick))
                                .hideAfter(Duration.seconds(5))
                                .position(Pos.BOTTOM_RIGHT);
                        notificationBuilder.show();

                        Message msgRead = new Message();

                        System.out.println(m.getId_Sender());

                        //msgRead.SeenMessage(m.get());    // user has replies to this message ça n'a pas marché
                        System.out.println("your message has been sent successfully");

                        // refresh ou afficher  l'historique de discussion
                        // refreeeeeesh  required here !!!!
                        Parent root;
                    } catch (SQLException ex) {

                    }
                }

            });
            send_but.setOnAction((event) -> {

            upload(event);
            }
            );
             // InboxVB.getChildren().add(loulares);
            InboxVB.getChildren().add(rana);
        

            InboxVB.getChildren().add(reply);
            InboxVB.getChildren().add(send_but);
          

        } catch (SQLException ex) {

        }

    }

    public VBox readmessages(Message m) throws SQLException {
        VBox vbmsg = new VBox(); // le petit contenaire pour un seul message
        HBox hb_petit = new HBox();
        vbmsg.setStyle("background-color : #ffffff; padding-right: 0px");
        vbmsg.setSpacing(5);
        ServiceUser su = new ServiceUser();

        Label nomSender = new Label();
      
        Label seen = new Label();
        Label id = new Label();
        ImageView taswira = new ImageView();
        ImageView taswira2 = new ImageView();

        if (m.getId_Sender() == idfriend) {
            String alo = su.findByIdname(idfriend);
            Image im = new Image("file:///C:/xampp/htdocs/projetZink/devIT/rana_chaabane/ServiceConnexion/src/Fxml/images/01.jpg");
            //Image im = new Image();

            taswira.setImage(im);
            taswira.setFitHeight(30);
            taswira.setFitWidth(30);
            nomSender.setText(alo + "");
            nomSender.setFont(Font.font("Amble CN", FontWeight.BOLD, 15));
            nomSender.setTextFill(Color.web("#0076a3"));
            messageBody.setText(m.getContenu());
            messageBody.setFont(Font.font("Amble CN", FontWeight.BOLD, 12));
            messageBody.setAlignment(Pos.TOP_LEFT);
            messageBody.setStyle("-fx-border-color: white;");

            if ("Now_Seen".equals(m.getEtat())) {
                seen.setText("seen✔");
            }

            messageBody.setStyle("-fx-font-size: 15; styleClass=\"txt-fld\"");

            messageBody.setOnMouseClicked((event) -> {
                int idm = m.getId_Message();
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Message supprimé!");
                alert.showAndWait();

                try {
                    sc.delete(idm);
                } catch (SQLException ex) {
                    Logger.getLogger(MessagerieController.class.getName()).log(Level.SEVERE, null, ex);
                }

            });
            messageBody.setOnMouseEntered((event) -> {
                try {
                    int idm = m.getId_Message();
                    sc.SeenMessage(idm);
                    seen.setText("seen✔");
                } catch (SQLException ex) {

                }
            });

        }
        if (m.getId_Sender() == idme) {
            Image im2 = new Image("file:///C:/xampp/htdocs/projetZink/devIT/rana_chaabane/ServiceConnexion/src/Fxml/images/02.jpg");

            taswira2.setImage(im2);
            taswira2.setFitHeight(30);
            taswira2.setFitWidth(30);
            nomSender.setText(su.findByIdname(idme) + " ");
            nomSender.setTranslateX(300);
            //messageBody.setTranslateX(300);
            taswira2.setTranslateX(300);
            nomSender.setFont(Font.font("Amble CN", FontWeight.BOLD, 15));
            nomSender.setTextFill(Color.web("#0076a3"));
            messageBody.setText(m.getContenu());
            messageBody.setFont(Font.font("Amble CN", FontWeight.BOLD, 12));
            messageBody.setAlignment(Pos.TOP_RIGHT);
            messageBody.setStyle("-fx-border-color: white;");

            messageBody.setOnMouseClicked((event) -> {
                int idm = m.getId_Message();
               Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setContentText("Supprimer Message!");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    
          
                    try {
                        sc.delete(idm);
                        System.err.println("supprime");
                    } catch (SQLException ex) {
                        Logger.getLogger(MessagerieController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                

                } else if(result.get() == ButtonType.CANCEL) {
                   System.err.println("supprission annulé");
                }


            });
        }
        hb_petit.setSpacing(10);
        vbmsg.getChildren().add(taswira);
        vbmsg.getChildren().add(taswira2);
        vbmsg.getChildren().add(nomSender);
        //   vbmsg.getChildren().add(id);

        vbmsg.getChildren().add(messageBody);
        vbmsg.getChildren().add(seen);
        vbmsg.getChildren().add(hb_petit);
        //  vbmsg.getChildren().add(t);

        return vbmsg;

    }

    /* public VBox createVBMessage(Message m ) {
      
        VBox vbmsg = new VBox(); // le petit contenaire pour un seul message
        HBox hb_petit = new HBox();
        vbmsg.setStyle("background-color : #ffffff; padding-right: 0px");
        vbmsg.setSpacing(10);
        // ImageView img = new ImageView(new Image(f.getPicturePath())); //f.getPicturePath()
        //http://localhost/pi/image/f.getPicturePath()
        //img.setPreserveRatio(false);
        //img.setX(100);
        //img.setY(100);
        // img.setFitHeight(220);
        // img.setFitWidth(170);
           ServiceUser su = new ServiceUser();
       
        try {
            su.findByIdname(2) ;
       
   
        Label nomSender = new Label(su.findByIdname(2)+ " " );

        nomSender.setFont(Font.font("Amble CN", FontWeight.BOLD, 20));
        Label messageBody = new Label(m.getContenu());
        messageBody.setFont(Font.font("Amble CN", FontWeight.BOLD, 15));

        TextArea t = new TextArea();
        t.setPromptText("Type your reply here.");

       
        reply.setOnAction((event) -> {
            System.out.println(t.getText());
               ServiceMessage ser = new ServiceMessage();
            Message mbs = new Message(m.getId_Sender(), m.getId_Receiver(), t.getText(),m.getId_Conversation());

            try {
                ser.ajouter(mbs);
          
            Message msgRead = new Message();
       
            System.out.println(m.getId_Sender());
           
            //msgRead.SeenMessage(m.get());    // user has replies to this message ça n'a pas marché
            System.out.println("your message has been sent successfully");

            // refresh ou afficher  l'historique de discussion
            // refreeeeeesh  required here !!!!
            
       
            

        VBox vbm;
            
     
            
            
            Parent root;
              } catch (SQLException ex) {
              
            }

        });
    
     hb_petit.setSpacing(20);
        vbmsg.getChildren().add(nomSender);
        vbmsg.getChildren().add(messageBody);

       
        hb_petit.getChildren().add(reply);
        hb_petit.getChildren().add(delete);
        
        vbmsg.getChildren().add(hb_petit);
        vbmsg.getChildren().add(t);
        
        } catch (SQLException ex) {
            Logger.getLogger(MessagerieController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return vbmsg;
}
    private void redirect(ActionEvent event) throws IOException {

    }

    private void answering() {
     
} */
    void redirect(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Messagerie.fxml"));
        Stage primaryStage = new Stage();

        Scene scene = new Scene(root);

        primaryStage.setTitle("Hello World!");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    private void messagenumber(MouseEvent event) {
        long nb;
        try {
            nb = sc.countNbUnreadConversations(2);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Total of messages: " + nb);
            alert.showAndWait();
        } catch (SQLException ex) {

        }
        // long nb2= conv.countNbUnreadConversations(2);

    }

    private void rechercher(ActionEvent event) {

        try {
            sc.recherche(recherche.getText());
        } catch (SQLException ex) {

        }

    }

    private void upload(ActionEvent event) {
       FileChooser F = new FileChooser();
       F.setTitle("File");
       F.getExtensionFilters().addAll();
 
       File f = F.showOpenDialog(messageBody.getScene().getWindow());
       if (f!= null)
       {
           messageBody.setText(f.toString());
       }
    
    }

    @FXML
    private void chat(TouchEvent event) {
        
             
    }

    @FXML
    private void chat1(MouseEvent event) {
            FXMLLoader LOADER = new FXMLLoader(getClass().getResource("Conversations.fxml"));
                try {
                    Parent root = LOADER.load();
                    Scene rana = new Scene(root);
                      ConversationsController hamza = LOADER.getController();
                    Stage window =(Stage)((Node) event.getSource()).getScene().getWindow() ;
              
                    window.setScene(rana);
                    window.show();
                } catch (IOException ex) {
                  
                }
    }

    @FXML
    private void camera(MouseEvent event) {
 
        try {
                   Webcam webcam = Webcam.getDefault();
webcam.open();
            ImageIO.write(webcam.getImage(), "PNG", new File("Smile.png"));
        } catch (IOException ex) {
            
        }
    }

    @FXML
    private void main(MouseEvent event) {
    }
}