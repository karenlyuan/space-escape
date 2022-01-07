import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener {
	
	int score1 = 0;
	int score2 = 0;
	
	Background bkgrd = new Background(0,0);
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		bkgrd.paint(g);
		
		
		Font c = new Font("Helvetica", Font.BOLD, 70);
		g.setFont(c);
		g.setColor(new Color(255,255,255));
		g.drawString(score1+"", 220, 500);
		g.setColor(new Color(255,255,255));
		g.drawString(score2+"", 630, 500);
		
		if(Rocket.y1 == 0) {
			score1++;
		}
		
		if(Rocket.y2 == 0) {
			score2++;
		}
		
		if(score1 == 5 || score2 == 5) {
			//set screen to the game over screen
			//over.paint(g);
			if(score1 > score2) {
				g.drawString("Player 1 Wins!", 420, 270);
			}
			if(score2 > score1) {
				g.drawString("Player 2 Wins!", 420, 270);
			}
		}
		
	}
	
	public static void main(String[] arg) {
		Frame f = new Frame();
	}
	
	public Frame() {
		JFrame f = new JFrame("Space Race");
		f.setSize(new Dimension(900, 600));
		f.setBackground(Color.black);
		f.add(this);
		f.setResizable(false);
		f.setLayout(new GridLayout(1,2));
		f.addMouseListener(this);
		f.addKeyListener(this);
		Timer t = new Timer(16, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		BufferedImage cursorImg;
		try {
			cursorImg =  ImageIO.read(new File("aiming-cursor.png"));
			Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
				    cursorImg, new Point(0, 0), "blank cursor");
			f.getContentPane().setCursor(blankCursor);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent m) {
		System.out.println(m.getKeyCode());
		
		//w = 87
		//s = 83
		//up arrow = 38
		//down arrow = 40
		
		if(m.getKeyCode() == 87) {
			Rocket.y1--;
		}
		
		if(m.getKeyCode() == 83) {
			Rocket.y1++;
		}
		
		if(m.getKeyCode() == 38) {
			Rocket.y2--;
		}
		
		if(m.getKeyCode() == 40) {
			Rocket.y2++;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}