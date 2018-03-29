package gameobjects;

import fileio.HighScoreManager;
import move.Point;
import run.GUI;
import run.GameOverScreen;

/**
 * Game board for snake project
 * Manages the GUI game board and the objects used in it, including points/coordinates, shapes and the death messages
 * 
 * @author Austin Levesque
 * @author Chris O'Reilly
 * @author Steven Canon-Almagro
 * @author Victor Chu
 */
public class GameBoard {

	//Text-base variables
	public final int ARRAY_X = 10, ARRAY_Y = 10;
	private Snake textSnakeA = new Snake(new Point(1, 1), 0);
	private Food textFood = new Food(new Point(0, 0), 0);
	private boolean runningGame = true;
	
	private static final int SHAPE_SIZE = 15;
	static int color1, color2, color3;
	private Point p1;
	private Point p2;
	private Point p3;
	private Snake aSnake;
	private Snake bSnake;
	private Food aFood;
	private String deathMessage;
	String[] args = new String[] {""};
	

	/**
	 * Updates the gui snake tail
	 */
	public void guiUpdateSnake() {
		aSnake.updateTail(p1.getXCoord(), p1.getYCoord());
		bSnake.updateTail(p3.getXCoord(), p3.getYCoord());
		aSnake.moveDir(30);
		bSnake.moveDir(30);
		
		if (aSnake.getTailStrings().contains(aSnake.getLoc(p1))) {
			GUI.disposeMethod();
			HighScoreManager.readScore();
			HighScoreManager.writeScore();
			System.out.println("Game over");
			deathMessage = "<html>Player 1 Killed themself.<br>Player 2 wins.<html>";
			GameOverScreen.main(args, deathMessage, aSnake.getScore(), bSnake.getScore());
			resetGame();
		}
		if (bSnake.getTailStrings().contains(bSnake.getLoc(p3))) {
			GUI.disposeMethod();
			System.out.println("Game over");
			HighScoreManager.writeScore();
			deathMessage = "<html>Player 2 Killed themself.<br>Player 1 wins.<html>";
			GameOverScreen.main(args, deathMessage, aSnake.getScore(), bSnake.getScore());
			resetGame();
			

		}
		if (aSnake.getTailStrings().contains(bSnake.getLoc(p3))) {
			GUI.disposeMethod();
			System.out.println("Game over");
			HighScoreManager.writeScore();
			deathMessage = "<html>Player 2 crahsed into Player 1.<br>Player 1 wins.<html>";
			GameOverScreen.main(args, deathMessage, aSnake.getScore(), bSnake.getScore());
			resetGame();
			

			//player2 crashes into player1
		}
		if (bSnake.getTailStrings().contains(aSnake.getLoc(p1))) {
			GUI.disposeMethod();
			System.out.println("Game over");
			HighScoreManager.writeScore();
			deathMessage = "<html>Player 1 crashed into Player 2.<br>Player 2 wins.<html>";
			GameOverScreen.main(args, deathMessage, aSnake.getScore(), bSnake.getScore());
			resetGame();
			

			//player1 crashes into player2
		}
		if (aSnake.getLoc(aSnake.getTopLeft()).equals(aFood.getLoc(aFood.getTopLeft()))) {
			aSnake.setScore(aSnake.getScore() + 1);
			aFood = new Food(aFood.newLoc(26), 15);
		}
		if (bSnake.getLoc(bSnake.getTopLeft()).equals(aFood.getLoc(aFood.getTopLeft()))) {
			bSnake.setScore(bSnake.getScore() + 1);
			aFood = new Food(aFood.newLoc(26), 15);
		}
	}
	
	/**
	 * Resets instance vars for the game to the original values
	 */
	public void resetGame() {
		p1 = new Point(8, 30);
		p2 = new Point(398, 390);
		p3 = new Point(788, 30);
		aSnake = new Snake(p1, SHAPE_SIZE);
		bSnake = new Snake(p3, SHAPE_SIZE);
		aFood = new Food(p2, SHAPE_SIZE);
	}
	
	/**
	 * Creates the visual grid through print statements using a standard
	 * nested/double for loop 2D grid of Strings Note, these are strings and not
	 * characters because they include a space
	 * 
	 * @return boolean
	 */ 
	public boolean grid() {
		System.out.println("ScoreA: " + textSnakeA.getScore());
		String[][] arrayGrid = new String[ARRAY_X][ARRAY_Y];
		for (int row = 0; row < ARRAY_X; row++) {
			for (int column = 0; column < ARRAY_Y; column++) {
				arrayGrid[row][column] = ". ";
				arrayGrid[getTextFood().getTopLeft().getYCoord()][getTextFood().getTopLeft().getXCoord()] = "* ";
				arrayGrid[textSnakeA.getTopLeft().getYCoord()][textSnakeA.getTopLeft().getXCoord()] = "A ";
				
				for (int j = textSnakeA.getTail().size(); j > 0; j--) {
					if (arrayGrid[textSnakeA.getTail().get(j - 1).getYCoord()][textSnakeA.getTail().get(j - 1)
							.getXCoord()] == "A ") {
						// if the headA has collided with the tail
						runningGame = false;
					} else {
						arrayGrid[textSnakeA.getTail().get(j - 1).getYCoord()][textSnakeA.getTail().get(j - 1)
								.getXCoord()] = "s ";
					}
				}
				System.out.print(arrayGrid[row][column]);
			}
			System.out.println();
		}
		if (textSnakeA.getQuit() == true) {
			runningGame = false;
		}
		return runningGame;
	}

	public Snake getSnakeA() {
		return aSnake;
	}

	public Snake getSnakeB() {
		return bSnake;
	}

	public Food getFood() {
		return aFood;
	}
	
	public Snake getTextSnakeA() {
		return textSnakeA;
	}
  
  	public Food getTextFood() {
		return textFood;
	}
	
	public void setTextFood(Point p, int i) {
		if (p.getXCoord() >= 0 && p.getXCoord() <= 9 && p.getYCoord() >= 0 && p.getYCoord() <= 9)
			textFood = new Food(p,i);
	}
}