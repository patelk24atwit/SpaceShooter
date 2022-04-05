package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Polygon;

public class Asteroids extends Shapes {

	public Asteroids(double x, double y) {
		super(new Polygon(25, -25, 25, 25, -25, 25, -25, -25, 25), x, y);
	}
	

}
