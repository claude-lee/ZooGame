import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.Timer;




public class JOKButton extends JButton implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private JAnswerButtons answers;
	private JZooGameFrame frame;
	private String buttonText;
	
	public JOKButton(JAnswerButtons answers, JZooGameFrame frame){
		this.answers = answers;
		this.frame = frame;
	}
	
	void createOKButton()
	{
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
		    	this.frame.setStatus(RunZooGame.JZooEvent.E_INITIAL);
		    	break;
		    case E_NOTCORRECT:
		    	checkIfAnswerIsCorrect();
		    	break;
		    case E_NOTHINGSELECTED:
		    	this.frame.getTextLabel().setText("Nothing is selected, please choose again.");
		    	this.frame.setStatus(RunZooGame.JZooEvent.E_INITIAL);
		    	break;
		}
		
		
	}
	
	void checkIfAnswerIsCorrect(){
		if(this.answers.isNothingSelected()){
			this.frame.getTextLabel().setText("Please choose an answer!.");
			this.frame.getTextLabel().setVisible(true);
			this.frame.setStatus(RunZooGame.JZooEvent.E_NOTHINGSELECTED);
			return;
		}
		if (this.answers.getIsAnswerCorrect()){
			System.out.println("YES, that's correct!");
			this.frame.getTextLabel().setText("Jo, ok. Press Ok, to play again.");
			this.frame.getTextLabel().setVisible(true);
			this.frame.setStatus(RunZooGame.JZooEvent.E_CORRECT);
			
		}else{
			System.out.println("No, that's not correct!");
			this.frame.getTextLabel().setVisible(false);
		    this.frame.getTextLabel().setText("NOOO, ok. Try again!");
			this.frame.getTextLabel().setVisible(true);
			this.frame.setStatus(RunZooGame.JZooEvent.E_NOTCORRECT);
		}
	}

}
