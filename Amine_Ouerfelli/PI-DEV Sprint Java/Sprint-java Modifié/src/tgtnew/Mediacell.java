/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tgtnew;

import Services.ServiceMedia;
import entities.Medias;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.media.MediaView;

/**
 *
 * @author asus
 */
public class Mediacell extends ListCell<Medias>{
        @FXML
    private MediaView media;
        @FXML
    private ImageView imageuser;
    @FXML
    private Button deletemedia;
    @FXML
    private Button update;
    private FXMLLoader Loader;
    @FXML
     private MediaView video;
private Media m;
private MediaPlayer mp;
/***************************/
ServiceMedia serm=new ServiceMedia();

    @FXML
    private void Delete(ActionEvent event) throws SQLException {
        serm.supprimer(this.getItem());
        this.getListView().getItems().remove(this.getItem());
    }

    @FXML
    private void updatemedia(ActionEvent event) {
    }
        private void loadFXML() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("media.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
        
    Mediacell() {
        loadFXML();
    }
        @Override
        protected void updateItem(Medias com, boolean empty) {
        super.updateItem(com, empty);

        if(empty || com== null) {

            String path=com.getSource();          
            m=new Media("C:/wamp64/www/Fos/web/uploads/Mixed"+path);
            if(com.getMediatype()=="video")
            { mp=new MediaPlayer(m);
               video.setMediaPlayer(mp);
              this.setOnMousePressed(new EventHandler<MouseEvent>() {
             @Override
             public void handle(MouseEvent event) {
                 
               if(mp.getStatus().equals(Status.PLAYING))
                mp.pause();
             
             else
                 mp.play();
             }});
        }
            else
            {
    InputStream im =getClass().getResourceAsStream("C:/wamp64/www/Fos/web/uploads/Mixed/"+path);
    Image imageuser1 = new Image(im);
    imageuser.setImage(imageuser1);
     }
          
    }
}

}
