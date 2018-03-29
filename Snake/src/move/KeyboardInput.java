package move;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

import run.GUI;

/**
 * Controller class for registerring keyboard input
 * 
 * @author Austin Levesque
 * @author Chris O'Reilly
 * @author Steven Canon-Almagro
 * @author Victor Chu
 */
public class KeyboardInput {

	public String input; 	
	public void setInput(String s){
		input = s;
	}
	
	public String getInput() {
		return input;
	}
	
	/**
	 * keyboard scanner that checks user input
	 * @return boolean
	 */
	public boolean userInput() {
		boolean valid = false;
		while (valid == false) {
			Scanner keyboard = new Scanner(System.in);
			System.out.println("movement: ");
			setInput(keyboard.nextLine());
			if (input.equals("w") || input.equals("a") ||input.equals("s") ||input.equals("d")||input.equals("q")) {
				valid = true;
			} else {
				System.out.println("Invalid input! Please use WASD to move or enter 'q' to quit");
			}
		}
		return valid;
	}
	
}
