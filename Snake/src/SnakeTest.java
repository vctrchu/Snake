

import static org.junit.Assert.*;

import move.*;
import org.junit.*;

import gameobjects.*;


public class SnakeTest {
	
	@Test
	public void test_getDir_DirectionIsTheSame() {
		Point p = new Point(5, 30);
		Snake s = new Snake(p, 20);
		s.setDir("left");
		s.setDir("up");
		assertEquals("Strings should be equal", "up",s.getDir());
	}
	
	@Test
	public void test_setDir_IncorrectInput() {
		Point p = new Point(2, 40);
		Snake s = new Snake(p, 3);
		s.setDir("down");
		s.setDir("arsenal");
		assertEquals("setting direction that isnt: up, down, left, right.", "down", s.getDir());
	}
	
	@Test
	public void test_setDir_InitialIncorrectInput() {
		Point p = new Point(2, 40);
		Snake s = new Snake(p, 3);
		s.setDir("RIPharambe");
		assertEquals("default direction for snakes should be down", "down", s.getDir());
	}
	
	@Test
	public void test_setDir_MovingInOppDirRight() {
		Point p = new Point(2, 40);
		Snake s = new Snake(p, 3);
		s.setDir("right");
		s.setDir("left");
		assertEquals("Player should not be allowed to move in the opposite direction", "right", s.getDir());
	}
	
	@Test
	public void test_setDir_MovingInOppDirLeft() {
		Point p = new Point(2, 40);
		Snake s = new Snake(p, 3);
		s.setDir("left");
		s.setDir("right");
		assertEquals("Player should not be allowed to move in the opposite direction", "left", s.getDir());
	}
	
	@Test
	public void test_setDir_MovingInOppDirUp() {
		Point p = new Point(2, 40);
		Snake s = new Snake(p, 3);
		s.setDir("left");
		s.setDir("up");
		s.setDir("down");
		assertEquals("Player should not be allowed to move in the opposite direction", "up", s.getDir());
	}
	
	@Test
	public void test_setDir_MovingInOppDirDown() {
		Point p = new Point(2, 40);
		Snake s = new Snake(p, 3);
		s.setDir("left");
		s.setDir("down");
		s.setDir("up");
		assertEquals("Player should not be allowed to move in the opposite direction", "down", s.getDir());
	}


	@Test
	public void test_moveDir_WhenDirIsDown() {
		Point p = new Point(40,40);
		Snake s = new Snake(p, 10);
		s.moveDir(1);
		assertEquals("Y-Coordinate should be set ", 41, s.getTopLeft().getYCoord());
	}
	
	@Test
	public void test_moveDir_WhenDirIsUp() {
		Point p = new Point(40,40);
		Snake s = new Snake(p, 10);
		s.setDir("left");
		s.setDir("up");
		s.moveDir(1);
		assertEquals("Y-Coordinate should be set ", 39, s.getTopLeft().getYCoord());
	}
	
	@Test
	public void test_moveDir_WhenDirIsRight() {
		Point p = new Point(40,40);
		Snake s = new Snake(p, 10);
		s.setDir("right");
		s.moveDir(1);
		assertEquals("X-Coordinate should be set ", 41, s.getTopLeft().getXCoord());
	}
	
	@Test
	public void test_moveDir_WhenDirIsLeft() {
		Point p = new Point(40,40);
		Snake s = new Snake(p, 10);
		s.setDir("left");
		s.moveDir(1);
		assertEquals("X-Coordinate should be set ", 39, s.getTopLeft().getXCoord());
	}
	
	@Test
	public void test_updateTail_UpdateTailAllListsSizeIsZeroTail() {
		Point p = new Point(20, 40);
		Snake s = new Snake(p, 5);
		s.updateTail(5, 5);
		assertEquals("Tail list length should be zero",0, s.getTail().size());
	}
	
	@Test
	public void test_updateTail_UpdateTailAllListsSizeIsZeroTailSnakes() {
		Point p = new Point(20, 40);
		Snake s = new Snake(p, 5);
		s.updateTail(5, 5);
		assertEquals("TailSnakes list length should be zero",0, s.getTailSnakes().size());
	}
	
	@Test
	public void test_updateTail_UpdateTailAllListsSizeIsZeroTailStrings() {
		Point p = new Point(20, 40);
		Snake s = new Snake(p, 5);
		s.updateTail(5, 5);
		assertEquals("TailStrings list length should be zero",0, s.getTailStrings().size());
	}
	
	@Test
	public void test_textMoveSnakeA_XCoordRight() {
		int xBound = 10, yBound = 10;
		String str = "d";
		Snake snake = new Snake(new Point(5,5),0);
		snake.textMoveSnakeA(xBound, yBound, str);
		assertEquals("XCoord should be " , 6, snake.getTopLeft().getXCoord());
	}
	
	@Test
	public void test_textMoveSnakeA_XCoordLeft() {
		int xBound = 10, yBound = 10;
		String str = "a";
		Snake snake = new Snake(new Point(5,5),0);
		snake.textMoveSnakeA(xBound, yBound, str);
		assertEquals("XCoord should be " , 4, snake.getTopLeft().getXCoord());
	}
	
	@Test
	public void test_textMoveSnakeA_YCoordUp() {
		int xBound = 10, yBound = 10;
		String str = "w";
		Snake snake = new Snake(new Point(5,5),0);
		snake.textMoveSnakeA(xBound, yBound, str);
		assertEquals("YCoord should be " , 4, snake.getTopLeft().getYCoord());
	}
	
	@Test
	public void test_textMoveSnakeA_YCoordDown() {
		int xBound = 10, yBound = 10;
		String str = "s";
		Snake snake = new Snake(new Point(5,5),0);
		snake.textMoveSnakeA(xBound, yBound, str);
		assertEquals("YCoord should be " , 6, snake.getTopLeft().getYCoord());
	}
	
	@Test
	public void test_textMoveSnakeA_XCoordLargerThanMax() {
		int xBound = 10, yBound = 10;
		String str = "d";
		Snake snake = new Snake(new Point(9,9),0);
		snake.textMoveSnakeA(xBound, yBound, str);
		assertEquals("XCoord should be " , 0, snake.getTopLeft().getXCoord());
	}
	
	@Test
	public void test_textMoveSnakeA_XCoordSmallerThanMin() {
		int xBound = 10, yBound = 10;
		String str = "a";
		Snake snake = new Snake(new Point(0,0),0);
		snake.textMoveSnakeA(xBound, yBound, str);
		assertEquals("XCoord should be " , 9, snake.getTopLeft().getXCoord());
	}
	
	@Test
	public void test_textMoveSnakeA_YCoordLargerThanMax() {
		int xBound = 10, yBound = 10;
		String str = "w";
		Snake snake = new Snake(new Point(0,0),0);
		snake.textMoveSnakeA(xBound, yBound, str);
		assertEquals("XCoord should be " , 9, snake.getTopLeft().getYCoord());
	}
	
	@Test
	public void test_textMoveSnakeA_YCoordSmallerThanMin() {
		int xBound = 10, yBound = 10;
		String str = "s";
		Snake snake = new Snake(new Point(9,9),0);
		snake.textMoveSnakeA(xBound, yBound, str);
		assertEquals("XCoord should be " , 0, snake.getTopLeft().getYCoord());
	}
	

	
}