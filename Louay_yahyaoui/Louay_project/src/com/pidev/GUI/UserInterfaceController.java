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
import com.pidev.Entite.Competition;
import com.pidev.Entite.Participation;
import com.pidev.Entite.Ticket;
import com.pidev.Entite.User;
import com.pidev.Service.ServiceCompetition;
import com.pidev.Service.ServiceParticipation;
import com.pidev.Service.ServiceTicket;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
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
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.Separator;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

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
            VBoxComp.setPrefHeight(157);
            VBoxComp.setPrefWidth(197);
            HBox panne = new HBox();
            panne.setSpacing(5);
            panne.setStyle("-fx-background-color : #FFFFFF;");
            //VBoxComp.setStyle("-fx-border-color : #2B48E8;");
            panne.setAlignment(Pos.CENTER);
            panne.setPrefHeight(30);
            panne.setPrefWidth(70);

            Rectangle c = new Rectangle(197, 78);

            try {
                c.setFill(new ImagePattern(new Image(new FileInputStream("C:/wamp64/www/PI_DEV_Image/" + listComp.get(i).getImageC()))));
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            }

            VBoxComp.getChildren().add(c);

            Label titreComp = new Label("Titre : " + listComp.get(i).getTitre());
            Label description = new Label("Description: " + listComp.get(i).getDescription());
            //Label mail = new Label("Mail: " + listUs.get(i).getMail());
            //Label tel = new Label("téléphone: " + listUs.get(i).getNumTel());
            //Label etat = new Label();
            //Label adresse = new Label("Adresse: " + listUs.get(i).getAdresse().getVille() + "," + listUs.get(i).getAdresse().getPays());

            int idCompetition = listComp.get(i).getIdCompetition();
            Competition c1 = serC.findById(idCompetition);

            Button btnPart = new Button("Participer");
            btnPart.setTextOverrun(OverrunStyle.CLIP);
            btnPart.setStyle("-fx-background-color : #E82B34;");
            String titre = listComp.get(i).getTitre();
            //btnSupp.setDisable(true);
            btnPart.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {

                    try {
                        User userTest = new User(102, "Louay", "Yahyaoui", "louay@esprit.tn", "louay", "oussema", "male", "28-08-1992", 234223878, "SimpleUtilisateur", "Comedie", "hahaha", 5000);

                        //Competition c = new Competition(103, user, "maysa", "event", "BeatBox","2020-02-18","2020-02-28",650);
                        ServiceTicket service = new ServiceTicket();
                        Ticket tik = service.findBy(c1, userTest);
                        String motDePasse = tik.getMotDePasse();
                        //Date date = tik.getDateEmission();
                        String nom = userTest.getNom();
                        String prenom = userTest.getPrenom();
                        ServiceParticipation serP = new ServiceParticipation();

                        //ImageView qrView = new ImageView();
                        if (serP.findById(c1, userTest) == false) {
                            if (userTest.getNbDiament() > c1.getCout()) {

                                serP.ParticiperCompetition(c1, userTest);
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
                                qrviewer.setImage(SwingFXUtils.toFXImage(bufferedImage, null));
                                //QrCode("Bonjour Mr  --" + nom + " " + prenom + "-- je vous souhaite la bienvenue au sein de notre Competition sous le Titre --" + titre + "-- Voici votre Mot de passe pour accédé à --" + titre + "-- Mot de passe =====> :" + motDePasse);
//                    TwilioSms twilio = new TwilioSms();
//                    twilio.sendSms("Participation avec succés Mr--"+nom+" "+prenom);

                                System.out.println(motDePasse);
                                flowPanePart.getChildren().clear();
                            AfficherParticipation();

                            } else {

                                Alert alert1 = new Alert(Alert.AlertType.ERROR, "Vous n'avez pas le nombre exacte du diamant", ButtonType.OK);
                                alert1.show();
                                flowPanePart.getChildren().clear();
                            AfficherParticipation();
                            }
                        } else {

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
                            qrviewer.setImage(SwingFXUtils.toFXImage(bufferedImage, null));
                            flowPanePart.getChildren().clear();
                            AfficherParticipation();

                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(UserInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            });
//
//            Button btnDetail = new Button("...");
//
//            String modifbtn1 = listComp.get(i).getTitre();
//            int idComp = listComp.get(i).getIdCompetition();
//            btnDetail.setStyle("-fx-background-color : #CFDBD1;");
//            btnDetail.setOnAction(new EventHandler<ActionEvent>() {
//                @Override
//                public void handle(ActionEvent event) {
//
//                    try {
//
//                        ServiceCompetition serC = new ServiceCompetition();
//                        Competition c1 = serC.findById(idComp);
//                        titre.setText(c1.getTitre());
//                        desc.setText(c1.getDescription());
//                        cout.setText(String.valueOf(c1.getCout()));
//                        date_debut.setValue(LocalDate.parse(c1.getDateDebut()));
//                        date_fin.setValue(LocalDate.parse(c1.getDateFin()));
//                        talent.setValue(c1.getTypeDeTalent());
//                        File file = new File("C:/wamp64/www/PI_DEV_Image/" + c1.getImageC());
////            System.out.println(file.toURI().toString());
//                        imageC.setImage(new Image(file.toURI().toString()));
//                        //imageC.setImage(new Image("C:/wamp64/www/PI_DEV_Image/"+c1.getImageC()));
//
//                    } catch (SQLException ex) {
//                        Logger.getLogger(IntChasseurController.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//
//                }
//            });
//
//            Button modif = new Button("Modifier");
//            String modifbtn = listComp.get(i).getTitre();
//            modif.setStyle("-fx-background-color : #60A9C4;");
//            modif.setOnAction(new EventHandler<ActionEvent>() {
//                @Override
//                public void handle(ActionEvent event) {
//                   
//                        LocalDate DateDe = date_debut.getValue();
//
//                        String DateD = DateDe.toString();
//
//                        LocalDate DateFin = date_fin.getValue();
//                        String DateFe = DateFin.toString();
//                        String Titre = titre.getText();
//                        String louay = desc.getText();
//
//                        String TypeTalent = talent.getValue();
//                        int Cout = Integer.parseInt(cout.getText());
//                        String image;
//                        try {
//                            
//                            if (ser.update(Titre, louay, TypeTalent, DateD, DateFe, Cout, ImageComp, modifbtn) == true) {
//                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Modification avec succés !", ButtonType.OK);
//                            alert.show();
//                            flowPaneComp.getChildren().clear();
//                            affichageUS();
//
//                        } else {
//                            Alert alert = new Alert(Alert.AlertType.ERROR, "Echec de modification  !", ButtonType.OK);
//                            alert.show();
//                            flowPaneComp.getChildren().clear();
//                            affichageUS();
//
//                        }
//                       
//
//                        // ser.update(Titre, Description, TypeTalent, DateD, DateFe, Cout,modif );
//                        
//
//                    } catch (SQLException ex) {
//                        Logger.getLogger(IntChasseurController.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//            });
            panne.getChildren().add(btnPart);
//            panne.getChildren().add(modif);
//            panne.getChildren().add(btnDetail);
            VBoxComp.getChildren().add(panne);

//            ComboBox<String> actions = new ComboBox<>();
//            actions.setPromptText("Les Actions");
//
//            if (listUs.get(i).getEnabled() == 1) {
//                etat.setText("Etat: Activer");
//                actions.getItems().addAll("Voir Profil", "Désactiver", "Chat");
//            } else if (listUs.get(i).getEnabled() == 0) {
//                etat.setText("Etat: Désactiver");
//                actions.getItems().addAll("Voir Profil", "Activer", "Chat");
//            }
//            else if (listUs.get(i).getEnabled() == -1) {
//                etat.setText("Etat: Non Encore Activer");
//                actions.getItems().addAll("Voir Profil", "Activer", "Chat");
//            }
//            
//            Alert al = new Alert(Alert.AlertType.NONE);
//            ButtonType Oui = new ButtonType("Oui");
//            ButtonType Non = new ButtonType("Non");
//
//            al.getButtonTypes().addAll(Oui, Non);
//            actions.setOnAction(new EventHandler<ActionEvent>() {
//                @Override
//                public void handle(ActionEvent event) {
//                    if (actions.getValue().equals("Voir Profil")) {
//                        System.out.println("Voir Profil " + id);
//                    } else if (actions.getValue().equals("Désactiver")) {
//                        al.setContentText("Vous Voulez vraiment désactiver le compte !");
//                        Optional<ButtonType> OuiNon = al.showAndWait();
//                        if (OuiNon.get() == Oui) {
//                            gUs.desactiverCompte(id);
//                            flowPaneUsers.getChildren().clear();
//                            affichageUS();
//                        }
//
//                    } else if (actions.getValue().equals("Activer")) {
//                        al.setContentText("Vous Voulez vraiment activer le compte !");
//                        Optional<ButtonType> OuiNon = al.showAndWait();
//                        if (OuiNon.get() == Oui) {
//                            gUs.activerCompte(id);
//                            flowPaneUsers.getChildren().clear();
//                            affichageUS();
//                        }
//                    }
//                    System.out.println(actions.getValue() + " ; " + id);
//
//                }
//            });
            VBoxComp.getChildren().add(titreComp);
            VBoxComp.getChildren().add(description);
//            VBoxUser.getChildren().add(mail);
//            VBoxUser.getChildren().add(etat);
//            VBoxUser.getChildren().add(adresse);
//            VBoxUser.getChildren().add(actions);

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
    
    private void AfficherParticipation() throws SQLException
    {
       
        User userTest = new User(102, "Louay", "Yahyaoui", "louay@esprit.tn", "louay", "oussema", "male", "28-08-1992", 234223878, "SimpleUtilisateur", "Comedie", "hahaha", 5000);
        ServiceParticipation service1 = new ServiceParticipation();
        ObservableList<Competition> MyList = FXCollections.observableArrayList(service1.findByRechercher(userTest));
        
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
            Label dateF = new Label("Description: " + MyList.get(i).getDateFin());
            //Label mail = new Label("Mail: " + listUs.get(i).getMail());
            //Label tel = new Label("téléphone: " + listUs.get(i).getNumTel());
            //Label etat = new Label();
            //Label adresse = new Label("Adresse: " + listUs.get(i).getAdresse().getVille() + "," + listUs.get(i).getAdresse().getPays());

            int idCompetition = MyList.get(i).getIdCompetition();
            ServiceCompetition serC = new ServiceCompetition();
            Competition c1 = serC.findById(idCompetition);
            
            Button btnSupp = new Button("Supprimer");
            btnSupp.setTextOverrun(OverrunStyle.CLIP);
            btnSupp.setStyle("-fx-background-color : #E82B34;");
            
            //btnSupp.setDisable(true);
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
                            Participation p = new Participation(c1, userTest);
                            ServiceParticipation ser = new ServiceParticipation();
                            ser.delete(p);
                            flowPanePart.getChildren().clear();
                            AfficherParticipation();

                        } else {
                           flowPanePart.getChildren().clear();
                            AfficherParticipation();

                        }

                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            });

            
             panne.getChildren().add(btnSupp);
//            panne.getChildren().add(modif);
//            panne.getChildren().add(btnDetail);
            VBoxComp.getChildren().add(panne);
            VBoxComp.getChildren().add(titreComp);
            VBoxComp.getChildren().add(dateF);
//            VBoxUser.getChildren().add(mail);
//            VBoxUser.getChildren().add(etat);
//            VBoxUser.getChildren().add(adresse);
//            VBoxUser.getChildren().add(actions);

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

            }}
            
             
             
             
        

    
    }

}
