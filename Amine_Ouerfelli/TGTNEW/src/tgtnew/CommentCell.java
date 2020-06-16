/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tgtnew;

import Services.ServiceCommentaire;
import entities.Commentaire;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import static tgtnew.HomeController.iduser_1;

/**
 *
 * @author asus
 */
public class CommentCell extends ListCell<Commentaire>{
    @FXML
    private Label username;
    @FXML
    private Label commentbody;
    @FXML
    private Label date;
    @FXML
    private Button delete;
    @FXML
    private Button update;
    @FXML
    private ImageView userimage;
    @FXML
    private AnchorPane combody;
    /************************************************/
    String username1="amine";
    private FXMLLoader Loader;
    private final TextField tf=new TextField();
    private final Button bt=new Button();
    ServiceCommentaire serc= new ServiceCommentaire();
    /************************************************/
    @FXML
    public void modifier()
    {
        tf.setLayoutY(61.0);
        tf.setPrefHeight(50.5);
        tf.setPrefWidth(595.0);
        combody.getChildren().remove(commentbody);
        combody.getChildren().add(tf);
        combody.getChildren().remove(update);
        combody.getChildren().remove(delete);
        bt.setLayoutX(374.0);
        bt.setLayoutY(60.0);
        bt.setText("Completer!");
        boolean add = combody.getChildren().add(bt);
    }
    @FXML
    public void supprimer() throws SQLException
    {
        serc.supprimer(this.getItem());
        this.getListView().getItems().remove(this.getItem());
 
       
        
        
        
        
    }
    
       public void modifier1() throws SQLException
    {   
        this.getItem().setcontenu(tf.getText());
         Commentaire c= this.getItem();
         if(serc.modifier(this.getItem()))
         {  
        
        combody.getChildren().remove(bt);
        combody.getChildren().remove(tf);
        combody.getChildren().add(commentbody);
        combody.getChildren().add(update);
        combody.getChildren().add(delete);
        List l1=serc.showcommentsbypub(c.getidpublication());
        this.getListView().getItems().clear();
        this.getListView().getItems().addAll(l1);
        
        
         }
             
    }
         EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent e)
            {
                try {
                    modifier1();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }; 
    
    
    private void loadFXML() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("commentaire.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    CommentCell() {
        loadFXML();
    }


    @Override
        protected void updateItem(Commentaire com, boolean empty) {
                super.updateItem(com, empty);

        if(empty || com== null) {

            setText(null);
            setGraphic(null);

        } else {
         
            date.setText(com.getdate().toString());
            commentbody.setText(com.getcontenu());
         if(this.getItem().getiduser()!=iduser_1)
         {
             update.setVisible(false);
             delete.setVisible(false);
         }
         else
         {
            update.setVisible(true);
            delete.setVisible(true);
         }
            bt.setOnAction(event);
                        InputStream input1 =getClass().getResourceAsStream("/image/supprimer.png");
            InputStream input2 =getClass().getResourceAsStream("/image/modifier.png");
 
        Image image = new Image(input1);
        Image image1 = new Image(input2);
        
        ImageView imageView1 = new ImageView(image);
        ImageView imageView2 = new ImageView(image1);
        delete.setGraphic(imageView1);
        update.setGraphic(imageView2) ;
         InputStream im =getClass().getResourceAsStream("/image/download.png");
          Image imageuser1 = new Image(im);
        userimage.setImage(imageuser1);
        username.setText(username1);
        
            setGraphic(combody);
        }
        
    }
}
