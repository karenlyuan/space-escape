import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Start{
	private int x;
	private int y;
	private Image bkgd; 	
	private AffineTransform tx;
	public Start(int bx, int by) {		
		bkgd = getImage("/imgs/SpaceRace Start.png");
		
		tx = AffineTransform.getTranslateInstance(x, y);
		init (x, y);
	}
	
	public void changePicture(String newFileName) {
		bkgd = getImage(newFileName);
		init (0,0);
	}
	
	
	public void paint(Graphics g) {
		Graphics2D g3 = (Graphics2D) g;
		g3.drawImage(bkgd, 0, 0, null);
	}

	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1, 1);
	}
	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Start.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

}
