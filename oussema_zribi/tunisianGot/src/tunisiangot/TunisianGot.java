/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tunisiangot;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author ousse
 */
public class TunisianGot extends Application {
    
    Stage window;
    Scene scene1;
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        window=primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("AffichageAnnonce.fxml"));
        Scene scene = new Scene(root);


scene1=scene;

        window.setScene(scene);
        window.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
