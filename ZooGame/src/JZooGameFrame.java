/**
 * A JZooGameFrame object represents the frame of the game 
 * @author Claudia Eisbrenner
 * @version 1.0
 * 
 */
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class JZooGameFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private Zoo zoo;
	private JLabel picLabel;
	private JAnswerButtons answers;
    private JOKButton okButton;
	private GridBagLayout gbl;
	private GridBagConstraints gbc;
	private Game.JZooStatus status;
	private JLabel textLabel;

	public JZooGameFrame() {
	    zoo = new Zoo();
	    status = Game.JZooStatus.E_INITIAL;
		answers = new JAnswerButtons(zoo, this);
		gbl = new GridBagLayout();
        getContentPane().setLayout(gbl);
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.BASELINE;
		
		// The picture component
        JAnimalImagePanel image = new JAnimalImagePanel(zoo.getRandomAnimalPicture());
		picLabel = new JLabel(new ImageIcon(image.getImage()));
        addComponentToFrame(0, 0, 1, 3, picLabel, gbc, new Insets(2,2,2,2));
        picLabel.setLocation(20, 20);
		
		
		//-------------------------------------------------
    	// The answers component
        this.answers.createAnswerButtons(zoo);
        this.addComponentToFrame(1, 0, 1, 1, answers.getAnswer1(), gbc, new Insets(55,2,2,2));
        this.addComponentToFrame(1, 1, 1, 1, answers.getAnswer2(), gbc, new Insets(55,2,2,2));
        this.addComponentToFrame(1, 2, 1, 1, answers.getAnswer3(), gbc, new Insets(55,2,2,2));
        
   
        // ------------------------------------------------
        // The OK button component
        this.okButton = new JOKButton(answers, this);
        this.addComponentToFrame(1, 3, 1, 1, okButton, gbc, new Insets(2,2,2,2));
        
        //-------------------
        // The text component
        this.textLabel = new JLabel();
        this.addComponentToFrame(0, 3, 1, 1, textLabel, gbc, new Insets(2,2,2,2));

   }
	
  /**
   * Generates a new foto and new answers
   *
   */
   void newGame(){
		JAnimalImagePanel image = new JAnimalImagePanel(zoo.getRandomAnimalPicture());
		this.picLabel.setIcon(new ImageIcon(image.getImage()));
		
		String[] threeAnswers = zoo.getThreeAnswers();
		this.answers.getAnswer1().setText(threeAnswers[0]);
		this.answers.getAnswer1().setSelected(false);
		
		this.answers.getAnswer2().setText(threeAnswers[1]);
		this.answers.getAnswer2().setSelected(false);
		
		this.answers.getAnswer3().setText(threeAnswers[2]);
		this.answers.getAnswer3().setSelected(false);

	
		this.answers.setNothingSelected(true);
	
	}
	
   /**
	 * adds a component to the main frame
    * 
    */
	void addComponentToFrame(int x, int y, int width, int height, Component comp, GridBagConstraints gbc, Insets i){
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridheight = height;
		gbc.gridwidth = width;
		getContentPane().add(comp, gbc);
		repaint();
		gbc.insets = i;
	}

	Game.JZooStatus getStatus(){
		return this.status;
	}
	
	GridBagLayout getGridBagLayout(){
		return this.gbl;
	}
	
	GridBagConstraints getGridBagConstraints(){
		return this.gbc;
	}
	
	public JLabel getTextLabel() {
		return textLabel;
	}

	public void setTextLabel(JLabel textLabel) {
		this.textLabel = textLabel;
	}
	
	public void setStatus(Game.JZooStatus status) {
		this.status = status;
	}
	
	
}

