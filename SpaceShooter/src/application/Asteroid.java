package application;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Polygon;

public class Asteroid extends Shapes {

	public Asteroid(double x, double y) {
		super(new Polygon(25, -25, 25, 25, -25, 25, -25, -25, 25), x, y);
	}
	
	
	
	// how to handle collision between ship and asteroid
	public boolean collision(Polygon temp) {
		return false;
	}

}
