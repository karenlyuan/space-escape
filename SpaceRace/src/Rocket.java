import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Rocket {
	
	//location attributes for left rocket
	public static int x1 = 220;
	public static int y1 = 145;
	
	//location attributes for right rocket
	public static int x2 = 680;
	public static int y2 = 145;
	
	private int length, width; //size
	public static double speedX = 5;
	public static double speedY = 5;
	
	public static Image img;
	private Image background;
	private static AffineTransform tx;
	public boolean draw;

	public Rocket() {
		
		img = getImage("rocket-transparent");
		
		tx = AffineTransform.getTranslateInstance(x1, y1);
		
		init(x1, y1); 				//initialize the location of the image
										//use your variables
		init(x2, y2);
		
	}
	
	public void changePicture(String newFileName) {
		img = getImage(newFileName);
		init(x1, y1);
		init(x2, y2);
		
	}
	
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);
		
		x1 += speedX;
		y1 += speedY;
		
		update();
				
		if (x1 <= -75 || x1 >= 780) {
			speedX *= -1;
		}
		
		if (y1 <= -30 || y1 >= 375) {
			speedY *= -1;
		}

	}
	
	public void update() {
		tx.setToTranslation(x1, y1);
		tx.setToTranslation(x2, y2);
		tx.scale(0.001, 0.001);
	}
	
	private static void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(0.001, 0.001);
	}

	public static Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Rocket.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

	public static void reset() {
		img = getImage("rocket-transparent");
		
		tx = AffineTransform.getTranslateInstance(x1, y1);
		init(x1, y1);
		init(x2, y2);
	}

}