package application;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Spaceship extends Characters{
	
	public Image ii = new Image("defaultShip.png");
//	int dx=0; // dx represents the change in the x movement
//	final int SPEED = 5;
	
	// add a draw get graphic method to return character imageview
	// then in main, add that imageview to the root group
	// do same with background map 
	// do same for other shots / characters / asteroids
	
	// then set up inifinite draw loop (use TimeLine)
	// and call draw functions
	// draw function calculates new x and y position and setting that to the graphic
	// graphic is the imageview
	
	   private double width;
	   public EventHandler<KeyEvent> playerKeyHandler;
	   public EventHandler<KeyEvent> playerKeyStopHandler;
	   

	    public Spaceship(int x,  int y) {
	    	setX(this.x);
	    	setY(this.y);
	        ship();
	        
	        playerKeyHandler = new EventHandler<KeyEvent>() {
		    	
	        	@Override
	        	public void handle(KeyEvent arg0) {
	        		System.out.println("key pressed");
	        		KeyCode keyPressed = arg0.getCode();
//	        		if (keyPressed == KeyCode.SPACE) {
//	        			if (!visible) {
//	        				shoot();
//	        			}
	        		switch(keyPressed) {
	        			case A:
	        				System.out.println("RIGHT PRESSED");
	        				dx = -1;
	        				break; 
	        			case D:
	        				dx = 1;
	        				break;
	        			case W:
	        				dy = -1;
	        				break;
	        			case S:
	        				dy = 1;
	        				break;
	        		
	        		
	        		}
	        	}
	        	
		    };
		    
		    playerKeyStopHandler = new EventHandler<KeyEvent>() {
		    	
	        	@Override
	        	public void handle(KeyEvent arg0) {
	        		System.out.println("key pressed");
	        		KeyCode keyPressed = arg0.getCode();
//	        		if (keyPressed == KeyCode.SPACE) {
//	        			if (!visible) {
//	        				shoot();
//	        			}
	        		switch(keyPressed) {
	        			case A:
	        				System.out.println("RIGHT PRESSED");
	        				dx = 0;
	        				break; 
	        			case D:
	        				dx = 0;
	        				break;
	        			case W:
	        				dy = 0;
	        				break;
	        			case S:
	        				dy = 0;
	        				break;
	        			case SPACE:
	        				dy=0;
	        				dx=0;
	        		}
	        	}
	        	
		    };
	        
	    }
	    
	    public Spaceship() {
	    }

	    public void ship() {
	    	// temporary image
	    	setImage(ii);
	    	ImageView iiGraph = new ImageView(getImage());
	    	setGraphic(iiGraph);
	    	getGraphic();
	    	
	        //width = player.getImage().getWidth();

	        // starting coordinates for where image generates
	        int START_X = 400;
	        setX(START_X);

	        int START_Y = 150;	
	        setY(START_Y);
	    }   
}