package com.eacardenase.game;

import java.util.Random;

public class GuessingGame {

    private final int randomNumber = new Random().nextInt(10);;
    private int numberOfGuesses = 0;

    public String guess(int guessNumber) {
        numberOfGuesses++;

        if (guessNumber == getRandomNumber()) {
            String tryText = numberOfGuesses == 1 ? "try" : "tries";

            return String.format("You got it in %d %s!", numberOfGuesses, tryText);
        }

        if (numberOfGuesses == 4) {
            return "You didn't get it and you had four tries. Game over.";
        }

        return "You didn't get it";
    }

    public int getRandomNumber() {
        return randomNumber;
    }
}
