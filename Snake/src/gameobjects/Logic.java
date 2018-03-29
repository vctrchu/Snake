package gameobjects;

import move.Point;
import java.awt.*;

/**
 * Logic Class for Snake Game Project
 * 
 * @author Austin Levesque
 * @author Chris O'Reilly
 * @author Steven Canon-Almagro
 * @author Victor Chu
 */
public abstract class Logic {

	private Point topLeft = new Point(0, 0);
	private int shapeSize;
	private int score = 0;

	/**
	 * Default Constructor
	 * 
	 * @param gameObject
	 * @param snakeSize
	 */
	public Logic(Point gameObject, int gameObjectShapeSize) {
		topLeft = gameObject;
		shapeSize = gameObjectShapeSize;
	}

	/**
	 * Checks if the snake location is equal to food location which will return a
	 * boolean.
	 * 
	 * @param snakeLoc
	 * @param foodLoc
	 * @return boolean
	 */
	public boolean foodBoolean(String snakeLoc, String foodLoc) {
		return snakeLoc.equals(foodLoc);
	}

	/**
	 * TEXTBASE: Checks to see if the snake has collided with the food, returns this
	 * as a boolean
	 * 
	 * @return boolean
	 */
	public boolean eat(Food f) {
		return getTopLeft().getXCoord() == f.getTopLeft().getXCoord()
				&& getTopLeft().getYCoord() == f.getTopLeft().getYCoord();
	}

	/**
	 * returns a point as a string value for comparison and printing for troubleshooting
	 * @param pointToCheck
	 * @return
	 */
	public String getLoc(Point pointToCheck) {
		String loc = ("(" + pointToCheck.getXCoord() + "," + pointToCheck.getYCoord() + ")");
		return loc;
	}

	public Point getTopLeft() {
		return topLeft;
	}

	public void setShapeSize(int newSize) {
		if (newSize >= 1) {
			shapeSize = newSize;
		}
	}

	public int getShapeSize() {
		return shapeSize;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int newScore) {
		if (newScore >= 0) {
			score = newScore;
		}
	}

	/**
	 * Draw Method for GUI
	 */
	public abstract void draw(Graphics g);
}