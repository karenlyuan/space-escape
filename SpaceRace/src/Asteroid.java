import java.awt.Color;
import java.awt.Graphics;

public class Asteroid {
	
	//instance variables should be private
	private int x, y; //position
	private int size; //size of asteroids
	private int vx, vy;
	private Color color;
	private double area; //helps with width calculation
							//as we consume other cells
	
	
	public Asteroid(int x, int y) {
		
	}
}

/*
public class Cell {

	
	//non default constructor - with parameters
	public Cell(int newX, int newY) {
		this();
		x = newX;
		y = newY;
	}
	
	//Cell myCell = new Cell(50,50);
	
	//default constructor - no parameters
	public Cell() {
		
		// (int)(Math.random()*(range+1))+min;
		width = (int)(Math.random()*(30-10+1))+10;
		x = 800/2-width/2;
		y = 600/2-width/2;
		
		//randomize color
		int red = (int)(Math.random()*256);
		int green = (int)(Math.random()*256);
		int blue = (int)(Math.random()*256);
		
		color = new Color(red, green, blue);
		
		vx = (int)(Math.random()*7)-3;
		vy = (int)(Math.random()*7)-3;
		
		//scale the velocity such that the bigger the object is
		//the smaller vx and vy are initially
		
		//assign area
		area = Math.PI*Math.pow(width/2, 2);
		
		if (vx == 0) {vx = 1;}
		
	}
	
	public void Paint(Graphics g) {
		y+=vy;
		x+=vx;
		g.setColor(color);
		g.fillOval(x,y,width,width);
	}
	
	public boolean Collide(Cell other) {
		
		int x1 = this.x+width/2;
		int y1 = this.y+width/2;
		
		int x2 = other.x+other.width/2;
		int y2 = other.y+other.width/2;
		
		int d = (int)(Math.sqrt(Math.pow(x1-x2, 2)+Math.pow(y1-y2,2)));
		int r1 = this.width/2;
		int r2 = other.width/2;
		
		//figure out which cell is bigger
		//increment its size somehow
		if(this.area > other.area) {
			//add other area to this area
			this.area += other.area; //eat other cell
			
			//calculate new width based on new area
			this.width = (int) Math.sqrt(this.area/Math.PI)*2;
			
		}
		
		return false&&(r1+r2)>d;
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

	public int getVy() {
		return vy;
	}

	public void setVy(int vy) {
		this.vy = vy;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}

}
*/
