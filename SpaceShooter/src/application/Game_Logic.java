package application;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.Random;

import javafx.stage.Stage;

public abstract class Game_Logic{
	
	private boolean gameRunning = true;
	
	// construtor
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

        
        public void keyPressed(Spaceship player, KeyEvent e) {

            player.keyPressed(e);

            int xPlay = player.getX();
            int yPlay = player.getY();

            int key = e.getKeyCode();

            if (key == KeyEvent.VK_SPACE) {
            	Shot shot = new Shot(xPlay, yPlay);
            }
        }
	}
	
	// randomly generate asteroids
	
	
	// check if shot matches coordinates of asteroids
	// then deal with collision
	
	
	
	// deal with ship and asteroid collision
	
	
}
