package application;

import javax.swing.ImageIcon;

// every time create instance of shot, store in an arraylist
// loop through array list continuously updating movement vectors
// to draw shot frame-by-frame

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Shot extends Characters{
	
	public Image shotImg = new Image("beamone.png", 10, 10, false, false);
	public boolean destroyed = false;
	private double[] moveVec;
	private int xPos, yPos;
	
	public Shot() {
	}
	
	public Shot (int x, int y, double[] shotMove) {
		xPos = x;
		yPos = y;
		
		this.setImage(shotImg);
		ImageView shotGraphic = new ImageView(this.getImage());
		this.setGraphic(shotGraphic);
		
		getGraphic().setX(x + 24);
		getGraphic().setY(y+2);
		setVisible(true);
		moveVec = shotMove;
		
	}
	
	public void drawBullet() {
		yPos += moveVec[1]*6;
		getGraphic().setY(yPos);
	}
	
	public void shotDestroyed(boolean state) {
		destroyed = state;
		getGraphic().setImage(null);
	}
	
	

}
