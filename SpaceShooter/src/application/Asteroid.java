package application;

import javax.swing.ImageIcon;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Polygon;

public class Asteroid extends Characters {
	public double width;
	public boolean destroyed;
	Image astImg = new Image("https://www.seekpng.com/png/detail/216-2168369_"
			+ "pixel-asteroid-png-jpg-pixel-art-deadpool-logo.png");
	public Asteroid asteroid = new Asteroid(500,400);
	
	public Asteroid (int x, int y) {
		asteroid(x, y);
		asteroid.setX(this.x);
		asteroid.setY(this.y);
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
        

        // y stays same
        // x should be a random number within the bounds of the game stage
        // 0 - 800
        int START_X = 200;
        setX(START_X);

        int START_Y = 400;
        setY(START_Y);
	}
	
	public void astMovement(int direct) {
		this.y -= direct;
	}
	
	public void setAstDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
	}
	
	public boolean getDestroyed() {
		return destroyed;
	}

}
