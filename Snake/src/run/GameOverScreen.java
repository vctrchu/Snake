package run;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import fileio.HighScoreManager;

/**
 * GameOverScreen object interface code
 * Child of JFrame
 * Gets called whenever the game is over.  Gives the player the option
 * to start a new game or return to the main menu.  Game over screen
 * displays the scores of the two players as well as who won the game.
 * @author Austin Levesque
 * @author Chris O'Reilly
 * @author Steven Canon-Almagro
 * @author Victor Chu
 */
public class GameOverScreen extends JFrame implements ActionListener {

	private static final int WINDOW_WIDTH = 750;
	// technically 780 + 8 + 8 (from left and right window borders) + 30 from the
	// top left corner of square and + 1 from spawn
	private static final int WINDOW_HEIGHT = 750;
	// 780 + 30 + 8 (from borders.) + 1 from spawn
	// to clarify, (788,780) is the bottom right most square of the grid
	String[] args = new String[] { "" };
	private JButton newGameBtn = new JButton("New Game");
	private JButton mainMenuBtn = new JButton("Main Menu");
	TextField text = new TextField(30);
	private JLabel gameover = new JLabel("test");
	static GUIMainMenu faceWindow = new GUIMainMenu();
	private JLabel deathLabel = new JLabel("death label");
	private JLabel aScoreLabel = new JLabel("a score");
	private JLabel bScoreLabel = new JLabel("b label");
	static String deathMessage;
	static int aSnakeScore;
	static int bSnakeScore;

	private Font f = new Font("Comic Sans", Font.BOLD, 30);

	private Font c = new Font("Comic Sans", Font.BOLD, 50);

	public GameOverScreen() {
		super("Battlesnakes");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		gameover.setForeground(Color.WHITE);
		deathLabel.setForeground(Color.WHITE);
		aScoreLabel.setForeground(Color.WHITE);
		bScoreLabel.setForeground(Color.WHITE);
		deathLabel.setFont(f);
		aScoreLabel.setFont(f);
		bScoreLabel.setFont(f);
		gameover.setFont(c);
		newGameBtn.setFont(f);
		deathLabel.setText(deathMessage);
		aScoreLabel.setText("<html>Player 1 Score: <html>" + aSnakeScore);
		bScoreLabel.setText("<html>Player 2 Score: <html>" + bSnakeScore);
		gameover.setText("<html>Game Over</html>");
		deathLabel.setBounds(180, 300, 900, 150);
		aScoreLabel.setBounds(240, 100, 900, 150);
		bScoreLabel.setBounds(240, 200, 900, 150);
		gameover.setBounds(230, 20, 900, 150);
		newGameBtn.setBounds(175, 500, 400, 60);
		mainMenuBtn.setFont(f);
		mainMenuBtn.setBounds(175, 600, 400, 60);
		newGameBtn.addActionListener(this);
		mainMenuBtn.addActionListener(this);
		mainMenuBtn.setFocusable(false);
		newGameBtn.setFocusable(false);
		add(deathLabel);
		add(aScoreLabel);
		add(bScoreLabel);
		add(gameover);
		add(newGameBtn);
		add(mainMenuBtn);

		// The following three windows are needed to listen to keyboard events.
		// We need the focus in our content pane in our window to ensure we are informed
		// of keyboard events
		getContentPane().setFocusable(true);
		requestFocusInWindow();
	}

	/**
	 * When the new game button is clicked, calls the main method in GUI to reset the game.
	 * Also calls resetGame() to reset the values
	 * If the main menu button is clicked, it hides the game over screen.
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("New Game")) {
			HighScoreManager.readScore();
			GUI.main(args);
			GUI.getGameBoard().resetGame();
			dispose();
		} else if (e.getActionCommand().equals("Main Menu")) {
			dispose();
		}
	}

	/**
	 * Main method for class.  Takes in a deathMessage which states how the game ended and 
	 * who won the game.  Also takes in the score of the two players as a parameter.
	 * @param args
	 * @param deathMessage
	 * @param aSnakeScore
	 * @param bSnakeScore
	 */
	public static void main(String[] args, String deathMessage, int aSnakeScore, int bSnakeScore) {
		GameOverScreen.deathMessage = deathMessage;
		GameOverScreen.aSnakeScore = aSnakeScore;
		GameOverScreen.bSnakeScore = bSnakeScore;
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GameOverScreen faceWindow = new GameOverScreen();
				faceWindow.setVisible(true);
				faceWindow.getContentPane().setBackground(new Color(200));
			}
		});
	}
}