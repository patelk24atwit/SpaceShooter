package application;

import javax.swing.ImageIcon;

// every time create instance of shot, store in an arraylist
// loop through array list continuously updating movement vectors
// to draw shot frame-by-frame

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Shot extends Characters{
	public Image shotImg = new Image("https://toppng.com/uploads/preview/"
			+ "laser-beam-pixel-art-11563037601qamote2gip.png");
	
	public Shot() {
	}
	
	public Shot (int x, int y) {
		setX(this.x);
		setY(this.y);
		setVisible(true);
		playerShot(x,y);
		
		dy = -1;
	}
	
	public void playerShot(int x, int y) {
		setImage(shotImg);
		ImageView shotGraphic = new ImageView(getImage());
		setGraphic(shotGraphic);
	}
	
	public void drawBullet() {
		y += dy*6;
		this.getGraphic().setY(y);
	}

}
