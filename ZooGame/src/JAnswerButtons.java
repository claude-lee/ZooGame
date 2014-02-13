
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class JAnswerButtons extends JPanel implements ActionListener{
	

	private static final long serialVersionUID = 1L;
	private boolean isAnswerCorrect;
	private boolean isNothingSelected;
	private JRadioButton answer1;
	private JRadioButton answer2;
	private JRadioButton answer3;
	private Zoo zoo;
	private JZooGameFrame frame;
	
	public JAnswerButtons(Zoo zoo, JZooGameFrame frame){
		this.zoo = zoo;
		this.isAnswerCorrect = false;
		this.isNothingSelected = true;
		this.frame = frame;

	}
	
	void createComponentAnswers(Zoo zoo){
		
		String[] threeAnswers = zoo.getThreeAnswers();
	
		this.answer1 = new JRadioButton();
		this.answer1.setText(threeAnswers[0]);
	    answer1.setMnemonic(KeyEvent.VK_B);
	    answer1.setActionCommand(toString());
	    answer1.addActionListener(this);
	    
	    this.answer2 = new JRadioButton();
	    this.answer2.setText(threeAnswers[1]);
	    answer2.setMnemonic(KeyEvent.VK_B);
	    answer2.setActionCommand(toString());
	    answer2.addActionListener(this);
	    
	    this.answer3 = new JRadioButton();
	    this.answer3.setText(threeAnswers[2]);
	    answer3.setMnemonic(KeyEvent.VK_B);
	    answer3.setActionCommand(toString());
	    answer3.addActionListener(this);
	    
   }
	
   public boolean isNothingSelected() {
		return isNothingSelected;
	}

   public void setNothingSelected(boolean isNothingSelected) {
	this.isNothingSelected = isNothingSelected;
}

void checkIfCorrectAnswer(String text){
	   if (text.equals(zoo.getCorrectAnswer())){
		   System.out.print("Hit");
		   this.isAnswerCorrect = true;
	   }
	   else{
		   System.out.print("No"); 
		   this.isAnswerCorrect = false;
	   }
   }
	
	@Override
	public void actionPerformed(ActionEvent ae) {
	    	JRadioButton button = (JRadioButton) ae.getSource();
	    	checkIfCorrectAnswer(button.getText());  
	    	if(this.frame.getStatus() == RunZooGame.JZooEvent.E_NOTHINGSELECTED){
	    		this.frame.setStatus(RunZooGame.JZooEvent.E_INITIAL);
	    	}
	    	this.isNothingSelected = false;
	    	this.frame.getTextLabel().setVisible(false);
	    	button.setSelected(false);
	    	
	    	
		
	}
	

	JRadioButton getAnswer1(){
		return this.answer1;
	}
	
	JRadioButton getAnswer2(){
		return this.answer2;
	}
	JRadioButton getAnswer3(){
		return this.answer3;
	}

	boolean getIsAnswerCorrect(){
		return this.isAnswerCorrect;
	}

}
