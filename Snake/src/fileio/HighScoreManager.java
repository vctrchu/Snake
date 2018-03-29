package fileio;

import java.io.*;
import gameobjects.*;
import run.GUI;

/**
 * High score object that tracks high scores to be displayed 
 * @author Austin Levesque
 * @author Chris O'Reilly
 * @author Steven Canon-Almagro
 * @author Victor Chu
 */
public class HighScoreManager {
	
	static File file = new File("HighScores.txt");
	public static int highScore;

	/**
	 * Reads the high score from a text file
	 */
	public static void readScore() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();

			while (line != null) // read the score file line by line
			{
				try {
					int score = Integer.parseInt(line.trim()); // parse each line as an int
					if (score > highScore) // and keep track of the largest
					{
						highScore = score;
					}
				} catch (NumberFormatException nfe) {
				}
				line = reader.readLine();
			}
			reader.close();

		} catch (IOException ex) {
			System.err.println("ERROR reading scores from file");
		}
	}

	/**
	 * Compares the scores of each snake with the highscore and picks the highest
	 * Used code from https://stackoverflow.com/questions/26443957/save-game-scores-to-file-and-determine-the-high-score
	 */
	public static void writeScore() {
		try {
			BufferedWriter output = new BufferedWriter(new FileWriter(file, true));
			int scoreA = GUI.getGameBoard().getSnakeA().getScore();
			int scoreB = GUI.getGameBoard().getSnakeB().getScore();
			output.newLine();
			if (scoreA > scoreB && scoreA >= highScore) {
				output.append("" + scoreA);
			} else if (scoreB > scoreA && scoreB >= highScore) {
				output.append("" + scoreB);
			} else if (scoreA == scoreB && scoreA >= highScore) {
				output.append("" + scoreA);
			}
			output.close();

		} catch (IOException ex1) {
			System.out.printf("ERROR writing score to file: %s\n", ex1);
		}
	}

	public static int getHighScore() {
		return highScore;
	}
	
	public static void setFile(String s) {
		file = new File(s);
	}
	
}