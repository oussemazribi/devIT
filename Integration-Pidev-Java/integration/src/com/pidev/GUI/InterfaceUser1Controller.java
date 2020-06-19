/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.GUI;

import com.pidev.Service.ServiceReclamation;
import com.pidev.Entite.Reclamation;
import static com.pidev.GUI.Integration.Userconnected;
import com.pidev.Service.ServiceUser;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author BENTEKFA
 */
public class InterfaceUser1Controller implements Initializable {


static int iduser=26;
    @FXML
    private Button vi;
    @FXML
    private Button dh;
    @FXML
    private Button nudite;
    @FXML

    private Button violence;
    @FXML
    private Button ci;
    @FXML
    private Button hercelement;
    @FXML

    private Button souau;
    @FXML

    private Button fausse;
    @FXML
    private Button terro;
    @FXML

    private Button achose;
    @FXML
    private Button send;

    /**
     * Initializes the controller class.
     */
    /*****************************************************/
    String objet="";
    ServiceReclamation serrec= new ServiceReclamation();
    FileChooser fileChooser = new FileChooser();
    String Description="";
   
   private Text actionStatus = new Text();
    String path="";
    String gg="";
   SingleFcButtonListener  SingleFcButtonListener=new SingleFcButtonListener();

   
    @FXML
    private Button annuler;
    @FXML
    private Button choix;
    @FXML
    private ImageView capture;
    @FXML
    private TextField texte1;
    @FXML
    private ImageView UserImage;
    @FXML
    private Label UserName;
     ServiceUser su = new ServiceUser();
    /****************************************************/

    /**
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    try {
        // TODO
        String im = su.findbyImage(Userconnected.getIdUser());
        File file = new File("C:/xampp/htdocs/Image_Pi/" + im);
        UserImage.setImage(new Image(file.toURI().toString()));
        String alo = su.findByIdname(Userconnected.getIdUser());
        String friendlastname = su.findByIlastname(Userconnected.getIdUser());
        UserName.setText(alo+" "+friendlastname);
        
        send.setVisible(false);
        choix.setOnAction(SingleFcButtonListener);
    } catch (SQLException ex) {
        Logger.getLogger(InterfaceUser1Controller.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }    
       public String removeWord(String string, String word) 
    {   if (string.contains(word)) 
        { 
            String tempWord = word + " "; 
            string = string.replaceAll(tempWord, ""); 
            tempWord = " " + word; 
            string = string.replaceAll(tempWord, ""); 
        } 
 
        return string; 
    } 

    @FXML
    private void acceuil(MouseEvent event) {
                                FXMLLoader LOADER = new FXMLLoader(getClass().getResource("Home_1.fxml"));
        try {
            Parent root = LOADER.load();
            Scene rana = new Scene(root);
            HomeController_1 hamza = LOADER.getController();
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(rana);
            window.show();
        } catch (IOException ex) {

        }
        
    }

    @FXML
    private void chat1(MouseEvent event) {
            FXMLLoader LOADER = new FXMLLoader(getClass().getResource("Conversations.fxml"));
                try {
                    Parent root = LOADER.load();
                    Scene rana = new Scene(root);
                      ConversationsController hamza = LOADER.getController();
                    Stage window =(Stage)((Node) event.getSource()).getScene().getWindow() ;
              
                    window.setScene(rana);
                    window.show();
                } catch (IOException ex) {
                  
                }
    }

    @FXML
    private void competition(MouseEvent event) {
                    if ("Chasseur du talent".equals(Userconnected.getTypeCompte()))
       {
           FXMLLoader LOADER = new FXMLLoader(getClass().getResource("IntChasseur.fxml"));
                try {
                    Parent root = LOADER.load();
                    Scene rana = new Scene(root);
                      IntChasseurController hamza = LOADER.getController();
                    Stage window =(Stage)((Node) event.getSource()).getScene().getWindow() ;
              
                    window.setScene(rana);
                    window.show();
                } catch (IOException ex) {
                  
    }}
       if ("Utilisateur simple".equals(Userconnected.getTypeCompte()))
       {
      try {
                Parent root = FXMLLoader.load(getClass().getResource("UserInterface.fxml"));
                annuler.getScene().setRoot(root);
            } catch (IOException ex) {System.out.println(ex.getMessage());
            }
    }}

    @FXML
    private void annonce(MouseEvent event) {
              FXMLLoader LOADER = new FXMLLoader(getClass().getResource("AffichageAnnonce.fxml"));
                try {
                    Parent root = LOADER.load();
                    Scene rana = new Scene(root);
                      AffichageAnnonceController hamza = LOADER.getController();
                    Stage window =(Stage)((Node) event.getSource()).getScene().getWindow() ;
              
                    window.setScene(rana);
                    window.show();
                } catch (IOException ex) {
                  
                }
    }

    @FXML
    private void reclamation(MouseEvent event) {
           if ("Administrateur".equals(Userconnected.getTypeCompte()))
        { 
            try {
                Parent root = FXMLLoader.load(getClass().getResource("interfaceadmin.fxml"));
                                annuler.getScene().setRoot(root);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
       if ("Utilisateur simple".equals(Userconnected.getTypeCompte()))
       {
      try {
                Parent root = FXMLLoader.load(getClass().getResource("interfaceUser1.fxml"));
                                annuler.getScene().setRoot(root);
 
            } catch (IOException ex) {System.out.println(ex.getMessage());
            }
    }
                if ("Chasseur du talent".equals(Userconnected.getTypeCompte()))
       {
      try {
                Parent root = FXMLLoader.load(getClass().getResource("interfaceUser1.fxml"));
                                annuler.getScene().setRoot(root);

            } catch (IOException ex) {System.out.println(ex.getMessage());
            }
    }
    }

    @FXML
    private void amis(MouseEvent event) throws IOException {
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("listAmis.fxml"));
                                annuler.getScene().setRoot(root);

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
    private void showSingleFileChooser() throws IOException {
	
		FileChooser fileChooser = new FileChooser();
		File selectedFile = fileChooser.showSaveDialog(null);
                fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPG Files",".jpg"));
                

		if (selectedFile != null) {

			actionStatus.setText("File selected: " + selectedFile.getName());
                        path=selectedFile.toURI().toString();
                        System.out.println(path);
                        gg=removeWord(path,"file:/");
                         
                        Image capt=new Image(gg);
                        capture.setImage(capt);
                         
                       
                       
                        
		}
		else {
			actionStatus.setText("File selection cancelled.");
		}
	}
    @FXML
    private void choix7(ActionEvent event) {
        objet="Ventes interdites";
        send.setVisible(true);
        nudite.setVisible(false);
        violence.setVisible(false);
        hercelement.setVisible(false);
        souau.setVisible(false);
        fausse.setVisible(false);
        ci.setVisible(false);
        dh.setVisible(false);
        terro.setVisible(false);
        achose.setVisible(false);
    }

    @FXML

    private void choix9(ActionEvent event) {
        objet="Discours haineux";
        send.setVisible(true);
        vi.setVisible(false);
        nudite.setVisible(false);
        violence.setVisible(false);
        hercelement.setVisible(false);
        souau.setVisible(false);
        fausse.setVisible(false);
        ci.setVisible(false);
        terro.setVisible(false);
        achose.setVisible(false);
    }

    @FXML
    private void choisir1(ActionEvent event) {
        objet="Nudité";
        send.setVisible(true);
        vi.setVisible(false);
        violence.setVisible(false);
        hercelement.setVisible(false);
        souau.setVisible(false);
        fausse.setVisible(false);
        ci.setVisible(false);
        dh.setVisible(false);
        terro.setVisible(false);
        achose.setVisible(false);
        
    }

    @FXML

    private void choisir2(ActionEvent event) {
        objet="Violence";
        send.setVisible(true);
        vi.setVisible(false);
        nudite.setVisible(false);
        hercelement.setVisible(false);
        souau.setVisible(false);
        fausse.setVisible(false);
        ci.setVisible(false);
        dh.setVisible(false);
        terro.setVisible(false);
        achose.setVisible(false);
        
    }

    @FXML

    private void choix6(ActionEvent event) {
        objet="Contenu indésirable";
        send.setVisible(true);
        vi.setVisible(false);
        nudite.setVisible(false);
        violence.setVisible(false);
        hercelement.setVisible(false);
        souau.setVisible(false);
        fausse.setVisible(false);
        dh.setVisible(false);
        terro.setVisible(false);
        achose.setVisible(false);
    }

    @FXML

    private void choix3(ActionEvent event) {
        objet="Harcélement";
        send.setVisible(true);
        vi.setVisible(false);
        nudite.setVisible(false);
        violence.setVisible(false);
        souau.setVisible(false);
        fausse.setVisible(false);
        ci.setVisible(false);
        dh.setVisible(false);
        terro.setVisible(false);
        achose.setVisible(false);
    }

    @FXML

    private void choix4(ActionEvent event) {
        objet="Suicide ou automutilation";
        send.setVisible(true);
        vi.setVisible(false);
        nudite.setVisible(false);
        violence.setVisible(false);
        hercelement.setVisible(false);
        fausse.setVisible(false);
        ci.setVisible(false);
        dh.setVisible(false);
        terro.setVisible(false);
        achose.setVisible(false);
    }

    @FXML

    private void choix5(ActionEvent event) {
        objet="Fausse information";
        send.setVisible(true);
        vi.setVisible(false);
        nudite.setVisible(false);
        violence.setVisible(false);
        hercelement.setVisible(false);
        souau.setVisible(false);
        ci.setVisible(false);
        dh.setVisible(false);
        terro.setVisible(false);
        achose.setVisible(false);
    }

    @FXML

    private void choix10(ActionEvent event) {
        objet="Terrorisme";
        send.setVisible(true);
        vi.setVisible(false);
        nudite.setVisible(false);
        violence.setVisible(false);
        hercelement.setVisible(false);
        souau.setVisible(false);
        fausse.setVisible(false);
        ci.setVisible(false);
        dh.setVisible(false);
        achose.setVisible(false);
    }

    @FXML

    private void choix11(ActionEvent event) {
        objet="Autre chose";
        send.setVisible(true);
        vi.setVisible(false);
        nudite.setVisible(false);
        violence.setVisible(false);
        hercelement.setVisible(false);
        souau.setVisible(false);
        fausse.setVisible(false);
        ci.setVisible(false);
        dh.setVisible(false);
        terro.setVisible(false);
    }

    @FXML
    private void envoyer(ActionEvent event) throws SQLException {
       
        Description=texte1.getText();
        System.out.println(Description);
        String etat="Non traité";       
        Reclamation r=new Reclamation(iduser,objet,Description,gg,etat);
        System.out.println(r.toString());
        serrec.ajouter(r);
    }
    @FXML
    private void annuler(ActionEvent event)
    {   objet="";
        send.setVisible(true);
        vi.setVisible(true);
        nudite.setVisible(true);
        violence.setVisible(true);
        hercelement.setVisible(true);
        souau.setVisible(true);
        fausse.setVisible(true);
        ci.setVisible(true);
        dh.setVisible(true);
        terro.setVisible(true);
        
    }

}
