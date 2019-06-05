package com.trilogyed;

import java.util.Random;
import java.util.Scanner;

public class HiLoLimitedTries {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner myScanner = new Scanner(System.in);


        int randomNum = random.nextInt(100) + 1;
        int userGuess;
        int userGuesses = 0;
        int attempts = 0;
        System.out.println("Try to guess a number 1-100. You have 7 attempts.");


        do {
            userGuess = Integer.parseInt(myScanner.nextLine());
            if (userGuess != randomNum && userGuess < randomNum) {
                System.out.println("Wrong! Your number is too low.");
                userGuesses += 1;
            } else if (userGuess != randomNum && userGuess > randomNum) {
                System.out.println("Wrong! Your number is too high.");
                userGuesses += 1;
            } else if (userGuess == randomNum) {
                    System.out.println("Congratulations, you guessed the right number!");
            }
        } while (userGuess != randomNum);
    }
}
