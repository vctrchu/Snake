import static org.junit.Assert.*;

import move.*;
import org.junit.*;

import gameobjects.*;

public class FoodTest {
	
	@Test
	public void test_newLoc_PointIsDifferent() {
		Food l = new Food(new Point(40, 40), 15);
		assertNotSame("A new point should have been generated when newLoc was called.", l.newLoc(26), l.newLoc(26));
	}
}
