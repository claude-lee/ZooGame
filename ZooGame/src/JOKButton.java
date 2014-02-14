/**
 * A JOKButton object represents the OK button in the frame of the game 
 * @author Claudia Eisbrenner
 * @version 1.0
 * 
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class JOKButton extends JButton implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private JAnswerButtons answers;
	private JZooGameFrame frame;
	private String buttonText;
	
	public JOKButton(JAnswerButtons answers, JZooGameFrame frame){
		this.answers = answers;
		this.frame = frame;
		this.buttonText = "  OK  ";
		this.setText(this.buttonText);
		this.addActionListener(this);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch(this.frame.getStatus()){
		    case E_INITIAL:
			    checkIfAnswerIsCorrect();
			    break;
		    case E_CORRECT:
		    	this.frame.getTextLabel().setVisible(false);
                this.frame.newGame();
		    	this.frame.setStatus(Game.JZooStatus.E_INITIAL);
		    	break;
		    case E_NOTCORRECT:
		    	checkIfAnswerIsCorrect();
		    	break;
		    case E_NOTHINGSELECTED:
		    	this.frame.getTextLabel().setText("Nothing is selected, please select an answer!");
		    	this.frame.setStatus(Game.JZooStatus.E_INITIAL);
		    	break;
		}
		
		
	}
	
	/**
	 * checks if selected answer is correct
	 * adds text and updates status
     */
	void checkIfAnswerIsCorrect(){
		if(answers.isNothingSelected())
		{
			frame.getTextLabel().setText("Please select one answer!.");
			frame.getTextLabel().setVisible(true);
			frame.setStatus(Game.JZooStatus.E_NOTHINGSELECTED);
			return;
		}
		if (answers.isAnswerCorrect())
		{
			frame.getTextLabel().setText("Correct answer! Press OK to play again.");
			frame.getTextLabel().setVisible(true);
			frame.setStatus(Game.JZooStatus.E_CORRECT);
			
		}
		else
		{
			frame.getTextLabel().setVisible(false);
		    frame.getTextLabel().setText("No, that's not correct. Try again!");
			frame.getTextLabel().setVisible(true);
			frame.setStatus(Game.JZooStatus.E_NOTCORRECT);
		}
	}

}
