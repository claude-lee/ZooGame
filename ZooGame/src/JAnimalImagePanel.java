

import java.awt.HeadlessException;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class JAnimalImagePanel extends JPanel{

 
	private static final long serialVersionUID = 1L;
	private BufferedImage animalImage;

    public JAnimalImagePanel(String fileName) {
       try {   
          InputStream inputStream = JAnimalImagePanel.class.getClassLoader().getResourceAsStream(fileName);
          animalImage = ImageIO.read(inputStream);  
       } catch (IOException e) {
    	   System.out.println("Oh no, oicture");
    	   e.printStackTrace();
       } catch (HeadlessException e) {
    	   System.out.println("Oh no, oicture");
			e.printStackTrace();
	   } 
    }
    
    
    BufferedImage getImage(){
    	return animalImage;
    }
    
    

}
