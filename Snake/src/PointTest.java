import static org.junit.Assert.*;

import move.*;
import org.junit.*;

import gameobjects.*;

public class PointTest {
	
	@Test
	public void test_setXCoord_ValueLargerThanMax() {
		Point p = new Point(2000, 200);
		p.setXCoord(2000);
		assertEquals("X-Coordinate should be set to minimum value", 8, p.getXCoord());
	}

	@Test
	public void test_setXCoord_ValueSmallerThanMin() {
		Point p = new Point(0, 200);
		p.setXCoord(0);
		assertEquals("X-Coordinate should be set to minimum value", 788, p.getXCoord());
	}

	@Test
	public void test_setYCoord_ValueLargerThanMax() {
		Point p = new Point(200, 2000);
		p.setYCoord(2000);
		assertEquals("Y-Coordinate should be set to minimum value", 30, p.getYCoord());
	}

	@Test
	public void test_setYCoord_ValueSmallerThanMin() {
		Point p = new Point(200, 0);
		p.setYCoord(0);
		assertEquals("Y-Coordinate should be set to minimum value", 780, p.getYCoord());
	}

	@Test
	public void test_setXCoord_ValidXValue() {
		Point p = new Point(200, 200);
		p.setXCoord(300);
		assertEquals("X-Coordinate should be changed to 300.", 300, p.getXCoord());
	}

	@Test
	public void test_setYCoord_ValidYValue() {
		Point p = new Point(200, 200);
		p.setYCoord(50);
		assertEquals("Y-Coordinate should be set to 50", 50, p.getYCoord());
	}
	
	@Test
	public void test_moveUp_SetsYCoord() {
		Point p = new Point(40, 40);
		p.moveUp(1);
		assertEquals("Y-Coordinate should be set to ", 39, p.getYCoord());
	}

	@Test
	public void test_moveDown_SetsYCoord() {
		Point p = new Point(40, 40);
		p.moveDown(1);
		assertEquals("Y-Coordinate should be set to ", 41, p.getYCoord());
	}

	@Test
	public void test_moveRight_SetsXCoord() {
		Point p = new Point(40, 40);
		p.moveRight(1);
		assertEquals("X-Coordinate should be set to ", 41, p.getXCoord());
	}

	@Test
	public void test_moveLeft_SetsXCoord() {
		Point p = new Point(40, 40);
		p.moveLeft(1);
		assertEquals("X-Coordinate should be set to ", 39, p.getXCoord());
	}
}
