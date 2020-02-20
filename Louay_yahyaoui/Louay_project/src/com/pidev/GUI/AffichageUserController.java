/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.GUI;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import static com.itextpdf.text.pdf.PdfName.RESOURCES;
import com.itextpdf.text.pdf.PdfWriter;
import com.pidev.Entite.Competition;
import com.pidev.Entite.Participation;
import com.pidev.Entite.Ticket;
import com.pidev.Entite.User;
import com.pidev.Service.ServiceCompetition;
import com.pidev.Service.ServiceParticipation;
import com.pidev.Service.ServiceTicket;
import com.pidev.Service.ServiceUser;
import com.sun.javafx.scene.control.skin.ButtonSkin;
import com.sun.scenario.effect.ImageData;
import com.twilio.rest.Twilio;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javax.swing.text.StyleConstants.FontConstants;

import com.twilio.rest.api.v2010.account.Message;

import com.twilio.type.PhoneNumber;
import com.twilio.exception.AuthenticationException;

import java.net.URI;
import java.util.Arrays;
import java.net.URISyntaxException;

/**
 * FXML Controller class
 *
 * @author loume78
 */
public class AffichageUserController implements Initializable {

    @FXML
    private TableColumn<Competition, String> ColumnTitre;
    @FXML
    private TableColumn<Competition, String> ColumnDescription;
    @FXML
    private TableColumn<Competition, String> ColumnTitre1;
    @FXML
    private TableColumn<Competition, String> ColumnDescription1;
    @FXML
    private TableColumn<Competition, String> ColumnTalent;
    @FXML
    private TableColumn<Competition, String> ColumnDateDebut;
    @FXML
    private TableColumn<Competition, String> ColumnDateFin;
    @FXML
    private TableColumn<Competition, String> ColumnCout;
    @FXML
    private ImageView qrView;
   @FXML
    private Button btnBack;
    

    @FXML
    private TableView<Competition> tableCompetition;
    @FXML
    private TableView<Competition> tableCompetition1;
    
   
    

    public void AfficherCombo() throws SQLException {

        User userTest = new User(102, "Louay", "Yahyaoui", "louay@esprit.tn", "louay", "oussema", "male", "28-08-1992", 234223878, "SimpleUtilisateur", "Comedie", "hahaha", 5000);
        ServiceParticipation service1 = new ServiceParticipation();

        
        
        
        
            ObservableList<Competition> MyList = FXCollections.observableArrayList(service1.findByRechercher(userTest));
             ColumnTitre1.setCellValueFactory(new PropertyValueFactory<Competition, String>("Titre"));
             ColumnDescription1.setCellValueFactory(new PropertyValueFactory<Competition, String>("Description"));
             tableCompetition1.setItems(MyList);
             
             
             
        

    }

    public void AfficherTousUser() throws SQLException {
        ServiceCompetition ser = new ServiceCompetition();

        ObservableList<Competition> list = FXCollections.observableArrayList(ser.readAll1());
        System.out.println(list);

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
            AfficherCombo();
            AfficherTousUser();
            
        } catch (SQLException ex) {
            Logger.getLogger(AffichageUserController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void btnPDF() throws IOException, SQLException {
          User userTest = new User(102, "Louay", "Yahyaoui", "louay@esprit.tn", "louay", "oussema", "male", "28-08-1992", 234223878, "SimpleUtilisateur", "Comedie", "hahaha", 5000);
//        ServiceCompetition service = new ServiceCompetition();
//        ServiceParticipation service1 = new ServiceParticipation();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        Button button2 = new Button();
        button2.setStyle("-fx-background-color: #00ff00");
        alert.setTitle("PDF ");
        alert.setContentText("Participation avec succés !  vous voulez exporter votre ticket en PDF ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
           setFILES();
            
        } else {
           

        }
    }
    
     public void btnPDF2() throws IOException, SQLException {
          User userTest = new User(102, "Louay", "Yahyaoui", "louay@esprit.tn", "louay", "oussema", "male", "28-08-1992", 234223878, "SimpleUtilisateur", "Comedie", "hahaha", 5000);
//        ServiceCompetition service = new ServiceCompetition();
//        ServiceParticipation service1 = new ServiceParticipation();
        Alert alert = new Alert(Alert.AlertType.WARNING);
        Button button2 = new Button();
        button2.setStyle("-fx-background-color: #00ff00");
        alert.setTitle("PDF ");
        alert.setContentText("Vous avez deja participer ! \n vous voulez exporter votre ticket en PDF de nouveau ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
           setFILES();
            
        } else {
           

        }
    }
     
     

    public void Participer() throws SQLException {
        Competition comp = tableCompetition.getSelectionModel().getSelectedItem();
        ServiceParticipation ser = new ServiceParticipation();
        ServiceUser ser1 = new ServiceUser();
        User userTest = new User(102, "Louay", "Yahyaoui", "louay@esprit.tn", "louay", "oussema", "male", "28-08-1992", 234223878, "SimpleUtilisateur", "Comedie", "hahaha", 5000);

        //Competition c = new Competition(103, user, "maysa", "event", "BeatBox","2020-02-18","2020-02-28",650);
        String titre = tableCompetition.getSelectionModel().getSelectedItem().getTitre();
        String description = tableCompetition.getSelectionModel().getSelectedItem().getDescription();
        ServiceTicket service = new ServiceTicket();
        Ticket tik = service.findBy(tableCompetition.getSelectionModel().getSelectedItem(), userTest);
        String motDePasse = tik.getMotDePasse();
        Date date = tik.getDateEmission();
        String nom = userTest.getNom();
        String prenom = userTest.getPrenom();

        //ImageView qrView = new ImageView();
        if (ser.findById(comp, userTest) == false) {
            if (userTest.getNbDiament() > comp.getCout()) {

                ser.ParticiperCompetition(comp, userTest);
//                    TwilioSms twilio = new TwilioSms();
//                    twilio.sendSms("Participation avec succés Mr--"+nom+" "+prenom);
                
                System.out.println(motDePasse);
                try {
                  Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Participation avec succés ! ", ButtonType.OK);
                  alert.show();

                   btnPDF();
                    this.AfficherCombo();
                } catch (IOException ex) {
                    Logger.getLogger(AffichageUserController.class.getName()).log(Level.SEVERE, null, ex);
                }
                QRCodeWriter qrCodeWriter = new QRCodeWriter();
                String myWeb = "Bonjour Mr  --" + nom + " " + prenom + "-- je vous souhaite la bienvenue au sein de notre Competition sous le Titre --" + titre + "-- Voici votre Mot de passe pour accédé à --" + titre + "-- Mot de passe =====> :" + motDePasse;
                int width = 200;
                int height = 200;
                String fileType = "png";

                BufferedImage bufferedImage = null;
                try {
                    BitMatrix byteMatrix = qrCodeWriter.encode(myWeb, BarcodeFormat.QR_CODE, width, height);
                    bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
                    bufferedImage.createGraphics();

                    Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
                    graphics.setColor(Color.WHITE);
                    graphics.fillRect(0, 0, width, height);
                    graphics.setColor(Color.BLACK);

                    for (int i = 0; i < height; i++) {
                        for (int j = 0; j < width; j++) {
                            if (byteMatrix.get(i, j)) {
                                graphics.fillRect(i, j, 1, 1);
                            }
                        }
                    }

                    System.out.println("Success...");

                } catch (WriterException ex) {
                    ex.getMessage();
                }
                qrView.setImage(SwingFXUtils.toFXImage(bufferedImage, null));
                

            } else {
                this.AfficherCombo();
                Alert alert1 = new Alert(Alert.AlertType.ERROR, "Vous n'avez pas le nombre exacte du diamant", ButtonType.OK);
                alert1.show();
            }
        } else {
            this.AfficherCombo();
            try {
                //            Alert alert2 = new Alert(Alert.AlertType.ERROR, "Vous avez deja participé !!", ButtonType.OK);
//            alert2.show();
btnPDF2();
            } catch (IOException ex) {
                Logger.getLogger(AffichageUserController.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(motDePasse);

            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            String myWeb = "Bonjour Mr  --" + nom + " " + prenom + "-- je vous souhaite la bienvenue au sein de notre Competition sous le Titre --" + titre + "-- Voici votre Mot de passe pour accédé à --" + titre + "-- Mot de passe =====> :" + motDePasse;
            int width = 200;
            int height = 200;
            String fileType = "png";

            BufferedImage bufferedImage = null;
            try {
                BitMatrix byteMatrix = qrCodeWriter.encode(myWeb, BarcodeFormat.QR_CODE, width, height);
                bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
                bufferedImage.createGraphics();

                Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
                graphics.setColor(Color.WHITE);
                graphics.fillRect(0, 0, width, height);
                graphics.setColor(Color.BLACK);

                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if (byteMatrix.get(i, j)) {
                            graphics.fillRect(i, j, 1, 1);
                        }
                    }
                }

                System.out.println("Success...");

            } catch (WriterException ex) {
                ex.getMessage();
            }
            qrView.setImage(SwingFXUtils.toFXImage(bufferedImage, null));

        }

    }
    
    
     public void btnSupprimerPart(ActionEvent event) throws IOException, SQLException {
          User userTest = new User(102, "Louay", "Yahyaoui", "louay@esprit.tn", "louay", "oussema", "male", "28-08-1992", 234223878, "SimpleUtilisateur", "Comedie", "hahaha", 5000);
        ServiceCompetition service = new ServiceCompetition();
        ServiceParticipation service1 = new ServiceParticipation();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        Button button2 = new Button();
        button2.setStyle("-fx-background-color: #00ff00");
        alert.setTitle("Suppression ");
        alert.setContentText("Voulez-vous vraiment supprimer cette Participation ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            Competition cFound=service.findByTitre(tableCompetition1.getSelectionModel().getSelectedItem().getTitre());
            Participation par = new Participation(cFound, userTest);
            service1.delete(par);
             this.AfficherCombo();
            
        } else {
              this.AfficherCombo();
              
              
           

        }
    }
     
     
     

    @FXML
    void setFILES() {
        try {

            User userTest = new User(102, "Louay", "Yahyaoui", "louay@esprit.tn", "louay", "oussema", "male", "28-08-1992", 234223878, "SimpleUtilisateur", "Comedie", "hahaha", 5000);
            String titre = tableCompetition.getSelectionModel().getSelectedItem().getTitre();
            String description = tableCompetition.getSelectionModel().getSelectedItem().getDescription();
            ServiceTicket ser = new ServiceTicket();
            Ticket tik = ser.findBy(tableCompetition.getSelectionModel().getSelectedItem(), userTest);
            String motDePasse = tik.getMotDePasse();
            Date date = tik.getDateEmission();
            String nom = userTest.getNom();
            String prenom = userTest.getPrenom();

            OutputStream file = new FileOutputStream(new File("text.pdf"));

            Document document = new Document();

            PdfWriter.getInstance(document, file);

            document.open();
            document.addTitle("Ticket");

            Image img;
            img = Image.getInstance("C:/Users/loume78/Documents/NetBeansProjects/Louay_project/src/com/pidev/affiches/louay.jpg");
            Image.getInstance(img);
            document.add(img);
            document.add(new Paragraph("                    "));
            document.add(new Paragraph("                    "));
            document.add(new Paragraph("                    "));
            document.add(new Paragraph("                    "));
            document.add(new Paragraph("Bonjour Mr  --" + nom + " " + prenom + "-- je vous souhaite la bienvenue "));
            document.add(new Paragraph("Au sein de notre Competition sous le Titre --" + titre + "--"));
            document.add(new Paragraph("Voici votre Mot de passe pour accédé à --" + titre + "--"));
            document.add(new Paragraph("Mot de passe =====> : " + motDePasse));
            document.close();
            file.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

//    public void QRCodeTicket(ActionEvent event)
//    {
//        
//            String titre = tableCompetition.getSelectionModel().getSelectedItem().getTitre();
//            String description = tableCompetition.getSelectionModel().getSelectedItem().getDescription();
//            ServiceTicket ser = new ServiceTicket();
//            Ticket tik=ser.findBy(tableCompetition.getSelectionModel().getSelectedItem(), tableCompetition.getSelectionModel().getSelectedItem().getUser());
//            String motDePasse=tik.getMotDePasse();
//            Date date=tik.getDateEmission();
//            String nom = tableCompetition.getSelectionModel().getSelectedItem().getUser().getNom();
//            String prenom = tableCompetition.getSelectionModel().getSelectedItem().getUser().getPrenom();
//            
//        
//        QRCodeWriter qrCodeWriter = new QRCodeWriter();
//        String myWeb = "hello Louay";
//        int width = 100;
//        int height = 100;
//        String fileType = "png";
//
//        BufferedImage bufferedImage = null;
//        try {
//            BitMatrix byteMatrix = qrCodeWriter.encode(myWeb, BarcodeFormat.QR_CODE, width, height);
//            bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//            bufferedImage.createGraphics();
//
//            Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
//            graphics.setColor(Color.WHITE);
//            graphics.fillRect(0, 0, width, height);
//            graphics.setColor(Color.BLACK);
//
//            for (int i = 0; i < height; i++) {
//                for (int j = 0; j < width; j++) {
//                    if (byteMatrix.get(i, j)) {
//                        graphics.fillRect(i, j, 1, 1);
//                    }
//                }
//            }
//
//            System.out.println("Success...");
//
//        } catch (WriterException ex) {
//            ex.getMessage();
//        }
//
//        //ImageView qrView = new ImageView();
//        qrView.setImage(SwingFXUtils.toFXImage(bufferedImage, null));
//        
//        
//    }
    
    
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
