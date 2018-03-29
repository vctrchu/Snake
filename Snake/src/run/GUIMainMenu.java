package run;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import fileio.HighScoreManager;

/**
 * Main run method for the GUI. This is the java file that should be used to run the GUI.
 * Initializes the main menu that is used between games.
 *
 * @author Austin Levesque
 * @author Chris O'Reilly
 * @author Steven Canon-Almagro
 * @author Victor Chu
 */
public class GUIMainMenu extends JFrame implements ActionListener {
	private static final int WINDOW_WIDTH = 750;
	// technically 780 + 8 + 8 (from left and right window borders) + 30 from the
	// top left corner of square and + 1 from spawn
	private static final int WINDOW_HEIGHT = 750;
	// 780 + 30 + 8 (from borders.) + 1 from spawn
	// to clarify, (788,780) is the bottom right most square of the grid
	String[] args = new String[] { "" };
	private JButton newGameBtn = new JButton("New Game");
	private Font f = new Font("Comic Sans", Font.BOLD, 50);
	TextField text = new TextField(30);
	JLabel title = new JLabel("title");
	JLabel groupLabel = new JLabel("group");
	
	static GUIMainMenu faceWindow = new GUIMainMenu();

	public GUIMainMenu() {
		super("Battlesnakes");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);

		title.setForeground(Color.WHITE);
		groupLabel.setForeground(Color.WHITE);
		newGameBtn.setFont(f);
		groupLabel.setFont(f);
		groupLabel.setText("Group 14");
		title.setFont(f);
		title.setText("BATTLESNAKES");
		groupLabel.setBounds(250, 250, 600, 60);
		title.setBounds(175, 150, 600, 60);
		newGameBtn.setBounds(175, 500, 400, 60);
		newGameBtn.addActionListener(this);
		newGameBtn.setFocusable(false);
		add(groupLabel);
		add(title);
		add(newGameBtn);

		// The following three windows are needed to listen to keyboard events.
		// We need the focus in our content pane in our window to ensure we are informed
		// of keyboard events
		getContentPane().setFocusable(true);
		requestFocusInWindow();
	}

	/**
	 * Checks if the New Game button was pressed.  If pressed, then it starts a new game by calling the main method
	 * in the GUI class and by calling the resetGame method to reset the values.  It will also start to read the high score file.
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("New Game")) {
			HighScoreManager.readScore();
			GUI.main(args);
			GUI.getGameBoard().resetGame();
		}
	}

	/**
	 * Main method for the class.  Calls the run method and creates the faceWindow in which the game will be played in.
	 * @param args
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GUIMainMenu faceWindow = new GUIMainMenu();
				faceWindow.setVisible(true);
				faceWindow.getContentPane().setBackground(new Color(200));
			}
		});
	}

}