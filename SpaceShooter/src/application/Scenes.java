package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Paths;


import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Scenes {
	
	public Stage window;
	public Scene scene;
	private static int width = 800;
	private static int height = 600;
	public boolean play = false;
	public ImageView view = new ImageView("game.jpg"); 
	public ImageView view2 = new ImageView("game2.jpg");

	

	public Scenes(Stage window) {
		
		this.window = window;
		
		//
		window.setTitle("Start");
		window.setResizable(false);
		
	}
	
	//Opening Scene
		public Scene Main () {
		
			Button sta = new Button();
			Button gea = new Button();
			
			Pane main = new Pane();
			main.setPrefSize(width, height);
			Image image = new Image("gear.png", 24, 24, true, true);
			ImageView geaUrl = new ImageView(image);
			
			//Start gear button
		    gea.setContentDisplay(ContentDisplay.TOP);
			gea.setStyle("-fx-background-radius: 10px;"
					+ "-fx-background-color: white;");
			gea.setPrefHeight(50);
			gea.setPrefWidth(50);
			gea.setLayoutX(460);
			gea.setLayoutY(300);
			gea.setGraphic(geaUrl);
			
			gea.setOnAction(e -> {
				
				Scene MenuScene = Menu();
				window.setScene(MenuScene);
				window.setTitle("Settings");
				window.show();
			});
			
			
			//Start Button
			sta.setText("Start");
			sta.setStyle("-fx-background-color: white;"
					+ "-fx-font: 20px Lucida-Fax;"
					+ "-fx-background-radius: 10px;");
			sta.setPrefHeight(50);
			sta.setPrefWidth(100);
			sta.setLayoutX(350);
			sta.setLayoutY(300);
			sta.setOnAction(e -> {
			
				Scene StartScene = Start();
				window.setScene(StartScene);
				window.setTitle("Running");
				window.show();
			});
		
        
		main.getChildren().addAll(view, sta, gea);
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
		
		Pane main = new Pane();
		main.setPrefSize(width, height);
		main.setStyle("-fx-background-color: white;");
		Button pla = new Button();
		Button bac = new Button();
		Button skin1 = new Button();
		Button skin2 = new Button();
		Button skin3 = new Button();
		
		//Play/Pause
		pla.setOnAction(e -> {
			
			play = true;
			playMusic("starwars.mp3");
			
		});
		
		//Back button
		bac.setText("Back");
		bac.setLayoutX(690);
		bac.setLayoutY(540);
		bac.setPrefHeight(50);
		bac.setPrefWidth(100);
		bac.setStyle("-fx-background-color: white;"
				+ "-fx-font: 15px Lucida-Fax;"
				+ "-fx-background-radius: 5px;");
		
		bac.setOnAction(e -> {
			
			Scene newScene = Main();
			window.setScene(newScene);
			window.setTitle("Start");
			window.show();
			//This 
			//e
			
		});
		//skin1
		skin1.setPrefHeight(100);
		skin1.setPrefWidth(200);
//		skin1.setLayoutX();
//		skin1.setLayoutY();
		
		//skin2
		skin2.setPrefHeight(100);
		skin2.setPrefWidth(200);
//		skin2.setLayoutX();
//		skin2.setLayoutY();
//		
		//skin3
		skin3.setPrefHeight(100);
		skin3.setPrefWidth(200);
//		skin3.setLayoutX();
//		skin3.setLayoutY();
//		
		
		
		
		
		
		main.getChildren().addAll(view2, pla, bac, skin1);
		Scene scene = new Scene(main);
		return scene;
	}
	
	public void playMusic (String s) {
		
						
			Media h = new Media(Paths.get(s).toUri().toString());
			MediaPlayer mediaPlayer = new MediaPlayer(h);
			mediaPlayer.play();
			
		
	}

}


