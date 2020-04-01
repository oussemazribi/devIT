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
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.pidev.Entite.Competition;
import com.pidev.Entite.Participation;
import com.pidev.Entite.Ticket;
import com.pidev.Entite.User;
import static com.pidev.GUI.tnGotTalent.Userconnected;
import com.pidev.Service.ServiceCompetition;
import com.pidev.Service.ServiceParticipation;
import com.pidev.Service.ServiceTicket;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.Separator;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author loume78
 */
public class UserInterfaceController implements Initializable {

    @FXML
    private FlowPane flowPaneComp;
    @FXML
    private FlowPane flowPanePart;
    @FXML
    private ImageView qrviewer;
    @FXML
    private Button btnBack;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            affichageCompetition();
            AfficherParticipation();
        } catch (SQLException ex) {
            Logger.getLogger(UserInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void QrCode(String Body) {

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        String myWeb = Body;
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
        qrviewer.setImage(SwingFXUtils.toFXImage(bufferedImage, null));
    }

    public void setFILES(String Body, String Body1, String Body2, String Body3) {
        try {

            OutputStream file = new FileOutputStream(new File("text.pdf"));

            Document document = new Document();

            PdfWriter.getInstance(document, file);

            document.open();
            document.addTitle("Ticket");

            com.itextpdf.text.Image img;
            img = com.itextpdf.text.Image.getInstance("C:/Users/loume78/Documents/NetBeansProjects/Louay_project/src/com/pidev/affiches/louay.jpg");
            com.itextpdf.text.Image.getInstance(img);
            document.add(img);
            document.add(new Paragraph("                    "));
            document.add(new Paragraph("                    "));
            document.add(new Paragraph("                    "));
            document.add(new Paragraph("                    "));
            document.add(new Paragraph(Body));
            document.add(new Paragraph(Body1));
            document.add(new Paragraph(Body2));
            document.add(new Paragraph(Body3));
            document.close();
            file.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    public void btnPDF(String Body, String Body1, String Body2, String Body3) throws IOException, SQLException {
        //User userTest = new User(102, "Louay", "Yahyaoui", "louay@esprit.tn", "louay", "oussema", "male", "28-08-1992", 234223878, "SimpleUtilisateur", "Comedie", "hahaha", 5000);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        Button button2 = new Button();
        button2.setStyle("-fx-background-color: #00ff00");
        alert.setTitle("PDF ");
        alert.setContentText("Participation avec succés !  vous voulez exporter votre ticket en PDF ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            setFILES(Body, Body1, Body2, Body3);

        } else {

        }
    }

    private void affichageCompetition() throws SQLException {

      
        ServiceCompetition serC = new ServiceCompetition();

        ObservableList<Competition> listComp = FXCollections.observableArrayList(serC.readAll1());

        System.out.println("We're right here for now ");
        ArrayList<Separator> as = new ArrayList<>();
        ArrayList<VBox> vbx = new ArrayList<>();
        ArrayList<HBox> btnP = new ArrayList<>();

        for (int i = 0; i < listComp.size(); i++) {

            Separator h = new Separator(Orientation.VERTICAL);
            h.setPrefWidth(17);
            h.setPrefHeight(24);
            h.setVisible(false);
            as.add(h);

            VBox VBoxComp = new VBox();

            VBoxComp.setSpacing(5);
            VBoxComp.setStyle("-fx-background-color : #FFFFFF;");
            //VBoxComp.setStyle("-fx-border-color : #2B48E8;");
            VBoxComp.setAlignment(Pos.CENTER);
            VBoxComp.setPrefHeight(169);
            VBoxComp.setPrefWidth(184);
            HBox panne = new HBox();
            panne.setSpacing(5);
            panne.setStyle("-fx-background-color : #FFFFFF;");
            //VBoxComp.setStyle("-fx-border-color : #2B48E8;");
            panne.setAlignment(Pos.CENTER);
            panne.setPrefHeight(30);
            panne.setPrefWidth(70);

            Rectangle c = new Rectangle(184, 90);

            try {
                c.setFill(new ImagePattern(new Image(new FileInputStream("C:/wamp64/www/PI_DEV_Image/" + listComp.get(i).getImageC()))));
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            }

            VBoxComp.getChildren().add(c);

            Label titreComp = new Label("Titre : " + listComp.get(i).getTitre());
            Label description = new Label("Cout: " + listComp.get(i).getCout());

            int idCompetition = listComp.get(i).getIdCompetition();
            Competition c1 = serC.findById(idCompetition);

            String Titre1 = c1.getTitre();
            String Description1 = c1.getDescription();
            String Image1 = c1.getImageC();
            String DateD1 = c1.getDateDebut();
            String DateF1 = c1.getDateFin();
            String Type1=c1.getTypeDeTalent();
            int Cout1=c1.getCout();
            
            
            
             Button btnPart = new Button("Participer");
            btnPart.setTextOverrun(OverrunStyle.CLIP);
            btnPart.setStyle("-fx-background-color : #3D7AB7;");
            String titre = listComp.get(i).getTitre();

            ServiceParticipation serviceP = new ServiceParticipation();
            if (serviceP.findById(c1, Userconnected) == true) {
                btnPart.setDisable(true);
            } else {
                btnPart.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {

                        try {

                            ServiceTicket service = new ServiceTicket();
                            Ticket tik = service.findBy(c1, Userconnected);
                            String motDePasse = tik.getMotDePasse();

                            String nom = Userconnected.getNom();
                            String prenom = Userconnected.getPrenom();
                            ServiceParticipation serP = new ServiceParticipation();

                            if (serP.findById(c1, Userconnected) == false) {
                                if (Userconnected.getNbDiament() > c1.getCout()) {

                                    serP.ParticiperCompetition(c1, Userconnected);
                                    String Body = "Bonjour Mr  --" + nom + " " + prenom + "-- je vous souhaite la bienvenue ";
                                    String Body1 = "Au sein de notre Competition sous le Titre --" + titre + "--";
                                    String Body2 = "Voici votre Mot de passe pour accédé à --" + titre + "--";
                                    String Body3 = "Mot de passe =====> : " + motDePasse;
                                    try {
                                        btnPDF(Body, Body1, Body2, Body3);
                                    } catch (IOException ex) {
                                        Logger.getLogger(UserInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    QrCode("Bonjour Mr  --" + nom + " " + prenom + "-- je vous souhaite la bienvenue au sein de notre Competition sous le Titre --" + titre + "-- Voici votre Mot de passe pour accédé à --" + titre + "-- Mot de passe =====> :" + motDePasse);
//
                    TwilioSms twilio = new TwilioSms();
                    twilio.sendSms("Participation avec succés Mr--"+nom+" "+prenom);
                                    System.out.println(motDePasse);
                                    flowPanePart.getChildren().clear();
                                    AfficherParticipation();
                                    flowPaneComp.getChildren().clear();
                                    affichageCompetition();

                                } else {

                                    Alert alert1 = new Alert(Alert.AlertType.ERROR, "Vous n'avez pas le nombre exacte du diamant", ButtonType.OK);
                                    alert1.show();
                                    flowPanePart.getChildren().clear();
                                    AfficherParticipation();
                                    flowPaneComp.getChildren().clear();
                                    affichageCompetition();
                                }
                            } else {

                                System.out.println(motDePasse);

                                QrCode("Bonjour Mr  --" + nom + " " + prenom + "-- je vous souhaite la bienvenue au sein de notre Competition sous le Titre --" + titre + "-- Voici votre Mot de passe pour accédé à --" + titre + "-- Mot de passe =====> :" + motDePasse);

                                flowPanePart.getChildren().clear();
                                AfficherParticipation();
                                flowPaneComp.getChildren().clear();
                                affichageCompetition();

                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(UserInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }

                });
            }

            
            Button btnDetail = new Button("Detail");
            btnDetail.setTextOverrun(OverrunStyle.CLIP);
            btnDetail.setStyle("-fx-background-color : #E4E0E0;");
            btnDetail.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {

                    try {

                        FXMLLoader LOADER = new FXMLLoader(getClass().getResource("Details.fxml"));
                        Parent rootDetails = LOADER.load();
                        DetailsController louay = LOADER.getController();
                        louay.setDetails(Titre1, Description1, Image1, DateD1, DateF1,Type1,Cout1);

                        Scene scene = new Scene(rootDetails, 600, 400);

                        Stage primaryStage = new Stage();
                        primaryStage.setScene(scene);
                        primaryStage.show();

                    } catch (IOException ex) {

                    }

                }
            });

           
            panne.getChildren().add(btnPart);
            panne.getChildren().add(btnDetail);
            VBoxComp.getChildren().add(panne);
            VBoxComp.getChildren().add(titreComp);
            VBoxComp.getChildren().add(description);

            vbx.add(VBoxComp);
            btnP.add(panne);
            flowPaneComp.getChildren().add(vbx.get(i));

            flowPaneComp.getChildren().add(as.get(i));

            if (i == 0) {
                System.out.println("i=0 llllll");
            } else if (((i + 1) % 2) == 0) {
                Separator sepHoriz = new Separator(Orientation.HORIZONTAL);
                sepHoriz.setPrefWidth(364);
                sepHoriz.setPrefHeight(30);
                sepHoriz.setVisible(false);
                flowPaneComp.getChildren().add(sepHoriz);

            }
        }
    }

    private void AfficherParticipation() throws SQLException {

        //User userTest = new User(102, "Louay", "Yahyaoui", "louay@esprit.tn", "louay", "oussema", "male", "28-08-1992", 234223878, "SimpleUtilisateur", "Comedie", "hahaha", 5000);
        ServiceParticipation service1 = new ServiceParticipation();
        ObservableList<Competition> MyList = FXCollections.observableArrayList(service1.findByRechercher(Userconnected));

        System.out.println("We're right here for now ");
        ArrayList<Separator> as = new ArrayList<>();
        ArrayList<VBox> vbx = new ArrayList<>();
        ArrayList<HBox> btnP = new ArrayList<>();

        for (int i = 0; i < MyList.size(); i++) {

            Separator h = new Separator(Orientation.VERTICAL);
            h.setPrefWidth(17);
            h.setPrefHeight(24);
            h.setVisible(false);
            as.add(h);

            VBox VBoxComp = new VBox();

            VBoxComp.setSpacing(5);
            VBoxComp.setStyle("-fx-background-color : #FFFFFF;");
            //VBoxComp.setStyle("-fx-border-color : #2B48E8;");
            VBoxComp.setAlignment(Pos.CENTER);
            VBoxComp.setPrefHeight(169);
            VBoxComp.setPrefWidth(184);
            HBox panne = new HBox();
            panne.setSpacing(5);
            panne.setStyle("-fx-background-color : #FFFFFF;");
            //VBoxComp.setStyle("-fx-border-color : #2B48E8;");
            panne.setAlignment(Pos.CENTER);
            panne.setPrefHeight(30);
            panne.setPrefWidth(70);

            Rectangle c = new Rectangle(184, 90);

            try {
                c.setFill(new ImagePattern(new Image(new FileInputStream("C:/wamp64/www/PI_DEV_Image/" + MyList.get(i).getImageC()))));
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            }

            VBoxComp.getChildren().add(c);

            Label titreComp = new Label("Titre : " + MyList.get(i).getTitre());
            Label dateF = new Label("Cout: " + MyList.get(i).getCout());
            int idCompetition = MyList.get(i).getIdCompetition();
            ServiceCompetition serC = new ServiceCompetition();
            Competition c1 = serC.findById(idCompetition);

            Button btnSupp = new Button("Supprimer");
            btnSupp.setTextOverrun(OverrunStyle.CLIP);
            btnSupp.setStyle("-fx-background-color : #E82B34;");
            btnSupp.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    try {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        Button button2 = new Button();
                        button2.setStyle("-fx-background-color: #F54F4F");
                        alert.setTitle("Suppression ");
                        alert.setContentText("Voulez-vous vraiment supprimer cette Competition ?");
                        Optional<ButtonType> result = alert.showAndWait();
                        if (result.get() == ButtonType.OK) {
                            Participation p = new Participation(c1, Userconnected);
                            ServiceParticipation ser = new ServiceParticipation();
                            ser.delete(p);
                            qrviewer.setImage(null);
                            flowPanePart.getChildren().clear();
                            AfficherParticipation();
                            flowPaneComp.getChildren().clear();
                            affichageCompetition();

                        } else {
                            flowPanePart.getChildren().clear();
                            AfficherParticipation();
                            flowPaneComp.getChildren().clear();
                            affichageCompetition();

                        }

                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            });

            Button btnAff = new Button("Ticket");
            btnAff.setTextOverrun(OverrunStyle.CLIP);
            btnAff.setStyle("-fx-background-color : #B9C0C7;");
            btnAff.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {

                    try {
                        ServiceTicket service = new ServiceTicket();
                        Ticket tik = service.findBy(c1, Userconnected);
                        String motDePasse = tik.getMotDePasse();
                        String titre = c1.getTitre();
                        String nom = Userconnected.getNom();
                        String prenom = Userconnected.getPrenom();
                        ServiceParticipation serP = new ServiceParticipation();
                        System.out.println(motDePasse);

                        QrCode("Bonjour Mr  --" + nom + " " + prenom + "-- je vous souhaite la bienvenue au sein de notre Competition sous le Titre --" + titre + "-- Voici votre Mot de passe pour accédé à --" + titre + "-- Mot de passe =====> :" + motDePasse);

                        flowPanePart.getChildren().clear();
                        AfficherParticipation();
                        flowPaneComp.getChildren().clear();
                        affichageCompetition();
                    } catch (SQLException ex) {
                        Logger.getLogger(UserInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            });

            panne.getChildren().add(btnSupp);
            panne.getChildren().add(btnAff);

            VBoxComp.getChildren().add(panne);
            VBoxComp.getChildren().add(titreComp);
            VBoxComp.getChildren().add(dateF);

            vbx.add(VBoxComp);
            btnP.add(panne);
            flowPanePart.getChildren().add(vbx.get(i));

            flowPanePart.getChildren().add(as.get(i));

            if (i == 0) {
                System.out.println("i=0 llllll");
            } else if (((i + 1) % 2) == 0) {
                Separator sepHoriz = new Separator(Orientation.HORIZONTAL);
                sepHoriz.setPrefWidth(364);
                sepHoriz.setPrefHeight(30);
                sepHoriz.setVisible(false);
                flowPanePart.getChildren().add(sepHoriz);

            }
        }

    }

    @FXML
    public void Back(ActionEvent event) throws IOException {
        FXMLLoader LOADER = new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent rootChasseur = LOADER.load();
        btnBack.getScene().setRoot(rootChasseur);

    }

    @FXML
    private void main(MouseEvent event) {
    }

    @FXML
    private void chat1(MouseEvent event) {
    }

}
