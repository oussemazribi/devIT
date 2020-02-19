/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tunisiangot;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URL;
import java.sql.Blob;
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
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.management.Notification;
import tungottalent.Entite.Annonce;
import tungottalent.Entite.User;
import tungottalent.IService.IServiceAnnonce;
import tungottalent.Service.ServiceAnnonce;

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

    User u2 = new User(6, "montasser", "sellami", "aaaa", "montinho", "aaaa", "homme", "1996", 10101010, "Administrateur", "Dance", "null");


    @FXML
    private Label label;
    
    @FXML
    private Button annuler;
    
    @FXML 
    private TilePane tilePane;
    
    @FXML
    private AnchorPane myAnchor;
    Image img;
    int count = 0;
    
    private int nRows = 4;  //no of row for tile pane
    private int nCols = 2;  // no of column for tile pane
    
    private static final double ELEMENT_SIZE = 100;
    private static final double GAP = ELEMENT_SIZE / 10;
    
     File filesJpg[]; // file array to store read images info
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
        //load Images on button click and open directory chooser
        Stage parent = (Stage)myAnchor.getScene().getWindow();
        
       
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedDirectory = directoryChooser.showDialog(parent);
 
        if (selectedDirectory != null) {
            FilenameFilter filterJpg = new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.toLowerCase().endsWith(".jpg");
                   
                    
                }
            };
 
            filesJpg = selectedDirectory.listFiles(filterJpg);
            
        }   
        
        //now set image in tiles
        createElements();
        
                        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        tilePane.setPrefColumns(nCols);
        tilePane.setPrefRows(nRows);
    
        tilePane.setHgap(GAP);
        tilePane.setVgap(GAP); 
        
        
    }    
    

        
    public VBox createPage(int index) {
 
        ImageView imageView = new ImageView();
 
        File file = filesJpg[index];
        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            Image image = new Image(file.toURI().toString());
            imageView.setImage(image);
            imageView.setFitWidth(ELEMENT_SIZE);
            imageView.setFitHeight(ELEMENT_SIZE);
           // imageView.setPreserveRatio(true);
            
            imageView.setSmooth(true);
            imageView.setCache(true);
            img = image;
        } catch (IOException ex) {
            
        }
         
        VBox pageBox = new VBox();
        pageBox.getChildren().add(imageView);        
        pageBox.setStyle("-fx-border-color: blue;");
        
        imageView = null;
        return pageBox;
    }  
    
    
    private void createElements() {
            tilePane.getChildren().clear();
            
            for (int i = 0; i < nCols; i++) {
                for (int j = 0; j < nRows; j++) {
                    tilePane.getChildren().add(createPage(count));
                    count++;
                            
                }
            }
        }

    @FXML
    private void AjoutOnClick(ActionEvent event) throws SQLException {

        ServiceAnnonce sp = new ServiceAnnonce();

        String Nom = nom.getText();
        String Description = description.getText();
        double Prix = Double.parseDouble(prix.getText());
        Image imgagee =  img;

        Annonce a = new Annonce(u2, Nom, Description, Prix, "disponible",imgagee);

        sp.ajouter(a);

    }

    @FXML
    
    private void Annuler(ActionEvent event) throws IOException{
        FXMLLoader LOADER = new FXMLLoader(getClass().getResource("AffichageAnnonce.fxml"));
        Parent root1 = LOADER.load();
        annuler.getScene().setRoot(root1);
    }
    
    
}
