/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tunisiangot;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import tungottalent.Entite.Annonce;
import tungottalent.Service.ServiceAnnonce;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
        ServiceAnnonce ser = new ServiceAnnonce();

    @FXML
    void AfficherAnnonce() throws SQLException {

        ObservableList<Annonce> list = FXCollections.observableArrayList(ser.readAll());
        System.out.println(list);
        ColumnDescription.setCellValueFactory(new PropertyValueFactory<Annonce, String>("Description"));
        ColumnNom.setCellValueFactory(new PropertyValueFactory<Annonce, String>("Nom"));
        ColumnProduit.setCellValueFactory(new PropertyValueFactory<Annonce, String>("user"));
        ColumnPrix.setCellValueFactory(new PropertyValueFactory<Annonce, String>("Prix"));
        tableAnnonce.setItems(list);

    }
     public void btnRefresh() throws SQLException
     {
            AfficherAnnonce();

         
     }
    @FXML
    void ajout(ActionEvent event) throws IOException {

        FXMLLoader LOADER = new FXMLLoader(getClass().getResource("AjoutAnnonce.fxml"));
        Parent root1 = LOADER.load();
        plus.getScene().setRoot(root1);

    }
    

}
