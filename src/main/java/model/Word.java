package model;


public class Word {
    //Mainīgie
    private String word;
    private String[] letterFromWord;

    //Getteri
    public String getWord() {
        return word;
    }

    public String[] getLetterFromWord() {
        return letterFromWord;
    }

    //Setteri
    //Word will come from DB
    public void setWord(String inputWord){
        if(inputWord != null){
            word = inputWord;
        }else{
            word = "APPLE";
        }
    }

    //No vārda šo ņem
    public void setLetter(){
        //izsaukšu setLetter funkciju
        setLettersFromWord(word);
    }

    //Konsturktors
    public Word(){
        setWord("APPLE");
        setLetter();
    }

    public Word(String inputWord){
        setWord(inputWord);
        setLetter();
    }

    //toString
    public String toString(){
        String result = "Word: " + word.toString() + " Letters: " + letterFromWord;
        return result;
    }

    //Papildus funkcijas
    public void setLettersFromWord(String inputWord){
        if(inputWord != null){
            for(int i = 0; i<word.length(); i++){
                letterFromWord[i] = "word.indexOf(i)";
            }
        }else{
            System.out.println("----wrong--input-------");
        }
    }
}
