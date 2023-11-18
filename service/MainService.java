package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MainService {

	//TODO Think of extra level difficulties for wordle
	
	public static Scanner myScanner = new Scanner(System.in);
	private static ArrayList<String> fiveLetterWords = new ArrayList<String>();
	private static ArrayList<String> sixLetterWords = new ArrayList<String>();
	private static ArrayList<String> sevenLetterWords = new ArrayList<String>();
	
	//TODO Registration
	//TODO Log in
	//TODO Game selection
	//TODO Level selection {Done?}
	
	public static int gameStart() { //Change return type
		
		ArrayList<Integer> listOfLevels = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
		ArrayList<Character> inWordWithCorrectPlacementLetters = chooseLevel(listOfLevels);
		int level = inWordWithCorrectPlacementLetters.size() - 4;
		String secretWord = "";
		
		if (level == 1) {
			secretWord = getSecretNum(fiveLetterWords, level); 
		}
		if (level == 2) {
			secretWord = getSecretNum(sixLetterWords, level); 
		}
		if (level == 3) {
			secretWord = getSecretNum(sevenLetterWords, level); 
		}
		
		//TODO Make levels {DONE}
		
		boolean gameOver = false;
		
		int lives = 7;
	
		ArrayList<String> allGuesses = new ArrayList<String>();
		ArrayList<Character> grayLetters = new ArrayList<Character>();
		ArrayList<Character> orangeLetters = new ArrayList<Character>();
		
		while(!gameOver) {
			String userGuess = userGuessWord(level);	
			userGuess = userGuess.toUpperCase();
			allGuesses.add(userGuess.toUpperCase());
			lives -= 1;
			
			if(userGuess.equals(secretWord)) {
				gameOver = true;
				showGuesses(inWordWithCorrectPlacementLetters, allGuesses, orangeLetters, grayLetters);
				System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^");
				System.out.println("You win!");
				System.out.println("Word was: " + secretWord);
				System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^");
			}else if(lives <= 0){
				gameOver = true;
				showGuesses(inWordWithCorrectPlacementLetters, allGuesses, orangeLetters, grayLetters);
				System.out.println("You lose!");
				System.out.println("Word was: " + secretWord);
			}else{
				
				//Makes a list with correctly placed used letters
				for(int i = 0; i < secretWord.length(); i++) {
					if(userGuess.charAt(i) == secretWord.charAt(i)) {
						inWordWithCorrectPlacementLetters.set(i, userGuess.toUpperCase().charAt(i));	
					}
				}

				for(int i = 0; i < secretWord.length(); i++) {
					for(int j = 0; j < secretWord.length(); j++) {
						if(userGuess.charAt(i) == secretWord.charAt(j) && !orangeLetters.contains(userGuess.charAt(i))) {
							orangeLetters.add(userGuess.charAt(i));
						}
					}
					if(!orangeLetters.contains(userGuess.charAt(i)) && !grayLetters.contains(userGuess.charAt(i))) {
						grayLetters.add(userGuess.charAt(i));
					}
				}
				
				showGuesses(inWordWithCorrectPlacementLetters, allGuesses, orangeLetters, grayLetters);
					
			}
			
		}
		
		//TODO Return game object with result, guesses, ...
		return 1;
	}
	
	
	public static ArrayList <Character> chooseLevel(ArrayList <Integer> listOfLevels) { // <- input the chosen game ?
		int level = 0;
		ArrayList<Character> inWordWithCorrectPlacementLetters = new ArrayList<Character>(Arrays.asList('?', '?', '?', '?', '?'));
		do {
			myScanner = new Scanner(System.in);
			System.out.println("Pick a level[1, 2, 3]:");
			level = myScanner.nextInt();
		}while(!listOfLevels.contains(level));
		
		if(level == 2) {
			inWordWithCorrectPlacementLetters.add('?');
		}else if(level == 3) {
			inWordWithCorrectPlacementLetters.add('?');
			inWordWithCorrectPlacementLetters.add('?');
		}
		return inWordWithCorrectPlacementLetters;
	}
	
	
	public static String getSecretNum(ArrayList<String> listOfWords, int level) {
		Random rand = new Random();
		String secretWord = listOfWords.get(rand.nextInt(listOfWords.size()));
		return secretWord;
	}
	
	
	
	// Function for the user guesses  
	public static String userGuessWord(int level) { //input level
		
		String userGuess = "";
		boolean correct_guess = false;
		while(!correct_guess) {
			myScanner = new Scanner(System.in);
			System.out.println("What is your guess?: ");
			userGuess = myScanner.next();
			
			if(level == 1 && userGuess.toUpperCase().matches("[A-Z]{5}")) {
				correct_guess = true;
			}else if(level == 2 && userGuess.toUpperCase().matches("[A-Z]{6}")) {
				correct_guess = true;
			}else if(level == 3 && userGuess.toUpperCase().matches("[A-Z]{7}")) {
				correct_guess = true;
			}else{
				System.out.println("----------------");
				System.out.println("Incorrect input!");
				System.out.println("----------------");
			}
		}
		return userGuess;
	}
	
	
	
	public static void showGuesses(ArrayList<Character> inWordWithCorrectPlacementLetters, ArrayList<String> allGuesses,
			ArrayList<Character> orangeLetters, ArrayList<Character> grayLetters) {
		System.out.println("=================================================");
		System.out.println("Known letters: " + inWordWithCorrectPlacementLetters);
		for(int i = 0; i < allGuesses.size(); i++) {
			System.out.println(allGuesses.get(i));
		}	
		System.out.println("-------------------------------------------------");
		System.out.println("In word letters with incorrect placement: " + orangeLetters);
		System.out.println("Used letters that are not in the word: " + grayLetters);
		System.out.println("=================================================");
	}
	
	
	
	
	public static void main(String[] args) {
		fiveLetterWords.add("ARROW"); fiveLetterWords.add("HUMAN"); fiveLetterWords.add("HOUSE");
		fiveLetterWords.add("TOWER"); fiveLetterWords.add("PRINT"); fiveLetterWords.add("BLOCK");
		sixLetterWords.add("CASTLE");
		sevenLetterWords.add("ZEALOUS");
		gameStart();
		myScanner.close();
	}

}
