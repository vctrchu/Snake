import static org.junit.Assert.*;

import move.*;
import org.junit.*;

import gameobjects.*;

public class GameBoardTest {
	@Test
	public void test_getSnakeA_GettingaSnake() {
		GameBoard g = new GameBoard();
		assertEquals("Getting aSnake without initializing should return null", null, g.getSnakeA());
	}
	@Test
	public void test_getSnakeB_GettingbSnake() {
		GameBoard g = new GameBoard();
		assertEquals("Getting bSnake without initializing should return null", null, g.getSnakeB());
	}
	@Test
	public void test_getFood_GettingFood() {
		GameBoard g = new GameBoard();
		assertEquals("Getting food without initializing should return null", null, g.getFood());
	}
	@Test
	public void test_getTextSnakeA_getTextBasedSnake() {
		GameBoard g = new GameBoard();
		assertEquals("Getting textSnakeA should have an x-coord of 1", 1,g.getTextSnakeA().getTopLeft().getXCoord());
		assertEquals("Getting textSnakeA should have an y-coord of 1", 1,g.getTextSnakeA().getTopLeft().getYCoord());

	}
	@Test
	public void test_getTextFood_getTextBasedFood() {
		GameBoard g = new GameBoard();
		assertEquals("Getting textFood should have an x-coord of 0", 0,g.getTextFood().getTopLeft().getXCoord());
		assertEquals("Getting textFood should have an y-coord of 0", 0,g.getTextFood().getTopLeft().getYCoord());

	}
	@Test
	public void test_setTextFood_SetWithValidPoint() {
		GameBoard g = new GameBoard();
		Point p = new Point(6,7);
		g.setTextFood(p, 0);
		assertEquals("Setting textFood with valid points should have an x-coord of 6", 6,g.getTextFood().getTopLeft().getXCoord());
		assertEquals("Setting textFood with valid points should have an y-coord of 7", 7,g.getTextFood().getTopLeft().getYCoord());
	}
	@Test
	public void test_setTextFood_SetWithInvalidPoint() {
		GameBoard g = new GameBoard();
		Point p = new Point(99,99);
		g.setTextFood(p, 0);
		assertEquals("Setting textFood with invalid points should have an x-coord of 0", 0,g.getTextFood().getTopLeft().getXCoord());
		assertEquals("Setting textFood with invalid points should have an y-coord of 0", 0,g.getTextFood().getTopLeft().getYCoord());
	}
	@Test
	public void test_setTextFood_SetWithValidandInvalidPoint() {
		GameBoard g = new GameBoard();
		Point p = new Point(5,9);
		Point s = new Point(294,47);
		g.setTextFood(p, 0);
		g.setTextFood(s, 999);
		assertEquals("Setting textFood with valid points should have an x-coord of 5", 5,g.getTextFood().getTopLeft().getXCoord());
		assertEquals("Setting textFood with valid points should have an y-coord of 9", 9,g.getTextFood().getTopLeft().getYCoord());
	}
	@Test
	public void test_resetGame_bSnakeLocation() {
		GameBoard g = new GameBoard();
		g.resetGame();
		assertEquals("At the start of the game aSnake's x-coord should be", 788, g.getSnakeB().getTopLeft().getXCoord());
		assertEquals("At the start of the game aSnake's x-coord should be", 30, g.getSnakeB().getTopLeft().getYCoord());
	}
	@Test
	public void test_resetGame_foodLocation() {
		GameBoard g = new GameBoard();
		g.resetGame();
		assertEquals("At the start of the game aSnake's x-coord should be", 398, g.getFood().getTopLeft().getXCoord());
		assertEquals("At the start of the game aSnake's x-coord should be", 390, g.getFood().getTopLeft().getYCoord());
	}
}
	