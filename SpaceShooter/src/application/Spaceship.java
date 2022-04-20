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
	
	   public EventHandler<KeyEvent> playerKeyHandler;
	   public EventHandler<KeyEvent> playerKeyStopHandler;
	   public ArrayList<Shot> bulletStorage = new ArrayList<Shot>();
	   

	    public Spaceship(int x,  int y) {
	    	setX(this.x);
	    	setY(this.y);
	        ship();
	        
	        playerKeyHandler = new EventHandler<KeyEvent>() {
		    	
	        	@Override
	        	public void handle(KeyEvent arg0) {
	        		KeyCode keyPressed = arg0.getCode();

	        		switch(keyPressed) {
	        			case A:
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
	        			case SPACE:
	        				shoot();
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
	        				break;
	        		}
	        	}
	        	
		    };
	        
	    }
	    
	    public Spaceship() {
	    }

	    public void ship() {
	    	setImage(ii);
	    	ImageView iiGraph = new ImageView(getImage());
	    	setGraphic(iiGraph);

	        // starting coordinates for where image generates
	        int START_X = 400;
	        setX(START_X);

	        int START_Y = 500;	
	        setY(START_Y);
	    }  
	    
	    public void drawShip() {
	    	x += dx*SPEED;
	    	y += dy*SPEED;
	    	
	    	this.getGraphic().setX(x);
	    	this.getGraphic().setY(y);
	    }
	    
	    public void shoot() {
	    	Shot bullet = new Shot(this.getX(), this.getY());
	    	bulletStorage.add(bullet);
	    }
}