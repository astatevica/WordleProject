package model;

import java.util.ArrayList;

public class Letter {
    //Mainīgie
    //Lai savāktu iekšā visus izveidotod burtus
    private ArrayList<String> allPicturesOfLetters = new ArrayList<String>();

    //Getteri
    public ArrayList<String> getAllPicturesOfLetters() {
        return allPicturesOfLetters;
    }


    //Setteri ==> nevajag, jo šeit ģenerējam bildes

   //Konstruktori
    public Letter(){
        createAllLetterPictures();
    }

    //toString
    public String toString(){
        String result = allPicturesOfLetters.toString();
        return result;
    }

    //Papildus funkcijas
    public void createAllLetterPictures(){
        PictureOfLetters[] allLetters = PictureOfLetters.values(); //nolasu visus burtus no enumeratora

        for(PictureOfLetters tempLetter: allLetters){
            allPicturesOfLetters.add("Letter_" + tempLetter);
        }
    }

}
