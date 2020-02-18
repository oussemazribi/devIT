/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tunisiangot;


import java.util.Random;



import org.controlsfx.control.GridCell;
import org.controlsfx.control.GridView;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.cell.ColorGridCell;
import org.controlsfx.samples.HelloNotificationPane;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
/**
 * FXML Controller class
 *
 * @author ousse
 */
public class NotificationController extends Application{

 Notifications notificationBuilder;
   Node graphic;
   private static final Image SMALL_GRAPHIC =  new Image(HelloNotificationPane.class.getResource("controlsfx-logo.png").toExternalForm());
	
   
	@Override
	public void start(Stage stage) throws Exception {
		
	    String text = "Hello Programmers";
		
		
		VBox root = new VBox(20);
		root.setPadding(new Insets(50,50,50,50));
		Scene scene = new Scene(root,400,400);
		
        
		
		Button btn1 = new Button("No Graphic");
		
		btn1.setOnAction(e ->{
			
			graphic = null;
			notification(Pos.TOP_LEFT,graphic,text);
			notificationBuilder.show();
			
		});
	
		
		Button btn2 = new Button("Warning Graphic");
		
		btn2.setOnAction(e -> {
			
			notification(Pos.BOTTOM_CENTER,graphic,text);
			notificationBuilder.showWarning();
			
		});
		
		
		Button btn3 = new Button("Information Graphic");
		
		btn3.setOnAction(e ->{
			
			notification(Pos.CENTER_RIGHT,graphic,text);
			notificationBuilder.showInformation();
			
			
		});
		
		
		
		Button btn4 = new Button("Confirm Graphic");
		
		btn4.setOnAction(e ->{
			
			notification(Pos.BOTTOM_RIGHT,graphic,text);
			notificationBuilder.showConfirm();
		});
		
		
		Button btn5 = new Button("Error Graphic");
		
		btn5.setOnAction(e -> {
			
			notification(Pos.TOP_CENTER, graphic, text);
			notificationBuilder.showError();
		});
		
		
		Button btn6 = new Button("Custom Graphic");
		
		btn6.setOnAction(e ->{
			
			graphic = new ImageView(SMALL_GRAPHIC);
			notification(Pos.TOP_RIGHT,graphic,text);
			notificationBuilder.show();
			
		});
		
		Button btn7 = new Button("Total-replcement Graphic");
		
		btn7.setOnAction(e ->{
			graphic = buildTotalReplacementGraphic();
			notification(Pos.BOTTOM_LEFT,graphic,text);
			notificationBuilder.show();
			
		});
		
		root.getChildren().addAll(new Label("Notifications In ControlsFX"),btn1,btn2,btn3,btn4,btn5,btn6,btn7);
		stage.setScene(scene);
		stage.show();
		
	}
	
	
	private Node buildTotalReplacementGraphic() {
        final ObservableList<Color> list = FXCollections.<Color>observableArrayList();

        GridView<Color> colorGrid = new GridView<>(list);
        colorGrid.setPrefSize(300, 300);
        colorGrid.setMaxSize(300, 300);

        colorGrid.setCellFactory(new Callback<GridView<Color>, GridCell<Color>>() {
            @Override public GridCell<Color> call(GridView<Color> arg0) {
                return new ColorGridCell();
            }
        });
        Random r = new Random(System.currentTimeMillis());
        for(int i = 0; i < 500; i++) {
            list.add(new Color(r.nextDouble(), r.nextDouble(), r.nextDouble(), 1.0));
        }
        return colorGrid;
    }
	
 
	private void notification(Pos pos,Node graphic,String Text)
	{
		
		notificationBuilder = Notifications.create()
				.title("Genius Coders ")
				.text(Text)
				.graphic(graphic)
				.hideAfter(Duration.seconds(40))
				.position(pos)
				.onAction(new EventHandler<ActionEvent>(){

					@Override
					public void handle(ActionEvent arg0) {
						System.out.println("Notifiation is Clicked");
					}
					
				});
				
		
		
	}
	


	public static void main(String args[])
	{
		launch(args);
	}

}
