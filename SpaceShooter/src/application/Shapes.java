package application;

import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Rotate;

/**
 * 
 * this is an abstract class used to define the movements 
 * of the general shapes in the game
 * it supercedes the asteroid and spaceship class
 *
 */
public abstract class Shapes {
	
	private Point2D moveShape;
	private Polygon shape;
	
	/**
	 * 
	 * creates a general polygon that has an x and y
	 * in the pane space
	 * that can be translated (i.e. move the shape)
	 * 
	 * 
	 */
	public Shapes (Polygon general, double x, double y) {
		this.shape = general;
		this.shape.setTranslateX(x);
		this.shape.setTranslateY(y);
		this.moveShape = new Point2D(0.,0.);
	}
	
	public Polygon getShape() {
		return shape;
	}
	
	public void rightTurn() {
		// rotate shape -60 degrees about an anchor point at (50,30)
		this.shape.getTransforms().add(new Rotate(90, 50, 30));
	}
	
	public void leftTurn() {
		// rotate shape 60 degrees about an anchor point at (50,30)
		this.shape.getTransforms().add(new Rotate(-90, 50, 30));
	}
	
	public void move() {
        this.shape.setTranslateX(this.shape.getTranslateX() + this.moveShape.getX());
        this.shape.setTranslateY(this.shape.getTranslateY() + this.moveShape.getY());
	}
	
	
	
}
