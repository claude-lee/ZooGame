
/**
 * A Zoo object represents the images and names of animals 
 * @author Claudia Eisbrenner
 * @version 1.0
 * 
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;


public class Zoo {
	
	private List<String> animalNameList;
	private String animalPicture;
	private HashMap<String, String> zooMap;
	private String correctAnswerText;
	
	public Zoo() {
		animalNameList = new ArrayList<String>();
		animalNameList.add("This is a dog!    ");
		animalNameList.add("This is a rabbit! ");
		animalNameList.add("This is a cow!    ");
		animalNameList.add("This is a donkey! ");
		animalNameList.add("This is a lion!   ");
		animalNameList.add("This is a zebra!  ");
		animalNameList.add("This is a horse!  ");
		animalNameList.add("This is a goat!   ");
		
		zooMap = new HashMap<String, String>();
        zooMap.put("giraffe.jpg", "This is a giraffe! ");
        zooMap.put("parakeet.jpg","This is a parakeet!");
        zooMap.put("tiger.jpg",   "This is a tiger!   ");
		
		correctAnswerText = "";
	}
	
	/**
	 * returns a string with the name of the image file
     * @return a string, the image file
     */
	String getRandomAnimalPicture(){
		Random random = new Random();
		List<String> imageFileNames = new ArrayList<String>(zooMap.keySet());
		String imageNameKey = imageFileNames.get(random.nextInt(imageFileNames.size()));
		animalPicture = imageNameKey;
		correctAnswerText = zooMap.get(animalPicture);
		return animalPicture;
	}
	
	
	/**
	 * returns an array of 3 strings
     * @return a string array of 3 answers
     */
	String[] getThreeAnswers(){
		String[] answers = new String[3];
		answers[0] = getCorrectAnswer();
		answers[1] = getIncorrectAnswer();
		answers[2] = getIncorrectAnswer();
		
		//if answers are the same, get another one
		while(answers[2] == answers[1]){
			answers[2] = getIncorrectAnswer();
		}
		shuffleAnswers(answers);
		
		return answers;
	}
	
	/**
	 * returns the correct answer
     * @return the correct answer
     */
	String getCorrectAnswer(){
		return zooMap.get(animalPicture);
	}
	
	/**
	 * returns a random incorrect answer
     * @return an answer that is not correct
     */
	String getIncorrectAnswer(){
		Random random = new Random();
		String randomAnswer = animalNameList.get(random.nextInt(animalNameList.size()));
		return randomAnswer;
	}
	
	
	/**
     * Shuffels the answers in the array
     * @param stringArray: the three answer strings
     */
	static void shuffleAnswers(String[] stringArray)
	{
	    Random random = new Random();
	    for (int i = stringArray.length - 1; i > 0; i--)
	    {
	      int index = random.nextInt(i + 1);
	      String tmp = stringArray[index];
	      stringArray[index] = stringArray[i];
	      stringArray[i] = tmp;
	    }
	}
	
	public String getCorrectAnswerText() {
		return correctAnswerText;
	}

	public void setCorrectAnswerText(String correctAnswerText) {
		this.correctAnswerText = correctAnswerText;
	}

		
	

}
