package com.eacardenase.game;

import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuessingGameTest {

    public static final int GAME_RANDOMNESS_RETRIES = 60;
    private GuessingGame game;

    @BeforeEach
    void setUp() {
        game = new GuessingGame();
    }

    @Test
//    @RepeatedTest(10)
    public void testRandomNumberGeneration() {
        int[] randomNumberCount = new int[10]; // int default value is 0
        int randomCount = 0;

        for (int i = 0; i < GAME_RANDOMNESS_RETRIES; i++) {
            int randomNumber = new GuessingGame().getRandomNumber();

            randomNumberCount[randomNumber] = 1;
        }

        for (int number : randomNumberCount) {
            randomCount += number;
        }

        assertEquals(randomNumberCount.length, randomCount);
    }

    @Test
    public void testSimpleWinSituation() {
        int randomNumber = game.getRandomNumber();

        String message = game.guess(randomNumber);

        assertEquals("You got it in 1 try!", message);
    }

    @Test
    public void testOneWrongNegGuessSituation() {
        int randomNumber = game.getRandomNumber();

        String message = game.guess(-randomNumber);

        assertEquals("You didn't get it - you're too low", message);
    }

    @Test
    public void testOneWrongPosGuessSituation() {
        int randomNumber = game.getRandomNumber();

        String message = game.guess(randomNumber + 1);

        assertEquals("You didn't get it - you're too high", message);
    }

    @Test
    public void testFourWrongGuesses() {
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);

        String message = game.guess(-3);

        assertEquals("You didn't get it and you had 4 tries. Game over.", message);
    }

    @Test
    public void testTenWrongGuesses() {
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);

        String message = game.guess(-3);

        assertEquals("Sorry, you are limited to only 4 tries. Game over.", message);
    }

    @Test
    public void testThreeWrongGuessesAndOneCorrect() {
        int randomNumber = game.getRandomNumber();

        game.guess(-3);
        game.guess(-3);
        game.guess(-3);

        String message = game.guess(randomNumber);

        assertEquals("You got it in 4 tries!", message);
    }

    @Test
    public void testTwoWrongGuessesAndOneCorrect() {
        int randomNumber = game.getRandomNumber();

        game.guess(-3);
        game.guess(-3);

        String message = game.guess(randomNumber);

        assertEquals("You got it in 3 tries!", message);
    }
}
