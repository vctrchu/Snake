package gameobjects;

import move.*;

import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Color;

/**
 * Snake Object for Snake Game Project Child of Logic Class
 * 
 * @author Austin Levesque
 * @author Chris O'Reilly
 * @author Steven Canon-Almagro
 * @author Victor Chu
 */
public class Snake extends Logic {

	private String direction = "down";
	private ArrayList<Point> tail = new ArrayList<Point>();
	private ArrayList<Snake> tailSnakes = new ArrayList<Snake>();
	private ArrayList<String> tailStrings = new ArrayList<String>();
	private boolean quitFlag = false;

	/**
	 * Default Constructor
	 * 
	 * @param snakeTopLeft
	 * @param snakeSize
	 */
	public Snake(Point snakeTopLeft, int shapeSize) {
		super(snakeTopLeft, shapeSize);
	}

	/**
	 * Moves the snake object in the direction it's facing by 'amount' units
	 * 
	 * @param amount
	 */
	public void moveDir(int amount) {
		if (direction == "down") {
			getTopLeft().moveDown(amount);
		} else if (direction == "up") {
			getTopLeft().moveUp(amount);
		} else if (direction == "left") {
			getTopLeft().moveLeft(amount);
		} else {
			getTopLeft().moveRight(amount);
		}
	}

	/**
	 * TEXTBASE: Moves the snake based on the input provided by the user.
	 * 
	 * @param void
	 */
	public void textMoveSnakeA(int boundaryX, int boundaryY, String s) {
		int moveX = getTopLeft().getXCoord();
		int moveY = getTopLeft().getYCoord();
		updateTail(moveX, moveY);
		// stores previous location data for the tail
		if (s.equals("w")) {
			moveY--;
			if (moveY < 0) {
				moveY = boundaryY - 1;
			}
			getTopLeft().setYCoord1(moveY);
		} else if (s.equals("s")) {
			moveY++;
			if (moveY > boundaryY - 1) {
				moveY = 0;
			}
			getTopLeft().setYCoord1(moveY);
		} else if (s.equals("a")) {
			moveX--;
			if (moveX < 0) {
				moveX = boundaryX - 1;
			}
			getTopLeft().setXCoord1(moveX);
		} else if (s.equals("d")) {
			moveX++;
			if (moveX > boundaryX - 1) {
				moveX = 0;
			}
			getTopLeft().setXCoord1(moveX);
		}
	}
	
	/**
	 * method for moving the text based version of the snake based on user  keypresses
	 * @param boundaryX
	 * @param boundaryY
	 * @param s
	 */
	public void textMoveSnakeB(int boundaryX, int boundaryY, String s) {
		int moveX = getTopLeft().getXCoord();
		int moveY = getTopLeft().getYCoord();
		updateTail(moveX, moveY);
		if (s.equals("i")) {
			moveY--;
			if (moveY < 0) {
				moveY = boundaryY - 1;
			}
			getTopLeft().setYCoord1(moveY);
		} else if (s.equals("k")) {
			moveY++;
			if (moveY > boundaryY - 1) {
				moveY = 0;
			}
			getTopLeft().setYCoord1(moveY);
		} else if (s.equals("j")) {
			moveX--;
			if (moveX < 0) {
				moveX = boundaryX - 1;
			}
			getTopLeft().setXCoord1(moveX);
		} else if (s.equals("l")) {
			moveX++;
			if (moveX > boundaryX - 1) {
				moveX = 0;
			}
			getTopLeft().setXCoord1(moveX);
		} else {
			quitFlag = true;
		}
	}

	/**
	 * Updates Tail lists with the previous points/coordinates of the head Deletes
	 * the oldest value in the lists based on the size of the tail i.e. the score
	 * 
	 * @param prevPtX
	 * @param prevPtY
	 */
	public void updateTail(int prevPtX, int prevPtY) {
		Point prevPt = new Point(prevPtX, prevPtY);
		tail.add(prevPt);
		tailStrings.add(getLoc(prevPt));
		Snake tempTail = new Snake(prevPt, 15);
		tailSnakes.add(tempTail);
		if ((tail.size()) > getScore()) {
			while ((tail.size()) > getScore()) {
				tail.remove(0);
				tailSnakes.remove(0);
				tailStrings.remove(0);
			}
		}
	}

	public ArrayList<Point> getTail() {
		return tail;
	}

	public ArrayList<Snake> getTailSnakes() {
		return tailSnakes;
	}

	public ArrayList<String> getTailStrings() {
		return tailStrings;
	}

	/**
	 * Changes snake direction
	 * @param newDir
	 */
	public void setDir(String newDir) {
		if (newDir == "up" || newDir == "down" || newDir == "left" || newDir == "right") {
			if (direction == "left" && newDir == "right") {
				direction = "left";
			}
			else if(direction == "right" && newDir == "left") {
				direction = "right";
			}
			else if(direction == "up" && newDir == "down") {
				direction = "up";
			}
			else if(direction == "down" && newDir == "up") {
				direction = "down";
			}
			else {
				direction = newDir;
			}
		}
	}

	public String getDir() {
		return direction;
	}
	
	public boolean getQuit() {
		return quitFlag;
	}

	/**
	 * Draw Methods for GUI
	 * Multiple draw methods for the separate colored snake heads and tails
	 */
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(getTopLeft().getXCoord(), getTopLeft().getYCoord(), getShapeSize() * 2, getShapeSize() * 2);
	}
	public void drawB(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(getTopLeft().getXCoord(), getTopLeft().getYCoord(), getShapeSize() * 2, getShapeSize() * 2);
	}
	public void drawTB(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect(getTopLeft().getXCoord(), getTopLeft().getYCoord(), getShapeSize() * 2, getShapeSize() * 2);
	}
	public void drawT(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillRect(getTopLeft().getXCoord(), getTopLeft().getYCoord(), getShapeSize() * 2, getShapeSize() * 2);
	}
}