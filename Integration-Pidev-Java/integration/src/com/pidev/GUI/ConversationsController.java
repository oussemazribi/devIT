/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.GUI;

import com.pidev.Entite.Conversation;
import com.pidev.Entite.Message;
import com.pidev.Entite.User;
import static com.pidev.GUI.Integration.Userconnected;
import com.pidev.Service.ServiceConversation;
import com.pidev.Service.ServiceUser;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.SwipeEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ConversationsController implements Initializable {

    static int idconversation, idfriend;
    @FXML
    private VBox InboxVB;
    @FXML
    private Label theniares;
    @FXML
    private Label loulares;
    @FXML
    private TextField recherche;
    @FXML
    private Label mnumber;
    ServiceUser su = new ServiceUser();
    ServiceConversation conv = new ServiceConversation();
    User userme = Userconnected;
    User userfriend = new User(2);
    List<Conversation> MapM;
    @FXML
    private ImageView UserImage;
    @FXML
    private Label UserName;

    public void setDetails(String login, String password) {
        loulares.setText(login);
        theniares.setText(password);

    }

    public String getDetails() {
        return loulares.getText();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //System.err.println(Userconnected.getIdUser());
        /* Map<Conversation, Message> map = conv.readMessage();
            for (Map.Entry<Conversation, Message> entry : map.entrySet()) {
                System.out.println(entry.getKey() + "/" + entry.getValue());
                Iterator entries = map.entrySet().iterator(); */
        List<Conversation> MapM;
        try {
            
                 String im = su.findbyImage(Userconnected.getIdUser());
            File file = new File("C:/xampp/htdocs/Image_Pi/" + im);
            UserImage.setImage(new Image(file.toURI().toString()));
            String alo = su.findByIdname(Userconnected.getIdUser());
              String friendlastname = su.findByIlastname(Userconnected.getIdUser());
            UserName.setText(alo+" "+friendlastname);
            
            
            MapM = conv.messageenvoyees(Userconnected.getIdUser()); // id user seesion

            Iterator iterator = MapM.iterator();

            Label test = new Label();
            TableView table = new TableView();
            VBox vbm;
            Label UnreadConversations = new Label("Your Liste of Conversations");
            UnreadConversations.setFont(Font.font("Amble CN", FontWeight.BOLD, 20));
            UnreadConversations.setTextFill(Color.web("black"));
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
                        vbm.getChildren().add(readConversations((Conversation) iterator.next()));
                    }
                }

                InboxVB.getChildren().add(vbm);
            }

            // TODO
        } catch (SQLException ex) {

        }

    }

    public VBox readConversations(Conversation m) throws SQLException {

        VBox vbmsg = new VBox();
        
        HBox all = new HBox();
        
        ServiceUser su = new ServiceUser();
        System.out.println(m.getIdU_Friend());
        Label nomSender = new Label();
        Label id = new Label();
        id.setText("" + m.getIdConversation());
         id.setFont(Font.font("Amble CN", FontWeight.BOLD, 2));
        Label messageBody = new Label();
        ImageView taswira = new ImageView();
        ImageView taswira2 = new ImageView();
      
        Image im2 = new Image("file:///C:/xampp/htdocs/projetZink/devIT/rana_chaabane/ServiceConnexion/src/Fxml/images/01.jpg");
        Image im3 = new Image("file:///C:/xampp/htdocs/projetZink/devIT/rana_chaabane/ServiceConnexion/src/Fxml/images/04.jpg");
        Image im4 = new Image("file:///C:/xampp/htdocs/projetZink/devIT/rana_chaabane/ServiceConnexion/src/Fxml/images/delete.png");
       taswira.setFitHeight(45);
        taswira.setFitWidth(45);
         taswira2.setFitHeight(15);
        taswira2.setFitWidth(15);
        String friend = su.findByIdname(m.getIdU_Friend());
       String friendlastname = su.findByIlastname(m.getIdU_Friend());
       String im = su.findbyImage(m.getIdU_Friend()) ;
         File file = new File("C:/xampp/htdocs/Image_Pi/" + im);
        taswira.setImage(new Image(file.toURI().toString()));
        taswira2.setImage(im4);
        nomSender.setFont(Font.font("Amble CN", FontWeight.BOLD, 25));
        messageBody.setFont(Font.font("Amble CN", FontWeight.BOLD, 15));
        nomSender.setTextFill(Color.web("white"));
  
        nomSender.setText(friend+" "+friendlastname);
        messageBody.setText("Your Conversation Name :"+m.getNom());
        messageBody.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                try {

                    FXMLLoader LOADER = new FXMLLoader(getClass().getResource("Messagerie.fxml"));
                    Parent root = LOADER.load();
                    //Scene ouss = new Scene(root);
                    MessagerieController hamza = LOADER.getController();
                    //  Stage window =(Stage)((Node) event.getSource()).getScene().getWindow() ;

                    //  hamza.setDetails(Integer.valueOf(id.getText()));
                    idconversation = Integer.parseInt(id.getText());
                    idfriend = m.getIdU_Friend();
                    hamza.setDetails(idconversation, idfriend);
                    System.out.println(Integer.parseInt(id.getText()));
                    id.getScene().setRoot(root);
                    // window.setScene(ouss);
                    //window.show();

                } catch (IOException ex) {

                    Logger.getLogger(MessagerieController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });
        taswira2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText(" supprimer Conversation!");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {

                    try {
                        conv.deleteAd(m.getIdConversation());
                    } catch (SQLException ex) {
                        Logger.getLogger(MessagerieController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else if (result.get() == ButtonType.CANCEL) {
                    System.err.println("supprission annulé");
                }
            }

        });
   all.setHgrow(id, Priority.ALWAYS);
    all.setHgrow(taswira, Priority.ALWAYS);
     all.setHgrow(nomSender, Priority.ALWAYS);
      all.setHgrow(taswira2, Priority.ALWAYS);
    
//         Image im = new Image(img);
        all.getChildren().add(id);
        all.getChildren().add(taswira);
        all.getChildren().add(nomSender);
           all.getChildren().add(taswira2);


        vbmsg.getChildren().add(all);
                vbmsg.getChildren().add(messageBody);

        return vbmsg;

    }

    @FXML
    private void rechercher(ActionEvent event) {

    }

    @FXML
    private void messagenumber(MouseEvent event) {
        long nb;
        try {
            nb = conv.countNbUnreadConversations(1);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Total of Conversation: " + nb);
            alert.showAndWait();
        } catch (SQLException ex) {

        }
        // long nb2= conv.countNbUnreadConversations(2);

    }

    void redirect(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Conversations.fxml"));
        Stage primaryStage = new Stage();

        Scene scene = new Scene(root);

        primaryStage.setTitle("Hello World!");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

   

    private void main(MouseEvent event) {

   
    }

    @FXML
    private void competition(MouseEvent event) {
            if ("Chasseur du talent".equals(Userconnected.getTypeCompte()))
       {
           FXMLLoader LOADER = new FXMLLoader(getClass().getResource("IntChasseur.fxml"));
                try {
                    Parent root = LOADER.load();
                    Scene rana = new Scene(root);
                      IntChasseurController hamza = LOADER.getController();
                    Stage window =(Stage)((Node) event.getSource()).getScene().getWindow() ;
              
                    window.setScene(rana);
                    window.show();
                } catch (IOException ex) {
                  
    }}
       if ("Utilisateur simple".equals(Userconnected.getTypeCompte()))
       {
      try {
                Parent root = FXMLLoader.load(getClass().getResource("UserInterface.fxml"));
                UserName.getScene().setRoot(root);
            } catch (IOException ex) {System.out.println(ex.getMessage());
            }
    }}

    @FXML
    private void annonce(MouseEvent event) {
         FXMLLoader LOADER = new FXMLLoader(getClass().getResource("AffichageAnnonce.fxml"));
                try {
                    Parent root = LOADER.load();
                    Scene rana = new Scene(root);
                      AffichageAnnonceController hamza = LOADER.getController();
                    Stage window =(Stage)((Node) event.getSource()).getScene().getWindow() ;
              
                    window.setScene(rana);
                    window.show();
                } catch (IOException ex) {
                  
                }
    }

    private void chat(MouseEvent event) {
  
    }

    @FXML
    private void reclamation(MouseEvent event)  {
        if ("Administrateur".equals(Userconnected.getTypeCompte()))
        { 
            try {
                Parent root = FXMLLoader.load(getClass().getResource("interfaceadmin.fxml"));
                                UserName.getScene().setRoot(root);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
       if ("Utilisateur simple".equals(Userconnected.getTypeCompte()))
       {
      try {
                Parent root = FXMLLoader.load(getClass().getResource("interfaceUser1.fxml"));
                                UserName.getScene().setRoot(root);

            } catch (IOException ex) {System.out.println(ex.getMessage());
            }
    }
             if ("Chasseur du talent".equals(Userconnected.getTypeCompte()))
       {
      try {
                Parent root = FXMLLoader.load(getClass().getResource("interfaceUser1.fxml"));
                                UserName.getScene().setRoot(root);

            } catch (IOException ex) {System.out.println(ex.getMessage());
            }
    }         if ("Chasseur du talent".equals(Userconnected.getTypeCompte()))
       {
      try {
                Parent root = FXMLLoader.load(getClass().getResource("interfaceUser1.fxml"));
                                UserName.getScene().setRoot(root);

            } catch (IOException ex) {System.out.println(ex.getMessage());
            }
    }}

    @FXML
    private void acceuil(MouseEvent event) {
                        FXMLLoader LOADER = new FXMLLoader(getClass().getResource("Home_1.fxml"));
        try {
            Parent root = LOADER.load();
            Scene rana = new Scene(root);
            HomeController_1 hamza = LOADER.getController();
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(rana);
            window.show();
        } catch (IOException ex) {

        }
    }

    @FXML
    private void chat1(MouseEvent event) {
                     FXMLLoader LOADER = new FXMLLoader(getClass().getResource("Conversations.fxml"));
        try {
            Parent root = LOADER.load();
            Scene rana = new Scene(root);
            ConversationsController hamza = LOADER.getController();
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(rana);
            window.show();
        } catch (IOException ex) {

        }
    }

    @FXML
    private void amis(MouseEvent event) throws IOException {
           Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("listAmis.fxml"));
                  UserName.getScene().setRoot(root);

    }

    @FXML
    private void logout(MouseEvent event) {
                                     FXMLLoader LOADER = new FXMLLoader(getClass().getResource("Authentification.fxml"));
        try {
            Parent root = LOADER.load();
            Scene rana = new Scene(root);
            AuthentificationController hamza = LOADER.getController();
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(rana);
            window.show();
        } catch (IOException ex) {

        }
    }
}
