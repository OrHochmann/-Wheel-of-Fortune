import java.util.concurrent.ThreadLocalRandom;

public class FortuneWheelBank
{

	//set words bank - static bank 
	private static final String[] WORDS = new String[]
	{
	"dog","panda", "koala", "wombat", "otter", "bear", "skunk", "squirrel", "hamster", "chinchilla"
	};
	
	
	public String getWord() // the public get word function
	{
		String randomWord;
		randomWord = randWord();
		return randomWord;
	}

	private String randWord() // private get random word function
	{
		int randWord = ThreadLocalRandom.current().nextInt(0, (WORDS.length)-1);
		return WORDS[randWord];
	}
	
	
}
