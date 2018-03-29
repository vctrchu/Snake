import static org.junit.Assert.*;

import move.*;
import org.junit.*;

import gameobjects.*;

public class LogicTest {
	
	@Test
	public void test_foodBoolean_FoodLocationIsSnakeLocation() {
		Food l = new Food(new Point(0, 0), 15);
		assertTrue("Strings are equal.  Method should return true", l.foodBoolean("", ""));
	}

	@Test
	public void test_foodBoolean_FoodLocationIsNotSnakeLocation() {
		Food l = new Food(new Point(40, 40), 15);
		assertFalse("Strings are not equal.  Method should return false", l.foodBoolean("it's", "different"));
	}
	
	@Test
	public void test_setScore_NegativeScore() {
		Point p1 = new Point(8, 30);
		Snake aSnake = new Snake(p1, 15);
		aSnake.setScore(-10);
		assertNotSame("Score cannot be negative.", -10, aSnake.getScore());
	}

	@Test
	public void test_setScore_ValidScore() {
		Point p1 = new Point(8, 30);
		Snake aSnake = new Snake(p1, 15);
		aSnake.setScore(10);
		assertEquals("Score entered is valid.  Score should be 10.", 10, aSnake.getScore());
	}
	
	@Test
	public void test_setShapeSize_InvalidSize() {
		Point p1 = new Point(8, 30);
		Snake aSnake = new Snake(p1, 15);
		aSnake.setShapeSize(-10);
		assertNotSame("Size cannot be negative.", -10, aSnake.getShapeSize());
	}

	@Test
	public void test_setShapeSize_ValidSize() {
		Point p1 = new Point(8, 30);
		Snake aSnake = new Snake(p1, 15);
		aSnake.setShapeSize(10);
		assertEquals("Size is valid. Size should be 10", 10, aSnake.getShapeSize());
	}
	
	@Test
	public void test_getLoc_SamePoints() {
		Point p1 = new Point(8, 30);
		Snake aSnake = new Snake(p1, 15);
		assertEquals("Points should be equal.", "(" + 8 + "," + 30 + ")", aSnake.getLoc(p1));
	}

	@Test
	public void test_getLoc_DifferentPoints() {
		Point p1 = new Point(10, 30);
		Snake aSnake = new Snake(p1, 15);
		assertNotSame("Points should be different.", "(" + 8 + "," + 30 + ")", aSnake.getLoc(p1));
	}

}
