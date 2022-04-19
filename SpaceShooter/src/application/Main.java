package application;
	
import java.time.Duration;

import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;


public class Main extends Application {
	
	Stage window;
	
	public static void main(String[] args) {
		launch(args);
		
	}
	
	@Override
	public void start(Stage primaryStage) {
		// creates the main window
		window = primaryStage;
		Scenes main = new Scenes(window);
		window.setScene(main.Main());
		window.show();
	}
}
