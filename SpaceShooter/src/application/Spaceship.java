package application;

import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Spaceship extends Characters{
	
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

	    public void movement() {

	        x += dx;

	        if (x <= 2) {
	            x = 2;
	        }

	        if (x >= 400 - 2 * width) {
	            x = 400 - 2 * width;
	        }
	    }

	    public void keyPressed(KeyEvent e) {

	        int key = e.getKeyCode();

	        if (key == KeyEvent.VK_LEFT) {
	            dx = -2;
	        }

	        if (key == KeyEvent.VK_RIGHT) {
	            dx = 2;
	        }
	    }

	    public void keyReleased(KeyEvent e) {

	        int key = e.getKeyCode();

	        if (key == KeyEvent.VK_LEFT) {

	            dx = 0;
	        }

	        if (key == KeyEvent.VK_RIGHT) {

	            dx = 0;
	        }
	    }
}
	
	

