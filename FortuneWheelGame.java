import java.util.Arrays;
import java.util.Scanner;

public class FortuneWheelGame 
{
	Scanner sn = new Scanner(System.in); 
	
	
	public void Game() 
	{
		start();
		 sn.close();
	}



	private void start() // private function that manage the start, continues and end of the game
	{
		char NewGame;
		System.out.println("    ** Wheel of Fortune game **");
		do{
			oneRound();
			System.out.println("\n would you like to start new game? y/n");
			NewGame = getLetter();
		}while (NewGame=='y');
		
	}

	private void oneRound() // need to find 1 word 
	{
		boolean playable = true;
		int trynumber = 0;
		FortuneWheelBank guWord = new FortuneWheelBank(); 
		String word = guWord.getWord();
		int len = word.length();
		int lettersLeft=len;
		char[] hiddenword;
		char[] theword;
		char[] englishLetters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		
		hiddenword = new char[len];
		theword = new char[len];
		
		for (int j=0; j<len; j++)
			{
			theword[j] = word.charAt(j);
			}
		
		
		for (int i=0; i<len; i++)
		{
			hiddenword[i] = '_';
		}
		
		
		while (playable && lettersLeft>0)
		{	
			boolean goodguess=false;
			
			int j;
			
			System.out.println("******************************************");
			System.out.print(" your word is: ");
			printWord(hiddenword);
			System.out.println("\n Unused letters: ");
			printArray(englishLetters);
			System.out.println("\n number of wrong guess:" + trynumber );
			
			char GuessedLetter = getLetter();
				
			int ind = GuessedLetter-'a';
		
			if (ind>=0 && ind<27)
			{
				englishLetters[ind]=' ';
			}
			
			for ( j=0; j<len ; j++)
			{
				
				if (GuessedLetter=='*')
				{ 
					j=len;
					
				}
				else if (GuessedLetter==(theword[j]))
				{
					goodguess=true;
					hiddenword[j]=theword[j];
					lettersLeft= lettersLeft-1;
				}
			}
			
			if (goodguess==false)
				{
				trynumber = trynumber+1;
				}
			
			if (lettersLeft==0)
			{
				playable=false;
			}
			
		}
		System.out.println("good job! the word was:");
		printWord(hiddenword);	
	}

	
	private static void printArray (char[] arr)
	{
		System.out.println(Arrays.toString(arr));
	}
	
	private static void printWord (char[] arr)
	{
		String arrStr = new String(arr);
		System.out.println(arrStr);
	}
	
	private char getLetter() 
	{
		
		 System.out.println("Please type one low case letter: ");
		 String str = sn.next();
		 char c = str.charAt(0);
		 
		 c = checkChar(c);
		
		 return c;
	}
	
	private static char checkChar(char c)
	{
		if (c<'a' || c >'z')
		{
			return '*';
		}
			return c;
	}
}
