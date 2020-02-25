/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.GUI;

import com.pidev.Entite.Conversation;
import com.pidev.Entite.Message;
import com.pidev.Entite.User;
import com.pidev.Service.ServiceConversation;
import com.pidev.Service.ServiceUser;
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
    User userme = new User(1);
    User userfriend = new User(2);
    List<Conversation> MapM;

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

        /* Map<Conversation, Message> map = conv.readMessage();
            for (Map.Entry<Conversation, Message> entry : map.entrySet()) {
                System.out.println(entry.getKey() + "/" + entry.getValue());
                Iterator entries = map.entrySet().iterator(); */
        List<Conversation> MapM;
        try {
            MapM = conv.messageenvoyees(1); // id user seesion

            Iterator iterator = MapM.iterator();

            Label test = new Label();
            TableView table = new TableView();
            VBox vbm;
            Label UnreadConversations = new Label("Your Liste of Conversations");
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
        taswira.setFitHeight(30);
        taswira.setFitWidth(30);
         taswira2.setFitHeight(15);
        taswira2.setFitWidth(15);
        String friend = su.findByIdname(m.getIdU_Friend());
       String friendlastname = su.findByIlastname(m.getIdU_Friend());
        taswira.setImage(im2);
        taswira2.setImage(im4);
        nomSender.setFont(Font.font("Amble CN", FontWeight.BOLD, 25));
        messageBody.setFont(Font.font("Amble CN", FontWeight.BOLD, 15));
  
        nomSender.setText(friend+" "+friendlastname);
        messageBody.setText(m.getNom());
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
    private void main(MouseEvent event) {

        FXMLLoader LOADER = new FXMLLoader(getClass().getResource("test.fxml"));
        try {
            Parent root = LOADER.load();
            Scene rana = new Scene(root);
            TestController hamza = LOADER.getController();
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(rana);
            window.show();
        } catch (IOException ex) {

        }

    }

}
