package hangmann;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class HangMann {
 
    public static void main(String[] args) {
        System.out.println("Welcome to Hangman Game");
        Scanner take = new Scanner(System.in);
        
        ArrayList<String> words=new ArrayList();//add available words to the arraylist
        words.add("lion");words.add("legend");words.add("twilight");words.add("hercules");words.add("indomitable");
        
        String word =words.get(new Random().nextInt(words.size()));//choose a random word from the list
        int chance = 7;

        //main game loop - it's gonna break when the game is over.
        while (true) {
                // Print out the board and get the player's guess.
                showBoard(word);
                System.out.println("Chance Remaining "+ chance);
                System.out.println("Guess!!");
                String guess = take.next().toLowerCase();
                char guesschar = guess.charAt(0);//since only letters are allowed, we take the first one evenif user enter >1

                /*
                this newword is gonna take and store the old word...and if the guessed character is 
                found in the old word,then it's gonna be replaced in this newword with uppercase...else 
                its gonna simply store the old word... this replace works if and only if the guessed character 
                is found in the word...all changes are gonna be made to this new word...then its gonna be
                compared to the main one...any changes made to this new word are gonna be applied to the main one
                */
                String newword = word.replace(guesschar, Character.toUpperCase(guesschar));

                // if newword equals the oldword, then this means the user guessed wrong and no change has occured to newword
                if (newword.equals(word)) {
                        System.out.println("Wrong!!");
                        chance--;
                        // Check if chances are over!
                        if (chance == 0) {
                                // End the game.
                                System.out.println("Game Over");
                                System.out.print("The word was ");
                                showBoard(word.toUpperCase());
                                break;
                        }
                }
                // At least one letter matched!
                else {
                        System.out.println("Got One!!");
                        word=newword;
                        // check win
                        if (newword.equals(word.toUpperCase())) {
                                // Stop the game.
                                System.out.println("You Got It");
                                System.out.println("The word was");
                                showBoard(word);
                                break;
                        }
                } 
        }	
} 
	// Prints out the board with necessary changes
	public static void showBoard(String passedWord) {
            
		for (int i=0; i<passedWord.length(); i++) {//iterating through each word
			
                        // If a letter is upper case, the user's already guessed it correctly.
			if (Character.isUpperCase(passedWord.charAt(i)))
                            System.out.print(passedWord.charAt(i));
                        
			// Otherwise it hasn't been guessed yet so we print an underscore.
                        else
                            System.out.print("_ ");
		}
		System.out.println();
	}
}
