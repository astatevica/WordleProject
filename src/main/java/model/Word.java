package model;

import java.util.ArrayList;

public class Word {
    //Mainīgie
    private String secretWord;
    private String userGuess;
    private ArrayList <PictureOfLetters> coloredLetters;

    //Getteri
    public String getSecretWord() {
        return secretWord;
    }

    public String getUserGuess() {
        return userGuess;
    }

    public ArrayList <PictureOfLetters> getColoredLetters() {
        return coloredLetters;
    }

    //Setteri
    //Word will come from DB
    public void setSecretWord(String inputSecretWord) {
        if(inputSecretWord != null){
            secretWord = inputSecretWord;
        }else{
            secretWord = "APPLE";
        }
    }

    public void setUserGuess(String inputUserGuess) {
        if(inputUserGuess != null){
            secretWord = inputUserGuess;
        }else{
            secretWord = "APPLE";
        }
    }

    public void colorLetters() {
        

        //TODO Need to optimize this...
        ArrayList<Character> grayLetters = new ArrayList<Character>();
		ArrayList<Character> orangeLetters = new ArrayList<Character>();

        ArrayList<String> lettersWithColors = new ArrayList<String>();
        for(int i = 0; i < secretWord.length(); i++) {
					
            if(userGuess.charAt(i) == secretWord.charAt(i)) {
                //Letter + Green (In secret word, with correct placement)
                lettersWithColors.set(i, userGuess.charAt(i) + "Green");

            }else{
                for(int j = 0; j < secretWord.length(); j++) {
                    //Makes a list with correct letters incorrectly placed
                    if(userGuess.charAt(i) == secretWord.charAt(j)) {
                        //Letter + Orange (In secret word, without correct placement)
                        lettersWithColors.set(i, userGuess.charAt(i) + "Orange");
                        
            
                        //Makes a list with letters in secret word, but incorrectly placed
                        if(!orangeLetters.contains(userGuess.charAt(i))){
                            orangeLetters.add(userGuess.charAt(i));
                        }
                    }
                }

                //Makes a list with letters not in the secret word
                if(!orangeLetters.contains(userGuess.charAt(i)) && !grayLetters.contains(userGuess.charAt(i))) {
                    grayLetters.add(userGuess.charAt(i));
                }


                //Letter + Gray (Not in secret word)
                if(grayLetters.contains(userGuess.charAt(i))){
                    lettersWithColors.set(i, userGuess.charAt(i) + "Gray");
                }
            }

            String letter = Character.toString(lettersWithColors.get(i).charAt(0));
            String color = lettersWithColors.get(i).substring(1);
            coloredLetters.add(new PictureOfLetters(letter, color));
            
        }

    }


    //Konsturktors
    public Word(){
        setSecretWord("APPLE");
        setUserGuess("PRIDE");
    }

    public Word(String inputWord){
        setSecretWord(inputWord);
        
    }

    //toString
    public String toString(){
        String result = "Word: ";
        return result;
    }

}
