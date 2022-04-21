package application;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream; 
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.TargetDataLine;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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

public class Scenes extends Main{
	
	// everything needs a draw function
	// keep calling the draw functions in a loop
	// in main game logic, create event handler and timeline to keep running event hand
	
	
	public Stage window;
	public Scene scene;
	private static int width = 800;
	private static int height = 600;
	public boolean play = false;
	public boolean Ind_One = false;
	public boolean Ind_two = false;
	public boolean Ind_tre = false;
	public ImageView view = new ImageView("game.jpg"); 
	public ImageView view2 = new ImageView("game2.jpg");
	public String MEDIA = "music.wav";
	

	

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
	// this is what happens after you click start
	// run timeline loop in here? (game logic goes here)
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
		
		// add characters image/////////////////////
		Spaceship player = new Spaceship(200, 100); 
		Asteroid asteroid = new Asteroid();
		ImageView drawPlayer = player.getGraphic();
		
		
		main.getChildren().addAll(view2 ,drawPlayer);
		
		/////////////////////// EVENTHANDLER
		ArrayList<Asteroid> asteroidList = new ArrayList<Asteroid>();
		ArrayList<Shot> bulletStorage = new ArrayList<Shot>();
		
		EventHandler<KeyEvent> playerShootHandler = new EventHandler<KeyEvent>() {
		    	
	        	@Override
	        	public void handle(KeyEvent arg0) {
	        		KeyCode keyPressed = arg0.getCode();
	        		switch(keyPressed) {
        			
        			case SPACE:
        				Shot bullet = new Shot(player.getX(), player.getY());
        				bulletStorage.add(bullet);
        				break;
        				//t
	        		}
	        	}
		 };
	       
		
		EventHandler<ActionEvent> spaceGame = new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				//System.out.println("hi");
				player.draw();
				
				for (Shot bullet : bulletStorage) {
					bullet.draw();
				}
				
				for (Asteroid ast : asteroidList) {
					ast.draw();
				}
				
			}
		};
		
		EventHandler<ActionEvent> spawnAsteroid = new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				Asteroid ast = new Asteroid();
				ImageView drawAsteroid = ast.getGraphic();
				asteroidList.add(ast);
				main.getChildren().add(drawAsteroid);
			}
		};
		
		Timeline spawnT = new Timeline(new KeyFrame(Duration.millis(3000), spawnAsteroid));
		spawnT.setCycleCount(Timeline.INDEFINITE);
		spawnT.play();
		
		Timeline t = new Timeline(new KeyFrame(Duration.millis(32), spaceGame));
		t.setCycleCount(Timeline.INDEFINITE);
		t.play();
		
		/////////////////////// EVENTHANDLER
		// make a list of all bullets and asteroids
		// loop through that and call their draw methods
		// takes care of movement
		Scene scene = new Scene(main);
		scene.setOnKeyPressed(player.playerKeyHandler);
		scene.setOnKeyReleased(player.playerKeyStopHandler);
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
		
		Label sone = new Label();
		Label stwo = new Label();
		Label stre = new Label();

		
		//Play/Pause
		pla.setPrefHeight(75);
		pla.setPrefWidth(100);
		pla.setLayoutX(350);
		pla.setLayoutY(100);
		
		if(play == true) {
			
			pla.setText("ON");
		}
		else {
			
			pla.setText("OFF");
		}
		
		pla.setOnAction(e -> {
			
			
			if(play == true) {
				
				play = false;
				pla.setText("OFF");
			}
			else {
				
				play = true;
				pla.setText("ON");
				playMusic();
				
			}
			
			
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
		
			
		});
		//skin1
		
			//Image of the ship
		Image ship1 = new Image("defaultShip.png", 195, 95, true, true);
		ImageView skin1view = new ImageView(ship1);
		skin1.setGraphic(skin1view);
		
			//Indicator
		sone.setPrefHeight(1);
		sone.setPrefWidth(50);
		sone.setLayoutX(150);
		sone.setLayoutY(410);
		
		if(Ind_One == false) {
			
			sone.setOpacity(0);
			
		} 
		else {
			
			sone.setOpacity(1);
			sone.setStyle("-fx-background-color: red;");
		}
				
			//height and x and y coords //Dont change
		skin1.setPrefHeight(100);
		skin1.setPrefWidth(200);
		skin1.setLayoutX(75);
		skin1.setLayoutY(300);
	
		skin1.setOnAction(e -> {
			
			
			
		});
		
		//skin2
		
			//Image of the ship
		Image ship2 = new Image("ship2.png", 200, 100, true, true);
		ImageView skin2view = new ImageView(ship2);
		skin2.setGraphic(skin2view);
			
			//height and x and y coords //Dont change
		skin2.setPrefHeight(100);
		skin2.setPrefWidth(200);
		skin2.setLayoutX(300);
		skin2.setLayoutY(300);
		
		skin2.setOnAction(e -> {
			
			
		});
		
		//skin3
		
			//Image of the ship
		Image ship3 = new Image("ship3.png", 200, 100, true, true);
		ImageView skin3view = new ImageView(ship3);
		skin3.setGraphic(skin3view);
		
			//height and x and y coords //Dont change
		skin3.setPrefHeight(100);
		skin3.setPrefWidth(200);
		skin3.setLayoutX(525);
		skin3.setLayoutY(300);
		
		skin3.setOnAction(e -> {
			
			
		});
		
		
		
		
		
		main.getChildren().addAll(view2, pla, bac, skin1, skin2, skin3, sone);
		Scene scene = new Scene(main);
		return scene;
	}
	
	public void playMusic () {
		
		
		try {
			
			File music = new File("./music.wav");
			AudioInputStream audios = AudioSystem.getAudioInputStream(music);
			Clip clip = AudioSystem.getClip();
			clip.open(audios);
			clip.start();
			
		    Thread.sleep(500);
		    
		    audios.close();
		    
		}
		catch (Exception e) {
			
			System.out.print("error Line 267 scenes class");
		}
			
		
	}
	
//	public void runGame() {
//		Game_Logic runSpaceShooters = new Game_Logic();
//	}

}


