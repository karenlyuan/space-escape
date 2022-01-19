import java.awt.Color;
import java.awt.Graphics;

public class Asteroid {
	
	//instance variables should be private
	private int x, y; //position
	private int width; //size of asteroids
	private int vx;
	private Color color;
	private double area; //helps with width calculation
							//as we consume other cells
	
	
	public Asteroid(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	Asteroid myAsteroid = new Asteroid(100, 100);
	
	public Asteroid() {
		width = 10;
		x = 900;
		y = (int)(Math.random()*(450+1));
		
		color = new Color(255,255,255);
		
		vx = (int)(Math.random()*(11))+10;
	}
	
	public void Paint(Graphics g) {
		x-=vx;
		g.setColor(color);
		g.fillOval(x,y,width,width);
	}
	
	public boolean Collide(Asteroid a) {
		
		//if robot collides with an Asteroid
		
		if(a.getX() + width >= Rocket.getX1() && a.getX() - width <= Rocket.getX1()
				&& a.getY() + width >= Rocket.getY1() && a.getY() - width <= Rocket.getY1()) {
			return true;
		} else if(a.getX() + width >= Rocket.getX2() && a.getY() - width <= Rocket.getX2()
				&& a.getY() + width >= Rocket.getY1() && a.getY() - width <= Rocket.getY1()) {
			return true;
		} else {
			return false;
		}
		
	}
	
	//getter
	public int getX() {
		return x; //return this.x
	}
	
	//setter
	public void setX(int newX) {
		x = newX;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getVx() {
		return vx;
	}

	public void setVx(int vx) {
		this.vx = vx;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}

}
