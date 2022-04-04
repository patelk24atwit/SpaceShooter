package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Scenes {
	
	public Stage start;
	public Scene main;
	public String title;
	private int height = 800;
	private int width = 600;
	
	
	public Scenes(Stage window, String title) {
		
		this.start = window;
		this.title = title;
		
		//
		start.setTitle(title);
		start.setResizable(false);
	}
	//Opening Scene
	
	
	public Scene Main () {
		
		Button sta = new Button();
		Label Title = new Label();
		
		GridPane main = new GridPane();
		main.setPrefSize(height, width);
		main.setStyle("-fx-background-color: black;");
		
		
		Title.setText("SpaceShooters/Asteriods IDK...");
		Title.setAlignment(Pos.CENTER);
		Title.setStyle("-fx-font-size: 40px;"
				+ "-fx-border-color: white;" 
				+ "-fx-border-width: 3px;"
				+ "-fx-border-radius: 10px;"
				+ "-fx-text-fill: white;"
				);
		sta.setText("Start");
		
        
        
		main.getChildren().addAll(Title);
		Scene scene = new Scene(main);
		return scene;
		
	}
	
	//Game
	public Scene Start () {
		
		
		
		return null;
	}
	
	//Menu Scene
	public Scene Menu () {
		
		
		return null;
	}
	
	
	

}
