package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class TestClass {
    public static void main(String[] args) {
        System.out.println("--TEST-PLAYER_CLASS-------------------------------");
        Player player1 = new Player("bigBen425","bigBen425@gmail.com","bigBen425");
        System.out.println(player1);

        Player player2 = new Player();
        System.out.println(player2);

        Player player3 = new Player("superDuper3234", "superDuper3234@gmail.com", "sup32dup34");
        System.out.println(player3);



        System.out.println("--TEST-GAME_CLASS-------------------------------");;

        System.out.println("--TEST-GAME_CLASS-addToAllGuesses-------------------------------");
        ArrayList<String> testGuesses = new ArrayList<>();
        testGuesses.add("BOOK");
        testGuesses.add("SOUP");
        testGuesses.add("CAMP");
        testGuesses.add("CAKE");

        Game game1 = new Game(player1,4,testGuesses,true, LocalDateTime.of(2023,11,20,12,18));
        System.out.println(game1);

        Game game2 = new Game();
        System.out.println(game2);

        Game game3 = new Game(player3,6,testGuesses,false, LocalDateTime.of(2023,11,20,12,23));
        System.out.println(game3);

        System.out.println("---TEST_LETTER_CLASS------------------------------------------");
        PictureOfLetters letter1 = new PictureOfLetters("A","green");
        System.out.println(letter1);

        PictureOfLetters letter2 = new PictureOfLetters("B", "orange");
        System.out.println(letter2);

        PictureOfLetters letter3 = new PictureOfLetters("N", "yellow");
        System.out.println(letter3);

        PictureOfLetters letter4 = new PictureOfLetters("S", "GrEy");
        System.out.println(letter4);

        PictureOfLetters letter5 = new PictureOfLetters("ņ", "GREEN");
        System.out.println(letter5);








    }
}
