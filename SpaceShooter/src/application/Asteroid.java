package application;

import javax.swing.ImageIcon;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Polygon;

public class Asteroid extends Characters {
	private int width;
	private boolean destroyed;
	
	public Asteroid (int x, int y) {
		asteroid(x, y);
	}
	
	public void asteroid(int x, int y) {
		this.x = x;
		this.y = y;
		
		var astImg = "https://www.seekpng.com/png/detail/216-2168369_"
				+ "pixel-asteroid-png-jpg-pixel-art-deadpool-logo.png";
		var ast = new ImageIcon(astImg);
		
		width = ast.getImage().getWidth(null);
        setImage(ast.getImage());

        int START_X = 200;
        setX(START_X);

        int START_Y = 400;
        setY(START_Y);
	}
	
	public void astMovement(int direct) {
		this.x += direct;
	}
	
	public void setAstDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
	}
	
	public boolean getDestroyed() {
		return destroyed;
	}

}
