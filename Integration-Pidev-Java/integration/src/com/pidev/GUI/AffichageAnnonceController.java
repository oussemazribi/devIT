/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.GUI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

import com.pidev.Entite.Annonce;
import com.pidev.Entite.User;
import static com.pidev.GUI.Integration.Userconnected;
import com.pidev.Service.ServiceAnnonce;
import com.pidev.Service.ServiceUser;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ousse
 */
public class AffichageAnnonceController implements Initializable {

    private Button annuler;
    private Label nom;

    @FXML
    private FlowPane flowPaneAnnonce;

    @FXML
    private Button plus;

    private final Background focusBackground = new Background(new BackgroundFill(Color.GREY, CornerRadii.EMPTY, Insets.EMPTY));
    private final Background unfocusBackground = new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY));
    @FXML
    private ImageView UserImage;
    @FXML
    private Label UserName;
    ServiceUser su = new ServiceUser();

    /**
     *
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            
                 String im = su.findbyImage(Userconnected.getIdUser());
            File file = new File("C:/xampp/htdocs/Image_Pi/" + im);
            UserImage.setImage(new Image(file.toURI().toString()));
            String alo = su.findByIdname(Userconnected.getIdUser());
              String friendlastname = su.findByIlastname(Userconnected.getIdUser());
            UserName.setText(alo+" "+friendlastname);
            AfficherAnnonce();
        } catch (SQLException ex) {
            Logger.getLogger(AffichageAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    Annonce a1;
    ServiceAnnonce ser = new ServiceAnnonce();
    ServiceUser ser1 = new ServiceUser();

       void AfficherAnnonce() throws SQLException {

        ObservableList<Annonce> list = FXCollections.observableArrayList(ser.readAll());
int bb;
        //System.out.println("We're right here for now ");
        ArrayList<Separator> as = new ArrayList<>();
        ArrayList<VBox> vbx = new ArrayList<>();
        ArrayList<HBox> btnP = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {

            Separator h = new Separator(Orientation.VERTICAL);
            h.setPrefWidth(17);
            h.setPrefHeight(24);
            h.setVisible(false);
            as.add(h);

            VBox VBoxAnnonce = new VBox();

            VBoxAnnonce.setSpacing(7);
            VBoxAnnonce.setStyle("-fx-background-color : #FFFFFF;");
            //VBoxComp.setStyle("-fx-border-color : #2B48E8;");
            VBoxAnnonce.setAlignment(Pos.CENTER);
            VBoxAnnonce.setPrefHeight(265);
            VBoxAnnonce.setPrefWidth(230);


            Circle c = new Circle(100);

//                ImageView img = new ImageView(new Image(new FileInputStream("C:\\Users\\loume78\\Desktop\\Mon_cv\\loume.png")));
//                img.setFitHeight(10);
//                img.setFitWidth(20);
            try {
                c.setFill(new ImagePattern(new Image(new FileInputStream("C:/xampp/htdocs/Image_Pi/" + list.get(i).getImages()))));
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            }

            VBoxAnnonce.getChildren().add(c);

            Label NomAnnonce = new Label(list.get(i).getNom());
            NomAnnonce.setFont(new Font("MV Boli",20));



            VBoxAnnonce.getChildren().add(NomAnnonce);


            vbx.add(VBoxAnnonce);
            flowPaneAnnonce.getChildren().add(vbx.get(i));

            flowPaneAnnonce.getChildren().add(as.get(i));

            if (i == 0) {
                System.out.println("i=0 llllll");
            } else if (((i + 1) % 2) == 0) {
                Separator sepHoriz = new Separator(Orientation.HORIZONTAL);
                sepHoriz.setPrefWidth(364);
                sepHoriz.setPrefHeight(30);
                sepHoriz.setVisible(false);
                flowPaneAnnonce.getChildren().add(sepHoriz);

            }
            
            int idAnnonce = list.get(i).getIdAnnonce();
            a1 = ser.findById(idAnnonce);
            int id = a1.getIdAnnonce();
            String Nom = a1.getNom();
            String Description = a1.getDescription();
            int Prix = a1.getPrix();
            String Etatt = a1.getEtat();
            User u = a1.getUser();
            String image = a1.getImages();
            
            VBoxAnnonce.backgroundProperty().bind(Bindings
                    .when(VBoxAnnonce.focusedProperty())
                    .then(focusBackground)
                    .otherwise(unfocusBackground)
            );
            VBoxAnnonce.setOnMouseClicked((e)
                    -> {
                
                VBoxAnnonce.requestFocus();

                try {
                    // Stage window = new Stage();

                    // Parent root2;
                    FXMLLoader LOADER = new FXMLLoader(getClass().getResource("DetailAnnonce.fxml"));
                     
                    Parent root2 = LOADER.load();
                      DetailAnnonceController Detail = LOADER.getController();
                      System.out.println("=== Nom: "+Nom);
                 Detail.DetailAnnonce(id,Nom, Description, Prix, image,Etatt, u);
                    // Scene scene = new Scene(root2);
                    VBoxAnnonce.getScene().setRoot(root2);
                   
                    // nom.setText(a1.getNom());
                    // window.show();

                } catch (IOException ex) {
                    Logger.getLogger(AffichageAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(AffichageAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
                }

            });

        }
     
    }

//    @FXML
//    void detail(ActionEvent event) throws IOException {
//
//        Parent root2 = FXMLLoader.load(getClass().getResource("DetailAnnonce.fxml"));
//        Scene scene = new Scene(root2);
//
//    }
    @FXML
    void ajout(ActionEvent event) throws IOException {

        FXMLLoader LOADER = new FXMLLoader(getClass().getResource("AjoutAnnonce.fxml"));
        Parent root = LOADER.load();

        plus.getScene().setRoot(root);

    }

    private void Annuler(ActionEvent event) throws IOException {
        FXMLLoader LOADER = new FXMLLoader(getClass().getResource("AffichageAnnonce.fxml"));
        Parent root1 = LOADER.load();
        annuler.getScene().setRoot(root1);
    }


    @FXML
    private void chat1(MouseEvent event) {
       FXMLLoader LOADER = new FXMLLoader(getClass().getResource("Conversations.fxml"));
                try {
                    Parent root = LOADER.load();
                    Scene rana = new Scene(root);
                      ConversationsController hamza = LOADER.getController();
                    Stage window =(Stage)((Node) event.getSource()).getScene().getWindow() ;
              
                    window.setScene(rana);
                    window.show();
                } catch (IOException ex) {
                  
                }
    }

    @FXML
    private void competition(MouseEvent event) {
            if ("Chasseur du talent".equals(Userconnected.getTypeCompte()))
       {
           FXMLLoader LOADER = new FXMLLoader(getClass().getResource("IntChasseur.fxml"));
                try {
                    Parent root = LOADER.load();
                    Scene rana = new Scene(root);
                      IntChasseurController hamza = LOADER.getController();
                    Stage window =(Stage)((Node) event.getSource()).getScene().getWindow() ;
              
                    window.setScene(rana);
                    window.show();
                } catch (IOException ex) {
                  
    }}
       if ("Utilisateur simple".equals(Userconnected.getTypeCompte()))
       {
      try {
                Parent root = FXMLLoader.load(getClass().getResource("UserInterface.fxml"));
                 annuler.getScene().setRoot(root);

            } catch (IOException ex) {System.out.println(ex.getMessage());
            }
    }}

    @FXML
    private void annonce(MouseEvent event) {
              FXMLLoader LOADER = new FXMLLoader(getClass().getResource("AffichageAnnonce.fxml"));
                try {
                    Parent root = LOADER.load();
                    Scene rana = new Scene(root);
                      AffichageAnnonceController hamza = LOADER.getController();
                    Stage window =(Stage)((Node) event.getSource()).getScene().getWindow() ;
              
                    window.setScene(rana);
                    window.show();
                } catch (IOException ex) {
                  
                }
    }

    @FXML
    private void acceuil(MouseEvent event) {
                                  FXMLLoader LOADER = new FXMLLoader(getClass().getResource("Home_1.fxml"));
        try {
            Parent root = LOADER.load();
            Scene rana = new Scene(root);
            HomeController_1 hamza = LOADER.getController();
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(rana);
            window.show();
        } catch (IOException ex) {

        }
    }

    @FXML
    private void reclamation(MouseEvent event) {
             if ("Administrateur".equals(Userconnected.getTypeCompte()))
        { 
            try {
                Parent root = FXMLLoader.load(getClass().getResource("interfaceadmin.fxml"));
 plus.getScene().setRoot(root);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
       if ("Utilisateur simple".equals(Userconnected.getTypeCompte()))
       {
      try {
                Parent root = FXMLLoader.load(getClass().getResource("interfaceUser1.fxml"));
                 plus.getScene().setRoot(root);

            } catch (IOException ex) {System.out.println(ex.getMessage());
            }
    }
                if ("Chasseur du talent".equals(Userconnected.getTypeCompte()))
       {
      try {
                Parent root = FXMLLoader.load(getClass().getResource("interfaceUser1.fxml"));
                 plus.getScene().setRoot(root);
 
            } catch (IOException ex) {System.out.println(ex.getMessage());
            }
    }
    }

    @FXML
    private void amis(MouseEvent event) throws IOException {
            Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("listAmis.fxml"));
                 plus.getScene().setRoot(root);

    }
}
