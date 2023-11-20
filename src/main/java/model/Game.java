package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Game {
    //Mainigie
    private Player player;
    private int guessesCount;
    private boolean winOrNot;
    private LocalDateTime date;

    //Šo priekš visu minējumu izvadīšanas priekš MainService
    private ArrayList<String> allGuesses = new ArrayList<String>();

    //Getters
    public Player getPlayer() {
        return player;
    }

    public int getGuessesCount() {
        return guessesCount;
    }

    public ArrayList<String> getAllGuesses() {
        return allGuesses;
    }

    public boolean isWinOrNot() {
        return winOrNot;
    }

    public LocalDateTime getDate() {
        return date;
    }

    //Setteri
    public void setPlayer(Player inputPlayer){
        if(inputPlayer != null){
            player = inputPlayer;
        }else{
           player = new Player();
        }
    }

    //TODO šo updato pēc katras spēles, jāsaprot funkcionalitāte
    public void setGuessesCount(int inputGuessesCount){
        if(inputGuessesCount >= 1){
            guessesCount = inputGuessesCount;
        }else{
            guessesCount = 0;
        }
    }

//    ŠO NEVAJAG
//    public void setAllGuesses(String inputAllGuesses){
//        if(inputAllGuesses != null){
//            allGuesses.add(inputAllGuesses);
//        }else{
//            allGuesses.add("NULL");
//        }
//    }

    public void setWinOrNot(boolean inputWinOrNot){
        winOrNot = inputWinOrNot;
    }

    public void setLocalDateTime(LocalDateTime inputDate){
        if(inputDate.isAfter(LocalDateTime.of(2023,10,20,12,30))){
            date = inputDate;
        }else{
            date = inputDate.of(2023,10,20,12,30);
        }
    }

    //Konstruktori
    public Game(){
        setPlayer(new Player());
        setGuessesCount(0);
        setWinOrNot(true);
        setLocalDateTime(LocalDateTime.of(2023,11,20,11,43));
    }

    public Game(Player inputPlayer, int inputGuessesCount,boolean inputWinOrNot, LocalDateTime inputDate){
        setPlayer(inputPlayer);
        setGuessesCount(inputGuessesCount);
        setWinOrNot(inputWinOrNot);
        setLocalDateTime(inputDate);
    }

    //toString
    public String toString(){
        String result = "Game result==> Player: " + player.getName() + " Guesses count: " + guessesCount + " All Guesses: " +
                allGuesses + " Round is won: " + winOrNot + " Date: " + date;
        return result;
    }

    //Papildus funkcijas
    //TODO katru reizi, kad tiks minēts vārds, tad funkcija tiks paņemta un izsaukta no šeienes līdzīgi
    // kā addBus Driver or something similar
    public void addToAllGuesses(String inputAllGuesses){
        if(inputAllGuesses != null){
            allGuesses.add(inputAllGuesses);
            //System.out.println(inputAllGuesses);
        }else{
            allGuesses.add("NULL");
            //System.out.println("NULL");
        }
    }

}
