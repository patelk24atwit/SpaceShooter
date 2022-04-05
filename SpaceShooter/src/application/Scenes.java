package application;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Scenes {
	
	public Stage window;
	public Scene scene;
	private static int width = 800;
	private static int height = 600;
	
	
	public Scenes(Stage window) {
		
		this.window = window;
		
		//
		window.setTitle("Start");
		window.setResizable(false);
		
	}
	//Opening Scene
	
	
		public Scene Main () {
		
		Button sta = new Button();
		Label Title = new Label();
		
		Pane main = new Pane();
		main.setPrefSize(width, height);
		main.setStyle("-fx-background-color: black;");		
		
		Title.setText("SpaceShooters/Asteriods IDK...");
		Title.setStyle("-fx-font-size: 40px;"
				+ "-fx-border-color: white;" 
				+ "-fx-border-width: 3px;"
				+ "-fx-border-radius: 10px;"
				+ "-fx-text-fill: white;"
				);
		Title.setLayoutX(120);
		
		
		sta.setText("Start");
		sta.setOnAction(e -> {
		
			Scene newScene = Start();
			window.setScene(newScene);
			window.setTitle("Running");
			window.show();
		});
		
        
        
		main.getChildren().addAll(Title, sta);
		Scene scene = new Scene(main);
		
		return scene;
	}
	
	//Game
	public Scene Start () {
		
		Button bac = new Button();

		Pane main = new Pane();
		main.setPrefSize(width, height);
		main.setStyle("-fx-background-color: white;");
		
		bac.setText("Back");
		bac.setOnAction(e -> {
		
			Scene newScene = Main();
			window.setScene(newScene);
			window.setTitle("Start");
			window.show();
		});
		
		main.getChildren().addAll(bac);
		Scene scene = new Scene(main);
		return scene;
	}
	
	//Menu Scene
	public Scene Menu () {
		
		
		return null;
	}
	
	
	

}
