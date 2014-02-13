
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

//import static JZooGameFrame.*;


public class JZooGameFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JAnswerButtons answers;
	private Zoo zoo;
	private JLabel picLabel;
	private JOKButton okButton;
	private GridBagLayout gbl;
	private GridBagConstraints gbc;
	private RunZooGame.JZooEvent status;
	private JLabel textLabel;

	public void setStatus(RunZooGame.JZooEvent status) {
		this.status = status;
	}

	public JZooGameFrame() {
		this.zoo = new Zoo();
		this.status = RunZooGame.JZooEvent.E_INITIAL;
		this.answers = new JAnswerButtons(zoo, this);
		this.gbl = new GridBagLayout();
        this.getContentPane().setLayout(gbl);
        
        this.gbc = new GridBagConstraints();
		
		gbc.anchor = GridBagConstraints.BASELINE;
		
		// The picture panel
		updatePicture();
		
		
		//-------------------------------------------------
    	// The answers window
		updateAnswers();
        
   
        // ------------------------------------------------
      
        // The submit button
        this.okButton = new JOKButton(answers, this);
        okButton.createOKButton();
        this.addComponentToFrame(1, 3, 1, 1, okButton, gbc, new Insets(2,2,2,2));
        
        //-------------------
        this.textLabel = new JLabel();
        this.addComponentToFrame(0, 3, 1, 1, textLabel, gbc, new Insets(2,2,2,2));

   }
	
	public JLabel getTextLabel() {
		return textLabel;
	}

	public void setTextLabel(JLabel textLabel) {
		this.textLabel = textLabel;
	}

	public void updatePicture(){
		JAnimalImagePanel image = new JAnimalImagePanel(zoo.getRandomAnimalPicture());
		this.picLabel = new JLabel(new ImageIcon(image.getImage()));
        this.addComponentToFrame(0, 0, 1, 3, picLabel, gbc, new Insets(2,2,2,2));
	}
	
	public void updateAnswers(){
		this.answers.createComponentAnswers(zoo);
        this.addComponentToFrame(1, 0, 1, 1, answers.getAnswer1(), gbc, new Insets(55,2,2,2));
        this.addComponentToFrame(1, 1, 1, 1, answers.getAnswer2(), gbc, new Insets(55,2,2,2));
        this.addComponentToFrame(1, 2, 1, 1, answers.getAnswer3(), gbc, new Insets(55,2,2,2));
	}
	
	void newGame(){
		JAnimalImagePanel image = new JAnimalImagePanel(zoo.getRandomAnimalPicture());
		this.picLabel.setIcon(new ImageIcon(image.getImage()));
		
		String[] threeAnswers = zoo.getThreeAnswers();
		this.answers.getAnswer1().setText(threeAnswers[0]);
		this.answers.getAnswer1().setSelected(false);
		//this.answers.getAnswer1().setEnabled(false);
		this.answers.getAnswer2().setText(threeAnswers[1]);
		this.answers.getAnswer2().setSelected(false);
		//this.answers.getAnswer2().setEnabled(false);
		this.answers.getAnswer3().setText(threeAnswers[2]);
		this.answers.getAnswer3().setSelected(false);
		//this.answers.getAnswer3().setSize(5, 5);
		//this.answers.getAnswer3().setEnabled(false);
	
		this.answers.setNothingSelected(true);
		
		
		/// unselect radiobuttons
		
		
		
	}

	RunZooGame.JZooEvent getStatus(){
		return this.status;
	}
	
	GridBagLayout getGridBagLayout(){
		return this.gbl;
	}
	
	GridBagConstraints getGridBagConstraints(){
		return this.gbc;
	}
	
	void addComponentToFrame(int x, int y, int width, int height, Component comp, GridBagConstraints gbc, Insets i){
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridheight = height;
		gbc.gridwidth = width;
		getContentPane().add(comp, gbc);
		repaint();
		gbc.insets = i;
	}

	
	
	
	
	
  
		
}

