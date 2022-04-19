package application;

import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Spaceship extends Characters{
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
	
	   private int width;

	    public Spaceship() {

	        ship();
	    }

	    private void ship() {
	    	// temporary image
	        var shipImg = "https://png.pngtree.com/png-clipart/20210323/our"
	        		+ "large/pngtree-ufo-space-ship-alien-clip-art-png-image_3103337.jpg";
	        var ii = new ImageIcon(shipImg);

	        width = ii.getImage().getWidth(null);
	        setImage(ii.getImage());

	        int START_X = 200;
	        setX(START_X);

	        int START_Y = 220;
	        setY(START_Y);
	    }

	    public void shipMovement() {
	        x += dx;
	        y += dy;

	        if (x <= 2) {
	            x = 2;
	        }

	        if (x >= 800 - 2 * width) {
	            x = 600 - 2 * width;
	        }
	        
	        if (y <= 2) {
	            y = 2;
	        }

	        if (y >= 800 - 2 * width) {
	            y = 600 - 2 * width;
	        }
	    }

	    
	    
	    public void keyPressed(KeyEvent e) {

	        int key = e.getKeyCode();

	        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
	            dx = -3;
	        }

	        if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
	            dx = 3;
	        }
	        
	        System.out.println("keypressed works");
	        
//	        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
//	        	dy = 3;
//	        }
//	        
//	        if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
//	        	dy = -3;
//	        } 
	    }

	    public void keyReleased(KeyEvent e) {

	        int key = e.getKeyCode();

	        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
	            dx = 0;
	        }

	        if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
	            dx = 0;
	        }
	        
	        System.out.println("key released works");
	        
//	        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
//	        	dy = 0;
//	        }
//	        
//	        if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
//	        	dy = 0;
//	        }
	    }
	    
}
	
	

