/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.GUI;

import com.pidev.Service.ServiceAnnonce;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.SQLException;
import static java.util.Collections.list;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author ousse
 */
public class ModifierAnnonceController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextArea description;
    @FXML
    private TextField prix;
    @FXML
    private Button LoadImage;
    @FXML
    private Button valider;
    @FXML
    private Button fermer;
    @FXML
    private ComboBox<String> etatt;

    private String ImageComp;
    private int iddd;
    @FXML
    ImageView imageC;

        ObservableList<String> listt = FXCollections.observableArrayList("disponible", "vendu");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
               etatt.setItems(listt);
               etatt.getSelectionModel().select("disponible");
               //System.out.println(listt);

        // TODO
    }
    void ModifierAnnonce1(int idd, String Nom, String Description, int Prix,String Etat, String image) throws IOException {
        iddd=idd;
        nom.setText(Nom);
        description.setText(Description);
        prix.setText(Integer.toString(Prix));
        File file = new File("C:/xampp/htdocs/Image_Pi/" + image);
        imageC.setImage(new Image(file.toURI().toString()));

    }

    @FXML
    private void fermer(ActionEvent event) throws IOException {

//          fermer.setOnAction(actionEvent -> Platform.exit()); 
        Window window = nom.getScene().getWindow();

        if (window instanceof Stage) {
            ((Stage) window).close();
        }

    }

    @FXML
    private void ChoiceImage() throws FileNotFoundException, IOException {
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
                os = new FileOutputStream(new File("C:/xampp/htdocs/Image_Pi/" + f.getName()));
                byte[] buffer = new byte[1024];
                int length;
                while ((length = is.read(buffer)) > 0) {
                    os.write(buffer, 0, length);
                }

            } finally {
                is.close();
                os.close();

            }

            File file = new File("C:/xampp/htdocs/Image_Pi/" + f.getName());
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
    private void ModifierAnnonce(ActionEvent event) throws IOException, SQLException {
        
                ServiceAnnonce sp = new ServiceAnnonce();

        
        String Nom = nom.getText();
        String Description = description.getText();
        int Prix = Integer.parseInt(prix.getText());
        String Etattt = etatt.getValue();
        String img = ImageComp;
       // sp.update(Nom, Description, Prix, img,Etattt , iddd);
        // ModifierAnnonce1();
        Window window = nom.getScene().getWindow();

        if (window instanceof Stage) {
            ((Stage) window).close();
        }
    }

}
