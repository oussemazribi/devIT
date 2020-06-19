/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.GUI;

import com.pidev.Entite.Medias;
import static com.pidev.GUI.Integration.Userconnected;
import com.pidev.Service.ServicePublication;
import com.pidev.Entite.Publication;
import com.pidev.Service.ServiceMedia;
import com.pidev.Service.ServicePCVR;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import static com.pidev.GUI.Integration.Userconnected;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class AjoutPubController implements Initializable {

    @FXML
    private TextField description;
    @FXML
    private MediaView video;
    private MediaPlayer mp;
    private Media m;
    @FXML
    private Button completer;
    @FXML
    private Button annuler;
    @FXML
    private Button choixfichier;
    /**********************************/
    ServicePublication serp=new ServicePublication();
    ServiceMedia serm=new ServiceMedia();
    FileChooser fileChooser = new FileChooser();
    private Text actionStatus = new Text();
    String path="";
    String nomfichier="";
    ArrayList<String> ass=new ArrayList<String>();
    ServicePCVR mam=new ServicePCVR(); 
    @FXML
    private TextField titre;
    /***********************************/
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
        choixfichier.setOnAction(new SingleFcButtonListener());
        annuler.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;-fx-background-radius: 10px;");
        choixfichier.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;-fx-background-radius: 10px;");
        completer.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;-fx-background-radius: 10px;");
    }   
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
            String ok=nomfichier;
            ass.add(ok);
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
      private void wwarn() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Ajout");
        alert.setHeaderText("Resultats");
        alert.setContentText("Champs Vide");
 
        alert.showAndWait();
    }
 

    @FXML
    private void ajouter(ActionEvent event) throws SQLException
    {
      
   
      if(description.getText()=="")
      {
       wwarn();
      }
      else
      {
      String contenue =description.getText();
     
      String type="Mixed";
      String title=titre.getText();
      for (String c :ass)
      {
          Medias m=new Medias();
          m.setSource(c);
          m.setMediatype("post");
          m.setIduser(Userconnected.getId());
          m.setMediatype("video");
          int idnewpos=mam.countkol();
          m.setIdpub(idnewpos);
          serm.ajouter(m);
      }
      Publication p=new Publication(Userconnected.getId(),type,contenue,title,0,0,0);
      serp.ajouter(p);
      Stage stage = (Stage) completer.getScene().getWindow();
      stage.close();
      }
    }

    @FXML
    private void fermer(ActionEvent event)
    {
    Stage stage = (Stage) annuler.getScene().getWindow();
  
    stage.close();
        
    }

    @FXML
    private void choisirfichier(ActionEvent event)
    {
    }

    
}