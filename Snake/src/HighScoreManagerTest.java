

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fileio.HighScoreManager;
import gameobjects.Snake;
import move.Point;
import run.GUI;

public class HighScoreManagerTest {
	
	@Test
	public void test_readScore_ReadsHighestScoreFile() {
		HighScoreManager.setFile("ReadScoreTest.txt");
		HighScoreManager.readScore();
		assertEquals("HighScore should be ", 6, HighScoreManager.getHighScore());
	}

}
