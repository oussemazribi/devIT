/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.GUI;

import com.pidev.Entite.Competition;
import com.pidev.Entite.User;
import com.pidev.Service.ServiceCompetition;
import com.sun.javafx.scene.control.skin.ButtonSkin;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import sun.plugin2.jvm.RemoteJVMLauncher.CallBack;

/**
 * FXML Controller class
 *
 * @author loume78
 */
public class AfficherCompetitionController implements Initializable {

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
    @FXML
    private TextField titre1;
    @FXML
    private TextArea description1;
    @FXML
    private TextField cout1;
    @FXML
    private ComboBox<String> typetalent1;
    @FXML
    private DatePicker date_debut1;
    @FXML
    private DatePicker date_fin1;
    @FXML
    private ComboBox<String> ComboModif;
    @FXML
    private Tab tabAjouter;
    @FXML
    private Tab tabConsulter;
    @FXML
    private Tab tabSupprimer;
    @FXML
    private Tab tabModifier;
    @FXML
    private TabPane tp;
    @FXML
    private Button btnBack;

    @FXML
    private TableColumn<Competition, String> ColumnTitre;
    @FXML
    private TableColumn<Competition, String> ColumnDescription;
    @FXML
    private TableColumn<Competition, String> ColumnTalent;
    @FXML
    private TableColumn<Competition, String> ColumnDateDebut;
    @FXML
    private TableColumn<Competition, String> ColumnDateFin;
    @FXML
    private TableColumn<Competition, String> ColumnCout;
    @FXML
    private TableColumn<Competition, Button> ColumnAction;

    @FXML
    private TableView<Competition> tableCompetition;

    ServiceCompetition ser1 = new ServiceCompetition();

    ObservableList<String> list = FXCollections.observableArrayList("Dance", "BeatBox", "Musique", "Comedie");

    
    public void AfficherTous() throws SQLException {

        ServiceCompetition ser = new ServiceCompetition();

        ObservableList<Competition> list = FXCollections.observableArrayList(ser.readAll1());

        System.out.println("We're right here for now ");

        //tableAssociation.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        //tableAssociation.setTableMenuButtonVisible(true);
        ColumnTitre.setCellValueFactory(new PropertyValueFactory<Competition, String>("Titre"));
        ColumnDescription.setCellValueFactory(new PropertyValueFactory<Competition, String>("Description"));
        ColumnTalent.setCellValueFactory(new PropertyValueFactory<Competition, String>("TypeDeTalent"));
        ColumnDateDebut.setCellValueFactory(new PropertyValueFactory<Competition, String>("DateDebut"));
        ColumnDateFin.setCellValueFactory(new PropertyValueFactory<Competition, String>("DateFin"));
        ColumnCout.setCellValueFactory(new PropertyValueFactory<Competition, String>("Cout"));
        tableCompetition.setItems(list);

    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            // TODO
//            ObservableList<String> listRecap = FXCollections.observableArrayList(ser1.Select());
//            ComboModif.setItems(listRecap);
typetalent.setItems(list);
AfficherTous();
//typetalent1.setItems(list);
        } catch (SQLException ex) {
            Logger.getLogger(AfficherCompetitionController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void getInformation() throws SQLException {
        User userTest = new User(101, "maysa", "habbachi", "hahaha", "hahaha", "haahha", "haha", "589", 2345, "Administrateur", "Dance", "jajaja", 20);

        LocalDate DateDe = date_debut.getValue();

        String DateD = DateDe.toString();

        LocalDate DateFin = date_fin.getValue();
        String DateFe = DateFin.toString();
        String Titre = titre.getText();
        String Description = description.getText();
        String TypeTalent = typetalent.getValue();
        int Cout = Integer.parseInt(cout.getText());

        Competition c1 = new Competition(userTest, Titre, Description, TypeTalent, DateD, DateFe, Cout);
        ServiceCompetition ser1 = new ServiceCompetition();
        //boolean test = false;
        //ser1.ajouter1(c1);
        if ((ser1.findBy(c1) == false) ) {
            ser1.ajouter(c1);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Ajout de --"+c1.getTitre()+"-- effectué avec succées", ButtonType.OK);
            alert.show();
            this.AfficherTous();
        
        
           
        }
        else {
            Alert alert1 = new Alert(Alert.AlertType.ERROR, "Cette Competition existe deja ! ", ButtonType.OK);
            alert1.show();
            this.AfficherTous();

        }

    }

    

    public void btnSupprimerAction(ActionEvent event) throws IOException, SQLException {
        ServiceCompetition service = new ServiceCompetition();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        Button button2 = new Button();
        button2.setStyle("-fx-background-color: #00ff00");
        alert.setTitle("Suppression ");
        alert.setContentText("Voulez-vous vraiment supprimer cette Competition ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            service.delete(tableCompetition.getSelectionModel().getSelectedItem());
            this.AfficherTous();
        } else {
            this.AfficherTous();

        }
    }

    public void btnModifierCompetition() throws IOException, SQLException {
        
       Competition comp = tableCompetition.getSelectionModel().getSelectedItem();
//        String t=comp.getTitre();
        String titre1 =comp.getTitre();
//        String d =comp.getDescription();
//        String dd =comp.getDateDebut();
//        String df =comp.getDateFin();
//        String tdt =comp.getTypeDeTalent();
//        int c=comp.getCout();
//        
//        titre.setText(t);
//        description.setText(d);
//        typetalent.setValue(tdt);
        //date_debut.setConverter(dd);
      
        
        
        LocalDate DateDe = date_debut.getValue();

        String DateD = DateDe.toString();

        LocalDate DateFin = date_fin.getValue();
        String DateFe = DateFin.toString();
        String Titre = titre.getText();
        String Description = description.getText();
        String TypeTalent = typetalent.getValue();
        int Cout = Integer.parseInt(cout.getText());
        ServiceCompetition ser = new ServiceCompetition();
        //ser.update(Titre, Description, TypeTalent, DateD, DateFe, Cout, titre1);

        this.AfficherTous();
        

    }

    public void btnRefresh() {
        ObservableList<String> listRecap;
        try {
            listRecap = FXCollections.observableArrayList(ser1.Select());
            ComboModif.setItems(listRecap);

        } catch (SQLException ex) {
            Logger.getLogger(AfficherCompetitionController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
     public void Back(ActionEvent event) throws IOException {
        FXMLLoader LOADER = new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent rootChasseur = LOADER.load();
        btnBack.getScene().setRoot(rootChasseur);
//        Scene scene = new Scene(rootChasseur);
//        
//        Stage primaryStage = new Stage();
//        primaryStage.setScene(scene);
//        primaryStage.show();
            
        
        
        
       
    }
     
    
     
     

}
