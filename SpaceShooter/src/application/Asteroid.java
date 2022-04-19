package application;

import java.util.Random;

import javax.swing.ImageIcon;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Polygon;

public class Asteroid extends Characters {
	public double width;
	public boolean destroyed;
	Image astImg = new Image("asteriod.jpg");
	
	public int dy = -1; //dy represents the change in y movement
	public final int FALL = 6;
	
	
	public Asteroid (int x, int y) {
		asteroid(x, y);
		setX(this.x);
		setY(this.y);
	}
	
	public Asteroid() {
	}
	
	public void asteroid(int x, int y) {
		this.x = x;
		this.y = y;
		
		setImage(astImg);
		ImageView astGraphic = new ImageView(getImage());
		setGraphic(astGraphic);
		
		//width = asteroid.getImage().getWidth();
      
        // x should be a random number within the bounds of the game stage
		Random rand = new Random();
		int n = rand.nextInt(50, 750);
        setX(n);

        int START_Y = 550;
        setY(START_Y);
	}
	
	public void astMovement() {
		setY(getY()*dy*FALL);
	}
	
	public void setAstDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
	}
	
	public boolean getDestroyed() {
		return destroyed;
	}

}
