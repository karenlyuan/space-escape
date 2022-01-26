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
	
	private int length, width; //size
	public static double speedX = 5;
	public static double speedY = 5;
	
	public static Image img;
	private Image background;
	private static AffineTransform tx;
	public boolean draw;

	public Rocket() {
		
		img = getImage("/imgs/SpaceShipWhite.jpg");
		
		tx = AffineTransform.getTranslateInstance(x1, y1);
		
		init(x1, y1); 				//initialize the location of the image
										//use your variables		
	}
	
	public void changePicture(String newFileName) {
		img = getImage(newFileName);
		init(x1, y1);
		
	}
	
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);
		
		x1 += speedX;
		y1 += speedY;
		
		update();
				
		if (x1 <= 50 || x1 >= 850) {
			speedX *= -1;
		}
		
		if (y1 <= -30 || y1 >= 375) {
			speedY *= -1;
		}

	}
	
	public void Collide(Asteroid a) {
		
		//if robot collides with an Asteroid
		
		if(x1 >= a.getX() && x1 <= a.getX() + width) {
			x1 = 220;
		}
		if(y1 >= a.getY() && y1 <= a.getX() + width) {
			y1 = 145;
		}
		
	}
	
	public void update() {
		tx.setToTranslation(x1, y1);
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
		img = getImage("/imgs/SpaceShipWhite.jpg");
		
		tx = AffineTransform.getTranslateInstance(x1, y1);
		init(x1, y1);
	}
	
	public static int getX1() {
		return x1;
	}

	public static void setX1(int x1) {
		Rocket.x1 = x1;
	}

	public static int getY1() {
		return y1;
	}

	public static void setY1(int y1) {
		Rocket.y1 = y1;
	}

	public static double getSpeedX() {
		return speedX;
	}

	public static void setSpeedX(double speedX) {
		Rocket.speedX = speedX;
	}

	public static double getSpeedY() {
		return speedY;
	}

	public static void setSpeedY(double speedY) {
		Rocket.speedY = speedY;
	}

}
