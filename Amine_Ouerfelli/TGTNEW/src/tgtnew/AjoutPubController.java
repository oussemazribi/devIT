/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tgtnew;

import Services.ServicePublication;
import entities.Publication;
import java.io.File;
import java.net.URL;
import java.sql.SQLException;
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
import static tgtnew.HomeController.iduser_1;

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
    @FXML
    private CheckBox publique;
    @FXML
    private CheckBox ami;
    /**********************************/
    ServicePublication serp=new ServicePublication();
    FileChooser fileChooser = new FileChooser();
    private Text actionStatus = new Text();
    String path="";
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

			showSingleFileChooser();
		}
	}
    private void showSingleFileChooser() {
	
		FileChooser fileChooser = new FileChooser();
		File selectedFile = fileChooser.showOpenDialog(null);
                fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("mp4 Files",".mp4"));
                

		if (selectedFile != null) {

			actionStatus.setText("File selected: " + selectedFile.getName());
                        path=selectedFile.toURI().toString();
                        m=new Media(selectedFile.toURI().toString());
                        mp=new MediaPlayer(m);
                        video.setMediaPlayer(mp);
		}
		else {
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
      if(path=="")
      {
          wwarn();
      }
      else
      {
      String description1 =description.getText();
      String type="video";
      int visib=1; 
      Publication p=new Publication(iduser_1,type,path,visib,description1);
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

    @FXML
    private void visib1(ActionEvent event)
    {
        
    }

    @FXML
    private void visib2(ActionEvent event) {
    }
    
}
