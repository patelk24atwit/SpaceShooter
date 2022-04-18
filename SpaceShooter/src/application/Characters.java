package application;

import java.awt.Image;

import javafx.animation.AnimationTimer;
import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Rotate;

/**
 * 
 * this is an abstract class used to define the 
 * general characters in the game
 *
 */
public abstract class Characters {
	
	private boolean visible;
    private Image image;
    private boolean dying;

    int x;
    int y;
    int dx;
    int dy;

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

        return image;
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

    public void setDying(boolean dying) {

        this.dying = dying;
    }

    public boolean isDying() {

        return this.dying;
    }
}
