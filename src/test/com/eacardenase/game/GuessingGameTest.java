package com.eacardenase.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuessingGameTest {

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

        for (int i = 0; i < 60; i++) {
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

        assertEquals("You got it", message);
    }

    @Test
    public void testOneWrongNegGuessSituation() {
        int randomNumber = game.getRandomNumber();

        String message = game.guess(-randomNumber);

        assertEquals("You didn't get it", message);
    }

    @Test
    public void testOneWrongPosGuessSituation() {
        int randomNumber = game.getRandomNumber();

        String message = game.guess(randomNumber + 1);

        assertEquals("You didn't get it", message);
    }
}
