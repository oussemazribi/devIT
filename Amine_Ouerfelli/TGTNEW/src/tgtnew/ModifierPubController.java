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
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import static tgtnew.HomeController.iduser_1;
import static tgtnew.PublicationCell.pp;

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
    private CheckBox publique;
    @FXML
    private CheckBox amis;
    @FXML
    private Button completer;
    @FXML
    private Button annuler;
    /*********************************/
    ServicePublication serpp=new ServicePublication();
    Publication p=pp;
    FileChooser fileChooser = new FileChooser();
    private Text actionStatus = new Text();
    String path="";
    int visibilite=1;
    /*********************************/

    /**
     * Initializes the controller class.
     */
           private class SingleFcButtonListener implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent e) {

			showSingleFileChooser();
		}
	}
    private void showSingleFileChooser() {
	
		FileChooser fileChooser = new FileChooser();
		File selectedFile = fileChooser.showOpenDialog(null);
                fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("mp4 Files", "*.mp4"));
                

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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        choixfichier.setOnAction(new SingleFcButtonListener());
        if(pp.getvisibilite()==1)
        publique.setSelected(true);
        else
        amis.setSelected(true);
        
        annuler.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;-fx-background-radius: 10px;");
        choixfichier.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;-fx-background-radius: 10px;");
        completer.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;-fx-background-radius: 10px;");
       
    }    

    @FXML
    private void setpublique(ActionEvent event)
    {
        if(publique.isSelected())
        visibilite=1;
    }

    @FXML
    private void setamis(ActionEvent event)
    {
        if(amis.isSelected())
        visibilite=2;
    }

    @FXML
    private void modifier(ActionEvent event) throws SQLException 
    { if(desc.getText()=="")
      {
       wwarn();
      }
      if(path=="")
      {
          wwarn();
      }
      else
      {
        p.setdescription(desc.getText());
        p.setcontenu(path);
        p.setvisibilite(visibilite);
        serpp.modifier(p);
        System.out.println(p.getdescription());
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
    private void annuler(ActionEvent event)
    {
    Stage stage = (Stage) annuler.getScene().getWindow();
    stage.close();
    }
    
}
