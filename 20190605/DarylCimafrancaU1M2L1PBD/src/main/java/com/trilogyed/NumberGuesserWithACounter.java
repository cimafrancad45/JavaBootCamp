package com.trilogyed;

import java.util.Random;
import java.util.Scanner;

public class NumberGuesserWithACounter {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner myScanner = new Scanner(System.in);

        //declared variables for the game.
        int randomNum = random.nextInt(10)+1;
        int userGuess;
        int userTries = 0;

        //loop that does not end until user guesses the number correctly.
        do {

            System.out.println("\nGuess a number between 1-10;");
            userGuess = Integer.parseInt(myScanner.nextLine());
            userTries += userTries;

            if (userGuess != randomNum) {
                System.out.println("\nWrong number, try again!");
            }

        } while (userGuess != randomNum);
        //Only prints after loop conditions are met.
        System.out.println("That is correct!" +
                "\nIt took you " + userTries + " to guess my number.");
    }
}
