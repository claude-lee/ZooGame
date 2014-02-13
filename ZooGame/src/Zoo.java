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
		animalNameList.add("This is a dog!");
		animalNameList.add("This is a rabbit!");
		animalNameList.add("This is a cow!");
		animalNameList.add("This is a donkey!");
		animalNameList.add("This is a lion!");
		animalNameList.add("This is a zebra!");
		animalNameList.add("This is a horse!");
		animalNameList.add("This is a goat!");
		
		zooMap = new HashMap<String, String>();
		zooMap.put("giraffe.jpg", "This is a giraffe!");
		zooMap.put("parakeet.jpg", "This is a parakeet!");
		zooMap.put("tiger.jpg", "This is a tiger!");
		this.correctAnswerText = "";
	}
	
	String getRandomAnimalPicture(){
		Random random = new Random();
		List<String> imageFileNames = new ArrayList<String>(zooMap.keySet());
		String imageNameKey = imageFileNames.get(random.nextInt(imageFileNames.size()));
		this.animalPicture = imageNameKey;
		this.correctAnswerText = zooMap.get(this.animalPicture);
		return this.animalPicture;
	}
	
	public String getCorrectAnswerText() {
		return correctAnswerText;
	}

	public void setCorrectAnswerText(String correctAnswerText) {
		this.correctAnswerText = correctAnswerText;
	}

	String[] getThreeAnswers(){
		String[] answers = new String[3];
		answers[0] = getCorrectAnswer();
		answers[1] = getIncorrectAnswer();
		answers[2] = getIncorrectAnswer();
		shuffleAnswers(answers);
		
		return answers;
	}
	
	String getCorrectAnswer(){
		return this.zooMap.get(this.animalPicture);
	}
	
	String getIncorrectAnswer(){
		Random random = new Random();
		String randomKey = animalNameList.get(random.nextInt(animalNameList.size()));
		return randomKey;
	}
	
	
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
	
	
		
	

}
