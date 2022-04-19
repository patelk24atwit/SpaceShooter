package application;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.Random;

import javafx.stage.Stage;

public class Game_Logic{
	
	public Asteroid asteroids = new Asteroid(150,150);
	public Spaceship player = new Spaceship();
	public Shot shot = new Shot();
	
	public Random rand = new Random();
	
	private boolean gameRunning = true;
	
	// construtor
	public Game_Logic() {
		// characters in the game
		this.player = player;
		this.shot = shot;
		this.asteroids = asteroids;
		
		addKeyListener(new playerMoves());
		
		
	}
	
	private void addKeyListener(playerMoves playerMoves) {
		// TODO Auto-generated method stub
		
	}

	// call player and make it move
	private class playerMoves extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {

            player.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {

            player.keyPressed(e);

            int x = player.getX();
            int y = player.getY();

            int key = e.getKeyCode();

            if (key == KeyEvent.VK_SPACE) {

                if (gameRunning) {

                    if (!shot.isVisible()) {

                        shot = new Shot(x, y);
                    }
                }
            }
        }
	}
	
	// randomly generate asteroids
	//int n = rand.nextInt(700);
	
	

	
	
	
	// check if shot matches coordinates of asteroids
	// then deal with collision
	
	
	
	// deal with ship and asteroid collision
	
	
	
}
