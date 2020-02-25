package com.pidev.GUI;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.pidev.Entite.Conversation;
import com.pidev.Entite.Message;
import com.pidev.Service.ServiceConversation;
import com.pidev.Service.ServiceMessage;
import com.pidev.Utils.DataBase;
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