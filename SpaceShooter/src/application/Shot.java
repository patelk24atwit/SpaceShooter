package application;

import javax.swing.ImageIcon;

public class Shot extends Characters{
	
	public Shot() {
	}
	
	public Shot (int x, int y) {
		
	}
	
	public void playerShot(int x, int y) {
		var shotImg = "https://toppng.com/uploads/preview/"
				+ "laser-beam-pixel-art-11563037601qamote2gip.png";
        var ii = new ImageIcon(shotImg);
        setImage(ii.getImage());

        int horizontal = 6;
        setX(x + horizontal);

        int vertical = 1;
        setY(y - vertical);
	}

}
