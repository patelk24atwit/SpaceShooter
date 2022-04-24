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
import javafx.animation.PauseTransition;
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
	
	public Stage window;
	public Scene scene;
	private static int width = 800;
	private static int height = 600;
	public boolean play = false;
	public Label scoreLabel = new Label("Score: 0");
	public int Score = 0;
	public ImageView view = new ImageView("game.jpg"); 
	public ImageView view2 = new ImageView("game2.jpg");
	public static ArrayList<Shot> bulletStorage = new ArrayList<Shot>();
	
	public static Pane main = new Pane();
	public Spaceship player = new Spaceship(500, 400);
	public ArrayList<Asteroid> asteroidListSlow = new ArrayList<Asteroid>();
	public ArrayList<Asteroid> asteroidListFast = new ArrayList<Asteroid>();
	

	public Scenes(Stage window) {
		this.window = window;
		window.setTitle("Start");
		window.setResizable(false);
		
	}
	
	//Opening Scene
	public Scene Main () {
	
		Button sta = new Button(); // start button
		//Button gea = new Button(); // settings (gear) button
		Label keys = new Label();
		
		Pane main = new Pane();
		main.setPrefSize(width, height);
		Image keyinstruction = new Image("instructions.png", 480, 131, true, true);
		ImageView keyinstructions = new ImageView(keyinstruction);
		
		//keys label
		

		keys.setLayoutX(160);
		keys.setLayoutY(400);
		keys.setGraphic(keyinstructions);
		
		
			PauseTransition visiblePause = new PauseTransition(
					
			        Duration.seconds(4)
			);
			
			visiblePause.setOnFinished(
					
			        event -> keys.setVisible(false)
			);
		
		visiblePause.play();
		
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
	
	main.getChildren().addAll(view, sta, keys);
	Scene scene = new Scene(main);
	return scene;
	}
	
	// MAIN GAMEPLAY
	// this is what happens after you click start
	public Scene Start () {
		
		main.setPrefSize(width, height);
		
		scoreLabel.setLayoutX(700);
		scoreLabel.setLayoutY(5);
		scoreLabel.setStyle("-fx-font: 15px Lucida-Fax;"
				+ "-fx-text-fill: white;");
		
		main.getChildren().addAll(view2, player.getGraphic());
		
		/////////////////////////////////////////////////////////////////////////////////// EVENTHANDLER
		
		// EventHandler for the main gameplay
		
			EventHandler<ActionEvent> spaceGame = new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent arg0) {
				
					if(player.isDead() == false) {
						player.drawShip();
						
						for (Shot bullet : bulletStorage) {
							bullet.drawBullet();
						}
						
						for (Asteroid ast : asteroidListSlow) {
							ast.drawSlowAst();
						}
						
						for (Asteroid ast : asteroidListFast) {
							ast.drawFastAst();
						}
						
						collisionDetect();
						

					}
					

					
				}
			};
			
			// Event Handler to spawn slow moving asteroids
			EventHandler<ActionEvent> spawnSlowAsteroid = new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent arg0) {
					
					Asteroid ast = new Asteroid();

					if(player.isDead() == false) {
					
						asteroidListSlow.add(ast);
						main.getChildren().add(ast.getGraphic());
						
					}
					
				
				}
			};
			
			// Event Handler to spawn fast moving asteroids
			EventHandler<ActionEvent> spawnFastAsteroid = new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent arg0) {
					
					Asteroid ast1 = new Asteroid();

					if(player.isDead() == false) {
					
						asteroidListFast.add(ast1);
						main.getChildren().add(ast1.getGraphic());
					
					}
				}
			};
			
			// timeline for slow asteroids

				Timeline spawnSA = new Timeline(new KeyFrame(Duration.millis(2500), spawnSlowAsteroid));
				spawnSA.setCycleCount(Timeline.INDEFINITE);
				spawnSA.play();
				
				// timeline for fast asteroids
				Timeline spawnFA = new Timeline(new KeyFrame(Duration.millis(5000), spawnFastAsteroid));
				spawnFA.setCycleCount(Timeline.INDEFINITE);
				spawnFA.play();
				
				// timeline for the main gameplay
				Timeline t = new Timeline(new KeyFrame(Duration.millis(32), spaceGame));
				t.setCycleCount(Timeline.INDEFINITE);
				t.play();
			
			
			
		///////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		Scene scene = new Scene(main);
		
		scene.setOnKeyPressed(player.playerKeyHandler);
		scene.setOnKeyReleased(player.playerKeyStopHandler);
		
		
		return scene;
	}
	
	// method to create instances of shots (bullets)
	 public static void createBullet(int x, int y, double[] shotMove) {
		 System.out.println("shooting");
			Shot bullet = new Shot(x, y, shotMove);
			bulletStorage.add(bullet);
			main.getChildren().add(bullet.getGraphic());
		}
	
	
	public Scene EndScene () {
		
		Pane main = new Pane();
		main.setPrefSize(width, height);
	
		Label bac = new Label();
		bac.setText("Thank you for playing your score was " + Score + " .");
		bac.setLayoutX(200);
		bac.setLayoutY(100);
		bac.setStyle("-fx-text-fill: white;"
				+ "-fx-font: 25px Lucida-Fax;");
			
	
		main.getChildren().addAll(view2, bac);
		Scene scene = new Scene(main);
		return scene;
		
	}
	

//	
	////////////////////////////////// COLLISION DETECTION METHOD
	public void collisionDetect() {
		
		
			Shot noShot = null;
			
			// loops through all the bullets shot by the player
			for (Shot bullet : bulletStorage) {
				
				// checks for collision with a slow moving asteroid
				for (Asteroid asteroid : asteroidListSlow) {
					if (bullet.getGraphic().getBoundsInParent().intersects
							(asteroid.getGraphic().getBoundsInParent())) {
						asteroidListSlow.remove(asteroid);
						asteroid.setAstDestroyed(true);
						bullet.shotDestroyed(true);
						bulletStorage.remove(bullet);
						noShot = bullet;
						Score = Score + 50;
						updateScore();						
					}
				}
				
				// checks for a collision with a fast moving asteroid
				for (Asteroid asteroid : asteroidListFast) {
					if (bullet.getGraphic().getBoundsInParent().intersects
							(asteroid.getGraphic().getBoundsInParent())) {
						asteroidListFast.remove(asteroid);
						asteroid.setAstDestroyed(true);
						bullet.shotDestroyed(true);
						bulletStorage.remove(bullet);
						noShot = bullet;
						Score = Score + 100;
						updateScore();

					}
				}
				
			
			
			if (noShot != null) {
				bulletStorage.remove(noShot);
			}
			
			// checks for collision between slow asteroid and player
			
			for (Asteroid asteroid : asteroidListSlow) {

				if (player.getGraphic().getBoundsInParent().intersects
						(asteroid.getGraphic().getBoundsInParent())&& !asteroid.getDestroyed()) {
					System.out.println("w");
					player.setDead(true);
					updatePlayerStatus();
				}
			}
		
			// checks for collision between fast asteroid and player
			for (Asteroid asteroid : asteroidListFast) {
				if (player.getGraphic().getBoundsInParent().intersects 
						(asteroid.getGraphic().getBoundsInParent())&& !asteroid.getDestroyed()) {
					System.out.println("w");
					player.setDead(true);
					updatePlayerStatus();
								
				}
			
			}
		}
	}
	
	// method to check if player is dead or alive
	// if the player is dead, the game ends
		
	public void updatePlayerStatus() {
		if(player.isDead() == true) {
			//Game End Change Scene
			Scene newScene = EndScene();
			window.setScene(newScene);
			window.setTitle("End");
			window.show();
		}
	
	}
	
	public void updateScore() {
		
		scoreLabel.setText("Score: " + Score);
	}
		
	

}


