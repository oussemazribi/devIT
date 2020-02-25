package Fxml;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.esprit.Entite.Conversation;
import com.esprit.Entite.Message;
import com.esprit.Service.ServiceConversation;
import com.esprit.Service.ServiceMessage;
import com.esprit.Utils.DataBase;
import java.sql.*;
import java.util.List;
import java.util.Map;

public class main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("test.fxml"));
        
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}