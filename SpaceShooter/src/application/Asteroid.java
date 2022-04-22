package application;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.ImageIcon;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Polygon;

public class Asteroid extends Characters {
	public boolean destroyed = false;
	Image astImg = new Image("asteriod.png");
	
	
	public Asteroid () {
		asteroid();
	}
	
	public void asteroid() {
		setImage(astImg);
		ImageView astGraphic = new ImageView(getImage());
		setGraphic(astGraphic);
	
      
        // x should be a random number within the bounds of the game stage
		int n = ThreadLocalRandom.current().nextInt(50, 750 + 1);
        setX(n);
        graphic.setX(n);

       int START_Y = 20;
        setY(START_Y);
        graphic.setY(START_Y);
        
        dy = 1;
	}
	
	public void drawSlowAst() {
    	y += dy*2;
    	this.getGraphic().setY(y);
	}
	
	public void drawFastAst() {
    	y += dy*5;
    	this.getGraphic().setY(y);
	}
	
	public void setAstDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
		this.getGraphic().setImage(null);
	}
	
	public boolean getDestroyed() {
		return destroyed;
	}

}
