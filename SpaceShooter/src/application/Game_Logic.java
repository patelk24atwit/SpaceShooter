package application;

import java.awt.event.KeyEvent;

import javafx.stage.Stage;

public class Game_Logic{
	
	public Asteroid asteroids = new Asteroid(150,150);
	public Spaceship player = new Spaceship();
	public Shot shot = new Shot();
	
	public Game_Logic() {
		System.out.println("Please work");
	}
	
	// call player and make it move
	public void playerMove(){
		
		
		try {
			
		} catch (Exception e) {
			System.out.println("key movement not working");
		};
		
	}
	
	// randomly generate asteroids
	
	// check if shot matches coordinates of asteroids
	// then deal with collision
	
	// deal with ship and asteroid collision
	
	
	
}
