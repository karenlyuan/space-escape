import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
/*add more levels and hit detection
 * clean graphics but cannot progress past level two, no hit detection +1
 * yeah cannot go past level 2
 * nice graphics
 * cool game
 * hit detection is a little weird
 * Apparently I beat the game at level 2? Also I might be invincible ? pretty cool otherwise ?
 * am i... better than everyone else?
 */
public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener {
	public static void main(String[] args) {
		Frame frame = new Frame();
	}
	
	Background background = new Background(0,0);
	
	Ship ship1 = new Ship();
	
	Start start = new Start(0, 0);
	
	int aX = 800;
	int aY = 0;
	int speedY = 5;
	int level = 1;
	int s = 0;
	int variable1 = 10;
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		
		start.paint(g);
		if(s == 10) {
		background.paint(g);
		
		ship1.paint(g);
		ship1.sX1 += ship1.sX1Code*3;
		ship1.sY1 += ship1.sY1Code*3;
		if(ship1.sX1 <= 0) {
			ship1.sX1 += 3;
		}
		if(ship1.sY1 <= 0) {
			ship1.sY1 += 3;
		}
		if(ship1.sY1 >= 525) {
			ship1.sY1 -= 3;
		}
		
		aY += speedY;
		
		if(aY == 600) {
			aY=0;
		}
		g.setColor(new Color(255,255,255));
		Font c = new Font("Courier New", Font.BOLD, 30);
		g.setFont(c);
		g.drawString("Level "+level, 20, 40);
		
		Asteroid asteroid = new Asteroid(800, aY);
		Asteroid asteroid2 = new Asteroid(700, aY);
		Asteroid asteroid3 = new Asteroid(600, aY);
		Asteroid asteroid4 = new Asteroid(500, aY);
		Asteroid asteroid5 = new Asteroid(400, aY);
		Asteroid asteroid6 = new Asteroid(300, aY);
		Asteroid asteroid7 = new Asteroid(200, aY);
		asteroid.Paint(g);
		asteroid2.Paint(g);
		asteroid3.Paint(g);
		asteroid4.Paint(g);
		asteroid5.Paint(g);
		asteroid6.Paint(g);
		asteroid7.Paint(g);
		g.setColor(new Color(255,255,255));
		
		for(int s = 0; s < 15; s++) {
		if(ship1.sX1 == 800) {
			ship1.sX1 = 0;
			level++;
		}
		
		}
			
		
		}
	}
	//change
	public Frame() {
		JFrame f = new JFrame("Space Race");
		f.setSize(new Dimension(900, 600));
		f.setBackground(Color.black);
		f.add(this);
		f.setResizable(false);
		f.setLayout(new GridLayout(1,2));
		f.addMouseListener(this);
		f.addKeyListener(this);
		Timer t = new Timer(10, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
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
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println(arg0.getKeyCode());
		if (arg0.getKeyCode() == 83) {
			s = 10;
		} 
		
		if (arg0.getKeyCode() == 87) {
			ship1.sY1Code = -1;
		} 
		if (arg0.getKeyCode() == 83) {
			ship1.sY1Code = 1;
		} 
		
		if (arg0.getKeyCode() == 65) {
			ship1.sX1Code = -1;
		} 
		if (arg0.getKeyCode() == 68) {
			ship1.sX1Code = 1;
		} 
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getKeyCode() == 87) {
			ship1.sY1Code = 0;
		} 
		if (arg0.getKeyCode() == 83) {
			ship1.sY1Code = 0;
		} 
		
		if (arg0.getKeyCode() == 65) {
			ship1.sX1Code = 0;
		} 
		if (arg0.getKeyCode() == 68) {
			ship1.sX1Code = 0;
			
		} 
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
