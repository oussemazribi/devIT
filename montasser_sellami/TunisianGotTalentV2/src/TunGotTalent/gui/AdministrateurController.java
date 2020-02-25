/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TunGotTalent.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author HPENVY
 */
public class AdministrateurController implements Initializable {
    @FXML
    private Label lblResultat;
    @FXML
    private ComboBox<?> combo_typeTalent;
    @FXML
    private DatePicker date;
    @FXML
    private TextField txtTelephone;
    @FXML
    private Button btnParcourir;
    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtPrenom;
    @FXML
    private TextField txtLogin;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private ComboBox<?> combo_typeCompte;
    @FXML
    private TextField txtEmail;
    @FXML
    private RadioButton rbHomme;
    @FXML
    private RadioButton rbFemme;
    @FXML
    private Button btnvalider;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void main(MouseEvent event) {
    }

    @FXML
    private void chat1(MouseEvent event) {
    }

    @FXML
    private void btnParcourir(ActionEvent event) {
    }

    @FXML
    private void ajouter(ActionEvent event) {
    }
    
}
