/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tunisiangot;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import tungottalent.Entite.Annonce;
import tungottalent.Service.ServiceAnnonce;
import tungottalent.Service.ServiceUser;

/**
 * FXML Controller class
 *
 * @author ousse
 */
public class AffichageAnnonceController implements Initializable {

    @FXML
    private TableColumn<Annonce, String> ColumnDescription;
    @FXML
    private TableColumn<Annonce, String> ColumnNom;
    @FXML
    private TableColumn<Annonce, String> ColumnPrix;
    @FXML
    private TableColumn<Annonce, String> ColumnProduit;
    @FXML
    private TableView<Annonce> tableAnnonce;

    @FXML
    private Button plus;
    @FXML
    private Button Pub;
    
    private Button btnQuitter;
    
    ImageView quitter;
    /**
     * 
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            AfficherAnnonce();
        } catch (SQLException ex) {
            Logger.getLogger(AffichageAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    ServiceAnnonce ser = new ServiceAnnonce();
    ServiceUser ser1 = new ServiceUser();

    @FXML
    void AfficherAnnonce() throws SQLException {
        tableAnnonce.setEditable(true);

        ObservableList<Annonce> list = FXCollections.observableArrayList(ser.readAll());
        // System.out.println(list);
        ColumnDescription.setCellValueFactory(new PropertyValueFactory<Annonce, String>("Description"));
        ColumnNom.setCellValueFactory(new PropertyValueFactory<Annonce, String>("Nom"));
        ColumnProduit.setCellValueFactory(new PropertyValueFactory<Annonce, String>("user"));
        ColumnPrix.setCellValueFactory(new PropertyValueFactory<Annonce, String>("Prix"));
        tableAnnonce.setItems(list);

    }

    @FXML
    void ajout(ActionEvent event) throws IOException {

        FXMLLoader LOADER = new FXMLLoader(getClass().getResource("AjoutAnnonce.fxml"));
        Parent root1 = LOADER.load();
        plus.getScene().setRoot(root1);

    }

    @FXML
    void Pub(ActionEvent event) throws IOException {

        FXMLLoader LOADER = new FXMLLoader(getClass().getResource("Ajoutpublicite.fxml"));
        Parent root2 = LOADER.load();
        Pub.getScene().setRoot(root2);

    }

    public void btnSupprimerAction(ActionEvent event) throws IOException, SQLException {
        ServiceAnnonce ser = new ServiceAnnonce();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        
//        quitter = new ImageView(new Image(getClass().getResourceAsStream("/add.png")));
//        btnQuitter.setGraphic(quitter);

        alert.setTitle("Suppression ");
        alert.setContentText("Voulez-vous vraiment supprimer cette Competition ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            ser.delete(tableAnnonce.getSelectionModel().getSelectedItem());
            this.AfficherAnnonce();
        } else {
            this.AfficherAnnonce();

        }
    }
    
       public void btnModifierAction(ActionEvent event) {
           
           
           
           
       } 
    

}
