/**
 * A JAnswerButtons object represents the 3 answer buttons 
 * @author Claudia Eisbrenner
 * @version 1.0
 * 
 */

import javax.swing.JFrame;

/**
 * The Game contains the main method to start the game
 * @author Claudia Eisbrenner
 * @version 1.0
 * 
 */
public class Game {
	
	
	private static void createAndShowGUI() {
		//Create and set up the window.
		JZooGameFrame frame = new JZooGameFrame();
		frame.setTitle("The ZooGame:    Choose the right answer!");
		frame.setSize(600,400);
		//Display the window.
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static enum JZooStatus {
	    E_INITIAL,
	    E_CORRECT,
	    E_NOTCORRECT,
	    E_NOTHINGSELECTED
	}
	
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
	    @Override
		   public void run() {
			   createAndShowGUI();
		   }
	    });

    }

}
