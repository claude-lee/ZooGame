import javax.swing.JFrame;



public class RunZooGame {
	
	public static enum JZooEvent {
	    E_INITIAL,
	    E_CORRECT,
	    E_NOTCORRECT,
	    E_NOTHINGSELECTED
	}
	
	private static void createAndShowGUI() {
		//Create and set up the window.
		JZooGameFrame frame = new JZooGameFrame();
		//Display the window.
		frame.setTitle("The ZooGame:    Choose the right answer!");
		frame.setSize(600,400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		//Schedule a job for the event-dispatching thread:
		//creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
	       @Override
		public void run() {
				createAndShowGUI();
			}
	     });

    }

}
