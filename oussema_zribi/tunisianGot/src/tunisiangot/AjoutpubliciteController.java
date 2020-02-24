/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tunisiangot;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import tungottalent.Entite.Annonce;
import tungottalent.Entite.Publicite;
import tungottalent.Entite.User;
import tungottalent.Service.ServiceAnnonce;
import tungottalent.Service.ServicePublicite;

/**
 * FXML Controller class
 *
 * @author ousse
 */
public class AjoutpubliciteController implements Initializable {
        @FXML
    private TableColumn<Publicite, String> ColumnAnnonce;
    @FXML
    private TableColumn<Publicite, String> ColumnDateDebut;
    @FXML
    private TableColumn<Publicite, String> ColumnDateFin;
    @FXML
    private TableColumn<Publicite, String> ColumnPack;
        @FXML
    private TableColumn<Publicite, String> ColumnPrix;
    @FXML
    private TableView<Publicite> tablePublicite;
    
        @FXML
    private ComboBox<String> packs;
    private DatePicker DateDebut;
    private DatePicker DateFin;
    
    
    ObservableList<String> list = FXCollections.observableArrayList("3Mois", "6Mois", "1Ans");
    User u2 = new User(6, "montasser", "sellami", "aaaa", "montinho", "aaaa", "homme", "1996", 10101010, "Administrateur", "Dance", "null");
   Annonce a1 = new Annonce(17, u2, "Guitarre", "Desctiption", 654, "Vendu");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

          packs.setItems(list);
                  try {
            AfficherPublicite();
        } catch (SQLException ex) {
            Logger.getLogger(AffichageAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // TODO
    }    
        ServicePublicite ser = new ServicePublicite();

       void AfficherPublicite() throws SQLException {
       

        ObservableList<Publicite> list = FXCollections.observableArrayList(ser.readAll());
        // System.out.println(list);
        ColumnAnnonce.setCellValueFactory(new PropertyValueFactory<Publicite, String>("Annonce"));
        ColumnDateDebut.setCellValueFactory(new PropertyValueFactory<Publicite, String>("Nom"));
        ColumnDateFin.setCellValueFactory(new PropertyValueFactory<Publicite, String>("user"));
        ColumnPack.setCellValueFactory(new PropertyValueFactory<Publicite, String>("Pack"));
        ColumnPrix.setCellValueFactory(new PropertyValueFactory<Publicite, String>("Prix"));
        tablePublicite.setItems(list);

    }
        @FXML
        private void AjoutPublicite(ActionEvent event) throws SQLException {

        ServicePublicite sp = new ServicePublicite();

        LocalDate DateDebut = this.DateDebut.getValue();
        LocalDate Datefin = this.DateFin.getValue();
        String Pack = packs.getValue();


            Publicite p = new Publicite(a1, u2, DateDebut, Datefin, "Publiée", Pack);
        sp.ajouter(p);

    }
    
}
