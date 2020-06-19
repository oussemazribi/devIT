/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.GUI;

import com.pidev.Service.ServiceReclamation;
import com.pidev.Entite.Reclamation;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author BENTEKFA
 */
public class InterfaceadminController implements Initializable {
    static Reclamation rr=new Reclamation();
    @FXML
    private TableView<Reclamation> listreclamation;
    @FXML
    private Button traiter;
    @FXML
    private Button supprimer;
    /************Service************/
    ServiceReclamation Serr=new ServiceReclamation();
    List<Reclamation> list = null;
    @FXML
    private TableColumn<?,?> iduser;
    @FXML
    private TableColumn<?, ?> objet;
    @FXML
    private TableColumn<?, ?> descr;
    @FXML
    private TableColumn<?, ?> photo;
    @FXML
    private TableColumn<?, ?> etat;
    @FXML
    private TableColumn<?, ?> date;
    /************************************************/
    ServiceReclamation ser=new ServiceReclamation();
    @FXML
    private Button actualiser;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           iduser.setCellValueFactory(new PropertyValueFactory<>("idUser"));
           objet.setCellValueFactory(new PropertyValueFactory<>("objet"));
           descr.setCellValueFactory(new PropertyValueFactory<>("description"));
            photo.setCellValueFactory(new PropertyValueFactory<>("photo"));
           etat.setCellValueFactory(new PropertyValueFactory<>("Etat"));
           date.setCellValueFactory(new PropertyValueFactory<>("dateReclamation"));
        try {
            System.out.println(ser.readAll());
        } catch (SQLException ex) {
          System.out.println(ex.getMessage());
        }
        try {
            listreclamation.getItems().setAll(ser.readAll());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }    

    @FXML
    private void traiterreclamation(ActionEvent event) throws IOException {
        transfertdata();
        Parent root = FXMLLoader.load(getClass().getResource("traitement.fxml"));
        Scene scene = new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show(); 
       
    }

    @FXML
    private void supprimerr(ActionEvent event) throws SQLException {
        Reclamation r=listreclamation.getSelectionModel().getSelectedItem();
        System.out.println(rr.toString());
        ser.delete(r);
        
        
    }
    public void transfertdata()
    { 
      rr.setIdUser(listreclamation.getSelectionModel().getSelectedItem().getIdUser());
      rr.setObjet(listreclamation.getSelectionModel().getSelectedItem().getObjet());
      rr.setEtat(listreclamation.getSelectionModel().getSelectedItem().getEtat());
      rr.setPhoto(listreclamation.getSelectionModel().getSelectedItem().getPhoto());
      rr.setDateReclamation(listreclamation.getSelectionModel().getSelectedItem().getDateReclamation());
      rr.setDescription(listreclamation.getSelectionModel().getSelectedItem().getDescription());
      
        
    }

    @FXML
    private void actualiser(ActionEvent event) {
        listreclamation.getItems().clear();
        
           iduser.setCellValueFactory(new PropertyValueFactory<>("idUser"));
           objet.setCellValueFactory(new PropertyValueFactory<>("objet"));
           descr.setCellValueFactory(new PropertyValueFactory<>("description"));
           photo.setCellValueFactory(new PropertyValueFactory<>("photo"));
           etat.setCellValueFactory(new PropertyValueFactory<>("Etat"));
           date.setCellValueFactory(new PropertyValueFactory<>("dateReclamation"));
        try {
            System.out.println(ser.readAll());
        } catch (SQLException ex) {
          System.out.println(ex.getMessage());
        }
        try {
            listreclamation.getItems().setAll(ser.readAll());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
}
