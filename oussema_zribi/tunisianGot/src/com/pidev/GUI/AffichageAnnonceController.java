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
import com.pidev.Service.ServiceAnnonce;
import com.pidev.Service.ServiceUser;

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

    /**
     *
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
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
                c.setFill(new ImagePattern(new Image(new FileInputStream("C:/wamp64/www/Images_PI/" + list.get(i).getImages()))));
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
            
            String Nom = a1.getNom();
            String Description = a1.getDescription();
            int Prix = a1.getPrix();
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
                 Detail.DetailAnnonce(Nom, Description, Prix, image, u);
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
        Parent root1 = LOADER.load();

        plus.getScene().setRoot(root1);

    }

    private void Annuler(ActionEvent event) throws IOException {
        FXMLLoader LOADER = new FXMLLoader(getClass().getResource("AffichageAnnonce.fxml"));
        Parent root1 = LOADER.load();
        annuler.getScene().setRoot(root1);
    }

//
//    @FXML
//    void Pub(ActionEvent event) throws IOException {
//
//        FXMLLoader LOADER = new FXMLLoader(getClass().getResource("Ajoutpublicite.fxml"));
//        Parent root2 = LOADER.load();
//        Pub.getScene().setRoot(root2);
//
//    }
//
//    public void btnSupprimerAction(ActionEvent event) throws IOException, SQLException {
//        ServiceAnnonce ser = new ServiceAnnonce();
//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//        
////        quitter = new ImageView(new Image(getClass().getResourceAsStream("/add.png")));
////        btnQuitter.setGraphic(quitter);
//
//        alert.setTitle("Suppression ");
//        alert.setContentText("Voulez-vous vraiment supprimer cette Competition ?");
//        Optional<ButtonType> result = alert.showAndWait();
//        if (result.get() == ButtonType.OK) {
//            ser.delete(tableAnnonce.getSelectionModel().getSelectedItem());
//            this.AfficherAnnonce();
//        } else {
//            this.AfficherAnnonce();
//
//        }
//    }
//    
//       public void btnModifierAction(ActionEvent event) {
//           
//           
//           
//           
//       } 
}
