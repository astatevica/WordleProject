package model;

import java.util.ArrayList;

public class PictureOfLetters {
    //variables
    private String letter;
    private String color;
    private Letters letterEnum;
    private Color colorEnum;
    private String pictureOfLetter;

    //getters
    public String getLetter() {
        return letter;
    }

    public String getColor() {
        return color;
    }

    public Letters getLetterEnum() {
        return letterEnum;
    }

    public Color getColorEnum() {
        return colorEnum;
    }

    public String getPictureOfLetter() {
        return pictureOfLetter;
    }

    //setters
    public void setLetter(String inputLetter){
        if(inputLetter != null){
            letter = inputLetter;
        }else{
            letter = "X";
        }
    }

    public void setColor(String inputColor){
        if(inputColor != null){
            color = inputColor;
        }else{
            color = "grey";
        }
    }

    //go through enum and compare to input value
    public void setLetterEnum(){
        Letters[] allLetters = Letters.values();//read all letters from enum

        for(Letters tempLetters: allLetters){
            if(tempLetters.toString().matches(letter.toUpperCase())){
                letterEnum = tempLetters;
                break;
            }else{
                letterEnum = Letters.X;
            }
        }
    }

    //go through enum and compare to input value
    public void setColorEnum(){
        Color[] allColors = Color.values();//read all colors from enum

        for(Color tempColor: allColors){
            //Setting color only when Letter is correctly entered
            if(tempColor.toString().matches(color.toLowerCase()) && letterEnum != Letters.X){
                colorEnum = tempColor;
                break;
            }else{
                colorEnum = Color.grey;
            }
        }
    }


    public void setPictureOfLetter(){
        pictureOfLetter = letterEnum + "_" + colorEnum;
    }

    //constructors
    public PictureOfLetters(){
        setLetter("A");
        setColor("green");
        setLetterEnum();
        setColorEnum();
        setPictureOfLetter();
    }

    public PictureOfLetters(String inputLetter,String inputColor){
        setLetter(inputLetter);
        setColor(inputColor);
        setLetterEnum();
        setColorEnum();
        setPictureOfLetter();
    }

    //toString function
    public String toString(){
        String result = pictureOfLetter.toString();
        return result;
    }


}
