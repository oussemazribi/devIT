/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.GUI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.stage.FileChooser;
import com.pidev.Entite.Annonce;
import com.pidev.Entite.User;
import com.pidev.Service.ServiceAnnonce;

/**
 * FXML Controller class
 *
 * @author ousse
 */
public class AjoutAnnonceController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextArea description;
    @FXML
    private TextField prix;

    User u2 = new User(5, "montasser", "sellami", "aaaa", "montinho", "aaaa", "homme", "1996", 10101010, "Administrateur", "Dance", "null");
    @FXML
    private Button LoadImage;
    @FXML
    private Button cree;

    @FXML
    private Label label;

    @FXML
    private Button annuler;

    @FXML
    private TilePane tilePane;
    @FXML
    private String ImageComp;
    @FXML
    ImageView imageC;
    @FXML
    private AnchorPane myAnchor;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        
        
    }

    
    
    public void ChoiceImage() throws FileNotFoundException, IOException {
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
                os = new FileOutputStream(new File("C:/wamp64/www/Images_PI/" + f.getName()));
                byte[] buffer = new byte[1024];
                int length;
                while ((length = is.read(buffer)) > 0) {
                    os.write(buffer, 0, length);
                }

            } finally {
                is.close();
                os.close();

            }

            File file = new File("C:/wamp64/www/Images_PI/" + f.getName());
//            System.out.println(file.toURI().toString());
            imageC.setImage(new Image(file.toURI().toString()));
            ImageComp = f.getName();
            System.out.println(ImageComp);
        } else if (f == null) {
            //Commentaire.setText("Erreur chargement de l'image");
            System.out.println("Erreur !");
        }

    }

//    public VBox createPage(int index) {
//        
//        
//         File f = fc.showOpenDialog(null);
//
//        ImageView imageView = new ImageView();
//            File file = new File("C:/wamp64/www/PI_DEV_Image/" + f.getName());
//
//        
//        try {
//            BufferedImage bufferedImage = ImageIO.read(file);
//            imageC.setImage(new Image(file.toURI().toString()));
//            imageC.setFitWidth(ELEMENT_SIZE);
//            imageC.setFitHeight(ELEMENT_SIZE);
//           // imageView.setPreserveRatio(true);
//            
//            imageC.setSmooth(true);
//            imageC.setCache(true);
//        } catch (IOException ex) {
//            
//        }
//         
//        VBox pageBox = new VBox();
//        pageBox.getChildren().add(imageC);        
//        pageBox.setStyle("-fx-border-color: blue;");
//        
//        imageView = null;
//        return pageBox;
//    }  
//    
//    
//    private void createElements() {
//            tilePane.getChildren().clear();
//            
//            for (int i = 0; i < nCols; i++) {
//                for (int j = 0; j < nRows; j++) {
//                    tilePane.getChildren().add(createPage(count));
//                    count++;
//                            
//                }
//            }
//        }
    @FXML
    private void AjoutOnClick(ActionEvent event) throws SQLException, IOException {

        ServiceAnnonce sp = new ServiceAnnonce();

        String Nom = nom.getText();
        String Description = description.getText();
        int Prix =Integer.parseInt(prix.getText());

        Annonce a = new Annonce(u2, Nom, Description, Prix, "disponible", ImageComp);

        sp.ajouter(a);
        
        
         FXMLLoader LOADER = new FXMLLoader(getClass().getResource("AffichageAnnonce.fxml"));
        Parent root1 = LOADER.load();
        
        cree.getScene().setRoot(root1);
        

    }

    @FXML

    private void Annuler(ActionEvent event) throws IOException {
        FXMLLoader LOADER = new FXMLLoader(getClass().getResource("AffichageAnnonce.fxml"));
        Parent root1 = LOADER.load();
        annuler.getScene().setRoot(root1);
    }

}
