package com.eacardenase.game;

import java.util.Random;

public class GuessingGame {

    private final int randomNumber = new Random().nextInt(10);;
    private int numberOfGuesses = 0;

    public String guess(int guessNumber) {
        numberOfGuesses++;
        String tryText = numberOfGuesses == 1 ? "try" : "tries";
        String loseText = "You didn't get it - ";
        String message;

        if (guessNumber == getRandomNumber()) {
            message = String.format("You got it in %d %s!", numberOfGuesses, tryText);
        } else if (numberOfGuesses == 4) {
            message = String.format("You didn't get it and you had %d %s. Game over.", numberOfGuesses, tryText);
        } else if (numberOfGuesses > 4) {
            message = "Sorry, you are limited to only 4 tries. Game over.";
        } else {
            message = (guessNumber < randomNumber) ?
                    loseText + "you're too low" :
                    loseText + "you're too high"
            ;
        }

        return message;
    }

    public int getRandomNumber() {
        return randomNumber;
    }
}
