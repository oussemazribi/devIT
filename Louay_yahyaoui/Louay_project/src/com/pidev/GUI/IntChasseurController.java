/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.GUI;

import com.jfoenix.controls.JFXTextField;
import com.pidev.Entite.Competition;
import com.pidev.Entite.User;
import static com.pidev.GUI.tnGotTalent.Userconnected;
import com.pidev.Service.ServiceCompetition;
import com.sun.mail.iap.Literal;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.AccessibleRole;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.converter.LocalDateTimeStringConverter;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import org.bouncycastle.asn1.DERNumericString;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author loume78
 */
public class IntChasseurController implements Initializable {

    private String ImageComp;
    @FXML
    private FlowPane flowPaneComp;

    @FXML
    private TextField titre;
    @FXML
    private TextField desc;
    @FXML
    private TextField cout;

    @FXML
    private ComboBox<String> talent;
    @FXML
    private DatePicker date_debut;
    @FXML
    private DatePicker date_fin;
    @FXML
    private Button ajoutComp;
    @FXML
    private Button browse;
    @FXML
    private ImageView imageC;
    @FXML
    private Button btnBack;
    @FXML
    private ImageView titreCheck;
    @FXML
    private ImageView descriptionCheck;
    @FXML
    private ImageView debCheck;
    @FXML
    private ImageView finCheck;
    @FXML
    private ImageView coutCheck;
    @FXML
    private ImageView talentChecker;

    ObservableList<String> list = FXCollections.observableArrayList("Dance", "BeatBox", "Musique", "Comedie");
//    
//    public String getPath()
//    {
//         FileChooser fc = new FileChooser();
//         fc.showOpenDialog(ownerWindow);
//        
//        imageC.setText(fc.getCurrentDirectory();
//    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            talent.setItems(list);
            affichageUS();

            System.out.println("We're right here for now ");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void affichageUS() throws SQLException {

        ServiceCompetition ser = new ServiceCompetition();

        ObservableList<Competition> listComp = FXCollections.observableArrayList(ser.readAll1());

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

            VBoxComp.setSpacing(7);
            VBoxComp.setStyle("-fx-background-color : #FFFFFF;");
            //VBoxComp.setStyle("-fx-border-color : #2B48E8;");
            VBoxComp.setAlignment(Pos.CENTER);
            VBoxComp.setPrefHeight(265);
            VBoxComp.setPrefWidth(230);
            HBox panne = new HBox();
            panne.setSpacing(5);
            panne.setStyle("-fx-background-color : #FFFFFF;");
            //VBoxComp.setStyle("-fx-border-color : #2B48E8;");
            panne.setAlignment(Pos.CENTER);
            panne.setPrefHeight(30);
            panne.setPrefWidth(80);

            Rectangle c = new Rectangle(230, 180);

//                ImageView img = new ImageView(new Image(new FileInputStream("C:\\Users\\loume78\\Desktop\\Mon_cv\\loume.png")));
//                img.setFitHeight(10);
//                img.setFitWidth(20);
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
            Competition c1 = ser.findById(idCompetition);

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
                            ser.delete(c1);
                            flowPaneComp.getChildren().clear();
                            affichageUS();

                        } else {
                            flowPaneComp.getChildren().clear();
                            affichageUS();

                        }

                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            });

            Button btnDetail = new Button("...");

            String modifbtn1 = listComp.get(i).getTitre();
            int idComp = listComp.get(i).getIdCompetition();
            btnDetail.setStyle("-fx-background-color : #CFDBD1;");
            btnDetail.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {

                    try {

                        ServiceCompetition serC = new ServiceCompetition();
                        Competition c1 = serC.findById(idComp);
                        titre.setText(c1.getTitre());
                        desc.setText(c1.getDescription());
                        cout.setText(String.valueOf(c1.getCout()));
                        date_debut.setValue(LocalDate.parse(c1.getDateDebut()));
                        date_fin.setValue(LocalDate.parse(c1.getDateFin()));
                        talent.setValue(c1.getTypeDeTalent());
                        File file = new File("C:/wamp64/www/PI_DEV_Image/" + c1.getImageC());
//            System.out.println(file.toURI().toString());
                        imageC.setImage(new Image(file.toURI().toString()));
                        //imageC.setImage(new Image("C:/wamp64/www/PI_DEV_Image/"+c1.getImageC()));

                    } catch (SQLException ex) {
                        Logger.getLogger(IntChasseurController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            });

            Button modif = new Button("Modifier");
            String modifbtn = listComp.get(i).getTitre();
            modif.setStyle("-fx-background-color : #60A9C4;");
            modif.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {

                    LocalDate DateDe = date_debut.getValue();

                    String DateD = DateDe.toString();

                    LocalDate DateFin = date_fin.getValue();
                    String DateFe = DateFin.toString();
                    String Titre = titre.getText();
                    String louay = desc.getText();

                    String TypeTalent = talent.getValue();
                    int Cout = Integer.parseInt(cout.getText());

                    try {

                        if (ser.update(Titre, louay, TypeTalent, DateD, DateFe, Cout, ImageComp, modifbtn) == true) {
                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Modification avec succés !", ButtonType.OK);
                            alert.show();
                            flowPaneComp.getChildren().clear();
                            affichageUS();

                        } else {
                            Alert alert = new Alert(Alert.AlertType.ERROR, "Echec de modification  !", ButtonType.OK);
                            alert.show();
                            flowPaneComp.getChildren().clear();
                            affichageUS();

                        }

                        // ser.update(Titre, Description, TypeTalent, DateD, DateFe, Cout,modif );
                    } catch (SQLException ex) {
                        Logger.getLogger(IntChasseurController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            panne.getChildren().add(btnSupp);
            panne.getChildren().add(modif);
            panne.getChildren().add(btnDetail);
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

//    public  void getInputPath() {
//  JFileChooser file = new JFileChooser();
//      file.setMultiSelectionEnabled(true);
//      file.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
//      file.setFileHidingEnabled(false);
//      if (file.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
//         java.io.File f = file.getSelectedFile();
//         System.err.println(f.getPath());
//      }
//}
//    public String handle1() {
//
//                   
//                       
//                        JFileChooser chooser = new JFileChooser();
//                        chooser.showOpenDialog(null);
//                        File f =chooser.getSelectedFile();
//                        String path =f.getAbsolutePath();
//                        System.out.println(pathe);
//                        return path;
//
//          
    @FXML
    public void ChoiceImage() throws FileNotFoundException, IOException {
        FileChooser fc = new FileChooser();
        //fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Images", listFichier));
        File f = fc.showOpenDialog(null);
        if (f != null) {

            //Commentaire.setText("Image selectionnée" + f.getAbsolutePath());
            InputStream is = null;
            OutputStream os = null;
            try {
                is = new FileInputStream(new File(f.getAbsolutePath()));
//             
                os = new FileOutputStream(new File("C:/wamp64/www/PI_DEV_Image/" + f.getName()));
                byte[] buffer = new byte[1024];
                int length;
                while ((length = is.read(buffer)) > 0) {
                    os.write(buffer, 0, length);
                }
                System.out.println("louay");

            } finally {
                is.close();
                os.close();

            }

            File file = new File("C:/wamp64/www/PI_DEV_Image/" + f.getName());
//            System.out.println(file.toURI().toString());
            imageC.setImage(new Image(file.toURI().toString()));
            ImageComp = f.getName();
            System.out.println(ImageComp);
        } else if (f == null) {
            //Commentaire.setText("Erreur chargement de l'image");
            System.out.println("Erreur !");
        }

    }

    @FXML
    public void getInformation() throws SQLException {
        //User userTest = new User(101, "maysa", "habbachi", "hahaha", "hahaha", "haahha", "haha", "589", 2345, "Administrateur", "Dance", "jajaja", 20);

        LocalDate DateDe = date_debut.getValue();

        String DateD = DateDe.toString();

        LocalDate DateFin = date_fin.getValue();
        String DateFe = DateFin.toString();
        String Titre = titre.getText();
        String Description = desc.getText();
        String TypeTalent = talent.getValue();
        //int Cout = Integer.parseInt(cout.getText());
        System.out.println(cout.getText());
        System.out.println(testCout());
        if(testCout()==true)
        {
        Competition c1 = new Competition(Userconnected, Titre, Description, TypeTalent, DateD, DateFe,Integer.parseInt(cout.getText()), ImageComp);
        ServiceCompetition ser1 = new ServiceCompetition();
        //boolean test = false;
        //ser1.ajouter1(c1);
        if (ser1.findBy(c1) == false) {
            if ((testSaisie() == true) && (testCout()==true)) {
//                if (testDateFin() == true) {
//                    if ((!cout.getText().isEmpty()) && (!titre.getText().isEmpty())) {
//                        if (testCout() == true) {
                ser1.ajouter(c1);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Ajout de --" + c1.getTitre() + "-- effectué avec succées", ButtonType.OK);
                alert.show();
                flowPaneComp.getChildren().clear();
                affichageUS();
            }
//                        } else {
//                            Alert alert = new Alert(Alert.AlertType.ERROR, "Verifier que vous avez entrer un entier dans le Cout !", ButtonType.OK);
//                            alert.show();
//
//                        }
//                    } else {
//                        Alert alert = new Alert(Alert.AlertType.ERROR, "Verifier que vous avez remlir toutes les champs !", ButtonType.OK);
//                        alert.show();
//
//                    }
//                } else {
//                    Alert alert = new Alert(Alert.AlertType.ERROR, "Verifier que la date de debut est inferieure a la date fin", ButtonType.OK);
//                    alert.show();
//
//                }
//            } else {
//                Alert alert = new Alert(Alert.AlertType.ERROR, "Verifier que la date de debut est supeieur a la date courante", ButtonType.OK);
//                alert.show();
//
//            }

        } else {
            Alert alert1 = new Alert(Alert.AlertType.ERROR, "Cette Competition existe deja ! ", ButtonType.OK);
            alert1.show();
            //this.affichageUS();
            flowPaneComp.getChildren().clear();
            affichageUS();

        }
        }
        else
        {
            Alert alert1 = new Alert(Alert.AlertType.ERROR, "le cout doit etre un entier ! ", ButtonType.OK);
            alert1.show();
            
        }

    }

//     public void AfficherTous() throws SQLException {
//
//        ServiceCompetition ser = new ServiceCompetition();
//
//        ObservableList<Competition> list = FXCollections.observableArrayList(ser.readAll1());
//
//        System.out.println("We're right here for now ");
//
//        tableAssociation.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
//        tableAssociation.setTableMenuButtonVisible(true);
//        ColumnTitre.setCellValueFactory(new PropertyValueFactory<Competition, String>("Titre"));
//        ColumnDescription.setCellValueFactory(new PropertyValueFactory<Competition, String>("Description"));
//        ColumnTalent.setCellValueFactory(new PropertyValueFactory<Competition, String>("TypeDeTalent"));
//        ColumnDateDebut.setCellValueFactory(new PropertyValueFactory<Competition, String>("DateDebut"));
//        ColumnDateFin.setCellValueFactory(new PropertyValueFactory<Competition, String>("DateFin"));
//        ColumnCout.setCellValueFactory(new PropertyValueFactory<Competition, String>("Cout"));
//        tableCompetition.setItems(list);
//
//    }
//    public void ChoiceImage(ActionEvent event) throws IOException
//    {
//     
//        FileChooser fc = new FileChooser();
//        File selecFile = fc.showOpenDialog(null);
//       
//        
//        if(selecFile !=null)
//        {
//            BufferedImage bufferedImage = ImageIO.read(selecFile);
//          Image imageSer   = SwingFXUtils.toFXImage(bufferedImage, null);
//                //IImage.setImage(imageSer);
//        }
//        else
//        {
//            System.out.println("file is not valid");
//        }
//       
//  
//  }
    @FXML
    public void Back(ActionEvent event) throws IOException {
        FXMLLoader LOADER = new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent rootChasseur = LOADER.load();
        btnBack.getScene().setRoot(rootChasseur);

    }

    private Boolean testSaisie() {

        if (!testTitre()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "verifier que vous avez saisir le Titre !", ButtonType.OK);
            alert.show();
        }
        if (!testDescription()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "verifier que vous avez saisir la Description !", ButtonType.OK);
            alert.show();
        }
        if (!testTalent()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "verifier que vous avez selectionner le type de talent !", ButtonType.OK);
            alert.show();
        }

        if (!testDateDebut()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "verifier que la date debut est superieure a la date courante !", ButtonType.OK);
            alert.show();
        }
        if (!testDateFin()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "verifier que la date fin est superieure a la date debut !", ButtonType.OK);
            alert.show();
        }

        if (!testCout()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "verifier que vous avez saisie des entier dans le Cout !", ButtonType.OK);
            alert.show();
        }

        return testTitre() && testDescription() && testTalent() && testDateDebut() && testDateFin() && testCout();
    }

    private Boolean testTalent() {

        if (!talent.getSelectionModel().selectedItemProperty().equals("")) {
            File file = new File("C:/wamp64/www/PI_DEV_Image/tick.png");
//            System.out.println(file.toURI().toString());
            talentChecker.setImage(new Image(file.toURI().toString()));
            return true;
        } else {
            File file = new File("C:/wamp64/www/PI_DEV_Image/close.png");
//            System.out.println(file.toURI().toString());
            talentChecker.setImage(new Image(file.toURI().toString()));

            return false;

        }
    }

    private Boolean testDescription() {
        int nbNonChar = 0;
        for (int i = 1; i < desc.getText().trim().length(); i++) {
            char ch = desc.getText().charAt(i);
            if (!Character.isLetter(ch)) {
                nbNonChar++;
            }
        }

        if (nbNonChar == 0 && desc.getText().trim().length() >= 3) {
            File file = new File("C:/wamp64/www/PI_DEV_Image/tick.png");
//            System.out.println(file.toURI().toString());
            descriptionCheck.setImage(new Image(file.toURI().toString()));
            return true;
        } else {
            File file = new File("C:/wamp64/www/PI_DEV_Image/close.png");
//            System.out.println(file.toURI().toString());
            descriptionCheck.setImage(new Image(file.toURI().toString()));
            return false;

        }

    }

    private Boolean testTitre() {
        int nbNonChar = 0;
        for (int i = 1; i < titre.getText().trim().length(); i++) {
            char ch = titre.getText().charAt(i);
            if (!Character.isLetter(ch)) {
                nbNonChar++;
            }
        }

        if (nbNonChar == 0 && titre.getText().trim().length() >= 3) {
            File file = new File("C:/wamp64/www/PI_DEV_Image/tick.png");
//            System.out.println(file.toURI().toString());
            titreCheck.setImage(new Image(file.toURI().toString()));
            return true;
        } else {
            File file = new File("C:/wamp64/www/PI_DEV_Image/close.png");
//            System.out.println(file.toURI().toString());
            titreCheck.setImage(new Image(file.toURI().toString()));
            return false;

        }

    }

    private Boolean testDateDebut() {
        //java.sql.Timestamp today_date = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
        ChronoLocalDate dt
                = LocalDate.now();
        if (date_debut.getValue() != null && date_debut.getValue().isAfter(dt)) {

            File file = new File("C:/wamp64/www/PI_DEV_Image/tick.png");
//            System.out.println(file.toURI().toString());
            debCheck.setImage(new Image(file.toURI().toString()));
            System.out.println("yes");
            return true;

        } else {

            File file = new File("C:/wamp64/www/PI_DEV_Image/close.png");
//            System.out.println(file.toURI().toString());
            debCheck.setImage(new Image(file.toURI().toString()));
            System.out.println("yes");
            System.out.println("no");

            return false;

        }

    }

//     @FXML
//    private Boolean testNom() {
//        int nbNonChar = 0;
//        for (int i = 1; i < NomTXFLD.getText().trim().length(); i++) {
//            char ch = NomTXFLD.getText().charAt(i);
//            if (!Character.isLetter(ch)) {
//                nbNonChar++;
//            }
//        }
//
//        if (nbNonChar == 0 && NomTXFLD.getText().trim().length() >= 3) {
//            nomCheckMark.setImage(new Image("Images/checkMark.png"));
//            return true; 
//        } else {
//            nomCheckMark.setImage(new Image("Images/erreurcheckMark.png"));
////                erreur = erreur + ("Pas de caractere permit dans le telephone\n");
//            return false;
//
//        }
//
//    }
    private Boolean testDateFin() {
//        java.sql.Timestamp today_date = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
        ChronoLocalDate dt
                = LocalDate.now();
        if (date_fin.getValue() != null && date_fin.getValue() != null && date_fin.getValue().isAfter(date_debut.getValue())) {
            File file = new File("C:/wamp64/www/PI_DEV_Image/tick.png");
//            System.out.println(file.toURI().toString());
            finCheck.setImage(new Image(file.toURI().toString()));
            System.out.println("yes");
            return true;

        } else {

            File file = new File("C:/wamp64/www/PI_DEV_Image/close.png");
//            System.out.println(file.toURI().toString());
            finCheck.setImage(new Image(file.toURI().toString()));
            System.out.println("no");
            return false;
        }

    }
    
    
//    @FXML
//    private void TextFieldKeyTyped( javafx.scene.input.KeyEvent event)
//    {
//        EventType c=event.getEventType();
//        if(!(Character.) || (c==KeyEvent.VK_BACK_SPACE)  || (c==KeyEvent.VK_DELETE))
//        {
//            evt.consume();
//        }
//    }

    private boolean testCout() {
        
    
    
        
           
        
       if((cout.getText().matches("^[0-9]*$")))
       {
            File file = new File("C:/wamp64/www/PI_DEV_Image/tick.png");
//            System.out.println(file.toURI().toString());
            coutCheck.setImage(new Image(file.toURI().toString()));
            return true;
        }
       else
       {
        File file = new File("C:/wamp64/www/PI_DEV_Image/close.png");
//            System.out.println(file.toURI().toString());
        coutCheck.setImage(new Image(file.toURI().toString()));
        return false;
    }

    }
    
     private void fonction(java.awt.event.KeyEvent evt)
    {
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c) ||( c==KeyEvent.VK_BACK_SPACE ) || c==KeyEvent.VK_DELETE))
        {
                        evt.consume();

            
        }
    }

//    @FXML
//    private Boolean testCout() {
////        java.sql.Timestamp today_date = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
//        File file = new File("C:/wamp64/www/PI_DEV_Image/tick.png");
////            System.out.println(file.toURI().toString());
//        coutCheck.setImage(new Image(file.toURI().toString()));
//        return true;
//    }
//}
//File file = new File("C:/wamp64/www/PI_DEV_Image/close.png");
////            System.out.println(file.toURI().toString());
//            coutCheck.setImage(new Image(file.toURI().toString()));
//            
//                    
//            
//        
//        return false;
//
//        
//
//    }

//    private Boolean testSaisie() {
//
//        if (!testDateDebut()) {
//            Alert alert = new Alert(Alert.AlertType.ERROR, "Veuillez verifier que vous avez choisi une date superieur a la date courante \n", ButtonType.CLOSE);
//            alert.show();
//        }
//
//        if (!testDateFin()) {
//            Alert alert = new Alert(Alert.AlertType.ERROR, "Veuillez verifier que vous avez choisi une date din superieur a la date debut \n", ButtonType.CLOSE);
//            alert.show();
//        }
//
//        return testDateDebut() && testDateFin();
//    }

    @FXML
    private void main(MouseEvent event) {
    }

    @FXML
    private void chat1(MouseEvent event) {
    }

    @FXML
    private void fonction(javafx.scene.input.KeyEvent event) {
    }

    @FXML
    private void fonction(ActionEvent event) {
    }
}
