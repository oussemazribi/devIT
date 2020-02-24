/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.GUI;
import static com.pidev.GUI.HomePage.Userconnected ;
import com.pidev.Entite.User;
import com.pidev.Service.DemandeAmitie;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


/**
 * FXML Controller class
 *
 * @author HPENVY
 */
public class ListAmisController implements Initializable {
    User u = new User();

    User Userconnected = new User();
      @FXML
    private TableView<User> table1;

    @FXML
    private TableColumn<User, String> nom;

    @FXML
    private TableColumn<User, String> prenom;

    
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        DemandeAmitie dm = new DemandeAmitie();
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        System.out.println("helloo");
         ObservableList<User> obListActivite = dm.getAll(163);
       // ObservableList<User> obListActivite = dm.getAll(Userconnected.getIdUser());
        table1.setItems(obListActivite);
        
        System.out.println("bye");
    }    
    
}
