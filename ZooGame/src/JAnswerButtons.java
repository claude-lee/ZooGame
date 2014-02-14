/**
 * A JAnswerButtons object represents the 3 answer buttons 
 * @author Claudia Eisbrenner
 * @version 1.0
 * 
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;


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
	
	/**
	   * creates the three answer buttons
	   *
	   */
	void createAnswerButtons(Zoo zoo){
		
		String[] threeAnswers = zoo.getThreeAnswers();
	
		//button 1
		answer1 = new JRadioButton();
		answer1.setText(threeAnswers[0]);
	    answer1.setMnemonic(KeyEvent.VK_B);
	    answer1.setActionCommand(toString());
	    answer1.addActionListener(this);
	    answer1.setHorizontalAlignment(SwingConstants.LEFT);
	    answer1.setVerticalTextPosition(SwingConstants.BOTTOM);
	    
	    //button 2
	    answer2 = new JRadioButton();
	    answer2.setText(threeAnswers[1]);
	    answer2.setMnemonic(KeyEvent.VK_B);
	    answer2.setActionCommand(toString());
	    answer2.addActionListener(this);
	    answer2.setHorizontalAlignment(SwingConstants.LEFT);
	    answer2.setVerticalTextPosition(SwingConstants.BOTTOM);
	    
	    //button 3
	    answer3 = new JRadioButton();
	    answer3.setText(threeAnswers[2]);
	    answer3.setMnemonic(KeyEvent.VK_B);
	    answer3.setActionCommand(toString());
	    answer3.addActionListener(this);
	    answer3.setHorizontalAlignment(SwingConstants.LEFT);
	
	    
   }
	
   public boolean isNothingSelected() {
		return isNothingSelected;
	}

   public void setNothingSelected(boolean isNothSelected) {
	    isNothingSelected = isNothSelected;
   }

   void isAnswerCorrect(String answerButtonText){
	   if (answerButtonText.equals(zoo.getCorrectAnswer())){
		   isAnswerCorrect = true;
	   }
	   else{
		   isAnswerCorrect = false;
	   }
   }
	
	@Override
	public void actionPerformed(ActionEvent ae) {
	    	JRadioButton button = (JRadioButton) ae.getSource();
	    	isAnswerCorrect(button.getText());  
	    	if(frame.getStatus() == Game.JZooStatus.E_NOTHINGSELECTED){
	    		frame.setStatus(Game.JZooStatus.E_INITIAL);
	    	}
	    	isNothingSelected = false;
	    	frame.getTextLabel().setVisible(false);
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

	boolean isAnswerCorrect(){
		return this.isAnswerCorrect;
	}

}
