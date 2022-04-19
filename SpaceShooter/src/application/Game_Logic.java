package application;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import javafx.stage.Stage;

public abstract class Game_Logic{
	
	public boolean gameRunning = true;
	
	// construtors
	public Game_Logic() {
		addKeyListener(new playerMoves());
	}
	
	private void addKeyListener(playerMoves playerMoves) {
	}

	// call player and make it move
	private class playerMoves extends KeyAdapter {
		
        public void keyReleased(Spaceship player, KeyEvent e) {
            player.keyReleased(e);
        }

        // when pressing spacebar, creates shot
	    public void spaceBarPressed(Spaceship player, KeyEvent e) {
	        player.keyPressed(e);
	        int key = e.getKeyCode();
	
	        int xPlay = player.getX();
	        int yPlay = player.getY();
	
	         if (key == KeyEvent.VK_SPACE) {
	            Shot shot = new Shot(xPlay, yPlay);
	          }
	     }
    
	    public void keyPressed(Spaceship player, KeyEvent e) {
	    	player.keyPressed(e);
	    	player.shipMovement(e);
	    }
	}	
	
	// randomly generate asteroids
	public void generateAst() {
		ArrayList<Asteroid> enemies = new ArrayList<Asteroid>(30); 
		for (int i=0; i<30; i++) {
			enemies.add(new Asteroid());
		}
		
	}
	
	// check if shot matches coordinates of asteroids
	public boolean shotCollision(Shot shot, Asteroid ast) {
		if ((shot.getX() == ast.getX()) && (shot.getY() == ast.getY())) {
			return true;
		}
		else {
			return false;
		}
	}
	// then deal with collision
	
	
	
	// deal with ship and asteroid collision
	public boolean shipCollision(Spaceship player, Asteroid ast) {
		if ((player.getX() == ast.getX()) && (player.getY() == ast.getY())) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
	

