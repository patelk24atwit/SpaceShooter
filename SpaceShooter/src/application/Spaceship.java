package application;

import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Spaceship extends Characters{
	
	public Image ii = new Image("defaultShip.png");
	int dx=0; // dx represents the change in the x movement
	final int SPEED = 5;
	
	// add a draw get graphic method to return character imageview
	// then in main, add that imageview to the root group
	// do same with background map 
	// do same for other shots / characters / asteroids
	
	// then set up inifinite draw loop (use TimeLine)
	// and call draw functions
	// draw function calculates new x and y position and setting that to the graphic
	// graphic is the imageview
	
	// constant speed variable
	// movement vector, 2 int array (x,y)
	// private double movementVector
	// movementVector starts as 0; 
	// pressing upkey charnges move vector to -1 or 1
	// movement vector 1 = right
	
	   private double width;

	    public Spaceship(int x,  int y) {
	    	setX(this.x);
	    	setY(this.y);
	        ship();
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
	    
	    public void shipMovement(KeyEvent ex) {
	    	int key = ex.getKeyCode();
	    	
	    	int left = dx*SPEED;
	    	int right = dx*SPEED;
	    	
	    	 if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
		            setX(getX()*left);
		     }
		     if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
		            setX(getX()*right);
		     }  
	    }
	    
	    public void keyPressed(KeyEvent e) {
	        int key = e.getKeyCode();

	        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
	            dx = -1;
	        }
	        if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
	            dx = 1;
	        }
	    }

	    public void keyReleased(KeyEvent e) {
	        int key = e.getKeyCode();

	        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
	            dx = 0;
	        }
	        if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
	            dx = 0;
	        } 
	    } 
}
	
	

