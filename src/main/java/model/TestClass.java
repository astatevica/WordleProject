package model;

import java.time.LocalDateTime;

public class TestClass {
    public static void main(String[] args) {
        System.out.println("--TEST-PLAYER_CLASS-------------------------------");
        Player player1 = new Player("bigBen425","bigBen425@gmail.com","bigBen425");
        System.out.println(player1);

        Player player2 = new Player();
        System.out.println(player2);

        Player player3 = new Player("superDuper3234", "superDuper3234@gmail.com", "sup32dup34");
        System.out.println(player3);



        System.out.println("--TEST-GAME_CLASS-------------------------------");
        Game game1 = new Game(player1,4,true, LocalDateTime.of(2023,11,20,12,18));
        System.out.println(game1);

        Game game2 = new Game();
        System.out.println(game2);

        Game game3 = new Game(player3,6,false, LocalDateTime.of(2023,11,20,12,23));
        System.out.println(game3);

        System.out.println("--TEST-GAME_CLASS-addToAllGuesses-------------------------------");
        game1.addToAllGuesses("BOOK");
        game1.addToAllGuesses("SOUP");
        game1.addToAllGuesses("CAMP");
        game1.addToAllGuesses("CAKE");

        System.out.println(game1);

        System.out.println("---TEST_LETTER_CLASS------------------------------------------");
        //Uztaisa visas bildes "PicturesOfLetter"
        Letter letter = new Letter();
        System.out.println(letter);

        System.out.println("---TEST_WORD_CLASS------------------------------------------");
        Word word1 = new Word("ORANGE");
        System.out.println(word1);



    }
}
