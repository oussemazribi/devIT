/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.GUI;

import com.pidev.Entite.Competition;
import com.pidev.Service.ServiceCompetition;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author loume78
 */
public class AjouterCompetitionController implements Initializable {

    @FXML
    private TextField titre;
    @FXML
    private TextArea description;
    @FXML
    private TextField cout;
    @FXML
    private ComboBox<String> typetalent;
    @FXML
    private DatePicker date_debut;
    @FXML
    private DatePicker date_fin;

    ObservableList<String> list = FXCollections.observableArrayList("Dance", "BeatBox", "Musique", "Comedie");

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        typetalent.setItems(list);
    }

//    public String verifTitre(String Titre) {
//
//        if (titre.getText().length() == 0) {
//            Alert a = new Alert(Alert.AlertType.ERROR, " Vous devez remplir ce champs", ButtonType.OK);
//
//        } else {
//            Titre = titre.getText();
//
//        }
//        return Titre;
//    }
//
//    public String verifDescription(String Description) {
//
//        if (description.getText().length() == 0) {
//            Alert a = new Alert(Alert.AlertType.ERROR, " Vous devez remplir ce champs", ButtonType.OK);
//
//        } else {
//            Description = description.getText();
//
//        }
//        return Description;
//    }
//
//    public String verifType(String TypeTalent) {
//
//        if (description.getText().length() == 0) {
//            Alert a = new Alert(Alert.AlertType.ERROR, " Vous devez remplir ce champs", ButtonType.OK);
//
//        } else {
//            TypeTalent = typetalent.getValue();
//
//        }
//        return TypeTalent;
//    }
//
//    
//           
//           
//        
//
//    public int verifCout(int Cout) {
//
//        if (cout.getText().length() == 0) {
//            Alert a = new Alert(Alert.AlertType.ERROR, " Vous devez remplir ce champs", ButtonType.OK);
//
//        } else {
//            Cout = Integer.parseInt(cout.getText());
//
//        }
//        return Cout;
//    }

    public void getInformation() throws SQLException {

//        if (titre.getText().length() > 0) {
//            String Titre = titre.getText();
//        } else {
//
//            Alert a = new Alert(Alert.AlertType.ERROR, " Vous devez remplir ce champs", ButtonType.OK);
//        }
//
//        if (description.getText().length() > 0) {
//            String Description = description.getText();
//        } else {
//
//            Alert a = new Alert(Alert.AlertType.ERROR, " Vous devez remplir ce champs", ButtonType.OK);
//        }
//        
//        if (typetalent.getValue().length() > 0) {
//             String typedetalent = typetalent.getValue();
//        } else {
//
//            Alert a = new Alert(Alert.AlertType.ERROR, " Vous devez remplir ce champs", ButtonType.OK);
//        }
//        
//        if (date_debut.getValue().isAfter(LocalDate.now())) {
//            LocalDate DateD = date_debut.getValue();
//            String DateDebut = DateD.toString();
//        } else {
//
//            Alert a = new Alert(Alert.AlertType.ERROR, " Vous devez remplir une date superieure a la date d'aujourd'hui", ButtonType.OK);
//        }
//        
//         if (date_fin.getValue().isBefore(date_debut.getValue())) {
//            LocalDate DateF = date_fin.getValue();
//            String DateFin = DateF.toString();
//        } else {
//
//            Alert a = new Alert(Alert.AlertType.ERROR, " Vous devez remplir une date superieure a la date d'aujourd'hui", ButtonType.OK);
//        }
//        
//        
//        
//
//       
//        
//        
//      
            LocalDate DateDe = date_debut.getValue();
           
            String DateD = DateDe.toString();

      
   
            LocalDate DateFin = date_fin.getValue();
            String DateFe = DateFin.toString(); 
             String Titre = titre.getText();
             String Description = description.getText();
             String TypeTalent = typetalent.getValue();
             int Cout = Integer.parseInt(cout.getText());
        

        //Competition c1 = new Competition(23, Titre, Description, TypeTalent, DateD, DateFe, Cout);
        ServiceCompetition ser1 = new ServiceCompetition();
        //boolean test = false;
        //test = ser1.ajouter1(c1);
//        if (ser1.ajouter1(c1)== true) {
//            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//            alert.show();
//        } else {
//            Alert alert1 = new Alert(Alert.AlertType.ERROR);
//            alert1.show();
//
//        }

    }

}
