package com.eacardenase.game;

import java.util.Random;

public class GuessingGame {

    private final int randomNumber = new Random().nextInt(10);;

    public String guess(int guessNumber) {
        return guessNumber == getRandomNumber() ? "You got it" : "You didn't get it";
    }

    public int getRandomNumber() {
        return randomNumber;
    }
}
