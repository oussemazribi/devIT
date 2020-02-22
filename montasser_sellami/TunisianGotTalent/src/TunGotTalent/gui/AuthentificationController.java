/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TunGotTalent.gui;

import TunGotTalent.Service.ServiceUser;
import TunGotTalent.entities.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HPENVY
 */
public class AuthentificationController implements Initializable {

    @FXML
    private TextField txtLogin;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Label lblerror;
    @FXML
    private Button btnValider;
      @FXML
    private Hyperlink mdpOublier ;

    
    public void btnValider(ActionEvent event) throws IOException {

        ServiceUser service = new ServiceUser();
        User user = new User();
        user = service.Authentification(txtLogin.getText(), txtPassword.getText());
        if (user.getIdUser() == 0) {
           
          
        } 
        else {
            if (user.getTypeCompte() == "Administrateur") {
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("Modifier_utlisateur.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
//
//            } else {
//                Stage stage = new Stage();
//                Parent root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
//                Scene scene = new Scene(root);
//                stage.setScene(scene);
//                stage.show();
//            }
//        }
    }}}

    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

 public void afficher (ActionEvent event){
 
 
 }
 
 
}
