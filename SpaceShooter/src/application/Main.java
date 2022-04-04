package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
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
		Pane background = new Pane();
		background.setPrefSize(600, 500);
		background.setStyle("-fx-background-color: black;");
		Scene scene = new Scene(background);
		window.setScene(scene);
		window.setTitle("Asteroids Game");
		window.show();
	}
	
	
}
