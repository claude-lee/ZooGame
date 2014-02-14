/**
 * A JAnimalImagePanel object represents the foto of an animal in the frame
 * @author Claudia Eisbrenner
 * @version 1.0
 * 
 */

import java.awt.HeadlessException;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class JAnimalImagePanel extends JPanel{

    private static final long serialVersionUID = 1L;
	private BufferedImage animalImage;

    public JAnimalImagePanel(String pathToImageFile) {
       try {   
          InputStream imageInputStream = JAnimalImagePanel.class.getClassLoader().getResourceAsStream(pathToImageFile);
          animalImage = ImageIO.read(imageInputStream);  
       } catch (IOException e) {
    	   e.printStackTrace();
       } catch (HeadlessException e) {
           e.printStackTrace();
	   } 
    }
    
    
    BufferedImage getImage(){
    	return animalImage;
    }
    
    

}
