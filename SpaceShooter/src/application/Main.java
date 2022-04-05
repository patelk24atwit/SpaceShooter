package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class Main extends Application {
	
	Stage window;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		// creates the main window
		window = primaryStage;
		Pane pane = new Pane();
		pane.setPrefSize(500, 600);
		
		Asteroid test = new Asteroid(100,100);
		pane.getChildren().add(test.getShape());
		
		test.rightTurn();
		test.leftTurn();
		test.move();
		
		Scene scene = new Scene (pane);
		window.setScene(scene);
		window.show();
	
		
//		Pane background = new Pane();
//		background.setPrefSize(800, 600);
//		background.setStyle("-fx-background-color: grey;");
//		Scene scene = new Scene(background);
	
	}
	
	
}
