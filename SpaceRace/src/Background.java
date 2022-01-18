/*
Notes for project:
- use previous projects as templates for classes! (duck-hunt, pong, agar.io)
- use own assets for game (pictures and sounds)
- find graphics or create them

*/

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Background {
	
	//add location attributes
	private int x, y; //position of the bird
	private int length, width; //size
	
	private Image img; 	
	private Image background;
	private AffineTransform tx;

	
	public Background(int x, int y) {
		background = getImage("/imgs/rocket-transparent.png");
		this.x = x;
		this.y = y;

		
		tx = AffineTransform.getTranslateInstance(x, y);
		init(x, y); 				//initialize the location of the image
									//use your variables
	}
	
	public void changePicture(String newFileName) {
		background = getImage(newFileName);
		init(0, 0);
	}
	
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g3 = (Graphics2D) g;
		g3.drawImage(background, tx, null);
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1,1);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Background.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

}
