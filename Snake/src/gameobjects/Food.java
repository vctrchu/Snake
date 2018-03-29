package gameobjects;
import move.*;

import java.awt.Graphics;
import java.util.Random;
import java.awt.Color;

/**
 * Food Object for Snake Game Project
 * Child of Logic Class
 * @author Austin Levesque
 * @author Chris O'Reilly
 * @author Steven Canon-Almagro
 * @author Victor Chu
 */
public class Food extends Logic {

	/**
	 * Default Constructor
	 * @param foodTopLeft
	 * @param foodSize
	 */
	public Food(Point foodTopLeft, int foodShapeSize) {
		super(foodTopLeft, foodShapeSize);
	}
	
	/**
	 * Generates a new random point
	 * 
	 * @param range
	 * @return Randomly generated Point
	 */
	public Point newLoc(int range) {
		int r1;
		int r2;
		Random rand1 = new Random();
		Point newPoint = new Point(0, 0);
		if (range == 26) {
			r1 = rand1.nextInt(26) * 30 + 8;
			r2 = rand1.nextInt(26) * 30;
			newPoint.setXCoord(r1);
			newPoint.setYCoord(r2);
		} else if (range == 10) {
			r1 = rand1.nextInt(9) + 1;
			r2 = rand1.nextInt(9) + 1;
			newPoint.setXCoord1(r1);
			newPoint.setYCoord1(r2);
		}
		return newPoint;
	}

	
	/**
	 * Draw Method for GUI
	 */
	public void draw(Graphics g){
		g.setColor(Color.GREEN);
		g.fillOval(getTopLeft().getXCoord(), getTopLeft().getYCoord(), getShapeSize() * 2,getShapeSize() * 2);
	}
}
