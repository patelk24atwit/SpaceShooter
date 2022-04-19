package application;

import javax.swing.ImageIcon;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Shot extends Characters{
	public Shot shot;
	public Image shotImg = new Image("https://toppng.com/uploads/preview/"
			+ "laser-beam-pixel-art-11563037601qamote2gip.png");
	
	public Shot() {
	}
	
	public Shot (int x, int y) {
	}
	
	public void playerShot(int x, int y) {
		shot.setImage(shotImg);
		ImageView shotGraphic = new ImageView(shot.getImage());
		shot.setGraphic(shotGraphic);

        int horizontal = 6;
        setX(x + horizontal);

        int vertical = 1;
        setY(y - vertical);
	}

}
