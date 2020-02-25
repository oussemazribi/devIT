/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tgtnew;

import Services.ServicePCVR;
import Services.ServicePublication;
import entities.Commentaire;
import entities.Publication;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author asus
 */
public class HomeController implements Initializable {
    static int iduser_1=1;
    static String username="amine";
    
    @FXML
    private Button ajout;
    @FXML
    private ListView<Publication> listepublication;
    
   /**********************************/
    ServicePublication serp=new ServicePublication();
    ServicePCVR serPCVR= new ServicePCVR();
     List<Publication> l1;
     List<Commentaire> l2;
    PublicationCellFactory cp;
    @FXML
    private Button actualiser;
    @FXML
    private Button stat;
    public HomeController() {
        this.cp = new PublicationCellFactory();
        this.listepublication = new ListView<Publication>();
    }
     
     /*********************************/
    InputStream im =getClass().getResourceAsStream("/image/download.png");
    Image imageuser1 = new Image(im);
    @FXML
 
    ImageView imageuser ;
    
    
    /**
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           try {
            l1=serp.readAll();
           } catch (SQLException ex) {
            System.out.println(ex.getMessage());
           }
          listepublication.setCellFactory(cp);
          listepublication.getItems().addAll(l1);
           /*ajout.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;-fx-background-radius: 10px;"); 
           actualiser.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;-fx-background-radius: 10px;");*/
            InputStream input1 =getClass().getResourceAsStream("/image/ajouter-100-.png");
            InputStream input2 =getClass().getResourceAsStream("/image/actualiser-90-.png");
            
            
 
        Image image = new Image(input1);
        Image image1 = new Image(input2);
        
        ImageView imageView1 = new ImageView(image);
        ImageView imageView2 = new ImageView(image1);
        imageuser.setImage(imageuser1);
       /* ajout.setGraphic(imageView1);
        actualiser.setGraphic(imageView2);*/
    }     
   

    @FXML
    private void ajouter(ActionEvent event) throws IOException
    {
     Parent root = FXMLLoader.load(getClass().getResource("AjoutPub.fxml"));
     Scene scene = new Scene(root);
     Stage stage=new Stage();
     stage.setScene(scene);
     stage.show();
    }

    @FXML
    private void actualiser(ActionEvent event) {
            try {
            l1=serp.readAll();
           } catch (SQLException ex) {
            System.out.println(ex.getMessage());
           }
        listepublication.getItems().clear();
        listepublication.getItems().addAll(l1);
    }

    @FXML
    private void stat(ActionEvent event) throws IOException {
     Parent root = FXMLLoader.load(getClass().getResource("postsStatics.fxml"));
     Scene scene = new Scene(root);
     Stage stage=new Stage();
     stage.setScene(scene);
     stage.show();
    }

    @FXML
    private void main(MouseEvent event) {
    }

    @FXML
    private void chat1(MouseEvent event) {
    }
    
}
