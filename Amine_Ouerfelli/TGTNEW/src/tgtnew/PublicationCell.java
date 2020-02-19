/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tgtnew;

import Services.ServiceCommentaire;
import Services.ServicePCVR;
import Services.ServicePublication;
import Services.ServiceReaction;
import Services.ServiceVote;
import entities.Commentaire;
import entities.Publication;
import entities.Reaction;
import entities.Vote;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import static tgtnew.HomeController.iduser_1;
import static tgtnew.HomeController.username;

/**
 *
 * @author asus
 */
class PublicationCell extends ListCell<Publication> {
Publication Pub;
static Publication pp=new Publication();
@FXML
private Label date;
@FXML
private Label nameuser;
@FXML
private Label desription;
@FXML
private ListView<Commentaire> listecommentaires;
@FXML
private TextField commentfield;
@FXML
private Button commenter;
@FXML
private Button modifier;
@FXML
private Button supprimer;
@FXML
private MediaView video;
private Media m;
private MediaPlayer mp;
@FXML
private ImageView imageuser;
@FXML
private CheckBox up;
@FXML
private CheckBox down;
@FXML
private CheckBox like;
@FXML
private CheckBox dislike;
@FXML
private Label nbvotes;
@FXML
private Label nbvotes2;
@FXML
private Label nbreacts;
@FXML
private AnchorPane pubbody;


/***************************/
    private FXMLLoader mLLoader;
    ServicePCVR serpc=new ServicePCVR();
    List<Commentaire> l1;
    CommentsFactory cf=new CommentsFactory();
    ServiceCommentaire serc= new ServiceCommentaire();
    ServiceVote serv=new ServiceVote();
    ServiceReaction serreac=new ServiceReaction();
    ServicePublication serp=new ServicePublication();

/**************************************/

@FXML
public void ajoutercomment() throws SQLException
{
        int idpub=this.getItem().getId();
        String contenue=commentfield.getText();
        int iduser=1;
       
        Commentaire c=new Commentaire(iduser,idpub,contenue);
        serc.ajouter(c);
        l1=serc.readAll();
        listecommentaires.getItems().clear();
        listecommentaires.getItems().addAll(l1);
        commentfield.setText("");
       

}
@FXML
public void supprimer() throws SQLException
{
        serp.supprimer(this.getItem());
        List pubs=serp.readAll();
        this.getListView().getItems().clear();
        this.getListView().getItems().addAll(pubs); 
        this.updateItem(this.Pub, true);
}
@FXML
public void modifier() throws IOException
{
     Parent root = FXMLLoader.load(getClass().getResource("ModifierPub.fxml"));
     Scene scene = new Scene(root);
     Stage stage=new Stage();
     stage.setScene(scene);
     stage.show();
     transferedata();
}
@FXML
public void upit() throws SQLException
{
       if(up.isSelected()&&!down.isSelected())
        {   
            int type=1;
            int idpub=this.getItem().getId();
            int iduser=1;
            Vote v=new Vote(iduser,idpub,type);
            serv.ajouter(v);
            
        }
         if(up.isSelected()&&down.isSelected())
        {   
            int type=1;
            int idpub=this.getItem().getId();
            int iduser=1;
            Vote v=new Vote(iduser,idpub,type);
            serv.modifier(v);
            down.setSelected(false);
            
        }
      up.selectedProperty().addListener(new ChangeListener<Boolean>() {
    @Override
    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
        try {
            supprimerup();
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
    }
});
}
@FXML
public void downit() throws SQLException
{
      if(down.isSelected()&&!up.isSelected())
        {   
            int type=2;
            int idpub=this.getItem().getId();
            int iduser=1;
            Vote v=new Vote(iduser,idpub,type);
            serv.ajouter(v);
            
        }
         if(down.isSelected()&&up.isSelected())
        {   
            int type=2;
            int idpub=this.getItem().getId();
            int iduser=1;
            Vote v=new Vote(iduser,idpub,type);
            serv.modifier(v);
            down.setSelected(false);
            
        }
             down.selectedProperty().addListener(new ChangeListener<Boolean>() {
    @Override
    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
        try {
            supprimerdown();
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
    }
});
}
@FXML
public void jaime() throws SQLException
{        if(like.isSelected()&&!dislike.isSelected())
        {   
            int type=1;
            int idpub=this.getItem().getId();
            int iduser=1;
            Reaction v=new Reaction(iduser,idpub,type);
            serreac.ajouter(v);
            
        }
         if(like.isSelected()&&dislike.isSelected())
        {   
            int type=1;
            int idpub=this.getItem().getId();
            int iduser=1;
            Reaction v=new Reaction(iduser,idpub,type);
            serreac.modifier(v);
            dislike.setSelected(false);
            
        }

       like.selectedProperty().addListener(new ChangeListener<Boolean>() {
    @Override
    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
        try {
            supprimerlike();
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
    }
});
  
  }

@FXML
public void dilikeit() throws SQLException
    {  

          if(dislike.isSelected()&&!like.isSelected())
        {   
            int type=2;
            int idpub=this.getItem().getId();
            int iduser=1;
            Reaction v=new Reaction(iduser,idpub,type);
            serreac.ajouter(v);
            
        }
         if(dislike.isSelected()&&like.isSelected())
        {   
            int type=2;
            int idpub=this.getItem().getId();
            int iduser=1;
            Reaction v=new Reaction(iduser,idpub,type);
            serreac.modifier(v);
            like.setSelected(false);
            
        }
         if(dislike.isSelected())
         { 
            if(dislike.isSelected()==false)
            {int type=2;
            int idpub=this.getItem().getId();
            int iduser=1;
            Reaction v=new Reaction(iduser,idpub,type);
            serreac.supprimer(v);
            
         }}
    dislike.selectedProperty().addListener(new ChangeListener<Boolean>() {
    @Override
    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
        try {
            supprimerdislike();
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
    }
});
         
    }


public PublicationCell()
    {
     
        loadFXML();
        


    }
private void loadFXML() 
    {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Publication.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
@Override
    protected void updateItem(Publication pub, boolean empty) {
        super.updateItem(pub, empty);

        if(empty || pub == null) {

            setText(null);
            setGraphic(null);

        } 
        else {
         setstyle();
         date.setText(pub.getdate().toString());
         desription.setText(pub.getdescription());
            String path=this.getItem().getcontenu();
          
            m=new Media(path);
            mp=new MediaPlayer(m);
            video.setMediaPlayer(mp);
       
            /****************************************/
                        try {
            l1 = serpc.commentofpost(this.getItem().getId());
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            listecommentaires.setCellFactory(cf);
            listecommentaires.getItems().addAll(l1);
            /*********************************************/
            
            
         if(this.getItem().getId_auteur()!=iduser_1)
         {
             modifier.setVisible(false);
             supprimer.setVisible(false);
         }
         else
         {
            modifier.setVisible(true);
            supprimer.setVisible(true);
         }
    InputStream im =getClass().getResourceAsStream("/image/download.png");
    Image imageuser1 = new Image(im);
    imageuser.setImage(imageuser1);
    nameuser.setText(username);
        }
        setGraphic(pubbody);
   }

    private void transferedata() {
      int id= this.getItem().getId();
      int id_u=this.getItem().getId_auteur();
      String c=this.getItem().getcontenu();
      String d= this.getItem().getdescription();
      String t=this.getItem().gettype();
      int v=this.getItem().getvisibilite();
      pp.setId(id);
      pp.setId_auteur(id_u);
      pp.setcontenu(c);
      pp.setdescription(d);
      pp.settype(t);
      pp.setvisibilite(v);
    }
    public void setstyle()
    {  like.setStyle(
    "-fx-border-color: lightblue; "
    + "-fx-font-size: 10;"
    + "-fx-border-insets: -5; "
    + "-fx-border-radius: 5;"
    + "-fx-border-style: dotted;"
    + "-fx-border-width: 2;"
);       
    dislike.setStyle(
    "-fx-border-color: lightblue; "
    + "-fx-font-size: 10;"
    + "-fx-border-insets: -5; "
    + "-fx-border-radius: 5;"
    + "-fx-border-style: dotted;"
    + "-fx-border-width: 2;"
);
    up.setStyle(
    "-fx-border-color: lightblue; "
    + "-fx-font-size: 10;"
    + "-fx-border-insets: -5; "
    + "-fx-border-radius: 5;"
    + "-fx-border-style: dotted;"
    + "-fx-border-width: 2;"
);
    down.setStyle(
    "-fx-border-color: lightblue; "
    + "-fx-font-size: 10;"
    + "-fx-border-insets: -5; "
    + "-fx-border-radius: 5;"
    + "-fx-border-style: dotted;"
    + "-fx-border-width: 2;"
);
    
    commentfield.setStyle(" -fx-font-size: 12pt;"
            
   + "-fx-font-family:Segoe UI Semibold;");
    commenter.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;-fx-background-radius: 10px;");
    modifier.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;-fx-background-radius: 10px;");
    supprimer.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;-fx-background-radius: 10px;");
    }
    public void supprimerdislike() throws SQLException
{
            int type=2;
            int idpub=this.getItem().getId();
            int iduser=1;
            Reaction v=new Reaction(iduser,idpub,type);
            serreac.supprimer(v);
}
public void supprimerlike() throws SQLException
{
            int type=1;
            int idpub=this.getItem().getId();
            int iduser=1;
            Reaction v=new Reaction(iduser,idpub,type);
            serreac.supprimer(v);
}
public void supprimerup() throws SQLException
{
            int type=1;
            int idpub=this.getItem().getId();
            int iduser=1;
            Vote v=new Vote(iduser,idpub,type);
            serv.supprimer(v);
}
public void supprimerdown() throws SQLException
{
            int type=2;
            int idpub=this.getItem().getId();
            int iduser=1;
            Vote v=new Vote(iduser,idpub,type);
            serv.supprimer(v);
}
}
