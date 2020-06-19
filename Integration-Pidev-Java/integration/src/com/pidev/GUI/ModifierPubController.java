/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.GUI;

import com.pidev.Entite.Medias;
import com.pidev.Service.ServicePublication;
import com.pidev.Entite.Publication;
import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import static com.pidev.GUI.Integration.Userconnected;
import static com.pidev.GUI.PublicationCell.pp;
import com.pidev.Service.ServiceMedia;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author asus
 */

/**
 * FXML Controller class
 *
 * @author asus
 */
public class ModifierPubController implements Initializable {

    @FXML
    private TextArea desc;
    @FXML
    private MediaView video;
    private Media m;
    private MediaPlayer mp;
    @FXML
    private Button choixfichier;
    @FXML
    private Button completer;
    @FXML
    private Button annuler;
    /**
     * ******************************
     */
    String nomfichier="";
    ServicePublication serpp = new ServicePublication();
    ServiceMedia serm = new ServiceMedia();
    Publication p = pp;
    FileChooser fileChooser = new FileChooser();
    private Text actionStatus = new Text();
    String path = "";
    int visibilite = 1;
    @FXML
    private ListView<Medias> mediacontainer;
    @FXML
    private TextField titre;

    /**
     * ******************************
     */

    /**
     * Initializes the controller class.
     */
    private class SingleFcButtonListener implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {

            try {
                showSingleFileChooser();
            } catch (IOException ex) {
               System.out.println(ex.getMessage());
            }
        }
    }

    private void showSingleFileChooser() throws FileNotFoundException, IOException {

        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("mp4 Files", "*.mp4"));

        if (selectedFile != null) {

            actionStatus.setText("File selected: " + selectedFile.getName());
            path = selectedFile.toURI().toString();
            m = new Media(selectedFile.toURI().toString());
            mp = new MediaPlayer(m);
            video.setMediaPlayer(mp);
            nomfichier=selectedFile.getName();
            InputStream is = null;
            OutputStream os = null;
                try {
                    is = new FileInputStream(new File(selectedFile.getAbsolutePath()));
//             
                    os = new FileOutputStream(new File("C:/wamp64/www/Fos/web/uploads/Mixed/" + selectedFile.getName()));
                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = is.read(buffer)) > 0) {
                        os.write(buffer, 0, length);
                    }

                } finally {
                    is.close();
                    os.close();

                }
        } else {
            actionStatus.setText("File selection cancelled.");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        choixfichier.setOnAction(new SingleFcButtonListener());
        annuler.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;-fx-background-radius: 10px;");
        choixfichier.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;-fx-background-radius: 10px;");
        completer.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;-fx-background-radius: 10px;");

    }

    @FXML
    private void modifier(ActionEvent event) throws SQLException {
        if (desc.getText() == "") {
            wwarn();
        }
        if (path == "") {
            wwarn();
        } else {
            p.setcontenu(desc.getText());
            p.settitre(titre.getText());
            Medias m = new Medias();
            m.setIdpub(p.getId());
            m.setIduser(Userconnected.getId());
            m.setSource(nomfichier);
            m.setMediatype("video");
            m.setType("post");
            serm.ajouter(m);
            serpp.modifier(p);
            Stage stage = (Stage) completer.getScene().getWindow();
            stage.close();
        }
    }

    private void wwarn() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ajout");
        alert.setHeaderText("Resultats");
        alert.setContentText("Champs Vide");
        alert.showAndWait();
    }

    @FXML
    private void annuler(ActionEvent event) {
        Stage stage = (Stage) annuler.getScene().getWindow();
        stage.close();
    }

}