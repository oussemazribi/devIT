/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fxml;

import com.esprit.Entite.Conversation;
import com.esprit.Service.EnvoyerMail;
import com.esprit.Service.ServiceConversation;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class TestController implements Initializable {

    private Label label;
    @FXML
    private TextArea idloula;
    @FXML
    private TextArea idthenia;
    ServiceConversation conv = new ServiceConversation();
   // mailServices off = new mailServices();
      EnvoyerMail m = new EnvoyerMail();

    /**
     * Initializes the controller class.
     */
    @Override

    public void initialize(URL url, ResourceBundle rb) {

        // TODO
    }

    @FXML
    private void loginButton(ActionEvent event) {
        try {

            FXMLLoader LOADER = new FXMLLoader(getClass().getResource("Conversations.fxml"));
            Parent root = LOADER.load();
            ConversationsController hamza = LOADER.getController();
            hamza.setDetails("" + idloula.getText(), idthenia.getText());
            Conversation NewConv = new Conversation(idloula.getText(), 1, Integer.parseInt(idthenia.getText()));

            try {
                if (conv.tester(Integer.parseInt(idthenia.getText())) == "yes") {
                    System.out.println("Conversation créé deja");
                    idloula.getScene().setRoot(root);

                } else {
                  
                    m.envoyer();
                    conv.ajouter(NewConv);
                    idloula.getScene().setRoot(root);
                }

            } catch (SQLException ex) {
                //   Logger.getLogger(TestController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (IOException ex) {

        }
    }

    @FXML
    private void chat(MouseEvent event) {
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

}
