package application;

//import java.awt.Image;
import javafx.scene.image.Image;

import javafx.animation.AnimationTimer;
import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Rotate;

/**
 * 
 * this is an abstract class used to define the 
 * general characters in the game
 *
 */
public abstract class Characters {
	
	public boolean visible = true;
    public Image image;
    public boolean dying = false;
    public ImageView graphic;
    public int SPEED = 6;
    
    int dx = 0;
    int dy = 0;

    int x;
    int y;
  

    public Characters() {
        visible = true;
    }

    public void die() {
        visible = false;
    }

    public boolean isVisible() {
        return visible;
    }

    protected void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return this.image;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setDead(boolean dying) {
        this.dying = dying;
    }

    public boolean isDead() {
        return this.dying;
    }
    
    public void setGraphic(ImageView graphic) {
    	this.graphic = graphic;
    }
    
    public ImageView getGraphic() {
    	return graphic;
    }
    
}
